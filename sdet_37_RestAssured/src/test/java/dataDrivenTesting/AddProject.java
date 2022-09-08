package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassesForSerializationAndDeserialization.PojoClassForDataProvider;

import static io.restassured.RestAssured.*;

public class AddProject {
	
	@Test(dataProvider = "getData") 
	public void addProject(String createdBy, String projectName, String status, int teamSize) {
		
		PojoClassForDataProvider pojo = new PojoClassForDataProvider(createdBy, projectName, status, teamSize);
	
		given()
		 .contentType(ContentType.JSON)
		 .body(pojo)
	     .when()
	     .post("http://localhost:8084/addProject")
	     .then()
	     .assertThat().contentType(ContentType.JSON)
	     .statusCode(201)
	     .log().all();
	}
	

	@DataProvider (name = "getData")
	public Object[][] objArray() {
		Object[][] data = new Object[4][4];
		
		data[0][1] = "A";
		data[0][2] = "Z";
		data[0][3] = "Created";
		data[0][4] = 10;
		
		data[1][1] = "B";
		data[1][2] = "Y";
		data[1][3] = "Created";
		data[1][4] = 10;
		
		data[2][1] = "C";
		data[2][2] = "X";
		data[2][3] = "Created";
		data[2][4] = 10;
		
		data[3][1] = "D";
		data[3][2] = "V";
		data[3][3] = "Created";
		data[3][4] = 10;
		
		return data;
	}
}




























