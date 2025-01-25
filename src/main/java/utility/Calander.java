package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Calander {

	WebDriver driver;

	public Calander(WebDriver driver) {
		this.driver = driver;
	}

	public void datePicker() {

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		while (!(month.equalsIgnoreCase("October") && year.equalsIgnoreCase("2023"))) {
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		}

		driver.findElement(By.xpath("(//a[@class='ui-state-default'])[5]")).click();
	}

	public void datePicker2() {

		driver.findElement(By.xpath("//input[@name='SelectedDate']")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		sel.selectByVisibleText("Oct");
		
		
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
		Select selyear = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		selyear.selectByVisibleText("2019");
		
		driver.findElement(By.xpath("(//a[@class='ui-state-default'])[23]")).click();
		

	}
	
	
}
