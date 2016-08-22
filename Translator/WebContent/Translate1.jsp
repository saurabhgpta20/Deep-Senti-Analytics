<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags"%>
   <link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Welcome</title>
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
<div align="center" style="border:0.5px solid black; width: 500px; margin-left: 32%;" >
<s:form action="translate.action" method="post">
<s:hidden id = "englishTweet" name = "englishTweet"/>
<s:hidden id = "sno" name = "sno"/>
	<h3>S.NO.: <s:property value="sno"/></h3>
	<h3><label for = "title">English Tweet: </label><br></br><textarea id="title" name="title"  rows="4" cols="50" readonly="readonly" style="resize:none"><s:property value="englishTweet" /></textarea></h3>
	<h3><label for = "translatetweet">Irish Translation:</label><s:textarea name = "irishtranslation" rows="4" cols="50" style="margin-left: -130px;"/></h3>
	 <s:select name="score" label="Confidence Level" style="font-size:18px;" headerKey="-1" headerValue="Please Select"
         list="{'0','1','2','3','4','5','6','7','8','9','10'}" />
	<s:submit method="translate" key="label.submit" align="center" style="padding: 12px 28px; border-radius:12px; font-weight:bold; margin-top: 10px;"/>
	</s:form>
</div>

<br><h3 align="center">"Please enter your translation into the text box provided,</br>
rate your translation on a scale of 1-10 using the drop-down menu, and then click "Submit." </h3>

<hr style="margin-top: 10px;">
</body>
</html>