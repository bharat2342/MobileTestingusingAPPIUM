package FrameWork1Ecommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_ErrorHandling_ToastMessages extends APPIUMConfiguration
{
	
	
	@Test
	public void toastmessage()
	{
		//To handle Toast Message in android we have
		//specifically Tag Name- android.widget.Toast[index number]
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String ToastMsg=driver.findElement
					(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println(ToastMsg);
		Assert.assertEquals(ToastMsg, "Please enter your name");
		
		
		
	}
	
	
	

}
