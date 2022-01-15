package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCWindows 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> window = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(window);
		
		driver.switchTo().window(windows.get(1));
		System.out.println("New window title is: "+driver.getTitle());
		
		driver.switchTo().window(windows.get(0));
		driver.close();
	}
}