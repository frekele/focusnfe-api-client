package org.frekele.fiscal.focus.nfe.client.model.entities.manifesto;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class MDeManifestoTest {

    @Test
    public void testNewInstance() throws Exception {
        String nve = "FR3476";

        MDeManifesto entity = new MDeManifesto();
        //entity.setNve(nve);

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());

        entity = MDeManifesto.newBuilder()
            //.withNve(nve)
            .build();

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());
    }
}
