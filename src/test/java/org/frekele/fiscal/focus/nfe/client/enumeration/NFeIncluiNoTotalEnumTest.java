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
public class NFeIncluiNoTotalEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIncluiNoTotalEnum entity = NFeIncluiNoTotalEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");
        assertEquals(entity.getDescription(), "Não");

        entity = NFeIncluiNoTotalEnum.fromCode("1");
        assertNotNull(entity);

        entity = NFeIncluiNoTotalEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIncluiNoTotalEnum.fromCode("");
        assertNull(entity);
        entity = NFeIncluiNoTotalEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIncluiNoTotalEnum> listAll = NFeIncluiNoTotalEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 2);
        assertTrue(listAll.contains(NFeIncluiNoTotalEnum.NAO));
        assertTrue(listAll.contains(NFeIncluiNoTotalEnum.SIM));
    }
}
