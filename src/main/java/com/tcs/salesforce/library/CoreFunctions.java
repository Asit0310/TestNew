package com.tcs.salesforce.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;



import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CoreFunctions {

	WebDriver driver;
	WebDriverWait wait;

	public enum ClickType {
		LEFT, RIGHT, DOUBLE
	};

	public Boolean CompareResults = true;

	public CoreFunctions(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, CommonConstants.webDriverWaitTime);
	}

	public void waitForElementVisible(By by) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	// This Function will close the current tab
	// Pass the frame name if you want to switch back to the frame you are
	// working on.
	public void closeCurrentTab(String CurrentFrameName) {
		try {
			// Switch to the default frame
			driver.switchTo().defaultContent();

			// Click on the close button on top left corner of the bullhorn
			// application
			driver.findElement(By.cssSelector(".close.bhi-close-o")).click();

			// If Frame name is blank then don't switch frames
			// else switch to the frame
			if (CurrentFrameName.length() > 0)
				driver.switchTo().frame(CurrentFrameName);
		} catch (Exception ex) {
			// Log.error("Error occurred while closing the current bullhorn tab");
		}
	}

	// This Function will refresh the current tab
	// Pass the frame name if you want to switch back to the frame you are
	// working on.
	public void refreshCurrentTab(String CurrentFrameName) {
		try {
			// Switch to the default frame
			driver.switchTo().defaultContent();

			// Click on the Refresh button on top left corner of the bullhorn
			// application
			driver.findElement(By.cssSelector(".reload.bhi-refresh-o")).click();

			// If Frame name is blank then don't switch frames
			// else switch to the frame
			if (CurrentFrameName.length() > 0)
				driver.switchTo().frame(CurrentFrameName);
		} catch (Exception ex) {
			// Log.error("Error occurred while closing the current bullhorn tab");
		}
	}

	// To Scroll the element into view
	public boolean scrollIntoView(WebElement OElement) {
		try {
			// create the JSE object
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll the element into view
			js.executeScript("arguments[0].scrollIntoView()", OElement);

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			// Log.info("Error occurred while executing the ScrollintoView function : "
			// + e.getMessage());
			return false;
		}
	}


	 public static void captureScreenShot(WebDriver driver, boolean wantscreenshot, String actionPerformed, String logpath){
		  //File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Paste the screenshot into the word document	 
					 
		 	try {
				File f=new File(logpath);
				FileInputStream fis=new FileInputStream(f);

				XWPFDocument docum= new XWPFDocument(OPCPackage.open(fis)); 
				

				XWPFParagraph p=docum.createParagraph();
				XWPFRun r=p.createRun();
				r.addBreak();
				r.setText(actionPerformed);
				
				if(wantscreenshot){
									// Take screenshot and store as a file format
									 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
									 try {
									// now copy theÂ  screenshot to desired location using copyFile method
							
									FileUtils.copyFile(src, new File(CommonConstants.tempScreenPath));
									}
							
									 catch (IOException e)
							
									 {
							
									 System.out.println(e.getMessage());
							
									 }
					
									r=p.createRun();
									r.addBreak();
									r.addPicture(new FileInputStream(CommonConstants.tempScreenPath), XWPFDocument.PICTURE_TYPE_JPEG, "name", Units.toEMU(450) , Units.toEMU(250));
								
								}
				
				FileOutputStream out = new FileOutputStream(logpath);
				docum.write(out);
				out.close();
				docum.close();
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

		    
		 }

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		});
	}

	/*
	 * Function : waitForElement This function will wait for an element to
	 * appear on the screen Arguments element : WebElement for which we have to
	 * wait TimeOutSeconds : Wait timeout Click-able : Check if the element is
	 * click-able. This will be useful if we have to click on the element Return
	 * values : Void
	 */
	public boolean waitForElement(WebElement element, int timeOutSeconds, String nameInApp,
			boolean checkClickable,String logpath) {
		boolean validation=false;
		// create web driver wait object
		WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);

		// this is time counter
		int loopcounter = 0;

		// loop and wait for the element to be displayed
		while (element.isDisplayed() != true) {
			try {
				loopcounter++;
				Thread.sleep(100);
				if (loopcounter == CommonConstants.GlobalMidTimeOutSeconds * 10)
					break;

			} catch (InterruptedException e) {
				// Nothing to be done here
			}
		}

		// if element is not displayed, then throw error
		if (!(element.isDisplayed())) {
			captureScreenShot(driver, true, nameInApp+" does not exist on the screen", logpath);
			
		}
		else{
			captureScreenShot(driver, false, nameInApp+ " displayed successfully on the screen", logpath);
			validation=true;
			}

		// check if element if click-able. This will throw error if element is
		// not click-able within time specified.
		if (checkClickable == true){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			validation=true;
		}
		
		return validation;
	}

	/*
	 * Function : mouseOverAction This function will mouse over on the web
	 * elements. Mouse pointer will not move, but the action will be performed
	 * Arguments OElement : Web element Return values : Boolean
	 */
	public Boolean mouseOverAction(WebElement OElement) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";

		((JavascriptExecutor) driver).executeScript(javaScript, OElement);

		return true;
	}

	/*
	 * Function : clickObject This function will mouse click on the objects
	 * Arguments OElement : Web element Return values : Boolean
	 */
		
		public Boolean clickObject(WebElement OElement, String logpath,String nameInApp) throws Exception {
			Boolean click=clickObject(OElement, ClickType.LEFT, nameInApp, logpath);
		if(click)
			captureScreenShot(driver, true, "Clicked on :"+nameInApp, logpath);
		else
			captureScreenShot(driver, true, "Element is not clicked successfully "+nameInApp, logpath);
		return click;
	}

	public Boolean sendKeysToElement(WebElement OElement, Keys key,String nameInApp,String logpath) {
		waitForElement(OElement, CommonConstants.GlobalShortTimeOutSeconds,
				nameInApp, true, logpath);
		OElement.sendKeys(key);

		return true;
	}

	/*
	 * Function : clickObject This function will mouse click on the objects
	 * Arguments OElement : Web element Button : Mouse button Return values :
	 * Boolean
	 */
	public Boolean clickObject(WebElement OElement, ClickType Button,String nameInApp,String logpath)
			throws Exception {

		String ElementName = OElement.toString();

		
		waitForElement(OElement, CommonConstants.GlobalShortTimeOutSeconds,
				nameInApp, true, logpath);
		
		scrollIntoView(OElement);
		captureScreenShot(driver, true, nameInApp+" is going to be clicked", logpath);

		if (Button == ClickType.LEFT) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click()", OElement);
				//OElement.click();
			} catch (Exception Ex) {

				Log.warn("Inside Left Click Exception : "
						+ Ex.getMessage().toString());
				// If error in clicking on element then Try clicking using
				// actions
				Actions action = new Actions(driver).click(OElement);
				action.build().perform();
			}

			Log.info("Left Clicked on " + ElementName);

		} else if (Button == ClickType.RIGHT) {
			Actions action = new Actions(driver).contextClick(OElement);
			action.build().perform();

			Log.info("Right Clicked on " + ElementName);

		} else if (Button == ClickType.DOUBLE) {
			Actions action = new Actions(driver).doubleClick(OElement);
			action.build().perform();

			Log.info("Double Clicked on " + ElementName);
		}

		return true;
	}

	/*
	 * Function : SetText This function will set text on the objects Arguments
	 * OElement : Web element NewText : Text to be set ObjectType : Type of the
	 * object, to determine the operation Return values : Boolean
	 */
	public Boolean setText(WebElement OElement, String NewText,
			String ObjectType,String nameInApp, String logpath) throws Exception {
		// wait for element to become click-able
		waitForElement(OElement, CommonConstants.webDriverWaitTime,
				nameInApp, true, logpath);
		scrollIntoView(OElement);

		// This will be used to read the value from the object after setting
		// the value
		String valuefromObject = "BLANK";

		// Check if the object type is combo box
		if (ObjectType.toUpperCase().trim().equals("COMBOBOX") == true) {
			Select dropdown = new Select(OElement);
			
			if ((!(NewText.toUpperCase() == "BLANK"))
					&& (!NewText.startsWith("#"))) {
				dropdown.selectByVisibleText(NewText);
				CommonUtils.manualWait(1);
				valuefromObject = getTextFromDropDown(OElement, nameInApp, logpath);
			} else if (NewText.startsWith("#")) {
				dropdown.selectByIndex(Integer.parseInt(NewText.substring(1)));
				valuefromObject = NewText;
				
			}
		}
		// This else if only works for TextBox as of now
		else if(ObjectType.toUpperCase().trim().equals("TEXTBOX") == true){
			OElement.clear();
			if (!(NewText.toUpperCase() == "BLANK")) {
				OElement.sendKeys(NewText);
			
				valuefromObject = OElement.getAttribute("value").toString();
			}
		}
		else if(ObjectType.toUpperCase().trim().equals("TEXTAREA") == true){
			OElement.clear();
			if (!(NewText.toUpperCase() == "BLANK")) {
				OElement.sendKeys(NewText);
			
				valuefromObject =NewText;
				
			}
		}
		
		else if(ObjectType.toUpperCase().trim().equals("LINKCOMBOBOX") == true){
			//OElement.clear();
			clickObject(OElement, logpath, nameInApp);						
			List<WebElement> dropDownValues= driver.findElements(By.xpath("html/body/div/div/ul/li/a"));
			System.out.println("Available  options : "+ dropDownValues.size());
			for(WebElement we: dropDownValues){
			     
				if(we.getText().equalsIgnoreCase(NewText)){
					System.out.println("Value option matching");
					clickObject(we, logpath, NewText);
					break;
				}
				
			}
			valuefromObject =OElement.getText();
		}

		// wait for element to be Click-able
		//waitForElement(OElement, CommonConstants.GlobalShortTimeOutSeconds,
		//		nameInApp, true, logpath);

		Log.info(valuefromObject + "--" + NewText);

		// check if new value is set correctly only if we are not clearing
		// the value
		if (valuefromObject.equals(NewText) || CompareResults == false) {
				
			Log.info("Setting text for : " + OElement.toString()
					+ " : Text Set - " + NewText);
			captureScreenShot(driver, true, "Passed:Value "+NewText+" is entered in the field '"+nameInApp+"'", logpath);
			return true;
		} 
	/*	else if(valuefromObject.equals("TextArea")){
			captureScreenShot(driver, true, "Passed:Value is entered in the field '"+nameInApp+"'", logpath);
			return true;
		}*/
		else{
			captureScreenShot(driver, true, "Setting text for : " + nameInApp
					+ " Failed : Text Set - " + NewText, logpath);

			Log.error("Setting text for : " + nameInApp
					+ " Failed : Text Set - " + NewText);
			throw (new Exception("Value not set for textbox : "
					+ nameInApp));
		}
	}

	/**
	 * Get selected option from Drop Down
	 * 
	 * @param element
	 * @return text of web element
	 */
	public String getTextFromDropDown(WebElement element,String nameInApp, String logpath) {

		//waitForElement(element, 5, nameInApp, false, logpath);

		Select dropdown = new Select(element);
		WebElement option = dropdown.getFirstSelectedOption();

		String text = null;

		text = option.getText();
		if (null != text && !text.isEmpty())
			text = text.trim();

		return text;
	}

	/**
	 * Get text from passed element
	 * 
	 * @param element
	 * @return text of web element
	 */
	public String getText(WebElement element,String nameInApp,String logpath) {

		String text = null;

		waitForElement(element, CommonConstants.GlobalLongTimeOutSeconds, nameInApp, false, logpath);

		text = element.getText();

		if (text == null || text.isEmpty()) {

			text = element.getAttribute("value");
		}

		if (null != text && !text.isEmpty())
			text = text.trim();

		return text;
	}

	/**
	 * Accept Alerts
	 * 
	 * @return true if success, false otherwise
	 */
	public boolean acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			Log.info("Accepting Alert message : " + alert.getText());
			alert.accept();
			CommonUtils.manualWait(1);
			return true;
		} catch (Exception e) {

			Log.warn("Error accepting Alert : " + e.getMessage());
			return false;
		}
	}

	/**
	 * Dismiss Alerts
	 * 
	 * @return true if success, false otherwise
	 */
	public boolean dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			Log.info("Dismissing Alert message : " + alert.getText());
			alert.dismiss();
			CommonUtils.manualWait(1);
			return true;
		} catch (Exception e) {

			Log.warn("Error dismissing Alert : " + e.getMessage());
			return false;
		}
	}
	
	
	
	//Switch between 2 windows.************AK

			public void handleTabs() throws Exception
			{
				String firstWinHandle;
				String secondWinHandle;
			
				Set <String>handles = driver.getWindowHandles();//To handle multiple windows
				firstWinHandle = driver.getWindowHandle();
				//System.out.println(firstWinHandle);
				handles.remove(firstWinHandle);
			
				String winHandle=handles.iterator().next();
				if (winHandle!=firstWinHandle)
				{
				     secondWinHandle=winHandle;
				  driver.close();
				driver.switchTo().window(secondWinHandle);   //Switch to popup window
			    }
				else 
					driver.switchTo().window(firstWinHandle);

			    
			
		}
	
			
			// Set text using send keys when setText function and simple sendkeys is not working
			
			public void sendText(WebElement oElement, String userInput)
			{

				Actions actions = new Actions(driver);
				actions.moveToElement(oElement);
				actions.click();
				actions.sendKeys(userInput);
				actions.sendKeys(Keys.ENTER);
				actions.build().perform();
				
		
			}
	
	
	
	
	
}
