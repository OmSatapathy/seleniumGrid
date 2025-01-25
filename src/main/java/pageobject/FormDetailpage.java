package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormDetailpage {

	WebDriver driver;
	
	public FormDetailpage(WebDriver driver){
		this.driver= driver;
	}

	private By section1Input = By.xpath("//input[@id='input1']");
	private By section1Submit = By.xpath("//button[@id='btn1']");
	private By section2Input = By.xpath("//input[@id='input2']");
	private By section2Submit = By.xpath("//button[@id='btn2']");

	public void enterTopara() {
		driver.findElement(section1Input).sendKeys("this is first");
		driver.findElement(section1Submit).click();
		driver.findElement(section2Input).sendKeys("second para");
		driver.findElement(section2Submit).click();

	}

}
