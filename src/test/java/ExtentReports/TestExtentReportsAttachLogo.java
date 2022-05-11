package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtentReportsAttachLogo {

	/*
	 * 1. Attach log
	 * 2. Part II - how to use config files to setup extent report
	 * 
	 * */
	
@Test
  public void f() throws IOException {
	  ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
	  
	  final File CONF = new File("extentConfig.xml");
	  spark.loadXMLConfig(CONF);
	  
	  extent.attachReporter(spark);
	  
	  ExtentTest test =  extent.createTest("First Test");
	  test.pass("Test started");
	  test.pass("Test Finished");
	 
	  
	  extent.flush(); //writes the report at last with all the log data and execution info
	 
	  Desktop.getDesktop().browse(new File("index.html").toURI());
  }
}
