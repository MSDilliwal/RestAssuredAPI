package crudOperationUsingFramework;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.DataBaseUtility;

//import com.aventstack.extentreports.model.Report;

import genericUtility.EndPointLibrary;
import genericUtility.FileUtility;
import genericUtility.Iconstants;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class EndToEndScenarioTest {

	//Scenario

	//Add a project using API
	//Capture the project ID from response
	//Go to RMG yantra (GUI) and validate using selenium
	//Go to database and write a query to validate whether the created project is there are not
	//Go to API and delete that project
	//Go to GUI and check it whether it is deleted or not
	//Go to database and validate the project whether it is deleted or not

	@Test
	public void createProject() throws IOException, SQLException {

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Virat");
		jobj.put("projectName", "FrameWork");
		jobj.put("status", "on going");
		jobj.put("teamSize", 10);

		Response response = given()
				.contentType(ContentType.JSON)
				.body(jobj)
				.when()
				.post(Iconstants.baseURI+EndPointLibrary.createProject);
				String pId =  response.jsonPath().get("projectId");
		        System.out.println(pId);
		        response.then().assertThat().contentType(ContentType.JSON)
		        .statusCode(201)
		        .log().all();
		        Reporter.log("Project is created in API");
 
	           //Validate the project inside the GUI
				WebDriver driver = null;

				JavaUtility jLib=new JavaUtility();
				FileUtility fLib = new FileUtility();
				WebDriverUtility wLib = new WebDriverUtility();

				
			
				FileInputStream fileInputStream = new FileInputStream("./src/test/resources/Data.properties");
				Properties properties = new Properties(); 
				properties.load(fileInputStream);
			
				String Url = properties.getProperty("url");
				String UserName = properties.getProperty("username");
				String Password = properties.getProperty("password");
				String Browser = properties.getProperty("browser");
				
				
				//setting up the browser
				if(Browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(Browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
				}

				//validation on GUI
                wLib.waitTillPageGetsLoad(driver);
                driver.get(Url);
                driver.manage().window().maximize();
                driver.findElement(By.id("usernmae")).sendKeys(UserName);
                driver.findElement(By.id("inputPassword")).sendKeys(Password);
                driver.findElement(By.xpath("//button[text()='Sign in']")).click();

                driver.findElement(By.xpath("//a[text()='Projects']")).click();
                
                List <WebElement> projectId = driver.findElements(By.xpath("//td[1]"));
                
                //Verification on GUI
                boolean temp = true;
                int count =0;
                
                for (WebElement proId : projectId ) {
                	String project = proId.getText();
                	if (project.equalsIgnoreCase(pId)) {
                		temp=false;
                		break;
                	}
                	count++;
                }
                if(temp==false) {
                	System.out.println("project is present in GUI");
                }
                else {
                	System.out.println("project is not presnt in GUI");
                }
                System.out.println(count);	
                
                
                //verify in database
                String query = "select * from project";
                DataBaseUtility dLib = new DataBaseUtility();
                dLib.connectToDB();
                dLib.executeQuery(query, 1, pId);
                dLib.closeDB();
               
                
         
                
	}
}
