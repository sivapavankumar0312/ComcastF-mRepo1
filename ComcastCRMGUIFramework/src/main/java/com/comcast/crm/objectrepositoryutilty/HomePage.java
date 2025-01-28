package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;

	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[.='Organizations']")
private WebElement orgLink;

@FindBy(xpath="//a[.='Products']")
private WebElement proLink;

@FindBy(xpath="//a[.='Contacts']")
private WebElement contactLink;

@FindBy(name="Campaigns")
private  WebElement campaignLink;

@FindBy(linkText = "More")
private WebElement moreLink;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;

@FindBy(linkText = "Sign Out")
private WebElement signOutLink;

@FindBy(xpath="//a[.='Contacts']")
private WebElement ContactsLink;



public WebElement getAdminImg() {
	return adminImg;
}

public WebElement getSignOutLink() {
	return signOutLink;
}

public WebElement getContactsLink() {
	return ContactsLink;
}

public WebElement getOrgLink() {
	return orgLink;
}

public WebElement getContactLink() {
	return contactLink;
}

public WebElement getorgLink() {
	return orgLink;
}
public void navigateToCampaignPage(WebDriver driver) {
	Actions act=new Actions(driver);
	act.moveToElement(moreLink).perform();
	campaignLink.click();
}

public WebElement getCampaignLink() {
	return campaignLink;
}

public WebElement getMoreLink() {
	return moreLink;
}
public void logout(WebDriver driver) {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	signOutLink.click();
}
}
