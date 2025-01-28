package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedContactInfoPage {
	WebDriver driver;

	public CreatedContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mouseArea_Last Name")
	private WebElement verifyLastName;
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startdateInfo;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement enddateInfo;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement verifylastName;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyOrgName;

	public WebElement getVerifyOrgName() {
		return verifyOrgName;
	}

	public WebElement getVerifylastName() {
		return verifylastName;
	}

	public WebElement getVerifyLastName() {
		return verifyLastName;
	}

	public WebElement getStartdateInfo() {
		return startdateInfo;
	}

	public WebElement getEnddateInfo() {
		return enddateInfo;
	}

}
