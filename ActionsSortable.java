package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//load leaf ground web page  
		
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		//switching to items frame
		driver.switchTo().frame(0);
		
		WebElement elesource = driver.findElement(By.xpath("//li[text()='Item 1']"));
		//WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='Item 2']"));
		//WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='Item 3']"));
		WebElement eletarget = driver.findElement(By.xpath("//li[text()='Item 3']"));
		//WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='Item 5']"));
		//WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='Item 6']"));
		//WebElement item7 = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='Item 7']"));
		
		Actions build=new Actions(driver);
		build.dragAndDrop(elesource, eletarget).pause(2000).perform();
			 
				
		

	}

}
