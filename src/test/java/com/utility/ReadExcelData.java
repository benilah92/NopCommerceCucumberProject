package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	
	static String path = "C:\\Users\\mechs\\Desktop\\IPT\\doc\\CustomerDetails.xlsx";
	File file = new File(path);
	
	
	public String getMailId() throws InvalidFormatException, IOException {
		
		
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String email = cell.getStringCellValue();
		return email;
		//System.out.println(email);
	}
	
	public String getPassword() throws InvalidFormatException, IOException {
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String password = cell.getStringCellValue();
		return password ;
	}
	
	public String getFirstName() throws InvalidFormatException, IOException {
		
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String firstName = cell.getStringCellValue();
		return firstName ;
		
	}
	public String getLastName() throws InvalidFormatException, IOException {
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(3);
		String lastName = cell.getStringCellValue();
		return lastName ;
		
	}
	public String getCompany() throws InvalidFormatException, IOException {
		
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(4);
		String company = cell.getStringCellValue();
		return company ;
	}
		
		
		
	
}
