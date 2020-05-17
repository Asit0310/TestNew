package com.tcs.salesforce.pageobjects.Common;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.tcs.salesforce.library.CommonConstants;
import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;
public class HomeSalesforceLight extends LoadableComponent<HomeSalesforceLight> {

	WebDriver driver;
	String logpath;
	
	public CoreFunctions coreFunc;
	
	//***********************Elements on Home Page *****************************************
	
	@FindBy(how = How.CSS, css = "input[placeholder*='Search Salesforce']")
	public WebElement tbx_searchBox;
	                                //.//*[@id='brandBand_1']/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]/div/div[1]/h2/a
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/div/div[1]/h2/a")
	public WebElement lnk_SearchObject;
	
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a")
	public List<WebElement> lnk_searchResult;
	
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]/span/button")
	public WebElement icn_loggedinuser;
									
	
	@FindBy(how = How.LINK_TEXT, linkText = "Log Out")
	public WebElement lnk_logout;
	
	//@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/a[2]")
	//public WebElement lnk_logout;
	//html/body/div[5]/div[1]/section/header/div[2]/span/ul/li[6]/div/div/div[1]/div/div/a/div
	//@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/div[2]/header/div[2]/span/ul/li[6]/div/div/div[1]/div/div/a/div")
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/header/div[2]/span/ul/li[6]/div/div/div[1]/div/div/a/div")
	public WebElement icn_setup;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='related_setup_app_home']/a/div[1]/div[1]/span/span[2]")
	public WebElement icn_setupOnActionMenu;
								      
	@FindBy(how = How.XPATH, xpath = ".//*[@id='oneHeader']/div[3]/one-appnav/div/div/div/nav/one-app-launcher-header/button")
	public WebElement btn_AppLauncher;
	
/*	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div/div/div/div/div[1]/div[1]/div/div/div[1]/div/h2")
	public WebElement txt_FirstHeadingHomePage;*/
	
	
	
	/********************Elements on App launcher****************/
	
	@FindBy(how = How.LINK_TEXT, linkText = "Prospection app (MCS)")
	public WebElement lnk_MCSLink;
								   // html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/ul/li/a/span/span
	@FindBy(how = How.XPATH, xpath = "html[1]/body[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li/a[1]/span[1]/span[1]")
	public List<WebElement> List_lnk_AllItems;
	
