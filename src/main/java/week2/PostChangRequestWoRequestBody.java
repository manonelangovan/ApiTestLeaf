package week2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostChangRequestWoRequestBody {
	@Test
	public void postCR() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "iNnYi7wT1xDL");
		RequestSpecification inputRequest = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.XML);
		Response createResponse = inputRequest.post();
		createResponse.prettyPrint();
		int ststusCode = createResponse.getStatusCode();
		System.out.println(ststusCode);
	}

}
