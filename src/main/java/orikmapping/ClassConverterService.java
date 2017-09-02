package orikmapping;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import orikmapping.beans.ClassMappingData;
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
		
		loadingMappingConfig("C:\\roni\\workspaces\\springboot\\orikatest\\src\\main\\resources\\mapping.xml");
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
		Class clazzA, clazzB;
		
		try {
			clazzA = Class.forName(mappingData.getTypeAclassName());
			clazzB = Class.forName(mappingData.getTypeBclassName());
			ClassMapBuilder builder = this.mapperFactory.classMap(clazzA, clazzB);
			for(FieldMappingData data : mappingData.getFieldMappingDataList()) {
				builder.field(data.getFieldAname(), data.getFieldBname());
			}
			builder.byDefault().register();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
