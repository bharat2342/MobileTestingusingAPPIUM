package TestNGTutorials;

import org.testng.annotations.Test;

public class AnnonatationsUsage 
{
	@Test
	public void demo()
	{
		System.out.println("hello");
		
	}
	
	
	@Test(groups={"Smoke"})
	public void demoSmoke()
	{
		System.out.println("SmokeDemoMustExecute");
		
	}

	

}
