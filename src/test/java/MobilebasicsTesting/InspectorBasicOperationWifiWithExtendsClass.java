package MobilebasicsTesting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtils.ConfigureAppium;
import io.appium.java_client.AppiumBy;

public class InspectorBasicOperationWifiWithExtendsClass extends ConfigureAppium
{
	@Test
	public void wifiSettingName() throws MalformedURLException
	{
		//ConfigureAppiumsetup(); //So here we give Without knowledge of TEstNG
		//But if we give beforeClass annotation it is sufficient
		//After class annotation is sufficient
		//tearDown();
		
		//So simply we write the MobileTest Cases and now configuration is done
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//To grab the Title of WiFi settings
		String actTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Bharat");
		driver.findElement(By.id("android:id/button1")).click();
		//Another way of Writing the X-path
		//driver.findElements(By.className("android.widget.Button")).get(1).click();//for same ok
		
		
	
	
	
	}
}
