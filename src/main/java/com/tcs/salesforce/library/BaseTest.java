
package com.tcs.salesforce.library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



/**********************************************************************************************************************************************************************
									DRIVER CLASS FOR TEST SUITE EXECUTION
									
				1.This class loads/links all the resources required for test suite execution with the code.
				2.Creates the test output folder and result report excel.
				3.Execute the test cases from test suite file sequentially for which the flag is 'Y'
				4.Kills all the processes after test suite execution.

*********************************************************************************************************************************************************************
*/public class BaseTest {

	public static WebDriver driver;
	public static CoreFunctions coreFunc;
	public static Properties prop;
	public static boolean result;
	public static String profile=CommonConstants.defaultProfile;
	//public static String role=CommonConstants.defaultRole;
	
	//public static String country=CommonConstants.defaultCountry;
	public static String env=CommonConstants.defaultenv;
	public static String logpath;
	public static String testName;
	public static String[][] testData;
	public static int testcounter,numberOfRows=1;
	public static Map<String, String> testDataValues = new HashMap<String, String>();

	InputStream inputStream;

	@BeforeSuite
	public void beforeSuite() throws Exception {

		inputStream = getClass().getClassLoader().getResourceAsStream(
				CommonConstants.propertiesFileName);
		
		prop = new Properties();
		
		if (inputStream != null) {
			prop.load(inputStream);
			
		} else {
			throw new FileNotFoundException("property file '"
					+ CommonConstants.propertiesFileName
					+ "' not found on the classpath !!");
		}

		inputStream.close();

		String time = CommonUtils.getDate(0, null);
		/*
		 create the output folder
		 */

		CommonConstants.outputFolderPath = "F:\\Automation\\SpainAutomation\\Automation_OutputFiles\\Automation_Screenshots\\"
				+ time + "\\";
		CommonUtils.createFolders(CommonConstants.outputFolderPath);

		//Create the ouptput excel report 
		CommonConstants.testResultPath=CommonConstants.outputFolderPath+"TestResult.xlsx";
        CommonUtils.createExcel(CommonConstants.testResultPath);
		 
	}
	

	
@BeforeMethod
	protected static WebDriver initializeDriver() throws Exception {

	System.out.println("thread id before method : " +Thread.currentThread().getId());
		//WebDriver driver = null;

		switch (CommonConstants.currentBrowser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					CommonConstants.geckoDriverPath);
			driver = new FirefoxDriver();
			break;
		case CHROME:
			 ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					CommonConstants.chromeDriverPath);
			//ChromeOptions options = new ChromeOptions();
		//	options.setHeadless(true);
		//	options.addArguments("window-size=1400,800");
			
		//	driver = new ChromeDriver(options);
			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			break;

		default:
			throw new Exception(
					"Invalid Browser parameter. Not able to initialize drivers!!");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		coreFunc = new CoreFunctions(driver);
		
		//String url= prop.getProperty(env+"Url");
		

		driver.get(prop.getProperty("QFIXLUrl"));
		
		Thread.sleep(3000);
		
		result=true;
		
		return driver;
	}
	
	
@AfterMethod
	public static void testResult(){
	System.out.println("After Test invoked");
	System.out.println("thread id After method : " +Thread.currentThread().getId());
		if(driver!=null)
			driver.quit();
		ExcelConfig.writeResultExcel(testName, result);
		
	}

public static void onFailure(String failedStep){
	result=false;
	CoreFunctions.captureScreenShot(driver, true, failedStep, logpath);
}

public static void logfileCreation() throws IOException{
	System.out.println("Log file creation");
	logpath = CommonConstants.outputFolderPath+"\\"+testName+CommonUtils.getDate(0, null)+".docx";
	CommonUtils.createWord(logpath);
		
	}
	
}

