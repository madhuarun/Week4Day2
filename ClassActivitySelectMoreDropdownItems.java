package Week4Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassActivitySelectMoreDropdownItems {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//To select the dropdown 
		
		WebElement dropdown=driver.findElement(By.xpath("//option[text()='Select your programs']/parent::select"));
		Select dd=new Select(dropdown);
		//convert select to list
		List<WebElement> option=dd.getOptions();
		
		//selecting first and last option
		WebElement item1=option.get(1);
		WebElement item2=option.get(4);
		
		//using action class to select first and last option by clicking control like how we select options manually
		
		Actions build=new Actions(driver);
		build.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();
		
				

}
}
