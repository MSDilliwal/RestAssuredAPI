package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProject {

	@Test
	public void readSingleProject() {
		
		//Validate and read or get a project using particular project ID
		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.get("http://localhost:8084/projects/TY0657");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
	
}
