package com.tcs.salesforce.library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**********************************************************************************************************************************************************************
							COMMON UTILITIES
*********************************************************************************************************************************************************************
*/
public class CommonUtils {

//	**************************   Method to wait for a specific time period    ************************************************************************
	public static void manualWait(int noOfSec) throws InterruptedException {

		Thread.sleep(noOfSec * 1000);
	}

//	**************************   Method to Get date and time   ************************************************************************
	
	public static String getDate(int noOfDays, String format) {

		if (null == format)
			format = "dd_MM_yyyy_HH_mm_ss";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noOfDays);

		DateFormat dateFormat = new SimpleDateFormat(format);
		String currdate = dateFormat.format(cal.getTime());

		return currdate;
	}

//	**************************   Method to create the folder in runtime  ************************************************************************

	
	public static void createFolders(String folderPath) {

		File file = new File(folderPath);
		if (!file.exists())
			file.mkdirs();
	}
	
	
//	**************************   Method to Create Word document  ************************************************************************

	

    public static void createWord(String fileName) throws IOException {
    
            //Blank Document
            XWPFDocument document = new XWPFDocument();
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File(fileName));
          //create Paragraph
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Created a new document file for Automation test screenshots");
            document.write(out);
            out.close();
            document.close();
 
           
    }
//	**************************   Mmethod to Create Excel document  ************************************************************************

  
	
	public static void createExcel(String filename) {
        try {
            
        	XSSFWorkbook workbook = new XSSFWorkbook();

        	//Create a blank spreadsheet
        	XSSFSheet sheet = workbook.createSheet("Sheet1"); 
        
            
            XSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("SNo.");
            rowhead.getCell(0).setCellStyle(ExcelConfig.getCellStyle(workbook, "Header"));
            rowhead.createCell(1).setCellValue("Test Name");
            rowhead.getCell(1).setCellStyle(ExcelConfig.getCellStyle(workbook, "Header"));
            rowhead.createCell(2).setCellValue("Result");
            rowhead.getCell(2).setCellStyle(ExcelConfig.getCellStyle(workbook, "Header"));
      
    	    
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
	
	
//	**************************   Mmethod to generate a random number  using  range ************************************************************************


	public static int getrandomNumber(int min, int max) {

		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;

	}

    
 



//**************************   Method to calculate difference in two dates   ************************************************************************

	public static int getDateDiff(String date1, String date2, String format) throws ParseException {
		System.out.println("date1 : "+ date1);
		System.out.println("date2 : "+ date2);
		
		if(null==format){
			format="yyyy-MM-dd";
			
		}
		
		DateFormat dateFormat = new SimpleDateFormat(format);
		java.util.Date dt1;
		java.util.Date dt2;
		
		dt1 = dateFormat.parse(date1);
		dt2 = dateFormat.parse(date2);
		

		 //int diffInDays = (int) ((dt2.getTime() - dt1.getTime()) / (1000 * 60 * 60 * 24));
		int diffInDays =(int) TimeUnit.DAYS.convert(dt2.getTime() - dt1.getTime(), TimeUnit.MILLISECONDS);
		 System.out.println("diffInDays : "+ diffInDays);
		return diffInDays;
	}


}