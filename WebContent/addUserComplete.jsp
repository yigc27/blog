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
		<h2>ユーザ追加完了</h2>
		<s:if test="message != null">
			<div class="message"><s:property value="message" escape = "false"/></div>
		</s:if>
		<div>
			<table>
				<tr>
					<td>
						名前
					</td>
					<td>
						<s:property value = "name"/>
					</td>
				</tr>
				<tr>
					<td>
						ログインID
					</td>
					<td>
						<s:property value = "login_id"/>
					</td>
				</tr>
				<tr>
					<td>
						パスワード
					</td>
					<td>
						<s:property value = "login_pass"/>
					</td>
				</tr>
				<tr>
					<td>
						権限
					</td>
					<td>
						<s:if test="admin == false">一般</s:if>
						<s:else>管理者</s:else>
					</td>
				</tr>
				<tr></tr>
			</table>
		</div>
	</div>
</body>
</html>