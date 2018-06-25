package org.frekele.fiscal.focus.nfe.client.model.response.webhook.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class WebHookBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        String id = "zVG8pGDp";
        String url = "http://minha.url/nfe";
        String authorization = "uhgdfdsgfjhfrw";
        String event = "nfe";
        String cnpj = "45678765456789";
        String deleted = "true";

        WebHookBodyResponse entity = new WebHookBodyResponse();
        entity.setErro(erro);
        entity.setId(id);
        entity.setUrl(url);
        entity.setAuthorization(authorization);
        entity.setEvent(event);
        entity.setCnpj(cnpj);
        entity.setDeleted(deleted);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(id, entity.getId());
        assertEquals(url, entity.getUrl());
        assertEquals(authorization, entity.getAuthorization());
        assertEquals(event, entity.getEvent());
        assertEquals(cnpj, entity.getCnpj());
        assertEquals(deleted, entity.getDeleted());
    }
}
