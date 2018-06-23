package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

/**
 * @author frekele - Leandro Kersting de Freitas
 */

public class ResponseManifestosReplaceFilter implements ClientResponseFilter {

    private Logger logger = Logger.getLogger(ResponseManifestosReplaceFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        if (requestContext.getUri() != null && requestContext.getUri().getSchemeSpecificPart() != null &&
            requestContext.getUri().getSchemeSpecificPart().contains("/v2/nfes_recebidas?cnpj=")) {
            FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);
            this.getLogger().debug("replaceResponseBodyJsonArrayToJsonObject --> [.....] to { arrayValues : [.....] }");
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
