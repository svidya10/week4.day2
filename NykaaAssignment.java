package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		// 1) Go to https://www.nykaa.com/
		// Setup
		WebDriverManager.chromedriver().setup();

		// Step1: Load ServiceNow application URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");

		// Maximize
		driver.manage().window().maximize();

		// 2) Mouse over on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();

		// 3) Click L'Oreal Paris

		driver.findElement(
				By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']/parent::a"))
				.click();

		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)

		if (driver.getTitle().contains("L'Oreal Paris") == true) {
			System.out.println("L'Oreal Paris page verified");
		} else {
			System.out.println("L'Oreal Paris page not verified");
		}

		// 5) Click sort By and select customer top rated
		
		driver.findElement(By.xpath("//div[@id='filter-sort']")).click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div")).click();

		// 6) Click Category and click Hair->Click haircare->Shampoo
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		// 7) Click->Concern->Color Protection
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();	
		
		// 8)check whether the Filter is applied with Shampoo

		String shampoo = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[text()='Shampoo']")).getText();
		System.out.println(shampoo);
		if(shampoo.contains("Shampoo") == true)
		{
			System.out.println("Shampoo is available in Filter");
		}
		else
		{
			System.out.println("Shampoo not available in Filter");
		}
		
		// 9) Click on L'Oreal Paris Colour Protect Shampoo
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[contains(text(),'Paris Colour Protect Shampoo')])[1]")).click();
		
		// 10) GO to the new window and select size as 175ml
		
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		WebElement dd = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropdown = new Select(dd);
		dropdown.selectByVisibleText("175ml");
		
		// 11) Print the MRP of the product
		System.out.println(driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText());
		
		// 12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text() = 'ADD TO BAG'])[1]")).click();

		// 13) Go to Shopping Bag
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class = 'cart-count']/parent::button")).click();

		// 14) Print the Grand Total amount
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,\"/mobileCartIframe?ptype=customIframeCart\")]")));
		
		Thread.sleep(4000);
		
		String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following-sibling::div")).getText();
		System.out.println(grandTotal);
		
		// 15) Click Proceed
		driver.findElement(By.xpath("//span[text() = 'PROCEED']/ancestor::button")).click();
		
		// 16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text() = 'CONTINUE AS GUEST']")).click();
		
		// 17) Check if this grand total is the same in step 14
		String gt = driver.findElement(By.xpath("//div[text() = 'Grand Total']/following-sibling::div/span")).getText();
		System.out.println(gt);
		
		if(gt.equals(grandTotal) == true)
		{
			System.out.println("Yes same Grandtotal");
		}
		else System.out.println("Grandtotal not same");
		// 18) Close all windows
		driver.quit();
		
	}

}
