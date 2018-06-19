package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFCeEmailBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();

        NFCeEmailBodyResponse entity = new NFCeEmailBodyResponse();
        entity.setErro(erro);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
    }
}
