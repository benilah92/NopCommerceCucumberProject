package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {
	
	public static WebDriver driver;
	
	@FindBy(id="Email")
	private WebElement mailId;
	
	@FindBy(id="Password")
	private WebElement passwd;
	
	@FindBy(id="FirstName")
	private WebElement firstName;
	
	@FindBy(id="LastName")
	private WebElement lastName;
	
	@FindBy(id="Gender_Female")
	private WebElement gender;
	
	@FindBy(xpath="//*[@class='k-select']")
	private WebElement dob;
	
	@FindBy(id="Company")
	private WebElement company;
	
	@FindBy(xpath="(//input[@class='check-box'])[1]")
	private WebElement checkbox1;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	private WebElement newsletterClick;
	
	public WebElement getNewsletterClick() {
		return newsletterClick;
	}

	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	private WebElement customerRoles;
	
	@FindBy(id="VendorId")
	private WebElement vendor;
	
	@FindBy(xpath="//button[@type='submit'][@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="class=\"alert alert-success alert-dismissable\"")
	private WebElement successMsg;

	public boolean getSuccessMsg() {
		
		return successMsg.isDisplayed();
	}

	public CustomerDetailsPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getMailId() {
		return mailId;
	}

	public WebElement getPasswd() {
		return passwd;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getCheckbox1() {
		return checkbox1;
	}

	
	public WebElement getCustomerRoles() {
		return customerRoles;
	}

	public WebElement getVendor() {
		return vendor;
	}
	

	

}
