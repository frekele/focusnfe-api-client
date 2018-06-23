package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
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
    public MDeConsultarManifestosResponse consultarManifestos(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusMDeV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarManifestos(this.getAuth().getAuthorization(), cnpj);
    }
}
