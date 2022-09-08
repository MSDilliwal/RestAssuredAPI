package crudOperationForReqresAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectsTest {

	@Test
	public void readProjects()
	{
		when()
		 .get("https://reqres.in/api/users/")
	    .then()
	     .contentType(ContentType.JSON)
	     .statusCode(200)
	     .log().all();
	}
}
