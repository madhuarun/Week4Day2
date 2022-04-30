package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.checkerframework.checker.index.qual.SubstringIndexBottom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTables {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//load leaf ground web page  
		
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Get the count of number of columns
		
		List <WebElement> columncount=driver.findElements(By.tagName("th"));
		System.out.println("The number of coloumns are:"+columncount.size());
		
		//Get the count of number of rows
		List <WebElement> rowcount=driver.findElements(By.tagName("tr"));
		System.out.println("The number of rows are:"+rowcount.size());
		
		TreeSet<Integer> progress = new TreeSet<Integer>();
		//Get the progress value of 'learn to interact with elements'
		//Loop through each row
		for(int i=2;i<=rowcount.size();i++) {

			String columnText = driver.findElement(By.xpath("//tr["+i+"]/td[1]")).getText();
			if (columnText.equals("Learn to interact with Elements")) {
				//System.out.println("Progress for "+columnText+" is:");
				System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText());
			}
			String progressText = driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
			int progressInt = Integer.parseInt(progressText.substring(0, progressText.length()-1));
			progress.add(progressInt);
		}
		
		String leastComplete = progress.first()+"%";
		
		//Loop through each row
				for(int i=2;i<=rowcount.size();i++) {
					String progressText = driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
					if (progressText.equals(leastComplete)) {
						driver.findElement(By.xpath("//tr["+i+"]/td[3]/input")).click();
					}
				}
		
		
		//List <WebElement> learn1=driver.findElements(By.xpath("//tr[@class=\"even\"]/td"));
		
		
		
		
		
}
}
