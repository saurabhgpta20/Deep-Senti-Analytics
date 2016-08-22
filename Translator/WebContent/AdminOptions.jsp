<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Admin Options</title>
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
	<div style="width: 200px; margin: 0 auto;">
		<h2 style="font-family: cursive; margin-top: 20px;"><u>Admin Options</u></h2>
		<s:form action="english2IrishDB.action" method="post">
			<s:submit cssClass="button" method="englishToIrishDB" key="label.engToirish"
				align="center" />
		</s:form>
		<s:form action="irish2EnglishDB.action" method="post">
			<s:submit cssClass="button" method="irishToEnglishDB" key="label.irishToeng"
				align="center" />
		</s:form>
	</div></br></br>
</div>
</body>
</html>