package differentWaysToPost;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class AddProjectWithHashMapTest {

	@Test
	public void addProject() {
		
		HashMap hasMap = new HashMap();
		hasMap.put("createdBy", "Joe");
		hasMap.put("projectName", "Mobilo");
		hasMap.put("statusCode", "created");
		hasMap.put("teamSize", 10);
		
		given()
	     .contentType(ContentType.JSON)
	     .body(hasMap)
	    .when()
	     .post("http://localhost:8084/addProject")
	    .then()
	     .assertThat().contentType(ContentType.JSON)
	     .statusCode(201)
	     .log().all();
	}
}
