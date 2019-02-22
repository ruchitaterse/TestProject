package com.automation.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.base.TestBase;

public class CaptureScreenshot extends TestBase {
	
	 public static void takeSnapShot(WebDriver driver, String filePath) throws Exception{

	        TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(filePath);
            
            FileUtils.copyFile(SrcFile, DestFile);
            
	    }


	}

