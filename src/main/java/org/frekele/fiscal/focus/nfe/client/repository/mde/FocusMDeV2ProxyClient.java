package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusMDeV2ProxyClient extends Serializable {

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    @GET
    @Path("xxxx/{referencia}")
    FocusNFeEntity consultar(@HeaderParam("Authorization") String authorization,
                             @PathParam("referencia") String referencia);
}
