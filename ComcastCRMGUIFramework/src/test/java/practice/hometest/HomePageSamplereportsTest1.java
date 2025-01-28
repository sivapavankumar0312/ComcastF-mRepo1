package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSamplereportsTest1 {
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log("s1",true);
		Reporter.log("s2",true);
		Reporter.log("s3",true);
		Reporter.log("s4",true);
		Reporter.log(mtd.getName() + "Test End");
		
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log("s1",true);
		Reporter.log("s2",true);
		Reporter.log("s3",true);
		Reporter.log("s4",true);
		Reporter.log(mtd.getName() + "Test End");

	}

}
