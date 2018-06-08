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
public class NFeVeiculoCondicaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoCondicaoEnum entity = NFeVeiculoCondicaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Acabado");

        entity = NFeVeiculoCondicaoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeVeiculoCondicaoEnum.fromCode("3");
        assertNotNull(entity);

        entity = NFeVeiculoCondicaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoCondicaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoCondicaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoCondicaoEnum> listAll = NFeVeiculoCondicaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeVeiculoCondicaoEnum.ACABADO));
        assertTrue(listAll.contains(NFeVeiculoCondicaoEnum.INACABADO));
        assertTrue(listAll.contains(NFeVeiculoCondicaoEnum.SEMI_ACABADO));
    }
}
