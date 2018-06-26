package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestHeaderInfoFilter;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
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
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusNFeV2RepositoryImpl implements FocusNFeV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusNFeV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(RequestHeaderInfoFilter.class);
        this.auth = auth;
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusNFeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusNFeV2ProxyClient.class);
    }

    /**
     * POST - Emitir NFe utilizando dados simplificados.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Cria uma nota fiscal e a envia para processamento.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe?ref=REFERENCIA
     */
    @Override
    public NFeAutorizarResponse autorizar(String referencia, NFeAutorizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeAutorizarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.autorizar(this.getAuth().getBasicAuthorization(), referencia, bodyRequest);
    }

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    @Override
    public NFeConsultarResponse consultar(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getBasicAuthorization(), referencia);
    }

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA?completa=(0|1)
     */
    @Override
    public NFeConsultarResponse consultarNFeCompleta(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getBasicAuthorization(), referencia, 1);
    }

    /**
     * DELETE - Cancelar NFe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    @Override
    public NFeCancelarResponse cancelar(String referencia, NFeCancelarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeCancelarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.cancelar(this.getAuth().getBasicAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Emitir Carta de Correção.
     * Cria uma carta de correção para a nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/carta_correcao
     */
    @Override
    public NFeCCeResponse emitirCCe(String referencia, NFeCCeBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeCCeBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.emitirCCe(this.getAuth().getBasicAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Encaminhar uma NFe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/email
     */
    @Override
    public NFeEmailResponse enviarEmail(String referencia, NFeEmailBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeEmailBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.enviarEmail(this.getAuth().getBasicAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Inutilizar uma faixa de numeração de NFe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/inutilizacao
     */
    @Override
    public NFeInutilizarResponse inutilizar(NFeInutilizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(bodyRequest, "NFeInutilizarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.inutilizar(this.getAuth().getBasicAuthorization(), bodyRequest);
    }
}
