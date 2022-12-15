package FrameWork1Ecommerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class TC1_FillAllDetails extends APPIUMConfiguration
{
	
	@Test
	public void fillForm()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BharatDetails");
		driver.hideKeyboard(); //To hide the keyboard
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//Scroll upto India We get this code from the UIautomator class
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath
				("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		
	}

}
