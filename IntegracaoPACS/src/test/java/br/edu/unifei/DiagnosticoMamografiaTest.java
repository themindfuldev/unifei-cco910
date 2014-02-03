package br.edu.unifei;

import junit.framework.TestCase;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

public class DiagnosticoMamografiaTest extends TestCase {

	public void testSimpleProcess() throws Exception {

		// Extract a process definition from the processdefinition.xml file.
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("DiagnosticoMamografia/processdefinition.xml");
		assertNotNull("Definition should not be null", processDefinition);

		// Create an instance of the process definition.
		ProcessInstance instance = new ProcessInstance(processDefinition);

		// Move the process instance from its start state to the first state.
		// The configured action should execute and the appropriate message
		// should appear in the message process variable.
		instance.signal();

		// Move the process instance to the end state. The configured action 
		// should execute again. The message variable contains a new value.
		instance.signal();
		instance.signal();
		instance.signal();
		instance.signal();
		
		assertEquals(
				"Valor não correspondente",
				"Nome: Dona Maria\nCPF:123.456.789-0\nIdade: 46 anos\nMamografia: XDXDXDXDXDXDXDXDXDXDXD", 
				instance.getContextInstance().getVariable("diagnostico"));
		assertTrue("Instance has ended", instance.hasEnded());
	}

}
