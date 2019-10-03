package com.mansingh.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.mansingh.TestBase.TestBase1;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethod1 extends TestBase1{
	
	public static void clickOnWebElement(String xpath, String webelement) throws Exception {
		
		try
		{
		driver.findElement(By.xpath(or.getProperty(xpath))).click();
		test.log(LogStatus.PASS, webelement + "has been clicked");
		ScreenShot();
		Reporter.log(webelement + "has been clicked");
		}
		catch (Throwable t) {
			
			test.log(LogStatus.FAIL, "Unable to click:-" + webelement + "because of:-" + t.getMessage());
			ScreenShot();
		}
	}
	
	public static void ScreenShot() {
		// TODO Auto-generated method stub
		
	}

	public static void fillAnElement(String xpath, String data, String webelement) throws Exception {
		try
		{
		driver.findElement(By.xpath(or.getProperty(xpath))).sendKeys(data);
		test.log(LogStatus.PASS, webelement + "has been entered");
		ScreenShot();
		Reporter.log(webelement + "has been entered");
		}
		catch(Throwable t) {
			
			test.log(LogStatus.FAIL, "Unable to enter test data in:-" + webelement + "because of:-" + t.getMessage());
			ScreenShot();
		}
	}
	
	public static void employees(String xpath, String webelement) throws Exception {
		
		try
		{
//		WebElement e=driver.findElement(By.xpath(or.getProperty(xpath)));
		Select s=new Select(driver.findElement(By.xpath(or.getProperty(xpath))));
		s.selectByValue("15");
		test.log(LogStatus.PASS, webelement + " has been selected");
		ScreenShot();
		Reporter.log(webelement + " has been selected");
		}
		catch(Throwable t) {
			
			test.log(LogStatus.FAIL, "Unable to select Employees:-" + webelement + "because of:-" + t.getMessage());
			ScreenShot();
		}
	}
	
	public static void language(String xpath, String webelement) throws Exception {
		
		try
		{
//		WebElement e=driver.findElement(By.xpath(or.getProperty(xpath)));
		Select s=new Select(driver.findElement(By.xpath(or.getProperty(xpath))));
		s.selectByValue("en_US");
		test.log(LogStatus.PASS, webelement + " has been selected");
		ScreenShot();
		Reporter.log(webelement + " has been selected");
		}
		catch(Throwable t) {
			
			test.log(LogStatus.FAIL, "Unable to select language:-" + webelement + "because of:-" + t.getMessage());
			ScreenShot();
		}
	}
	
	public static boolean isDisplayed(String xpath, String webelement) {
		
		try {
			
			driver.findElement(By.xpath(or.getProperty(xpath))).isDisplayed();
			return true;
		} 
		catch (Exception e) {
			
			return false;
		}

	}

}
