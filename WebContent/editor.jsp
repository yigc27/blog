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
		<h2>記事の編集</h2>
		<s:if test="message != null">
			<div class="message">
				<s:property value="message"/>
			</div>
		</s:if>
		<div id="editor">
			<s:form action="PostAction">
				<table>
					<tr>
						<td class="label">
							<label>タイトル</label>
						</td>
						<td>
								<input type="text" name="title" class="title" value="<s:property value='session.title'/>">
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>カテゴリ</label>
						</td>
						<td>
							<select name="category">
								<s:iterator value="categoryList">
									<s:if test="session.category == id">
										<option value="<s:property value='id'/>" selected><s:property value='name'/></option>
									</s:if>
									<s:else>
										<option value="<s:property value='id'/>"><s:property value='name'/></option>
									</s:else>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>本文</label>
						</td>
						<td>
								<textarea name="text" class="text"><s:property value='session.text'/></textarea>
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>公開設定</label>
						</td>
						<td>
							<select name="publish">
								<s:if test="session.publish == false">
									<option value="true">公開</option>
									<option value="false" selected>非公開</option>
								</s:if>
								<s:else>
									<option value="true" selected>公開</option>
									<option value="false">非公開</option>
								</s:else>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<s:submit value="投稿"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
</body>
</html>