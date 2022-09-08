package crudOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProject {

	@Test
	public void addProject() {

		JSONObject jobj = new JSONObject ();
		jobj.put("createdBy", "Ganesh");
		jobj.put("projectName", "Life");
		jobj.put("statusCode", "created");
		jobj.put("teamSize", 3);


		given()
		 .contentType(ContentType.JSON)
		 .body(jobj.toJSONString())
		.when()
		 .post("http://localhost:8084/addProject")
		.then() 
		 .log().all();

	}
}
