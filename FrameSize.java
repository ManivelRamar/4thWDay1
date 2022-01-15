package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSize 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.id("Click"));
		
		File pic = click.getScreenshotAs(OutputType.FILE); 
		File folder = new File("./Images/click.png"); 
		FileUtils.copyFile(pic, folder);
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frameList=driver.findElements(By.tagName("iframe"));
		System.out.println("Count of the frames in the page "+frameList.size());

	}

}
