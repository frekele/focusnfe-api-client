package org.frekele.fiscal.focus.nfe.client.repository.webhook;

import org.frekele.fiscal.focus.nfe.client.core.FocusMediaType;
import org.frekele.fiscal.focus.nfe.client.model.request.webhook.body.WebHookCriarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookCriarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookExcluirResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas da API V2 WebHooks.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/v2")
@Produces({FocusMediaType.APPLICATION_JSON_CHARSET_UTF8})
@Consumes({FocusMediaType.APPLICATION_JSON_CHARSET_UTF8})
interface FocusWebHookV2ProxyClient extends Serializable {

    /**
     * POST - Criar um novo WebHook.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/hooks
     */
    @POST
    @Path("hooks")
    WebHookCriarResponse criar(@HeaderParam("Authorization") String authorization,
                               WebHookCriarBodyRequest bodyRequest);

    /**
     * GET - Consultar um WebHook individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    @GET
    @Path("hooks/{webHookId}")
    WebHookConsultarResponse consultar(@HeaderParam("Authorization") String authorization,
                                       @PathParam("webHookId") String webHookId);

    /**
     * GET - Consultar os WebHooks disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks?hooks=hooks
     * QueryParam '?hooks=hooks' é usado para reconhecimento do ResponseArrayJsonReplaceFilter.
     */
    @GET
    @Path("hooks")
    WebHookConsultarTodosResponse consultarTodos(@HeaderParam("Authorization") String authorization,
                                                 @QueryParam("hooks") String hooks);

    /**
     * DELETE - Excluir um WebHook.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    @DELETE
    @Path("hooks/{webHookId}")
    WebHookExcluirResponse excluir(@HeaderParam("Authorization") String authorization,
                                   @PathParam("webHookId") String webHookId);
}
