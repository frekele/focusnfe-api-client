package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar.NFeAutorizacao;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.NFeCCeBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.NFeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.NFeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeCCeResponse;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.nfe.response.NFeInutilizarResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
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
        this.client = client;
        this.auth = auth;
    }

    public ResteasyClient getClient() {
        return client;
    }

    public FocusNFeAuth getAuth() {
        return auth;
    }

    public FocusNFeV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusNFeV2ProxyClient.class);
    }

    @Override
    public NFeAutorizarResponse autorizar(String referencia, NFeAutorizacao bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeAutorizarBodyRequest");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.autorizar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFeConsultarResponse consultar(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia);
    }

    @Override
    public NFeConsultarResponse consultarTudo(String referencia) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getAuthorization(), referencia, 1);
    }

    @Override
    public NFeCancelarResponse cancelar(String referencia, NFeCancelarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeCancelarBodyRequest");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.cancelar(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFeCCeResponse emitirCCe(String referencia, NFeCCeBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeCCeBodyRequest");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.emitirCCe(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFeEmailResponse enviarEmail(String referencia, NFeEmailBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(referencia, "referencia");
        FocusNFeUtils.throwObject(bodyRequest, "NFeEmailBodyRequest");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.enviarEmail(this.getAuth().getAuthorization(), referencia, bodyRequest);
    }

    @Override
    public NFeInutilizarResponse inutilizar(NFeInutilizarBodyRequest bodyRequest) {
        FocusNFeUtils.throwObject(bodyRequest, "NFeInutilizarBodyRequest");
        FocusNFeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.inutilizar(this.getAuth().getAuthorization(), bodyRequest);
    }
}
