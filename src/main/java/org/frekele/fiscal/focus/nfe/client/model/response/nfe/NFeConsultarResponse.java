package org.frekele.fiscal.focus.nfe.client.model.response.nfe;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeConsultarBodyResponse;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface NFeConsultarResponse extends FocusNFeEntity {

    @HeaderParam("X-Rate-Limit-Limit")
    Integer getRateLimitLimit();

    @HeaderParam("X-Rate-Limit-Remaining")
    Integer getRateLimitRemaining();

    @HeaderParam("X-Rate-Limit-Reset")
    Integer getRateLimitReset();

    @Status
    Integer getStatus();

    @Body
    NFeConsultarBodyResponse getBody();

    Response getResponse();
}
