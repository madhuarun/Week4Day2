package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDrop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//opening leaf ground drop page
		driver.get("http://leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//assigning the xpath of source square to webelement
		WebElement sourceloc=driver.findElement(By.xpath("//div[@id='draggable']"));
		
		
		//assigning the xpath of target square to webelement
		WebElement targetloc=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions build=new Actions(driver);
		build.dragAndDrop(sourceloc, targetloc).perform();
		
	
	}

}
