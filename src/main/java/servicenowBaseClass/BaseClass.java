package servicenowBaseClass;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {
	public static String sys_id;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.
				basic("admin", "iNnYi7wT1xDL");
	}
}
