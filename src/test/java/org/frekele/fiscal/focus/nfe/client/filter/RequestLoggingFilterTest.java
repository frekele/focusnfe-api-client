package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.core.MediaType;

import static org.mockito.Mockito.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class RequestLoggingFilterTest {

    @Test
    public void testNewInstance() throws Exception {
        ClientRequestContext requestContext = mock(ClientRequestContext.class);

        new RequestLoggingFilter().filter(requestContext);

        String content = "{\"codigo\":\"123\",\"mensagem\":\"teste\"}";
        when(requestContext.hasEntity()).thenReturn(true);
        when(requestContext.getEntity()).thenReturn(content);
        new RequestLoggingFilter().filter(requestContext);

        when(requestContext.hasEntity()).thenReturn(true);
        when(requestContext.getEntity()).thenReturn(content);
        when(requestContext.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"));
        new RequestLoggingFilter().filter(requestContext);
    }
}
