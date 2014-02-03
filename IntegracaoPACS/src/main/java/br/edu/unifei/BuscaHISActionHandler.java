package br.edu.unifei;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class BuscaHISActionHandler implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8428186444156094662L;

	public synchronized void execute(ExecutionContext context) throws Exception {
		// TODO: BUSCAR NAS BASES DE DADOS HIS
		String message = (String) context.getContextInstance().getVariable("message");
		if (null != message) {
			message += "Nome: Dona Maria\nCPF:123.456.789-0\nIdade: 46 anos";
		}
		else {
			message = "Nome: Dona Maria\nCPF:123.456.789-0\nIdade: 46 anos";
		}
		context.getContextInstance().setVariable("message", message);
	}

}
