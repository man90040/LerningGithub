package com.mansingh.Pages;

import java.util.Hashtable;

import org.testng.Assert;

import com.mansingh.CommonMethods.CommonMethod1;
import com.mansingh.TestBase.TestBase1;

public class HomePage extends TestBase1{
	
	public static void createAnAccountPass(Hashtable<String, String> testData) throws Exception {
		
		String Actual_title=driver.getTitle();
		Assert.assertEquals(Actual_title, "Professional Edition Free 30-Day Trial - Salesforce UK - Salesforce UK");
		passLogStatus("User has been redirected to the" + Actual_title + "application");
		
		CommonMethod1.fillAnElement("fname", testData.get("First_Name"), "First Name has been entered");
		
		CommonMethod1.fillAnElement("lname", testData.get("Last_Name"), "Last Name has been entered");
		
		CommonMethod1.fillAnElement("jobtitle", testData.get("Title"), "Title has been entered");
		
		CommonMethod1.fillAnElement("email", testData.get("Email_ID"), "Email Name has been entered");
		
		CommonMethod1.fillAnElement("phone", testData.get("Phone_Numer"), "Mobile Number Name has been entered");
		
		CommonMethod1.fillAnElement("compnyname", testData.get("Company"), "Company Name has been entered");
		
		CommonMethod1.employees("employee", "Employees has been selected");
		
		CommonMethod1.language("country", testData.get("Employees"));
		
		CommonMethod1.clickOnWebElement("lang", testData.get("CompanyLanguage"));
		
		CommonMethod1.clickOnWebElement("signup", "SignUp button has been clicked");
	}
	
	public static void createAnAccountFail(Hashtable<String, String> testData) throws Exception {
		
		String Actual_title=driver.getTitle();
		Assert.assertEquals(Actual_title, "Professional Edition Free 30-Day Trial - Salesforce UK - Salesforce UK");
		passLogStatus("User has been redirected to the" + Actual_title + "application");
		
//		CommonMethod1.fillAnElement("fname", testData.get("First_Name"), "First Name has been entered");
		
		CommonMethod1.fillAnElement("lname", testData.get("Last_Name"), "Last Name has been entered");
		
		CommonMethod1.fillAnElement("jobtitle", testData.get("Title"), "Title has been entered");
		
		CommonMethod1.fillAnElement("email", testData.get("Email_ID"), "Email Name has been entered");
		
		CommonMethod1.fillAnElement("phone", testData.get("Phone_Numer"), "Mobile Number Name has been entered");
		
		CommonMethod1.fillAnElement("compnyname", testData.get("Company"), "Company Name has been entered");
		
		CommonMethod1.employees("employee", "Employees has been selected");
		
		CommonMethod1.language("country", testData.get("Employees"));
		
		CommonMethod1.clickOnWebElement("lang", testData.get("CompanyLanguage"));
		
		CommonMethod1.clickOnWebElement("signup", "SignUp button has been clicked");
	}

}
