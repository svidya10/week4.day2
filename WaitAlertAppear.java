package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitAlertAppear {

	public static void main(String[] args) {
		// Launch the browser
		WebDriverManager.chromedriver().setup();

		// Launch the URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/alertappear.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Click on the button that is visible

		driver.findElement(By.xpath("//button[@id='alert']")).click();

		// Wait for the alert box to appear Hint: WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());

		// After alert appears, handle it
		Alert alert = driver.switchTo().alert();

		alert.accept();

	}

}
