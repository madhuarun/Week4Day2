package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {
	
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	
	//open nykaa page
	driver.get("http://www.nykaa.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//mouse over to brand and search
	WebElement brand=driver.findElement(By.xpath("//a[text()='brands']"));
	WebElement search=driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		
	Actions build=new Actions(driver);
	build.moveToElement(brand).moveToElement(search).click().sendKeys("L'Oreal Paris").perform();
	
	WebElement lorealparis=driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]"));
	build.moveToElement(lorealparis).click().perform();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//get title of loreal paris page
	String title=driver.getTitle();
	
	//checking if the title page contains the brand name
	
	if(title.contains("L'Oreal")) {
		System.out.println(title);
	}
	else
	{
		System.out.println("Not the right page");
	}
	
	//clicking /expanding sort options
	driver.findElement(By.xpath("//span[@class='sort-name']/parent::button")).click();
	
	//selecting customer top rated
	driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']//div[@class='control-indicator radio ']")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//expand category 
	driver.findElement(By.xpath("//span[text()='Category']/following-sibling::div")).click();
	Thread.sleep(1500);
	
	//expand hair  
	driver.findElement(By.xpath("//span[text()='Hair']/ancestor::li")).click();
	

	//expand Haircare
	driver.findElement(By.xpath("//span[text()='Hair Care']/parent::div/parent::li")).click();
	
	//check shampoo	
	driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']//div[2]")).click();
		
    Thread.sleep(2000);
	
	//expand the shop by concern first expand hair then expand shop by concern
	
	driver.findElement(By.xpath("//span[text()='Hair']/ancestor::li")).click();
	driver.findElement(By.xpath("//span[text()='Shop By Concern']/parent::div/parent::li")).click();
	
	Thread.sleep(2000);
	
	//check color protection 
	driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div/following-sibling::div")).click();
	
	//assigning the shampoo path to filter and getting the text in filter 
	
     WebElement filter=driver.findElement(By.xpath("//span[text()='Shampoo']"));
     System.out.println(filter.getText());
     
     //checking if the filter applied contains shampoo else mention not present 
     if(filter.getText().equals("Shampoo")) {
    	 System.out.println("Shampoo is present in filters applied");
    	 
    	     }else {
    	    	System.out.println("shampoo not present");
    	     }
     
     //click the image with all filters applied 
     driver.findElement(By.xpath("//img[contains(@alt,'Paris')]")).click();
     
     //handle the windows as moving to new page
     
     Set<String> windowhandle=driver.getWindowHandles();
     List<String> listhandle=new ArrayList<String>(windowhandle);
     driver.switchTo().window(listhandle.get(1));
     
     //select 175ml from drop down 
        WebElement eleDropdownsizeindex=driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd=new Select(eleDropdownsizeindex);
		dd.selectByIndex(1);
	
		//getting the value of product in a web element and printing the value of the product
		
		WebElement mrp=driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span"));
		System.out.println(mrp.getText());
		
		//click add to bag button 
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']/parent::button")).click();
		
		//click shopping bag
		driver.findElement(By.xpath("//span[text()='Account']/following::div/button")).click();
		Thread.sleep(2000);
		
		//handling frames
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		System.out.println(iframe.size());
		
		//switching to the shopping bag i frame
		
		WebElement shopcartframe=driver.findElement(By.xpath("//div[@id='portal-root']//iframe"));
		driver.switchTo().frame(shopcartframe);

		//getting the value of grand total
		WebElement grandtotal=driver.findElement(By.xpath("//span[text()='Grand Total']/parent::div/following-sibling::div"));
		String total=grandtotal.getText();
		System.out.println(total);
		
		//click proceed button
		
		driver.findElement(By.xpath("//span[text()='PROCEED']/parent::span/parent::button")).click();
		Thread.sleep(3000);
		
		//click continue as guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(2000);
		
		//getting the value of grand total after clicking continue as guest
		WebElement grandtotalguest=driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span"));
		System.out.println(grandtotalguest.getText());
		
		if(total.contains(grandtotalguest.getText())) {
			
			System.out.println("Amount matches");
		}
			else {
				System.out.println("Amount doesn't match");
			}
		
		//driver.quit();
			
			}
	
}

