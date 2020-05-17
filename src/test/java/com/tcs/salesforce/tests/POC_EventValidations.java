
package com.tcs.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.salesforce.library.BaseTest;
import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;
import com.tcs.salesforce.library.SalesforceFunction;
import com.tcs.salesforce.pageobjects.Common.ActivityLightSpainQF;
import com.tcs.salesforce.pageobjects.Common.HomeSalesforceLight;



public class POC_EventValidations extends BaseTest {

	@Test
	public static void event_001_ValidateControlInEvent() throws Exception
	
	{
		//Name of the scenario under test
		testName="EVENT_001_ValidateControlInEvent";
		
		//create a document(logfile) for test case screenshots
		logfileCreation();
		
		
		HomeSalesforceLight hsf = new HomeSalesforceLight(driver, logpath);
		
		ActivityLightSpainQF accObj = new ActivityLightSpainQF(driver, logpath);

		//Step 1: Login into Application
		
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 1: Login into Application ", logpath);
			 SalesforceFunction.login(driver, logpath);
				//SalesforceFunction.loginAsCountryFOManager(driver, logpath);
				 // SalesforceFunction.loginAsBranchManager(driver, logpath);
			  System.out.println("1"+result);
			
			}catch (Exception e) {
				
				onFailure("Step 1 Failed: Login into applciation"+e);
				e.printStackTrace();
			}
			
		
		//Step 2: Go to global search and search for account 
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 2:Search for the account created by us", logpath);
			
			SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
			 System.out.println("2"+result);
			}catch (Exception e) {
				
				onFailure("Step 2 Failed: Search for the account created by us"+e);
				e.printStackTrace();
			}
		
		//Step 3: click on the related tab and go to the new opportunity button 

			try{
				CoreFunctions.captureScreenShot(driver, true, "Step 3: Click on Activity tab and create event for first time withe this user", logpath);
				hsf.selectFromRelatedList_Lightning("Activity");
				coreFunc.waitForPageLoad();
				
				
				accObj.createNewEvent();
				
				System.out.println("3"+result);
				
				}catch (Exception e) {
					
					onFailure("Step 3 Failed:  Click on Activity tab and create event for first time withe this user"+e);
					e.printStackTrace();
				}
			
		//Step 4: Create event for second time with same user
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 4: Create event for second time with same user", logpath);
			CommonUtils.manualWait(5);
			accObj.createNewEvent();
			System.out.println("3"+result);
			
			}catch (Exception e) {
				
				onFailure("Step 4 Failed: Create event for second time with same user"+e);
				e.printStackTrace();
			}

		//Step 5: verify error message
		
		try {
			CoreFunctions.captureScreenShot(driver, true, "Step 5: Validate Error Message when event is created with same contact", logpath);	
			System.out.println("Error msgs:"+accObj.txt_errorMsg.getText());
			
			if(!accObj.txt_errorMsg.getText().equalsIgnoreCase("Error: You already have another visit with same date, same contact and same account."))
					{
				CoreFunctions.captureScreenShot(driver, true, "FAILED: Activity is created with same contact for same day", logpath);
				  result=false;
				
					}
			else
				CoreFunctions.captureScreenShot(driver, true, "PASSED: Activity is NOT created with same contact for same day", logpath);

			}catch (Exception e) {
				
				onFailure("Step 1 Failed: Validate Error Message when event is created with same contact"+e);
				e.printStackTrace();
			}
		
		  //Step 6: 
				try{
					CoreFunctions.captureScreenShot(driver, true, "Step 6: Logout", logpath);
					SalesforceFunction.logout(driver, logpath);
					
				}catch (Exception e) {
					
					onFailure("Step 6 Failed: Logout"+e);
					e.printStackTrace();
				}
		
		Assert.assertEquals(result, true);
	
	}
	
	
    
	

	
}