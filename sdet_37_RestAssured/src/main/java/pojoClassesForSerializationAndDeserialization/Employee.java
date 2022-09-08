package pojoClassesForSerializationAndDeserialization;

public class Employee {
 
	String empName ;
	String empId;
	String empEmail;
	long empPhone;
	
	public Employee (String empName,String empId, String empEmail, long empPhone) {
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
	}
	
	public Employee() {
		
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
	
}
