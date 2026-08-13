package iTestContextExample;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Class1 {
    
    
  @Test
  public void setCustomerId(ITestContext context) {
      context.setAttribute("cust_id", "sriramkukkadapu@gmail.com");
  }
  
}
