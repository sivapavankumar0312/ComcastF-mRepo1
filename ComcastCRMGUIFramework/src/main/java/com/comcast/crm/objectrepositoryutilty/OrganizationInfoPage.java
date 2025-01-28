package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(className = "dvHeaderText")
private WebElement headermsg;

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headerorgan;

@FindBy(id="mouseArea_Industry")
private WebElement headerInd;


@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement verifyheader;


WebDriver driver;
public OrganizationInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public WebElement getHeadermsg() {
	return headermsg;
}
public String getHeaderorgan() {
	 String text=headerorgan.getText();
	 return text;
	
}
public String getHeaderInd() {
	 String text=headerInd.getText();
	 return text;
	
}
public WebElement getVerifyheader() {
	return verifyheader;
}


public void VerifyHeader(String organizationname) {
	String header = verifyheader.getText();
	if(header.contains(organizationname)) {
		System.out.println("organization created");
	}
	else {
		System.out.println("not created");
	}
}



}
