package org.frekele.fiscal.focus.nfe.client.repository.download;

import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

/**
 * Proxy RestEasy para chamadas de Download de Arquivos.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
interface FocusDownloadProxyClient extends Serializable {

    /**
     * GET - Baixar arquivo .xml informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.xml
     */
    @GET
    @Path("{path}.xml")
    @Consumes({
        MediaType.TEXT_XML + ";charset=UTF-8", MediaType.APPLICATION_XML + ";charset=UTF-8"})
    DownloadFileResponse downloadXml(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .pdf informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.pdf
     */
    @GET
    @Path("{path}.pdf")
    @Consumes({"application/pdf;charset=UTF-8"})
    DownloadFileResponse downloadPdf(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .html informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.html
     */
    @GET
    @Path("{path}.html")
    @Consumes({MediaType.TEXT_HTML + ";charset=UTF-8"})
    DownloadFileResponse downloadHtml(@HeaderParam("Authorization") String authorization,
                                      @PathParam("path") String path);

    /**
     * GET - Baixar arquivo .zip informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.zip
     */
    @GET
    @Path("{path}.zip")
    @Consumes({"application/zip;charset=UTF-8"})
    DownloadFileResponse downloadZip(@HeaderParam("Authorization") String authorization,
                                     @PathParam("path") String path);
}
