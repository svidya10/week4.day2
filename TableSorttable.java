package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSorttable {

	public static void main(String[] args) throws InterruptedException {
		// Setup
		WebDriverManager.chromedriver().setup();

		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");

		// Maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<String> namelist = new ArrayList<String>();
		int size = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		for (int i = 1; i < size; i++) {

			String name = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]")).getText();
			namelist.add(name);
			System.out.println(name);
		}

		Collections.sort(namelist);

		driver.findElement(By.xpath("//th[text()='Name']")).click();
		
		Thread.sleep(2000);
		
		List<String> sortlist = new ArrayList<String>();
		int sortSize = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		for (int i = 1; i < sortSize; i++) {
			String nameSort = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]")).getText();
			sortlist.add(nameSort);
			System.out.println(nameSort);
		}

		if (namelist.equals(sortlist))
			System.out.println("Table Sort working");
		else
			System.out.println("Table Sort not working");
	}
}
