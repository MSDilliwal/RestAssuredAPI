package validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {

	@Test
	public void DynamicResponseValidationTest() {
		
		//pre-requisites
		String expectedData = "TY_PROJ_1005";
		
		//actions
		Response response = when().get("http://localhost:8084/projects");
		
		//validation
		boolean flag = false;
		List<String> projectsIds = response.jsonPath().get("projectId");
		for (String pIds : projectsIds) {
			
			if(pIds.equalsIgnoreCase(expectedData)) {
				flag = true;
			}	
		}
		Assert.assertTrue(flag);
		System.out.println("Data is verified");	
	    response.then().log().all();
	}
}
