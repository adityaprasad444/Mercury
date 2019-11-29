package com.demo.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demo.TestCases.BaseClass;

public class ExcelRead extends BaseClass {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public ExcelRead() 
	{
		try {
			File file = new File(System.getProperty("user.dir")+"//src//test//java//com//demo//Resources//TestData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}

	public String getdata(int row,int column) 
	{
		sheet = workbook.getSheetAt(0);
		String s=sheet.getRow(row).getCell(column).getStringCellValue();
		return s;

	}
}
