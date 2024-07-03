package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fs = new FileInputStream(src);

			XSSFWorkbook wb = new XSSFWorkbook(fs);
		} catch (Exception e) {
			System.out.println("Unable to read excel file" + e.getMessage());

		}

	}
	public String getStringData(int sheetindex, int row, int cell) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int cell) {
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int cell) {
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}	

}
