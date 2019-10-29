<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>UnsubscribeConfirm</title>

<script type="text/javascript">
				function submitAction(url){
					$('form').attr('action', url);
					$('form').submit();
				}
				function disp(){
					if(window.confirm('本当によろしいですか？')) {
						location.href = "UnsubscribeConfirmAction";
					}
				}
		</script>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UnsubscribeConfirm</p>
		</div>
		<div>
			<h2>退会しますか？</h2>
		</div>
		<s:form>
			<tr>
					<td><input type="button" value="戻る"
						onclick="submitAction('HomeAction')" /></td>
					<td><input type="button" value="退会"
						onclick="disp()" /></td>
				</tr>
		</s:form>
		<div>
			<p>※退会手続き後は、会員情報、購入履歴等すべてが削除されます。予めご了承ください。</p>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>