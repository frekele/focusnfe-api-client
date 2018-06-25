package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import java.net.URI;

import static org.mockito.Mockito.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class ResponseArrayJsonReplaceFilterTest {

    @Test
    public void testNewInstance() throws Exception {
        ClientRequestContext requestContext = mock(ClientRequestContext.class);
        ClientResponseContext responseContext = mock(ClientResponseContext.class);

        new ResponseArrayJsonReplaceFilter().filter(requestContext, responseContext);

        when(requestContext.getMethod()).thenReturn("GET");
        when(requestContext.getUri()).thenReturn(new URI("/v2/nfes_recebidas?cnpj=34598375834"));
        new ResponseArrayJsonReplaceFilter().filter(requestContext, responseContext);

        when(requestContext.getMethod()).thenReturn("GET");
        when(requestContext.getUri()).thenReturn(new URI("/v2/hooks?hooks=hooks"));
        new ResponseArrayJsonReplaceFilter().filter(requestContext, responseContext);
    }
}
