package FrameWork1Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC3_AddTheProduct extends APPIUMConfiguration
{
	
	@Test
	public void addProductandAddtoCart() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BharatDetails");
		driver.hideKeyboard(); //To hide the keyboard
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//Scroll upto India We get this code from the UIautomator class
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath
				("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//To go and Scroll-upto Jordan ringas
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		//Now we need to add the cart 
		List<WebElement> products= driver.findElements
				(By.id("com.androidsample.generalstore:id/productName"));
		
		for(int i=0;i<products.size();i++)
		{
			
			String productName=driver.findElements
							(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id
						("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Add cart- Validation
		//Explicit wait 
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		
		String LastPageProduct=driver.findElement
				(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(LastPageProduct, "Jordan 6 Rings");//Finally the cart added is validated or not
		
	}
}
