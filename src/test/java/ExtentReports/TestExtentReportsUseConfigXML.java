package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtentReportsUseConfigXML {
  @Test
  public void f() throws IOException {
	  ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
	  
	  final File CONF = new File("extentConfig.xml");
	  spark.loadXMLConfig(CONF);
	  
//	  spark.config().setTheme(Theme.DARK);
//	  spark.config().setDocumentTitle("Extent Report Example");
//	  spark.config().setReportName("Report Name");
	  
	  extent.attachReporter(spark);
	  
	  ExtentTest test =  extent.createTest("Login Tests").assignAuthor("Sriram K").assignCategory("Regression").assignDevice("Chrome"); //creates a test node
	  test.pass("Test started successfully"); //step
	  test.pass("URl is loaded"); //step
	  test.pass("Value is entered"); //step
	  test.pass("Test passed successfully"); //step
	  test.info("This is just a info"); //info
//	  test.skip("This is a skip"); //skip
	  
	  //debug fatal error options are removed
	  
	  
	  ExtentTest test2 =  extent.createTest("Home page Tests").assignAuthor("Manju").assignCategory("Smoke").assignDevice("Firefox"); //creates a test node
	  test2.pass("Test started successfully"); //step
	  test2.pass("URl is loaded"); //step
	  test2.pass("Value is entered"); //step
	  test2.fail("Home page test failed"); //step
	  
	  extent.flush(); //writes the report at last with all the log data and execution info
	  
  }
}
