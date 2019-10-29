<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>itemCreate</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ItemCreate</p>
		</div>
		<h2>新規商品登録ページ</h2>
		<s:form action="ItemCreateConfirmAction">
			<tr>
				<td>
					<label>商品名:</label>
				</td>
				<td>
					<input type="text" name="itemName">
				<tr>
			</tr>
			<tr>
				<td>
					<label>価格:</label>
				</td>
				<td>
					<input type="number" name="itemPrice">
				</td>
			</tr>
			<tr>
				<td>
					<label>在庫:</label>
				</td>
				<td>
					<input type="number" name="itemStock">
				</td>
			</tr>
				<s:submit value="登録確認"/>
		</s:form>
		<p>管理者画面に<a href='<s:url action="AdminAction"/>'>戻る</a></p>
	</div>
	<div id="footer"></div>
</body>
</html>