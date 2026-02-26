package com.comcast.HMS.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * ExcelUtility class is used to perform Excel file operations.
 * 
 * This class provides reusable methods to:
 * 
 * 1. Read data from Excel file 2. Get row count from Excel sheet 3. Get cell
 * count from Excel sheet 4. Write data into Excel file
 * 
 * It uses Apache POI library to interact with Excel files. This utility
 * supports data-driven testing in Selenium framework.
 * 
 * Excel file location: ./HMS_DATA/AppData.xlsx
 * 
 * @author Mahan
 */
public class ExcelUtility {

	/**
	 * This method is used to read data from Excel file.
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return String (cell value)
	 * @throws Exception
	 */
	public String getData(String sheetName, int row, int cell) throws Exception {

		// Open Excel file
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");

		// Create Workbook object
		Workbook book = WorkbookFactory.create(file);

		// Read data from specified sheet, row, and cell
		String data = book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();

		// Close workbook
		book.close();

		// Return cell data
		return data;
	}

	/**
	 * This method is used to get total number of rows in a sheet.
	 * 
	 * @param sheet
	 * @return int (row count)
	 * @throws Exception
	 */
	public int getRowCount(String sheet) throws Exception {

		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");

		Workbook book = WorkbookFactory.create(file);

		// Get number of rows present in sheet
		int count = book.getSheet(sheet).getPhysicalNumberOfRows();

		book.close();

		return count;
	}

	/**
	 * This method is used to get total number of cells in first row of sheet.
	 * 
	 * @param sheet
	 * @return int (cell count)
	 * @throws Exception
	 */
	public int getCellCount(String sheet) throws Exception {

		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");

		Workbook book = WorkbookFactory.create(file);

		// Get number of cells in first row
		int count = book.getSheet(sheet).getRow(0).getPhysicalNumberOfCells();

		book.close();

		return count;
	}

	/**
	 * This method is used to create a new cell in Excel sheet. Used for writing
	 * data into Excel file.
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @throws Exception
	 */
	public void setDataIntoExcel(String sheetName, int row, int cell) throws Exception {

		// Open Excel file
		FileInputStream file = new FileInputStream("./HMS_DATA/AppData.xlsx");

		Workbook book = WorkbookFactory.create(file);

		// Create cell at specified location
		book.getSheet(sheetName).getRow(row).createCell(cell);

		// Write changes to Excel file
		FileOutputStream fos = new FileOutputStream("./HMS_DATA/AppData.xlsx");

		book.write(fos);

		book.close();
	}

}