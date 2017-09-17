package orikatest.beanDto;

import java.util.ArrayList;
import java.util.List;

public class WorkPlaceDto {
	private String placeName;
	
	List<Worker> workers = new ArrayList<Worker>();

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
	
	
	
}
