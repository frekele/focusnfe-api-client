package org.frekele.fiscal.focus.nfe.client.model.response.nfce;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeConsultarBodyResponse;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

/**
 * ResponseObject Consultar NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface NFCeConsultarResponse extends FocusNFeEntity {

    /**
     * Número de créditos para o período atual.
     */
    @HeaderParam("X-Rate-Limit-Limit")
    String getRateLimitLimit();

    /**
     * Número de créditos que restam no período atual.
     */
    @HeaderParam("X-Rate-Limit-Remaining")
    String getRateLimitRemaining();

    /**
     * Número de segundos até que seja reinicializado o contador de créditos.
     */
    @HeaderParam("X-Rate-Limit-Reset")
    String getRateLimitReset();

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
    NFCeConsultarBodyResponse getBody();

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
