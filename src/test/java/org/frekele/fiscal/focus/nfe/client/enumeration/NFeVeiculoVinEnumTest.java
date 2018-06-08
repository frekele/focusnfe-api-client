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
public class NFeVeiculoVinEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoVinEnum entity = NFeVeiculoVinEnum.fromCode("R");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "R");
        assertEquals(entity.getDescription(), "Remarcado");

        entity = NFeVeiculoVinEnum.fromCode("N");
        assertNotNull(entity);

        entity = NFeVeiculoVinEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoVinEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoVinEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoVinEnum> listAll = NFeVeiculoVinEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 2);
        assertTrue(listAll.contains(NFeVeiculoVinEnum.REMARCADO));
        assertTrue(listAll.contains(NFeVeiculoVinEnum.NORMAL));
    }
}
