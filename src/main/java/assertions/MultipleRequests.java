package assertions;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import servicenowBaseClass.BaseClass;
import static org.hamcrest.Matchers.*;

public class MultipleRequests extends BaseClass{
	static RequestSpecification response;
	
	@BeforeMethod
	public void beforeExecution() {
		Map<String,String> quaryParamValues= new HashMap<String, String>();
		quaryParamValues.put("sysparm_fields","sys_id,number");
		quaryParamValues.put("category","Software");
		response = RestAssured
				.given()
				.log()
				.all()
				.queryParams(quaryParamValues)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"category\":\"software\",\"short_description\":\"Created by Manon 4 CCR\"}");

		ValidatableResponse createResponse = response.post("change_request").then().body(containsString("sys_id"));
	}
	
	
	
	@Test(invocationCount = 3)
	public void deleteCCR() {
		response = RestAssured.given().contentType(ContentType.JSON);
		Response response1= response.delete("change_request/"+sys_id);
				response1.prettyPrint();
		int ststusCode = response1.getStatusCode();
		System.out.println(ststusCode);
		Assert.assertEquals(ststusCode, "204");
	}

}
