package servicenowBaseClass;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident_Chaining extends BaseClass{
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
		.body("{\"category\":\"software\",\"short_description\":\"Created by Manon 4 request\"}");
		Response createResponse = inputRequest.post("incident");
		createResponse.prettyPrint();
		int ststusCode = createResponse.getStatusCode();
		System.out.println(ststusCode);
	}
	

}
