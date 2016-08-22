package com.saurabh.onlinetranslation;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthenticate extends ActionSupport{
		private static final long serialVersionUID = 1L;
		private String username;
		private String password;
		//private int score; 
	
/************************************************************/		
	
		public String authenticate(){
			//System.out.println(score);
			if(this.username.equals("admin") && this.password.equals("admin")){
			//	System.out.println(score);
				return "SUCCESS";
			}else{
				System.out.println(username + " " + password);
				addActionError(getText("error.login"));
				return "ERROR";
			}
			
		}
		
/************************************************************/		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
