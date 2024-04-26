package nopcommerce.baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	File file;

	// Browser Launch Method
	public static WebDriver getDriver(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	// Launching Url
	protected void launchUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// WebElement Methods
	protected void passInput(WebDriver driver, WebElement element, String input) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void clickOnElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void deleteInput(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected boolean isEnabled(WebDriver driver,WebElement element) {
		return element.isEnabled();
	}

	protected boolean isDisplayed(WebDriver driver,WebElement element) {
		return element.isDisplayed();
	}

	protected boolean isSelected(WebDriver driver,WebElement element) {
		return element.isSelected();
	}
	

	// Screenshot Method
	protected void screenShot(WebDriver driver, String name) {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File(".\\Screenshot\\" + name + ".png");
		try {
			FileUtils.copyFile(scrfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Java Script Executor Methods
	protected void scroll(WebDriver driver, int x, int y) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ");");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void jsClick(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void jsScrollAndClick(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Wait Methods
	protected void implicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	protected void expliciWaitVisible(WebDriver driver, WebElement element) {
		try {


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void staticWait(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void selectFromDropDown(WebDriver driver, WebElement element, String option, String value) {

		try {
			Select s = new Select(element);
			if (option.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			} else if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibleText")) {
				s.selectByVisibleText(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Alert Method
	protected void confirmAlert(WebDriver driver, WebElement element, String condition) {
		try {
			Alert confirm_alert = driver.switchTo().alert();
			if (condition.equalsIgnoreCase("accept")) {
				confirm_alert.accept();
			} else if (condition.equalsIgnoreCase("dismiss")) {
				confirm_alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Mouse Actions Methods
	protected void dragAndDrop(WebDriver driver, WebElement element, WebElement element1) {
		try {
			new Actions(driver).dragAndDrop(element, element1).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void mouseHover(WebDriver driver, WebElement element) {
		try {
			new Actions(driver).moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Switch To Window or Tab Method
	protected static void switchWindow(WebDriver driver, int index) {
		try {
			Set<String> all_tab_id = driver.getWindowHandles();
			List<String> tab_id_list = new LinkedList<>(all_tab_id);
			driver.switchTo().window(tab_id_list.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Switch To DefaultContent
	protected void switchToHome() {
		try {
			Set<String> set = driver.getWindowHandles();
			ArrayList arr = new ArrayList(set);
			driver.switchTo().window((String) arr.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected String getText(WebDriver driver,WebElement element) {
		try {
			return element.getText();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	// Close & Quit
	protected void closeTab() {
		driver.close();
	}

	protected void terminateBrowser() {
		driver.quit();
	}

}
