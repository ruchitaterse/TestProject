package com.automation.testcases;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.utilities.CaptureScreenshot;

public class MinervaHomePage extends TestBase {
	
	@Test()
	public void homePage() throws Exception {
		driver.findElement(By.id(or.getProperty("UsernameID"))).sendKeys(config.getProperty("ValidUserName"));
		driver.findElement(By.id(or.getProperty("passwordID"))).sendKeys(config.getProperty("ValidPassWord"));
		driver.findElement(By.id(or.getProperty("signInID"))).click();
		
		WebElement homepage = driver.findElement(By.id(or.getProperty("Home")));
		if (homepage.isDisplayed()) {
			System.out.println("We are on Home Page");
			log.debug("We are on Home Page...!!!");

			String textFile = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestDataSearch.txt";
			FR = new FileReader(textFile);
			BR = new BufferedReader(FR);
			ArrayList<String> abc = new ArrayList<String>();
			String Content = null;
			int i = 0;
			while ((Content = BR.readLine()) != null) {
				abc.add(i, Content);

				WebElement getText = driver.findElement(By.id(or.getProperty("inputText")));
				getText.sendKeys(abc.get(i));
				System.out.println("We are searching for : "+abc.get(i));
				WebElement search = driver.findElement(By.id(or.getProperty("searchButtonID")));
				search.click();
				String Title = "Search Colleagues";
				if (driver.getTitle().contains(Title)) {
					System.out.println("We are redirected to search result page");
					log.debug("We are redirected to search result page...!!!");

					try {
						if (driver.findElement(By.xpath(or.getProperty("errorText"))).isDisplayed()
								|| driver.findElement(By.className("dxgvDataRow_Glass")).isDisplayed()) {

							if (driver.findElement(By.xpath(or.getProperty("errorText"))).isDisplayed()) {
								System.out.print("Result for : ");
								System.err.println(abc.get(i));
								System.err.println(driver.findElement(By.xpath(or.getProperty("errorText"))).getText()+" Please enter valid data");
							}
						}
					} catch (Exception e) {
						
						System.out.println("Result for : "+abc.get(i));
						CaptureScreenshot.takeSnapShot("error.png");
						
						
					}

				}
				Assert.fail("Failed");
				driver.findElement(By.id(or.getProperty("Home"))).click();
			}
			
		}

	}
}