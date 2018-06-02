package org.frekele.fiscal.focus.nfe.client.repository.nfce;

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
interface FocusNFCeV2ProxyClient extends Serializable {

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são síncronos.
     * Cria uma nota fiscal e a envia para processamento.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfce
     */
    @POST
    @Path("nfce")
    FocusNFeEntity send(@HeaderParam("Authorization") String authorization,
                        @QueryParam("ref") String referencia);

    /**
     * GET - Consultar NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET http://homologacao.acrasnfe.acras.com.br/v2/nfce/12345
     */
    @GET
    @Path("nfce/{referencia}")
    FocusNFeEntity find(@HeaderParam("Authorization") String authorization,
                        @PathParam("referencia") String referencia);

    /**
     * GET - Consultar NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET http://homologacao.acrasnfe.acras.com.br/v2/nfce/12345?completa=1
     */
    @GET
    @Path("nfce/{referencia}")
    FocusNFeEntity find(@HeaderParam("Authorization") String authorization,
                        @PathParam("referencia") String referencia,
                        @QueryParam("completa") String completa);

    /**
     * DELETE - Cancelar NFCe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE http://homologacao.acrasnfe.acras.com.br/v2/nfce/12345
     */
    @DELETE
    @Path("nfce/{referencia}")
    FocusNFeEntity cancel(@HeaderParam("Authorization") String authorization,
                          @PathParam("referencia") String referencia);

    /**
     * POST - Encaminhar uma NFCe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfce/12345/email
     */
    @POST
    @Path("nfce/{referencia}/email")
    FocusNFeEntity sendEmail(@HeaderParam("Authorization") String authorization,
                             @PathParam("referencia") String referencia);

    /**
     * POST - Inutilizar o número de alguma série de NFCe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST http://homologacao.acrasnfe.acras.com.br/v2/nfce/inutilizacao
     */
    @POST
    @Path("nfce/inutilizacao")
    FocusNFeEntity disablement(@HeaderParam("Authorization") String authorization);
}
