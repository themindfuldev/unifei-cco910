<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript">
	function setAction(acao) {
		document.formulario.bAcao.value = acao;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h4>Selecione uma imagem e clique em "Gravar"</h4>
<form name="formulario" method="post" enctype="multipart/form-data"
	action="Handler.do">
<table>
	<tr>
		<td>numExame:</td>
		<td><input type="text" size="26" name="numExame" value="0"/></td>
	</tr>
    <tr>
		<td>digExame</td>
		<td><input type="text" size="26" name="digExame" value="0"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="file" name="arquivo" /></td>
	</tr>
	<tr>
		<td colspan="2">
          <input type="submit" value="Gravar imagem" onclick="setAction('gravardocumento')" />
          <input type="submit" value="Listar documentos" onclick="setAction('listardocumentos')" />
		  <input type="hidden" name="bAcao" />
       </td>
	</tr>
</table>
</form>
</body>
</html>
