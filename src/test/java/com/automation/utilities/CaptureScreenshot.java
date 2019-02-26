package com.automation.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.base.TestBase;

public class CaptureScreenshot extends TestBase {
	
	 public static void takeSnapShot(String fileName) throws Exception{
		 	String fileName1 = "error.png";
		String filePath=System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+fileName1;
	        TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(filePath);
            FileUtils.copyFile(SrcFile, DestFile);
            System.out.println("Screenshot captured at mentioned location : "+filePath);
          
            
	    }

	}

