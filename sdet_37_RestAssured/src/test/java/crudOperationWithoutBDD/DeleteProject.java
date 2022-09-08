package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProject {

	@Test
	public void deleteTheProject() {
		
		//validate and delete the particular project with the help of project ID
		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.delete("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(204);
		validate.log().all();
	}
}
