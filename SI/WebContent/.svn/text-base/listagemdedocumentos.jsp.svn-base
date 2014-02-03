<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<c:set var="docs" scope="session" value="${documentos}" />
<table border="1">
	<tr>		
		<td>NumExame</td>
		<td>digExame</td>
		<td>Nome</td>
		<td>Tamanho</td>
		<td>Tipo</td>
  </tr>
	
	<c:forEach var="documento" items="${docs}">
	  <form method="get" action="Handler.do">
		<input type="hidden" name="numExame"value="${documento.numExame}" />
		<input type="hidden" name="digExame"value="${documento.digExame}" />
	      
		<tr>			
			<td align="center"><c:out value="${documento.numExame}" /></td>
			<td align="center"><c:out value="${documento.digExame}" /></td>
			<td><c:out value="${documento.nome}" /></td>
			<td align="right"><c:out value="${documento.tamanho}" /></td>
			<td><c:out value="${documento.tipo}" /></td>
			<td><input type="submit" value="Download" /> </td>
		</tr>            
      </form>
	</c:forEach>
</table>



<a href="index.jsp">Home</a>
</body>
</html>
