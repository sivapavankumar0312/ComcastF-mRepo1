package com.nobroker.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NobrokerClass {
	@Test
	public void Loginbroker() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http:www.nobroker.in");
		

	}		
		
		
}	