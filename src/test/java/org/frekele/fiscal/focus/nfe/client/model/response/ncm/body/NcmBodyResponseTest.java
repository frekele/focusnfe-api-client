package org.frekele.fiscal.focus.nfe.client.model.response.ncm.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.ncm.NFeNcm;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NcmBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        NFeNcm ncm = new NFeNcm();

        NcmBodyResponse entity = new NcmBodyResponse();
        entity.setErro(erro);
        entity.setNcm(ncm);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(ncm, entity.getNcm());
    }
}
