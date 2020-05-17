package com.tcs.salesforce.pageobjects.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.tcs.salesforce.library.CommonUtils;
import com.tcs.salesforce.library.CoreFunctions;

public class LoginSalesforce extends LoadableComponent<LoginSalesforce> {

	WebDriver driver;
	String logpath;
	public CoreFunctions coreFunc;


	//***********************Elements on Login page*****************************************
	@FindBy(how = How.ID, id = "username")
	public WebElement userName;

	@FindBy(how = How.ID, id = "password")
	public WebElement password;

	@FindBy(how = How.ID, id = "Login")
	public WebElement clickToSandBoxButton;

	public LoginSalesforce(WebDriver driver, String logpath) {
		
		this.logpath=logpath;
		this.driver = driver;
		coreFunc = new CoreFunctions(driver);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void enterUserName(String uName) throws Exception {
		coreFunc.setText(userName, uName, "TextBox","UserName",logpath);
	}

	public void enterPassword(String pwd) throws Exception {
		coreFunc.setText(password, pwd, "TextBox", "Password", logpath);
	}

	public void clickLogin() throws Exception {

		coreFunc.clickObject(clickToSandBoxButton,logpath, "Login");

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
