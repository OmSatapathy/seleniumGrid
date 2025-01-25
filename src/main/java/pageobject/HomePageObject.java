package pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

	private WebDriver driver;
	String selectedCountry;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	private By name = By.xpath("//input[@id='name']");
	private By email = By.xpath("//input[@id='email']");
	private By phone = By.xpath("//input[@id='phone']");
	private By gender = By.xpath("//input[@class='form-check-input' and @type ='radio']");
	private By Days = By.xpath("//input[@type='checkbox' and @class= 'form-check-input']");
	

	private By Country = By.xpath("//select[@id='country']");
	private By Colors = By.xpath("//select[@id='colors']");
	

	public void enterDetails() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(name)));

		WebElement username = driver.findElement(name);
		username.sendKeys("sunil");

		driver.findElement(email).sendKeys("sunil@gmail.com");
		driver.findElement(phone).sendKeys("834885386");

		List<WebElement> ele = driver.findElements(gender);
		ele.get(1).click();

	}
	
	public void selectDate() {
		List<WebElement> allday =driver.findElements(Days);
		for(int i =0; i< allday.size();i++) {
			allday.get(i).click();
		}
	}
	
	public void selectCountry() {
		WebElement countrySel = driver.findElement(Country);
		countrySel.click();
		Select sel = new Select(countrySel);
		sel.selectByIndex(4);
		sel.selectByIndex(3);
    	sel.selectByIndex(2);
    	
    	sel.selectByVisibleText("India");
        selectedCountry=countrySel.getText();
		


	}
	
	public void selectColor() {
		WebElement colorSelect = driver.findElement(Colors);
		Select sel = new Select(colorSelect);
		sel.selectByIndex(4);
		sel.selectByIndex(3);
    	sel.selectByIndex(2);

	}
}
