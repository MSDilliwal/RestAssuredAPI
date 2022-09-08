package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {

	@Test
	public void createProject() {
		
		//json body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Sam");
		jobj.put("projectName", "Optim");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);	
		
		//request
		RequestSpecification reqSpec = RestAssured.given();
	    reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		
		//actions validations
		Response response = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();	
	}
}
