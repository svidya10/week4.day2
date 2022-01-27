package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSortable {

	public static void main(String[] args) {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");

		// Maximize
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Move an element from one position to another
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		Point location = item3.getLocation();
		
		// Select multiple elements using Mouse Drag
		builder.dragAndDropBy(item1, location.getX(), location.getY()).perform();
		
	}
}
