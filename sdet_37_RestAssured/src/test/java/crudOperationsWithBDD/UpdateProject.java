package crudOperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
@Test
public void updateProject () {
	
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Sharma");
	jobj.put("projectName", "Edge");
	jobj.put("statusCode", "Updated");
	jobj.put("teamSize", 20);
	
	given()
	 .contentType(ContentType.JSON)
	 .body(jobj)
	.when()
	 .put("http://localhost:8084/projects/TY_PROJ_807")
	.then()
	 .assertThat().statusCode(200)
	 .assertThat().contentType(ContentType.JSON)
	 .log().all();
	 
	 
	 
	
	
}
}
