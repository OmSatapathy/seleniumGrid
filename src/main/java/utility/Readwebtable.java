package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Readwebtable {

	WebDriver driver;

	public Readwebtable(WebDriver driver) {
		this.driver = driver;
	}

	public void webTable() {
		WebElement table = driver.findElement(By.name("BookTable"));
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
	}

	public void dynamicWebtable() {
		WebElement table = driver.findElement(By.id("taskTable"));
		// find number of rows
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

		for (WebElement ele : rows) {
			List<WebElement> cells = ele.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText() + " | ");
			}
			System.out.println();
		}

	}
	
	public void readProdtable() {
	WebElement ele=	driver.findElement(By.id("productTable"));
	List<WebElement> rows   =  ele.findElements(By.xpath(".//tbody/tr"));
	  for(WebElement row : rows) {
		List<WebElement> el=    row.findElements(By.tagName("td"));
		for(WebElement l : el) {
			System.out.println(l.getText() + " | ");
		}
		System.out.println();
	  }
	}
}
