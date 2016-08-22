package com.saurabh.onlinetranslation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;


public class English2Irish extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int sno;
	private String englishTweet;
	private String irishtranslation;
	private int score;
	private int var1;
	
	@SkipValidation
	public String englishToIrish(){
		String ret = "ERROR";
		Connection conn = null;
	
		try {
			conn = OracleCon.connectDb();
			String str = "select * from TWEET_TABLE WHERE SCORE1 is null ORDER BY SNO";
			PreparedStatement ps = conn.prepareStatement(str);
			setScore(-1);
			ps.setMaxRows(1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sno = rs.getInt(1);
				englishTweet = rs.getString(2);
				ret = "SUCCESS";
			}
		} catch (Exception e) {
			System.out.println(e);
			ret = "ERROR";
		}finally {
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
				}
			}
		}
		return ret;
	}
	
	/*************************************************************************/
	
	public String translate() throws SQLException {
		String ret = "ERROR";
		Connection conn = null;
		
		try{
			conn = OracleCon.connectDb();
			String str = "update TWEET_TABLE set IRISH_TRANSLATE=?, SCORE1=? where sno= ?";
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, irishtranslation);
			ps.setInt(2, score);
			ps.setInt(3, sno);
			//System.out.println(score);
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
			//System.out.println("Record is inserted into DBUSER table!");
			
			ret = "SUCCESS";
		}catch(Exception e){
			System.out.println(e.getMessage());

			ret = "ERROR";
		}finally {
			setIrishtranslation("");
			setScore(0);
			if(conn != null){
				try{
					conn.close();
					//setUsername("admin");
					//setPassword("admin");
					return this.englishToIrish();
				}catch(Exception e){
					addActionError(getText("error.login"));
					return "ERROR";
				}
			}
		}
		return ret;


	}
	
	@Override
	public void validate()
	{
		if (getScore() == -1) {
			addFieldError("score", "Enter the score!! \n If you want to skip this tweet leave translation field blank and submit confidence level : 0");		
		}
		if (hasErrors()) {
			this.englishToIrish();
		}
	}
	
	
	/*************************************************************************/
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getEnglishTweet() {
		return englishTweet;
	}

	public void setEnglishTweet(String englishTweet) {
		this.englishTweet = englishTweet;
	}
	
	public String getIrishtranslation() {
		return irishtranslation;
	}

	public void setIrishtranslation(String irishtranslation) {
		this.irishtranslation = irishtranslation;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
