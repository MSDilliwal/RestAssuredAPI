package pojoCLasses;

public class ProjectLibrary {

	//declare the variables globally 
	String createdBy;
	String porjectName;
	String status;
	int teamSize;
	
	//create a constructor
	public ProjectLibrary(String createdBy, String porjectName, String status, int teamSize) {
		super();
		this.createdBy = createdBy;
		this.porjectName = porjectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	//provide getters and setters metods
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPorjectName() {
		return porjectName;
	}

	public void setPorjectName(String porjectName) {
		this.porjectName = porjectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	

}
