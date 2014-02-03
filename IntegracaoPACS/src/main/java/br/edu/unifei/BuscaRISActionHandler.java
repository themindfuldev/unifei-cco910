package br.edu.unifei;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class BuscaRISActionHandler implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -805691025333527020L;

	public synchronized void execute(ExecutionContext context) throws Exception {
		// TODO: BUSCAR NAS BASES DE DADOS RIS
		String message = (String) context.getContextInstance().getVariable("message");
		if (null != message) {
			message += "Mamografia: XDXDXDXDXDXDXDXDXDXDXD";
		}
		else{
			message = "Mamografia: XDXDXDXDXDXDXDXDXDXDXD";
		}
		context.getContextInstance().setVariable("message", message);
	}

}
