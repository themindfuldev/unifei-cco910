package br.edu.unifei.servicos;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import br.edu.unifei.beans.ExameRadiologico;
import br.edu.unifei.beans.Paciente;

/**
 * Test case para os serviços de consulta.
 * @author Tiago Romero Garcia
 */
public class ServicosConsultaTest extends TestCase {
	
	private ServicosConsulta servicos = new ServicosConsulta();

	/**
	 * Teste para o método consultaPacientes.
	 */
	public void testConsultaPacientes() {
		List<Paciente> listaPacientes = servicos.consultaPacientes("Maria");
		
		for (Paciente p: listaPacientes) {
			System.out.println(p.getNomPaciente());
		}
	}

	/**
	 * Teste para o método consultaPorRegiaoAnatomicaEOuTipoDeExame.
	 */
	public void testConsultaPorRegiaoAnatomicaEOuTipoDeExame() {
		List<ExameRadiologico> lista = servicos.consultaPorRegiaoAnatomicaEOuTipoDeExame(1, 1, new Date(108, 1, 1), new Date());
		
		for (ExameRadiologico e: lista) {
			System.out.println(e.getId().getNumExame() + " " + e.getId().getDigExame());
		}
	}

	/**
	 * Teste para o método consultaExamesDePaciente.
	 */
	public void testConsultaExamesDePaciente() {
		List<ExameRadiologico> lista = servicos.consultaExamesDePaciente(1);
		
		for (ExameRadiologico e: lista) {
			System.out.println(e.getId().getNumExame() + " " + e.getId().getDigExame());
		}
	}

	/**
	 * Teste para o método consultaPorDescricaoDoLaudo.
	 */
	public void testConsultaPorDescricaoDoLaudo() {
		List<ExameRadiologico> lista = servicos.consultaPorDescricaoDoLaudo(new String[]{"sem", "problemas"}, new Date(108, 1, 1), new Date());
		
		for (ExameRadiologico e: lista) {
			System.out.println(e.getId().getNumExame() + " " + e.getId().getDigExame());
		}
	}

	/**
	 * Teste para o método consultaCompleta.
	 */
	public void testConsultaCompleta() {
		List<ExameRadiologico> lista = servicos.consultaCompleta("Maria", 1, 1, new String[]{"sem", "problemas"}, new Date(108, 1, 1), new Date());
		
		for (ExameRadiologico e: lista) {
			System.out.println(e.getId().getNumExame() + " " + e.getId().getDigExame());
		}
	}

}
