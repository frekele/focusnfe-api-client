package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeInutilizarResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusNFCeV2RepositoryImpl implements FocusNFCeV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusNFCeV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class);
        this.auth = auth;
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusNFCeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusNFCeV2ProxyClient.class);
    }

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA
     */
    @Override
    public NFCeAutorizarResponse autorizar(String referencia, NFCeAutorizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeAutorizarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.autorizar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos e retorna informações completa.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA&completa=(0|1)
     */
    @Override
    public NFCeAutorizarResponse autorizarConsultarTudo(String referencia, NFCeAutorizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeAutorizarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.autorizar(this.getAuth().getAuthorization(), referencia, 1, bodyRequest);
    }

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    @Override
    public NFCeConsultarResponse consultar(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia);
    }

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA?completa=(0|1)
     */
    @Override
    public NFCeConsultarResponse consultarTudo(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia, 1);
    }

    /**
     * DELETE - Cancelar NFCe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    @Override
    public NFCeCancelarResponse cancelar(String referencia, NFCeCancelarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeCancelarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.cancelar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Encaminhar uma NFCe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/REFERENCIA/email
     */
    @Override
    public NFCeEmailResponse enviarEmail(String referencia, NFCeEmailBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeEmailBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.enviarEmail(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    /**
     * POST - Inutilizar uma faixa de numeração de NFCe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/inutilizacao
     */
    @Override
    public NFCeInutilizarResponse inutilizar(NFCeInutilizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(bodyRequest, "NFCeInutilizarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.inutilizar(this.getAuth().getAuthorization(), bodyRequest);
    }
}
