package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutilty.CreateContactPage;
import com.comcast.crm.objectrepositoryutilty.CreatedContactInfoPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;

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
}
