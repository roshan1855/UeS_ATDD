package com.optum.synergy.ues.ui.utilities;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class DataReader {

	public static String inputFile;
	public static String testCaseID;
	public static String testCaseName;
	public static String customerID;

	public static String userName;
	public static String Password;
	public static String State;
	public static String TotEligibleEmployees;
	public static String AvgTotEligibleEmployees;
	public static String QuoteType;
	public static String CompanyName;
	public static String Address;
	public static String City;
	public static String ZipCode;
	public static String SICCode;
	public static String NonCOBRAEmployees;
	public static String COBRAEmployees;
	public static String TotalEmployees;

	public static String CRID;
	public static String CRID_2;
	public static String CRID_3;
	public static String startDate;
	public static String endDate;
	public static String comments;
	public static String coverageType;
	public static int currentRow;
	public static Workbook w;
	public static Sheet sheet;
	public static String splitPercent_1;
	public static String splitPercent_2;
	public static String splitPercent_3;
	public static String rateType;
	public static String rateValue;
	public static String contractNumber;
	public static String issueState;
	public static String chargeLineCode;

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

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return Password;
	}

	public String getState() {
		return State;
	}

	public String getTotEligibleEmployees() {
		return TotEligibleEmployees;
	}

	public String getAvgTotEligibleEmployees() {
		return AvgTotEligibleEmployees;
	}

	public String getQuoteType() {
		return QuoteType;
	}

	public String getCompanyName() {
		return CompanyName;
	}
	
	public String getAddress() {
		return Address;
	}

	public String getCity() {
		return City;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public String getSICCode() {
		return SICCode;
	}

	public String getNonCOBRAEmployees() {
		return NonCOBRAEmployees;
	}

	public String getCOBRAEmployees() {
		return COBRAEmployees;
	}

	public String getTotalEmployees() {
		return TotalEmployees;
	}

	public String getCRID() {
		return CRID;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getComments() {
		return comments;
	}

	public String getCoverageType() {
		return coverageType;
	}

	public String getCRID_2() {
		return CRID_2;
	}

	public static String getCRID_3() {
		return CRID_3;
	}

	public String getSplitPercent_1() {
		return splitPercent_1;
	}

	public String getSplitPercent_2() {
		return splitPercent_2;
	}

	public String getSplitPercent_3() {
		return splitPercent_3;
	}

	public String getRateType() {
		return rateType;
	}

	public String getRateValue() {
		return rateValue;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public String getIssueState() {
		return issueState;
	}

	public String getChargeLineCode() {
		return chargeLineCode;
	}

	public void setCurrentRow(int i) {
		DataReader.currentRow = i;
	}

	public void setTestCaseID() {
		DataReader.testCaseID = sheet.getCell(0, currentRow).getContents();

	}

	public void setuserName() {
		userName = sheet.getCell(3, currentRow).getContents();
	}

	public void setPassword() {
		Password = sheet.getCell(4, currentRow).getContents();
	}

	public void setState() {
		State = sheet.getCell(3, currentRow).getContents();
	}

	public void setTotEligibleEmployees() {
		TotEligibleEmployees = sheet.getCell(4, currentRow).getContents();
	}

	public void setAvgTotEligibleEmployees() {
		AvgTotEligibleEmployees = sheet.getCell(5, currentRow).getContents();
	}

	public void setQuoteType() {
		QuoteType = sheet.getCell(6, currentRow).getContents();
	}

	public void setCompanyName() {
		CompanyName = sheet.getCell(7, currentRow).getContents();
	}

	public void setAddress() {
		Address = sheet.getCell(8, currentRow).getContents();
	}

	public void setCity() {
		City = sheet.getCell(9, currentRow).getContents();
	}

	public void setZipCode() {
		ZipCode = sheet.getCell(10, currentRow).getContents();
	}

	public void setSICCode() {
		SICCode = sheet.getCell(11, currentRow).getContents();
	}

	public void setNonCOBRAEmployees() {
		NonCOBRAEmployees = sheet.getCell(12, currentRow).getContents();
	}

	public void setCOBRAEmployees() {
		COBRAEmployees = sheet.getCell(13, currentRow).getContents();
	}

	public void setTotalEmployees() {
		TotalEmployees = sheet.getCell(14, currentRow).getContents();
	}

	public void setTestCaseName() {
		testCaseName = sheet.getCell(1, currentRow).getContents();
	}

	public void setCustomerID() {
		customerID = sheet.getCell(2, currentRow).getContents();

	}

	public void setCRID() {
		CRID = sheet.getCell(3, currentRow).getContents();
	}

	public void setStartDate() {
		startDate = sheet.getCell(4, currentRow).getContents();
	}

	public void setEndDate() {
		endDate = sheet.getCell(5, currentRow).getContents();
	}

	public void setComments() {
		comments = sheet.getCell(6, currentRow).getContents();
	}

	public void setCoverageType() {
		coverageType = sheet.getCell(7, currentRow).getContents();
	}

	public void setSplitPercentage_1() {
		splitPercent_1 = sheet.getCell(8, currentRow).getContents();
	}

	public void setSplitPercentage_2() {
		splitPercent_2 = sheet.getCell(9, currentRow).getContents();
	}

	public void setSplitPercentage_3() {
		splitPercent_3 = sheet.getCell(10, currentRow).getContents();
	}

	public void setCRID_2() {
		CRID_2 = sheet.getCell(11, currentRow).getContents();

	}

	public void setCRID_3() {
		CRID_3 = sheet.getCell(12, currentRow).getContents();

	}

	public void setRateType() {
		rateType = sheet.getCell(13, currentRow).getContents();
	}

	public void setRateValue() {
		rateValue = sheet.getCell(14, currentRow).getContents();
	}

	public void setContractNumber() {
		contractNumber = sheet.getCell(15, currentRow).getContents();
	}

	public void setIssueState() {
		issueState = sheet.getCell(16, currentRow).getContents();
	}

	public void setChargeLineCode() {
		chargeLineCode = sheet.getCell(17, currentRow).getContents();
	}

	public static String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		DataReader.inputFile = inputFile;
	}

}
