
package com.tcs.salesforce.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.salesforce.library.BaseTest;
import com.tcs.salesforce.library.CoreFunctions;
import com.tcs.salesforce.library.SalesforceFunction;
import com.tcs.salesforce.pageobjects.Common.AccountLightSpainQF;
import com.tcs.salesforce.pageobjects.Common.Accounts;




public class POC_KAMValidations extends BaseTest {

	
	@Test
	public  static void kam_001_VerifyCountryFOEditPermissionOnKAMFieldVirtualAccount () throws Exception {
	

	//Name of the scenario under test
	testName="KAM_001_VerifyCountryFOEditPermissionOnKAMFieldVirtualAccount";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	
	
	AccountLightSpainQF accountObj= new AccountLightSpainQF(driver, logpath);
	
	// Step 1: Login into the Application
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 1: Login into the Application as Country FO Manager ", logpath);
		
		  //SalesforceFunction.loginAsBranchUser(driver, logpath);
			SalesforceFunction.login(driver, "Country FO Manager");
			//  SalesforceFunction.loginAsBranchManager(driver, logpath);
		
			
		}catch (Exception e) {
			
			onFailure("Step 1 Failed: Login into applciation"+e);
			e.printStackTrace();
		}
	
	// Step 2: Open existing Virtual Account
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 2: Open existing virtual account", logpath);
		SalesforceFunction.globalSearchLight("Test virtual tcs", logpath);
		
		
		}catch (Exception e) {
			
			onFailure("Step 2 Failed: Open existing Virtual Account"+e);
			e.printStackTrace();
		}

	
	// Step 3: 
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 3: Verify if KAM Field is editable", logpath);
		boolean flag_isEditableCFO=false;
	
		
		//For CFO
		flag_isEditableCFO=accountObj.	verifyIfFieldIsEditable("KAM");
		
		if(!flag_isEditableCFO)
		{
			result=false;
		}
		
		//For Branch user
	/*	boolean flag_isEditableBU=false;
		
		flag_isEditableBU=accountObj.	verifyIfFieldIsEditable("KAM");
		
		if(flag_isEditableBU)
		{
			result=false;
		}

		//For  Branch manager
		
	/*	boolean flag_isEditableBM=false;
		
		if(flag_isEditableBM)
		{
			result=false;
		}
		*/
	
	}catch (Exception e) {
		
		onFailure("Step 3 Failed: verify if KAM field is editable"+e);
		e.printStackTrace();
	}
	
	//Step 4: 
	try{
		CoreFunctions.captureScreenShot(driver, true, "Step 4: Logout", logpath);
		SalesforceFunction.logout(driver, logpath);
		
	}catch (Exception e) {
		
		onFailure("Step 4 Failed: Logout"+e);
		e.printStackTrace();
	}


	Assert.assertEquals(result, true);
	
	
}
	
	

@Test
	public  static void kam_002_VerifyBranchUserEditPermissionOnKAMFieldHQAccount () throws Exception {
	

	//Name of the scenario under test
	testName="KAM_002_VerifyBranchUserEditPermissionOnKAMFieldHQAccount";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	
	
	AccountLightSpainQF accountObj= new AccountLightSpainQF(driver, logpath);
	
	// Step 1: Login into the Application
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 1: Login into the Application as Branch User", logpath);
		
		    SalesforceFunction.login(driver, logpath);
			//SalesforceFunction.loginAsCountryFOManager(driver, logpath);
			 // SalesforceFunction.loginAsBranchManager(driver, logpath);
		
			
			
	}catch (Exception e) {
		
		onFailure("Step 1 Failed: Login into applciation"+e);
		e.printStackTrace();
	}
	// Step 2: Open existing HQ Account
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 2: Open existing HQ account", logpath);
		SalesforceFunction.globalSearchLight("TCSTestAccount_HQ", logpath);
		
		
		

	}catch (Exception e) {
		
		onFailure("Step 2 Failed: Open existing HQ Account"+e);
		e.printStackTrace();
	}
	
	// Step 3: 
	try{
		CoreFunctions.captureScreenShot(driver, false, "Step 3: Verify if KAM Field is editable", logpath);
	/*boolean flag_isEditableCFO=false;
	
		
		//For CFO
		flag_isEditableCFO=accountObj.	verifyIfFieldIsEditable("KAM");
		
		if(!flag_isEditableCFO)
		{
			result=false;
		}
		*/
		//For Branch user
		boolean flag_isEditableBU=false;
		
		flag_isEditableBU=accountObj.	verifyIfFieldIsEditable("KAM");
		
		if(flag_isEditableBU)
		{
			result=false;
		}

		//For  Branch manager
		
	/*	boolean flag_isEditableBM=false;
		
		if(flag_isEditableBM)
		{
			result=false;
		}
	*/

	}catch (Exception e) {
		
		onFailure("Step 3 Failed: verify if KAM field is editable"+e);
		e.printStackTrace();
	}
	
	//Step 4: 
	try{
		CoreFunctions.captureScreenShot(driver, true, "Step 4: Logout", logpath);
		SalesforceFunction.logout(driver, logpath);
		
	}catch (Exception e) {
		
		onFailure("Step 4 Failed: Logout"+e);
		e.printStackTrace();
	}

	Assert.assertEquals(result, true);
	
	
}


