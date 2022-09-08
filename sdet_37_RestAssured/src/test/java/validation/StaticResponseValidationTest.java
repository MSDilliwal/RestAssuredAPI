package validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {

	@Test
	public void StaticResponseValidationTest() {
		
		//pre-requisites
		String expectedData = "TY_PROJ_001";
		
		//actions
		Response response = when().get("http://localhost:8084/projects");
		
		//validation
	    String actualData = response.jsonPath().get("[0].projectId");
	    Assert.assertEquals(expectedData, actualData);
	    
	    System.out.println("Data is verified");
	    response.then().log().all();
		
		
	}

}
