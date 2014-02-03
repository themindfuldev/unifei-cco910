package br.edu.unifei;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class JuncaoDiagnosticoActionHandler implements ActionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2053358775806855688L;

	/**
	 * A message process variable is assigned the value of the message
	 * member. The process variable is created if it doesn't exist yet.
	 */
	public synchronized void execute(ExecutionContext context) throws Exception {
		//String message1 = (String) context.getContextInstance().getVariable("messageHIS");
		//String message1 = null;
		//String message2 = (String) context.getContextInstance().getVariable("messageRIS");
		//String diagnostico = message1 + "\n"+ message2;
		String diagnostico = (String) context.getContextInstance().getVariable("message");
		
		context.getContextInstance().setVariable("diagnostico", diagnostico);
	}

}
