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
		System.out.println("Parent window title- "+driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("home")).click();
		
		Set<String> window = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(window);
		
		driver.switchTo().window(winList.get(1));
		
		driver.findElement(By.xpath("//h5[text()='Drop down']")).click();
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		int sizeOfWindows = driver.getWindowHandles().size();
		System.out.println("Size of windows: "+sizeOfWindows);
		
		driver.findElement(By.id("color")).click();
		
		Set<String> windows1 = driver.getWindowHandles();
		
		for (String allWindows : windows1) 
		{
			if(!allWindows.equals(parentWindow))
			{
				driver.switchTo().window(allWindows);
				driver.close();
			}
		
		}
		System.out.println("This program execution has successful");
	}

}

