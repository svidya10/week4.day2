package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();

		// Launch the URL - https://erail.in/
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		//	Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		// clear and type in the source station
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MS");
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys(Keys.ENTER);

		// clear and type in the destination station
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("CBE");
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys(Keys.ENTER);
		
		//	Add a java sleep for 2 seconds
		Thread.sleep(2000);
		
		//	Store all the train names in a list
		List<String> trainList = new ArrayList<String>();
		
		//	Get the size of it
		int size = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr")).size();
		
		//	Add the list into a new Set
		
		for( int i=1; i<= size; i++)
		{			
			String train = driver.findElement(By.xpath("//table[@class ='DataTable TrainList TrainListHeader']//tr[ "+  i  + " ]/td[2]")).getText();
			trainList.add(train);		
		}
		
		Set<String> trainSet = new HashSet<String>(trainList);
		
		//	And print the size of it
		if ( trainSet.size() == trainList.size())
			System.out.println("List is Unique " + "Set =  " +trainSet.size() + "List = " + trainList.size() );
		else 
			System.out.println("List is not Unique " + "Set =  " +trainSet.size() + "List = " + trainList.size() );
		
		driver.close();
		
	}
		
}
