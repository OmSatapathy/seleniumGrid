package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		return driver;
	}
}
