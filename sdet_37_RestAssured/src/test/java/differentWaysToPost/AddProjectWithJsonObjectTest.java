package differentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithJsonObjectTest {

	@Test
	public void createProject() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kalpanaa");
		obj.put("projectName", "TY0001");
		obj.put("statusCode", "created");
		obj.put("teamSize", 2);
				
		
		given()
		 .body(obj)
		 .contentType(ContentType.JSON)
		.when()
		 .post("http://localhost:8084/addProject")
		.then()
		 .assertThat().contentType(ContentType.JSON)
		 .statusCode(201)
		 .log().all();
	}
}
