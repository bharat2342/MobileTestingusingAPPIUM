package FrameWork1Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC4_SumofTheCartValidation extends APPIUMConfiguration
{

	@Test
	public void addCartTotalAmount()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BharatDetails");
		driver.hideKeyboard(); //To hide the keyboard
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath
				("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//As it comtains 2 Add-to-cart so we go with Elements
		driver.findElements(By.xpath
				("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath
				("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		//Another way to get the ADD to cart by its index
		//driver.findElement(By.xpath
				//("//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
		
				driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains
				(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		
		
	List<WebElement> cartAmountTotal=	driver.findElements(By.id
				("com.androidsample.generalstore:id/productPrice"));
	
	double Totalsum=0;
	for(int i=0;i<cartAmountTotal.size();i++)
	{
		
		String totalAmount=cartAmountTotal.get(i).getText();
		Double actualprice=Double.parseDouble(totalAmount.substring(1));//To remove the dollar in the price
		Totalsum=Totalsum+ actualprice;  //120+160.97=280.97
		
	}
	
	// Now validate the Sum is equal to actually produced
	String TotaldisplayAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	Double expectedprice=Double.parseDouble(TotaldisplayAmount.substring(1));
	
	
	Assert.assertEquals(Totalsum, expectedprice);
	
		
		
		
		
		
		
	}
	
	
	
}
