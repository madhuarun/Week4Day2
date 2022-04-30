package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDrag {
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	
//opening leaf ground page
	driver.get("http://leafground.com/pages/drag.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//assigning the xpath of green square to webelement
	WebElement greensquare=driver.findElement(By.xpath("//p[text()='Drag me around']/parent::div"));
	
	//printing the current location of the green square
	System.out.println(greensquare.getLocation());
	
	//using actions class to drag and drop the green square to a specific location
	Actions build=new Actions(driver);
	build.dragAndDropBy(greensquare,200,100).perform();
	
	//printing the new location of green square
	System.out.println(greensquare.getLocation());

}
}