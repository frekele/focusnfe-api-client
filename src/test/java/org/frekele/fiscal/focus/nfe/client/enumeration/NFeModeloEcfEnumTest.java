package org.frekele.fiscal.focus.nfe.client.enumeration;

import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeModeloEcfEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeModeloEcfEnum entity = NFeModeloEcfEnum.fromCode("2B");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "2B");

        entity = NFeModeloEcfEnum.fromCode("2C");
        assertNotNull(entity);
        assertEquals(entity.getDescription(), "Cupom Fiscal PDV");
        entity = NFeModeloEcfEnum.fromCode("2D");
        assertNotNull(entity);

        entity = NFeModeloEcfEnum.fromCode(null);
        assertNull(entity);
        entity = NFeModeloEcfEnum.fromCode("");
        assertNull(entity);
        entity = NFeModeloEcfEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeModeloEcfEnum> listAll = NFeModeloEcfEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeModeloEcfEnum.CUPOM_FISCAL_EMITIDO_POR_MAQUINA_REGISTRADORA_NAO_ECF));
        assertTrue(listAll.contains(NFeModeloEcfEnum.CUPOM_FISCAL_PDV));
        assertTrue(listAll.contains(NFeModeloEcfEnum.CUPOM_FISCAL_EMITIDO_ECF));
    }
}
