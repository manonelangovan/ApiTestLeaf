package week3;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestCR {
	@Test
	public void updateIncident() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/change_request/4ac9addc87220110b4decaaf8bbb35dc";
		RestAssured.authentication = RestAssured.
				basic("admin", "iNnYi7wT1xDL");
		//File file= new File("./src/test/resources/IncidentPUT.json");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"description\": \"Manon adding description for testing\",\r\n"
				+ "    \"short_description\": \"Manon adding short description for testing\"\r\n"
				+ "}");
		Response reponse =inputRequest.put();
		reponse.prettyPrint();
		int ststusCode = reponse.getStatusCode();
		System.out.println(ststusCode);
		
	}
}
