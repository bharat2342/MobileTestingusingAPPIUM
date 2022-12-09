package MobilebasicsTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class InspectorBasicOperation 
{

	@Test
	public void InspectorTest() throws MalformedURLException
	{
		//This is invoke the app-Demos
		//Select the preferences
		//then perference dependancies and the click the wifi Settings
		//now add the name and then click on OK
		AppiumDriverLocalService service= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\bharat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();

		//To open the in-built framework of Mobile Testing
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("Bharat Emulator");
		options.setApp("C:\\Users\\bharat\\git\\repository\\MobileTestingUsingAPPIUM\\src\\test\\java\\Resources\\ApiDemos-debug.apk");

		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723") ,options);

		//Actual Finding and Inspecting of Locators will be done from here
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		
		driver.quit();
		service.stop();
		
		
		
		
		
		
		
	}

}
