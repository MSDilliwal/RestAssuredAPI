package genericUtility;

import static io.restassured.RestAssured.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIclass extends BaseClass {

	BaseClass bLib = new BaseClass();
	DataBaseUtility dLib = new DataBaseUtility();
	JavaUtility jLib = new JavaUtility();
	//RestAssuredLibrary rLib = new RestAssuredLibrary(); 


	@BeforeSuite
	public void bsConfig() throws Exception {
		dLib.connectToDB();
		 baseURI = "http://localhost";
		 port = 8084;

	}

	@AfterSuite
	public void asConfig() throws Exception {

		dLib.closeDB();
	}


}
