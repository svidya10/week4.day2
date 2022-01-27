package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitDisappear {

	public static void main(String[] args) {
		// Launch the browser
		WebDriverManager.chromedriver().setup();

		// Launch the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		// Get WebElement for Button
		WebElement disappear = driver.findElement(By.id("btn"));
		
		// Wait for it to disappear Hint: WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(disappear));
		
		// After button disappeared, a text will appear. Verify that the text appears.  

		String text = driver.findElement(By.xpath("//strong[contains(text(),'I know you can')]")).getText();
		
		if (text.contains("I know"))
			System.out.println("Text Appears");
		else
			System.out.println("Text does not Appear");
		
	}

}
