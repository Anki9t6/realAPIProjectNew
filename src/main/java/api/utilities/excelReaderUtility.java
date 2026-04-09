package api.utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelReaderUtility{
	@Test
	public static void readFile()throws IOException {
		System.out.println("Hello World");
		
		FileInputStream fis=new FileInputStream("C:/Users/ankit.sh/Downloads/APiTestCases (1).xlsx"); 
		XSSFWorkbook wb =new XSSFWorkbook(fis);	
		XSSFSheet sh=wb.getSheet("Sheet1");
	int totalRows=sh.getLastRowNum();//5
	System.out.println("Total rows are "+totalRows);
	int totalCells=sh.getRow(1).getLastCellNum();//7
	System.out.println("Total cells are "+totalCells);
	for(int r=0;r<=totalRows;r++) {
		XSSFRow rows=sh.getRow(r);
		for(int c=0;c<totalCells;c++) {
			XSSFCell cell=rows.getCell(c);
			System.out.println(cell.toString());
			
		}
	}
		wb.close();
		fis.close();
		
	}
	
}
