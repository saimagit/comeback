package stepDefinitions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaywriteTestSteps {
	
	/**
	 * When I enter the google url
    Then google home page is shown
	 */
	
	@When("i enter the google url")
	public void i_enter_the_google_url() {
		
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //BrowserContext context = browser.newContext();
        
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("resources/")));
        
        Page page = context.newPage();
        // Navigate to a URL
        page.navigate("https://www.google.com");
        System.out.println("Page title: " + page.title());
        page.fill("//textarea[@aria-label='Search']", "saima tak");
		
	}
	
	@Then("google home page is shown")
	public void google_home_page_i_shown() {
		
	}

}
