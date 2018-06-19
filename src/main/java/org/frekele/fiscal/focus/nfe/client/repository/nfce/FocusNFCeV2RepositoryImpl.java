package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
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
        this.client = client;
        this.auth = auth;
    }

    public ResteasyClient getClient() {
        return client;
    }

    public FocusNFeAuth getAuth() {
        return auth;
    }

    public FocusNFCeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusNFCeV2ProxyClient.class);
    }

    @Override
    public NFCeAutorizarResponse autorizar(String referencia, NFCeAutorizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeAutorizarBodyRequest");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.autorizar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFCeConsultarResponse consultar(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia);
    }

    @Override
    public NFCeConsultarResponse consultarTudo(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia, 1);
    }

    @Override
    public NFCeCancelarResponse cancelar(String referencia, NFCeCancelarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeCancelarBodyRequest");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.cancelar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFCeEmailResponse enviarEmail(String referencia, NFCeEmailBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFCeEmailBodyRequest");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.enviarEmail(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFCeInutilizarResponse inutilizar(NFCeInutilizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(bodyRequest, "NFCeInutilizarBodyRequest");
        FocusNFCeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.inutilizar(this.getAuth().getAuthorization(), bodyRequest);
    }
}
