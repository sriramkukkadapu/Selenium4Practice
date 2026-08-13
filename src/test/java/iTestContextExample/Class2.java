package iTestContextExample;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Class2 {
    
    
  @Test
  public void getCustomerId(ITestContext context) {
      System.out.println("CustomerId : "+context.getAttribute("cust_id"));
  }
  
}
