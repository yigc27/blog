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
		<h2><s:if test="session.admin">記事一覧</s:if>
		<s:else><s:property value="session.name"/>さんの記事一覧</s:else></h2>
		<div>
			<s:if test="message != null">
				<div class="message"><s:property value="message"/></div>
			</s:if>
			<s:iterator value="entrieList">
				<div class="entrie">
					<div class="info">
						<div class="update_date">最終更新日:<s:property value="update_date"/></div>
						<div class="post_date"><s:property value="post_date"/></div>
						<div class="category"><s:property value="category"/></div>
						<h3><s:property value="title"/></h3>
						<s:if test="session.admin"><div class="author">執筆者:<s:property value="author"/></div></s:if>
					</div>
					<div class="edit">
						<form action="EditPostAction" name="edit">
							<input type="hidden" name = "postid" value="<s:property value='id'/>">
							<input type="submit" class="textsubmit" value="編集"/>
						</form>
						<form action="DeleteEntrieAction" name="delete">
							<input type="hidden" name="postid" value="<s:property value='id'/>">
							<input type="submit" class="textsubmit" value="削除"/>
						</form>
				</div>
			</div>
			</s:iterator>
		</div>
	</div>
</body>
</html>