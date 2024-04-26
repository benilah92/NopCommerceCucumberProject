Feature: Login to nopCommerce.com WebPage 
Background: 
	Given user Lands on the application 
Scenario: Login To Application As Valid User 
	Given  user Enters The URL "https://admin-demo.nopcommerce.com/login" 
	When user Login With Valid Credentials 
	And click Login Button 
	Then user sees Dashboard Page 
	When user Clicks Customers In The Customers Tag On Left 
	And clicks Add New Button
	
	
Scenario: Adding The Customer Details
	Given user Navigates to the new Customer Page
	When user Fills The Form From Excel Sheet
	And user Clicks Save Button
	Then it Shows a Success Message
