package com.optum.synergy.ues.ui.integrationHelper;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class DataReader {

	public static String inputFile;
	public static String testCaseID;
	public static String testCaseName;
	public static String customerID;
	public static int currentRow;
	public static Workbook w;
	public static Sheet sheet;
	public static String invoiceFileBrms;
	public static String paymentFileBrms;
	public static String ftsTag;

	public String getInvoiceFileBrms() {
		return invoiceFileBrms;
	}

	public void setInvoiceFileBrms() {
		DataReader.invoiceFileBrms = sheet.getCell(3, currentRow).getContents();
		;
	}
	
	public String getFtsTag() {
		return ftsTag;
	}

	public void setFtsTag() {
		DataReader.ftsTag = sheet.getCell(5, currentRow).getContents();
		;
	}
	

	public String getPaymentFileBrms() {
		return paymentFileBrms;
	}

	public void setPaymentFileBrms() {
		DataReader.paymentFileBrms = sheet.getCell(4, currentRow).getContents();
		
	}

	

	public void LoadExcelApplication(String inputFileName) {
		File inputWorkbook = new File(inputFileName);

		try {
			w = Workbook.getWorkbook(inputWorkbook);
			sheet = w.getSheet(0);
		} catch (Exception e) {

		}

	}

	public int getCurrentRow() {
		return currentRow;
	}

	public static Workbook getW() {
		return w;
	}

	public static Sheet getSheet() {
		return sheet;
	}

	public String getTestCaseID() {
		return testCaseID;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCurrentRow(int i) {
		DataReader.currentRow = i;
	}

	public void setTestCaseID() {
		DataReader.testCaseID = sheet.getCell(0, currentRow).getContents();

	}

	public void setTestCaseName() {
		testCaseName = sheet.getCell(1, currentRow).getContents();
	}

	public void setInputFile(String inputFile) {
		DataReader.inputFile = inputFile;
	}

}
