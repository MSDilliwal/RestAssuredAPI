package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateTheProject() {

		//Create a json body for which you want to do updation
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Virat");
		jobj.put("projectName", "Amazon");
		jobj.put("status", "OK");
		jobj.put("teamSize", 10);	

		//Request a object body using RequestSpecification
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);

		//actions validations
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_001");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
}
