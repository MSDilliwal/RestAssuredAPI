package requestChaining;

import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;


public class RequestChainingUsingPostAndGetTest {

	@Test
	public void  RequestChainingTest() {
		
		JavaLibrary jLib = new JavaLibrary();
		
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Viru");
		jobj.put("projectName", "HAMCREST"+jLib.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		//pre-requisites
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		.when()
		 .post("http://localhost:8084/addProject");
		
		//capture the project ID
		String pId = response.jsonPath().get("projectId");
		System.out.println(pId);
	    response.then().log().all();
		
		//reuse of projectId in get
	    
	    given()
	     .pathParam("projectId", pId)
	    .when()
	     .get("http://localhost:8084/projects/{projectId}")
	    .then()
	     .assertThat().statusCode(200)
	     .contentType(ContentType.JSON)
	     .log().all();
	    	
	}
}
