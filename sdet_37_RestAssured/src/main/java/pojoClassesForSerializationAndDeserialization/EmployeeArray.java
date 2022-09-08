package pojoClassesForSerializationAndDeserialization;

public class EmployeeArray {

	String empName ;
	String empId;
	String []empEmail;
	int [] empPhone;
	
	public EmployeeArray (String empName, String empId,String[] empEmail, int [] empPhone )
	{
		this.empName = empName;
		this.empId = empId;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
	}
	
	public EmployeeArray ()
	{
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String[] getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String[] empEmail) {
		this.empEmail = empEmail;
	}

	public int[] getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(int[] empPhone) {
		this.empPhone = empPhone;
	}
	

}
