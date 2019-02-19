package com.automation.rough;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;

public class TestProperties extends TestBase{


			@Test(dataProvider="getDataProvider")
			public void getF(String Username, String password) {
				System.out.println(Username);
				System.out.println(password);
			}
		
			@DataProvider
			public Object[][] getDataProvider(){
			Object[][] data = new Object[2][2];
			data[0][0]="rulihilk";
			data[0][1]="chjkhkjh";
			data[1][0]="itj,gk,kj";
			data[1][1]="aajkhjkhjk";
			for (int i = 0; i < 2; i++) { 
			
				for (int j = 0; j < 2; j++) {
					
					System.out.println(data[i][j]);
					j++;
					System.out.println(data[i][j]);
					j++;
				}
			}
			return data;
	}
	}



