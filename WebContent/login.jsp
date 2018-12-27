<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>Insert title here</title>
<style>
	body{
		background-color: #EFEFEF;
		text-align : center;
		font-family:'メイリオ','sans-serif';
	}
	#main {
	  position: absolute;
	  top: 0px;
	  right: 0px;
	  bottom: 0px;
	  left: 0px;
	  margin: auto;

	  width: 400px;
	  height: 400px;
	  background-color:#FFFFFF;
	  box-shadow:0 0 50px #AAAAAA;
	}

	 h2{
	 	margin-top: 50px;
	 	font-weight: normal;
	 }
	.form{
		margin: auto;
		margin-top:30px;
	}
	.textfield{
		margin-bottom:20px;
	}
	.submit{
		background-color:#FFFFFF;
		margin-right:75px;
		margin-top:10px;
	}

	#main a{
		position:absolute;
		bottom:0;
		right:0;
	}
</style>
</head>
<body>
<div id="main">
	<h2>ログイン</h2>
	<s:if test="message != null">
		<p><s:property value="message"/></p>
	</s:if>
	<s:form action="LoginCompleteAction" cssClass="form">
		<s:textfield cssClass="textfield" name="login_id" placeholder="ログインID"/>
		<s:password cssClass="textfield" name="login_pass" placeholder="パスワード"/>
		<s:submit cssClass="submit" value="ログイン"/>
	</s:form>
	<a href="<s:url action='IndexAction'/>">戻る</a>
</div>
</body>
</html>