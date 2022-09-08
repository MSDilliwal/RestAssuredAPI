package crudOperationUsingFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import genericUtility.BaseAPIclass;
import genericUtility.EndPointLibrary;
import genericUtility.Iconstants;
import io.restassured.http.ContentType;
import pojoCLasses.ProjectLibrary;

public class UpdateProject extends BaseAPIclass {

	@Test
	public void updateProject() {
		
		ProjectLibrary proLib = new ProjectLibrary("Vinay", "vinnie", "ongoing", 10);
		
		given() 
		 .pathParam("pID", "TY_PROJ_1009")
		 .contentType(ContentType.JSON)
		.when()
		 .put(Iconstants.baseURI+EndPointLibrary.updateProject+"{pID}")
		.then()
		 .assertThat().statusCode(200)
		 .contentType(ContentType.JSON)
		 .log().all();
	}
}