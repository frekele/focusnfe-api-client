package org.frekele.fiscal.focus.nfe.client.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

/**
 * @author frekele - Leandro Kersting de Freitas
 */

public class RequestLoggingFilter implements ClientRequestFilter {

    private Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName());

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("------------------------------------------------------------------");
        sb.append("\n");
        sb.append("--> Request Filter:");
        sb.append("\n");
        sb.append("--> Request - Method = " + requestContext.getMethod());
        sb.append("\n");
        sb.append("--> Request - Uri = " + requestContext.getUri());
        sb.append("\n");
        if (requestContext.hasEntity()) {
            sb.append("--> Request - EntityClass = " + requestContext.getEntityClass());
            sb.append("\n");
            String body = this.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestContext.getEntity());
            sb.append(body);
            sb.append("\n");
        }
        sb.append("------------------------------------------------------------------");
        this.getLogger().info(sb.toString());
    }

    public Logger getLogger() {
        return logger;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
