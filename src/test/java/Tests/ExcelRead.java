package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static String getCellDataString(int rowNo,int cellNo) throws IOException {
	
		String	data=null;
		
		FileInputStream fis = new FileInputStream("excelData/Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheet("loginData");
		Row row= sh.getRow(rowNo);
		Cell cell= row.getCell(cellNo);
		return cell.getStringCellValue();
	
	}
	
	public static Object[][] getEntireSheetData() throws IOException{
		
		Object[][] object;
		FileInputStream fis = new FileInputStream("excelData/Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheet("loginData");
		System.out.println("========>"+sh.getLastRowNum());
		System.out.println("========>"+sh.getFirstRowNum());
		int n = sh.getLastRowNum()-sh.getFirstRowNum();
		object = new Object[n][2];
		
		for(int i=1;i<=n;i++) {
			String username = getCellDataString(i,0);
			String password = getCellDataString(i, 1);
			object[i-1][0] = (Object) username;
			object[i-1][1] = (Object) password;
		}
		
		return object;
		
	}
	
public static ArrayList<String> getRowDataAsList(int rowNo) throws IOException{
		
		ArrayList<String> list=new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("excelData/Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheet("loginData");
		Row row= sh.getRow(rowNo);
		Cell cell;
		for(int i=0;i<2;i++) {
			cell = row.getCell(i);
			String cellValue = cell.getStringCellValue();
			list.add(cellValue);
		}
		
		return list;
	}
}
