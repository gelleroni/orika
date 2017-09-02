package orikmapping.beans;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FieldMappingData {
	
	@XmlAttribute(name="fieldA")
	private String fieldAname;
	@XmlAttribute(name="fieldB")
	private String fieldBname;
	
	public FieldMappingData() {
		
	}
	
	public String getFieldAname() {
		return fieldAname;
	}
	
	//
	public void setFieldAname(String fieldAname) {
		this.fieldAname = fieldAname;
	}
	public String getFieldBname() {
		return fieldBname;
	}
	//
	public void setFieldBname(String fieldBname) {
		this.fieldBname = fieldBname;
	}

	@Override
	public String toString() {
		return "FieldMappingData [fieldAname=" + fieldAname + ", fieldBname=" + fieldBname + "]";
	}
	
	
	
}
