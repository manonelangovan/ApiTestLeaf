package week3;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {
	@Test
	public void updateIncidentWithPatch() {
		RestAssured.baseURI= "https://dev94739.service-now.com/api/now/table/incident/f3d3e15887220110b4decaaf8bbb35fb";
		RestAssured.authentication = RestAssured.
				basic("admin", "iNnYi7wT1xDL");
		File file= new File("./src/test/resources/IncidentPATCH.json");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON).body(file);
		Response reponse =inputRequest.patch();
		reponse.prettyPrint();
		int ststusCode = reponse.getStatusCode();
		System.out.println(ststusCode);
	}
}
