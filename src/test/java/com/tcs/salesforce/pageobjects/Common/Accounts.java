package com.tcs.salesforce.pageobjects.Common;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;




	public class Accounts extends LoadableComponent<Accounts> {
		
		WebDriver driver;
		String logpath;
		public CoreFunctions coreFunc;

		@FindBy(how = How.XPATH,xpath="//*[@title='Accounts']")
		public WebElement lnk_Account;
		
		@FindBy(how = How.XPATH,xpath="//*[@title='New']")
		public WebElement btn_New;
		
		@FindBy(how = How.XPATH,xpath="//*[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']")
		public WebElement btn_Next;
		
		@FindBy(how = How.XPATH, xpath = "html[1]/body[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/force-aloha-page[1]/div[1]/iframe[1]")
	    public WebElement frm_AccountFrame;
		
		@FindBy(how = How.XPATH,xpath=".//*[@id='lightning']/div[2]/div[2]/div[9]/div[2]/span/span/button")
		public WebElement btn_CreateSiteManually; 
									 
		@FindBy(how = How.XPATH,xpath="html/body/div[1]/div[2]/div[2]/div[2]/div/table/tr[1]/td[1]/select")
		public WebElement lst_AccountCriteraOption;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[1]/div[2]/div[2]/div[2]/div/table/tr[1]/td[2]/select")
		public WebElement lst_Operator;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[1]/div[2]/div[2]/div[2]/div/table/tr[1]/td[3]/input")
		public WebElement txt_accountCriteriaValue;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[1]/div[2]/div[2]/div[2]/div/table/tr[1]/td[4]/button")
		public WebElement btn_add;
		
		
		@FindBy(how = How.XPATH,xpath="html/body/div[1]/div[2]/div[2]/div[3]/div/div/span[1]/button")
		public WebElement btn_searchIcon;
		
		@FindBy(how = How.XPATH,xpath="//*[@id='lightning']/div[2]/div[2]/div[7]/table/tbody/tr/td[3]/span/span")
		public WebElement chbx_HQSite;
		
		@FindBy(how = How.XPATH,xpath="//*[@id='lightning']/div[2]/div[2]/div[7]/table/tbody/tr[1]/td[1]/span/div/label/span")
		public WebElement chbx_accountselected;
		
		@FindBy(how = How.XPATH,xpath="//*[@id='lightning']/div[2]/div[2]/div[4]/div[1]/span[2]/span/button")
		public WebElement btn_AccountCreation;
		
		@FindBy(how = How.XPATH,xpath="//*[@id='lightning']/div[2]/div[2]/div[7]/table/tbody/tr[1]/td[4]/span")
		public WebElement lbl_Exteranl_DB_Accountname;
		

		
		@FindBy(how = How.XPATH,xpath="//*[@id='creationResult']/div/div/div[2]/div/table/tbody/tr/td[1]/span/a")
		public WebElement lnk_CreatedAccount;
		
	
		
		@FindBy(how = How.XPATH,xpath="(//*[@class='uiOutputText'])[1]")
		public WebElement tbx_CreatedAccountName;
		
		@FindBy(how = How.XPATH,xpath="(//*[@class='uiOutputPhone'])[2]")
		public WebElement tbx_AccountPhoneNo;
		
		@FindBy(how = How.XPATH,xpath="(//*[@class='uiOutputURL'])[1]")
		public WebElement tbx_Website;
		
		

		@FindBy(how = How.XPATH,xpath="//*[@title='Edit']")
		public WebElement lnk_Edit;
		
		
		
		@FindBy(how = How.XPATH,xpath="html[1]/body[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
		public WebElement tbx_Accname;
		
	
		
		@FindBy(how = How.XPATH,xpath="//*[@type='url']")
		public WebElement tbx_site;
		
		@FindBy(how = How.XPATH,xpath="//*[@title='Save']")
		public WebElement btn_save;
		
		
		
	//	**************** Elements on Site HQ account details Page**************************************
		
									   //html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[1]/div/header/div[2]/ul/li[5]/div/div/div/div/a
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[1]/div/header/div[2]/ul/li[5]/div/div/div/div/a")
		public WebElement lnk_KAMValue_Header;
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[1]/section/div/div/div[1]/div[1]/div/div[1]/div/div[1]/div/header/div[2]/ul/li[5]/div/div/div/div/a")
		public WebElement lnk_KAMValueSite_Header;
		
		@FindBy(how = How.CLASS_NAME ,className="test-id__field-label")
		public List<WebElement> List_txt_FiledlabelsHQ;
		
		@FindBy(how = How.CSS ,css=".test-id__field-label")
		public List<WebElement> List_txt_FiledlabelsSite;
		
		@FindBy(how = How.LINK_TEXT,  linkText="New Site")
		public WebElement lnk_NewSite;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[1]/div[2]/div/div/div/input")
		public WebElement tbx_Phone;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[4]/div[1]/div/div/div/div/div[1]/div/div/a")
		public WebElement lst_RangeOfEmplyoees;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[6]/div[1]/div/div/fieldset/div/div[3]/div/div/textarea")
		public WebElement textArea_Street;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[6]/div[1]/div/div/fieldset/div/div[4]/div/div/input")
		public WebElement tbx_City;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[6]/div[1]/div/div/fieldset/div/div[5]/div[1]/div/input")
		public WebElement tbx_PostalCode;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[6]/div[1]/div/div/fieldset/div/div[5]/div[2]/div/div/div[1]/div/div/a")
		public WebElement lst_StateProvince;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[1]/div[1]/div/div/div/div/div/div[1]/div/input")
		public WebElement tbx_AccountName;
		
		@FindBy(how = How.XPATH,xpath="html/body/div[5]/div[2]/div/div[2]/div/div[3]/button[2]")
		public WebElement btn_SaveSite;
		
		
		//	**************** Elements on HQ Edit details Page**************************************
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[3]/div/button[3]")
		public WebElement btn_SaveHQ;
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div/div/input")
		public WebElement tbx_AccountNameHQ;
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[7]/div[2]/div/div/div/div/div/div[1]/div/input")
		public WebElement tbx_KAMFieldHQ;
		
		@FindBy(how = How.LINK_TEXT,  linkText="Edit")
		public WebElement lnk_EditHQ;
		
		
		//	**************** Elements on Virtual account details Page**************************************
		
		@FindBy(how = How.CSS ,css=".test-id__field-label")
		public List<WebElement> List_txt_Filedlabels;
										//html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/header/div[2]/ul/li[4]/div/div/div/div/a
		@FindBy(how = How.XPATH,  xpath="/html[1]/body[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[2]/ul[1]/li[4]/div[1]/div[1]/div[1]/div[1]/a[1]")
		public WebElement lnk_KAMValueVirtual_Header;
		
		@FindBy(how = How.XPATH,  xpath="/html[1]/body[1]/div[5]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/article[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/span[1]/div[1]/a[1]")
		public WebElement lnk_KAMValueVirtualDetails;
		
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/button[3]")
		public WebElement btn_SaveVirtual;
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[1]/div[1]/div/div/div/input")
		public WebElement tbx_AccountNameVirtual;
		
		@FindBy(how = How.XPATH,  xpath="html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/input")
		public WebElement tbx_KAMFieldVirtual;
		
		@FindBy(how = How.LINK_TEXT,  linkText="Edit")
		public WebElement lnk_EditVirtual;
		
		public Accounts(WebDriver driver, String logpath) {
			
			this.logpath=logpath;
			this.driver = driver;
			coreFunc = new CoreFunctions(driver);
			// This initElements method will create all WebElements
			PageFactory.initElements(driver, this);

		}

		
		public void clickNewAndContinue() throws Exception{
			
			/*coreFunc.clickObject(lnk_Account, logpath, "Account");
			Thread.sleep(2000);*/
			coreFunc.clickObject(btn_New, logpath, "New");
			Thread.sleep(1000);
			coreFunc.clickObject(btn_Next, logpath, "Next");
			Thread.sleep(10000);

		
		}
		
		public void clickCreateSiteManually() throws Exception{
			//AccountSearchFrame("accessibility title");
			driver.navigate().refresh();
			Thread.sleep(3000);
			coreFunc.waitForElement(frm_AccountFrame, 120, "Account Search Page ", false, logpath);
			//System.out.println(" No of frames available :"+frm_AccountFrame.getAttribute(name));
			
			//driver.switchTo().frame(frm_AccountFrame);
			
			
		//	coreFunc.waitForElement(lst_AccountCriteraOption, 120, "Account cr", false, logpath);
			//coreFunc.clickObject(btn_CreateSiteManually, logpath, "Create manually HQ site");
		
		}
		
		public String createSiteFromHQ() throws Exception{
			coreFunc.clickObject(lnk_NewSite, logpath, "New Site");
			coreFunc.setText(tbx_Phone, "159159159", "TextBox", "Phone", logpath);
			coreFunc.setText(lst_RangeOfEmplyoees, "02 - 10 to 19 employees", "LinkComboBox", "Range of Employees", logpath);
			String street="Street_"+CommonUtils.getDate(0, null);
			coreFunc.setText(textArea_Street, street, "TextArea", "Street", logpath);
			coreFunc.setText(tbx_City, "City1", "TextBox", "City", logpath);
			coreFunc.setText(tbx_PostalCode, "28001", "TextBox", "Postal code", logpath);
			coreFunc.setText(lst_StateProvince, "Albacete", "LinkComboBox", "State/Province", logpath);
			coreFunc.clickObject(btn_SaveSite, logpath, "Save");
			
			Thread.sleep(5000);
			
			return street;
			
		}
		
		public boolean validateKamValueOnSite(String expectedKAMValue) throws Exception{
			
			boolean match=false;
			if(expectedKAMValue.equalsIgnoreCase(coreFunc.getText(lnk_KAMValueSite_Header, "Kam Value", logpath))){
				match=true;				
			}
		
			return match;
		}
		
		
		public boolean validateKamFieldExist(String accountType) throws Exception{
			List<WebElement> elelist=null;
			boolean match=false;
			
			if(accountType.equalsIgnoreCase("HQ")){
				elelist=List_txt_FiledlabelsHQ;
				
			}
			if(accountType.equalsIgnoreCase("Site")){
				elelist=List_txt_FiledlabelsSite;
				
			}
			
			if(accountType.equalsIgnoreCase("virtual")){
				elelist=List_txt_FiledlabelsSite;
				
			}
			
			
			System.out.println(" SIze of labele :"+elelist.size());
			for(WebElement we: elelist){
				
				System.out.println(" Value for "+accountType+" is :"+we.getText());
			if("KAM".equalsIgnoreCase(we.getText())){
				match=true;				
				break;
			}
			
			}
		
			return match;
		}
		
		
/*		
		public void AccountSearchFrame(String value) throws Exception
		{
			
				for (WebElement objTab:frm_AccountFrame)
				{
					System.out.println(objTab.getAttribute("Title"));
					if(value.equals(objTab.getAttribute("Title")))
					{
						coreFunc.scrollIntoView(objTab);

						coreFunc.clickObject(objTab,  logpath,"Account Search"+"\t is clicked");
						//coreFunc.waitForPageLoad();
					
						driver.switchTo().frame(objTab);
						CoreFunctions.captureScreenShot(driver, true, "Account search frame"+"\t is selected", logpath);

						break;
					}


				

			} 
		}
		
		*/
		
		
		
	
			public void AccountCriteria(String Value) throws Exception{	
	
			
			
		   //* driver.switchTo().frame(1);
			
			Thread.sleep(20000);
			
		
			/*coreFunc.setText(lst_AccountCriteraOption, option, "LINKCOMBOBOX", "AccountCriteriaOption", logpath);
			Thread.sleep(2000);
			coreFunc.setText(lst_Operator, Criteria, "LINKCOMBOBOX", "Operator", logpath);
			Thread.sleep(2000);
			coreFunc.setText(txt_AccountCriteriaValue, Value, "TEXTBOX", "AccountCriteriaOption", logpath);
			*/
			
			Select criteraOption=new Select(lst_AccountCriteraOption);
			criteraOption.selectByValue("BillingCity");
			
			Select Operator=new Select(lst_Operator);
			Operator.selectByValue("equals");
			Thread.sleep(1000);
			coreFunc.setText(txt_accountCriteriaValue, Value, "TEXTBOX", "AccountCriteriaOption", logpath);
			
			txt_accountCriteriaValue.sendKeys(Keys.TAB);
			coreFunc.clickObject(btn_add, logpath, "ADD");
			Thread.sleep(1000);
			coreFunc.clickObject(btn_searchIcon, logpath, "Search");
			
		}
		
		
        
        public void AccSelectedfromDB()throws Exception{
        	
        	coreFunc.clickObject(chbx_accountselected, logpath, "Account Selected from search result");
        	Thread.sleep(1000);
        	coreFunc.clickObject(btn_AccountCreation, logpath, "Account creation button");
        	
        }
			
		
		
        
        
        public void AccExternalDB() throws Exception{
			
			
			coreFunc.clickObject(lnk_CreatedAccount, logpath, "Account");
      	    Thread.sleep(1000);
      	    coreFunc.handleTabs();
		
		}
        
        
        public void ClickOnEdit() throws Exception{
			
			
			coreFunc.clickObject(lnk_Edit, logpath, "Edit");
      	    Thread.sleep(1000);
      	    
		}
        
       
       
       public void UpdateAccount(String Phn, String website) throws Exception{
			
		
      	    coreFunc.setText(tbx_Phone, Phn, "TEXTAREA", "Phone Number", logpath);
    	 
    	    tbx_Phone.sendKeys(Keys.TAB);
    	    
    	    Thread.sleep(1500);
    	    
    	    coreFunc.setText(tbx_site, website, "TEXTAREA", "Website", logpath);
       	 
    	    tbx_site.sendKeys(Keys.TAB);
    	    
    	    Thread.sleep(1500);
    	    
    	     coreFunc.clickObject(btn_save, logpath, "Save");
      	    Thread.sleep(1000);
		
		}
        
       
       public void refresh(){
    	   System.out.println("Refreshing the page");
    	   driver.navigate().refresh();
       }
        
        
        
        

		@Override
		protected void isLoaded() throws Error {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void load() {
			// TODO Auto-generated method stub
			
		}
}
