package pojoClassesForSerializationAndDeserialization;

public class EmployeeSpouse {

	String spouseName ;
	int spousePhone;
	String spouseAddress;
	
	
	public EmployeeSpouse(String spouseName,int spousePhone, String spouseAddress)
	{
		this.spouseName = spouseName;
		this.spousePhone = spousePhone;
		this.spouseAddress = spouseAddress;
		
	}
	
	public EmployeeSpouse ()
	{
		
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public int getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(int spousePhone) {
		this.spousePhone = spousePhone;
	}

	public String getSpouseAddress() {
		return spouseAddress;
	}

	public void setSpouseAddress(String spouseAddress) {
		this.spouseAddress = spouseAddress;
	}
	
	
}
