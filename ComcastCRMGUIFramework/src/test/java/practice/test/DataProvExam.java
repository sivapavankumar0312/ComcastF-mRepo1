package practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class DataProvExam {
	@Test(dataProvider="LoginData",dataProviderClass=CustomizeDataProv.class)
	public void loginTest(String un,String pwd)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");
	 driver.findElement(By.id("email")).sendKeys(un);
	 driver.findElement(By.id("pass")).sendKeys(pwd);
	 driver.findElement(By.xpath("//button[.='Log in']")).click();
	 driver.close();
	 
	}
}
