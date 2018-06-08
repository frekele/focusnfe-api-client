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
public class NFeConsumidorFinalEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeConsumidorFinalEnum entity = NFeConsumidorFinalEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");

        entity = NFeConsumidorFinalEnum.fromCode("1");
        assertNotNull(entity);

        entity = NFeConsumidorFinalEnum.fromCode(null);
        assertNull(entity);
        entity = NFeConsumidorFinalEnum.fromCode("");
        assertNull(entity);
        entity = NFeConsumidorFinalEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeConsumidorFinalEnum> listAll = NFeConsumidorFinalEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 2);
        assertTrue(listAll.contains(NFeConsumidorFinalEnum.NORMAL));
        assertTrue(listAll.contains(NFeConsumidorFinalEnum.CONSUMIDOR_FINAL));
    }
}
