package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	public static WebDriver driver;
	
	@FindBy(id="SearchEmail")
	private WebElement searchMail;
	
	@FindBy(id="SearchFirstName")
	private WebElement searchFirstName;
	
	@FindBy(id="SearchLastName")
	private WebElement searchLastName;
	
	@FindBy(xpath="//button[@id='search-customers']//i")
	private WebElement searchBtn;

	public SearchCustomerPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchMail() {
		return searchMail;
	}

	public WebElement getSearchFirstName() {
		return searchFirstName;
	}

	public WebElement getSearchLastName() {
		return searchLastName;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
}
