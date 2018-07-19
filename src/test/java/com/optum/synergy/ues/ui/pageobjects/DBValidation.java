package com.optum.synergy.ues.ui.pageobjects;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.optum.synergy.ues.ui.stepDefinitions.CommonLibrary;

public class DBValidation {

	private static final String EXCEL_FILE_LOCATION = "C:\\Users\\mpaluchu\\Desktop\\excelfiles\\MyFirstExcel.xls";
	public static int rowCount;
	public static int colCount;
	public static HashMap<String, String> hm;
	public static Map.Entry m;
	public static WritableWorkbook myFirstWbook;
	public static Label value;
	public static Label value1;

	public static void enterValues(String value) throws IOException {
		System.out.println("Entered here with" + value);
		myFirstWbook.write();

	}

	public static void validate() throws BiffException {
		hm = CommonLibrary.hm;

		// 1. Create an Excel file
		try {
			// Workbook workbook = Workbook.getWorkbook(new
			// File(EXCEL_FILE_LOCATION));
			// WritableWorkbook myFirstWbook = Workbook.createWorkbook(new
			// File("EXCEL_FILE_LOCATION"), workbook);

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			// add something into the Excel sheet
			Label header = new Label(0, 0, "Billed Premium");
			excelSheet.addCell(header);

			header = new Label(1, 0, "Paid Premium");
			excelSheet.addCell(header);

			/**
			 * Find Row and Column for insertion
			 */

			// ***************Capture Null Row*****************
			int row;
			/*System.out.println("Label -->" + excelSheet.findLabelCell("Billed Premium").getRow() + "****"
					+ excelSheet.findCell("Billed Premium").getColumn());*/
			POJOForValueInsertion.setCol(excelSheet.findCell("Billed Premium").getColumn());
			for (row = 0; row < excelSheet.getRows() + 1; row++) {
				
				
				 
				if (excelSheet.getCell(0, row).getContents() == null
						|| excelSheet.getCell(0, row).getContents().length() == 0) {
					POJOForValueInsertion.setCurrentRow(row);
					System.out.println("Row value is : : " + row);

					for (Entry<String, String> m : hm.entrySet()) {

						System.out.println("ENTERED HERE");
						Label value1 = new Label(excelSheet.findLabelCell(m.getKey().toString()).getColumn(),
								POJOForValueInsertion.getCurrentRow(), m.getValue().toString());
						excelSheet.addCell(value1);
						System.out.println("First key is : " + m.getKey() + " with value :" + m.getValue() + "\n"
								+ "row : " + POJOForValueInsertion.getCurrentRow() + "col : "
								+ excelSheet.findLabelCell(m.getKey().toString()).getColumn());
						enterValues(m.getValue());

						/*
						 * //**************Capture Column******************** if
						 * (m.getKey().equals("Billed Premium")) {
						 * System.out.println("ENTERED HERE");
						 * System.out.println("Label -->" +
						 * excelSheet.findLabelCell("Billed Premium").getRow() +
						 * "****" +
						 * excelSheet.findCell("Billed Premium").getColumn());
						 * POJOForValueInsertion.setCol(excelSheet.
						 * findCell("Billed Premium").getColumn());
						 * System.out.println("Debug point "
						 * +POJOForValueInsertion.getCol()); Label value1 = new
						 * Label(POJOForValueInsertion.getCol(),
						 * POJOForValueInsertion.getCurrentRow(),
						 * m.getValue().toString()); excelSheet.addCell(value1);
						 * 
						 * 
						 * myFirstWbook.write(); }
						 * 
						 * 
						 * //**************Capture Column******************** if
						 * (m.getKey().equals("Paid Premium")) {
						 * System.out.println("ENTERED HERE");
						 * System.out.println("Label -->" +
						 * excelSheet.findLabelCell("Paid Premium").getRow() +
						 * "****" +
						 * excelSheet.findCell("Paid Premium").getColumn());
						 * POJOForValueInsertion.setCol(excelSheet.
						 * findCell("Paid Premium").getColumn()); value = new
						 * Label(POJOForValueInsertion.getCol(),
						 * POJOForValueInsertion.getCurrentRow(),
						 * m.getValue().toString()); excelSheet.addCell(value);
						 * 
						 * 
						 * myFirstWbook.write(); }
						 */

					}
break;//only one iteration is needed
				}

				/*
				 * if (m.getKey().equals("Billed Premium")) {
				 * System.out.println("ENTERED HERE");
				 * System.out.println("Label -->" +
				 * excelSheet.findLabelCell("Billed Premium").getRow() + "****"
				 * + excelSheet.findCell("Billed Premium").getColumn());
				 * POJOForValueInsertion.setCol(excelSheet.
				 * findCell("Billed Premium").getColumn()); for (int row = 0;
				 * row < excelSheet.getRows() + 1; row++) { if
				 * (excelSheet.getCell(1, row).getContents() == null ||
				 * excelSheet.getCell(0, row).getContents().length() == 0) {
				 * POJOForValueInsertion.setCurrentRow(row);
				 * System.out.println("Did i enter here?? :O" + row); Label
				 * value = new Label(POJOForValueInsertion.getCol(),
				 * POJOForValueInsertion.getCurrentRow(),
				 * m.getValue().toString()); excelSheet.addCell(value);
				 * myFirstWbook.write();
				 * 
				 * break; } }
				 */ /*
					 * System.out.println("Label -->"+excelSheet.
					 * findLabelCell("Billed Premium").getRow()+"****"+
					 * excelSheet.findCell("Billed Premium").getColumn());
					 * for(int row =0;row<=excelSheet.getRows();row++){
					 * if(excelSheet.getCell(0, row).getContents()==
					 * null||excelSheet.getCell(0,
					 * row).getContents().length()==0){
					 * POJOForValueInsertion.setCurrentRow(row);
					 * 
					 * }
					 * 
					 * } Label value = new Label(2, 0, "Value");
					 * excelSheet.addCell(value);
					 */
				/*
				 * number = new Number(0, 2, 2); excelSheet.addCell(number);
				 * 
				 * label = new Label(1, 2, "Passed 2");
				 * excelSheet.addCell(label);
				 */
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {

			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

		}

	}
}