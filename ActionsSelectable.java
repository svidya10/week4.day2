package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSelectable {

	public static void main(String[] args) {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");

		// Maximize
		driver.manage().window().maximize();
		
		// Select multiple elements using Ctrl and click
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		// Select multiple elements using Mouse Drag
		builder.keyDown(Keys.CONTROL).click(item1)
			.click(item2)
			.click(item3)
			.click(item4)
			.keyUp (Keys.CONTROL)	
			.perform();
			
	}

}
