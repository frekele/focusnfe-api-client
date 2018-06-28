package org.frekele.fiscal.focus.nfe.client.model.response.download;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * ResponseObject Download de Arquivo.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface DownloadFileResponse extends FocusNFeEntity {

    /**
     * Content-Type do arquivo.
     */
    @HeaderParam("Content-Type")
    String getContentType();

    /**
     * Tempo de execução.
     */
    @HeaderParam("X-Runtime")
    String getRuntime();

    /**
     * Status Http da Chamada.
     */
    @Status
    Integer getStatus();

    /**
     * Corpo da Resposta.
     */
    @Body
    InputStream getBody();

    /**
     * Corpo da Resposta em String.
     */
    @Body
    String getBodyString();

    /**
     * Response Completo.
     */
    Response getResponse();
}
