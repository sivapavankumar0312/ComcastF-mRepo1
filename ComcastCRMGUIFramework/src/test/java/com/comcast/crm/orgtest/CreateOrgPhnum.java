package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.CreatingNewOrganizatonPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;
import com.comcast.crm.objectrepositoryutilty.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutilty.OrganzationsPage;

public class CreateOrgPhnum {
public static void main(String[] args) throws IOException {
	FileUtility fu = new FileUtility();
	ExcelUtility eu = new ExcelUtility();
	JavaUtlity Ju = new JavaUtlity();
	WebDriverUtliity wdv = new WebDriverUtliity();
	
	String BROWSER = fu.getDataFromPropertiesFile("browser");
	String URL= fu.getDataFromPropertiesFile("url");
	String USERNAME = fu.getDataFromPropertiesFile("username");
	String PASSWORD= fu.getDataFromPropertiesFile("password");
	
	String org =	eu.getDataFromExcel("org", 1, 2)+Ju.getRandomNum();
	String phn =	eu.getDataFromExcel("org", 1, 5);
	
		
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
		driver= new ChromeDriver();
	else if(BROWSER.equals("firefox"))
		driver=new FirefoxDriver();
	else
		driver=new ChromeDriver();	


	wdv.waitForPageTOLoad(driver);
	driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getorgLink().click();
		
		OrganzationsPage op=new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();
		

		
		CreatingNewOrganizatonPage cnop = new CreatingNewOrganizatonPage(driver);
		cnop.creatingNewOrg(org, phn);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeadermsg().getText();
		if(actOrgName.contains(org))
			System.out.println(org+" is verified tcpass");
		else
			System.out.println(org+" is notverified tcfail");
		String act_ph=cnop.getVerifyphno().getText();
		if(act_ph.equals(phn))
			System.out.println(phn+" is verified tcpass");
		else
			System.out.println(phn+" is not verified tcpass");
	
	hp.logout(driver);
	driver.quit();

	

}
}
