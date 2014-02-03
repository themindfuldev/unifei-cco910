
/**
 * ServicoImagensSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package br.edu.unifei.ws;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import br.edu.unifei.servicos.ObterImagemResponse;
import br.edu.unifei.servicos.ServicoImagens;
    /**
     *  ServicoImagensSkeleton java skeleton for the axisService
     */
    public class ServicoImagensSkeleton implements ServicoImagensSkeletonInterface{
	
	private ServicoImagens servico = new ServicoImagens();
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param obterImagem0
         */
        
                 public br.edu.unifei.servicos.ObterImagemResponse obterImagem
                  (
                  br.edu.unifei.servicos.ObterImagem obterImagem0
                  )
            {
                Integer digExame = obterImagem0.getDigExame();
                Integer numExame = obterImagem0.getNumExame();
                
                byte[] imagem = servico.obterImagem(numExame, digExame);
                
                DataHandler dataHandler = new DataHandler(imagem, "image/jpeg");
                
                ObterImagemResponse response = new ObterImagemResponse();
                response.set_return(dataHandler);
                
                return response;
                     
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#obterImagem");
        }
     
    }
    