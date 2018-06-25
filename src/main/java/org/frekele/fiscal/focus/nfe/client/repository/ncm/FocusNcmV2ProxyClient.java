package org.frekele.fiscal.focus.nfe.client.repository.ncm;

import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarTodosResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas da API NCM.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusNcmV2ProxyClient extends Serializable {

    /**
     * GET - Consultar um NCM individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/ncms/CODIGO_NCM
     */
    @GET
    @Path("ncms/{ncm}")
    NcmConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                   @PathParam("ncm") String ncm);

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
    @GET
    @Path("ncms")
    NcmConsultarTodosResponse consultarTodos(@HeaderParam("Authorization") String authorization,
                                             @QueryParam("codigo") String codigo,
                                             @QueryParam("descricao") String descricao,
                                             @QueryParam("capitulo") String capitulo,
                                             @QueryParam("posicao") String posicao,
                                             @QueryParam("subposicao1") String subposicao1,
                                             @QueryParam("subposicao2") String subposicao2,
                                             @QueryParam("item1") String item1,
                                             @QueryParam("item2") String item2,
                                             @QueryParam("offset") String offset);
}
