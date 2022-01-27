package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsResizable {

	public static void main(String[] args) {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");

		// Maximize
		driver.manage().window().maximize();
		
		// Drag to resize the element
		Actions builder = new Actions(driver);

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement resizeEle = driver.findElement(By.xpath("//div[@class = 'ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		
		builder.dragAndDropBy(resizeEle,100,150).perform();
		
	}

}
