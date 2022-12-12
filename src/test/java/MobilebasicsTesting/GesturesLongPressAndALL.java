package MobilebasicsTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class GesturesLongPressAndALL extends ConfigureAppium
{
	@Test
	public void longPress() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@Text='People Names']"));
		
		longPressActions(ele);
		
		//Now the gestures can be done
		//Documentation is provided by APPIUM-GIT-Hub
		//Key-Value Pairs must be created using the Javascript executor Method
		//((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
			//	ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		
		String MenuText=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(MenuText, "Sample menu");
		
		
	}
	
	
	
	

}
