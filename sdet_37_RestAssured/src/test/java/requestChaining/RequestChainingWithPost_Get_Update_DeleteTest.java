package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingWithPost_Get_Update_DeleteTest {

	@Test
	public void addProject() {
		
		//Create a json object 
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "SK");
		jobj.put("projectName", "Development");
		jobj.put("status", "on going");
		jobj.put("teamSize", 1);
		
		//post the request using post method and get the response and store it inside the variable
		Response response = given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		.when()
		 .post("http://localhost:8084/addProject");
		
		//find the path of projectId inside the json path
		String pId = response.jsonPath().get("projectId");
		System.out.println("Projecct ID ="+pId);
		response.then().log().all();
		
		//get Project 
		given()
		 .pathParam("proId", pId)
		 .when()
	 	 .get("http://localhost:8084/projects/{pId}")
		 .then()
		 .assertThat().statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
		
		//update project
		jobj.put("createdBy", "MS");
		jobj.put("projectName", "Testing");
		jobj.put("status", "on going");
		jobj.put("teamSize", 1);
		
		given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		 .when()
		 .put("http://localhost:8084/projects/{pId}")
		 .then()
		 .assertThat().contentType(ContentType.JSON)
		 .statusCode(200)
		 .log().all();
		
		//delete project
		given()
		 .pathParam("projoId", pId)
		 .when()
		 .delete("http://localhost:8084/projects/{pId}")
		 .then()
		 .assertThat().statusCode(204)
		 .log().all();
	}
}
