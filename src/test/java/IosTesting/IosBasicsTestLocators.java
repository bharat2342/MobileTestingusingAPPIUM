package IosTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IosBasicsTestLocators extends IosConfigure

{
	@Test
	public void iosBasicsLocators()
	{
		//Basics Locators in ios-Xpath,className,IOS,iosclassChain,IOSpredicateString
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//Now we use Locator of IOS-ClassChain
		//Xpath is very slow in ios so here we come up with IOS-classChain
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		//Same how do we use iosClassChain it is very much similiar to X-path with some changes
		driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeStaticText[`label=='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**XCUIElementTypeCell")).sendKeys("Bharat Wifi");
		
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
		
		//Now how to Use IOS predicateString
		
		driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value== 'Confirm / Cancel'"));
		
		//Just Like Contains in Xpath we write this conjunction expressions
		
		driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"));
		driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
		
		
	String actualMsg=driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'==")).getText();
		System.out.println(actualMsg);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label=='Confirm'")).click();
		
		Assert.assertEquals(actualMsg, "A message");
		
		
		
		
		
		
		
	}
	
	
	

}
