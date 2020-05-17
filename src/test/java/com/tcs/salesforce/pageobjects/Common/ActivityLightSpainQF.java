package com.tcs.salesforce.pageobjects.Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;
import com.tcs.salesforce.library.SalesforceFunction;


public class ActivityLightSpainQF extends LoadableComponent<ActivityLightSpainQF> {

	WebDriver driver;
	String logpath;
	public CoreFunctions coreFunc;


	//***********************Elements on Account details page*****************************************
	@FindBy(how = How.CSS, css = "[title='Create new...']")
	public WebElement txt_toOpenEvent;
	
	@FindBy(how = How.XPATH,xpath="(//*[@class='select'])[1]")
	                               //html/body/div[5]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a
	public WebElement lst_typeEvent;
	
	//@FindBy(how = How.XPATH,xpath="//*[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")
 
	/*@FindBy(how = How.XPATH,xpath="(//input[@title='Search Contacts'])[2]")
	public WebElement lst_contact;*/
	
	@FindBy(how = How.CSS,css="[class='slds-button slds-button--brand cuf-publisherShareButton MEDIUM uiButton']")
	public WebElement btn_save;
	
	
	//@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[1]/a")
	@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[1]/a")
   // @FindBy(how = How.CSS, css = "[class='outputLookupLink slds-truncate outputLookupLink-0031l00000LoRcDAAV-156:14902;a forceOutputLookup']")
	public WebElement lnk_selectedContact;
	
	@FindBy(how = How.CLASS_NAME,className="errorsList")
	public WebElement txt_errorMsg;
	

	
	//******************************************************

	public ActivityLightSpainQF(WebDriver driver, String logpath) {
		
		this.logpath=logpath;
		this.driver = driver;
		coreFunc = new CoreFunctions(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	

	
	
	public void createNewEvent() throws Exception
		
	{
		
		
		CommonUtils.manualWait(4);
		coreFunc.scrollIntoView(txt_toOpenEvent);
		
		coreFunc.clickObject(txt_toOpenEvent, logpath, "Create new event");
		
		CommonUtils.manualWait(6);
		
		
		coreFunc.scrollIntoView(lst_typeEvent);
		
		coreFunc.setText(lst_typeEvent, "Sales Visit", "LINKCOMBOBOX", "Type", logpath);
		coreFunc.sendKeysToElement(lst_typeEvent, Keys.TAB, "TAb key", logpath);
		//coreFunc.sendKeysToElement(lst_typeEvent, Keys., "TAb key", logpath);
		
		WebElement lst_contact=driver.switchTo().activeElement();
		System.out.println("Current active element is displayed"+lst_contact.isDisplayed()+"value of locator"+lst_contact);
		
		
		coreFunc.scrollIntoView(lst_contact);
		
		//coreFunc.sendKeysToElement(lst_contact, Keys.ENTER, "Enter", logpath);
		System.out.println("Entered");
	//	lst_contact.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", lst_contact);
		
		SalesforceFunction.selectLookupValueLightning(driver, lst_contact, "Client_TCS JHA", "Contact", logpath);
	/*	js.executeScript("arguments[0].sendKeys('Client_TCS JHA')", lst_contact);
		js.executeScript("arguments[0].sendKeys('KEYS.ENTER')", lst_contact);
		*/
		
	/*	//lst_contact.sendKeys();
		
		//coreFunc.setText(lst_contact, "Client_TCS JHA", "textbox", "Contact", logpath);
		
	// coreFunc.sendKeysToElement(lst_contact, Keys.ARROW_DOWN, "Down Arrow", logpath);
        //CommonUtils.manualWait(1);
		
		coreFunc.sendKeysToElement(lst_contact, Keys.ENTER, "Enter", logpath);*/
		
		//coreFunc.clickObject(lnk_selectedContact, logpath, "Selected contact");
		
		coreFunc.clickObject(btn_save, logpath, "Save  event");
		
		
		
		
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
