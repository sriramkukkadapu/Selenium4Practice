package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtentReportsForFailedAndSuccessfulTests {
  @Test
  public void f() throws IOException {
	  
	  /*
	   * 
	   *  1. change viewing order
	   *  2. remove some menu
	   *  3. highlight a particular log line
	   *  4. list of strings how to log them
	   *  5. map<String,String> how to log it
	   * 
	   * 
	   * 
	   * 
	   * */
	  ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("index.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY} ).apply();
	  
	  //1 report for all the tests 
	  //1 reporter for failed tests
	  
	  ExtentSparkReporter failedSpark = new ExtentSparkReporter("failed-tests-index.html")
			  																.filter()
			  																.statusFilter()
			  																.as(new Status [] {Status.FAIL} )
			  																.apply();
	  
	  failedSpark.config().setDocumentTitle("Failed tests");
	  
	  final File CONF = new File("extentConfig.xml");
	  spark.loadXMLConfig(CONF);
	  
//	  spark.config().setTheme(Theme.DARK);
//	  spark.config().setDocumentTitle("Extent Report Example");
//	  spark.config().setReportName("Report Name");
	  
	  extent.attachReporter(spark,failedSpark);
	  
	  ExtentTest test =  extent.createTest("Login Tests").assignAuthor("Sriram K").assignCategory("Regression").assignDevice("Chrome"); //creates a test node
	  test.pass("Test started successfully"); //step
	  test.pass("URl is loaded"); //step
	  test.pass("Value is entered"); //step
	  test.pass("Test passed successfully"); //step
	  test.pass(MarkupHelper.createLabel("test.pass(\"Test passed successfully\"); ",ExtentColor.GREEN));
	  test.info("This is just a info"); //info
//	  test.skip("This is a skip"); //skip
	  
	  Arrays.asList(new String[]{"Selenium", "QTP", "Cypress"}).forEach(test::pass); //old way
	  test.pass(MarkupHelper.createUnorderedList(Arrays.asList(new String[]{"Selenium", "QTP", "Cypress"})).getMarkup());
	  test.pass(MarkupHelper.createOrderedList(Arrays.asList(new String[]{"Selenium", "QTP", "Cypress"})).getMarkup());
	  
	  Map<String,String> map=new HashMap<String,String>();
	  map.put("Automation Tool", "Selenium");
	  map.put("Code repository", "Github");
	  map.put("Management Tool", "JIRA");
	  map.forEach((k,v) -> test.pass(k +  ":" +v));
	  test.pass(MarkupHelper.createUnorderedList(map).getMarkup());
	  test.pass(MarkupHelper.createOrderedList(map).getMarkup());
	  
	  //debug fatal error options are removed
	  
	  ExtentTest test2 =  extent.createTest("Home page Tests").assignAuthor("Manju").assignCategory("Smoke").assignDevice("Firefox"); //creates a test node
	  test2.pass("Test started successfully"); //step
	  test2.pass("URl is loaded"); //step
	  test2.pass("Value is entered"); //step
	  test2.fail("Home page test failed"); //step
	  test.fail(MarkupHelper.createLabel("test.pass(\"Test passed successfully\"); ",ExtentColor.RED));
	  
	  extent.flush(); //writes the report at last with all the log data and execution info
	  
	  Desktop.getDesktop().browse(new File("index.html").toURI());
	  Desktop.getDesktop().browse(new File("failed-tests-index.html").toURI());
  }
}
