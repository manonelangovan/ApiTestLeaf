package homework.JIRA;

import java.io.File;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssueInJira {
	@Test
	public void createRequest() throws FileNotFoundException{
		RestAssured.baseURI= "https://restapijira.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().
				basic("RestAPIJira@gmail.com", "DMB3vASfPQt15fEa7wqj03E3");
		File file= new File("./src/test/resources/JIRARequestPost.json");
		RequestSpecification inputRequest = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(file);
	
		Response createResponse = inputRequest.post();
		createResponse.prettyPrint();
		int ststusCode = createResponse.getStatusCode();
		System.out.println(ststusCode);
	}
	
}
