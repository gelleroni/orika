package orikatest.beans;

import java.util.Date;

public class BasicPersonDto { 
	  private String fullName;
	  private int currentAge;
	  private Date birthDate;
	  private String standard;
	  // getters/setters omitted
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getCurrentAge() {
		return currentAge;
	}
	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	@Override
	public String toString() {
		return "BasicPersonDto [fullName=" + fullName + ", currentAge=" + currentAge + ", birthDate=" + birthDate + "]";
	}
	  
	  
	}
