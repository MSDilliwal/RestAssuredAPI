package genericUtility;

import io.restassured.response.Response;

/**
 * This class consists of rest assured specific re usable methods 
 * @author Hp Lap
 *
 */
public class RestAssuredLibrary {

	/**
	 * This method will get the json data through json path from response body
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData (Response response, String path) {

	String jsonData = response.jsonPath().get(path);
	return jsonData;
 }
}