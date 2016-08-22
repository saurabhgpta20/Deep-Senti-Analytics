<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="styles.css">
<html>
<head>
<title>Translator</title>
</head>

<body background="images/back.jpg" style="background-repeat:no-repeat; background-size:100% 100%">
<p><img src="images/adapt_logo.png" width="200" height="130" alt="" class="left" align="middle" style="vertical-align:middle"/><p style="text-align:center; margin-top:-85px;font-family:'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; font-size:50px;" >Translator Web Application</p></p>
<hr style="margin-top:-15px;">
<s:actionerror />
<div style="width: 200px; margin:0 auto;">

<s:form action="english2Irish.action" method="post">
	<s:submit cssClass="button" method="englishToIrish" key="label.engToirish" align="center" />
</s:form>
<s:form action="irish2English.action" method="post">
	<s:submit cssClass="button" method="irishToEnglish" key="label.irishToeng" align="center" style="margin-top: 10px;"/>
</s:form> 
<s:form action="instruction.action" method="post">
	<s:submit cssClass="button" method="instructions" key="label.instruction" align="center" style="margin-top: 10px;"/>
</s:form>
<s:form action="login.action" method="post">
	<s:submit cssClass="button" method="adminPanel" key="label.adminPanel" align="center" style="margin-top: 10px;"/>
</s:form>
<s:form action="sentimentinput.action" method="post">
	<s:submit cssClass="button" method="sentimentInput" key="label.sentimentinput" align="center" style="margin-top: 10px;"/>
</s:form>
</div>
</body>
</html>