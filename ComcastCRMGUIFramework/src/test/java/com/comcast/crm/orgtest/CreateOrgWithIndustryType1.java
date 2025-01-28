package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.CreatingNewOrganizatonPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;
import com.comcast.crm.objectrepositoryutilty.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutilty.OrganzationsPage;

public class CreateOrgWithIndustryType1 extends BaseClass {
@Test

	public  void createOrgWithIndustryType1() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		/*FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");*/
		
		//FileUtility fu=new FileUtility();
		//String BROWSER=fu.getDataFromPropertiesFile("browser");
		//String URL=fu.getDataFromPropertiesFile("url");
		//String USERNAME=fu.getDataFromPropertiesFile("username");
		//String PASSWORD=fu.getDataFromPropertiesFile("password");

		//read ts data from excel
	/*	FileInputStream fis1=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("org");
		Row row=sh.getRow(1);
		String orgName=row.getCell(2).toString();
		String indName=row.getCell(3).toString();
		book.close();*/
		//ExcelUtility eu=new ExcelUtility();
		String Name=eu.getDataFromExcel("org", 4, 2);
		//JavaUtlity ju=new JavaUtlity();
		int num=ju.getRandomNum();
		String orgName=Name+num;
		String Name1=eu.getDataFromExcel("org", 4, 3);
		String industry=Name1;
		String type=eu.getDataFromExcel("org", 4, 4);


	/*	WebDriver driver=null;
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
		lp.loginToApp("admin","admin");*/
		HomePage hp=new HomePage(driver);
		hp.getorgLink().click();
		//driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrganzationsPage op=new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//op.getCreateneworgName().sendKeys(orgName);
		//Select s=new Select(driver.findElement(By.name("industry")));
		//s.selectByIndex(2);
				CreatingNewOrganizatonPage cnop=new CreatingNewOrganizatonPage(driver);
				//cnop.getIndustrydd();
				cnop.createOrg(orgName, industry, type);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



		//String text=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		//String text1=driver.findElement(By.id("mouseArea_Industry")).getText();
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String text=oip.getHeaderorgan();
				String text1=oip.getHeaderInd();

		if(text.contains(orgName))
			System.out.println("Organization" + "is created");
		else 
			System.out.println("Organization" + "is not created");
		if(text1.equals(industry))
			System.out.println("INdustry type is created");
		else
			System.out.println("INdustry type is not created");
		
		
	
		

	}

}
