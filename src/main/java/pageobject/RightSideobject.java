package pageobject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
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

	private By simpleAlert = By.xpath("//button[@id='alertBtn']");
	private By confirmAlert = By.xpath("//button[@id='confirmBtn']");
	private By promptAlert = By.xpath("//button[@id='promptBtn']");

	private By newtab = By.xpath("//button[contains(text(),'New Tab')]");
	private By multiWindow = By.xpath("//button[contains(text(),'Popup Windows')]");

	public void dragDrop() {
		WebElement src = driver.findElement(source);
		WebElement tar = driver.findElement(target);

		Actions act = new Actions(driver);
		act.dragAndDrop(src, tar).build().perform();
		String message = tar.getText();
		Assert.assertEquals(message, "Dropped!");
	}

	public void uploadFile() {
		driver.findElement(file).sendKeys("/Users/om.satapthy/Downloads/restAssured-serialization.pdf");
	}

	public void handleSimpleAlert() {
		driver.findElement(simpleAlert).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

	public void handleconfirmAlert() {
		driver.findElement(confirmAlert).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
	}

	public void handlepromptAlert() {
		driver.findElement(promptAlert).click();
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("Manoj Dash");
		System.out.println(alt.getText());
		alt.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
	}

	public void handleTab() {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(newtab).click();
		Set<String> alltab = driver.getWindowHandles();
		Iterator<String> itr = alltab.iterator();

		while (itr.hasNext()) {
			if (parentWindow != itr.next()) {
				driver.switchTo().window(itr.next());
				System.out.println(driver.getTitle());

			}

		}
		driver.switchTo().window(parentWindow);
	}

	public void handleWindow() {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(multiWindow).click();
		
		Set<String> alltab = driver.getWindowHandles();
		Iterator<String> itr = alltab.iterator();

		while (itr.hasNext()) {
			if (parentWindow != itr.next()) {
				driver.switchTo().window(itr.next());
				System.out.println(driver.getTitle());
				driver.close();

			}

		}
	}

}
