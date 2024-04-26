package com.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.pom.CustomerDetailsPage;
import com.poma.PageObjectManager;
import com.utility.ConfigReader;
import com.utility.ReadExcelData;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nopcommerce.baseClass.BaseClass;

public class StepDefClass extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	public static Robot r;
	//ConfigReader cd;
	
	@Before
	public void beforeHooks(Scenario s) {
		System.out.println("Scenario Nmae: " +s.getName());
	
	}
	
	@Given("user Lands on the application")
	public void user_lands_on_the_application() {
	    System.out.println("User lands on the application");
	}
	
	@Given("user Enters The URL {string}")
	public void user_enters_the_url(String URL) {
	   launchUrl(driver, URL);
	}

	@When("user Login With Valid Credentials")
	public void user_login_with_valid_credentials() {
	    
	}

	@When("click Login Button")
	public void click_login_button() {
		expliciWaitVisible(driver,pom.getLoginPage().getLoginBtn() );
		
		clickOnElement(driver, pom.getLoginPage().getLoginBtn());
	   
	}
	@When("user sees Dashboard Page")
	public void user_sees_page() {
	   Assert.assertEquals(pom.getLoginPage().getDashBoard(),true);
	}

	@When("user Clicks Customers In The Customers Tag On Left")
	public void user_clicks_customers_in_the_customers_tag_on_left() throws AWTException {
	   
		implicitWait(driver);
		clickOnElement(driver, pom.getLoginPage().getCustomerTag());
	    r = new Robot();
	    r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		implicitWait(driver);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@Then("clicks Add New Button")
	public void clicks_add_new_button() {
	   clickOnElement(driver, pom.getLoginPage().getAddCustomer());
	}
	
	@Given("user Navigates to the new Customer Page")
	public void user_navigates_to_the_new_customer_page() {
	    
	}
	@When("user Fills The Form From Excel Sheet")
	public void user_fills_the_form_from_excel_sheet() throws InvalidFormatException, IOException {
		
		ReadExcelData reader = new ReadExcelData();
		passInput(driver, pom.getDetails().getMailId(), reader.getMailId());
		passInput(driver, pom.getDetails().getPasswd(), reader.getPassword());
		passInput(driver, pom.getDetails().getFirstName(), reader.getFirstName());
		passInput(driver, pom.getDetails().getLastName(), reader.getLastName());
		clickOnElement(driver, pom.getDetails().getGender());
		clickOnElement(driver, pom.getDetails().getDob());
		String monthYear=driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
		System.out.println(monthYear);
		String month = monthYear.split(" ")[0].trim();
		String year = monthYear.split(" ")[1].trim();
		System.out.println(month);
		System.out.println(year);
		while (!(month.equals("March") && year.equals("2020"))) {

			WebElement cal = driver.findElement(By.xpath("//a[@aria-label='Previous']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", cal);
			monthYear = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			month = monthYear.split(" ")[0].trim();
			year = monthYear.split(" ")[1].trim();

		}
		WebElement date = driver.findElement(By.xpath("//a[text()='20']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", date);
		passInput(driver, pom.getDetails().getCompany(), reader.getCompany());
		clickOnElement(driver, pom.getDetails().getCheckbox1());
		clickOnElement(driver, pom.getDetails().getNewsletterClick());
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		clickOnElement(driver, pom.getDetails().getCustomerRoles());
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		clickOnElement(driver, pom.getDetails().getVendor());
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		

	}
	@When("user Clicks Save Button")
	public void user_clicks_save_button() {
	   clickOnElement(driver, pom.getDetails().getSaveBtn());
	   
	}
	
	@Then("it Shows a Success Message")
	public void it_shows_a_success_message() {
		//clickOnElement(driver, pom.getDetails().getSuccessMsg());
		//CustomerDetailsPage cd = new CustomerDetailsPage(driver);
	
		//Assert.assertEquals(pom.getDetails().getSuccessMsg(),true);
		//Assert.assertEquals(true, pom.getDetails().getSuccessMsg().isDisplayed());
		//driver.close();
	    
	}
	
	@After
	public void afterHooks(Scenario s) {
		
		screenShot(driver, "nopCommerce");
		System.out.println("Scenario Status: " +s.getStatus());
		
	}


	

}
