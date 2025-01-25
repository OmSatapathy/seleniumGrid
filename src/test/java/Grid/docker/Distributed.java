package Grid.docker;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import BaseTest.Basetest;

public class Distributed extends Basetest {
	WebDriver driver;

	
	@SuppressWarnings("deprecation")
	@Test
	public void launch() throws Exception {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		driver.get("https://www.selenium.dev/");

		System.out.println(driver.getTitle());
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void launch2() throws Exception {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		driver.get("https://github.com/SeleniumHQ/selenium/releases/tag/selenium-4.28.0");

		System.out.println(driver.getTitle());
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void launch3() throws Exception {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		driver.get("https://www.browserstack.com/guide/take-screenshots-in-selenium");

		System.out.println(driver.getTitle());
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void launc4() throws Exception {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		driver.get("https://www.geeksforgeeks.org/");

		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	

}
