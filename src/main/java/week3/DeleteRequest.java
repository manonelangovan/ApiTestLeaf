package week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	@Test
	public void deleteIncident() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/incident/f3d3e15887220110b4decaaf8bbb35fb";
		RestAssured.authentication = RestAssured.
				basic("admin", "iNnYi7wT1xDL");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON);
		Response response= inputRequest.delete();
		response.prettyPrint();
		int ststusCode = response.getStatusCode();
		System.out.println(ststusCode);
	}
}
