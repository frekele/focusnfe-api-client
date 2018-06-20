package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeConsultarUltimoManifestoBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        MDeManifesto manifesto = new MDeManifesto();

        MDeConsultarUltimoManifestoBodyResponse entity = new MDeConsultarUltimoManifestoBodyResponse();
        entity.setErro(erro);
        entity.setManifesto(manifesto);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(manifesto, entity.getManifesto());
    }
}
