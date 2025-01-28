package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetName, int rowNUM ,int celNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rowNUM).getCell(celNum).getStringCellValue();
	wb.close();
	return data;
	
}
public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TekPTestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowCount=wb.getSheet(sheetName).getLastRowNum();
	return  rowCount;
}
public void setDataIntoExcel(String sheetName, int rowNUM ,int celNum , String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./tesdata/testscriptdata1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNUM).createCell(celNum);
	FileOutputStream fos=new FileOutputStream("./tesdata/testscriptdata1.xlsx");
	wb.write(fos);
	wb.close();
}
}
 