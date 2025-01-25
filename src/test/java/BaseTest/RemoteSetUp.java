package BaseTest;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import config.Configuration;
import pageobject.RightSideobject;
import utility.BrowserUtility;

public class RemoteSetUp extends Basetest{
	
	@Test
	public void setUp() throws MalformedURLException {
		driver = BrowserUtility.setUp("remote");
		driver.get(Configuration.Base_url);
		RightSideobject obj = new RightSideobject(driver);
		obj.dragDrop();
		obj.uploadFile();
	
	}

}
