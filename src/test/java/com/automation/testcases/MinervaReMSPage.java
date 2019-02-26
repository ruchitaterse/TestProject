package com.automation.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.TestBase;

public class MinervaReMSPage extends TestBase {

	/**
	 * @throws Exception
	 */
	@Test()
	public void remsPage() throws Exception {
		driver.findElement(By.id(or.getProperty("UsernameID"))).sendKeys(config.getProperty("ValidUserName"));
		driver.findElement(By.id(or.getProperty("passwordID"))).sendKeys(config.getProperty("ValidPassWord"));
		driver.findElement(By.id(or.getProperty("signInID"))).click();
		Actions action = new Actions(driver);
		// WebElement rems = driver.findElement(By.xpath(or.getProperty("remsXpath")));
		WebElement rems = driver.findElement(By.id(or.getProperty("remsID")));
		action.moveToElement(rems).click().perform();
		WebElement fillTimesheet = driver.findElement(By.id(or.getProperty("fillTimesheet")));
		action.moveToElement(fillTimesheet).click().perform();
		WebElement selectOption = driver.findElement(By.name(or.getProperty("selectOption")));
		Select s = new Select(selectOption);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		s.selectByValue("2");
		WebElement errormsg = driver.findElement(By.id(or.getProperty("errorMsg")));
		System.err.println(errormsg.getText());
		WebElement cancel = driver.findElement(By.id(or.getProperty("cancel")));
		cancel.click();
		
	}

}
