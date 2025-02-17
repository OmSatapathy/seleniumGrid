package designPattern;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverTest {

    private WebDriver driver;

    // Constructor that will accept WebDriver object
    public WebDriverTest(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void openWebsite() {
        
        driver.get("https://chatgpt.com/");
        System.out.println("Page title: " + driver.getTitle());
        
        driver.quit(); 
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        	       .withTimeout(Duration.ofSeconds(30L))
        	       .pollingEvery(Duration.ofSeconds(5L))
        	       .ignoring(NoSuchElementException.class);
        
        
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
              return driver.findElement(By.id("foo"));
            }
          });

    }


    @Factory
    @Parameters("browser")
    public static Object[] createTests(String browser) {
        WebDriver driver = WebDriverFactory.getDriver(browser); 
        return new Object[]{new WebDriverTest(driver)};
    }
}
