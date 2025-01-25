package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class RightSideobject {

	WebDriver driver;

	public RightSideobject(WebDriver driver) {
		this.driver = driver;

	}

	private By source = By.xpath("//div[@id='draggable']");
	private By target = By.xpath("//div[@id='droppable']");
	private By file = By.xpath("(//input[@type='file'])[1]");

	
	
	public void dragDrop() {
		WebElement src = driver.findElement(source);
		WebElement tar = driver.findElement(target);

		Actions act = new Actions(driver);
		act.dragAndDrop(src, tar).build().perform();
	    String message =	tar.getText();
	    Assert.assertEquals(message, "Dropped!");
	}
	
	public void uploadFile() {
		driver.findElement(file).sendKeys("/Users/om.satapthy/Downloads/restAssured-serialization.pdf");
	}

}
