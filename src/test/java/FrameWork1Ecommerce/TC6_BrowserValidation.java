package FrameWork1Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_BrowserValidation extends MobileBrowserConfiguration
{

	@Test
	public void mobileBrowserTest()
	{
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("rahul-shettyAcademy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		//how to scroll and use other gestures
		//Actually it is another TC7 but i am writing in this
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		
		driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
		
		//How to scroll on native app
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0.1000)", "");
		
		
		String devops=driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		System.out.println(devops);
		
		Assert.assertEquals(devops, "devops");
	}
	
	
}
