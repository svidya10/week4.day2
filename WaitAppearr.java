package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitAppearr {

	public static void main(String[] args) {
		// Launch the browser
		WebDriverManager.chromedriver().setup();

		// Launch the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Get WebElement for Button that is not visible yet

		WebElement hiddenButton = driver.findElement(By.id("btn"));

		// Wait for it to appear Hint: WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(hiddenButton));

		// After button appears, get the text of that button.

		System.out.println(hiddenButton.getText());
	}

}
