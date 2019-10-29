<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<meta charset="UTF-8">
		<title>AdminPage</title>

	</head>
	<body>
		<div id="header">
		</div>
		<div id="main">
			<div id="top">
				<p>AdminPage</p>
			</div>
			<h2>管理者用ページ</h2>
			<div>
				<table>
					<tr>
						<td>商品：</td>
							<td><s:form action="ItemCreateAction">
								<s:submit value="新規登録"/>
							</s:form></td>
							<td><s:form action="ItemListAction">
								<s:submit value="一覧表示"/>
							</s:form></td>
					</tr>
					<tr>
						<td>ユーザー：</td>
							<td><s:form action="UserCreateAction">
							<s:submit value="新規登録"/>
						</s:form></td>
							<td><s:form action="UserListAction">
							<s:submit value="一覧表示"/>
						</s:form></td>
					</tr>
				</table>
				<p>管理者ページを離れる:<a href='<s:url action="GoHomeAction"/>'>ホームへ</a>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>