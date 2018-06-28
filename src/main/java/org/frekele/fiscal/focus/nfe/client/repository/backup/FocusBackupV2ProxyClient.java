package org.frekele.fiscal.focus.nfe.client.repository.backup;

import org.frekele.fiscal.focus.nfe.client.model.response.backup.BackupConsultaResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas da API Backups.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusBackupV2ProxyClient extends Serializable {

    /**
     * GET - Consultar os Backups disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/backups/CNPJ.json
     */
    @GET
    @Path("backups/{cnpj}.json")
    BackupConsultaResponse consultarTodos(@HeaderParam("Authorization") String authorization,
                                          @PathParam("cnpj") String cnpj);
}
