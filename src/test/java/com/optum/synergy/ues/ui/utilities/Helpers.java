package com.optum.synergy.ues.ui.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  
class Helpers{  
public void DB_EstablishConnection(String driverName , String hostName , String SID){
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
//"jdbc:oracle:thin:@dbsld0024.uhc.com:1521/basts04svc.uhc.com ","BODSAPP","bodsapp_qa");  
		"jdbc:oracle:thin:@ed01dbadm02.uhc.com:1521/basts07svc.uhc.com ","BODSAPP","bodsapp_dv");  


//step3 create the statement object  
Statement stmt=con.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from producer");  
while(rs.next())  {
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
int temp = rs.getInt(1);
if(temp==160766)  {
	System.out.println("Match Found");
break;		}
}
//step5 close the connection object  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}  