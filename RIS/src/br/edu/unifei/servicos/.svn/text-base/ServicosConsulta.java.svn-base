package br.edu.unifei.servicos;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.unifei.beans.ExameRadiologico;
import br.edu.unifei.beans.ExameRadiologicoDao;
import br.edu.unifei.beans.Paciente;
import br.edu.unifei.beans.PacienteDao;

/**
 * Serviços de consulta propostos para este RIS.
 * 
 * @author Tiago Romero Garcia
 */
public class ServicosConsulta {

	private ExameRadiologicoDao exameRadiologicoDao = new ExameRadiologicoDao();
	private PacienteDao pacienteDao = new PacienteDao();

	/**
	 * Consulta de pacientes por nome/sobrenome
	 * 
	 * @param nome
	 *            nome ou sobrenome do paciente a ser buscado
	 * @return lista com pacientes correspondentes à busca
	 */
	public List<Paciente> consultaPacientes(String nome) {

		if (null == nome) {
			return null;
		}

		String hql = "FROM Paciente p WHERE p.nomPaciente LIKE '%"
				+ nome + "%'";

		List lista = pacienteDao.findByHQL(hql);

		return lista;
	}

	/**
	 * Consulta de exames radiológicos por região anatômica e/ou tipo
	 * de exame mais período
	 * 
	 * @param codRegiao
	 *            código da região anadômica a ser buscado
	 * @param codExame
	 *            código do tipo de exame a ser buscado
	 * @param dataInicio
	 *            data inicial do período a ser buscado
	 * @param dataFim
	 *            data final do período a ser buscado
	 * @return lista com exames radiológicos correspondentes à busca
	 */
	public List<ExameRadiologico> consultaPorRegiaoAnatomicaEOuTipoDeExame(
			Integer codRegiao, Integer codExame, Date dataInicio,
			Date dataFim) {

		if (null == dataInicio || null == dataInicio) {
			return null;
		}

		if (null == codRegiao && null == codExame) {
			return null;
		}

		String hql = "FROM ExameRadiologico e WHERE ";

		if (null != codRegiao) {
			hql += "e.regiaoExame.codRegiao = " + codRegiao + " AND ";
		}

		if (null != codExame) {
			hql += "e.exame.codExame = " + codExame + " AND ";
		}

		hql += "e.dtaRealizacaoExame >= :dataInicio " +
				"AND e.dtaRealizacaoExame <= :dataFim";

		Map<String, Date> datas = new HashMap<String, Date>();
		datas.put("dataInicio", dataInicio);
		datas.put("dataFim", dataFim);

		List lista = exameRadiologicoDao.findByHQL(hql, datas);

		return lista;
	}

	/**
	 * Consulta de exames radiológicos por código do paciente
	 * 
	 * @param codPaciente
	 *            código do paciente a ser buscado
	 * @return lista com exames radiológicos correspondentes à busca
	 */
	public List<ExameRadiologico> consultaExamesDePaciente(
			Integer codPaciente) {

		if (null == codPaciente) {
			return null;
		}

		ExameRadiologico retorno = null;

		String hql = "FROM ExameRadiologico e WHERE " +
				"e.paciente.codPaciente = " + codPaciente;

		List lista = exameRadiologicoDao.findByHQL(hql);

		return lista;
	}

	/**
	 * Consulta de exames radiológicos por palavras-chave presentes na
	 * conclusão de exame mais período
	 * 
	 * @param palavrasChave
	 *            array de palavras-chave presentes na conclusão do
	 *            exame a ser buscado
	 * @param dataInicio
	 *            data inicial do período a ser buscado
	 * @param dataFim
	 *            data final do período a ser buscado
	 * @return lista com exames radiológicos correspondentes à busca
	 */
	public List<ExameRadiologico> consultaPorDescricaoDoLaudo(
			String[] palavrasChave, Date dataInicio, Date dataFim) {

		if (null == palavrasChave) {
			return null;
		}

		if (null == dataInicio || null == dataInicio) {
			return null;
		}

		String hql = "FROM ExameRadiologico e WHERE ";

		for (String palavrachave : palavrasChave) {
			hql += "e.dscConclusao LIKE '%" + palavrachave
					+ "%' AND ";
		}

		hql += "e.dtaRealizacaoExame >= :dataInicio AND " +
				"e.dtaRealizacaoExame <= :dataFim";

		Map<String, Date> datas = new HashMap<String, Date>();
		datas.put("dataInicio", dataInicio);
		datas.put("dataFim", dataFim);

		List lista = exameRadiologicoDao.findByHQL(hql, datas);

		return lista;
	}

	/**
	 * Consulta de exames radiológicos completa
	 * 
	 * @param nome
	 *            nome ou sobrenome do paciente a ser buscado
	 * @param codRegiao
	 *            código da região anadômica a ser buscado
	 * @param codExame
	 *            código do tipo de exame a ser buscado
	 * @param palavrasChave
	 *            array de palavras-chave presentes na conclusão do
	 *            exame a ser buscado
	 * @param dataInicio
	 *            data inicial do período a ser buscado
	 * @param dataFim
	 *            data final do período a ser buscado
	 * @return lista com exames radiológicos correspondentes à busca
	 */
	public List<ExameRadiologico> consultaCompleta(String nome,
			Integer codRegiao, Integer codExame,
			String[] palavrasChave, Date dataInicio, Date dataFim) {

		if (null == dataInicio || null == dataInicio) {
			return null;
		}

		String hql = "FROM ExameRadiologico e WHERE ";

		if (null != nome) {
			hql += "e.paciente.nomPaciente LIKE '%" + nome
					+ "%' AND ";
		}

		if (null != codRegiao) {
			hql += "e.regiaoExame.codRegiao = " + codRegiao + " AND ";
		}

		if (null != codExame) {
			hql += "e.exame.codExame = " + codExame + " AND ";
		}

		for (String palavrachave : palavrasChave) {
			hql += "e.dscConclusao LIKE '%" + palavrachave
					+ "%' AND ";
		}

		hql += "e.dtaRealizacaoExame >= :dataInicio AND " +
				"e.dtaRealizacaoExame <= :dataFim";

		Map<String, Date> datas = new HashMap<String, Date>();
		datas.put("dataInicio", dataInicio);
		datas.put("dataFim", dataFim);

		List lista = exameRadiologicoDao.findByHQL(hql, datas);

		return lista;
	}
}
