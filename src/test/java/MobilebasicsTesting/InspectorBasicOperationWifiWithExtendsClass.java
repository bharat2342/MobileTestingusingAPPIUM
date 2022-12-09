package MobilebasicsTesting;

import java.net.MalformedURLException;

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
		
	
	
	
	}
}
