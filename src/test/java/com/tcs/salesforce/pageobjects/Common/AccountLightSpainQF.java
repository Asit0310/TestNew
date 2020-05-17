package com.tcs.salesforce.pageobjects.Common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;


public class AccountLightSpainQF extends LoadableComponent<AccountLightSpainQF> {

	WebDriver driver;
	String logpath;
	public CoreFunctions coreFunc;


	//***********************Elements on Account details page*****************************************
	@FindBy(how = How.CSS, css = "a[title='Edit']")
	public WebElement btn_Edit;
	
	@FindBy(how = How.CSS, css="button[class='slds-button test-id__inline-edit-trigger slds-button_icon slds-button_icon-small slds-shrink-none inline-edit-trigger slds-button_icon-container']")
	public List<WebElement> icon_EditPencil;
	
	@FindBy(how = How.XPATH,xpath="//span[@class='deleteIcon']")
	public WebElement icon_deleteKAMField;
	
	
	
	//******************************************************

	public AccountLightSpainQF(WebDriver driver, String logpath) {
		
		this.logpath=logpath;
		this.driver = driver;
		coreFunc = new CoreFunctions(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	

	//Check if edit field(pencil) is available in any field: works for all fields in details section. 
	
	public boolean verifyIfFieldIsEditable(String fieldToVerify) throws Exception
	{
		CommonUtils.manualWait(15);
		System.out.println("Number of editable fields "+icon_EditPencil.size());
		
		//We will use loop to check title of editable field with user provided input: ie in case of KAM field, it would look for this field in list of editable fields for particular field
	
		boolean flag_matched=false;
		
		for(WebElement editableFields:icon_EditPencil)
		{
			coreFunc.scrollIntoView(editableFields);
			
			System.out.println("Field from UI:"+editableFields.getAttribute("title").trim()+"\n field from user"+"Edit "+fieldToVerify);
			
			if(editableFields.getAttribute("title").trim().equalsIgnoreCase("Edit "+fieldToVerify))
			{
				System.out.println(fieldToVerify+"is Editable");
				//Add logic to Edit if required
				flag_matched=true;
				
				
				CoreFunctions.captureScreenShot(driver, true, fieldToVerify+" Field is editable for this profile", logpath);
				//Edit it by clearing it:
				coreFunc.scrollIntoView(editableFields);
				
				coreFunc.clickObject(editableFields, logpath, "Edit icon ");
				
				coreFunc.clickObject(icon_deleteKAMField, logpath, "delete icon");
				
				
				CoreFunctions.captureScreenShot(driver, true, "existing KAM Field value is cleared and saved", logpath);

				
				break;
			}
			
			
		}
		
		if(!flag_matched)
		{
			System.out.println("Field is not editable");
			CoreFunctions.captureScreenShot(driver, true, fieldToVerify+" Field is NOT editable for this profile", logpath);

		}
		return flag_matched;
		
		
		
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
