package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000) ;
		
		
		Actions act = new Actions(driver);
		
		WebElement fashion = driver.findElement(By.xpath("//div[@aria-label='Fashion']"));
		
		act.moveToElement(fashion).perform();
		Thread.sleep(2000) ;
		
		WebElement mensFas = driver.findElement(By.xpath("//a[text() = 'Men Footwear']"));
		act.moveToElement(mensFas).perform();
		Thread.sleep(2000);
		
		WebElement sportsWear = driver.findElement(By.xpath("//a[text() = \"Men's Sports Shoes\"]"));
		act.moveToElement(sportsWear).con().perform();		
		
		
		
	}
}
