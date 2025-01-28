package com.comcast.crm.basetest;

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
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.dbutility.DataBaseUtilty;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;

public class BaseClass {
	public DataBaseUtilty db=new DataBaseUtilty();
	public FileUtility fu=new FileUtility();
	public WebDriver driver=null;
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtlity ju=new JavaUtlity();
	
	public WebDriverUtliity wu=new WebDriverUtliity();
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("connect to DB,Report Config");
	db.getDbconnection("jdbc:mysql://localhost:3306/games", "root", "root");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(String browser) throws IOException {
		System.out.println("Launch Browser");
		String BROWSER=browser;
				//fu.getDataFromPropertiesFile("browser");

		if(BROWSER.equals("chrome"))
			driver= new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();	
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
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
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("logout");
		 HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close DB,Report backup");
		db.closeDbconnection();
	}
	
}
