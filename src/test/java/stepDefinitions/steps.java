package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class steps {
	
	private static Response response;
	private static String dogsBaseURL = "https://dog.ceo";;
		
		@Given("The url is correct")
		public void the_url_is_correct() {
			System.out.println("i'm in Given");
		 
			}
		
		@When("I hit the API")
		public void I_hit_the_API() {
			System.out.println("i'm in WHEN");
			RestAssured.baseURI = dogsBaseURL;
			response = RestAssured.given().get("api/breeds/list/all");
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
		
		@And("bakharwal is present in the response body")
		public void bakharwal_is_present() {
			response
			   .then()
			    .statusCode(200)
			     .body("message.bakharwal", hasItem("Indian".toLowerCase()))
			     .body(containsString("chippiparai"));
			
			//response.then().body(containsString("bakarwal"));
			//response.asString().contains("bakharwal");
		}
		
		@And("bulldog has correct countries {string} {string} {string}")
		public void bulldog_has_correct_countries(String country1, String country2, String country3) {
			response.then()
			.body("message.bulldog", allOf(hasItem(country1), hasItem(country2), hasItem(country3) ))
			.body("message.husky", empty());
		}
		

}
