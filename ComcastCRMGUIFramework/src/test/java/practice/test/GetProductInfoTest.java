package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest {
@Test
public void getProductInfoTest() {
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://amazon.in");
	//search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	//capture product info
}
}
