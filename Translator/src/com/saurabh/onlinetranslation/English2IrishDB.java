package com.saurabh.onlinetranslation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class English2IrishDB {
	String ret = "ERROR";
	Connection conn = null;
	ArrayList<EnglishUser> list1 = new ArrayList<EnglishUser>();

	public ArrayList<EnglishUser> getList1() {
		return list1;
	}
	
	public void setList1(ArrayList<EnglishUser> list1) {
		this.list1 = list1;
	}

/******************************************************************/

	public String englishToIrishDB(){
		try{
			conn = OracleCon.connectDb();
			String str = "select * from TWEET_TABLE ORDER BY SNO";
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				EnglishUser englishUser = new EnglishUser();
				englishUser.setSno(rs.getInt(1));
				englishUser.setEnglish_tweet(rs.getString(2));
				englishUser.setIrish_translate(rs.getString(3));
				englishUser.setScore1(rs.getInt(4));
				list1.add(englishUser);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "SUCCESS";
	}
	
/******************************************************************/
}
