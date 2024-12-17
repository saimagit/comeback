package stepDefinitions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaywriteTestSteps {
	
	/**
	 * When I enter the google url
    Then google home page is shown
	 */
    private static String email = "";
	
	Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    //BrowserContext context = browser.newContext();
    
    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
            .setRecordVideoDir(Paths.get("resources/")));
    
    Page page = context.newPage();
	
	@Given("I am on ABC CA home page")
	public void Iam_on_ABC_CA_home_pagel() {

        // Navigate to a URL
        page.navigate("https://www.abc.ca");
        System.out.println("Page title: " + page.title());
       // page.fill("//textarea[@aria-label='Search']", "saima tak");
		
	}
	@And("I have a valid email id {string}")
	public void i_have_a_valid_email_id(String email_id) {
	    // Write code here that turns the phrase above into concrete actions
	    email = email_id;
	    System.out.println("Email is is " + email);
	}

	
	@When("I click on Sign in Account")
	public void I_click_on_Sign_in_Account() {
		page.click("//div[text()='Account']");
	}
	
	//-------------------------------------------
	

	@Then("sign in or Create new account is displayed on a pop up")
	public void sign_in_or_Create_new_account_is_displayed_on_a_pop_up() {
	    // Write code here that turns the phrase above into concrete actions
		//page.isVisible("button[text()='Sign in or create account']");
	    
	}

	@When("I click on Sign in or create new account")
	public void i_click_on_Sign_in_or_create_new_account() {
	    // Write code here that turns the phrase above into concrete actions
		// page.pause();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.click("button[text()='Sign in or create account']");
	}

	@Then("page is navigated to the sign in or create new account screen")
	public void page_is_navigated_to_the_sign_in_or_create_new_account_screen() {
	    // Write code here that turns the phrase above into concrete actions
		page.isVisible("//h1[text()='Sign in or create your account']");
	}

	@When("I enter an email id {string}")
	public void i_enter_an_email_id_john1_smith_gmail_com(String email_id) {
	    // Write code here that turns the phrase above into concrete actions
	    page.fill("//input[@name='Email address']", email_id);
	}

	@When("I click on Continue button")
	public void i_click_on_Continue_button() {
	    // Write code here that turns the phrase above into concrete actions
	    page.click("//button[@id='login-continue-button']");
	}

	@Then("page is navigated to the Create your ABC account screen")
	public void page_is_navigated_to_the_Create_your_ABC_account_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("email id is displayed")
	public void email_id_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid first name {string}")
	public void i_enter_valid_first_name_Daria1(String fName) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid sur name {string}")
	public void i_enter_valid_sur_name(String surName) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter valid password {string}")
	public void i_enter_valid_password(String pwd) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click on Create Account button")
	public void i_click_on_Create_Account_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a success message is displayed {string}")
	public void a_success_message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Then("an error message is displayed {string}")
	public void n_error_message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
