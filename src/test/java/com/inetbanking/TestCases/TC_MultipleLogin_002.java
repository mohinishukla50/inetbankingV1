package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.XLUtils;

public class TC_MultipleLogin_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void multiLogin(String user, String pswd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pswd);
		logger.info("Password Provided");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		Thread.sleep(3000);
		
		if (isAlertPresent() == true) {
			
			driver.switchTo().alert().accept();// close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		} 
		else 
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			Thread.sleep(3000);
			lp.ClickLogout();
			logger.info("Logout button clicked");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close the logout alert
			driver.switchTo().defaultContent();
		}

	}

	
	
	public boolean isAlertPresent() // user defined method to check alert present or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1"); // total number of rows
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1); // total number of column
		String logindata[][] = new String[rowcount][colcount]; // total number of data to initialize array

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				// values are taken from excel sheet and saved in logindata
				// 0 0
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindata;
	}

}
