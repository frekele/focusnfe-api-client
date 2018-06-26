package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

/**
 * Filtro para adicionar Http Headers 'X-Api-Cli-Name' e 'X-Api-Cli-Version' nas Requisições RestEasy.
 *
 * @author frekele - Leandro Kersting de Freitas
 */

public class RequestHeaderInfoFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("X-Api-Cli-Name", "focusnfe-api-client");
        requestContext.getHeaders().add("X-Api-Cli-Version", FocusNFe.class.getPackage().getImplementationVersion());
    }
}
