package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllTheProjects {

	@Test
	public void readAllTheProjects() {
		
		//Validate and read or get all the projects using end point called projects .
		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.get("http://localhost:8084/projects");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
}
