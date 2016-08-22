package com.saurabh.onlinetranslation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Irish2EnglishDB {
	String ret = "ERROR";
	Connection conn = null;
	ArrayList<IrishUser> list2 = new ArrayList<IrishUser>();

	public ArrayList<IrishUser> getList2() {
		return list2;
	}
	
	public void setList2(ArrayList<IrishUser> list2) {
		this.list2 = list2;
	}

/******************************************************************/

	public String irishToEnglishDB(){
		try{
			conn = OracleCon.connectDb();
			String str = "select * from TABLE1 ORDER BY SNO";
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				IrishUser irishUser = new IrishUser();
				irishUser.setSno(rs.getInt(1));
				irishUser.setIrish_tweet(rs.getString(2));
				irishUser.setEng_translate(rs.getString(3));
				irishUser.setScore1(rs.getInt(4));
				list2.add(irishUser);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
/******************************************************************/
	
}
