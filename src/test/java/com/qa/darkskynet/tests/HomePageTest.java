package com.qa.darkskynet.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darkskynet.Base.BasePage;
import com.qa.darkskynet.pages.HomePage;
import com.qa.darkskynet.util.ElementUtil;

public class HomePageTest {

	WebDriver driver;
	HomePage homePage;
	Properties prop;
	BasePage basePage;
	ElementUtil elementUtil;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.Init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "lowest  temperature is displayed correctly")
	public void verifyCheckLowestTemp() {
		// System.out.println(homePage.checkLowestTemp());
		Assert.assertTrue(homePage.checkLowestTemp());

	}

	@Test(priority = 2 , description = "verify highest temperature is displayed correctly")
	public void verifyCheckHighestTemp() {
		// System.out.println(homePage.checkHighestTemp());
		Assert.assertTrue(homePage.checkHighestTemp());

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}