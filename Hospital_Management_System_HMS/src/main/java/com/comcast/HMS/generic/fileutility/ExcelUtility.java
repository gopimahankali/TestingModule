package com.comcast.HMS.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getData(String sheetName, int row, int cell) throws Exception {
		
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		String data = book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		book.close();
		
		return data;
	}
	
	public int getRowCount(String sheet) throws Exception {
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		int count = book.getSheet(sheet).getPhysicalNumberOfRows();
		book.close();
		
		return count;
		
		}
	
	public int getCellCount(String sheet) throws Exception {
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		int count = book.getSheet(sheet).getRow(0).getPhysicalNumberOfCells();
		book.close();
		
		return count;
	}
		
	
	public void setDataIntoExcel(String sheetName, int row, int cell) throws Exception{
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		book.getSheet(sheetName).getRow(row).createCell(cell);
		
		FileOutputStream fos = new FileOutputStream("./HMS_DATA/AppData.xlsx");
		book.write(fos);
		book.close();
		
	}

}
