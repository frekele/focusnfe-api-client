package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.model.request.mde.MDeManifestarBodyRequest;
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
        this.client = client;
        this.auth = auth;
    }

    public ResteasyClient getClient() {
        return client;
    }

    public FocusNFeAuth getAuth() {
        return auth;
    }

    public FocusMDeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusMDeV2ProxyClient.class);
    }

    @Override
    public MDeManifestarResponse manifestar(String chaveNFe, MDeManifestarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusNFeUtils.throwObject(bodyRequest, "MDeManifestarBodyRequest");
        FocusNFeUtils.throwBeanValidation(bodyRequest);
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.manifestar(this.getAuth().getAuthorization(), chaveNFe, bodyRequest);
    }

    @Override
    public MDeConsultarManifestosResponse consultarManifestos(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestos(this.getAuth().getAuthorization(), cnpj);
    }

    @Override
    public MDeConsultarManifestosResponse consultarManifestos(String cnpj, Integer versao) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusNFeUtils.throwObject(versao, "versao");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosVersao(this.getAuth().getAuthorization(), cnpj, versao);
    }

    @Override
    public MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosPendente(this.getAuth().getAuthorization(), cnpj, "true");
    }

    @Override
    public MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj, Integer versao) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusNFeUtils.throwObject(versao, "versao");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestosVersaoPendente(this.getAuth().getAuthorization(), cnpj, versao, "true");
    }

    @Override
    public MDeConsultarUltimoManifestoResponse consultarUltimoManifesto(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarUltimoManifesto(this.getAuth().getAuthorization(), chaveNFe);
    }

    @Override
    public MDeConsultarNFeResponse consultarNFe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarNFe(this.getAuth().getAuthorization(), chaveNFe);
    }

    @Override
    public MDeConsultarNFeResponse consultarNFeCompleta(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarNFe(this.getAuth().getAuthorization(), chaveNFe, 1);
    }

    @Override
    public MDeDownloadXmlResponse downloadNFe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadNFe(this.getAuth().getAuthorization(), chaveNFe);
    }

    @Override
    public MDeDownloadXmlResponse downloadCancelamento(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadCancelamento(this.getAuth().getAuthorization(), chaveNFe);
    }

    @Override
    public MDeDownloadXmlResponse downloadUltimaCCe(String chaveNFe) {
        FocusNFeUtils.throwObject(chaveNFe, "chaveNFe");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.downloadUltimaCCe(this.getAuth().getAuthorization(), chaveNFe);
    }
}
