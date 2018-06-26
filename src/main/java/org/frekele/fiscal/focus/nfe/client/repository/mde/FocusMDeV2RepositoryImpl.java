package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseArrayJsonReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.request.mde.body.MDeManifestarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarNFeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarUltimoManifestoResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeDownloadXmlResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeManifestarResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusMDeV2RepositoryImpl implements FocusMDeV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusMDeV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(ResponseArrayJsonReplaceFilter.class);
        this.auth = auth;
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusMDeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusMDeV2ProxyClient.class);
    }

    /**
     * POST - Realiza um manifesto na nota informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/manifesto
     */
    @Override
    public MDeManifestarResponse manifestar(String chaveNFe, MDeManifestarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusNFeUtils.throwObject(bodyRequest, "MDeManifestarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.manifestar(this.getAuth().getBasicAuthorization(), chaveNFe, bodyRequest);
    }

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ
     */
    @Override
    public MDeConsultarManifestosResponse consultarManifestos(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestos(this.getAuth().getBasicAuthorization(), cnpj);
    }

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&versao=VERSAO
     */
    @Override
    public MDeConsultarManifestosResponse consultarManifestos(String cnpj, Integer versao) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusNFeUtils.throwObject(versao, "versao");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosVersao(this.getAuth().getBasicAuthorization(), cnpj, versao);
    }

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&pendente=PENDENTE
     */
    @Override
    public MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosPendente(this.getAuth().getBasicAuthorization(), cnpj, "true");
    }

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&versao=VERSAO&pendente=PENDENTE
     */
    @Override
    public MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj, Integer versao) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusNFeUtils.throwObject(versao, "versao");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosVersaoPendente(this.getAuth().getBasicAuthorization(), cnpj, versao, "true");
    }

    /**
     * GET - Consulta o último manifesto válido na nota fiscal informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/manifesto
     */
    @Override
    public MDeConsultarUltimoManifestoResponse consultarUltimoManifesto(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarUltimoManifesto(this.getAuth().getBasicAuthorization(), chaveNFe);
    }

    /**
     * GET - Consulta as informações da nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.json
     */
    @Override
    public MDeConsultarNFeResponse consultarNFe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarNFe(this.getAuth().getBasicAuthorization(), chaveNFe);
    }

    /**
     * GET - Consulta as informações da nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.json?completa=1
     */
    @Override
    public MDeConsultarNFeResponse consultarNFeCompleta(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarNFe(this.getAuth().getBasicAuthorization(), chaveNFe, 1);
    }

    /**
     * GET - Baixar o XML de uma nota fiscal especifica:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.xml
     */
    @Override
    public MDeDownloadXmlResponse downloadNFe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadNFe(this.getAuth().getBasicAuthorization(), chaveNFe);
    }

    /**
     * GET - Baixar o XML de cancelamento de uma nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/cancelamento.xml
     */
    @Override
    public MDeDownloadXmlResponse downloadCancelamento(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadCancelamento(this.getAuth().getBasicAuthorization(), chaveNFe);
    }

    /**
     * GET - Baixar o XML da última Carta de Correção Eletrônica de uma nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/carta_correcao.xml
     */
    @Override
    public MDeDownloadXmlResponse downloadUltimaCCe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadUltimaCCe(this.getAuth().getBasicAuthorization(), chaveNFe);
    }
}
