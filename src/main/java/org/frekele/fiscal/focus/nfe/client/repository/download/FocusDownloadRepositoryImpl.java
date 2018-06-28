package org.frekele.fiscal.focus.nfe.client.repository.download;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestHeaderInfoFilter;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para Download de Arquivos.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusDownloadRepositoryImpl implements FocusDownloadRepository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusDownloadRepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
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

    private FocusDownloadProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusDownloadProxyClient.class);
    }

    /**
     * GET - Baixar arquivo .xml informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.xml
     */
    @Override
    public DownloadFileResponse downloadXml(String path) {
        FocusNFeUtils.throwObject(path, "path");
        FocusDownloadProxyClient proxyClient = this.getProxyClient();
        //Remove .xml if exist.
        path = path.replace(".xml", "");
        return proxyClient.downloadXml(this.getAuth().getBasicAuthorization(), path);
    }

    /**
     * GET - Baixar arquivo .pdf informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.pdf
     */
    @Override
    public DownloadFileResponse downloadPdf(String path) {
        FocusNFeUtils.throwObject(path, "path");
        FocusDownloadProxyClient proxyClient = this.getProxyClient();
        //Remove .pdf if exist.
        path = path.replace(".pdf", "");
        return proxyClient.downloadPdf(this.getAuth().getBasicAuthorization(), path);
    }

    /**
     * GET - Baixar arquivo .html informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.html
     */
    @Override
    public DownloadFileResponse downloadHtml(String path) {
        FocusNFeUtils.throwObject(path, "path");
        FocusDownloadProxyClient proxyClient = this.getProxyClient();
        //Remove .html if exist.
        path = path.replace(".html", "");
        return proxyClient.downloadHtml(this.getAuth().getBasicAuthorization(), path);
    }

    /**
     * GET - Baixar arquivo .zip informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.zip
     */
    @Override
    public DownloadFileResponse downloadZip(String path) {
        FocusNFeUtils.throwObject(path, "path");
        FocusDownloadProxyClient proxyClient = this.getProxyClient();
        //Remove .zip if exist.
        path = path.replace(".zip", "");
        return proxyClient.downloadZip(this.getAuth().getBasicAuthorization(), path);
    }
}
