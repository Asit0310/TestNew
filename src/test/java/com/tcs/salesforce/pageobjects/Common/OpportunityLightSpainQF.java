package com.tcs.salesforce.pageobjects.Common;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;

public class OpportunityLightSpainQF extends LoadableComponent<OpportunityLightSpainQF> {
	WebDriver driver;
	String logpath;
	public CoreFunctions coreFunc;

	
	
	//useful in quick fix
	
	@FindBy(how = How.CSS,css="a[title='New Opportunity']")
	public WebElement btn_newOpportunity;
	
	@FindBy(how = How.XPATH,xpath="//*[@role=\"menuitemradio\"]")
	public List<WebElement> lst_opportunityStages;
	
	@FindBy(how = How.XPATH,xpath="(//a[@class='select'])[1]")
	public WebElement  txt_StageField;
	
	@FindBy(how = How.XPATH,xpath="(//*[@class='select']) [1]")
	public WebElement  txt_StageFieldNationalOpportunity;
	
	@FindBy(how = How.CSS,css="button[title='Edit Stage']")
	public WebElement icon_editStage;
	
	/*
	@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[1]/div/header/div[2]/div/div[2]/ul/li[6]/div/div/div/div/a")
	public WebElement icon_arrowOnButtons;
	*/
	@FindBy(how = How.ID,id="p3")
	public WebElement  lst_recordType;
	
	@FindBy(how = How.CSS,css="[title='New Opportunity: Select Opportunity Record Type ~ Salesforce - Unlimited Edition']")
	public WebElement frm_opportunityRecordType;
	
	@FindBy(how = How.CSS,css="[title='Continue']")
	public WebElement btn_continue;
			
	
	
	
	  //***********************Elements on Local Opportunity creation  page*****************************************
    
	@FindBy(how = How.XPATH, xpath = "//iframe")
	public WebElement frm_opportunityFrame;
	
	
    @FindBy(how = How.XPATH, xpath = "(//input[@class=' input'])[1]")
    public WebElement tbx_oppname;      
    
    @FindBy(how = How.XPATH, xpath= "(//a[@class='select'])[1]")
    public WebElement list_stage;    
    
    @FindBy(how = How.XPATH, xpath="(//a[@class='select'])[2]")
    public WebElement list_type;
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[5]/div[2]/div/div/div/input")
    public WebElement tbx_potentialRevenue;
    
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[10]/div[1]/div/div/div/div/div[1]/div/div/a")
    public WebElement list_businessLine;
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[11]/div[1]/div/div/div/div/div[1]/div/div/a")
    public WebElement list_brand;
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[13]/div[1]/div/div/div/div/div/div/div/a")
    public WebElement list_service;
    
    
    @FindBy(how = How.XPATH, xpath="(//*[@class=' input'] )[2]")
    public WebElement txt_closedate;
    
    
   // @FindBy(how = How.XPATH, xpath="(//span[@title='Selection'])")
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[14]/div[1]/div/div/lightning-picklist/lightning-dual-listbox/div/div[2]/div/div[3]/div/ul/li[2]/div/span/span")
	public WebElement txt_Subservice;
    
   // @FindBy(how = How.XPATH, xpath="[title=\"Move selection to Chosen\"]")
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[14]/div[1]/div/div/lightning-picklist/lightning-dual-listbox/div/div[2]/div/div[4]/lightning-button-icon[1]/button")
	public WebElement arrow_Subservice;
    
