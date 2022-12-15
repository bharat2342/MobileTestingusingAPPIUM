package MobilebasicsTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.android.Activity;

public class DirectlyJumpToSpecificPage extends ConfigureAppium
{
	@Test
	public void ToJumpSpecificPage()
	{
	
	//APP package and APP activity
	//adb shell dumpsys window | find "mCurrentFocus" -This is command in windows
	Activity activity= new Activity("io.appium.android.apis",
			"io.appium.android.apis.preference.PreferenceDependancies");
	
	driver.startActivity(activity);
	//We Directly land on to the page after Giving the command in the terminal
	
	DeviceRotation landScape= new DeviceRotation(0,0,90);
	driver.rotate(landScape);
	
	
	driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
	
	String actTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
	Assert.assertEquals(actTitle, "WiFi settings");
	
	
	// To Copy and Paste from Clipboard-Virtual
	driver.setClipboardText("Bharat Wifi");//Lets say somewhere it is copied from the app
	
	driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	driver.findElement(By.id("android:id/button1")).click();
	
	
	
	
	
	
	}
}
