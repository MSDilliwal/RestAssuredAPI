package differentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassesForSerializationAndDeserialization.PostRequest;

import static io.restassured.RestAssured.*;

public class AddProjectWithPojoClassTest {
    @Test
	public void addProject() {
		
    	PostRequest postObject = new PostRequest("Anvi","SmartInstant", "created", 5);
    	
    	given()
    	 .body(postObject)
    	 .contentType(ContentType.JSON)
    	.when()
    	 .post("http://localhost:8084/addProject")
    	.then()
    	 .assertThat().statusCode(201)
    	 .contentType(ContentType.JSON)
    	 .log().all();
	}
}
