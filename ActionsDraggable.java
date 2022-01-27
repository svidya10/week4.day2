package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDraggable {

	public static void main(String[] args) {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");

		// Maximize
		driver.manage().window().maximize();

		// Drag element and move to a new position
		Actions builder = new Actions(driver);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		
		Point location = dragEle.getLocation();
		System.out.println("X = " + location.getX() + "Y = " + location.getY());
		int x = 20;
		int y = 200;
		
		builder.dragAndDropBy(dragEle, x, y).perform();
		location = dragEle.getLocation();
		System.out.println("X = " + location.getX() + "Y = " + location.getY());
	}

}
