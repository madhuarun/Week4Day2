package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.gson.GsonExtentTypeAdapterBuilder.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealClassroomActivity2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		//load snap deal 
		driver.get("http://www.snapdeal.com/");
		
		//mouse hover on men's fashion and click shirts
		WebElement mensfashion=driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		
		//moving towards shirts snd clicking it 
		Actions build=new Actions(driver);
		build.moveToElement(mensfashion).perform();
		driver.findElement(By.xpath("//div[@class='colDataInnerBlk']//span[text()=\"Shirts\"]")).click();
		
		//mouse hover on first product and click quick view
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement firstimage=driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
		build.moveToElement(firstimage).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
}
}
