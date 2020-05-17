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

public class AdeccoMarketPlayer extends LoadableComponent<AdeccoMarketPlayer> {

	WebDriver driver;
	String logpath;
	public CoreFunctions coreFunc;


	//***********************Elements on Branch Account page*****************************************
	@FindBy(how = How.LINK_TEXT, linkText = "Potential Adecco")
	public WebElement lnk_PotentialAdecco;
	
	@FindBy(how = How.CSS, css = "button[class*='slds-button slds-button_icon-border-filled']")
	public WebElement arrow_MenuOptionsOnBranchAccount;

	@FindBy(how = How.LINK_TEXT, linkText = "Related")
	public WebElement tab_Related;	

	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div/div[1]/article/div[2]/header/div[2]/h2/a")
	public WebElement lnk_MarketPlayersSection;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div/div[1]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[2]/td[4]/div/a/lightning-icon/lightning-primitive-icon")
	public WebElement icon_ActionArrow2row;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div/div/ul/li[1]/a")
	public WebElement lnk_EditMarketPlayer;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div/div/ul/li[2]/a")
	public WebElement lnk_DeleteMarketPlayer;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/button[2]")
	public WebElement btn_DeleteOnConfirmWindow;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/td[8]/span/span")
	public WebElement txt_StrengthValueInListView2row;
	
	@FindBy(how = How.CLASS_NAME, className = "Title1")
	public WebElement txt_titlePotentialAdecco;
	
	@FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[2]/header[1]/div[2]/h2[1]/a[1]/span[2]")
	public WebElement txt_MarketPlayerRelatedListNumber;	
	
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div/div[1]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr/td[2]/span")
	public List <WebElement> List_txt_SubservicesValuesOnMarketPlayers;	
	
	//***********************Elements on Adecco Potential page*****************************************
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div/div[2]/div[3]/div[3]/div/div/select")
	public WebElement lst_Service;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div/div[2]/div[4]/div[3]/div/div/select")
	public WebElement lst_SubService;
	
	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div/div[2]/div[5]/div[3]/div/select")
	public WebElement lst_AdeccoBrand;

	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div/div[2]/div[6]/div[3]/span/input")
	public WebElement tbx_PlayerForecast;	

	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/section/div/div[2]/div[10]/div[3]/button")
	public WebElement btn_Save;
	
	//***********************Elements on Adecco Potential Edit page*****************************************
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div[3]/div/div[2]/div[3]/div[3]/div/span")
	public WebElement txt_Service;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div[3]/div/div[2]/div[4]/div[3]/div/span")
	public WebElement txt_SubService;
	
	@FindBy(how = How.XPATH, xpath = ".//*[@id='brandBand_1']/div/div[1]/div[3]/div/div[2]/div[5]/div[3]/span")
	public WebElement txt_AdeccoBrand;

	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div[2]/div[7]/div[3]/div/div/select")
	public WebElement lst_Strength;	

	@FindBy(how = How.XPATH, xpath = "html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div[2]/div[10]/div[3]/button")
	public WebElement btn_SaveEdit;




	public AdeccoMarketPlayer(WebDriver driver, String logpath) {
		
		this.logpath=logpath;
		this.driver = driver;
		coreFunc = new CoreFunctions(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void clickPotentialAdecco() throws Exception {
		coreFunc.clickObject(arrow_MenuOptionsOnBranchAccount, logpath, "Arrow Menu Options");
		coreFunc.clickObject(lnk_PotentialAdecco, logpath, "Potential Adecco");
	}
	
	public String getTitlePotentialAdecco() throws Exception {
		return coreFunc.getText(txt_titlePotentialAdecco, "Title of Adecco Potential Window", logpath);
	}

	public void clickRelatedTab() throws Exception {
		coreFunc.clickObject(tab_Related, logpath, "Related tab");
		Thread.sleep(3000);
	}
	
	public void clickMarketPlayerSectionHeader() throws Exception {
		coreFunc.clickObject(lnk_MarketPlayersSection, logpath, "Related tab");
		Thread.sleep(3000);
	}
	
	public String getMarketPlayerCount() throws Exception {
		return coreFunc.getText(txt_MarketPlayerRelatedListNumber, "Title of Adecco Potential Window", logpath);
	}
	
	public void createAdeccoPotential() throws Exception {
		Thread.sleep(3000);
		coreFunc.setText(lst_Service, "Permanent Placement(Adecco)","ComboBox", "Service", logpath);
		Thread.sleep(3000);
		coreFunc.setText(lst_SubService, "Selection","ComboBox", "Sub-Service", logpath);
		Thread.sleep(3000);
		coreFunc.setText(lst_AdeccoBrand, "Adecco","ComboBox", "Adecco Brand", logpath);
		Thread.sleep(3000);
		coreFunc.setText(tbx_PlayerForecast, "0","Textbox", "Player Forecast", logpath);
		coreFunc.clickObject(btn_Save, logpath, "Save");
		
		Thread.sleep(6000);
		
	}
	
	public void updateAdeccoPotential() throws Exception {
		Thread.sleep(3000);
		coreFunc.setText(lst_Strength, "Quality","ComboBox", "Strength", logpath);
		Thread.sleep(3000);
		
		coreFunc.clickObject(btn_SaveEdit, logpath, "Save");
		
		Thread.sleep(6000);
		
	}
	
	
	public boolean validateMarketPlayerExistOnBranchAccount(String subService) throws Exception {
		
		Thread.sleep(3000);
		
		boolean match=false;
		for(WebElement we : List_txt_SubservicesValuesOnMarketPlayers){
			if(subService.equalsIgnoreCase(we.getText())){
				match=true;
				break;
			}
			
		}
		return match;
	}
	public boolean validateMarketPlayerUpdatedOnBranchAccount(String strength) throws Exception {
		Thread.sleep(3000);
		boolean match=false;
		
			if(strength.equalsIgnoreCase(txt_StrengthValueInListView2row.getText())){
				match=true;				
			}
		return match;
	}
	

	public void clickOnEditMarketPlayer() throws Exception {
		coreFunc.clickObject(icon_ActionArrow2row, logpath, "Action Menu Arrow Icon");
		coreFunc.clickObject(lnk_EditMarketPlayer, logpath, "Edit");
			
	}
	

	public void clickOnDeleteMarketPlayer() throws Exception{
		coreFunc.clickObject(icon_ActionArrow2row, logpath, "Action Menu Arrow Icon");
		coreFunc.clickObject(lnk_DeleteMarketPlayer, logpath, "Delete");
	}

	public void clickDeleteOnConfirmWindow() throws Exception{
		coreFunc.clickObject(btn_DeleteOnConfirmWindow, logpath, "Delete button");
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
