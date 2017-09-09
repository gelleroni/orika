package orikmapping.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FieldData {
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="owningType")
	private String owningType;
	
	@XmlAttribute(name="getFunc")
	private String getFunctionName;
	
	@XmlAttribute(name="setFunc")
	private String setFunctionName;
	
	@XmlAttribute(name="setParamType")
	private String setParamType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGetFunctionName() {
		return getFunctionName;
	}

	public void setGetFunctionName(String getFunctionName) {
		this.getFunctionName = getFunctionName;
	}

	public String getSetFunctionName() {
		return setFunctionName;
	}

	public void setSetFunctionName(String setFunctionName) {
		this.setFunctionName = setFunctionName;
	}

	public String getSetParamType() {
		return setParamType;
	}

	public void setSetParamType(String setParamType) {
		this.setParamType = setParamType;
	}
	
	

	public String getOwningType() {
		return owningType;
	}

	public void setOwningType(String owningType) {
		this.owningType = owningType;
	}

	@Override
	public String toString() {
		return "FieldData [name=" + name + ", owningType=" + owningType + ", getFunctionName=" + getFunctionName
				+ ", setFunctionName=" + setFunctionName + ", setParamType=" + setParamType + "]";
	}

	
	
	
	
}
