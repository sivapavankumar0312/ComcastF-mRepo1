package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}	
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLink;
	
	@FindBy(name="lastname")
	private WebElement createlastName;
	
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;



	public WebElement getSaveBtn() {
	return saveBtn;
}

	public WebElement getCreatelastName() {
		return createlastName;
	}

	public WebElement getCreateContactLink() {
		return createContactLink;
	}
	
	
	
	
	
	
}
