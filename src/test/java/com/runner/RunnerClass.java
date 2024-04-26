package com.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src\\test\\java\\com\\feature\\nopcommerce.feature",
					//"src\\test\\java\\com\\feature\\searchCustomer.feature"},
			
			glue="com.stepdef",
			//tags="@A1 or @A3",
			plugin= {"html:HTML_Reports/nopCommerceReport.html",
					"json:JSONReports/nopCommerceJsonReport.json",
					"pretty",
			  	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							
					}
		
			)
	public class RunnerClass {
		
		public static WebDriver driver;
		
		@BeforeClass
		public static  void set_Up() {
			
			driver = nopcommerce.baseClass.BaseClass.getDriver("chrome");
		
		}
		
		@org.junit.AfterClass
		public static void tear_down() {
			//driver.close();
		}

}
