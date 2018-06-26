package org.frekele.fiscal.focus.nfe.client.repository.webhook;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseArrayJsonReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.request.webhook.body.WebHookCriarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookCriarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookExcluirResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API WebHooks.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusWebHookV2RepositoryImpl implements FocusWebHookV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusWebHookV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(ResponseArrayJsonReplaceFilter.class);
        this.auth = auth;
        this.client.register(ResponseArrayJsonReplaceFilter.class);
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusWebHookV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusWebHookV2ProxyClient.class);
    }

    /**
     * POST - Criar um novo WebHook.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/hooks
     */
    @Override
    public WebHookCriarResponse criar(WebHookCriarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(bodyRequest, "WebHookCriarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusWebHookV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.criar(this.getAuth().getBasicAuthorization(), bodyRequest);
    }

    /**
     * GET - Consultar um WebHook individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    @Override
    public WebHookConsultarResponse consultar(String webHookId) {
        FocusNFeUtils.throwObject(webHookId, "webHookId");
        FocusWebHookV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getBasicAuthorization(), webHookId);
    }

    /**
     * GET - Consultar os WebHooks disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/hooks
     */
    @Override
    public WebHookConsultarTodosResponse consultarTodos() {
        FocusWebHookV2ProxyClient proxyClient = this.getProxyClient();
        //QueryParam '?hooks=hooks' é usado para reconhecimento do ResponseArrayJsonReplaceFilter.
        return proxyClient.consultarTodos(this.getAuth().getBasicAuthorization(), "hooks");
    }

    /**
     * DELETE - Excluir um WebHook.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/hooks/HOOK_ID
     */
    @Override
    public WebHookExcluirResponse excluir(String webHookId) {
        FocusNFeUtils.throwObject(webHookId, "webHookId");
        FocusWebHookV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.excluir(this.getAuth().getBasicAuthorization(), webHookId);
    }
}
