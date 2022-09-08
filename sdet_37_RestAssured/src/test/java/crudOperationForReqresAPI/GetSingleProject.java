package crudOperationForReqresAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject {

	@Test
	public void readSingleProject() {
		when()
		 .get("https://reqres.in/api/users/3")
		 .then()
		 .statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
		 
	}
}
