package crudOperationForReqresAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {

	@Test
	 public void DeleteProject() {
		
		when()
		 .delete("https://reqres.in/api/users/2")
		.then()
		 .assertThat()
		 .statusCode(204)
		 .log().all();
	}

}
