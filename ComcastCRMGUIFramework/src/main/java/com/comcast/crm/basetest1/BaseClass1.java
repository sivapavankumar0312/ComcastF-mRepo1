package com.comcast.crm.basetest1;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.dbutility.DataBaseUtilty;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;

public class BaseClass1 {
	public DataBaseUtilty db=new DataBaseUtilty();
	public FileUtility fu=new FileUtility();
	public WebDriver driver=null;
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtlity ju=new JavaUtlity();
	public static WebDriver sdriver=null;
	
	
	
	public WebDriverUtliity wu=new WebDriverUtliity();
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("connect to DB,Report Config");
	db.getDbconnection("jdbc:mysql://localhost:3306/games", "root", "root");
	
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("Launch Browser");
		String BROWSER=fu.getDataFromPropertiesFile("browser");
				//fu.getDataFromPropertiesFile("browser");

		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();	
		
	}
	sdriver=driver;
	UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod
	public void configBM() throws IOException {
		wu.waitForPageTOLoad(driver);
		String URL=fu.getDataFromPropertiesFile("url");
		driver.get(URL);
		System.out.println("login to app");
		LoginPage lp=new LoginPage(driver);
		String USERNAME=fu.getDataFromPropertiesFile("username");
		String PASSWORD=fu.getDataFromPropertiesFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
		
	}
	@AfterMethod
	public void configAM() {
		System.out.println("logout");
		 HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	@AfterClass
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("close DB,Report backup");
		db.closeDbconnection();
		
	}
	
}
