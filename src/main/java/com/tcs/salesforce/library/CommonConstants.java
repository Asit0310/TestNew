package com.tcs.salesforce.library;
/**********************************************************************************************************************************************************************
					All the constants required throughout the execution are stored in this JAVA class 
*********************************************************************************************************************************************************************
*/
public class CommonConstants {

	public enum Browsers {
		FIREFOX, CHROME
	}
	

	public static String testResultPath = "";
	public static String geckoDriverPath = ".\\geckodriver.exe";
	public static String chromeDriverPath = ".\\src\\main\\resources\\chromedriver.exe";

	public static Browsers currentBrowser = Browsers.CHROME;

	public static String propertiesFileName = "info_config.properties";

	public static int webDriverWaitTime = 300;
 
	public static String outputFolderPath = "";

	public static int GlobalShortTimeOutSeconds = 10;
	public static int GlobalMidTimeOutSeconds = 20;
	public static int GlobalLongTimeOutSeconds = 30;
	public static String tempScreenPath=".\\src\\main\\resources\\123.jpeg";
	public static String projectPath="F:\\SpainDemo";
	public static String defaultenv="IATNL";
	//public static String defaultCountry="Netherlands";
	public static String defaultProfile="Adecco Branch User Lightning";
	//public static String defaultRole="NL";
	
	
	
	
}
