package pojoClassesForSerializationAndDeserialization;



public class Employee1 {
 
	String empName ;
	String empId;
	String empEmail;
	long empPhone;
    Object spouse;
	
	public Employee1 (String empName,String empId, String empEmail, long empPhone, Object spouse) {
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.spouse = spouse;
	}
	
	public Employee1() {
		
	}
	public String getEmpName()
	{
		return empName;
	}
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getEmpId()
	{
		return empId;
	}
	public void setEmpId(String empId)
	{
		this.empId = empId;
	}	
	public String getEmpEmail()
	{
		return empEmail;
	}
	public void setEmpEmail (String empEmail) 
	{
		this.empEmail = empEmail;
	}
	public long getEmpPhone()
	{
		return empPhone;
	}
	public void setEmpPhone (long empPhone)
	{
		this.empPhone = empPhone;
	}

	public Object getSpouse() {
		return spouse;
	}

	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
}

