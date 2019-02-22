package com.automation.testcases;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.utilities.ExcelUtility;

public class MinervaLoginPage extends TestBase {

	@Test
	public void loginPage() throws IOException {
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestData.xlsx";
		String fileName = "TestData.xlsx";
		String sheetName = "LoginPage";
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){
			workbook = new XSSFWorkbook(inputStream);

	    }
		else if(fileExtensionName.equals(".xls")){
			workbook = new HSSFWorkbook(inputStream);

	    }
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		int i = 0;
		log.debug("Inside Login Test...!!!");
		for (i = 0; i <= rowCount; i++) {
			driver.get(config.getProperty("Url"));
			WebElement userName = driver.findElement(By.id(or.getProperty("UsernameID")));
			WebElement passWord = driver.findElement(By.id(or.getProperty("passwordID")));

			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				userName.sendKeys(row.getCell(j).getStringCellValue());
				j++;

				passWord.sendKeys(row.getCell(j).getStringCellValue());

				WebElement signIn = driver.findElement(By.id(or.getProperty("signInID")));
				signIn.click();
				String Title = "	Home Page";

				if (Title.contains(driver.getTitle())) {
					System.out.println("Login successful");
					log.debug("Login successful...!!!");
				} else if (driver.findElement(By.id(or.getProperty("loginNameReqrd"))).isDisplayed()) {
					log.debug("Username & Password can not be blank");
					System.out.print(driver.findElement(By.id(or.getProperty("loginNameReqrd"))).getText() + " and ");
					System.err.println(" " + driver.findElement(By.id(or.getProperty("pswdReqrd"))).getText()
							+ " : Username & Password can not be blank");
				} else {
					log.debug("Invalid Credentials...Please try again later");
					WebElement invalidMsg = driver.findElement(By.id(or.getProperty("invalidloginMsg")));
					System.err.println(invalidMsg.getText());
				}

			}

		}

	}
	

	

}
