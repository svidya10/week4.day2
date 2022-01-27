package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraAssignment {

	public static void main(String[] args) throws IOException {
		// 1) Open https://www.myntra.com
		// Setup
		WebDriverManager.chromedriver().setup();

		// Step1: Load Snapdeal application URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");

		// Maximize
		driver.manage().window().maximize();
		
		// 2) Mouse hover on Men
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement menFashion = driver.findElement(By.xpath("//a[@data-type='navElements'][text()='Men']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
		
		// 3) Click Jackets
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

		// 4) Find the total count of item
		String totalCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(totalCount);
		totalCount = totalCount.replaceAll("[^0-9]", "");
		int tc = Integer.parseInt(totalCount);
	

		// 5) Validate the sum of categories count matches
		String jacket = driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span")).getText();
		System.out.println(jacket);
		jacket = jacket.replaceAll("[^0-9]", "");
		System.out.println(jacket);
		int j = Integer.parseInt(jacket);
		
		String rainJacket = driver.findElement(By.xpath("//input[@value='Rain Jacket']/following-sibling::span")).getText();
		System.out.println(rainJacket);
		rainJacket = rainJacket.replaceAll("[^0-9]", "");
		System.out.println(rainJacket);
		int rj = Integer.parseInt(rainJacket);
		
		int sum = j+rj;
		if(tc==sum)
			System.out.println("Jacket+RainJAcket is equal to Totalcount of JAckets");
		else
			System.out.println("Jacket+RainJAcket is NOT equal to Totalcount of Jackets");
			
		// 6) Check jackets
		driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::div")).click();

		// 7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();

		// 8) Type Duke and click check box
		
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//input[@value='Duke']/parent::label")).click();
		
		// 9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class = 'myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		// 10) Confirm all the Coats are of brand Duke
		// Hint : use List
		//driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		List<WebElement> findElements = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		boolean status = true;
		for(WebElement brandName:findElements)
		{			
			String text = brandName.getText();

			if(text.equals("Duke") == false)
			{
				status = false;
				break;
			}
		}
		
		if(status == true)
			System.out.println("All jackets are of brand Duke");
		else
			System.out.println("All jackets are not of brand Duke");
		
		// 11) Sort by Better Discount
		driver.findElement(By.xpath("//div[@class = 'sort-sortBy']")).click();
		driver.findElement(By.xpath("//input[@value='discount']/parent::label")).click();

		// 12) Find the price of first displayed item
		String firstPrice = driver.findElement(By.xpath("(//span[@class = 'product-discountedPrice'])[1]")).getText();
		System.out.println(firstPrice);
		
		// Click on the first product
		driver.findElement(By.xpath("(//span[@class = 'product-discountedPrice'])[1]")).click();

		// 13) Take a screen shot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/myntra.png");
		FileUtils.copyFile(source, destination);
		
		// 14) Click on WishList Now
		driver.findElement(By.xpath("//span[text() = 'WISHLIST']")).click();

		// 15) Close Browser
		driver.close();

	}
}
