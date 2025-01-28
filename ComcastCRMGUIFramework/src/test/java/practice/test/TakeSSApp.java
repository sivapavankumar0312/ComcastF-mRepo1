package practice.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeSSApp {
	@Test
public void appss() throws IOException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://pari-match-in.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshots/ssapp.jpeg");
		FileHandler.copy(src, dst);
		driver.quit();
	}
}
