package com.mansingh.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase1 {

	public static WebDriver driver;
	public static Properties config;
	public static Properties or;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String TestCaseName;
	public static ExcelReader er = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\test_Data\\Master_Sheet.xlsx");
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static Hashtable<String, String> TestCaseRunMode = new Hashtable<String, String>();

	@BeforeSuite
	public static void LoadingFiles() throws IOException {

		extent = new ExtentReports(System.getProperty("user.dir") + "\\src\\test\\resources\\execution_Report\\"
				+ "ExecutionReport_" + TestCaseName + ".html");
		config = new Properties();
		FileInputStream f1 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		config.load(f1);
		or = new Properties();
		FileInputStream f2 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\or.properties");
		or.load(f2);
		loadHashTable(TestCaseRunMode, "Test_Cases", "TestCaseName", "Run_Mode");

	}

	@BeforeMethod
	public static void LaunchingBrowser() {

		if(config.getProperty("Browser").equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(config.getProperty("launch_Aap"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public static void writeIntoExtentReport() {
		extent.endTest(test);
		extent.flush();
	}

	private static void loadHashTable(Hashtable<String, String> testCaseRunMode2, String string, String string2,
			String string3) {
		int row = er.getRowCount(string);

		for (int i = 2; i <= row; i++) {
			String key = er.getCellData(string, string2, i);

			String val = er.getCellData(string, string3, i);

			TestCaseRunMode.put(key, val);
		}

		System.out.println(TestCaseRunMode);
	}

	public static boolean isExecutable(String TC_Name) {

		TestCaseName = TC_Name;
		if (TestCaseRunMode.get(TestCaseName).equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}

	@DataProvider
	public static Object[][] data_Collections() {

		DataCollection dc = new DataCollection(er, "Test_Data", TestCaseName);
		return dc.dataArray();
	}

	public static void ScreenShot() throws Exception {

		File ScrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String ReportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ "\\src\\test\\resources\\execution_Report" + timeStamp + ".png";

		File destFile = new File(ReportDirectory);

		FileHandler.copy(ScrFile, destFile);

		test.log(LogStatus.PASS, test.addScreenCapture(ReportDirectory));

		String filePath = destFile.toString();

		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";

		Reporter.log(path);
	}

	public static void passLogStatus(String message) throws Exception {

		test.log(LogStatus.PASS, message);
		ScreenShot();
	}
}
