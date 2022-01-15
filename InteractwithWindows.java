package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractwithWindows 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		System.out.println("Current title "+driver.getTitle());
		
		driver.findElement(By.id("home")).click();
		
		Set<String> window = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(window);
		
		driver.switchTo().window(winList.get(1));
		System.out.println("Current title "+driver.getTitle());
		
		driver.switchTo().window(winList.get(0));
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> window1 = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(window1);
		
		driver.switchTo().window(winList1.get(2));
		System.out.println("Current title "+driver.getTitle());
		
		
		driver.switchTo().window(winList1.get(1));
		System.out.println("Current title "+driver.getTitle());
		
		driver.quit();
	}

}
