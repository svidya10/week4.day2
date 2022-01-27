package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTextChange {

	public static void main(String[] args) {
		// Launch the browser
		WebDriverManager.chromedriver().setup();

		// Launch the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		// Get WebElement for Button that is visible
		WebElement button = driver.findElement(By.id("btn"));
		// Wait for the text to change Hint: WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));
		
		// After button text changes, click on button.		
		button.click();
		
		// Handle Alert.
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
