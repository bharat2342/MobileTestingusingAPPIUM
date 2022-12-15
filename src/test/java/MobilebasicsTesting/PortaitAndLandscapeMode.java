package MobilebasicsTesting;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;

public class PortaitAndLandscapeMode extends ConfigureAppium
{
	@Test
	public void portaritLandScape() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//To turn the screen in 90 degrees
		//So now we need to check both the landscape and portarit mode
		
		DeviceRotation landScape= new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String actTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actTitle, "WiFi settings");
		
		
		// To Copy and Paste from Clipboard-Virtual
		driver.setClipboardText("Bharat Wifi");//Lets say somewhere it is copied from the app
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1")).click();
		
		
		
		//To navigate to home and all
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.HOME));//To press Home Button
		
		
	
	
	
	}
}
