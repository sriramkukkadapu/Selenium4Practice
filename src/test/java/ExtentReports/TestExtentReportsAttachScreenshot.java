package ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtentReportsAttachScreenshot {

	/*
	 * 1. png, jpg file -> attach to report
	 * 2. convert image to base64 and attach to report
	 * 3. take screenshot as base64 and attach to report (Best way)
	 * 
	 * */
	
	ExtentReports extent;
	ExtentSparkReporter spark ;
	WebDriver driver;
	
@BeforeSuite
public void beforeSetup() throws IOException {
	extent = new ExtentReports();
	spark = new ExtentSparkReporter("index.html");
	  
	  final File CONF = new File("extentConfig.xml");
	  spark.loadXMLConfig(CONF);
	  
	  extent.attachReporter(spark);
}
	
@Test
  public void f() throws IOException, InterruptedException {
	  
	  ExtentTest test =  extent.createTest("First Test");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  test.pass("Test Started");
	  
	  driver.get("https://www.google.co.in");
	  driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
	  Thread.sleep(2000);
//	  test.pass("Attaching image directly", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotPath()).build());
//	  test.pass("Attaching image as Base 64 image bytes", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	  test.pass("Attaching image as Base 64 image bytes - OutputType.BASE64", MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64()).build());
	  test.pass("Test finished");
	  
  }


@AfterSuite
public void afterSuite() throws IOException {
	 extent.flush(); //writes the report at last with all the log data and execution info
	 
	  Desktop.getDesktop().browse(new File("index.html").toURI());
	  
	  driver.quit();
}

public String getScreenshotPath() throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/images/screenshot.png";
	FileUtils.copyFile(src, new File(path));
	return path;
}

public String getScreenshotAsBase64() throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/images/screenshot.png";
	FileUtils.copyFile(src, new File(path));
	byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
	
	return Base64.getEncoder().encodeToString(imageBytes);
}

public String geBase64() throws IOException
{
	return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
}

}
