package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automation.base.TestBase;

public class ExcelUtility {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public void ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheetAt(0);
	}
	
	public int getRowCount() {
		int index = workbook.getSheetIndex(sheet);
		if(index==-1) {
			return 0;
		}
		else {
			int number = sheet.getLastRowNum();
			System.out.println("Row count is : "+number);
			return number;
		}
	}
	public int getColCount() {
		
		
		int index = workbook.getSheetIndex(sheet);
		if(index==-1) {
			return 0;
		}
		else {
			int number1 = row.getLastCellNum();
			System.out.println("Column count is : "+number1);
			return number1;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		ExcelUtility excel = new ExcelUtility();
		excel.ExcelReader(
				"C:\\Users\\ruchitat\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\excel\\TestData.xlsx");
		int rowCount = excel.getRowCount();
		excel.getColCount();
	}
}