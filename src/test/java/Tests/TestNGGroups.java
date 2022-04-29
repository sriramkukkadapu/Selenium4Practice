package Tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGGroups {

@Test(groups= {"smoke"})
@Parameters({"browser"})
public void smoke1(String browserName) {
	System.out.println("smoke test 1");
}

@Test(groups= {"smoke"})
@Parameters({"browser"})
public void smoke2(String browserName) {
	System.out.println("smoke test 2");
}

@Test(groups= {"regression"})
@Parameters({"browser"})
public void reg1(String browserName) {
	System.out.println("reg test 1");
}

@Test(groups= {"regression"})
@Parameters({"browser"})
public void reg2(String browserName) {
	System.out.println("reg test 2");
}

}
