package com.tcs.salesforce.tests;

/*Created by: Abhilasha
 * Creation date: 12th Sep 19
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.salesforce.library.BaseTest;
import com.tcs.salesforce.library.CoreFunctions;
import com.tcs.salesforce.library.SalesforceFunction;
import com.tcs.salesforce.pageobjects.Common.HomeSalesforceLight;
import com.tcs.salesforce.pageobjects.Common.OpportunityLightSpainQF;


public class POC_OpportunityValidations extends BaseTest {
	
	@Test
	public static void opp_001_ValidateStagesInLocalOpportunity() throws Exception
	
	{
		//Name of the scenario under test
		testName="OOP_001_ValidateStagesInLocalOpportunity";
		
		//create a document(logfile) for test case screenshots
		logfileCreation();
		
		
		
		HomeSalesforceLight hsf = new HomeSalesforceLight(driver, logpath);
		
		OpportunityLightSpainQF oppObj = new OpportunityLightSpainQF(driver, logpath);

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
			
			SalesforceFunction.globalSearchLight("TCSTestAccount_HQ", logpath);
			 System.out.println("2"+result);
			 
			}catch (Exception e) {
				
				onFailure("Step 2 Failed: Search for the account created by us"+e);
				e.printStackTrace();
			}
			
		//Step 3: click on the related tab and go to the new opportunity button 

			try{
				CoreFunctions.captureScreenShot(driver, true, "Step 3: Click on the related tab and go to the New opportunity", logpath);
				hsf.selectFromRelatedList_Lightning("Related");
				
				coreFunc.scrollIntoView(oppObj.btn_newOpportunity);
				
				coreFunc.clickObject(oppObj.btn_newOpportunity, logpath, "new opportunity button");
				 System.out.println("3"+result);
				 
				
			
			
			}catch (Exception e) {
				
				onFailure("Step 3 Failed: Click on the related tab and go to the New opportunity"+e);
				e.printStackTrace();
			}
		
		//Step 4: verify list of stages in local opportunity
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 4: Verify list of stages in local opportunuity", logpath);

             String[] stagesListFromUser={"Rejected","Presented","Under negotiation","Short List / Visit with trainer","Adjudicated - Sign data pending","Implemented / with execution date"};//testDataValues.get("Stages").split(",");
			
               boolean flag_match=false;
               
               coreFunc.clickObject(oppObj.txt_StageField, logpath, "Stages field in opportunity ");
               
               
               flag_match=oppObj.validateDropdownValuesInLightning(oppObj.lst_opportunityStages, stagesListFromUser, logpath);
			
               System.out.println("Did all values matched"+flag_match);
               System.out.println("4:1"+result);
               
               if(flag_match)
 
       			  CoreFunctions.captureScreenShot(driver, true, "User given stages matched on UI stages list", logpath);
              
               else 
               
               {
          			CoreFunctions.captureScreenShot(driver, true, "User given stages did not match on UI stages list", logpath);
                    result=false;
                    
                  }
               
               
            	   
               System.out.println("4:2"+result);
			
			
			}catch (Exception e) {
				
				onFailure("Step 4 Failed: Verify list of stages in local opportunuity"+e);
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
	public static void opp_002_ValidateStagesInNationalOpportunity() throws Exception
	
	{
		//Name of the scenario under test
				testName="OPP_ValidateStagesInNationalOpportunity";
				
				//create a document(logfile) for test case screenshots
				logfileCreation();
				
				
		//HomeSalesforceLight hsf = new HomeSalesforceLight(driver, logpath);
		
		OpportunityLightSpainQF oppObj = new OpportunityLightSpainQF(driver, logpath);

		//Step 1: Login into Application
		
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 1: Login into Application ", logpath);
			SalesforceFunction.login(driver, "Country FO Manager");
            System.out.println("1"+result);
				
			}catch (Exception e) {
				
				onFailure("Step 1 Failed: Login into applciation"+e);
				e.printStackTrace();
			}
			
		
		
		//Step 2: Go to global search and search for national opportunity
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 2:Search for national opportunity", logpath);
			
			SalesforceFunction.globalSearchLight("TCS Nat Opp",logpath);
			 System.out.println("2"+result);
			
			}catch (Exception e) {
				
				onFailure("Step 2 Failed: Search for national opportunity"+e);
				e.printStackTrace();
			}
			

		
		//Step 3: verify list of stages in national opportunity
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 3: Verify list of stages in national opportunity", logpath);

			//click on edit stage field
			
			coreFunc.clickObject(oppObj.icon_editStage, logpath, "Edit icon");
			
			
             String[] stagesListFromUser={"Identify","Qualify","Develop","Detection","Propose","Win Pending","Implementation","Closed Lost","Closed Won"};//testDataValues.get("Stages").split(",");
			
               boolean flag_match=false;
               
               coreFunc.clickObject(oppObj.txt_StageFieldNationalOpportunity, logpath, "Stages field in national opportnity ");
               
               
               flag_match=oppObj.validateDropdownValuesInLightning(oppObj.lst_opportunityStages, stagesListFromUser, logpath);
			
               System.out.println("Did all values matched"+flag_match);
               System.out.println("4:1"+result);
               
               if(flag_match)
               {
       			  CoreFunctions.captureScreenShot(driver, true, "User given stages matched on UI stages list", logpath);
       			
             
               }
               else {
          			CoreFunctions.captureScreenShot(driver, true, "User given stages did not match on UI stages list", logpath);
                    result=false;
               }
               
            	   
               System.out.println("4:2"+result);
			
					
				}catch (Exception e) {
					
					onFailure("Step 3 Failed: Verify list of stages in national opportunity"+e);
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
	public static void opp_003_ValidateProbabilityFieldEditabilityInLocalOpportunity () throws Exception
	
	{
		

		//Name of the scenario under test
				testName="OPP_003_ValidateProbabilityFieldEditabilityInLocalOpportunity";
				
				//create a document(logfile) for test case screenshots
				logfileCreation();
				
		HomeSalesforceLight hsf = new HomeSalesforceLight(driver, logpath);
		
		OpportunityLightSpainQF oppObj = new OpportunityLightSpainQF(driver, logpath);

		String probabilityValue=null;
		
		//Step 1: Login into Application
		
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 1: Login into Application ", logpath);
			  SalesforceFunction.login(driver, logpath);
				//SalesforceFunction.loginAsCountryFOManager(driver, logpath);
				 // SalesforceFunction.loginAsBranchManager(driver, logpath);
				
			}catch (Exception e) {
				
				onFailure("Step 1 Failed: Login into applciation"+e);
				e.printStackTrace();
			}
			
			
		
		//Step 2: Go to global search and search for account 
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 2:Search for existing account ", logpath);
			
			SalesforceFunction.globalSearchLight("ALFA HEAD CORPORATION SOCIEDAD LIMITADA.", logpath);
			}catch (Exception e) {
				
				onFailure("Step 2 Failed: Search for existing account "+e);
				e.printStackTrace();
			}
		
		//Step 3: click on the related tab and go to the new opportunity button 

			try{
				CoreFunctions.captureScreenShot(driver, true, "Step 3: Click on the related tab and open opportunity creation page", logpath);
				hsf.selectFromRelatedList_Lightning("Related");
				
				coreFunc.scrollIntoView(oppObj.btn_newOpportunity);
				
				coreFunc.clickObject(oppObj.btn_newOpportunity, logpath, "new opportunity button");
			
				
				
			
			
			}catch (Exception e) {
				
				onFailure("Step 3 Failed: Click on the related tab and open opportunity creation page"+e);
				e.printStackTrace();
			}
			
		
		//Step 4: Open local opportunity creation page.Edit probability field> Save opportunity
		
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 4: Enter details in  local opportunity creation page. Edit probability field> Save opportunity" , logpath);

			probabilityValue="15";
			
			oppObj.EnterLocalOppDetails(probabilityValue);
           	oppObj.clickOnSave();
        	coreFunc.waitForPageLoad();
		}catch (Exception e) {
			
			onFailure("Step 4 Failed:Enter details in  local opportunity creation page. Edit probability field> Save opportunity"+e);
			e.printStackTrace();
		}
		
		
  //Step 5: 
		try{
			CoreFunctions.captureScreenShot(driver, true, "Step 5: Validate value of probability in created opportunity", logpath);
			
			coreFunc.waitForElement(oppObj.txt_probabilityValueUI, 10, "Probability value", false, logpath);
			
	
			
			System.out.println("Value of probability from UI"+oppObj.txt_probabilityValueUI.getText().replace("%", "").trim());
			
			
			if(oppObj.txt_probabilityValueUI.getText().replace("%", "").trim().equalsIgnoreCase(probabilityValue))
			{
				System.out.println("Edited");
				CoreFunctions.captureScreenShot(driver, true, "Probability is edited by current user", logpath);
				
				result=false;
			
			}
			else
			{
				System.out.println("Probability field is Not Edited");
				CoreFunctions.captureScreenShot(driver, true, "Probability is NOT edited by current profile user", logpath);
				
			}
		
			
			
		}catch (Exception e) {
			
			onFailure("Step 5 Failed: Validate value of probability in created opportunity"+e);
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
