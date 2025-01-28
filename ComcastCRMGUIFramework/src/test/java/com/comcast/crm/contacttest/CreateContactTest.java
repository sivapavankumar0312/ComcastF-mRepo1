package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;
import com.comcast.crm.objectrepositoryutilty.CreateContactPage;
import com.comcast.crm.objectrepositoryutilty.CreatedContactInfoPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.LoginPage;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		// read commondata from properties
		// create object
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		// read ts data from excel
		String lastName = elib.getDataFromExcel("contact", 1, 1);

		System.out.println(lastName);

		WebDriver driver = null;
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();

		else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		// login to app
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.get(URL); driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		// navigate to "Contacts" module/link
		WebDriverUtliity wdv = new WebDriverUtliity();
		wdv.waitForPageTOLoad(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		// driver.findElement(By.xpath("//a[.='Contacts']")).click();
		hp.getContactsLink().click();

		// click on "Create Contact" + icon
		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getCreateContactLink().click();
		// enter all details & create new Contact
		// driver.findElement(By.name("lastname")).sendKeys(lastName);
		ccp.getCreatelastName().sendKeys(lastName);
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ccp.getSaveBtn().click();

//verification of created contact info Expected result
		CreatedContactInfoPage ccip = new CreatedContactInfoPage(driver);
		String text = ccip.getVerifyLastName().getText();

		if (text.contains(lastName))
			System.out.println("contact" + "is created");
		else
			System.out.println("contact" + "is not created");
		// hp.logout();
		// driver.quit();

	}

}
