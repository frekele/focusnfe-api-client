package org.frekele.fiscal.focus.nfe.client.model.response.ncm.body;

import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.ncm.NFeNcm;
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
public class NcmsBodyResponseTest {

    @Test
    public void testNewInstance() throws Exception {
        NFeErro erro = new NFeErro();
        List<NFeNcm> ncms = new ArrayList<>();
        ncms.add(new NFeNcm());

        NcmsBodyResponse entity = new NcmsBodyResponse();
        entity.setErro(erro);
        entity.setNcms(ncms);

        assertNotNull(entity);
        assertEquals(erro, entity.getErro());
        assertEquals(ncms, entity.getNcms());
    }
}
