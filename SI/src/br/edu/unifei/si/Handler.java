package br.edu.unifei.si;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.edu.unifei.si.model.DocumentoDAO;
import br.edu.unifei.si.model.DocumentoVO;

public class Handler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DocumentoVO documento;
    private String acao;

    public Handler() {
	super();
	this.documento = new DocumentoVO();
	this.acao = null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String numExame = request.getParameter("numExame");
	String digExame = request.getParameter("digExame");

	DocumentoDAO documentoDAO = new DocumentoDAO();

	DocumentoVO documento = documentoDAO.lerArquivo(Integer.parseInt(numExame), Integer.parseInt(digExame));

	HttpSession sessao = request.getSession();
	sessao.setAttribute("documento", documento);
	response.sendRedirect("downloadarquivos.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	
	
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);		

	if (isMultipart) {
	    this.processaRequisicao(request);
	    
	    if(acao.equals("gravardocumento")){			
		DocumentoDAO documentoDAO = new DocumentoDAO();
		documentoDAO.gravarDocumento(this.documento);
		response.sendRedirect("sucessogravacao.jsp");
	    }
	    if(acao.equals("listardocumentos")){
		DocumentoDAO documentoDAO = new DocumentoDAO();
		List documentos = documentoDAO.consultarDocumentos();
		HttpSession sessao = request.getSession();
		sessao.setAttribute("documentos", documentos);
		response.sendRedirect("listagemdedocumentos.jsp");
	    }
	}
    }

    private void processaRequisicao(HttpServletRequest request){
	List items = null;
	FileItem fileItem = null;	

	try {
	    FileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    items = upload.parseRequest(request);

	    Iterator iterator = items.iterator();
	    while (iterator.hasNext()) {
		fileItem = (FileItem) iterator.next();

		if (fileItem.isFormField()) {
		    processaCampo(fileItem);
		} else {
		    processaArquivo(fileItem);
		}
	    }
	} catch (FileUploadException e) {
	    e.printStackTrace();
	}
    }

    private void processaCampo(FileItem fileItem){
	String campo = fileItem.getFieldName();
	String valor = fileItem.getString();

	if(campo.equals("numExame")){
	    this.documento.setNumExame(Integer.parseInt(valor));
	}
	
	if(campo.equals("digExame")){
	    this.documento.setDigExame(Integer.parseInt(valor));
	}
	
	if(campo.equals("tipo")){
	    this.documento.setTipo(valor);
	}

	if(campo.equals("bAcao")){
	    this.acao = valor;
	}
    }

    private void processaArquivo(FileItem fileItem){
	String nomeDoArquivo = fileItem.getName();
	this.documento.setNome(nomeDoArquivo);

	long tamanhoDoArquivo = fileItem.getSize();
	this.documento.setTamanho(tamanhoDoArquivo);

	byte[] arquivo = ConversorDeFormatos.fileItemToBytes(fileItem);
	this.documento.setArquivo(arquivo);
    }
}
