package com.optum.synergy.ues.ui.pageobjects;

public class Test {

	public static void main(String[] args) {
		String s = "2,969.28";
       // float f = Float.parseFloat(s);
		/*float f=Float.valueOf(s);
        System.out.println(f);
        String d = s.substring(1, 9);*/
		
		String[] AnulPremium=s.split(",");
		
		System.out.println(AnulPremium[0]);
		System.out.println(AnulPremium[1]);
		
		int res=Integer.parseInt(AnulPremium[0]);
		System.out.println("Result ::" + res);
	     	 	
	 	if(res != 0){
	 		System.out.println("ANNUAL PREMIUM Amount ::" +s + " displayed successfully" );
	 		}
	 	else{
	 		System.out.println("ANNUAL PREMIUM Amount ::" +s + "not displayed" );
	 	}

	}}
