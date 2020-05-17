/**
 * 
 */
package com.tcs.salesforce.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author 662162
 *
 */
public class ExcelConfig {
	  File src;
	  FileInputStream fis;
	  XSSFWorkbook wb;
	  XSSFSheet sh1;
			 

	/**
	 * 
	 */
	public ExcelConfig(String excelPath, String sheetName) {
		

		  try {
			 src=new File(excelPath);
			 
			  // Load the file
			 
			   fis=new FileInputStream(src);
			 
			   // load the workbook
			 
			    wb=new XSSFWorkbook(fis);
			 
			  // get the sheet which you want to modify or create
			 
			    sh1= wb.getSheet(sheetName);
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	}
		//Method to return aray after reading data from excel
							public  Object[][] getExcelArray() throws Exception{        
							    
							    int rowNum = sh1.getLastRowNum() + 1;
							    int colNum = sh1.getRow(0).getLastCellNum();
							    String[][] data = new String[rowNum][colNum];
						
							    for (int i = 0 ; i < rowNum ; i++) {
							    	XSSFRow  row = sh1.getRow(i);
							            for (int j = 0 ; j < colNum ; j++) {
							            	  XSSFCell cell = row.getCell(j);
							                  String value=cell.getStringCellValue();
							                  data[i][j] = value ;
							                  System.out.println("the value is " + value);
							            }
							        }
							    return data;
							    }
	
		//Method to return aray after reading data from excel
				public int getRowCount(){
							     int rowCount=sh1.getLastRowNum();
							     System.out.println("Row count is:"+rowCount);
							     return rowCount;
					
					
				}
			
		//Method to return aray after reading data from excel
				public int getColCount(){
								int colCount=sh1.getRow(0).getLastCellNum();
								System.out.println("Column Count is :"+colCount);
								return colCount;
					
				}
				
				
				public static void writeResultExcel(String testName,boolean result) {
			       
			         
			        try {
			            FileInputStream inputStream = new FileInputStream(new File(CommonConstants.testResultPath));
			            Workbook workbook = WorkbookFactory.create(inputStream);
			            
			 
			            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
			 
			             int rowCount = ((XSSFSheet) sheet).getLastRowNum();
			 
			              Row row = sheet.createRow(++rowCount);
			 
			                int columnCount = 0;
			                 
			                Cell cell = row.createCell(columnCount);
			                cell.setCellValue(rowCount);
			                cell.setCellStyle(getCellStyle(workbook, "Normal"));
			                
			                cell = row.createCell(++columnCount);
			                cell.setCellValue(testName);
			                cell.setCellStyle(getCellStyle(workbook, "Normal"));
			                
			                cell = row.createCell(++columnCount);
			                if(result){
			                	cell.setCellValue("Passed");
			                	cell.setCellStyle(getCellStyle(workbook, "Pass"));
			                }
			                else{
			                	cell.setCellValue("Failed");
			                	cell.setCellStyle(getCellStyle(workbook, "Fail"));
			                }
			                	
			            	sheet.autoSizeColumn(1);
			            	sheet.autoSizeColumn(2);  
			            inputStream.close();
			 
			            FileOutputStream outputStream = new FileOutputStream(CommonConstants.testResultPath);
			            workbook.write(outputStream);
			            workbook.close();
			            outputStream.close();
			             
			        } catch (IOException | EncryptedDocumentException
			                | InvalidFormatException ex) {
			            ex.printStackTrace();
			        }
			    }
				
		
				
				
	public static CellStyle getCellStyle(Workbook workbook, String type) {
		 CellStyle style = workbook.createCellStyle();
         Font font = workbook.createFont();
        
         style.setBorderBottom(BorderStyle.THIN);
         style.setBorderLeft(BorderStyle.THIN);
         style.setBorderRight(BorderStyle.THIN);
         style.setBorderTop(BorderStyle.THIN);
         //style.setWrapText(true);
        
         switch(type.toUpperCase()){
         
         case "HEADER":
        	 font.setBold(true);
        	 style.setFont(font);
        	 style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        	 
        	 break;
        	 
         case "PASS":
        	 font.setColor(IndexedColors.GREEN.getIndex());
         	 style.setFont(font);
         	 break;
         	 
         case "FAIL":
        	 font.setColor(IndexedColors.RED.getIndex());
         	 style.setFont(font);
         	 break;
         	 
        default:
        	break;
        	 
         }
         
         return style;
		
	}

}
