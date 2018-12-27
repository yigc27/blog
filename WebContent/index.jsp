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
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>SampleBlog</title>
</head>
<body>
		<div id="page_top"><a href="#"></a></div>
	<div id="header">
		<h1><a href="<s:url action='IndexAction'/>">SampleBlog</a></h1>
	</div>
	<div id="main">
		<div id="content">
			<s:iterator value="entrieList">
				<div class="entrie">
					<span class="category">カテゴリ：<s:property value="category"/></span>
					<h2><s:property value="title"/></h2>
					<div class="post_date"><s:property value="post_date"/></div>
					<div class="text"><s:property value="text" escape="false"/></div>
					<div class="author"><s:property value="author"/></div>

				</div>
			</s:iterator>
		</div>
		<div id="menu">
			<s:if test="session.id != null">
			<p><a href="<s:url action="LoginCompleteAction"/>">マイページ</a></p>
			</s:if>
			<s:else>
			<p><a href="<s:url action='LoginAction'/>">ログイン</a></p>
			</s:else>
			<h2>カテゴリ</h2>
			<ul>
				<s:iterator value="categoryList">
					<li>
						<form action = "CategoryRefineAction">
							<input type="hidden" name="categoryid" value="<s:property value='id'/>">
							<input type="submit" value="<s:property value='name'/>" class="textsubmit"/>
						</form>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p id="copywrite">copywrite</p>
	</div>
</body>
</html>