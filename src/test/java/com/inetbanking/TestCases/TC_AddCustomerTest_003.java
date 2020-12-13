package com.inetbanking.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.AddCustPage;
import com.inetbanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void AddNewCust() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(10000);
		
		logger.info("Customer details added");
		AddCustPage addcust=new AddCustPage(driver);
		addcust.clickaddnewcustlink();
		addcust.addCustName("Mohini");
		addcust.CustGender("female");
		addcust.Custdob("04","10", "1998");
		Thread.sleep(3000);
		addcust.custAddr("INDIA");
		addcust.custCity("Mumbai");
		addcust.custState("MAHARASHTRA");
		addcust.custPIN(421204);
		addcust.custtelphno("9930449950");
		String email=Randomestring()+"@gmail.com";
		addcust.custEmail(email);
		addcust.custPassword("abc@123");
		addcust.ClickSubmit();
		Thread.sleep(3000);
		
		logger.info("Validation Started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res== true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed....");
			
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver, "addnewCustomer");
			logger.info("Test case failed....");

		}
		
		
	}
	
	//Generate random emailid
		public String Randomestring() {

			String generatedstring = RandomStringUtils.randomAlphanumeric(8);
			return (generatedstring);


	
}
}