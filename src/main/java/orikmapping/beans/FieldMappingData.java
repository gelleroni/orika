package orikmapping.beans;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FieldMappingData {
	
	@XmlElement(name="fieldA")
	private FieldData fieldA;
	
	@XmlElement(name="fieldB")
	private FieldData fieldB;
	
	
	public FieldMappingData() {
		
	}
	
	

	public FieldData getFieldA() {
		return fieldA;
	}



	public void setFieldA(FieldData fieldA) {
		this.fieldA = fieldA;
	}



	public FieldData getFieldB() {
		return fieldB;
	}



	public void setFieldB(FieldData fieldB) {
		this.fieldB = fieldB;
	}



	@Override
	public String toString() {
		return "FieldMappingData [fieldAname=" + fieldA + ", fieldBname=" + fieldB + "]";
	}
	
	
	
}
