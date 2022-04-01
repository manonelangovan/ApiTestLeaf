package servicenowBaseClass;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCCR_Chaining extends BaseClass{
	@Test
	public void createIncident() {
		Map<String,String> quaryParamValues= new HashMap<String, String>();
		quaryParamValues.put("sysparm_fields","sys_id,number");
		quaryParamValues.put("category","Software");
		RequestSpecification inputRequest= RestAssured
		.given()
		.log()
		.all()
		.queryParams(quaryParamValues)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\"category\":\"software\",\"short_description\":\"Created by Manon 4 CCR\"}");
		Response createResponse = inputRequest.post("change_request");
		createResponse.prettyPrint();
		int ststusCode = createResponse.getStatusCode();
		System.out.println(ststusCode);
		 JsonPath jsonPath=  createResponse.jsonPath();
		 sys_id= jsonPath.get("result.sys_id");
		 System.out.println(sys_id);
		 Assert.assertEquals(ststusCode, 201,"Assertion Failed");
	}
	

}
