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
public class NFeLocalDestinoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeLocalDestinoEnum entity = NFeLocalDestinoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Operação interna");

        entity = NFeLocalDestinoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeLocalDestinoEnum.fromCode("3");
        assertNotNull(entity);

        entity = NFeLocalDestinoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeLocalDestinoEnum.fromCode("");
        assertNull(entity);
        entity = NFeLocalDestinoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeLocalDestinoEnum> listAll = NFeLocalDestinoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeLocalDestinoEnum.OPERACAO_INTERNA));
        assertTrue(listAll.contains(NFeLocalDestinoEnum.OPERACAO_INTERESTADUAL));
        assertTrue(listAll.contains(NFeLocalDestinoEnum.OPERACAO_EXTERIOR));
    }
}
