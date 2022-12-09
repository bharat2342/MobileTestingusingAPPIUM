package CommonUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ConfigureAppium 
{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppiumsetup() throws MalformedURLException
	{
		 service= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\bharat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
			service.start();

			//To open the in-built framework of Mobile Testing
			UiAutomator2Options options= new UiAutomator2Options();
			options.setDeviceName("Bharat Emulator");
			options.setApp("C:\\Users\\bharat\\git\\repository\\MobileTestingUsingAPPIUM\\src\\test\\java\\Resources\\ApiDemos-debug.apk");

			 driver= new AndroidDriver(new URL("http://127.0.0.1:4723") ,options);
		
			
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
	

}
