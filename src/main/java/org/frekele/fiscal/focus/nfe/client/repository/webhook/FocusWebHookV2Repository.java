package org.frekele.fiscal.focus.nfe.client.repository.webhook;

import org.frekele.fiscal.focus.nfe.client.model.request.webhook.body.WebHookCriarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookCriarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookExcluirResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API V2 WebHooks.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusWebHookV2Repository extends Serializable {

    /**
     * POST - Criar um novo WebHook.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/hooks
     */

    WebHookCriarResponse criar(WebHookCriarBodyRequest bodyRequest);

    /**
     * GET - Consultar um WebHook individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    WebHookConsultarResponse consultar(String webHookId);

    /**
     * GET - Consultar os WebHooks disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks
     */
    WebHookConsultarTodosResponse consultarTodos();

    /**
     * DELETE - Excluir um WebHook.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    WebHookExcluirResponse excluir(String webHookId);
}
