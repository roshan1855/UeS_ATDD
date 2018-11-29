package com.optum.synergy.ues.ui.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Properties;

import com.optum.synergy.ues.ui.pageobjects.DBValidation;
import com.optum.synergy.ues.ui.utilities.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CommonLibrary {

	public static String testCaseID;
	public static String testCaseName;
	public static String customerID;
	
	public static String userName;
	public static String State;
	public static String TotEligibleEmployees;
	public static String AvgTotEligibleEmployees;
	
	
	public static String CRID;
	public static String startDate;
	public static String endDate;
	public static int currentRow;
	public static HashMap<String, String> hm = new HashMap<String, String>();
	public static HashMap<String, Object[]> hm1 = new HashMap<String, Object[]>();
	static DataReader reader = new DataReader();
	public static Properties autoProperties;
	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static String ExecutedTestCasesSheet;
	static WritableSheet shSheet;
	public static List<String> queries;
	public static String query1;
	public static String query2;
	public static String query3;
	public static String query4;
	public static String query5;
	public static String query6;

	/**
	 * @author dsuribab
	 * @description : All values in getters coming from DataReader Class
	 **/
	public String getCustomerID() {
		return reader.getCustomerID();
	}
	
	public String getUserName() {
		return reader.getUserName();
	}	

	public String getPassword() {
		return reader.getPassword();
	}
	
	public String getState() {
		return reader.getState();
	}	

	public String getTotEligibleEmployess() {
		return reader.getTotEligibleEmployees();
	}
	
	public String getAvgTotEligibleEmployess() {
		return reader.getAvgTotEligibleEmployees();
	}
	
	public String getQuoteType() {
		return reader.getQuoteType();
	}

	public String getCompanyName() {
		return reader.getCompanyName();
	}
	
	public String getAddress() {
		return reader.getAddress();
	}

	public String getCity() {
		return reader.getCity();
	}

	public String getZipCode() {
		return reader.getZipCode();
	}

	public String getSICCode() {
		return reader.getSICCode();
	}

	public String getNonCOBRAEmployees() {
		return reader.getNonCOBRAEmployees();
	}

	public String getCOBRAEmployees() {
		return reader.getCOBRAEmployees();
	}

	public String getTotalEmployees() {
		return reader.getTotalEmployees();
	}


	public String getCRID() {
		return reader.getCRID();
	}

	public String getStartDate() {
		return reader.getStartDate();
	}

	public String getEndDate() {
		return reader.getEndDate();
	}

	public String getComments() {
		return reader.getComments();
	}

	public String getCoverageType() {
		return reader.getCoverageType();

	}

	public String getSplitPercent_1() {
		return reader.getSplitPercent_1();
	}

	public String getSplitPercent_2() {
		return reader.getSplitPercent_2();
	}

	public String getSplitPercent_3() {
		return reader.getSplitPercent_3();
	}

	public String getCRID_2() {
		return reader.getCRID_2();
	}

	public String getRateType() {
		return reader.getRateType();
	}

	public String getRateValue() {
		return reader.getRateValue();
	}

	public String getContractNumber() {
		return reader.getContractNumber();
	}

	public String getIssueState() {
		return reader.getIssueState();
	}

	public String getChargeLineCode() {
		return reader.getChargeLineCode();
	}

	public static void setAllValues() {
		reader.setCustomerID();
		reader.setStartDate();
		reader.setCRID();
		reader.setEndDate();
		reader.setComments();
		reader.setCoverageType();
		reader.setCRID_2();
		reader.setCRID_3();
		reader.setSplitPercentage_1();
		reader.setSplitPercentage_2();
		reader.setSplitPercentage_3();
		reader.setRateType();
		reader.setRateValue();
		reader.setContractNumber();
		reader.setIssueState();
		reader.setChargeLineCode();
		
		reader.setuserName();
		reader.setPassword();
		reader.setState();
		reader.setTotEligibleEmployees();
		reader.setAvgTotEligibleEmployees();
		reader.setQuoteType();
		reader.setCompanyName();
		reader.setAddress();
		reader.setCity();
		reader.setZipCode();
		reader.setSICCode();
		reader.setNonCOBRAEmployees();
		reader.setCOBRAEmployees();
		reader.setTotalEmployees();
	}

	/**
	 * @author hkaur115
	 * @category Common Feature Step
	 */
	@Given("^Flow_Fetch Data from excel Sheet for \"([^\"]*)\"$")
	public void flow_fetch_Data_from_excel_Sheet_for(String arg1) throws Throwable {
		autoProperties = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/UeS.properties");
		autoProperties.load(in);
		in.close();

		DataReader reader = new DataReader();
		String testCaseID = arg1;
		String screenName = "AOR";
		File inputWorkbook = null;
		int sheetIndex = 0;
		switch (screenName) {
		case "AOR":
			String dsPath = System.getProperty("user.dir") + "/" + autoProperties.getProperty("DataSheetPath");

			// String dsPath = "DataSheets/DataSheet_QA.xls";
			reader.LoadExcelApplication(dsPath);
			inputWorkbook = new File(dsPath);
			sheetIndex = 0;
			break;
		case "CommissionRates ":
			// reader.LoadExcelApplication("C:\\Users\\hkaur115\\Desktop\\TestData\\AORSheet.xls");
			// inputWorkbook = new
			// File("C:\\Users\\hkaur115\\Desktop\\TestData\\AORSheet.xls");
			sheetIndex = 1;
			break;
		}

		Workbook w;
		System.out.println(
				"reading xls:  " + System.getProperty("user.dir") + "\\" + autoProperties.getProperty("DataSheetPath"));

		try {
			System.out.println("try");
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(sheetIndex);

			for (int i = 0; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(1, i);
				if (cell.getContents().contains(testCaseID)) {
					System.out.println("Match Found for testCase Id\t" + cell.getContents());
					reader.setCurrentRow(i);
					System.out.println("Hello" + reader.getCurrentRow());
					break;
				}
			}
			CommonLibrary.setAllValues();

			System.out.println("Finally..." + reader.getCustomerID());

		} catch (BiffException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author hkaur115 Split function to split dates
	 * @return
	 */
	public String[] splitDate(String receivedDate) {
		String[] data = receivedDate.split("-");
		return data;

	}

	public String[] splitDate(String receivedDate, String delimiter) {
		String[] data = receivedDate.split(delimiter);
		return data;
	}

	/**
	 * @description This code is used for DB Validation
	 * @throws Throwable
	 */
	@Then("^Data should be loaded to respective tables$")
	public void dataShouldBeLoadedToRespectiveTables() throws Throwable {
		System.out.println("Loaded to database table");
		Connection con = null;
		Statement stmt = null;
		String hostName = autoProperties.getProperty("HostName");
		String serviceName = autoProperties.getProperty("ServiceName");
		String dbUserName = autoProperties.getProperty("DBUserName");
		String dbPwd = autoProperties.getProperty("DBPwd");
		Class.forName(autoProperties.getProperty("JDBCDriver"));
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + hostName + ":1521/" + serviceName, dbUserName, dbPwd);
		// step3 create the statement object
		stmt = con.createStatement();
		String query = autoProperties.getProperty("Query1");
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("query:- " + query);
		while (rs.next()) {
			if (rs.getString(1).equals("0513738"))
				System.out.println("Record is present in DB with value: " + rs.getString(1));
			break;
		}
	}
	// con.close();
	// stmt.close();
	// }

	/*@Then("^Data should be loaded to respective tables with validation$")
	public void dataShouldBeLoadedToRespectiveTables_1() throws Throwable {
		System.out.println("Loaded to database table");
		query1 = "select bil_prem_amt from contract_product_invoice_dtl where contr_nbr = '05P7502'";
		query2 = "select bil_prem_amt, bil_sbscr_cnt, rvnu_prd_strt_dt, rvnu_prd_end_dt from contract_product_invoice_dtl where contr_nbr = '05P7502'";
		queries = new ArrayList<String>();
		queries.add(query1);
		queries.add(query2);
		CommonLibrary c = new CommonLibrary();
		String[] arr = { "123", "234" };
		DBValidation.openWorkBook();
		for (int i = 0; i < 2; i++) {
			System.out.println("Done" + c.getCustomerID());

			Connection con = null;
			Statement stmt = null;
			String hostName = autoProperties.getProperty("HostName");
			String serviceName = autoProperties.getProperty("ServiceName");
			String dbUserName = autoProperties.getProperty("DBUserName");
			String dbPwd = autoProperties.getProperty("DBPwd");
			Class.forName(autoProperties.getProperty("JDBCDriver"));
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + hostName + ":1521/" + serviceName, dbUserName,
					dbPwd);
			// step3 create the statement object
			stmt = con.createStatement();
			for (int queryNo = 0; queryNo < queries.size(); queryNo++) {
				String queryFromConfig = autoProperties.getProperty("Query2");
				String query1FromConfig = autoProperties.getProperty("Query1");

				ResultSet rs = stmt.executeQuery(queries.get(queryNo));

				System.out.println("query:- " + queries.get(queryNo));
				int counter = 0;

				while (rs.next()) {
					counter = counter + 1;
					if (counter <= 10) {
						// System.out.println("Record is present in DB with
						// value: "+rs.getString(1));
						if (queries.get(queryNo).toString().contains(queryFromConfig)) {
							hm.put("Billed Premium", rs.getString(1));
							hm.put("Subscriber Count", rs.getString(2));
							hm.put("Revenue Start", rs.getString(3));
							hm.put("Revenue End", rs.getString(4));
							hm.put("CustomerID", arr[i]);
							DBValidation.createExcelData();
							DBValidation.compareValues();
							System.out.println("I came back");
							// writeInExcel(rs.getString(1));
							// readExcel();
						} else {
							hm.put("Paid Premium", rs.getString(1));
							DBValidation.createExcelData();
							DBValidation.compareValues();
							System.out.println("I came back");
							// setValueIntoCell("sheet1", 5, 1, "PASS");

						}
					}
				}
			}
			// DBValidation.writeExcelCells();
		}
		DBValidation.writeExcelCells();
	}

	public void writeInExcel(String value) throws RowsExceededException, WriteException, IOException {

		WritableWorkbook excelNameNew = null;
		WritableSheet newSheet;
		String screenName = "DB";
		File inputWorkbook = null;
		int sheetIndex = 0;
		switch (screenName) {
		case "DB":
			String dsPath = System.getProperty("user.dir") + "/" + autoProperties.getProperty("DataSheetPath");
			excelNameNew = Workbook
					.createWorkbook(new File("C:\\Users\\hkaur115\\Desktop\\excelfiles\\testSampleDataCopy.xls"));
			
			 * newSheet = excelNamenew.getSheet(0);
			 
			// String dsPath = "DataSheets/DataSheet_QA.xls";
			
			 * reader.LoadExcelApplication(dsPath); inputWorkbook = new
			 * File(dsPath); sheetIndex = 0; break;
			 

			System.out.println("reading xls:  " + System.getProperty("user.dir") + "\\"
					+ autoProperties.getProperty("DataSheetPath"));

			System.out.println("try");
			
			 * w = Workbook.getWorkbook(inputWorkbook); Sheet sheet =
			 * w.getSheet(sheetIndex);
			 
			WritableSheet writeInSheet = excelNameNew.getSheet("testSampleDataCopy");
			Label labTemp = new Label(1, 1, "Hi");
			writeInSheet.addCell(labTemp);

			
			 * for (int i = 0; i < writeInSheet.getRows(); i++) { for(int j = 0
			 * ; j < writeInSheet.getColumns();j++){ Cell cell =
			 * writeInSheet.getCell(1, i); if
			 * (cell.getContents().contains(null)) { reader.setCurrentRow(i);
			 * labTemp = new Label(2, 1, "Hi");
			 * 
			 * writeInSheet.addCell(labTemp); break; } }
			 

		}

		// con.close();
		// stmt.close();
		// }
	}

	public void readExcel() {
		try {
			wbook = Workbook.getWorkbook(new File("C:\\Users\\hkaur115\\Desktop\\excelfiles\\testSampleDataCopy.xls"));
			wwbCopy = Workbook.createWorkbook(new File("C:\\Users\\hkaur115\\Desktop\\excelfiles\\testSampleData.xls"),
					wbook);
			shSheet = wwbCopy.getSheet(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setValueIntoCell(String strSheetName, int iColumnNumber, int iRowNumber, String strData)
			throws WriteException {
		WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
		Label labTemp = new Label(iColumnNumber, iRowNumber, strData);

		try {
			wshTemp.addCell(labTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}