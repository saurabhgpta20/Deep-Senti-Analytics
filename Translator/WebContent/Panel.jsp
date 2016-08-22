<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Admin Panel</title>
</head>
<body background="images/back.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%">
	<p>
		<img src="images/adapt_logo.png" width="200" height="130" alt=""
			class="left" align="middle" style="vertical-align: middle" />
		<p style="text-align: center; margin-top: -85px; font-family: 'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; font-size: 50px;">Translator
			Web Application</p>
	</p>
	<hr style="margin-top: -15px;">
	
	<s:actionerror />
<div align="center" style="border:0.5px solid black; width: 400px; margin-left: 35%; margin-top: 40px;" >
<h2><u>Admin Login</u></h2>
</br>
	<s:form action="loginPanel.action" method="post">
		
			<s:textfield name="username" key="label.username" size="20" placeholder="e.g. 'smith'"/>
			<s:password name="password" key="label.password" size="20" placeholder="******" />
			<s:submit method="execute" key="label.login" align="center" style="padding: 12px 28px; border-radius:12px;"/>
		
	</s:form>
</div>
</body>
</html>