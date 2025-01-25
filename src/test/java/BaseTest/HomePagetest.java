package BaseTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import config.Configuration;
import pageobject.CalenderPageObject;
import pageobject.HomePageObject;
import utility.BrowserUtility;
import utility.Calander;
import utility.ReadData;
import utility.Readwebtable;

public class HomePagetest extends Basetest {



//	@BeforeSuite
	public void setUp() throws MalformedURLException {
		driver = BrowserUtility.setUp("chrome");
		driver.get(Configuration.Base_url);
	}

	@Test(priority = 1)
	public void homeTest() throws InterruptedException {

		HomePageObject obj = new HomePageObject(driver);
		obj.enterDetails();
		System.out.println(driver.getTitle());
		obj.selectDate();

		BrowserUtility.scrollDown();

		obj.selectCountry();
		obj.selectColor();

	}
	
	@Test(priority = 2)
	public void testCalender() {
		Calander can = new Calander(driver);
		can.datePicker();
		can.datePicker2();
		
		BrowserUtility.scrollDown();
		
		Readwebtable obj = new Readwebtable(driver);
		obj.webTable();
		BrowserUtility.scrollDown();
		obj.dynamicWebtable();
		obj.readProdtable();
	}

}
