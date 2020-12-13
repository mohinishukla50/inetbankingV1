package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustPage {

	WebDriver ldriver;

	public AddCustPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement NewCustomerlink;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustname;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelphno;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement password;


	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	WebElement btnsubmit;

	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement btnreset;

	public void clickaddnewcustlink() {
		NewCustomerlink.click();//click on the new customer link on homepage
	}
	
	public void addCustName(String cname) {
		txtCustname.sendKeys(cname);
	}
	
	public void CustGender(String cgender) {
		rdGender.click();
		}
	
	public void Custdob(String mm,String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddr(String address) {
		txtaddress.sendKeys(address);
	}
	
	public void custCity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void custState(String state) {
		txtState.sendKeys(state);
	}
	
	public void custPIN(int cPIN) {
		txtPin.sendKeys(String.valueOf(cPIN)); //convert int to string as sendkeys accept values in string form
	}
	
	public void custtelphno(String telphno) {
		txttelphno.sendKeys(telphno);
	}
	
	public void custEmail(String email) {
		txtemailid.sendKeys(email);
	}
	
	public void custPassword(String paswd) {
		password.sendKeys(paswd);
	}

	public void ClickSubmit() {
		btnsubmit.click();
	}
	
	public void ClickReset() {
		btnreset.click();
		
	}
}
