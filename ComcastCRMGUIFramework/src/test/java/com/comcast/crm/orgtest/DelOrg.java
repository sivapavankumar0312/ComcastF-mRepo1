package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
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

public class DelOrg {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	/*	FileInputStream fis=new FileInputStream("./configAppData/commondata.properties.txt");
Properties p=new Properties();
p.load(fis);
String BROWSER=p.getProperty("browser");
String URL=p.getProperty("url");
String USERNAME=p.getProperty("username");
String PASSWORD=p.getProperty("password");*/
//read ts data from excel
FileUtility fu=new FileUtility();
String BROWSER=fu.getDataFromPropertiesFile("browser");
String URL=fu.getDataFromPropertiesFile("url");
String USERNAME=fu.getDataFromPropertiesFile("username");
String PASSWORD=fu.getDataFromPropertiesFile("password");


/*FileInputStream fis1=new FileInputStream("./testdata/testscriptdata.xlsx");
Workbook book=WorkbookFactory.create(fis1);
Sheet sh=book.getSheet("org");
Row row=sh.getRow(1);
String orgName=row.getCell(2).toString();
book.close(); */

ExcelUtility eu=new ExcelUtility();
String Name=eu.getDataFromExcel("org", 1, 2);
JavaUtlity ju=new JavaUtlity();
int num=ju.getRandomNum();
String orgName=Name+""+num;

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
//Login page
lp.loginToApp("admin","admin");
/*lp.getUN().sendKeys("admin");
lp.getPWD().sendKeys("admin");
lp.getLoginbtn().click();*/
//homepage (navigate to Organization link)
HomePage hp=new HomePage(driver);
hp.getorgLink().click();
//hp.navigateToCampaignPage();

//click on "create Organization" Button
OrganzationsPage op=new OrganzationsPage(driver);
op.getCreateNewOrgBtn().click();

//enter all deatails and create new Organization
CreatingNewOrganizatonPage cnop=new CreatingNewOrganizatonPage(driver);
cnop.createOrg(orgName);
cnop.getSaveBtn().click();


//verify Header Msg Expected Result
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String actOrgName=oip.getHeadermsg().getText();
if(actOrgName.contains(orgName))
	System.out.println(orgName+" is verified tcpass");
else
	System.out.println(orgName+" is notverified tcfail");

//go back to Organization page 
hp.getorgLink().click();
//search for organization
op.getSearchEdt().sendKeys(orgName);
wdv.selectVisibleText(op.getSearchdd(), "Organization Name");
op.getSearchBtn().click();
//In dynamic webtable select & delete org
driver.findElement(By.xpath("//a[.='"+orgName+"']/../../td[8]/a[.='del']")).click();
wdv.swithchToAlertAndAccept(driver);
//logout
hp.logout(driver);
driver.quit();

//create organization
/*CreatingNewOrganizatonPage cno=new CreatingNewOrganizatonPage(driver);
cno.getcreateorgLink().click();*/



/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[.='Organizations']")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();



String text=driver.findElement(By.id("mouseArea_Organization Name")).getText();

if(text.contains(orgName))
	System.out.println("Organization" + "is created");
else 
	System.out.println("Organization" + "is not created");*/
	

	}

}
