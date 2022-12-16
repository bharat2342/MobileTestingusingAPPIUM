package FrameWork1Ecommerce;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

//We are automating the browser in MobileBasedApps
public class MobileBrowserConfiguration 
{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeTest
	public void mobileBrowserConfigure() throws MalformedURLException
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
		options.setChromedriverExecutable("path should be given");//Just like Selenium chromeDriver set Property statement
		options.setCapability("broswerName", "Chrome");
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723") ,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
