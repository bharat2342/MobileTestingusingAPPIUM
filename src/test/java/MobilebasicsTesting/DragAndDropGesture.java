package MobilebasicsTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class DragAndDropGesture extends ConfigureAppium
{
	@Test
	public void dragDrop() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement sourceID=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) sourceID).getId(),
			    "endX", 619,
			    "endY", 560
			));
		
		String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "Dropped!");
		
	}
}
