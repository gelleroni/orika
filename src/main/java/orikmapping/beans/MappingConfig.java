package orikmapping.beans;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;



@XmlRootElement(name="mappings")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingConfig {
	
	@XmlElement(name="classMapping")
	private List<ClassMappingData> mappingData;

	public MappingConfig() {
		
		 mappingData = new ArrayList<ClassMappingData>();
	}

	public List<ClassMappingData> getMappingData() {
		return mappingData;
	}
	
	
	
	public void setMappingData(List<ClassMappingData> mappingData) {
		this.mappingData = mappingData;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		for(ClassMappingData mapping : this.mappingData) {
			builder.append("[mappingData=").append(mapping).append("]\n");
		}
		return builder.toString();
	}
	
	
	
}
