package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(iTestListener.class)
public class TestNGTestListener {

@Test()
public void testMethod() {
	//Assert.assertEquals(false, true);
	System.out.println("========================");
	System.out.println("Test method getting executed");
	System.out.println("========================");
}


}
