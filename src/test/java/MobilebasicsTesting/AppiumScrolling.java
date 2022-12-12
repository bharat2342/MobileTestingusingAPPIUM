package MobilebasicsTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class AppiumScrolling extends ConfigureAppium
{
	public void mouseScrollOperations() throws InterruptedException
	{
	
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
	//Method-1 scroll type-When the Element is known wher to scroll
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	
	//Method-2 Dont know where the element exists and to scroll we go upto end
	//Here we use Co-ordinates
	
	//When dont have prior Idea upto where to scroll we go for it
	
	scrollToEndAction();
	
	
	//longPressActions(ele);
	
	
	}
}
