package Tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class iTestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Method Strat");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");
	}
}
