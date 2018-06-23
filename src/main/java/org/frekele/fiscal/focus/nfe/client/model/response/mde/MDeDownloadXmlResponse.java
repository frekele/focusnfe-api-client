package org.frekele.fiscal.focus.nfe.client.model.response.mde;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface MDeDownloadXmlResponse extends FocusNFeEntity {

    @HeaderParam("X-Rate-Limit-Limit")
    String getRateLimitLimit();

    @HeaderParam("X-Rate-Limit-Remaining")
    String getRateLimitRemaining();

    @HeaderParam("X-Rate-Limit-Reset")
    String getRateLimitReset();

    @Status
    Integer getStatus();

    @Body
    String getBody();

    Response getResponse();
}
