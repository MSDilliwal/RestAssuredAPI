package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassesForSerializationAndDeserialization.PojoClassForDataProvider;

import static io.restassured.RestAssured.*;

public class AddProjectWithDataProvider {

	@Test(dataProvider = "getData")
	public void addProjectUsingDataProvider (String createdBy,String projectName, String status, int teamSize) {

		PojoClassForDataProvider addProjct = new PojoClassForDataProvider(createdBy,projectName,status,teamSize);

		given()
		.contentType(ContentType.JSON)
		.body(addProjct)
		.when()
		.post("http://localhost:8084/addProject")
		.then() 
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}

	@DataProvider(name = "getData")
	public Object[][] ObjArr(){
		Object[][] data = new Object[4][4];

		data[0][0] ="Prakash";
		data[0][1] ="Maogos";
		data[0][2] ="created";
		data[0][3] = 10;

		data[1][0] ="Kalpana";
		data[1][1] ="Hamcrest";
		data[1][2] ="completed";
		data[1][3] =11;

		data[2][0] = "Sachin";
		data[2][1] = "Impetus";
		data[2][2] = "on going";
		data[2][3] =12;

		data[3][0] = "Sanjay";
		data[3][1] = "Lamda";
		data[3][2] = "created";
		data[3][3] =13;

		return data; 
	}
}
