package com.tcs.salesforce.library;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;






import com.tcs.salesforce.pageobjects.Common.*;

public class SalesforceFunction extends BaseTest{
	
	CoreFunctions corefunc=new CoreFunctions(null);
	String[] opportunityRecordType= testDataValues.get("Opportunity Record Type").split(",");
	
public static void login(WebDriver driver,String profile) throws Exception {
		
	

		LoginSalesforce loginSF = new LoginSalesforce(driver, logpath);
		loginSF.get();
		String userName=prop.getProperty("QFIXABULuser");
		String password= new String(Base64.decodeBase64(prop.getProperty("QFIXABULpassword").getBytes()));
		
		System.out.println("Password : "+password);
		
		if(profile.equalsIgnoreCase("Country FO Manager")){
			userName=prop.getProperty("FOUser");
			password=new String(Base64.decodeBase64(prop.getProperty("FOPassword").getBytes()));
		}
		

		
		loginSF.enterUserName(userName);
		
		
		
		loginSF.enterPassword(password);
	

		
		loginSF.clickLogin();
		driver.navigate().refresh();
		
		/*HomeSalesforceLight homeSF = new HomeSalesforceLight(driver, logpath);
		HomeSalesforceClassic homeSFCL= new HomeSalesforceClassic(driver, logpath);

		if(homeSF.tbx_searchBox.isDisplayed()){
			CoreFunctions.captureScreenShot(driver, true, "User logged in Successfully", logpath);
		}
		else
		{
			CoreFunctions.captureScreenShot(driver, true, "User Login failed", logpath);
			
		}
		*/
		
	
	}
	
public static void logout(WebDriver driver,String logpath) throws Exception {
		
		
		
		
/*		
  if(profile.contains("Classic")){
	   HomeSalesforceClassic homeSFCL = new HomeSalesforceClassic(driver, logpath);
		homeSFCL.get();
		homeSFCL.clickLoggedUserProfile();
		
		Log.info("Click on logout");
		homeSFCL.clickLogout();
  }
  else{*/
	  HomeSalesforceLight homeSF = new HomeSalesforceLight(driver, logpath);
	  homeSF.clickloggedinuser();
		
		Log.info("Click on logout");
		homeSF.clickLogout();
//  }

		coreFunc.waitForPageLoad();
		
		driver.quit();	
	
	}
public static void clickTabLoggedAsLight(WebDriver driver,String nameInApp, String logpath) throws Exception {
	boolean match=false;
	HomeSalesforceLight homeSF = new HomeSalesforceLight(driver, logpath);
	homeSF.clickAppLauncher();
	
	System.out.println("Size of Links :"+homeSF.List_lnk_AllItems.size());
	for(WebElement we: homeSF.List_lnk_AllItems){
		//System.out.println("element from UI: "+we.getText()+" element passed : "+nameInApp);
		if(we.getText().equalsIgnoreCase(nameInApp)){
			coreFunc.clickObject(we, logpath, nameInApp);
			Thread.sleep(9000);//wait for page load
			match=true;
			break;
			
		}
		
	}
	if(!match)
	CoreFunctions.captureScreenShot(driver, true, "Tab(Object)Link does not exist", logpath);
	

}

/*public static void TrUserLogin(String userProfile,WebDriver driver,String logpath) throws Exception {
	
	
	HomeSalesforce homeSF = new HomeSalesforce(driver, logpath);
	homeSF.clickSetup();
	homeSF.clickManageUsersLink();
	homeSF.clickPublicGroups();
	homeSF.ClickFRSpringTRUsers();
	homeSF.loginAs(userProfile);
	//homeSF.clickUserArrow();
	//homeSF.clickUserDetails();
	//homeSF.clickLogin();
	

}
*/
/* This method selects a value from a lookup field and returns the selected value

*/
public static void loginAsProfileLight(WebDriver driver,String profileName,String logpath) throws Exception {
	login(driver, logpath);
	HomeSalesforceLight homeSF = new HomeSalesforceLight(driver, logpath);
	
	homeSF.clickSetUp();
	
	//Switch to new Window
	coreFunc.handleTabs();
	homeSF.clickUsers();
	homeSF.clickProfiles();
	homeSF.clickDesiredProfile(profileName);
	homeSF.clickViewUsers();
	
	//Sort user based on active status
	homeSF.clickActiveColumnHeader();
	while(!homeSF.getTitleActiveColumnSortArrow().equalsIgnoreCase("Sorted Descending")){
		homeSF.clickActiveColumnHeader();
	}
	
    //Open details of first user and login
	if(homeSF.FirstUserNameIsDisplayed()){
		homeSF.clickFirstUserName();
		if(!homeSF.getUserLanguage().equalsIgnoreCase("English")){
			homeSF.clickEditUser();
			homeSF.selectLanguage("English");
			homeSF.saveUserDetails();
		}
		
		homeSF.clickLogin();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	else{
		CoreFunctions.captureScreenShot(driver, true, "No Active users available", logpath);
	}
		
	
	
}



public static String globalSearchLight(String searchText , String logpath) throws Exception {
	HomeSalesforceLight gs= new HomeSalesforceLight(driver, logpath);
	gs.enterSearchText(searchText);
	Thread.sleep(2000);
	gs.tbx_searchBox.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	/*//gs.tbx_searchBox.sendKeys(Keys.ENTER);
	
	coreFunc.clickObject(gs.lnk_SearchObject, logpath, "Search Object");
	Thread.sleep(2000);
	
	String clickedResult=null;
	for(WebElement we: gs.lnk_searchResult){
		if(searchText.equalsIgnoreCase(we.getText())){
			clickedResult=coreFunc.getText(we, "Search result",logpath);
			if(clickedResult==null){
				clickedResult=searchText;
			}
		coreFunc.clickObject(we, logpath, clickedResult);
		break;
			
		}
	}
	
	
	return clickedResult;*/
	
	return searchText;
	
}
	

public static boolean validateDropdownValues(WebElement dropdownName , String[] values,String logpath) throws Exception {
	
	boolean matchResult=true;//overall match status
	
	Select dropdown = new Select(dropdownName);
	
	List<WebElement> options = dropdown.getOptions();
	int dropdownSize=options.size();
	System.out.println("First Option : "+options.get(0).getText());
	if(options.get(0).getText().contains("Select")||options.get(0).getText().contains("None")){
		dropdownSize=dropdownSize-1;
	}
	System.out.println("values.length "+values.length+"options.size() "+options.size());
	if(values.length==dropdownSize){
				
				for(int i=0; i< values.length;i++){
					boolean match=false;//each value match status
					for(WebElement we: options){
							
						if(we.getText().equalsIgnoreCase(values[i])){
				    			match=true;
				    			dropdown.selectByVisibleText(values[i]);
				    			CoreFunctions.captureScreenShot(driver, true,values[i]+ " is available in the dropdown", logpath);
				    			break;
						
						}
					
					}
						
			    	if(!match){
			    		matchResult=false;
			    		CoreFunctions.captureScreenShot(driver, false,values[i]+ " is not available in the dropdown", logpath);
			    	}
			    	
			    	
			    	
			    }
				
		
		}
	
	else{
		coreFunc.clickObject(dropdownName, logpath, "Dropdown");
		CoreFunctions.captureScreenShot(driver, true, "Values available in dropdown does not match the number of expected values", logpath);
		matchResult=false;
	}
		
		
		return matchResult;
		
}

/*public static void clickTabLoggedAsClassic(WebDriver driver,String nameInApp, String logpath) throws Exception {
	
	
	HomeSalesforceClassic homeSF = new HomeSalesforceClassic(driver, logpath);
	homeSF.get();
	homeSF.clickTabs(nameInApp, logpath);

}


public static String globalSearchClassic(String searchText , String logpath) throws Exception {
	HomeSalesforceClassic gs= new HomeSalesforceClassic(driver, logpath);
	coreFunc.setText(gs.searchBox,searchText, "TextBox", "Global Search", logpath);
	Thread.sleep(2000);
	coreFunc.clickObject(gs.btn_search, logpath, "search button");
	String clickedResult=coreFunc.getText(gs.lnk_searchResult, "First Search result",logpath);
		if(clickedResult==null){
			clickedResult=searchText;
		}
	coreFunc.clickObject(gs.lnk_searchResult, logpath, clickedResult);
	return clickedResult;
	
}

*/
//select values from dropdown
public static boolean selectValuesFromDropdownValues(WebElement dropdownName , String value,String logpath) throws Exception {
	boolean matchResult=true;//overall match status
	Select dropdown = new Select(dropdownName);
	     coreFunc.scrollIntoView(dropdownName);
	List<WebElement> options = dropdown.getOptions();
	
					boolean match=false;//each value match status
					for(WebElement we: options){
							
						if(we.getText().equalsIgnoreCase(value)){
				    			match=true;
				    			dropdown.selectByVisibleText(value);
				    			Thread.sleep(3000);
				    
				    		CoreFunctions.captureScreenShot(driver, true,value+ " is available in the dropdown", logpath);	
				    		break;
						}
					
					}
						
			    	if(!match){
			    		matchResult=false;
			    		CoreFunctions.captureScreenShot(driver, true,value+ " is not available in the dropdown", logpath);
			    	}

		return matchResult;
		
	}


/* This method selects a value from a lookup field and returns the selected value

*/
public static String selectLookupValue(WebDriver driver,WebElement txtbox, WebElement lookupIcon,WebElement linkSelection, String textValue,String nameInApp,String logpath) throws Exception {
    //coreFunc.setText(txtbox, textValue, "TextBox", nameInApp, logpath);
	
	coreFunc.clickObject(txtbox, logpath, "SearchBox lookup");
	
    txtbox.sendKeys(Keys.TAB);
	String keysPressed =  Keys.chord(Keys.CONTROL, Keys.RETURN);
	lookupIcon.sendKeys(keysPressed) ;
	
	 Thread.sleep(3000);
	 
	 //Switch to lookup window
	  String parentWindow = driver.getWindowHandle();
	  Set<String> handles =  driver.getWindowHandles();
						 for(String windowHandle  : handles)
						     { 
						     if(!windowHandle.equals(parentWindow))
						        {
						    	 
						        driver.switchTo().window(windowHandle);
						        driver.manage().window().maximize();
						        CoreFunctions.captureScreenShot(driver, true, "Search lookup window is displayed", logpath);
						        }
						     }
					
						 Thread.sleep(6000);	
		 driver.switchTo().frame("searchFrame");				 
		
		 WebElement tbx_SearchBox= driver.findElement(By.id("lksrch"));
		 WebElement btn_Go= driver.findElement(By.name("go"));
		 
		//WebElement tbx_SearchBox= driver.findElement(By.xpath("html/body/form/div/div[2]/input[1]"));
		
		// WebElement btn_Go= driver.findElement(By.xpath("html/body/form/div/div[2]/input[2]"));
		 WebElement radio_allFields= driver.findElement(By.id("lkenhmdSEARCH_ALL"));
		 
		 //select radio button ""all fields"
		 
		 coreFunc.clickObject(radio_allFields, logpath, "All fields radio button");
		 
		 coreFunc.setText(tbx_SearchBox, textValue, "TextBox", "Search Box", logpath);
		 Thread.sleep(4000);
		 
		 coreFunc.clickObject(btn_Go, logpath, "GO");
		 
		 Thread.sleep(3000);
		 driver.switchTo().parentFrame();
		 
		 driver.switchTo().frame("resultsFrame");
		 String linkClicked=coreFunc.getText(linkSelection, "Search result", logpath);
		 CoreFunctions.captureScreenShot(driver, true, linkClicked+" is to be clicked", logpath);
		
		 linkSelection.click();
		 
		 Thread.sleep(2000);
		 //switch to main window
		 driver.switchTo().window(parentWindow);
		return linkClicked;
	
}

/*public static void TrUserLogin() throws Exception {
	login(driver, logpath);
	HomeSalesforceClassic homeSFCL= new HomeSalesforceClassic(driver, logpath);
	homeSFCL.loginAsTRUser();

}


public static void loginAsProfileClassic() throws Exception {
	login(driver, logpath);
	HomeSalesforceClassic homeSFCL= new HomeSalesforceClassic(driver, logpath);
	homeSFCL.loginAsProfile();

}*/

public static void selectLookupValueLightning(WebDriver driver,
		WebElement tbx_AccountTextbox, String acc, String nameInApp, String logpath)throws Exception {
	// TODO Auto-generated method stub
	coreFunc.setText(tbx_AccountTextbox, acc, "Textbox", nameInApp, logpath);
	Thread.sleep(6000);
	tbx_AccountTextbox.sendKeys(Keys.ARROW_DOWN);
	//tbx_AccountTextbox.sendKeys(Keys.ARROW_DOWN);
	tbx_AccountTextbox.sendKeys(Keys.ENTER,Keys.TAB);
	Thread.sleep(3000);
}


public static boolean checkEditable(WebElement we, String nameInApp)throws Exception {
	// TODO Auto-generated method stub
	
	boolean editable=false;
	coreFunc.waitForElement(we, 120, nameInApp, false, logpath);
	we.sendKeys("Editable");
	if("Ediatable".equalsIgnoreCase(we.getText())){
		editable=true;
	}
	return editable;
}

}
