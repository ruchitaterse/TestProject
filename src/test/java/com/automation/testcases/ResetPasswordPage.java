package com.automation.testcases;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.base.TestBase;

public class ResetPasswordPage extends TestBase {

	@Test
	public void resetPassword() throws IOException, InterruptedException {

		ResetPasswordPage reset = new ResetPasswordPage();
		WebElement forgotPswd = driver.findElement(By.linkText(or.getProperty("forgotPswdLinkText")));
		forgotPswd.click();
		log.debug("Clicked on forgot your password link...!!!");
		log.debug("Verifying title of reset password page after clicking on forgot password link...!!!");
		reset.verifyTitle();
		String textFile = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestDataLoginName.txt";
		
		FR = new FileReader(textFile);
		BR = new BufferedReader(FR);
		ArrayList<String> abc = new ArrayList<String>();
		String Content = null;
		int i = 0;
		while ((Content = BR.readLine()) != null) {
			abc.add(i, Content);
			driver.findElement(By.id(or.getProperty("loginNameID"))).sendKeys(abc.get(i));
			driver.findElement(By.name(or.getProperty("submitName"))).click();
			if(driver.findElement(By.id(or.getProperty("loginnameReqrd"))).isDisplayed() || driver.findElement(By.id(or.getProperty("invalidUserID"))).isDisplayed()) {
				if(driver.findElement(By.id(or.getProperty("loginnameReqrd"))).isDisplayed()) {
				System.err.println(driver.findElement(By.id(or.getProperty("loginnameReqrd"))).getText()+" : "+abc.get(i)+" Username can not be blank");
				Reporter.log("Username can not be blank");
				log.debug("Username can not be blank...!!!");
			}
				else {
					System.err.println(driver.findElement(By.id(or.getProperty("invalidUserID"))).getText()+" : "+abc.get(i));
					Reporter.log("Invalid username");
					log.debug("Invalid username...!!!");
				}
			
			}	
			
			driver.get("https://minervahrms.com/Planit/LoginForgotPassword.aspx");
			i++;
		}
		System.out.println(abc);
		System.out.println("Second element is : "+abc.get(2));
		
	}

	public void verifyTitle() {
		String Title = "	Reset Password";
		if (Title.contains(driver.getTitle())) {
			System.out.println("We are on reset password page...Please enter username to reset the password");
			log.debug("We are on reset password page");
		} else {
			System.out.println("Some error has occurred...!!!");
			log.debug("Some error has occurred...!!!");
		}
	}

}
