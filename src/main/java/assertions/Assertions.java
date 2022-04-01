package assertions;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import servicenowBaseClass.BaseClass;
import static org.hamcrest.Matchers.*;

public class Assertions extends BaseClass{
	
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
		ValidatableResponse createResponse = inputRequest.post("change_request").then().body(containsString("sys_id1"));
		/*
		 * createResponse.prettyPrint(); int ststusCode =
		 * createResponse.getStatusCode(); System.out.println(ststusCode); JsonPath
		 * jsonPath= createResponse.jsonPath(); sys_id= jsonPath.get("result.sys_id");
		 * System.out.println(sys_id);
		 */ 
	}

}
