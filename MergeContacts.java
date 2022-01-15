package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[1]")).click();
		
		Set<String> set = driver.getWindowHandles();
		List<String> newPage = new ArrayList<String>(set);
		
		driver.switchTo().window(newPage.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		
		driver.switchTo().window(newPage.get(0));
		
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img[1]")).click();
		
		Set<String> set1 = driver.getWindowHandles();
		List<String> newPage1 = new ArrayList<String>(set1);
		
		driver.switchTo().window(newPage1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt']//a[1]")).click();
		
		driver.switchTo().window(newPage1.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		driver.switchTo().alert().accept();
		
		if(driver.getTitle().contains("View Contact | opentaps CRM"))
		
			System.out.println("Title verified");
		else
			System.out.println("Title not verified");
		
	}

}