@Test
public  static void kam_003_ReplicateKAMInformationOnSiteAccounts() throws Exception {
	
	//Name of the scenario under test
	testName="KAM_003_ReplicateKAMInformationOnSiteAccounts";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	

	//Instantiation of Page objects required for current test
	Accounts acc =new Accounts(driver,logpath);
	
	//Step 1 : Login into the application
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
		SalesforceFunction.login(driver, logpath);
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 1 Failed : Login into the application"+e);
		e.printStackTrace();
	}
	
	String kamValueOnVirtual=null;
	
	//Step 2 : Search for Virtual Account and validate that KAM value Exist
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 2 :  Search for Virtual Account and validate that KAM value Exist ******", logpath);
		SalesforceFunction.globalSearchLight("Test virtual tcs", logpath);
		
		
			if(acc.validateKamFieldExist("Virtual")){
			CoreFunctions.captureScreenShot(driver, true, "Kam exist on Virtual account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam does not exist on virtual account", logpath);
			result=false;
		}
		
			
			kamValueOnVirtual=coreFunc.getText(acc.lnk_KAMValueVirtual_Header, "KAM Value", logpath);
		
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 2 Failed:  Search for Virtual Account and validate that KAM value Exist"+e);
		e.printStackTrace();
	}
	
	//Step 3 : Search for Site HQ having TCS virtual account as parent and validate the KAM Value
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Search for Site HQ having TCS virtual account as parent and validate the KAM Value ******", logpath);
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		
		driver.navigate().refresh();
		if(acc.validateKamFieldExist("HQ")){
		CoreFunctions.captureScreenShot(driver, true, "Kam exist on HQ account", logpath);
		
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam does not exist on HQ account", logpath);
			result=false;
		}
	
		if(kamValueOnVirtual.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValue_Header, "KAM Value on HQ", logpath))){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is inherited from its virtual account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is not inherited from its virtual account", logpath);
			result=false;
		}
		
		
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 3 Failed: Search for Site HQ having TCS virtual account as parent and validate the KAM Value"+e);
		e.printStackTrace();
	}
	//Step 4 : Search for Site and validate the KAM value is properly inherited
		try {
			CoreFunctions.captureScreenShot(driver, false, "******Step 3 :Search for Site and validate the KAM value is properly inherited******", logpath);

			SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC City1 Street_18_09_2019_00_48_49", logpath);
			driver.navigate().refresh();
			
			if(acc.validateKamFieldExist("Site")){
			CoreFunctions.captureScreenShot(driver, true, "Kam exist on site account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam does not exist on site account", logpath);
			result=false;
		}
		
			if(kamValueOnVirtual.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValueSite_Header, "KAM Value on HQ", logpath))){
				CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is inherited from its virtual account", logpath);
				
			}
			else{
				CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is not inherited from its virtual account", logpath);
				result=false;
			}
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 4 Failed: Search for Site and validate the KAM value is properly inherited "+e);
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
	public  static void kam_004_Verify_KAM_Heridity_onNewAccounts() throws Exception {
	
	//Name of the scenario under test
	testName="KAM_004_Verify_KAM_Heridity_onNewAccounts";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	

	//Instantiation of Page objects required for current test
	Accounts acc =new Accounts(driver,logpath);
	
	//Step 1 : Login into the application
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
		SalesforceFunction.login(driver, logpath);
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 1 Failed : Login into the application"+e);
		e.printStackTrace();
	}
	String street=null;
	//Step 2 : Search for Site HQ and create a Site account
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 2 : Search for Site HQ and create a Site account******", logpath);
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		
		//String kamValueOnHQ="Miguel Saúde";
		
		street=acc.createSiteFromHQ();
		driver.navigate().refresh();
		
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 2 Failed: Search for Site HQ and create a Site account"+e);
		e.printStackTrace();
	}
	
	//Step 3 : Get KAM Value of Site HQ and validate KAM value on newly created Site is inherited correctly
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Get KAM Value of Site HQ and validate KAM value on newly created Site is inherited correctly******", logpath);
		
		
		String kamValueOnHQ=coreFunc.getText(acc.lnk_KAMValue_Header,"KAM value on Site HQ", logpath);
		System.out.println("Kam value on HQ:"+ kamValueOnHQ);
	SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC City1 "+street, logpath);
//SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC City1 Street_18_09_2019_00_48_49", logpath);
            driver.navigate().refresh();
			if(acc.validateKamValueOnSite(kamValueOnHQ)){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is inherited from its HQ account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is not inherited from its HQ account", logpath);
			result=false;
		}
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 3 Failed: Get KAM Value of Site HQ and validate KAM value on newly created Site is inherited correctly "+e);
		e.printStackTrace();
	}
	
	//Step 4: 
	try{
		CoreFunctions.captureScreenShot(driver, true, "Step 4: Logout", logpath);
		SalesforceFunction.logout(driver, logpath);
		
	}catch (Exception e) {
		
		onFailure("Step 4 Failed: Logout"+e);
		e.printStackTrace();
	}

	
	Assert.assertEquals(result, true);
	
	
	
	
	
    }
	

	
	@Test
	public  static void kam_005_EditKAMFieldsOnExistingAccount() throws Exception {
	
	//Name of the scenario under test
	testName="KAM_005_EditKAMFieldsOnExistingAccount";
	
	//create a document(logfile) for test case screenshots
	logfileCreation();
	
	
	

	//Instantiation of Page objects required for current test
	Accounts acc =new Accounts(driver,logpath);
	
	//Step 1 : Login into Application
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 1 : Login into the application******", logpath);
		SalesforceFunction.login(driver, "Country FO Manager");

	
		} catch (Exception e) {
			// Mark the test result as fail and take screenshot
			onFailure("Step 1 Failed: Login into the application "+e);
			e.printStackTrace();
		}
	
	
	//Step 2 : Search for Virtual account and update KAM value
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 2 : Search for Virtual account and update KAM value******", logpath);
		SalesforceFunction.globalSearchLight("Test virtual tcs", logpath);
		
		coreFunc.clickObject(acc.lnk_EditVirtual, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameVirtual, logpath, "Edit");
		acc.tbx_AccountNameVirtual.sendKeys(Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldVirtual, "KATIA TITTON", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
	
		coreFunc.clickObject(acc.btn_SaveVirtual, logpath, "Save Button");
		
		Thread.sleep(6000);
		//driver.navigate().refresh();
		} catch (Exception e) {
			// Mark the test result as fail and take screenshot
			onFailure("Step 2 Failed: Search for Virtual account and update KAM value"+e);
			e.printStackTrace();
		}
	
	
	//Step 3 : Search for the Site HQ and Validate the KAM value is updated on HQ as well
	try {
		CoreFunctions.captureScreenShot(driver, false, "******Step 3 : Search for the Site HQ and Validate the KAM value is updated on HQ as well******", logpath);
		
		//intentional failure
		//String kamValueOnVirtual=coreFunc.getText(acc.lnk_KAMValueVirtual_Header, "KAM Value", logpath);
		String kamValueOnVirtual="Miguel Saúde";
		
		
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		
		driver.navigate().refresh();
	
		if(kamValueOnVirtual.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValue_Header, "KAM Value on HQ", logpath))){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on SiteHQ account is updated from its virtual account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on SiteHQ account is not updated from its virtual account", logpath);
			result=false;
			
		}
	
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 3 Failed : Search for the Site HQ and Validate the KAM value is updated on HQ as well"+e);
		e.printStackTrace();
	}
		/*//step 2.............
		
		try{
		coreFunc.clickObject(acc.lnk_EditHQ, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameHQ, logpath, "Edit");
		acc.tbx_AccountNameHQ.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldHQ, "Miguel Saúde", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
		coreFunc.clickObject(acc.btn_SaveHQ, logpath, "Save Button");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		String kamValueOnHQ=coreFunc.getText(acc.lnk_KAMValue_Header, "KAM Value", logpath);
		
		
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC City1 Street_18_09_2019_00_48_49", logpath);
		
		driver.navigate().refresh();
	
		if(kamValueOnHQ.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValueSite_Header, "KAM Value on Site", logpath))){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is updated from its HQ account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is not updated from its HQ account", logpath);
			result=false;
		}
	
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 2 Failed : Login into the application"+e);
		e.printStackTrace();
	}	
		
		
		//step 3 update site and then HQ value will be updated as in HQ
		try{
		coreFunc.clickObject(acc.lnk_EditHQ, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameHQ, logpath, "Edit");
		acc.tbx_AccountNameHQ.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldHQ, "Miguel Saúde", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
		coreFunc.clickObject(acc.btn_SaveHQ, logpath, "Save Button");
		
		Thread.sleep(3000);
		
		
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		coreFunc.clickObject(acc.lnk_EditHQ, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameHQ, logpath, "Edit");
		acc.tbx_AccountNameHQ.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldHQ, "Miguel Saúde", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
		coreFunc.clickObject(acc.btn_SaveHQ, logpath, "Save Button");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		String kamValueOnHQ=coreFunc.getText(acc.lnk_KAMValue_Header, "KAM Value", logpath);
		
		
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC City1 Street_18_09_2019_00_48_49", logpath);
		
		driver.navigate().refresh();
	
		if(kamValueOnHQ.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValueSite_Header, "KAM Value on Site", logpath))){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is updated from its HQ account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on Site account is not updated from its HQ account", logpath);
			result=false;
		}
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 3 Failed : Login into the application"+e);
		e.printStackTrace();
	}
		
		//Step 4 update HQ manually and then update virtual and check KAM value on HQ
		try{
			
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		coreFunc.clickObject(acc.lnk_EditHQ, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameHQ, logpath, "Edit");
		acc.tbx_AccountNameHQ.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldHQ, "Miguel Saúde", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
		coreFunc.clickObject(acc.btn_SaveHQ, logpath, "Save Button");
		
		Thread.sleep(3000);
		
	SalesforceFunction.globalSearchLight("Test virtual tcs", logpath);
		
		coreFunc.clickObject(acc.lnk_EditVirtual, logpath, "Edit");
		coreFunc.clickObject(acc.tbx_AccountNameVirtual, logpath, "Edit");
		acc.tbx_AccountNameVirtual.sendKeys(Keys.TAB,Keys.BACK_SPACE);
		//acc.tbx_AccountNameVirtual.sendKeys();
		//coreFunc.clickObject(acc.icon_deleteKam, logpath, "KAM value delete icon");
		SalesforceFunction.selectLookupValueLightning(driver, acc.tbx_KAMFieldVirtual, "Miguel Saúde", "Kam look up", logpath);
		//coreFunc.setText(acc.tbx_KAMFieldVirtual, "Miguel Saúde", ObjectType, nameInApp, logpath)
	
		coreFunc.clickObject(acc.btn_SaveVirtual, logpath, "Save Button");
		
		Thread.sleep(6000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		System.out.println("KAM value on step 4 virtual before");
		 String kamValueOnVirtual=coreFunc.getText(acc.lnk_KAMValueVirtualDetails, "KAM Value", logpath);
		
		System.out.println("KAM value on step 4 virtual :"+kamValueOnVirtual);
		SalesforceFunction.globalSearchLight("TCS_SiteHQ_POC", logpath);
		
		driver.navigate().refresh();

	
		if(kamValueOnVirtual.equalsIgnoreCase(coreFunc.getText(acc.lnk_KAMValue_Header, "KAM Value on HQ", logpath))){
			CoreFunctions.captureScreenShot(driver, true, "Kam value on SiteHQ account is updated from its virtual account", logpath);
			
		}
		else{
			CoreFunctions.captureScreenShot(driver, true, "Kam value on SiteHQ account is not updated from its virtual account", logpath);
			result=false;
		}
	
	
		
		
		
	} catch (Exception e) {
		// Mark the test result as fail and take screenshot
		onFailure("Step 4 Failed: Validate the created Potential on Branch Account page "+e);
		e.printStackTrace();
	}*/
	
	
	//Step 4: 
	try{
		CoreFunctions.captureScreenShot(driver, true, "Step 4: Logout", logpath);
		SalesforceFunction.logout(driver, logpath);
		
	}catch (Exception e) {
		
		onFailure("Step 4 Failed: Logout"+e);
		e.printStackTrace();
	}
	Assert.assertEquals(result, true);
	
	
	
	
	
    }
	



	
}