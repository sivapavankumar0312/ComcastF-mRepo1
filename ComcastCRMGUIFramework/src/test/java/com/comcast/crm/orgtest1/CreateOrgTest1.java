package com.comcast.crm.orgtest1;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutilty.CreatingNewOrganizatonPage;
import com.comcast.crm.objectrepositoryutilty.HomePage;
import com.comcast.crm.objectrepositoryutilty.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutilty.OrganzationsPage;

public class CreateOrgTest1 extends BaseClass {
	@Test
	public void createOrgTest1() throws EncryptedDocumentException, IOException {

		String Name = eu.getDataFromExcel("org", 1, 2);
		int num = ju.getRandomNum();
		String orgName = Name + "" + num;
		HomePage hp = new HomePage(driver);

		hp.getorgLink().click();

		OrganzationsPage op = new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();

//enter all deatails and create new Organization
		CreatingNewOrganizatonPage cnop = new CreatingNewOrganizatonPage(driver);
		cnop.createOrg(orgName);
		cnop.getSaveBtn().click();

//verify Header Msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadermsg().getText();
		if (actOrgName.contains(orgName))
			System.out.println(orgName + " is verified tcpass");
		else
			System.out.println(orgName + " is notverified tcfail");

	}

	@Test
	public void createorgphn() throws EncryptedDocumentException, IOException {
		String org = eu.getDataFromExcel("org", 1, 2) + ju.getRandomNum();
		String phn = eu.getDataFromExcel("org", 1, 5);
		HomePage hp = new HomePage(driver);
		hp.getorgLink().click();

		OrganzationsPage op = new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizatonPage cnop = new CreatingNewOrganizatonPage(driver);
		cnop.creatingNewOrg(org, phn);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadermsg().getText();
		if (actOrgName.contains(org))
			System.out.println(org + " is verified tcpass");
		else
			System.out.println(org + " is notverified tcfail");
		String act_ph = cnop.getVerifyphno().getText();
		if (act_ph.equals(phn))
			System.out.println(phn + " is verified tcpass");
		else
			System.out.println(phn + " is not verified tcpass");
	}

	@Test
	public void createOrgwithINdtype() throws EncryptedDocumentException, IOException {
		String Name = eu.getDataFromExcel("org", 4, 2);
		int num = ju.getRandomNum();
		String orgName = Name + num;
		String Name1 = eu.getDataFromExcel("org", 4, 3);
		String industry = Name1;
		String type = eu.getDataFromExcel("org", 4, 4);
		HomePage hp = new HomePage(driver);
		hp.getorgLink().click();
		OrganzationsPage op = new OrganzationsPage(driver);
		op.getCreateNewOrgBtn().click();
		CreatingNewOrganizatonPage cnop = new CreatingNewOrganizatonPage(driver);
		cnop.createOrg(orgName, industry, type);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String text = oip.getHeaderorgan();
		String text1 = oip.getHeaderInd();

		if (text.contains(orgName))
			System.out.println("Organization" + "is created");
		else
			System.out.println("Organization" + "is not created");
		if (text1.equals(industry))
			System.out.println("INdustry type is created");
		else
			System.out.println("INdustry type is not created");
	}
}
