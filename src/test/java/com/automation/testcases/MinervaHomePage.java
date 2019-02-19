package com.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;


public class MinervaHomePage extends TestBase{
	@Test(dataProvider="getDataProvider")
	public void homePage(String searchKeyword , String searchKey) {
		driver.findElement(By.id(or.getProperty("UsernameID"))).sendKeys(config.getProperty("ValidUserName"));
		driver.findElement(By.id(or.getProperty("passwordID"))).sendKeys(config.getProperty("ValidPassWord"));
		driver.findElement(By.id(or.getProperty("signInID"))).click();
		WebElement homepage = driver.findElement(By.id(or.getProperty("Home")));
		if(homepage.isDisplayed()) {
			System.out.println("We are on Home Page");
			log.debug("We are on Home Page...!!!");
			int i=1;
			if(searchKeyword != null && searchKey != null) {
			WebElement getText = driver.findElement(By.id(or.getProperty("inputText")));
			getText.sendKeys(searchKeyword);
			WebElement search = driver.findElement(By.id(or.getProperty("searchButtonID")));
			search.click();
			String Title ="Search Colleagues";
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains(Title)) {
				System.out.println("We are redirected to search result page");
				log.debug("We are redirected to search result page...!!!");
				WebElement table = driver.findElement(By.id(or.getProperty("searchResultTable")));
				List<WebElement> row = table.findElements(By.className("dxgvDataRow_Glass"));
				int rows = table.findElements(By.className("dxgvDataRow_Glass")).size();
				System.out.println(rows);
				List<WebElement> col = table.findElements(By.className("dxgv"));
				
				for(WebElement object : col) {
					System.out.println(object.getText());
				}
			
				int columns = col.size();
				System.out.println(columns);
			}else {
				System.out.println("Some error as occurred");
			}
			//homepage.click();
			}
		}
		else {
			System.out.println("Some error occurred");
		}
		
	}

	
	
	
}
