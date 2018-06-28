package org.frekele.fiscal.focus.nfe.client.repository.download;

import org.frekele.fiscal.focus.nfe.client.core.FocusMediaType;
import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas de Download de Arquivos.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/")
@Produces({FocusMediaType.APPLICATION_JSON_CHARSET_UTF8})
@Consumes({FocusMediaType.APPLICATION_JSON_CHARSET_UTF8})
interface FocusDownloadProxyClient extends Serializable {

    /**
     * GET - Baixar arquivo .xml informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.xml
     */
    @GET
    @Path("{path}.xml")
    @Consumes({
        FocusMediaType.TEXT_XML, FocusMediaType.TEXT_XML_CHARSET_UTF8,
        FocusMediaType.APPLICATION_XML, FocusMediaType.APPLICATION_XML_CHARSET_UTF8})
    DownloadFileResponse downloadXml(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .pdf informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.pdf
     */
    @GET
    @Path("{path}.pdf")
    @Consumes({FocusMediaType.APPLICATION_PDF, FocusMediaType.APPLICATION_PDF_CHARSET_UTF8})
    DownloadFileResponse downloadPdf(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .html informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.html
     */
    @GET
    @Path("{path}.html")
    @Consumes({FocusMediaType.TEXT_HTML, FocusMediaType.TEXT_HTML_CHARSET_UTF8})
    DownloadFileResponse downloadHtml(@HeaderParam("Authorization") String authorization,
                                      @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .zip informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.zip
     */
    @GET
    @Path("{path}.zip")
    @Consumes({FocusMediaType.APPLICATION_ZIP, FocusMediaType.APPLICATION_ZIP_CHARSET_UTF8})
    DownloadFileResponse downloadZip(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);
}
