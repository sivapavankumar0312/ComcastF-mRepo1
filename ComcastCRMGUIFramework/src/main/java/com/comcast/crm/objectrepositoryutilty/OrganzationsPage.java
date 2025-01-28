package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganzationsPage {
	WebDriver driver;
	public OrganzationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createNewOrgBtn;

@FindBy(name="accountname")
private WebElement createneworgName;


@FindBy(name="search_text")
private WebElement searchEdt;

@FindBy(name="search_field")
private WebElement searchdd;

@FindBy(name="submit")
private WebElement searchBtn;

@FindBy(name="industry")
private WebElement industrydd1;


public WebElement getCreateNewOrgBtn() {
	return createNewOrgBtn;
}

public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchdd() {
	return searchdd;
}

public WebElement getSearchBtn() {
	return searchBtn;
}

public WebElement getCreateneworgName() {
	return createneworgName;
}




}
