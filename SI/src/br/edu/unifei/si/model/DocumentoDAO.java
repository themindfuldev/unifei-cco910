package br.edu.unifei.si.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

import br.edu.unifei.si.ConversorDeFormatos;


public class DocumentoDAO {
    private String driverName = "com.mysql.jdbc.Driver"; 
    private String url = "jdbc:mysql://localhost:3306/si";
    private String username = "root";
    private String password = "";
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;    

    
    public DocumentoDAO() {
	try{
	 // Carregando o JDBC Driver
	    Class.forName("com.mysql.jdbc.Driver");	
	}
	catch (ClassNotFoundException e) {	    
	    e.printStackTrace();
	}
	
    }


    public void gravarDocumento(DocumentoVO si){
	try {	    
	    conn = DriverManager.getConnection(url, username, password);
	    stmt = conn.prepareStatement("INSERT INTO documento (numExame, digExame, nome, tamanho, arquivo) values(?, ?, ?, ?, ?)");
	    
	    stmt.setLong(1, si.getNumExame());
	    stmt.setLong(2, si.getDigExame());
	    
	    stmt.setString(3, si.getNome());
	    stmt.setLong(4, si.getTamanho());
	    InputStream isArquivo = ConversorDeFormatos.byteToInputStream(si.getArquivo());
	    stmt.setBinaryStream(5, isArquivo, 1);
	    
	    stmt.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public List consultarDocumentos(){
	List documentos =  new ArrayList();
	DocumentoVO documento = null;
	try {	    
	    conn = DriverManager.getConnection(url, username, password);
	    stmt = conn.prepareStatement("SELECT numExame, digExame, nome, tamanho FROM documento");
	    rs = stmt.executeQuery();
	    while (rs.next()) {
		long numExame = rs.getLong(1);
		long digExame = rs.getLong(2);
		String nome = rs.getString(3);
		long tamanho = rs.getLong(4);		

		documento = new DocumentoVO();
		documento.setNumExame(numExame);
		documento.setDigExame(digExame);
		documento.setNome(nome);
		documento.setTamanho(tamanho);
		

		documentos.add(documento);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return documentos;
    }

    public DocumentoVO lerArquivo(int numExame, int digExame){
	DocumentoVO documento = new DocumentoVO();

	try {
	    conn = DriverManager.getConnection(url, username, password);
	    stmt = conn.prepareStatement("SELECT nome, arquivo FROM documento WHERE numExame = ? AND digExame = ?");
	    stmt.setInt(1, numExame);
	    stmt.setInt(2, digExame);
	    
	    rs = stmt.executeQuery();
	    if (rs.next()) {
		String nome = rs.getString(1);
		documento.setNome(nome);
		byte[] arquivo = rs.getBytes(2);
		documento.setArquivo(arquivo);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return documento;
    }
}

