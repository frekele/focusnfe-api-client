package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.jboss.resteasy.core.Headers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.ws.rs.client.ClientRequestContext;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class RequestHeaderInfoFilterTest {

    @Test
    public void testNewInstance() throws Exception {
        ClientRequestContext requestContext = mock(ClientRequestContext.class);

        Headers headers = new Headers<>();
        when(requestContext.getHeaders()).thenReturn(headers);
        new RequestHeaderInfoFilter().filter(requestContext);
        assertEquals(headers.getFirst("X-Api-Cli-Name"), "focusnfe-api-client");
    }
}
