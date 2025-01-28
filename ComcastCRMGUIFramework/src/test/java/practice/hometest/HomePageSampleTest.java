package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		SoftAssert sa=new SoftAssert();
		System.out.println("s1");
		System.out.println("s2");
		Assert.assertEquals("Home", "Home");
		System.out.println("s3");
		sa.assertEquals("Home-CRM", "Home-CR");
		System.out.println("s4");
		sa.assertAll();
		System.out.println(mtd.getName() + "Test End");
		
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");
		SoftAssert sa=new SoftAssert();
		System.out.println("s1");
		System.out.println("s2");
		sa.assertTrue(true);
		System.out.println("s3");
		System.out.println("s4");
		System.out.println(mtd.getName() + "Test End");

	}

}
