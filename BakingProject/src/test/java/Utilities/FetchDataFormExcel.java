package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.ConstantData;

public class FetchDataFormExcel
{
	public static String getURL() throws IOException
	 {
		//to fetch data from excel sheet we create object of FileInputStream
		 FileInputStream fs = new FileInputStream(ConstantData.ExcelPath);
		 
		 //we call excel sheet is woorkbook 
		 //workbook helps u inorder to intract with elements present in sheet 
		 //it conatins multiple sheets
		 
		XSSFWorkbook workbook = new  XSSFWorkbook(fs);
		
		XSSFSheet sheet =workbook.getSheetAt(0); //we are intracting with zero sheets thats why
		
		XSSFCell value  = sheet.getRow(1).getCell(0); 
		
		String URLValue = value.toString();
		
		
	    return URLValue;
		
		
		 
	 }


}
