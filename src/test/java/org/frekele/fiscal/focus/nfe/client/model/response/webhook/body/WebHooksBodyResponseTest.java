package org.frekele.fiscal.focus.nfe.client.model.response.webhook.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class WebHooksBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        List<WebHookBodyResponse> webhooks = new ArrayList<>();
        webhooks.add(new WebHookBodyResponse());

        WebHooksBodyResponse entity = new WebHooksBodyResponse();
        entity.setErro(erro);
        entity.setWebhooks(webhooks);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(webhooks, entity.getWebhooks());
    }
}
