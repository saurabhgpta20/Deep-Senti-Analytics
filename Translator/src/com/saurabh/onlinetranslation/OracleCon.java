package com.saurabh.onlinetranslation;

import java.sql.Connection;
import java.sql.DriverManager;  
class OracleCon{ 
	static Connection con= null;
	public static Connection connectDb(){  
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			//step2 create  the connection object  
			con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@ca676practicum.ctpdpq7erozo.eu-west-1.rds.amazonaws.com:1521/ORCL","saurabh","oracle123");
		}catch(Exception e){ 
			System.out.println(e);
		}
		return con;  

	}  
}  