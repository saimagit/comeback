package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class steps {
	
	private static Response response;
	private static String baseURL;
		
		@Given("The url is correct")
		public void the_url_is_correct() {
			System.out.println("i'm in Given");
		    baseURL = "https://dog.ceo";
			
		}
		
		@When("I hit the API")
		public void I_hit_the_API() {
			System.out.println("i'm in WHEN");
			RestAssured.baseURI = baseURL;
			RequestSpecification request = RestAssured.given();
		    response = request.get("api/breeds/list/all");
		}
		@Then("the status code is 200")
		public void status_code_is_200() {
			System.out.println("i'm in THEN");
			Assert.assertEquals(200, response.getStatusCode());
		}
		@And("body is correct")
		public void body_is_correct() {
			System.out.println("i'm in AND");
			String json = response.asString();
			System.out.println(json);
		}

}
