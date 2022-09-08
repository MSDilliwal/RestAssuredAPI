package crudOperationForReqresAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest {

	@Test
	public void createProject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Rahul");
		jobj.put("job", "TL");
	
		given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		.when()
		 .post("https://reqres.in/api/users")
	    .then()
	     .assertThat().contentType(ContentType.JSON)
	     .statusCode(201)
	     .log().all();
		
		
		
	}
}
