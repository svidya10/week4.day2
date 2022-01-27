package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// 1. Launch https://www.snapdeal.com/
		// Setup
		WebDriverManager.chromedriver().setup();

		// Step1: Load Snapdeal application URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");

		// Maximize
		driver.manage().window().maximize();

		// 2. Go to Mens Fashion
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement menFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
	
		// 3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		// 4. Get the count of the sports shoes
		
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(count);
		
		// 5. Click Training shoes
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		// 6. Sort by Low to High
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		
		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		
		// 7. Check if the items displayed are sorted correctly
		
		String sort = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		System.out.println(sort);
		if(sort.contains("Price Low To High") == true )
			System.out.println("Low to High Sort done");
			else System.out.println("Sort Not done");
		
		// 8. Select the price range (900-1200)
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		// 9. Filter with color Navy
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(text(),'View More')])[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
		// 10. verify the all applied filters
		String price = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
		System.out.println(price);
		
		String color = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
		System.out.println(color);
		
		if(price.contains("Rs. 900 - Rs. 1200") == true )
			System.out.println("Price Filter is done");
			else System.out.println("Price Filter is not done");
		
		if(color.contains("Navy") == true )
			System.out.println("Color Filter is done");
			else System.out.println("Color Filter is not done");
		
		// 11. Mouse Hover on first resulting Training shoes
	
		WebElement firstShoe = driver.findElement(By.xpath("(//div[@class='product-tuple-image '])[1]"));
		builder.moveToElement(firstShoe).perform();
		
		// 12. click QuickView button
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
		
		// 13. Print the cost and the discount percentage
		System.out.println(driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		
		// 14. Take the snapshot of the shoes.
		

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Snapdeal.png");
		FileUtils.copyFile(source, destination);
		
		// 15. Close the current window
		
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		
		// 16. Close the main window
		
		//driver.close();

	}

}
