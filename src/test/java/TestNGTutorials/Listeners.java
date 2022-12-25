package TestNGTutorials;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

//iTestListerners is an interface which Implements TestNG listerners
public class Listeners implements ITestListener
{
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("I successfully executed the test");
			
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		//So here it is reaching whenever it is failed
		//result.getName() will get which test is failing
		System.out.println("It failed the test" + result.getName());
			
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
