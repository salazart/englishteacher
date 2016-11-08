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
		<table border="0" cellpadding="2" cellspacing="0" style="width: 360px">
			<tr>
				Направление перевода:<br>
				${wayTranslate}
			</tr>
			<tr>
				<td><input name="exampleWord" type="text" size="20" value='${exampleWord}'></td>
			</tr>
			<tr>
				<td><input name="translateWord" type="text" size="20" value='${translateWord}' autofocus></td>
			</tr>
			<tr>
				<td>
					<div>
						<input type="checkbox" name="engToRus" value="true" ${engToRus == 'true' ? 'checked' : ''}/>Eng-Rus<br />
                    	<input type="checkbox" name="engToRus" value="false"${engToRus == 'false' ? 'checked' : ''}/>Rus-Eng<br />
					</div>
				</td>
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
