package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		// Launch the browser
		WebDriverManager.chromedriver().setup();

		// Launch the URL - https://erail.in/
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Un-check the check box - sort on date
		driver.findElement(By.id("chkSelectDateOnly")).click();

		// clear and type in the source station
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MS");
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys(Keys.ENTER);

		// clear and type in the destination station
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("CBE");
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys(Keys.ENTER);

		// Find all the train names using xpath and store it in a list
		// //table[@class = 'DataTable TrainList TrainListHeader']//tr[1]/td[2]
		
		int size = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr")).size();
		
		List<String> trainList = new ArrayList<String>();
		
		for(int i = 1; i <= size; i++)
		{			
			String trainName = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]")).getText();
			trainList.add(trainName);
			System.out.println("//table[@class = 'DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]");
		}
		
		// Use Java Collections sort to sort it and then print it
		Collections.sort(trainList);
		
		for(String trainName:trainList)
			System.out.println(trainName);		
	}
}
