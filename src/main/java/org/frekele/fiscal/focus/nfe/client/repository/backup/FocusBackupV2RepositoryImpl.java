package org.frekele.fiscal.focus.nfe.client.repository.backup;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestHeaderInfoFilter;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseArrayJsonReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.response.backup.BackupConsultaResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API V2 Backups.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusBackupV2RepositoryImpl implements FocusBackupV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusBackupV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(RequestHeaderInfoFilter.class)
            .register(ResponseArrayJsonReplaceFilter.class);
        this.auth = auth;
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusBackupV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusBackupV2ProxyClient.class);
    }

    /**
     * GET - Consultar os Backups disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/backups/CNPJ.json
     */
    @Override
    public BackupConsultaResponse consultarTodos(String cnpj) {
        FocusNFeUtils.throwObject(cnpj, "cnpj");
        FocusBackupV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultarTodos(this.getAuth().getBasicAuthorization(), cnpj);
    }
}
