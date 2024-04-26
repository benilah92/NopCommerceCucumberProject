package com.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.poma.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nopcommerce.baseClass.BaseClass;

public class SearchCusStepDefinitoin extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	public static Robot r;
	
	@Given("Login in to the URL {string}")
	public void login_in_to_the_url(String url) {
		launchUrl(driver, url);
	 
	}
	
	@Given("User login to the application")
	public void user_login_to_the_application() {
	    
	}

	@When("user login with Given Email and Password")
	public void user_login_with_given_email_and_password() {
	   // expliciWaitVisible(driver, pom.getLoginPage().getLoginBtn());
		clickOnElement(driver, pom.getLoginPage().getLoginBtn());
	}
	
	@Given("user Clicks the Customer tag for Searching")
	public void user_clicks_the_customer_tag_for_searching() throws AWTException {
	    
		expliciWaitVisible(driver,pom.getLoginPage().getCustomerTag() );
		clickOnElement(driver, pom.getLoginPage().getCustomerTag());
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		implicitWait(driver);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

	@When("user enters The Email Id {string}")
	public void user_enters_the_email_id(String mailId) {
	   passInput(driver, pom.getSearch().getSearchMail(), mailId);
	}

	@Then("user Clicks Search Button")
	public void user_clicks_search_button() {
		expliciWaitVisible(driver, pom.getSearch().getSearchBtn());
	   clickOnElement(driver, pom.getSearch().getSearchBtn());
	}

	@Then("user will See The Details")
	public void user_will_see_the_details() {
	    
	}
	@Given("user Clicks the Customer tag")
	public void user_clicks_the_customer_tag() throws AWTException {
		clickOnElement(driver, pom.getLoginPage().getCustomerTag());
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		implicitWait(driver);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enters The Name {string}")
	public void user_enters_the_name(String Name) {
		passInput(driver, pom.getSearch().getSearchFirstName(), Name);
		
	}


	
}
