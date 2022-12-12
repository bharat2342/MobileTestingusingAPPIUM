package MobilebasicsTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class SwipeActions extends ConfigureAppium
{
	public void swipeOperations() throws InterruptedException
	{
	
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@Text='1. Photos']")).click();
	WebElement firstImage= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
	
	Assert.assertEquals
(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), 
		"true");
	//Now swipe will get focused to another 1
	//How do we swipe
	//This are well-Documented in Appium-GitHub-Gestures
	//Again Re-usable code is possible
	
	/*
	 * ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
	 * ImmutableMap.of( "elementId",((RemoteWebElement)firstImage).getId(),
	 * 
	 * "direction", "left", "percent", 0.75 ));
	 */
	
	swipeAction(firstImage, "left");
	
	//After Swipe the focus turns out to be false
	
	Assert.assertEquals
	(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), 
			"false");
	}
}
