package crudOperationUsingFramework;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import genericUtility.BaseAPIclass;
import genericUtility.EndPointLibrary;
import genericUtility.Iconstants;
import genericUtility.JavaUtility;
import pojoCLasses.ProjectLibrary;

public class GetSingleProject extends BaseAPIclass{

	@Test
	public void readProject() {
		
	    JavaUtility jLib = new JavaUtility();
	   	    
	    given()
	     .pathParam("pID", "TY_PROJ_1404")
	    .when()
	     .get(Iconstants.baseURI+EndPointLibrary.getSingleProject+"{pID}")
	    .then()
	     .assertThat()
	     .statusCode(200)
	     .log().all();
	    
	}

}
