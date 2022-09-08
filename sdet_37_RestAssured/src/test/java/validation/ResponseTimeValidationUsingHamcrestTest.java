package validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationUsingHamcrestTest {

	@Test
	public void HamcrestValidationTest() {
		
		//actions
		when()
		 .get("http://localhost:8084/projects")
		 
		//validation
		.then()
		 .assertThat().time(Matchers.greaterThan(50L),TimeUnit.MILLISECONDS)
		 .assertThat().log().all();
	}

}
