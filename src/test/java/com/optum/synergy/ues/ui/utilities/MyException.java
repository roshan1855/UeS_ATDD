package com.optum.synergy.ues.ui.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class MyException extends RuntimeException{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MyException(WebDriver driver , Utilities utility, Exception e) throws IOException {
			System.out.println("Exception Thrown");
	    	utility.GenerateReport("", e, "cause", "Please Rerun this TC");
	    	
	        
	    }

	    
	

}
