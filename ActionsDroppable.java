package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDroppable {

	public static void main(String[] args) {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");

		// Maximize
		driver.manage().window().maximize();

		// Drag smaller element and put it on the bigger element
		Actions builder = new Actions(driver);

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		WebElement dropEle = driver.findElement(By.id("droppable"));

		Point location = dropEle.getLocation();

		builder.dragAndDrop(dragEle, dropEle).perform();
		location = dragEle.getLocation();
		System.out.println("X = " + location.getX() + "Y = " + location.getY());
	}

}
