/**
 * 
 */
package Week4Day2;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainNames {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in");
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		System.out.println("Number of trains:"+(tableRows.size()));
		Set<String> trainNames = new TreeSet();
		for(int i= 1;i<=tableRows.size();i++) {
			String trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(trainName);
			trainNames.add(trainName);
			
		}
		
		if(tableRows.size()>trainNames.size()) {
			System.out.println("Duplicates found"+trainNames.size());
			
		}else {
			System.out.println("No Duplicates found"+trainNames.size());
		}
		

	}

}
