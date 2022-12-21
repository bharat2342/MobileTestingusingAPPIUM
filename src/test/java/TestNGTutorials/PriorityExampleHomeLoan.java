package TestNGTutorials;

import org.testng.annotations.Test;

public class PriorityExampleHomeLoan 
{

	@Test
	public void webHomeLoanLogin()
	{
		
		System.out.println("HomeLoan login via Web");
	}
	
	@Test
	public void MobileHomeLoanLogin()
	{
		
		System.out.println("HomeLoan login via Mobile");
	}

	@Test
	public void loginAPIHomeLoanLogin()
	{
		System.out.println("HomeLoan via API restAssured");
		
	}
	
	
	

}
