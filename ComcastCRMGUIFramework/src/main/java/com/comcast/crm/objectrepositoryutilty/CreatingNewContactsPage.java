package com.comcast.crm.objectrepositoryutilty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;

public class CreatingNewContactsPage {
	WebDriver driver;
	public CreatingNewContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}	
	@FindBy(xpath="//input[@type='text']")
	private WebElement createlastName;

@FindBy(name="support_start_date")
private WebElement startdate;

@FindBy(name="support_end_date")
private WebElement endate;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(xpath=("//input[@name='account_name']/following-sibling::img"))
private WebElement plusBtn;

@FindBy(id="search_txt")
private WebElement searchField;


 
@FindBy(xpath="//input[@name='search']")
private WebElement searchnowbtn;





public WebDriver getDriver() {
	return driver;
}



public WebElement getSearchnowbtn() {
	return searchnowbtn;
}



public WebElement getSearchField() {
	return searchField;
}
  


public WebElement getPlusBtn() {
	return plusBtn;
}



public WebElement getStartdate() {
	return startdate;
}

public WebElement getEndate() {
	return endate;
}


public WebElement getSaveBtn() {
	return saveBtn;
}

	public WebElement getCreatelastName() {
		return createlastName;
	}
	public void creatingNewContact(String lastName,String startdt,String enddt) {
		createlastName.sendKeys(lastName);
		startdate.clear();
		startdate.sendKeys(startdt);
		endate.clear();
		endate.sendKeys(enddt);
		saveBtn.click();
	}
	public void creatingNewContact(String lastName) {
		createlastName.sendKeys(lastName);
	}
	public void createContactWithOrg (WebDriver driver, String orgName, String lastName) {
		createlastName.sendKeys(lastName);
		plusBtn.click();
		WebDriverUtliity wdv=new WebDriverUtliity();
		wdv.switchToTabOnURL(driver, "module=Accounts");
		searchField.sendKeys(orgName);
		searchnowbtn.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		wdv.switchToTabOnURL(driver, "Contacts&action");
		saveBtn.click();
	}

}
