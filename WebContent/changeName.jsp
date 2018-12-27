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
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="css/style2.css">
<title>Mypage</title>
</head>
<body>
	<div id="menu">
		<div class="menu"><a href="<s:url action='NewPostAction'/>">新規投稿</a></div>
		<div class="menu"><a href="<s:url action='EntrieListAction'/>">記事一覧</a></div>
		<div class="menu"><a href="<s:url action='CategoryAction'/>">カテゴリ</a></div>
		<div class="menu"><a href="<s:url action='LogoutAction'/>">ログアウト</a></div>
		<div class="menu"><a href="<s:url action='IndexAction'/>">トップ</a></div>
		<div class="menu"><a href="<s:url action='UserConfigAction'/>">ユーザ設定</a></div>
		<s:if test="session.admin">
			<div class="menu"><a href="<s:url action='UserManagementAction'/>">ユーザ管理</a></div>
		</s:if>
	</div>
	<div id="main">
		<h2>名前の変更</h2>
		<s:if test="message != null">
			<div class="message"><s:property value="message" escape="false"/></div>
		</s:if>
		<table>
			<tr>
				<td>現在の名前</td>
				<td><s:property value="session.name"/></td>
			</tr>
			<s:form action="ChangeNameCompleteAction">
			<tr>
				<td>変更後の名前</td>
				<td><input type="text" name="nameAfter"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="送信"></td>
			</tr>

			</s:form>
		</table>
	</div>
</body>
</html>