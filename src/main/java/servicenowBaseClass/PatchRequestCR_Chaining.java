package servicenowBaseClass;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequestCR_Chaining extends BaseClass{
	@Test(dependsOnMethods = "servicenowBaseClass.CreateCCR_Chaining.createIncident")
	public void updateIncidentWithCCR() {
		System.out.println(sys_id+ " SysID");
		File file= new File("./src/test/resources/IncidentPATCH.json");
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON).body(file);
		Response reponse =inputRequest.patch("change_request/"+sys_id);
		reponse.prettyPrint();
		int ststusCode = reponse.getStatusCode();
		System.out.println(ststusCode);
	}
}
