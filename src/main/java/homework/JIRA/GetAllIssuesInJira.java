package homework.JIRA;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetAllIssuesInJira {
	@Test
	public void getIssues() {
		RestAssured.baseURI = "https://restapijira.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("RestAPIJira@gmail.com", "DMB3vASfPQt15fEa7wqj03E3");
		RequestSpecification inputRequest =RestAssured.given().log().all().accept(ContentType.JSON).queryParam("jql", "project="+"AP");
		Response res = inputRequest.get();
		res.prettyPrint();
		int ststusCode = res.getStatusCode();
		System.out.println(ststusCode);
	}

}
