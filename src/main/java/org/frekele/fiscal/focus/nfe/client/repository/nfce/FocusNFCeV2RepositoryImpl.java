package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
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
}
