package org.frekele.fiscal.focus.nfe.client.filter;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class ResponseLoggingFilterTest {

    @Test
    public void testNewInstance() throws Exception {
        ClientRequestContext requestContext = mock(ClientRequestContext.class);
        ClientResponseContext responseContext = mock(ClientResponseContext.class);

        new ResponseLoggingFilter().filter(requestContext, responseContext);

        String content = "{\"codigo\":\"123\",\"mensagem\":\"teste\"}";
        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream(content.getBytes("UTF-8")));
        new ResponseLoggingFilter().filter(requestContext, responseContext);

        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream(content.getBytes("UTF-8")));
        when(responseContext.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"));
        new ResponseLoggingFilter().filter(requestContext, responseContext);

        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream(content.getBytes("UTF-8")));
        when(responseContext.getMediaType()).thenReturn(new MediaType("application", "pdf"));
        new ResponseLoggingFilter().filter(requestContext, responseContext);

        when(responseContext.hasEntity()).thenReturn(true);
        when(responseContext.getEntityStream()).thenReturn(new ByteArrayInputStream(content.getBytes("UTF-8")));
        when(responseContext.getMediaType()).thenReturn(new MediaType("application", "zip"));
        new ResponseLoggingFilter().filter(requestContext, responseContext);
    }
}
