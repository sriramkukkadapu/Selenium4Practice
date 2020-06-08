package Tests;

import org.testng.TestNG;

public class TestRunner {
	static TestNG testNG;
public static void main(String args[])
{
	testNG=new TestNG();
	testNG.setTestClasses(new Class[] {DriverTestNGTest.class});
	testNG.run();
}
}
