package IosTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IosConfigure 
{
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureIosApplesetup() throws MalformedURLException
	{
		//Exclusively to invoke android APPS
		 service= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\bharat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
			service.start();
			
			//Xcode and UI catalog just like inspector in android and Simulator
			XCUITestOptions options=new XCUITestOptions();
			options.setDeviceName("iPhone 13 Pro");
			
			//Same here we give ios Location //UIKitCatalog.app
			options.setApp("C:\\Users\\bharat\\git\\repository\\MobileTestingUsingAPPIUM\\src\\test\\java\\Resources\\General-Store.apk");
			options.setPlatformVersion("15.5");
			
			//WebDriver Agent->IOS apps
			options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			
			//Now This time IosDriver
			driver= new IOSDriver(new URL("http://127.0.0.1:4723") ,options);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}
