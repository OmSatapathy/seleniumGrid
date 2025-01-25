package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalenderPageObject {

	 WebDriver driver;

	public CalenderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private By Country = By.xpath("//select[@id='country']");

	private By Colors = By.xpath("//select[@id='colors']");

	public void selectCountry() {
		WebElement countrySel = driver.findElement(Country);
		Select sel = new Select(countrySel);
		List<WebElement> allCountry = sel.getAllSelectedOptions();

		for (int i = 0; i < allCountry.size(); i++) {
			System.err.println(allCountry.get(i).getText());
			if (allCountry.get(i).getText().equalsIgnoreCase("India")) {
				allCountry.get(i).click();
				break;
			}
		}
	}

	public void selectColor() {
		WebElement colorSelect = driver.findElement(Colors);
		Select sel = new Select(colorSelect);
		List<WebElement> allColor = sel.getAllSelectedOptions();
		for(int i =0; i < allColor.size(); i++) {
			System.out.println(allColor.get(i).getText());
		}

	}

}
