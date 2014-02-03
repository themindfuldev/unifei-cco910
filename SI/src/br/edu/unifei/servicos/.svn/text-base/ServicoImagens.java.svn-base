package br.edu.unifei.servicos;

import br.edu.unifei.si.model.DocumentoDAO;
import br.edu.unifei.si.model.DocumentoVO;

/**
 * Serviços de obtenção de imagens propostos para este SI.
 * 
 * @author Tiago Romero Garcia
 */
public class ServicoImagens {
    private DocumentoDAO dao = new DocumentoDAO();

    /**
     * Obtenção da imagem de um determinado exame.
     * 
     * @param numExame
     *                número do exame
     * @param digExame
     *                dígito do exame
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
