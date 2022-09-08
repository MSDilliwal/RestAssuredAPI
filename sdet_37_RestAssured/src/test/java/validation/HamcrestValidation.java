package validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

public class HamcrestValidation {

	@Test
	public void HamcrestValidation() {
		
		when()
		 .get("http://localhost:8084/projects")
		.then()
		 .assertThat().contentType(ContentType.JSON).statusCode(200).time(Matchers.greaterThan(500L), TimeUnit.MILLISECONDS)
		 .log().all();
		 
		
	}

}
