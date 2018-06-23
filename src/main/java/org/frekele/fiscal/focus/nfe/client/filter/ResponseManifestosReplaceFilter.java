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

    private static final String CONSULTAR_MANIFESTOS_REL_PATH = "/v2/nfes_recebidas?cnpj=";

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        if (requestContext.getUri().getSchemeSpecificPart().contains(CONSULTAR_MANIFESTOS_REL_PATH)) {
            FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);
            this.getLogger().debug("replaceResponseBodyJsonArrayToJsonObject --> [.....] to { arrayValues : [.....] }");
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
