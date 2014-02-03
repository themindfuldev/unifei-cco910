<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="br.edu.unifei.si.model.DocumentoVO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	DocumentoVO documento = (DocumentoVO) session.getAttribute("documento");

	byte[] arquivo = documento.getArquivo();

	if (arquivo != null) {
		String nomeArquivo = documento.getNome();
		response.setHeader("Content-Disposition", "attachment;filename=" + nomeArquivo);
		response.setContentType("APPLICATION/OCTET-STREAM");
		OutputStream saida = response.getOutputStream();
		saida.write(arquivo);
		saida.flush();
		saida.close();
	}
%>
</body>
</html>
