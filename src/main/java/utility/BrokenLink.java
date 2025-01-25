package utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLink {

	WebDriver driver;

	public BrokenLink(WebDriver driver) {
		this.driver = driver;
	}

	public void findBrokenlinks() {
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));

		for(int i=0;i<alllinks.size();i++)
        {
            WebElement E1= alllinks.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
        }

	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}
}
