package MobilebasicsTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerAutomate 

{
	
	@Test
	public void AppiumTest() throws MalformedURLException
	{
	//We create a object fpr AppiumDriverLocal Service
	// Now we give the AppiumJS available in the local System to trigger the node to start server
	//Then give IP address and Port on which it has to start
	//Then use the server instance of certain methods
	
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
			
			
			driver.quit();
			service.stop();
	
	}

}
