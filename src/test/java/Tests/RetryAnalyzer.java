package Tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	int maxRetries = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Retrying count: "+count);
		count++;
		
		if(count == maxRetries)
			return false;
		else
			return true;
	}

}
