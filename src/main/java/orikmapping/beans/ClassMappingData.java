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
	
	@XmlElement(name="fieldMapping")
	private List<FieldMappingData> fieldMappingDataList ;
	
	public ClassMappingData() {
		fieldMappingDataList = new ArrayList<FieldMappingData>(); 
	}
	
	public String getTypeAclassName() {
		return typeAclassName;
	}
	
	
	//@XmlAttribute(name="classA")
	public void setTypeAclassName(String typeAclassName) {
		this.typeAclassName = typeAclassName;
	}
	public String getTypeBclassName() {
		return typeBclassName;
	}
	//@XmlAttribute(name="classB")
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("ClassMappingData [typeAclassName=" + typeAclassName + ", typeBclassName=" + typeBclassName
				+ ", fieldMappingDataList=");
		for(FieldMappingData data : this.fieldMappingDataList) {
			builder.append(data).append("\n");
		}
		return builder.toString();
	}

	
	
}
