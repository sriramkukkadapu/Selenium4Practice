package PDFExamples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPDFFromURLNov2022 {
    
  WebDriver driver;  
    
  @BeforeTest
  public void beforeTest() {
     System.out.println("Execution started...");
     WebDriverManager.chromedriver().setup(); 
     ChromeOptions co = new ChromeOptions();
     co.setHeadless(true);
     driver=new ChromeDriver(co); 
     driver.get("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
     //here you can use URL("file://...") url as well
  }
    
  @Test
  public void f() throws IOException {

	  /*========= We are using Apache PDFBox dependency ===========*/
	  
	  URL url = new URL("https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf");
	  
	  InputStream is = url.openStream();
	  BufferedInputStream bis = new BufferedInputStream(is);
	  PDDocument document = null;
	  
	  document = PDDocument.load(bis);
	  
	  //Content - method 1
	  String pdfContent = new PDFTextStripper().getText(document);
	   //System.out.println(pdfContent);
	  
	  //Page Count
	  int pageCount = document.getNumberOfPages();
	  System.out.println("No of pages: "+pageCount);
	  
	  //Page content/text - method 2
	  PDFTextStripper stripper = new PDFTextStripper();
	  String content = stripper.getText(document);
	  System.out.println(content);
	  
	  Assert.assertTrue(content.contains("PDF BOOKMARK SAMPLE "));
	  Assert.assertTrue(content.contains("^reformat trunc"));
	  Assert.assertTrue(content.contains("abmk command"));
	  Assert.assertTrue(content.contains("Place ap_bookmark.IFD"));
	  
	  
	  //Set the page number and get text from that particular page, here we ll get 3 & 4 pages contents
	  stripper.setStartPage(3);
	  content = stripper.getText(document);
	  System.out.println("====================");
      System.out.println(content);
	  Assert.assertTrue(content.contains("abmk command"));
      Assert.assertTrue(content.contains("Place ap_bookmark.IFD"));
	 
	  
//	  Assert.assertTrue(pdfContent.contains("Mechanics"));
//	  Assert.assertTrue(pdfContent.contains("zzzzz"));
	  
	  
	  
  }
  
  @AfterTest
  public void tearDown() {
      driver.quit();
  }
}
