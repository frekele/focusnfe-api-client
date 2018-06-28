package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

/**
 * Filtro para adicionar Http Headers ['X-Api-Cli-Name', 'X-Api-Cli-Version', 'X-Api-Cli-Lang' e 'X-Api-Cli-OS'] nas Requisições RestEasy.
 *
 * @author frekele - Leandro Kersting de Freitas
 */

public class RequestHeaderInfoFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) {
        requestContext.getHeaders().add("X-Api-Cli-Name", "focusnfe-api-client");
        //Example: [1.0.2].
        requestContext.getHeaders().add("X-Api-Cli-Version", FocusNFe.class.getPackage().getImplementationVersion());
        //Example: [Java - 1.8.0_172 - Oracle Corporation].
        requestContext.getHeaders().add("X-Api-Cli-Lang", "Java - " + System.getProperty("java.version") + " - " + System.getProperty("java.vendor"));
        //Example: [Windows 10 - amd64].
        requestContext.getHeaders().add("X-Api-Cli-OS", System.getProperty("os.name") + " - " + System.getProperty("os.arch"));
    }
}
