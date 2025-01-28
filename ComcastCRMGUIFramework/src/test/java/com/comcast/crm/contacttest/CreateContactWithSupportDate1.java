package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.comcast.crm.objectrepositoryutilty.CreatedContactInfoPage;
import com.comcast.crm.objectrepositoryutilty.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;

public class CreateContactWithSupportDate1 extends BaseClass{
@Test
	public  void createContactWithSupportDate1() throws IOException {
		/*FileInputStream fis=new FileInputStream("C:\\Users\\home\\Desktop\\data\\commondata.properties.txt");
Properties p=new Properties();
p.load(fis);
String BROWSER=p.getProperty("browser");
String URL=p.getProperty("url");
String USERNAME=p.getProperty("username");
String PASSWORD=p.getProperty("password");*/
				
		/*FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
//read ts data from excel
/*FileInputStream fis1=new FileInputStream("C:\\Users\\home\\Desktop\\data\\VTIGER_Testcases.xlsx");
Workbook book=WorkbookFactory.create(fis1);
Sheet sh=book.getSheet("contact");
Row row=sh.getRow(1);
String lastName=row.getCell(4).toString();
book.close();*/
		//JavaUtlity ju=new JavaUtlity();
		String	startDate =	ju.getSystemDateYYYYMMdd().toString();
		String	endDate =	ju.getRequireddateYYYYMMdd(30).toString();

String lastName=eu.getDataFromExcel("contact", 1, 4)+ju.getRandomNum();

/*WebDriver driver=null;
if(BROWSER.equals("chrome"))
	driver= new ChromeDriver();
else if(BROWSER.equals("firefox"))
	driver=new FirefoxDriver();
else
	driver=new ChromeDriver();	*/

//login to app
/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
driver.manage().window().maximize();
driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();*/
//WebDriverUtliity wdv=new WebDriverUtliity();
//wdv.waitForPageTOLoad(driver);
//driver.get(URL);
//LoginPage lp=new LoginPage(driver);
//lp.loginToApp(USERNAME,PASSWORD);


//navigate to "Contacts" module/link
//driver.findElement(By.xpath("//a[.='Contacts']")).click();
HomePage hp=new HomePage(driver);
hp.getContactLink().click();
//click on "Create Contact" + icon
//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
CreateContactPage ccp=new CreateContactPage(driver);
ccp.getCreateContactLink().click();
//enter all details & create new Contact
/*Date d=new Date();
SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
String startDate=sim.format(d);
Calendar cal =sim.getCalendar();
cal.add(Calendar.DAY_OF_MONTH, 30);
String endDate=sim.format(cal.getTime());
driver.findElement(By.name("lastname")).sendKeys(lastName);
driver.findElement(By.name("support_start_date")).clear();
driver.findElement(By.name("support_start_date")).sendKeys(startDate);
driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(endDate);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
cncp.creatingNewContact(lastName, startDate, endDate);

//verification of created contact with supportDate info Expected result
CreatedContactInfoPage ccip=new CreatedContactInfoPage(driver);
String text1=ccip.getStartdateInfo().getText();

if(text1.contains(startDate))
	System.out.println("startdate" + "is saved");
else 
	System.out.println("startdate" + "is not saved");
	
String text2=ccip.getEnddateInfo().getText();
if(text2.contains(endDate))
	System.out.println("enddate" + "is saved");
else 
	System.out.println("enddate" + "is not saved");

}
}
