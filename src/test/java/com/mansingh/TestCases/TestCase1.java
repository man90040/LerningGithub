package com.mansingh.TestCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mansingh.Pages.HomePage;
import com.mansingh.TestBase.TestBase1;


public class TestCase1 extends TestBase1 {

	@BeforeClass
	public static void isSkip() {

		if (!isExecutable("TC001_Create_an_Account1"))

			throw new SkipException("Skipping Test case as it's Run Mode is set to N");
	}

	@Test(dataProvider = "data_Collections")
	public static void TC001_Create_an_Account1(Hashtable<String, String> testData) throws Exception {
		test = extent.startTest("TC001_Create_an_Account1");

		HomePage.createAnAccountPass(testData);
	}
}
