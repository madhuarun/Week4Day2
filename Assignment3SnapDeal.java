package Week4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;

public class Assignment3SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(2000);
		
		Actions build = new Actions(driver);
		
		
		//2. Go to Mens Fashion
		WebElement MensFashion = driver.findElement(By.xpath("//span[text() = \"Men's Fashion\"]/parent::a"));
		
		build.moveToElement(MensFashion).perform();
		Thread.sleep(2000);
		//3.Go to Sports Shoes
		driver.findElement(By.xpath("//span[text() = \"Sports Shoes\"]/parent::a")).click();
		
		
		//4. Get the count of the sports shoes
		System.out.println(driver.findElement(By.xpath("//h1[@category= 'Sports Shoes for Men']/following-sibling::span")).getText());
		Thread.sleep(8000);
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()=\"Training Shoes\"]/parent::a")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class = 'sort-drop clearfix']")).click();
		
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-index = '1']")).click();
		
		//7. Check if the items displayed are sorted correctly
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		String priceFirst = priceElements.get(0).getAttribute("data-price");
		String priceLast = priceElements.get(priceElements.size() - 1).getAttribute("data-price");
		
		if (Integer.parseInt(priceFirst) < Integer.parseInt(priceLast)) {
			System.out.println("Items are sorted as expected");
		} else {
			System.out.println("Items are not sorted");
		}

//		8.Select the price range (900-1200)
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		//price-go-arrow btn btn-line btn-theme-secondary
		
		Thread.sleep(3000);
//		9.Filter with color Navy 
		
		driver.findElement(By.xpath("//button[text()='View More ']")).click();
		if (driver.findElement(By.xpath("//input[@value='Navy']")).isEnabled()) {
			driver.findElement(By.xpath("//input[@value='Navy']/parent::div")).click();
		}else {
			System.out.println("Navy color filter is not enabled");
		}
//		10 verify the all applied filters 
		String price = driver.findElement(By.xpath("(//div[@class='filters']/div)[1]/a")).getText();
		String color = driver.findElement(By.xpath("(//div[@class='filters']/div)[2]/a")).getText();
		if ((price.equals("Rs. 900 - Rs. 1200")) && (color.equals("Navy"))) {
			System.out.println("Filters have been applied");
		} else {
			System.out.println("Filters are not applied");
		}	
		
		Thread.sleep(2000);
//		11. Mouse Hover on first resulting Training shoes and 12.click quickview button 
		
		WebElement mouseoverproduct=driver.findElement(By.xpath("//picture[@class='picture-elem']/img[1]"));
		
		WebElement quickview=driver.findElement(By.xpath("//picture[@class='picture-elem']/img[1]//ancestor::a/following-sibling::div[@class='clearfix row-disc']/div[contains(text(),'Quick View')]"));
		
		Actions builder=new Actions(driver);
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(2000) );
		wait1.until(ExpectedConditions.elementToBeClickable(mouseoverproduct));
		
		builder.moveToElement(mouseoverproduct).pause(4000).build().perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(quickview));
		
		builder.moveToElement(quickview).click().perform();
		
	
//		13. Print the cost and the discount percentage
		String pricefinal=driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println(pricefinal);
		String discount=driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(discount);
		
//		14. Take the snapshot of the shoes.
		
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshots/shoe.png");
		FileUtils.copyFile(source, destination);
		
		
//		15. Close the current window
		
		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i[@class='sd-icon sd-icon-delete-sign']")).click();
		
	//	16. Close the main window
		
		
		driver.close();
		

	}
	}