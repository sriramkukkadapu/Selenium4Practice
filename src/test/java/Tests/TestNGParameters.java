package Tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

@Test
@Parameters({"browser"})
public void testMethod(String browserName) {
	System.out.println("Browser Name: "+browserName);
}

}
