package BaseTest;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import config.Configuration;
import pageobject.FormDetailpage;
import pageobject.RightSideobject;
import utility.BrokenLink;
import utility.BrowserUtility;

public class HomePageRightTest extends Basetest {
	

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		driver = BrowserUtility.setUp("chrome");
		driver.get(Configuration.Base_url);
	}
	
	@Test
	public void testForm() {
		FormDetailpage obj = new FormDetailpage(driver);
		obj.enterTopara();
		BrokenLink bnk = new BrokenLink(driver);
		bnk.findBrokenlinks();
	}
	
	
	@Test
	public void actionTest() throws InterruptedException {
		RightSideobject obj = new RightSideobject(driver);
		obj.dragDrop();
		obj.uploadFile();
		Thread.sleep(3000);
	}

}