    @FindBy(how = How.CSS,xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/input")
    public WebElement txt_probability;
    
   
   // @FindBy(how = How.XPATH, xpath="(//button[contains(.,'Save')])[2]")
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/button[3]")
	public WebElement btn_save;
	
	//@FindBy(how = How.XPATH, xpath="(//input[@type='text'])[6]")
    
    @FindBy(how = How.XPATH, xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div[1]/div/input")                       
	public WebElement tbx_accountName;
    
    @FindBy(how = How.XPATH, xpath=" (//*[@class='uiOutputPercent'])[1]")
    public WebElement txt_probabilityValueUI;
	/*
	@FindBy(how= How.XPATH,xpath="html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/section/div/div/article/div[2]/div/div[2]/div/div/div[3]/div[1]/div/div[2]/span")
	public WebElement tbx_validateOppName;
	
	@FindBy(how = How.CSS,css="button[class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']")
	public WebElement btn_Next;
	
	@FindBy(how = How.XPATH, xpath="html/body/div[8]/div/ul/li[1]/a")
	public WebElement btn_newOppNational;
	*/
	
	
/********************************************************************/
			
			public OpportunityLightSpainQF(WebDriver driver, String logpath) {
				
				this.logpath=logpath;
				this.driver = driver;
				coreFunc = new CoreFunctions(driver);
				// This initElements method will create all WebElements
				PageFactory.initElements(driver, this);

			}
				
			
			//Validate all values of list in a field

			public  boolean validateDropdownValuesInLightning(List<WebElement> dropdownName , String[] values,String logpath) throws Exception {
				
				boolean matchResult=true;//overall match status
				
				int dropdownSize=dropdownName.size();
				
				System.out.println("First Option : "+dropdownName.get(0).getText());
				
				
				if(dropdownName.get(0).getText().contains("Select")||dropdownName.get(0).getText().contains("None")){
				System.out.println("Drop down size is decreased because first option is:"+dropdownName.get(0).getText());
					dropdownSize=dropdownSize-1;
				}
				
				
				
				System.out.println("User input count: "+values.length+"From UI: count "+dropdownSize);
				
				
				if(values.length==dropdownSize){
							
							for(int i=0; i< values.length;i++){
								
								boolean match=false;//each value match status
								
								for(WebElement we: dropdownName){
										
									if(we.getText().equalsIgnoreCase(values[i])){
							    			match=true;
							    			System.out.println("matched");
							    			coreFunc.scrollIntoView(we);
							    			
							    			CoreFunctions.captureScreenShot(driver, true, values[i]+"\t is available in dropdown", logpath);						    			
				                             break;
				                             
									
									}
								
								}
									
						    	if(!match){
					    			CoreFunctions.captureScreenShot(driver, true, values[i]+"\t is NOT available in dropdown", logpath);						    			

						    		matchResult=false;
						    	}
						    	
						    	
						    	
						    }
							
					
					}
				
				else{  
	    			CoreFunctions.captureScreenShot(driver, true, "User provided input length does notmatch with list elements available in dropdown", logpath);						    			

                    matchResult=false;
				}
					
					
					return matchResult;
					
			}
					
			// Enter all fields in the opportunity page to create Local opportunity
			   
			public void EnterLocalOppDetails(String probabilityValue) throws Exception
			{    
				CommonUtils.manualWait(3);
				coreFunc.scrollIntoView(tbx_oppname);
				
				coreFunc.setText(tbx_oppname, "TCS_Auto_Opp_"+CommonUtils.getDate(0, null), "TextBox", "Opportunity Name", logpath);
				
				coreFunc.scrollIntoView(list_stage);
				coreFunc.setText(list_stage, "Presented", "LINKCOMBOBOX", "Stage", logpath);
				
				
				
				
				coreFunc.scrollIntoView(list_type);
				coreFunc.setText(list_type, "Existing Client: Expansion within Scope", "LINKCOMBOBOX", "Client Type", logpath);
			
			//	
				
				coreFunc.scrollIntoView(txt_closedate);
				coreFunc.setText(txt_closedate, ""+CommonUtils.getDate(5, "dd/MM/YYYY") , "TextBox", "Close Date", logpath);
				coreFunc.sendKeysToElement(txt_closedate, Keys.TAB, "Close Date", logpath);
				
				coreFunc.scrollIntoView(tbx_potentialRevenue);
				coreFunc.setText(tbx_potentialRevenue, "8745142", "TextBox", "Potential Revenue", logpath);
				
			
				
				//coreFunc.setText(txt_probability, "40" , "TextBox", "Probability", logpath);
				
				
	
				
				
				coreFunc.scrollIntoView(list_businessLine);
				coreFunc.setText(list_businessLine, "Staffing", "LINKCOMBOBOX", "Business Line", logpath);
				
				coreFunc.scrollIntoView(list_brand);
				
				coreFunc.setText(list_brand, "Adecco", "LINKCOMBOBOX", "Brand", logpath);
				
				
				coreFunc.setText(list_service,"Permanent Placement(Adecco)","LINKCOMBOBOX", "Service", logpath);
				
				//auto filled with branch user
		           coreFunc.setText(tbx_accountName, "ALFA HEAD CORPORATION SOCIEDAD LIMITADA.", "TextBox", "Account Name", logpath);
				   coreFunc.sendKeysToElement(tbx_accountName, Keys.ARROW_DOWN, "Down Arrow", logpath);
				   coreFunc.sendKeysToElement(tbx_accountName, Keys.ENTER, "Enter ", logpath);
				   

					coreFunc.scrollIntoView(txt_Subservice);
					coreFunc.clickObject(txt_Subservice, logpath, "value of subservice selected");
					coreFunc.clickObject(arrow_Subservice, logpath, "arrow pressed");
		
					
					coreFunc.scrollIntoView(txt_probability);
					coreFunc.clickObject(txt_probability, logpath, "probability text field");
			
			         txt_probability.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
	                   CommonUtils.manualWait(2);
					
					txt_probability.sendKeys(probabilityValue);
					
					CoreFunctions.captureScreenShot(driver, true, "Probability is edited", logpath);
					
				
			}
			
			
			
			
		//Validate probability according to stage: Not required
			
			public void checkProbabilityAccordingToStage(String stageName) throws Exception
			{
				
				int probability=(Integer) null;
				
				switch(stageName)
				{
				case "Rejected":
					probability=0 ;
					break;
				case "Presented":
					probability=10 ;
					break;
					
				case "Under negotiation":
					probability=25 ;
					break;
					
				case "Short List / Visit with trainer":
					probability=50 ;
					break;
					
				case "Adjudicated - Sign data pending":
					probability=75 ;
					break;
					
				case "Implemented / with execution date":
					probability=100 ;
					break;
					
					
					default:
					{
						System.out.println(stageName+"\tstage is not available");
		    			CoreFunctions.captureScreenShot(driver, true, stageName+"Stage is not listed here  ", logpath);						    			

						break;
					}
					
				}
				
				
				
				
			}
			
			
			public void clickOnSave() throws Exception
			{
				
				coreFunc.clickObject(btn_save, logpath, "Save button");
				
			}
			
			@Override
			protected void isLoaded() throws Error {
				try {
					CommonUtils.manualWait(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			@Override
			protected void load() {
				// TODO Auto-generated method stub

			}


}

