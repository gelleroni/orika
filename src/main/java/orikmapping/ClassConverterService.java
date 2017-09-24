package orikmapping;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.tomcat.util.codec.binary.StringUtils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;
import ma.glasnost.orika.impl.util.StringUtil;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Property;
import orikatest.beans.BasicPerson;
import orikmapping.beans.ClassMappingData;
import orikmapping.beans.FieldData;
import orikmapping.beans.FieldMappingData;
import orikmapping.beans.MappingConfig;

public class ClassConverterService {
	private static ClassConverterService instance = null;
	private MappingConfig config;
	private MapperFactory mapperFactory;
	
	
	
	public static ClassConverterService instance() throws JAXBException {
		if(instance == null) {
			instance = new ClassConverterService();
		}
		return instance;
	}
	
	public MapperFacade getMapperFacade() {
		return this.mapperFactory.getMapperFacade();
	}
	
	private ClassConverterService() throws JAXBException {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		loadingMappingConfig("C:\\roni\\workspaces\\springboot\\orikatest\\src\\main\\resources\\mapping1.xml");
	}


	private void loadingMappingConfig(String fileName) throws JAXBException {
		// TODO Auto-generated method stub
		File file = new File(fileName);
		JAXBContext jaxbContext  = JAXBContext.newInstance(MappingConfig.class);
		

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		config = (MappingConfig) jaxbUnmarshaller.unmarshal(file);
		System.out.println(config);
		 
		config.getMappingData().forEach((x) -> setClassMapping(x));
		
	}

	@SuppressWarnings("unchecked")
	private void setClassMapping(ClassMappingData mappingData) {
		Class clazzA = null, clazzB=null;
		
		try {
			clazzA = Class.forName(mappingData.getTypeAclassName());
			clazzB = Class.forName(mappingData.getTypeBclassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-genberated catch block
			e.printStackTrace();
		}
			
		ClassMapBuilder builder = this.mapperFactory.classMap(clazzA, clazzB);
			
		mappingData.getFieldMappingDataList().forEach((x)->setFieldMapping(builder, x)) ;
	
		if(mappingData.isByDefault()) {
			builder.byDefault();
		}
		
	}

	private void  setFieldMapping(ClassMapBuilder builder, FieldMappingData mappingData) {
		
		
		Object propertyA = null, propertyB = null;
		try {
			propertyA = getPropertyCofig(mappingData.getFieldA(), builder.getAType().getClass());
			 propertyB = getPropertyCofig(mappingData.getFieldB(), builder.getAType().getClass());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		if(propertyA instanceof String && propertyB instanceof String) {
			builder.field((String)propertyA, (String)propertyB);
			
		}else if(propertyA instanceof ma.glasnost.orika.metadata.Property.Builder &&  
				propertyB instanceof ma.glasnost.orika.metadata.Property.Builder) {
			builder.field((ma.glasnost.orika.metadata.Property.Builder)propertyA, (ma.glasnost.orika.metadata.Property.Builder)propertyB);
		}else if(propertyA instanceof String && propertyB instanceof ma.glasnost.orika.metadata.Property.Builder ) {
			builder.field((String)propertyA, (ma.glasnost.orika.metadata.Property.Builder)propertyB);
		}else if(propertyA instanceof ma.glasnost.orika.metadata.Property.Builder  && propertyB instanceof String ) {
			builder.field((ma.glasnost.orika.metadata.Property.Builder)propertyA, (String)propertyB);
		}
	
		
		builder.register();
		
		
	}
	
	
	private Object getPropertyCofig(FieldData fieldData, Class owningClass) throws ClassNotFoundException {
	
		
		if(fieldData.getGetFunctionName() != null) {
			
			if(fieldData.getOwningType() != null) {
				owningClass =   Class.forName(fieldData.getOwningType());
			}
			Class setClassType= Class.forName(fieldData.getSetParamType());
			
			ma.glasnost.orika.metadata.Property.Builder builder = Property.Builder.propertyFor(owningClass, fieldData.getName()).
					type(setClassType).getter(fieldData.getGetFunctionName() +  "()").setter(fieldData.getSetFunctionName() +"(%s)");
			
			return builder;
		}
		
		return fieldData.getName();
		
	}
	
	
}
