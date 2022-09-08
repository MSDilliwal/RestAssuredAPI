package crudOperationUsingFramework;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import genericUtility.BaseAPIclass;
import genericUtility.EndPointLibrary;
import io.restassured.http.ContentType;

public class GetAllProject extends BaseAPIclass{

	@Test
	public void readAllProjects() {
		
		when()
		 .get(EndPointLibrary.getAllProjects)
		.then()
		 .assertThat().statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
	}

}
