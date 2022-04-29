package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryAnalyzer {

@Test(retryAnalyzer = RetryAnalyzer.class)
public void testMethod() {
	Assert.assertEquals(false, true);
}

@Test
public void testMethod2() {
	Assert.assertEquals(false, true);
}

}
