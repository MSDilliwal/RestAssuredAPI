package crudOperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class GetProject {
 @Test
 public void readProject() {
 
	 given()
	  .contentType(ContentType.JSON)
	 .when()
	  .get("http://localhost:8084/projects/TY_PROJ_001")
	 .then()
	  .assertThat().contentType(ContentType.JSON)
	  .assertThat().statusCode(200)
	  .and()
	  .log().all();
	 
 }
}
