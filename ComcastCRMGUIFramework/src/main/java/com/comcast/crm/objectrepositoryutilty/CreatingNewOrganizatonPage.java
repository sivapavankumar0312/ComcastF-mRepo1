package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;

public class CreatingNewOrganizatonPage {
	WebDriver driver;
	public CreatingNewOrganizatonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industrydd;
	
	/*
	 * @FindBy(name="industry") private WebElement industrydd1;
	 */
	
	@FindBy(id = "phone")
	private WebElement Phonenumber;
	
	
@FindBy(id="dtlview_Phone")
private WebElement verifyphno;

/*
 * public WebElement getIndustrydd1() { return industrydd1; }
 */

@FindBy(name="accounttype")
private WebElement IndustryType;

public WebElement getIndustryType( ) {
	return IndustryType;
}

@FindBy(name="industry")
private WebElement industryDB;

public WebElement getindustryDB( ) {
	return industryDB;
}

public WebElement getVerifyphno() {
	return verifyphno;
}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
public void createOrg(String orgName) {
	orgNameEdt.sendKeys(orgName);
}

public void createOrg(String orgName,String industry, String type)
{   //WebDriverUtliity wLib=new WebDriverUtliity();
	orgNameEdt.sendKeys(orgName);
	Select s1=new Select(industryDB);
	s1.selectByVisibleText(industry);
	Select s2=new Select(IndustryType);
	s2.selectByVisibleText(type);
	saveBtn.click();
	System.out.println(industry + "   name of the industry");
	System.out.println(type + "   name of the type");

}
public void getIndustrydd() {
	Select s=new Select(industrydd);
	s.selectByIndex(2);
	saveBtn.click();
}
public WebElement getPhonenumber() {
	return Phonenumber;
}
public void creatingNewOrg(String OrgName,String phone)
{
	orgNameEdt.sendKeys(OrgName);
	Phonenumber.sendKeys(phone);
	saveBtn.click();
}

public void creatingNewOrgWithIndAndType(String OrgName,String phone)
{
	orgNameEdt.sendKeys(OrgName);
	Phonenumber.sendKeys(phone);
	saveBtn.click();
}

	
	
	}

