package wdMethods;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcel {

	public static Object[][] getdata(String filename) throws IOException {
		// TODO Auto-generated method stub
	XSSFWorkbook book=new XSSFWorkbook("./data/"+filename+".xlsx");
         XSSFSheet sheet = book.getSheet("createlead");
         int lastrow = sheet.getLastRowNum();
         int column = sheet.getRow(0).getLastCellNum();
         Object[][] data=new Object[lastrow][column];
        for(int i=1;i<=lastrow;i++) {
         XSSFRow row = sheet.getRow(i);
         for(int j=0;j<column;j++) {
        	XSSFCell cell = row.getCell(j);
        	String value = cell.getStringCellValue();
        	data[i-1][j]=value;
        	 System.out.println(value);
	
         }
         
	}
return data;
}
}
