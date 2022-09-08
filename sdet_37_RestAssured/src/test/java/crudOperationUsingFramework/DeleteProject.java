package crudOperationUsingFramework;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import genericUtility.BaseAPIclass;
import genericUtility.EndPointLibrary;

public class DeleteProject extends BaseAPIclass {

	@Test
	public void deleteProject() {
		
		when()
		 .delete(EndPointLibrary.deleteProject)
		.then()
		 .assertThat().statusCode(204)
		 .log().all();
	}

}
