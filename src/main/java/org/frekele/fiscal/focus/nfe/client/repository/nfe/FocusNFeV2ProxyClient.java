package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

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
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfe
     */
    @POST
    @Path("nfe")
    FocusNFeEntity send(@HeaderParam("Authorization") String authorization,
                        @QueryParam("ref") String referencia);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET http://homologacao.acrasnfe.acras.com.br/v2/nfe/12345
     */
    @GET
    @Path("nfe/{referencia}")
    FocusNFeEntity find(@HeaderParam("Authorization") String authorization,
                        @PathParam("referencia") String referencia);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET http://homologacao.acrasnfe.acras.com.br/v2/nfe/12345?completa=1
     */
    @GET
    @Path("nfe/{referencia}")
    FocusNFeEntity find(@HeaderParam("Authorization") String authorization,
                        @PathParam("referencia") String referencia,
                        @QueryParam("completa") String completa);

    /**
     * DELETE - Cancelar NFe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE http://homologacao.acrasnfe.acras.com.br/v2/nfe/12345
     */
    @DELETE
    @Path("nfe/{referencia}")
    FocusNFeEntity cancel(@HeaderParam("Authorization") String authorization,
                          @PathParam("referencia") String referencia);

    /**
     * POST - Emitir Carta de Correção.
     * Cria uma carta de correção para a nota fiscal com a referência informada.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfe/12345/carta_correcao
     */
    @POST
    @Path("nfe/{referencia}/carta_correcao")
    FocusNFeEntity sendCCe(@HeaderParam("Authorization") String authorization,
                           @PathParam("referencia") String referencia);

    /**
     * POST - Encaminhar uma NFe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfe/12345/email
     */
    @POST
    @Path("nfe/{referencia}/email")
    FocusNFeEntity sendEmail(@HeaderParam("Authorization") String authorization,
                             @PathParam("referencia") String referencia);

    /**
     * POST - Inutilizar uma faixa de numeração de NFe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfe/inutilizacao
     */
    @POST
    @Path("nfe/inutilizacao")
    FocusNFeEntity disablement(@HeaderParam("Authorization") String authorization);
}
