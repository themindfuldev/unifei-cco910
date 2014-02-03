
/**
 * ServicosConsultaSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package br.edu.unifei.ws;

import java.util.Date;
import java.util.List;

import br.edu.unifei.beans.ExameRadiologico;
import br.edu.unifei.beans.Paciente;
import br.edu.unifei.servicos.ConsultaCompletaResponse;
import br.edu.unifei.servicos.ConsultaExamesDePacienteResponse;
import br.edu.unifei.servicos.ConsultaPacientesResponse;
import br.edu.unifei.servicos.ConsultaPorDescricaoDoLaudoResponse;
import br.edu.unifei.servicos.ConsultaPorRegiaoAnatomicaEOuTipoDeExameResponse;
import br.edu.unifei.servicos.ServicosConsulta;
    /**
     *  ServicosConsultaSkeleton java skeleton for the axisService
     */
    public class ServicosConsultaSkeleton implements ServicosConsultaSkeletonInterface{
        
    	private ServicosConsulta servico = new ServicosConsulta();
         
        /**
         * Auto generated method signature
         * 
                                     * @param consultaCompleta0
         */
        
                 public br.edu.unifei.servicos.ConsultaCompletaResponse consultaCompleta
                  (
                  br.edu.unifei.servicos.ConsultaCompleta consultaCompleta0
                  )
            {
                	 String nome = consultaCompleta0.getNome();
                	 Integer codRegiao = consultaCompleta0.getCodRegiao();
                	 Integer codExame = consultaCompleta0.getCodExame();
         			 String[] palavrasChave = consultaCompleta0.getPalavrasChave();
         			 Date dataInicio = consultaCompleta0.getDataInicio().getTime();
         			 Date dataFim = consultaCompleta0.getDataFim().getTime();
         			 
         			List<ExameRadiologico> lista = servico.consultaCompleta(nome, codRegiao, codExame, palavrasChave, dataInicio, dataFim);
         			
         			ConsultaCompletaResponse response = new ConsultaCompletaResponse();
         			response.set_return(lista);
         			
         			return response;
                	 
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#consultaCompleta");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param consultaPorRegiaoAnatomicaEOuTipoDeExame2
         */
        
                 public br.edu.unifei.servicos.ConsultaPorRegiaoAnatomicaEOuTipoDeExameResponse consultaPorRegiaoAnatomicaEOuTipoDeExame
                  (
                  br.edu.unifei.servicos.ConsultaPorRegiaoAnatomicaEOuTipoDeExame consultaPorRegiaoAnatomicaEOuTipoDeExame2
                  )
            {
                	 Integer codRegiao = consultaPorRegiaoAnatomicaEOuTipoDeExame2.getCodRegiao();
                	 Integer codExame = consultaPorRegiaoAnatomicaEOuTipoDeExame2.getCodExame();
         			 Date dataInicio = consultaPorRegiaoAnatomicaEOuTipoDeExame2.getDataInicio().getTime();
         			 Date dataFim = consultaPorRegiaoAnatomicaEOuTipoDeExame2.getDataFim().getTime();
         			 
         			List<ExameRadiologico> lista = servico.consultaPorRegiaoAnatomicaEOuTipoDeExame(codRegiao, codExame, dataInicio, dataFim);
         			
         			ConsultaPorRegiaoAnatomicaEOuTipoDeExameResponse response = new ConsultaPorRegiaoAnatomicaEOuTipoDeExameResponse();
         			response.set_return(lista);
         			
         			return response;
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#consultaPorRegiaoAnatomicaEOuTipoDeExame");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param consultaExamesDePaciente4
         */
        
                 public br.edu.unifei.servicos.ConsultaExamesDePacienteResponse consultaExamesDePaciente
                  (
                  br.edu.unifei.servicos.ConsultaExamesDePaciente consultaExamesDePaciente4
                  )
            {
                	 Integer codPaciente = consultaExamesDePaciente4.getCodPaciente();
         			 
         			List<ExameRadiologico> lista = servico.consultaExamesDePaciente(codPaciente);
         			
         			ConsultaExamesDePacienteResponse response = new ConsultaExamesDePacienteResponse();
         			response.set_return(lista);
         			
         			return response;
         			
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#consultaExamesDePaciente");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param consultaPacientes6
         */
        
                 public br.edu.unifei.servicos.ConsultaPacientesResponse consultaPacientes
                  (
                  br.edu.unifei.servicos.ConsultaPacientes consultaPacientes6
                  )
            {
                	String nome = consultaPacientes6.getNome();

         			List<Paciente> lista = servico.consultaPacientes(nome);
         			
         			ConsultaPacientesResponse response = new ConsultaPacientesResponse();
         			response.set_return(lista);
         			
         			return response;
         			
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#consultaPacientes");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param consultaPorDescricaoDoLaudo8
         */
        
                 public br.edu.unifei.servicos.ConsultaPorDescricaoDoLaudoResponse consultaPorDescricaoDoLaudo
                  (
                  br.edu.unifei.servicos.ConsultaPorDescricaoDoLaudo consultaPorDescricaoDoLaudo8
                  )
            {
         			 String[] palavrasChave = consultaPorDescricaoDoLaudo8.getPalavrasChave();
         			 Date dataInicio = consultaPorDescricaoDoLaudo8.getDataInicio().getTime();
         			 Date dataFim = consultaPorDescricaoDoLaudo8.getDataFim().getTime();
         			 
         			List<ExameRadiologico> lista = servico.consultaPorDescricaoDoLaudo(palavrasChave, dataInicio, dataFim);
         			
         			ConsultaPorDescricaoDoLaudoResponse response = new ConsultaPorDescricaoDoLaudoResponse();
         			response.set_return(lista);
         			
         			return response;
         			
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#consultaPorDescricaoDoLaudo");
        }
     
    }
    