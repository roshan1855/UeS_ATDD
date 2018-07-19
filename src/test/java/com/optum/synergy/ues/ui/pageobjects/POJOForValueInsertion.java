package com.optum.synergy.ues.ui.pageobjects;

public class POJOForValueInsertion {
	
	public static int row;
	public static int getCurrentRow() {
		return currentRow;
	}
	public static void setCurrentRow(int currentRow) {
		POJOForValueInsertion.currentRow = currentRow;
	}
	public static void setCol(int col) {
		POJOForValueInsertion.col = col;
	}
	public static int getCol() {
		return col;
	}
	public static int col;
	public static int currentRow;
	

}