/*	@FindBy(how = How.TAG_NAME, tagName = "//a")
	public List<WebElement> List_lnk_AllItems;*/
	
	//Elements on any object detail page
	@FindBy(how = How.CSS, css = "span[class='title']")
	//@FindBy(how = How.CSS, css =  "[class='slds-tabs_default__link']")
	public  List <WebElement> tab_relatedList;
	
	
	/******************** Elements on Set Up page  ****************/
	@FindBy(how = How.LINK_TEXT, linkText = "Users")
	public WebElement lnk_Users;
	
	@FindBy(how = How.LINK_TEXT, linkText = "Profiles")
	public WebElement lnk_Profiles;
	
	@FindBy(how = How.TAG_NAME, tagName = "iframe")
	public WebElement frm_Profiles;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[1]/div[1]/div[1]/h1")
	public WebElement lbl_Userprofiles;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[3]/div[1]/div/div[2]/table/tbody/tr/th/a")
	public List<WebElement> List_lnk_Profiles;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div/div[5]/div[2]/div/form/div[1]/div/div[1]/table/tbody/tr/td[2]/input")
	public WebElement btn_ViewUsers;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='ResetForm']/div[2]/table/tbody/tr[1]/th[7]/a")
	public WebElement lnk_ActiveColoumn;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='ResetForm']/div[2]/table/tbody/tr[1]/th[7]/a/img")
	public WebElement img_ActiveColoumnSortArrow;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='ResetForm']/div[2]/table/tbody/tr[2]/th/a")
	public WebElement lnk_FirstUserName;
	
	
	/******************** Elements on User details page  ****************/
	@FindBy(how = How.XPATH, xpath = ".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[13]/td[2]")
	public WebElement txt_Language;
	
	@FindBy(how = How.NAME, name = "edit")
	public WebElement btn_Edit;
	
	@FindBy(how = How.NAME, name = "login")
	public WebElement btn_Login;
	
	/******************** Elements on User details Edit page  ****************/
	@FindBy(how = How.NAME, name = "LanguageLocaleKey")
	public WebElement lst_Language;
	
	@FindBy(how = How.NAME, name = "save")
	public WebElement btn_Save;
	
	public HomeSalesforceLight(WebDriver driver, String logpath) {
		
		this.logpath=logpath;
		this.driver = driver;
		coreFunc = new CoreFunctions(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	public void clickLogout()throws Exception {
		coreFunc.clickObject(lnk_logout, logpath, "Logout");
	}

	public void clickloggedinuser()throws Exception {
		coreFunc.clickObject(icn_loggedinuser, logpath, "Logged in user icon");
	}
	
/*	public void clickSearchResults()throws Exception {
		coreFunc.clickObject(lnk_searchResult, logpath, "First search result");
	}
	*/
	public void enterSearchText(String value)throws Exception {
		coreFunc.setText(tbx_searchBox, value, "TextBox", "Global Search", logpath);
	}
	
	public void clickAppLauncher()throws Exception {
		//coreFunc.waitForElement(txt_FirstHeadingHomePage, CommonConstants.webDriverWaitTime, "First heading on home page", false, logpath);
		coreFunc.waitForPageLoad();
		CommonUtils.manualWait(5);
		coreFunc.waitForElement(btn_AppLauncher, CommonConstants.webDriverWaitTime, "App launcher icon", false, logpath);
		while(!btn_AppLauncher.isEnabled()){
			Thread.sleep(3000);
		}
		coreFunc.clickObject(btn_AppLauncher, logpath, "App Launcher");
		Thread.sleep(6000);
	}
	
	public void clickMCSLink()throws Exception {
		
		coreFunc.clickObject(lnk_MCSLink, logpath, "MCS");
	}
	
	public void clickSetUp()throws Exception {
		Thread.sleep(12000);
		coreFunc.clickObject(icn_setup, logpath, "Setup icon");
		
		coreFunc.clickObject(icn_setupOnActionMenu, logpath, "Setup icon on Action menu");
	}
	
	public void clickUsers()throws Exception {
		coreFunc.clickObject(lnk_Users, logpath, "Users");
		
	}
	
	public void clickProfiles()throws Exception {
		coreFunc.clickObject(lnk_Profiles, logpath, "Profiles");
		
	}
	
	public void switchTOProfilesFrame()throws Exception {
		coreFunc.waitForElement(frm_Profiles, CommonConstants.webDriverWaitTime, "Profiles frame", false, logpath);
		CommonUtils.manualWait(3);
		driver.switchTo().frame(frm_Profiles);
		
	}
	
	
	public void clickDesiredProfile(String profileName)throws Exception {
		switchTOProfilesFrame();
		coreFunc.waitForElement(lbl_Userprofiles, CommonConstants.webDriverWaitTime, "User Profiles", false	, logpath);
		System.out.println("Profile Name : "+ profileName);
		coreFunc.waitForPageLoad();
		for(WebElement we: List_lnk_Profiles){
			if(we.getText().equalsIgnoreCase(profileName)){
				coreFunc.clickObject(we, logpath, profileName);
				break;
			}
		}
		driver.switchTo().parentFrame();
		
	}
	
	public void clickViewUsers()throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(btn_ViewUsers, logpath, "View Users");
		driver.switchTo().parentFrame();
		
	}
	
	public String getTitleActiveColumnSortArrow()throws Exception {
		switchTOProfilesFrame();
		String title=img_ActiveColoumnSortArrow.getAttribute("title");
		driver.switchTo().parentFrame();
		return title;
	}
	
	public void clickActiveColumnHeader()throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(lnk_ActiveColoumn, logpath, "Active Column");
		driver.switchTo().parentFrame();
		
	}
	
	public boolean FirstUserNameIsDisplayed()throws Exception {
		switchTOProfilesFrame();
		boolean exist=coreFunc.waitForElement(lnk_FirstUserName, 5, "First User Name", false, logpath);
		driver.switchTo().parentFrame();
		return exist;
	}
	public String clickFirstUserName()throws Exception {
		switchTOProfilesFrame();
		Thread.sleep(3000);
		String username=lnk_FirstUserName.getText();
		coreFunc.clickObject(lnk_FirstUserName, logpath, username);
		driver.switchTo().parentFrame();
		return username;
		
	}
	
	public String getUserLanguage()throws Exception {
		switchTOProfilesFrame();
		String language=coreFunc.getText(txt_Language, "Language", logpath);
		driver.switchTo().parentFrame();
		return language;
		
	}
	
	public void clickEditUser()throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(btn_Edit, logpath, "Edit");
		driver.switchTo().parentFrame();
		
	}
	
	public void selectLanguage(String language)throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(lst_Language, logpath, "Language");
		driver.switchTo().parentFrame();
		
	}
	
	public void saveUserDetails()throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(btn_Save, logpath, "Language");
		driver.switchTo().parentFrame();
		
	}
	
	public void clickLogin()throws Exception {
		switchTOProfilesFrame();
		coreFunc.clickObject(btn_Login, logpath, "Login");
		driver.switchTo().parentFrame();
	}
	
	
	public  void selectFromRelatedList_Lightning(String toBeClickedTab) throws Exception
	{
		
		coreFunc.waitForPageLoad();
		
		CommonUtils.manualWait(1);
		
		System.out.println("Selected related tab, size of all tab list"+tab_relatedList.size());
		
		for (WebElement objTab:tab_relatedList)
		{
			//System.out.println("Is related tab visible"+objTab.isDisplayed());
			System.out.println(objTab.getText());
			
			if(toBeClickedTab.trim().equalsIgnoreCase(objTab.getText()))
			{
				coreFunc.scrollIntoView(objTab);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", objTab);
				
				//coreFunc.clickObject(objTab,  logpath,objTab.getText()+"\t is clicked");
				//coreFunc.waitForPageLoad();
				
				CoreFunctions.captureScreenShot(driver, true, toBeClickedTab+"\t tab is selected", logpath);
				
				break;
			}
			
			
		}
		
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
