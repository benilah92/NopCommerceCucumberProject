package com.poma;

import com.pom.CustomerDetailsPage;
import com.pom.LoginPage;
import com.pom.SearchCustomerPage;

import nopcommerce.baseClass.BaseClass;

public class PageObjectManager extends BaseClass{
	
	public LoginPage login;
	public CustomerDetailsPage details;
	public SearchCustomerPage search;

	public LoginPage getLoginPage() {
		
		if(login == null) {
			
			login = new LoginPage(driver);
			
		}
		return login;
	}

	public CustomerDetailsPage getDetails() {
		
		if(details == null) {
			details = new CustomerDetailsPage(driver);
		}
		return details;
	}

	public SearchCustomerPage getSearch() {
		
		if(search == null) {
			search = new SearchCustomerPage(driver);
		}
		return search;
	}
	
	
	

}
