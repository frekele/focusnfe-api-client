package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeInutilizarResponse;

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
 * Proxy RestEasy para chamadas da API NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusNFCeV2ProxyClient extends Serializable {

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA
     */
    @POST
    @Path("nfce")
    NFCeAutorizarResponse autorizar(@HeaderParam("Authorization") String authorization,
                                    @QueryParam("ref") String referencia,
                                    NFCeAutorizarBodyRequest bodyRequest);

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos e retorna informações completa.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA&completa=(0|1)
     */
    @POST
    @Path("nfce")
    NFCeAutorizarResponse autorizar(@HeaderParam("Authorization") String authorization,
                                    @QueryParam("ref") String referencia,
                                    @QueryParam("completa") Integer completa,
                                    NFCeAutorizarBodyRequest bodyRequest);

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    @GET
    @Path("nfce/{referencia}")
    NFCeConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                    @PathParam("referencia") String referencia);

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA?completa=(0|1)
     */
    @GET
    @Path("nfce/{referencia}")
    NFCeConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                    @PathParam("referencia") String referencia,
                                    @QueryParam("completa") Integer completa);

    /**
     * DELETE - Cancelar NFCe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    @DELETE
    @Path("nfce/{referencia}")
    NFCeCancelarResponse cancelar(@HeaderParam("Authorization") String authorization,
                                  @PathParam("referencia") String referencia,
                                  NFCeCancelarBodyRequest bodyRequest);

    /**
     * POST - Encaminhar uma NFCe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/REFERENCIA/email
     */
    @POST
    @Path("nfce/{referencia}/email")
    NFCeEmailResponse enviarEmail(@HeaderParam("Authorization") String authorization,
                                  @PathParam("referencia") String referencia,
                                  NFCeEmailBodyRequest bodyRequest);

    /**
     * POST - Inutilizar uma faixa de numeração de NFCe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/inutilizacao
     */
    @POST
    @Path("nfce/inutilizacao")
    NFCeInutilizarResponse inutilizar(@HeaderParam("Authorization") String authorization,
                                      NFCeInutilizarBodyRequest bodyRequest);
}
