Feature: Search Customer by EmailId and Name 
Background: 
	Given User login to the application 

@A1	
Scenario: User enters Email and Password 
	Given Login in to the URL "https://admin-demo.nopcommerce.com/login" 
	When  user login with Given Email and Password 
	And   click Login Button 
@A2	
Scenario: Searching customer by Email 
	Given user Clicks the Customer tag for Searching 
	When user enters The Email Id "steve_gates@nopCommerce.com" 
	Then user Clicks Search Button 
	And user will See The Details 
@A3	
Scenario: Searching customer by Name
Given user Clicks the Customer tag 
When user enters The Name "Victoria"
Then user Clicks Search Button
And user will See The Details 	
 
