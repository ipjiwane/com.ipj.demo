package com.ipj.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class XLUtil {

	private FileInputStream fi;

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;

	private int rows;
	private int cells;

	public XLUtil(String path, String sheetname) 
	{ 
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
		} catch (Exception e) {
			System.out.println("Error while accessing excel data : "+e.getMessage());;
		}
		sheet = workbook.getSheet(sheetname);
	}


	public int getRowCount() throws IOException
	{
		/*
		fi = new FileInputStream(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		*/
		rows = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rows;	
	}

	public int getCellCount(int rowNum) throws IOException
	{
		/*
		fi = new FileInputStream(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		*/
		row = sheet.getRow(rowNum);
		cells = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cells;
	}

	public String getCellData(int rowNum, int column) throws IOException
	{
		/*
		fi = new FileInputStream(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		*/
		row = sheet.getRow(rowNum);
		cell = row.getCell(column);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}

	public void setCellData(int rowNum, int column, String data) throws IOException
	{
		/*
		fi = new FileInputStream(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		*/
		row = sheet.getRow(rowNum);
		cell = row.createCell(column);
		cell.setCellValue(data);

		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	public List<Map<String, String>> getTestDetails() throws IOException
	{
		/*
		fi = new FileInputStream(System.getProperty("user.dir")+"/TestData/TestRunner.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet("UAT");
		*/
		rows = sheet.getLastRowNum();
		cells = sheet.getRow(0).getLastCellNum();



		List <Map<String,String>> tests = new ArrayList <Map<String,String>>();
		for(int i=1;i<=rows;i++)
		{
			Map <String,String> testDetails = new HashMap<String,String>();
			for(int j=0;j<cells;j++)
			{
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				testDetails.put(key,value);
			}
			tests.add(testDetails);
		}

		return tests;

	}

}
