package orikmapping.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="classMapping")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassMappingData {
	
	@XmlAttribute(name="classA")
	private String typeAclassName;
	@XmlAttribute(name="classB")
	private String typeBclassName;
	
	@XmlAttribute(name="byDefault")
	private boolean byDefault;
	
	@XmlElement(name="fieldMapping")
	private List<FieldMappingData> fieldMappingDataList ;
	
	public ClassMappingData() {
		fieldMappingDataList = new ArrayList<FieldMappingData>(); 
	}
	
	public String getTypeAclassName() {
		return typeAclassName;
	}
	
	
	
	public void setTypeAclassName(String typeAclassName) {
		this.typeAclassName = typeAclassName;
	}
	public String getTypeBclassName() {
		return typeBclassName;
	}
	
	public void setTypeBclassName(String typeBclassName) {
		this.typeBclassName = typeBclassName;
	}
	
	
	public List<FieldMappingData> getFieldMappingDataList() {
		return fieldMappingDataList;
	}
	
	
	//@XmlElement(name="fieldMapping")
	public void setFieldMappingDataList(List<FieldMappingData> fieldMappingDataList) {
		this.fieldMappingDataList = fieldMappingDataList;
	}
	
	

	public boolean isByDefault() {
		return byDefault;
	}

	public void setByDefault(boolean byDefault) {
		this.byDefault = byDefault;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("ClassMappingData [typeAclassName=" + typeAclassName + ", typeBclassName=" + typeBclassName
				+ ", byDefault=" + byDefault +", fieldMappingDataList=");
		for(FieldMappingData data : this.fieldMappingDataList) {
			builder.append(data).append("\n");
		}
		return builder.toString();
	}

	
	
}
