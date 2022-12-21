package TestNGTutorials;

import org.testng.annotations.Test;

public class GroupAnnotation 
{
	@Test(groups= {"Smoke"})
	public void webGroup1()
	{
		
		System.out.println("car login via Web");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileCarLoginLoan()
	{
		
		System.out.println("car login via Mobile");
	}

	@Test
	public void loginAPICarLogin()
	{
		System.out.println("car login via API restAssured");
		
	}
	
	
	

}
