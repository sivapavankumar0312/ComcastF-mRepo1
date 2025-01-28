package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	
	@FindBy(xpath="//span[@className='dvHeaderText']")
	private WebElement verifyheader;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement verifylastName;
	
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement verifyStartDate;
	

	
	
	
	
}
