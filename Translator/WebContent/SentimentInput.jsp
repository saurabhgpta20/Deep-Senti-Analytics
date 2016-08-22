<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <link rel="stylesheet" type="text/css" href="styles.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Sentiment</title>
</head>
<body background="images/back.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%">
<p>
		<img src="images/adapt_logo.png" width="200" height="130" alt=""
			class="left" align="middle" style="vertical-align: middle" />
		<p style="text-align: center; margin-top: -85px; font-family: 'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; font-size: 50px;">Deep Senti-Analytics</p>
	</p>
	<hr style="margin-top: -15px;">
<div align="center" style="border:0.5px solid black; width: 500px; margin-left: 32%;" >
<s:form action="sentimentanalysis.action" method="post">
	<h3><label for = "translatetweet">Enter Keyword:</label><s:textarea name = "inputtweet" rows="4" cols="50" style="margin-left: -0px;"/></h3>
	<s:submit method="sentimentAnalysis" key="label.submit" align="center" style="padding: 12px 28px; border-radius:12px; font-weight:bold; margin-top: 10px;"/>
	</s:form>
</div>

</body>
</html>