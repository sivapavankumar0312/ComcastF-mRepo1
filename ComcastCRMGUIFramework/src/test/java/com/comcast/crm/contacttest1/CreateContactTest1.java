package com.comcast.crm.contacttest1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutilty.CreateContactPage;
import com.comcast.crm.objectrepositoryutilty.CreatedContactInfoPage;
import com.comcast.crm.objectrepositoryutilty.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutilty.CreatingNewOrganizatonPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutilty.OrganzationsPage;

public class CreateContactTest1 extends BaseClass {
	@Test
	public void createContactTest1() throws EncryptedDocumentException, IOException {
		 HomePage hp=new HomePage(driver);
	String lastName = eu.getDataFromExcel("contact", 1, 1);
	hp.getContactsLink().click();
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.getCreateContactLink().click();
	ccp.getCreatelastName().sendKeys(lastName);
	ccp.getSaveBtn().click();
	CreatedContactInfoPage ccip = new CreatedContactInfoPage(driver);
	String text = ccip.getVerifyLastName().getText();

	if (text.contains(lastName))
		System.out.println("contact" + "is created");
	else
		System.out.println("contact" + "is not created");
}
	

@Test
public void createContactwithOrg() throws EncryptedDocumentException, IOException {
	String Name=eu.getDataFromExcel("org", 1, 2);
	int num=ju.getRandomNum();
	String orgName=Name+""+num;
	String lastName=eu.getDataFromExcel("contact", 1, 4)+ju.getRandomNum();

	
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
}
	@Test
	public void createContactwithSupportDate() throws EncryptedDocumentException, IOException {
		String	startDate =	ju.getSystemDateYYYYMMdd().toString();
		String	endDate =	ju.getRequireddateYYYYMMdd(30).toString();

String lastName=eu.getDataFromExcel("contact", 1, 4)+ju.getRandomNum();
HomePage hp=new HomePage(driver);
hp.getContactLink().click();
CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
cncp.creatingNewContact(lastName, startDate, endDate);
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

