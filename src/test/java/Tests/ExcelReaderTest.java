package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReaderTest {
public static void main(String args[]) throws IOException {

	System.out.println(ExcelRead.getCellDataString(0, 0));
	
System.out.println(ExcelRead.getRowDataAsList(1));
}
}
