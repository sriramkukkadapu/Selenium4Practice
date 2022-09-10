package PDFExamples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadPDFFromURL {
  @Test
  public void f() throws IOException {
	  /*========= We are using Apache PDFBox dependency ===========*/
	  
	  URL url = new URL("http://www.africau.edu/images/default/sample.pdf");
	  InputStream is = url.openStream();
	  BufferedInputStream bis = new BufferedInputStream(is);
	  PDDocument document = null;
	  
	  document = PDDocument.load(bis);
	  String pdfContent = new PDFTextStripper().getText(document);
	  System.out.println(pdfContent);
	  
	  Assert.assertTrue(pdfContent.contains("Mechanics"));
	  Assert.assertTrue(pdfContent.contains("zzzzz"));
	  
  }
}
