package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;

public class RequestChainingUsingPostAndDeleteTest {

	@Test
	public void RequestChainingUsingPostAndDeleteTest() {
		
		JavaLibrary jLib = new JavaLibrary ();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Kalpana");
		jobj.put("projectName", "AnyFile"+jLib.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		.when()
		 .post("http://localhost:8084/addProject");
		
		//capture the projectId 
		String proId = response.jsonPath().get("projectId");
		System.out.println(proId);
		response.then().log().all();
		
		//create a delete request and pass proId as path parameter
		given()
		 .pathParam("pID", proId)
		.when()
		 .delete("http://localhost:8084/projects/{pID}")
		.then()
		 .assertThat().statusCode(204)
		 .log().all();
		 
		 
		 
		 
		
	}

}
