package com.comcast.crm.contacttest1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtlity;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.CreateContactPage;
import com.comcast.crm.objectrepositoryutilty.CreatedContactInfoPage;
import com.comcast.crm.objectrepositoryutilty.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutilty.CreatingNewOrganizatonPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;
import com.comcast.crm.objectrepositoryutilty.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutilty.OrganzationsPage;

public class CreateContactWithOrg1 extends BaseClass {
@Test
	public  void createContactWithOrg1() throws EncryptedDocumentException, IOException {
	
		// TODO Auto-generated method stub
		/*FileInputStream fis = new FileInputStream("C:\\Users\\home\\Desktop\\data\\commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");*/
		
		//FileUtility flib=new FileUtility();
		//ExcelUtility eu=new ExcelUtility();
		//JavaUtlity ju=new JavaUtlity();
		//String BROWSER=flib.getDataFromPropertiesFile("browser");
		//String URL=flib.getDataFromPropertiesFile("url");
	//	String USERNAME=flib.getDataFromPropertiesFile("username");
		//String PASSWORD=flib.getDataFromPropertiesFile("password");

		
        //read testscript data from excel file
		/*FileInputStream fis1 = new FileInputStream("C:\\Users\\home\\Desktop\\data\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(1);
		String  orgName= row.getCell(2).toString();*/
		//String contactLastName = row.getCell(4).toString();
		String Name=eu.getDataFromExcel("org", 1, 2);
		int num=ju.getRandomNum();
		String orgName=Name+""+num;
		String lastName=eu.getDataFromExcel("contact", 1, 4)+ju.getRandomNum();
	
	/*	WebDriver driver=null;
		if(BROWSER.equals("chrome"))
			driver= new ChromeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();	
		
		
		
		 
		 
		 //Step 1: Login to app
		 /*driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		  
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();*/
	//	WebDriverUtliity wdv=new WebDriverUtliity();
		//wdv.waitForPageTOLoad(driver);
		//driver.get(URL);
		//LoginPage lp=new LoginPage(driver);
	//	lp.loginToApp(USERNAME,PASSWORD);
		
		  
		  //Step 2: navigate to organization module
		 // driver.findElement(By.linkText("Organizations")).click();
		
		
		HomePage hp=new HomePage(driver);
		hp.getorgLink().click();
		
		  
		  //Step 3: click on "create Organization" button
		  //driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrganzationsPage op=new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();
		  
		  //step 4: enter all the details & create new organization
		 // driver.findElement(By.name("accountname")).sendKeys(orgName);
		CreatingNewOrganizatonPage cnop=new CreatingNewOrganizatonPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
	
		//  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
cnop.getSaveBtn().click();
		  //verify Header phone number info Expected Result
         /* String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(headerInfo.contains(orgName)) {
			  System.out.println(orgName + " is created==>Pass");
		  }else {
			  System.out.println(orgName + " is not created==>Fail");
		  }*/
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String actOrgName=oip.getHeadermsg().getText();
if(actOrgName.contains(orgName))
	System.out.println(orgName+" is verified tcpass");
else
	System.out.println(orgName+" is notverified tcfail");

			 
		  //Step 5: navigate to contact module
		 //driver.findElement(By.linkText("Contacts")).click();
         hp.getContactLink().click();
     
     
     
		  
		  //Step 6: click on "create Contact" button
		 //driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
CreateContactPage ccp=new CreateContactPage(driver);
ccp.getCreateContactLink().click();
CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
cncp.createContactWithOrg(driver, orgName, lastName);

		  
		  //Step 7: click on "create Contact" button
	      //driver.findElement(By.name("lastname")).sendKeys(lastName);
//ccp.getCreatelastName().sendKeys(lastName);
	     // driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	      
	      //switch to child window
	    /*  Set<String> set = driver.getWindowHandles();
	      Iterator<String> it= set.iterator();
	      
	      while(it.hasNext()) {
	    	String windowID = it.next();
	    	  driver.switchTo().window(windowID);
	    	  
	    	  
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
	      }
	      
	      driver.findElement(By.name("search_text")).sendKeys(orgName);
	      driver.findElement(By.name("search")).click();
	      driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	      
	      //switch to parent window
	      Set<String> set1 = driver.getWindowHandles();
	      Iterator<String> it1= set1.iterator();
	      
	      while(it1.hasNext()) {
	    	String windowID = it1.next();
	    	  driver.switchTo().window(windowID);
	    	  
	    	  
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("Contacts&action")) {
				break;
			}
	      }

	      
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		  
		//verify Header msg expected result
CreatedContactInfoPage ccip=new CreatedContactInfoPage(driver);
		   String actheaderInfo = ccip.getVerifylastName().getText();
		  if(actheaderInfo.contains(lastName)) {
			  System.out.println(lastName + " is verified==>Pass");
		  }else {
			  System.out.println(lastName + " is not verified==>Fail");
		  }
		  
		//verify Header orgName expected result
	  String actOrgName1 = ccip.getVerifyOrgName().getText();
	  System.out.println(actOrgName1);
		  if(actOrgName1.trim().equals(orgName)) {
			  System.out.println(orgName + " is created==>Pass");
	  }else {
		  System.out.println(orgName + " is not created==>Fail");
	  }
		  
		   //Step 8:Logout
			
		 
		  
	}


	}

