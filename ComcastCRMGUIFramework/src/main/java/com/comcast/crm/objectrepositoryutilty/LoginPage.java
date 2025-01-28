package com.comcast.crm.objectrepositoryutilty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtliity;

public class LoginPage extends WebDriverUtliity{   //Rule-1  create a separate java cls
	                       //Rule-2 Object Creation
	//WebDriver driver;
	public LoginPage(WebDriver driver) {
		//this.driver=driver;
PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement UN;
@FindBy(name="user_password")
 private WebElement PWD;
@FindBy(id="submitButton")
private WebElement loginbtn;
                                  //Rule-3 Object Initialization
//Rule 4 : object Encapsulation
public WebElement getUN() {
	return UN;
}
public WebElement getPWD() {
	return PWD;
}
public WebElement getLoginbtn() {
	return loginbtn;
}
//Rule 5:provide Action
public void loginToApp( String username,String password) {
	//driver.manage().window().maximize();
	UN.sendKeys(username);
	PWD.sendKeys(password);
	loginbtn.click();
}
	

}
