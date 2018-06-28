package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

/**
 * Filtro que altera a resposta da consulta de um Array Json para Objeto Json, ou seja, 'de [] para { arrayValues : [] }'.
 * '/v2/nfes_recebidas?cnpj=CNPJ'.
 *
 * @author frekele - Leandro Kersting de Freitas
 */

public class ResponseArrayJsonReplaceFilter implements ClientResponseFilter {

    private Logger logger = Logger.getLogger(ResponseArrayJsonReplaceFilter.class.getName());

    private static final String CONSULTAR_MANIFESTOS_REL_PATH = "/v2/nfes_recebidas?cnpj=";

    private static final String CONSULTAR_WEB_HOOKS_REL_PATH = "/v2/hooks?hooks=hooks";

    private static final String CONSULTAR_NCM_REL_PATH = "/v2/ncms";

    private static final String CONSULTAR_BACKUPS_REL_PATH = "/v2/backups/";

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        if (requestContext.getMethod() != null && requestContext.getUri() != null && requestContext.getUri().getSchemeSpecificPart() != null) {
            String method = requestContext.getMethod();
            String relativePath = requestContext.getUri().getSchemeSpecificPart();
            if ("GET".equalsIgnoreCase(method)) {
                if (relativePath.contains(CONSULTAR_MANIFESTOS_REL_PATH) ||
                    relativePath.contains(CONSULTAR_WEB_HOOKS_REL_PATH) ||
                    relativePath.contains(CONSULTAR_NCM_REL_PATH) ||
                    relativePath.contains(CONSULTAR_BACKUPS_REL_PATH)) {
                    FocusNFeUtils.replaceResponseBodyJsonArrayToJsonObject(responseContext);
                    this.getLogger().debug("replaceResponseBodyJsonArrayToJsonObject --> [.....] to { arrayValues : [.....] }");
                }
            }
        }
    }

    public Logger getLogger() {
        return logger;
    }
}
