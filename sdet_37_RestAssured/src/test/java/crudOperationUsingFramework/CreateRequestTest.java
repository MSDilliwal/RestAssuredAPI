package crudOperationUsingFramework;

import org.testng.annotations.Test;

import genericUtility.BaseAPIclass;
import genericUtility.EndPointLibrary;
import genericUtility.Iconstants;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoCLasses.ProjectLibrary;

public class CreateRequestTest extends BaseAPIclass{

 @Test
 public void createProject() {
	 
	 JavaUtility jLib = new  JavaUtility();
	 
	 ProjectLibrary proLib = new ProjectLibrary("Aakash", "profito"+jLib.getRandomNum(), "on going", 10); 
	
	 given()
	  .contentType(ContentType.JSON)
	  .body(proLib)
	 .when()
	  .post(EndPointLibrary.createProject)
	 .then()
	  .assertThat().statusCode(201)
	  .contentType(ContentType.JSON)
	  .log().all();
	 
	 
		
 }
}
