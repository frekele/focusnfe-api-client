package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCCeBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCCeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeInutilizarResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas da API NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusNFeV2ProxyClient extends Serializable {

    /**
     * POST - Emitir NFe utilizando dados simplificados.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Cria uma nota fiscal e a envia para processamento.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe?ref=REFERENCIA
     */
    @POST
    @Path("nfe")
    NFeAutorizarResponse autorizar(@HeaderParam("Authorization") String authorization,
                                   @QueryParam("ref") String referencia,
                                   NFeAutorizarBodyRequest bodyRequest);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    @GET
    @Path("nfe/{referencia}")
    NFeConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                   @PathParam("referencia") String referencia);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA?completa=(0|1)
     */
    @GET
    @Path("nfe/{referencia}")
    NFeConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                   @PathParam("referencia") String referencia,
                                   @QueryParam("completa") Integer completa);

    /**
     * DELETE - Cancelar NFe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    @DELETE
    @Path("nfe/{referencia}")
    NFeCancelarResponse cancelar(@HeaderParam("Authorization") String authorization,
                                 @PathParam("referencia") String referencia,
                                 NFeCancelarBodyRequest bodyRequest);

    /**
     * POST - Emitir Carta de Correção.
     * Cria uma carta de correção para a nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/carta_correcao
     */
    @POST
    @Path("nfe/{referencia}/carta_correcao")
    NFeCCeResponse emitirCCe(@HeaderParam("Authorization") String authorization,
                             @PathParam("referencia") String referencia,
                             NFeCCeBodyRequest bodyRequest);

    /**
     * POST - Encaminhar uma NFe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/email
     */
    @POST
    @Path("nfe/{referencia}/email")
    NFeEmailResponse enviarEmail(@HeaderParam("Authorization") String authorization,
                                 @PathParam("referencia") String referencia,
                                 NFeEmailBodyRequest bodyRequest);

    /**
     * POST - Inutilizar uma faixa de numeração de NFe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/inutilizacao
     */
    @POST
    @Path("nfe/inutilizacao")
    NFeInutilizarResponse inutilizar(@HeaderParam("Authorization") String authorization,
                                     NFeInutilizarBodyRequest bodyRequest);
}
