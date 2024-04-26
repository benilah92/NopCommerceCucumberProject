package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='content-header']")
	private WebElement dashBoard;
	
	@FindBy(xpath="//div[@class='os-content']//following::ul//li[4][@class='nav-item has-treeview']")
	private WebElement customerTag;
	
	@FindBy(xpath="//div[@class='float-right']//a")
	private WebElement addCustomer;

	
	public WebElement getAddCustomer() {
		return addCustomer;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public boolean getDashBoard() {
		return dashBoard.isDisplayed();
	}

	public WebElement getCustomerTag() {
		return customerTag;
	}
	
	//(//ul[@class='nav nav-treeview'])[4]//li[1]//i

}
