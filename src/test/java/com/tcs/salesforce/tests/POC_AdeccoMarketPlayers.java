
package com.tcs.salesforce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.salesforce.library.BaseTest;
import com.tcs.salesforce.library.CoreFunctions;
import com.tcs.salesforce.library.SalesforceFunction;
import com.tcs.salesforce.pageobjects.Common.AdeccoMarketPlayer;



public class POC_AdeccoMarketPlayers extends BaseTest {

@Test
//@Parameters("branchAccount")
	public  static void mp_001_PotentialAdeccoCreation() throws Exception {
	
	//Name of the scenario under test
	testName="MP_001_PotentialAdeccoCreation";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	

	//Instantiation of Page objects required for current test
	//HomeSalesforceLight homeLT=new HomeSalesforceLight(driver, logpath);
	AdeccoMarketPlayer amp = new AdeccoMarketPlayer(driver, logpath);
	
	//Step 1 : Login into the application
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
		SalesforceFunction.login(driver, logpath);
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 1 Failed : Login into the application"+e);
		e.printStackTrace();
	}
	
	//Step 2 : Search for an existing branch account and open details page
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 2 : Search for an existing branch account and open details page******", logpath);
		SalesforceFunction.globalSearchLight("BRT13848792", logpath);
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 2 Failed: Search for an existing branch account and open details page"+e);
		e.printStackTrace();
	}
	
	//Step 3 : Create new Potential Adecco and Validate title of Potential Adecco Creation page
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Create new Potential Adecco and Validate title of Potential Adecco Creation page******", logpath);
		amp.clickPotentialAdecco();
		if("New Potential Adecco".trim().equalsIgnoreCase(amp.getTitlePotentialAdecco().trim())){
			CoreFunctions.captureScreenShot(driver, true, "Validation Passed : Title of the window is as expected", logpath);
		}
		else{
			onFailure("Validation Failed : Title of the window is not expected");
		}
		
		amp.createAdeccoPotential();
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 3 Failed: Create new Potential Adecco and Validate title of Potential Adecco Creation page "+e);
		e.printStackTrace();
	}
	//Step 4 : Validate the created Potential on Branch Account page
		try {
			CoreFunctions.captureScreenShot(driver, false, "******Step 4 : Validate the created Potential on Branch Account page******", logpath);
				driver.navigate().refresh();
		amp.clickRelatedTab();
		
		if(amp.validateMarketPlayerExistOnBranchAccount("Selection")){
			CoreFunctions.captureScreenShot(driver, true, "Market Player created successfully", logpath);
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Market Player is not created successfully", logpath);
			result=false;
		}
		
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 4 Failed: Validate the created Potential on Branch Account page "+e);
		e.printStackTrace();
	}
	
		
		  //Step 5: 
				try{
					CoreFunctions.captureScreenShot(driver, true, "Step 5: Logout", logpath);
					SalesforceFunction.logout(driver, logpath);
					
				}catch (Exception e) {
					
					onFailure("Step 5 Failed: Logout"+e);
					e.printStackTrace();
				}
	Assert.assertEquals(result, true);
	
	
	
	
	
    }
	


@Test
public  static void mp_002_EditMarketPlayer() throws Exception {

//Name of the scenario under test
testName="MP_002_EditMarketPlayer";

//create a document(logfile) for test case screenshots
logfileCreation();

AdeccoMarketPlayer amp = new AdeccoMarketPlayer(driver, logpath);



//Step 1 : Login into the application
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
	SalesforceFunction.login(driver, logpath);
	
} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 1 Failed : Login into the application"+e);
	e.printStackTrace();
}

//Step 2 : Search for an existing branch account and open details page
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 2 : Search for an existing branch account and open details page******", logpath);
	SalesforceFunction.globalSearchLight("BRT43135006", logpath);
	
	
	} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 2 Failed: Search for an existing branch account and open details page"+e);
	e.printStackTrace();
	}

//Step 3 : Update existing Market Player
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Update existing Market Player******", logpath);
	
	amp.clickRelatedTab();
	//System.out.println("Number of market players :"+amp.getMarketPlayerCount());.
	amp.clickOnEditMarketPlayer();
	coreFunc.waitForElement(amp.txt_Service, 120, "Edit Page", false, logpath);
	
	amp.updateAdeccoPotential();
	
	} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 3 Failed: Update existing Market Player"+e);
	e.printStackTrace();
	}

//Step 4 : Validate the updated Market Player value
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 4 : Validate the updated Market Player value******", logpath);
	
	amp.clickRelatedTab();
	amp.clickMarketPlayerSectionHeader();
	if(amp.validateMarketPlayerUpdatedOnBranchAccount("Quality")){
		CoreFunctions.captureScreenShot(driver, true, "Validation Passed : Market Player updated successfully with the strength value", logpath);
	}else{
		CoreFunctions.captureScreenShot(driver, true, "Validation Passed : Market Player is not updated successfully with the correct Strength Value", logpath);
		result=false;
	}
	
	
} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 4 Failed: Validate the updated Market Player value"+e);
	e.printStackTrace();
}

//Step 5: 
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 5: Logout", logpath);
			SalesforceFunction.logout(driver, logpath);
			
		}catch (Exception e) {
			
			onFailure("Step 5 Failed: Logout"+e);
			e.printStackTrace();
		}
Assert.assertEquals(result, true);





}

@Test
public  static void mp_003_DeleteMarketPlayer() throws Exception {

//Name of the scenario under test
testName="MP_003_DeleteMarketPlayer";

//create a document(logfile) for test case screenshots
logfileCreation();



AdeccoMarketPlayer amp = new AdeccoMarketPlayer(driver, logpath);



//Step 1 : Login into the application
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
	SalesforceFunction.login(driver, logpath);
	
} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 1 Failed : Login into the application"+e);
	e.printStackTrace();
}

//Step 2 : Search for an existing branch account and open details page
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 2 : Search for an existing branch account and open details page******", logpath);
	SalesforceFunction.globalSearchLight("BRT43135006", logpath);
	} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 2 Failed: Search for an existing branch account and open details page"+e);
	e.printStackTrace();
	}

	
	

//Step 3 : Delete an existing Market Player
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Delete an existing Market Player******", logpath);
	amp.clickRelatedTab();
	amp.clickOnDeleteMarketPlayer();
	amp.clickDeleteOnConfirmWindow();
	
	} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 3 Failed: Delete an existing Market Player"+e);
	e.printStackTrace();
	}

//Step 4 : Verify that the Market player is deleted from Branch account
try {
	CoreFunctions.captureScreenShot(driver, false, "******Step 4 : Verify that the Market player is deleted from Branch account******", logpath);
	
	driver.navigate().refresh();
	amp.clickRelatedTab();
	
	
	if(amp.validateMarketPlayerExistOnBranchAccount("Selection")){
		CoreFunctions.captureScreenShot(driver, true, "Market Player is not deleted successfully", logpath);
		result=false;
	}
	else{
		CoreFunctions.captureScreenShot(driver, true, "Market Player is deleted successfully", logpath);
	}
	
} catch (Exception e) {
	// Mark the test result as fail and take screenshot
	onFailure("Step 4 Failed: Verify that the Market player is deleted from Branch account"+e);
	e.printStackTrace();
}

//Step 5: 
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 5: Logout", logpath);
			SalesforceFunction.logout(driver, logpath);
			
		}catch (Exception e) {
			
			onFailure("Step 5 Failed: Logout"+e);
			e.printStackTrace();
		}
Assert.assertEquals(result, true);




}

	
}