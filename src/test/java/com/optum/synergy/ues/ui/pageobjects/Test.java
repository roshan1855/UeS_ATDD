package com.optum.synergy.ues.ui.pageobjects;

import java.util.ArrayList;
import java.util.List;


public class Test {
	
	public static String test;
	public static List<String> a;

	public static List<String> xyz(){
		System.out.println("This is Method ::");
		String s="Optum";
		a = new ArrayList<String>();
		a.add(s);
		System.out.println("List Value in method :: " + a.get(1));
        return a;
	}
	
	public void ABC(){
		System.err.println("Test ::" + test );
	}
	
	public static void main(String[] args) {
		Test tst=new Test();
		//System.out.println("Another Method ::" + tst.ABC(););
	//	String abc=tst.xyz();
		System.out.println("Returned String ::" + xyz().get(1));
		//String s = "ATTN: Mogili Vamshi";
		String s="ATTN: ANNE BALL";
		String[] Name=s.split(":");
		System.out.println("Actual Name1 :" +Name[0] );
		System.out.println("Actual Name2 :" +Name[1] );
		
		String[] NewName=Name[1].trim().split(" ");
		
		System.out.println("After Split First Name : " +NewName[0]);
		System.out.println("After Split Last Name : " +NewName[1]);
		
		System.out.println("Required Last Name:: " + NewName[1]);
		
		/*int res=Integer.parseInt(AnulPremium[0]);
		System.out.println("Result ::" + res);
	     	 	
	 	if(Integer.parseInt(AnulPremium[0]) != 0){
	 		System.out.println("ANNUAL PREMIUM Amount ::" +s + " displayed successfully" );
	 		}
	 	else{
	 		System.out.println("ANNUAL PREMIUM Amount ::" +s + "not displayed" );
	 	}*/
	}
	}
