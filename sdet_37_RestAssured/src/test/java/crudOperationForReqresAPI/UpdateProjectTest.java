package crudOperationForReqresAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {

	@Test
	public void UpdatingProject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "MS");
		jobj.put("job", "TeamLead");
		
		given()
		 .contentType(ContentType.JSON)
		 .body(jobj)
		.when()
		 .put("https://reqres.in/api/users/2")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.and().log().all();
	
	}
}
