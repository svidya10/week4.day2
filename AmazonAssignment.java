package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//1.Load the URL https://www.amazon.in/
		// Setup
		WebDriverManager.chromedriver().setup();

		// Step1: Load Amazon application URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// Maximize
		driver.manage().window().maximize();
		
		//2.search as oneplus 9 pro
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		//3.Get the price of the first product
		String phonePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(phonePrice);
		phonePrice = phonePrice.replaceAll("[^0-9]", "");
		int pPrice = Integer.parseInt(phonePrice);
		
		//4. Print the number of customer ratings for the first displayed product
		System.out.println(driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText());
			
		//5. Mouse Hover on the stars
		// (//span[@data-action='a-popover']/parent::span)[1]
		// (//span[@data-action='a-popover'])[1]
		// (//span[@data-action='a-popover']/a)[1]
		// (//span[@data-action='a-popover']/a/i)[1]
		// (//span[@data-action='a-popover']/a/i/span)[1]
		// (//span[@data-action='a-popover']/a/i)[2]
		
		driver.findElement(By.xpath("(//span[@data-action='a-popover']/a)[1]")).click();
		
		Thread.sleep(2000);
		
		//6. Get the percentage of ratings for the 5 star.
		System.out.println(driver.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]/span[2]/a")).getText());
		
		//7. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal']/parent::a)[1]")).click();
		
		// Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windows.get(1));
		
		//8. Take a screen shot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Amazon.png");
		FileUtils.copyFile(source, destination); 
		
		//9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//10. Get the cart sub total and verify if it is correct.
		
		Thread.sleep(4000);
		
		String subtotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]")).getText();
		System.out.println("Subtotal is : "+ subtotal);
		
		subtotal = subtotal.replaceAll("[^0-9]", "");
		System.out.println("Subtotal replaced is " + subtotal);
		int subTPrice = Integer.parseInt(subtotal);
		
		if(subtotal.contains(phonePrice))
			System.out.println("Price matched");
		else
			System.out.println("Price not matched");
		
		driver.quit();
	}

}
