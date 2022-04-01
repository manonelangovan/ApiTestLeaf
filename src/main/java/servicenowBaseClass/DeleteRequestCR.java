package servicenowBaseClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequestCR extends BaseClass{
	@Test (dependsOnMethods = "servicenowBaseClass.PatchRequestCR_Chaining.updateIncidentWithCCR")
	public void deleteCCR() {
		/*
		 * RestAssured.baseURI=
		 * "https://dev94739.service-now.com/api/now/table/change_request/4ac9addc87220110b4decaaf8bbb35dc";
		 * RestAssured.authentication = RestAssured. basic("admin", "iNnYi7wT1xDL");
		 */
		RequestSpecification inputRequest = RestAssured.given().contentType(ContentType.JSON);
		Response response= inputRequest.delete("change_request/"+sys_id);
		response.prettyPrint();
		int ststusCode = response.getStatusCode();
		System.out.println(ststusCode);
	}
}
