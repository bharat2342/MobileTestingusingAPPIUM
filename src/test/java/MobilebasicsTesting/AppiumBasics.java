package MobilebasicsTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {

	@Test
	public void AppiumTest() throws MalformedURLException
	{
		//By default the Appium Server Starts at Port no-4723
		//We use write the Capabilities(In what Operating system we need to write)
		//Android Apps or ios Apps
		//Lets create the Androiddriver object
		//Appium Code is sent to server interprets the code and talk to Mobile Testing
		
		//Install the app and Invoke the particular app
		//under the app Api-demos will get clicked
		
		UiAutomator2Options capabilities= new UiAutomator2Options();
		capabilities.setPlatformName("Bharat Emulator");
		capabilities.setApp("C:\\Users\\bharat\\git\\repository\\MobileTestingUsingAPPIUM\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723") ,capabilities);
		driver.quit();

	}

}
