package com.qa.darkskynet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darkskynet.Base.BasePage;
import com.qa.darkskynet.util.AppConstants;
import com.qa.darkskynet.util.ElementUtil;
import com.qa.darkskynet.util.JavaScriptUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	JavaScriptUtil javaScriptUtil;
	ElementUtil elementUtil;
	String lowTemp;
	public HomePage(WebDriver  driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil= new JavaScriptUtil(driver);
	}
	By todayElement = By.xpath("//span[contains(text(),'Today')]");
	By lowestTemp = By.xpath("//span[@class='minTemp']");
	By highestTemp = By.xpath("//span[@class='maxTemp']");
	
	
	
	
	public boolean checkLowestTemp() {
		WebElement element = driver.findElement(todayElement);
		javaScriptUtil.scrollIntoView(element, driver);
		elementUtil.waitForElementVisible(todayElement);
		elementUtil.doClick(todayElement);
		 lowTemp = elementUtil.doGettext(lowestTemp);
		 System.out.println(lowTemp+"is the lowest temp of today");
		
		if (elementUtil.doisDisplayed(lowestTemp)) {
			
				return true ; 
			
		}else {
			System.out.println("Lowest Temprature is not displayed");
		}
		
		
		
		return false;
	}
	
	
	public boolean checkHighestTemp() {
		WebElement element = driver.findElement(todayElement);
		javaScriptUtil.scrollIntoView(element, driver);
		elementUtil.waitForElementVisible(todayElement);
		elementUtil.doClick(todayElement);
		 String highTemp = elementUtil.doGettext(highestTemp);
		 System.out.println(highTemp+"is the highest temp of today.");
		
		if (elementUtil.doisDisplayed(highestTemp)) {
			
				return true ; 
			}
		else {
			System.out.println("Highest Temprature is not displayed");
		}
		
		
		return false;
	}
	
	
	
	
	
	
}
