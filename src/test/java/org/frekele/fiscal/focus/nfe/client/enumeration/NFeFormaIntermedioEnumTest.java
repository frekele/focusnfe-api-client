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
public class NFeFormaIntermedioEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeFormaIntermedioEnum entity = NFeFormaIntermedioEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");

        entity = NFeFormaIntermedioEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeFormaIntermedioEnum.fromCode("3");
        assertNotNull(entity);

        entity = NFeFormaIntermedioEnum.fromCode(null);
        assertNull(entity);
        entity = NFeFormaIntermedioEnum.fromCode("");
        assertNull(entity);
        entity = NFeFormaIntermedioEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeFormaIntermedioEnum> listAll = NFeFormaIntermedioEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeFormaIntermedioEnum.IMPORTACAO_POR_CONTA_PROPRIA));
        assertTrue(listAll.contains(NFeFormaIntermedioEnum.IMPORTACAO_POR_CONTA_E_ORDEM));
        assertTrue(listAll.contains(NFeFormaIntermedioEnum.IMPORTACAO_POR_ENCOMENDA));
    }
}
