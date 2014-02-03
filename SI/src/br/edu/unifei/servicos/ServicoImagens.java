package br.edu.unifei.servicos;

import br.edu.unifei.si.model.DocumentoDAO;
import br.edu.unifei.si.model.DocumentoVO;

/**
 * Servi�os de obten��o de imagens propostos para este SI.
 * 
 * @author Tiago Romero Garcia
 */
public class ServicoImagens {
    private DocumentoDAO dao = new DocumentoDAO();

    /**
     * Obten��o da imagem de um determinado exame.
     * 
     * @param numExame
     *                n�mero do exame
     * @param digExame
     *                d�gito do exame
     * @return imagem serializada relacionada ao exame
     */
    public byte[] obterImagem(Integer numExame, Integer digExame) {

	if (null == numExame || null == digExame) {
	    return null;
	}

	byte[] imagem = null;

	DocumentoVO vo = dao.lerArquivo(numExame, digExame);
	if (null != vo) {
	    imagem = vo.getArquivo();
	}

	return imagem;
    }
}
