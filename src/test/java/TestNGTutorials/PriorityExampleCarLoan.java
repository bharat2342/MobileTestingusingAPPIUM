package TestNGTutorials;

import org.testng.annotations.Test;

public class PriorityExampleCarLoan 
{
	
	
	@Test
	public void webCarLogin()
	{
		
		System.out.println("car login via Web");
	}
	
	@Test
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
