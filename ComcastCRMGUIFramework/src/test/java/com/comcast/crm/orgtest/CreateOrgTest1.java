package com.comcast.crm.orgtest;

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
	public void createOrgTest1() throws EncryptedDocumentException, IOException  {

String Name=eu.getDataFromExcel("org", 1, 2);
int num=ju.getRandomNum();
String orgName=Name+""+num;
HomePage hp=new HomePage(driver);

hp.getorgLink().click();

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

}
}

//logout
//hp.logout();
//driver.quit();

