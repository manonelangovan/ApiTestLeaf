package week2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetRequest {
	@Test
	public void getReguet() {
		//End Point
		Map<String,String> quaryParamValues= new HashMap<String, String>();
		quaryParamValues.put("sysparm_fields","sys_id,number,priority");
		quaryParamValues.put("category","Software");
		RestAssured.baseURI = "https://dev94739.service-now.com/api/now/table/change_request";
		//Add request
		RestAssured.authentication = RestAssured.basic("admin", "iNnYi7wT1xDL");
		int statusCode = RestAssured.get().statusCode();
		System.out.println(statusCode);
		RequestSpecification inputRequest = RestAssured
												.given()
												.log()
												.all()
												.queryParams(quaryParamValues)
												.accept(ContentType.JSON);
		Response response = inputRequest.get();
		int statusCode2= response.getStatusCode();
		System.out.println(statusCode2);
		response.prettyPrint();
	}
}
