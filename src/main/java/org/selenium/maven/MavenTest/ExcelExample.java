package org.selenium.maven.MavenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExample {
	
	public static void main(String[] args) throws IOException{
		
		File loc = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenTest\\TestData\\Selenium.xlsx");
		
		FileInputStream file = new FileInputStream(loc);
		
		Workbook wkbook = new XSSFWorkbook(file);
		
		Sheet s = wkbook.getSheet("Sheet1"); 
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			
			Row r = s.getRow(i);
			for(int j=0; j<r.getPhysicalNumberOfCells();j++) {
				Cell c = r.getCell(j);
//				System.out.println(c);
//				System.out.println(c.getCellType());
				if(c.getCellType()==1) {
					String cellType = c.getStringCellValue();
				System.out.println(cellType);
			}
				else if(c.getCellType()==0) {
					if(DateUtil.isCellDateFormatted(c)) {
						java.util.Date dateValue = c.getDateCellValue();
						SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
						String format = simple.format(dateValue);
						System.out.println(format);
					}
					else {
						double numericValue = c.getNumericCellValue();
						long l = (long)numericValue;
						String value = String.valueOf(l);
						System.out.println(value);
					}
					
				}
					
			}
		}
		
/*		Row r = s.getRow(0);
		Cell c = r.getCell(1);
		System.out.println(c);
		
		int type = c.getCellType();
		System.out.println(type);*/
		
		
		
		
	}

}
