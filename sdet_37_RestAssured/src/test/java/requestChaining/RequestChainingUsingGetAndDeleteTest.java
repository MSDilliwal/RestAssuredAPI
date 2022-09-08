package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class RequestChainingUsingGetAndDeleteTest {

	@Test
	public void RequestChainingUsingGetAndDeleteTest() {
		
		Response response = given() 
		 .contentType(ContentType.JSON) 
		.when()
		 .get("http://localhost:8084/projects/TY_PROJ_807");
		
		//store the response of project ID in ref variable 
		String pID = response.jsonPath().get("projectId");
		System.out.println(pID);
		response.then().log().all();
		
	   given()
	    .pathParam("proId", pID)
	   .when()
	    .delete("http://localhost:8084/projects/{proId}")
	   .then()
	    .assertThat().statusCode(204)
	    .log().all();
		
	}
}
