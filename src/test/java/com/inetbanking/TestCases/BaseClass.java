package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("e-banking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			logger.info("Chrome opened");

		}

		else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("Firefox opened");

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		//driver.manage().window().maximize();
		logger.info("URL is opened");
		
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;// calls the driver that can capture the screenshot
		File source=ts.getScreenshotAs(OutputType.FILE);//captures the screenshot and store it in temporary file
		File target=new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname +".png");//create new file
		FileUtils.copyFile(source, target); //copy file from source to target permanently
		System.out.println("Screenshot taken");
	}

}
