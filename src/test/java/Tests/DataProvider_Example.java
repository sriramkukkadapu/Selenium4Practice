package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Example {


@DataProvider
public Object[][] dataProvider() throws IOException {
	Object[][] obj;
	
	obj=ExcelRead.getEntireSheetData();
	
	return obj;
}
	
@Test(dataProvider = "dataProvider")
public void testDataProvider(String username, String password) {
	System.out.println(username+"    "+password);
}

	
	
}
