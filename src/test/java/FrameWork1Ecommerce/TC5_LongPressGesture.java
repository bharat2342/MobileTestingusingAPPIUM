package FrameWork1Ecommerce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC5_LongPressGesture extends APPIUMConfiguration
{
	@Test
	public void longPress() throws InterruptedException
	{
		WebElement longPress= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		//To make a long press of Terms and Conditions
		longPressActions(longPress);
		//We get a POP-UP now we need to close it
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000); //If the performance is low then use it
		
		//Now it is opening a Browser
		Set<String> contexts= driver.getContextHandles(); //It retervies all the context of Both Android and Web-browser
		
		for(String contextNames:contexts)
		{
			System.out.println(contextNames);
			
			
		}
		
		//So we get 2 contexts as output
		//NATIVE_APP & "WEBVIEW_com.androidsample.generalstore" Then put in next context statement
		//driver.context("Webview"); //It switch the context from Android to Web-browser Mode
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		//Now we are in Browser switch from the app
		driver.findElement(By.name("q")).sendKeys("BharatKumar");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);//It performs search option
		//Now again we need to go back from the browser
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //Again we back to Native APP
		//So again switched to Native app
		driver.context("NATIVE_APP");
		
		
		
	}
	
	

}
