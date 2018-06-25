package org.frekele.fiscal.focus.nfe.client.repository.ncm;

import org.frekele.fiscal.focus.nfe.client.model.request.ncm.param.NcmQueryParam;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarTodosResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API NCM.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusNcmV2Repository extends Serializable {

    /**
     * GET - Consultar um NCM individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/ncms/CODIGO_NCM
     */
    NcmConsultarResponse consultar(String ncm);

    /**
     * GET - Consultar os NCMs disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/ncms
     * O código NCM é formato por 8 dígitos no seguinte formato:
     * <p>
     * CCPPSÇII, sendo:
     * <ul>
     * <li>CC = Capitulo;
     * <li>PP = Posição;
     * <li>S = Subposição 1;
     * <li>Ç = Subposição 2;
     * <li>II = Item 1 e 2;
     * </ul>
     * São aceitos os seguintes parâmetros de pesquisa:
     * codigo: Pesquise pela parte inicial do código NCM
     * descricao: Pesquisa por parte da descrição do código NCM.
     * capitulo, posicao, subposicao1, subposicao2, item1 e item2: Pesquisa exata informando qualquer uma das partes do código NCM.
     * Para buscar os demais registros, utilize o parâmetro offset.
     */
    NcmConsultarTodosResponse consultarTodos(NcmQueryParam queryParam);
}
