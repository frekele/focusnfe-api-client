package org.frekele.fiscal.focus.nfe.client.filter;

import com.fasterxml.jackson.databind.JsonNode;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

/**
 * Filtro de Logging para as Respostas RestEasy.
 *
 * @author frekele - Leandro Kersting de Freitas
 */

public class ResponseLoggingFilter implements ClientResponseFilter {

    private Logger logger = Logger.getLogger(ResponseLoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        if (this.getLogger().isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("------------------------------------------------------------------");
            sb.append("\n");
            sb.append("<-- Response Filter:");
            sb.append("\n");
            sb.append("<-- Response - Method = " + requestContext.getMethod());
            sb.append("\n");
            sb.append("<-- Response - Uri = " + requestContext.getUri());
            sb.append("\n");
            sb.append("<-- Response - Status = " + responseContext.getStatus());
            sb.append("\n");
            if (responseContext.hasEntity()) {
                String body = FocusNFeUtils.responseBodyToString(responseContext);
                if (body != null && !body.trim().isEmpty()) {
                    if (responseContext.getMediaType() != null && responseContext.getMediaType().getSubtype().equals("json")) {
                        JsonNode jsonNode = FocusNFeUtils.parseJsonToJsonNode(body);
                        body = FocusNFeUtils.parseJsonToString(jsonNode, true);
                    }
                    sb.append(body);
                    sb.append("\n");
                }
            }
            sb.append("------------------------------------------------------------------");
            this.getLogger().debug(sb.toString());
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
