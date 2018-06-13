package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeEmailBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();

        NFeEmailBodyResponse entity = new NFeEmailBodyResponse();
        entity.setErro(erro);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());

        entity = NFeEmailBodyResponse.newBuilder()
            .withErro(erro)
            .build();

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
    }
}
