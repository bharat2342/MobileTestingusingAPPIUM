package TestNGTutorials;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriorityExampleHomeLoan 
{

	@Test
	public void webHomeLoanLogin()
	{
		
		System.out.println("HomeLoan login via Web");
	}
	
	@Test(groups= {"Smoke"})
	public void MobileHomeLoanLogin()
	{
		
		System.out.println("HomeLoan login via Mobile");
	}

	@Parameters({"Base URL"}) //Only this particular Test method only
	@Test
	public void loginAPIHomeLoanLogin(String urlname)
	{
		System.out.println("HomeLoan via API restAssured");
		System.out.println(urlname);
		
	}
	
	
	

}
