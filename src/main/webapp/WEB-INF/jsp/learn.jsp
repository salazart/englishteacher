<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input new word</title>
</head>
<body onload=${popupMessage} onkeyup="hotkey(event)">
	<form id='frm' action="learn" method="post" >
	<input id="id" type="hidden" name="id" value=${id}>
		<table border="0" cellpadding="2" cellspacing="0" style="width: 360px">
			<tr>
				Направление перевода:<br>
				${engToRus ? "Англо-русский" : "Русско-английский"}
			</tr>
			<tr>
				<td><input name="exampleWord" type="text" size="20" value='${engToRus ? word.exampleWord : word.translateWord}'></td>
			</tr>
			<tr>
				<td><input name="translateWord" type="text" size="20" value='${translateWord}' autofocus></td>
			</tr>
			<tr>
				<td>
					<div>
						<input id='engCheck' type="checkbox" name="engToRus" value="true" onclick="changeCheck(1)" ${engToRus == 'true' ? 'checked' : ''}/>Eng-Rus<br />
                    	<input id='rusCheck' type="checkbox" name="engToRus" value="false" onclick="changeCheck(2)" ${engToRus == 'false' ? 'checked' : ''}/>Rus-Eng<br />
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
<script type="text/javascript">
function changeCheck(type) {
	var engCheck = document.getElementById('engCheck');
	var rusCheck = document.getElementById('rusCheck');
	if(type == 1 && engCheck.checked == true){
		rusCheck.checked = false;
	} else {
		rusCheck.checked = true;
	} 
	
	if(type = 2 && rusCheck.checked == true){
		engCheck.checked = false;
	} else {
		engCheck.checked = true;	
	}
	document.getElementById('id').value = 0;
	document.getElementById('frm').submit();
};
</script>
