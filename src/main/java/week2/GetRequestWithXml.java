package week2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithXml {
	@Test
	public void getXml() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "iNnYi7wT1xDL");
		RequestSpecification input = RestAssured.given().accept(ContentType.XML);
		Response res =input.get();
		int statusCode = res.getStatusCode();
		System.out.println("Status code: "+statusCode);
		res.prettyPrint();
	}

}
