package crudOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
@Test
public void readAllProjects() {
	
	given()
	 .contentType(ContentType.JSON)
	.when()
	 .get("http://localhost:8084/projects")
	.then()
	 .statusCode(200)
	 .and()
	 .log().all();
}
}
