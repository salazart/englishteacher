<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input new word</title>
</head>
<body onload=${popupMessage} onkeyup="hotkey(event)">
	<form action="learn" method="post" >
	<input type="hidden" name="id" value=${id}>
		<table border="0" cellpadding="2" cellspacing="0" style="width: 480px">
			<tr>
				<td>English:</td>
				<td><input name="eng" type="text" size="14" value=${eng}></td>
			</tr>
			<tr>
				<td>Русский:</td>
				<td><input name="rus" type="text" size="14" value=${rus}></td>
			</tr>
			<tr>
				<td>
					<input name="save" type="submit" value="Проверить">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>