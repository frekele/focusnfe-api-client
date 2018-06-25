package org.frekele.fiscal.focus.nfe.client.model.request.webhook.body;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class WebHookCriarBodyRequestTest {

    @Test
    public void testNewInstance() throws Exception {
        String cnpj = "45678765456789";
        String event = "nfe";
        String url = "http://minha.url/nfe";

        WebHookCriarBodyRequest entity = new WebHookCriarBodyRequest();
        entity.setCnpj(cnpj);
        entity.setEvent(event);
        entity.setUrl(url);

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(event, entity.getEvent());
        assertEquals(url, entity.getUrl());

        entity = WebHookCriarBodyRequest.newBuilder()
            .withCnpj(cnpj)
            .withEvent(event)
            .withUrl(url)
            .build();

        assertNotNull(entity);
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(event, entity.getEvent());
        assertEquals(url, entity.getUrl());
    }

    @Test
    public void testBeanValidation() throws Exception {
        String cnpj = "45678765456789";
        String event = "nfe";
        String url = "http://minha.url/nfe";

        WebHookCriarBodyRequest entity = new WebHookCriarBodyRequest(cnpj, event, url);
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        WebHookCriarBodyRequest entity = new WebHookCriarBodyRequest();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
