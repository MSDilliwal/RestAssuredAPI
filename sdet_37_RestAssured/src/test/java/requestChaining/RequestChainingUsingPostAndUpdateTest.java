package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;

import pojoClassesForSerializationAndDeserialization.PostRequest;

public class RequestChainingUsingPostAndUpdateTest {

	@Test
	public void RequestChainingUsingPostAndUpdateTest() {

		JavaLibrary jLib = new JavaLibrary ();

		//create project using pojo
		PostRequest postPojo = new PostRequest("Sunil", "Vitable"+jLib.getRandomNumber(), "created", 10);

		Response response = given()
				.contentType(ContentType.JSON)
				.body(postPojo)
				.when()
				.post("http://localhost:8084/addProject");

		//capture the projectId
		String pId = response.jsonPath().get("projectId");
		System.out.println("project Id = "+pId);
		response.then().log().all();

		
		//reuse of project Id form post request in update request
		 postPojo = new PostRequest("Anil", "Vitable"+jLib.getRandomNumber(), "created", 10);
		given()
		.pathParam("projectId", pId)
		.body(postPojo)
		.contentType(ContentType.JSON)


		.when()
		.put("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

	}
}
