package orikatest.beans;

public class WorkPlace {
	private String depName;
	
	private BasicPerson workerArr[] = new BasicPerson[5];

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public BasicPerson[] getWorkerArr() {
		return workerArr;
	}

	public void setWorkerArr(BasicPerson[] workerArr) {
		this.workerArr = workerArr;
	}
	
	
}
