package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
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
public class MDeConsultarManifestosBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        List<MDeManifesto> manifestos = new ArrayList<>();
        manifestos.add(new MDeManifesto());

        MDeConsultarManifestosBodyResponse entity = new MDeConsultarManifestosBodyResponse();
        entity.setErro(erro);
        entity.setManifestos(manifestos);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(manifestos, entity.getManifestos());
    }
}
