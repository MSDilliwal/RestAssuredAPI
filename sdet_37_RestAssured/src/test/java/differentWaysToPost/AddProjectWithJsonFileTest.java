package differentWaysToPost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class AddProjectWithJsonFileTest {

	@Test
	public void addProject() {
		
		File file = new File("./src/test/resources/JsonFile.json");
		
		given()
		 .contentType(ContentType.JSON)
		 .body(file)
		.when()
		 .post("http://localhost:8084/addProject")
		.then()
		 .assertThat().contentType(ContentType.JSON)
		 .statusCode(201)
		 .log().all();
		
	}
}
