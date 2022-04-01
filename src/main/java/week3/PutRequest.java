package week3;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void updateIncident() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/incident/1c741bd70b2322007518478d83673af3";
		RestAssured.authentication = RestAssured.
				basic("admin", "iNnYi7wT1xDL");
		File file= new File("./src/test/resources/IncidentPUT.json");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON).body(file);
		Response reponse =inputRequest.put();
		reponse.prettyPrint();
		int ststusCode = reponse.getStatusCode();
		System.out.println(ststusCode);
		
	}
}
