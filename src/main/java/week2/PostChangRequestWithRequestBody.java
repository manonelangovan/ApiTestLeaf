package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostChangRequestWithRequestBody {
	@Test
	public void postCR() throws FileNotFoundException {
		
		Map<String,String> quaryParamValues= new HashMap<String, String>();
		quaryParamValues.put("sysparm_fields","sys_id,number");
		quaryParamValues.put("category","Software");
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "iNnYi7wT1xDL");
		File file= new File("./src/test/resources/ChangeRequestPost1.json");
		RequestSpecification inputRequest = RestAssured
				.given()
				.log()
				.all()
				.queryParams(quaryParamValues)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(file);
	
		Response createResponse = inputRequest.post();
		createResponse.prettyPrint();
		int ststusCode = createResponse.getStatusCode();
		System.out.println(ststusCode);
	}

}
