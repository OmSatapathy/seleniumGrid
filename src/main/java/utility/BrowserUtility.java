package utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public static WebDriver setUp(String browser) throws MalformedURLException {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);

		}

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--start-maximized");
			driver = new FirefoxDriver(opt);
		}

		if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		if (browser.equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");

			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		}
		return driver;

	}

	@AfterSuite
	public static void tearDown() {
		driver.quit();
	}

	public static void scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
	}

}
