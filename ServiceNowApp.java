package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev115675.service-now.com/navpage.do");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Cyclone@121212");
		driver.findElement(By.id("sysverb_login")).click();

		driver.findElement(By.id("filter")).sendKeys("Incident", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']//div[text()='All']")).click();

		driver.switchTo().frame("gsft_main");

		driver.findElement(By.id("sysverb_new")).click();

		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("admin", Keys.ENTER);
		driver.findElement(By.id("incident.short_description"))
				.sendKeys("Creating an incident with help of selenium in Web");
		String incNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		Thread.sleep(2000);

		driver.findElement(By.id("sysverb_insert_bottom")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search'][@class='form-control']")).sendKeys(incNum,
				Keys.ENTER);
		String search = driver.findElement(By.xpath("//td[@class='vt']/a[1]")).getText();
		
		
		if(search.contains(incNum))
			System.out.println("Incident created successfully"); 
		else
			System.out.println("Incident creation failed");
		  
		  File pic = driver.getScreenshotAs(OutputType.FILE); 
		  File folder = new File("./Images/Incident.png"); 
		  FileUtils.copyFile(pic, folder);
		  
		 
	}

}
