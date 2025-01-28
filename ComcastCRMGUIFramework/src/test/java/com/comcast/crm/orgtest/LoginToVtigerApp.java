package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.LoginPage;

public class LoginToVtigerApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
Properties p=new Properties();
p.load(fis);
String BROWSER=p.getProperty("browser");
String URL=p.getProperty("url");
String USERNAME=p.getProperty("username");
String PASSWORD=p.getProperty("password");*/
		FileUtility fu=new FileUtility();
		String BROWSER=fu.getDataFromPropertiesFile("browser");
		String URL=fu.getDataFromPropertiesFile("url");
		String USERNAME=fu.getDataFromPropertiesFile("username");
		String PASSWORD=fu.getDataFromPropertiesFile("password");

WebDriver driver=null;
if(BROWSER.equals("chrome"))
	driver= new ChromeDriver();
else if(BROWSER.equals("firefox"))
	driver=new FirefoxDriver();
else
	driver=new ChromeDriver();	
WebDriverUtliity wdv=new WebDriverUtliity();
wdv.waitForPageTOLoad(driver);
driver.get(URL);
LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);
/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();*/
String title=driver.getTitle();
if(title.contains("Home"))
	System.out.println("home page" + "is displayed");
else 
	System.out.println("home page" + "is not displayed");
	
driver.quit();
	}

}
