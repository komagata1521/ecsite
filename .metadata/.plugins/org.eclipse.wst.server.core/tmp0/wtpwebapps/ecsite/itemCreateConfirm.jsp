<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemCreateConfirm</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<div id="header"></div>
		<div id="main">
			<div id="top">
				<p>ItemCreateConfirm</p>
			</div>
<div>
				<h3>登録する内容は以下でよろしいですか。</h3>
				<table>
					<s:form action="ItemCreateCompleteAction">
					<tr id="box">
						<td>
							<label>商品名：</label>
						</td>
						<td>
							<s:property value="itemName" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>価格：</label>
						</td>
						<td>
							<s:property value="itemPrice" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>在庫数：</label>
						</td>
						<td>
							<s:property value="itemStock" escape="false"/>
						</td>
					</tr>
					<tr>
						<s:submit value="完了"/>
					</tr>
					</s:form>
				</table>
			</div>
		</div>
		<div id="footer"></div>
</body>
</html>