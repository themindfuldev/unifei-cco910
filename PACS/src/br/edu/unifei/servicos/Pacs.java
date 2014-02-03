package br.edu.unifei.servicos;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import br.edu.unifei.beans.ExameRadiologico;
import br.edu.unifei.servicos.ServicoImagensStub.ObterImagem;
import br.edu.unifei.servicos.ServicoImagensStub.ObterImagemResponse;
import br.edu.unifei.servicos.ServicosConsultaStub.ConsultaExamesDePaciente;

public class Pacs {
	public static void main(java.lang.String args[]){
        try{
        	ServicoImagensStub servicoImagensStub =
                new ServicoImagensStub
                ("http://localhost:8088/axis2/services/ServicoImagens");
        	
        	ServicosConsultaStub servicosConsultaStub =
                new ServicosConsultaStub
                ("http://localhost:8088/axis2/services/ServicosConsulta");

            diagnosticoMamografia(servicoImagensStub, servicosConsultaStub);

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("\n\n\n");
        }
    }

    private static void diagnosticoMamografia(
			ServicoImagensStub servicoImagensStub,
			ServicosConsultaStub servicosConsultaStub) {
    	
        try{    	
	    	ObterImagem obterImagemRequest = new ObterImagem();
	    	
	    	obterImagemRequest.setDigExame(1);
	    	obterImagemRequest.setNumExame(1);
			
	    	ObterImagemResponse response = servicoImagensStub.obterImagem(obterImagemRequest);
	    	
	    	byte[] imagem = (byte[]) response.get_return().getContent();
	    	System.out.println(Arrays.toString(imagem));

	    	
	    	ConsultaExamesDePaciente consultaExamesDePacienteRequest = new ConsultaExamesDePaciente();
	    	consultaExamesDePacienteRequest.setCodPaciente(1);
	    	
	    	List<ExameRadiologico> listaExamesRadiologicos = (List<ExameRadiologico>) servicosConsultaStub.consultaExamesDePaciente(consultaExamesDePacienteRequest).get_return();
	    	
	    	System.out.println(listaExamesRadiologicos.get(0).getDscConclusao());
	    	
	    } catch(Exception e){
	        e.printStackTrace();
	        System.out.println("\n\n\n");
	    }
	}

}
