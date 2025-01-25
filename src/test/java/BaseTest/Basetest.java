package BaseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.BrowserUtility;

public class Basetest {

	WebDriver driver;

	public void setUp() throws MalformedURLException {
		driver = BrowserUtility.setUp("chrome");
		driver.get(Configuration.Base_url);
	}

	public void tearDown() {
		driver.quit();
	}

}
