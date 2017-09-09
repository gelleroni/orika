package orikatest.beans;

import java.util.Date;

public class BasicPerson {
	  private String name;
	  private int age;
	  private Date birthDate;
	 
	  private String UNSTANDARD;

	  
	  // getters/setters omitted
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getUNSTANDARD() {
		return UNSTANDARD;
	}
	public void setUNSTANDARD(String uNSTANDARD) {
		UNSTANDARD = uNSTANDARD;
	}
	  
	  
	  
}

