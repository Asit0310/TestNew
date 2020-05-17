/**
 * 
 */
package com.tcs.salesforce.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author 662162
 *
 */
public class WordConfig {
	
	File src;
	FileInputStream fis;
	static XWPFDocument wd;
	  
	
	private static XWPFWordExtractor we;
			 

	/**
	 * @throws  
	 * 
	 */
	
	/*  public  static void main(String[] args) throws FileNotFoundException{
	    	
	    	WordConfig wc= new WordConfig(CommonConstants.projectPath+"\\Regression\\src\\test\\resources\\simple1.docx");
	    	String text=wc.readDocument();
	    	System.out.println(text.length());
	    	System.out.println(text);
	    	System.out.println("char"+text.charAt(139)+text.charAt(140)+text.charAt(144)+text.charAt(141)+text.charAt(142)+text.charAt(143));
	    	
	    }*/
	public WordConfig(String fileName){

		try {
			
			 src=new File(fileName);
			 fis=new FileInputStream(src);
			 wd= new XWPFDocument(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public  String readDocument() throws IOException {
    	//String text = null;
        	we = new XWPFWordExtractor(wd);
			String extract=we.getText();
			
			/* try {
			        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\test.txt"));
			            for (int i = 0; i < 4; i++) {
			                out.write(extract);
			            }
			            out.close();
			        } catch (IOException e) {}
			 
			 BufferedReader reader = new BufferedReader(new java.io.FileReader("D:\\test.txt"));

			 try{
			   String line;
			   //as long as there are lines in the file, print them
			   while((line = reader.readLine()) != null){ 
			     text=text+line;
			   }
			 } catch (IOException e) {
			   e.printStackTrace();
			 }*/
			
			we.close();
			wd.close();
			fis.close();
		
			return extract;//entire content of the doument
        	
    }
    
  
	
}