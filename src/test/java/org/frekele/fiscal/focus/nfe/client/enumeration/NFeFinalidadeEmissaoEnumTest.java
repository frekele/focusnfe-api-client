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
public class NFeFinalidadeEmissaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeFinalidadeEmissaoEnum entity = NFeFinalidadeEmissaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");

        entity = NFeFinalidadeEmissaoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeFinalidadeEmissaoEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeFinalidadeEmissaoEnum.fromCode("4");
        assertNotNull(entity);

        entity = NFeFinalidadeEmissaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeFinalidadeEmissaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeFinalidadeEmissaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeFinalidadeEmissaoEnum> listAll = NFeFinalidadeEmissaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 4);
        assertTrue(listAll.contains(NFeFinalidadeEmissaoEnum.NOTA_NORMAL));
        assertTrue(listAll.contains(NFeFinalidadeEmissaoEnum.NOTA_COMPLEMENTAR));
        assertTrue(listAll.contains(NFeFinalidadeEmissaoEnum.NOTA_DE_AJUSTE));
        assertTrue(listAll.contains(NFeFinalidadeEmissaoEnum.DEVOLUCAO_MERCADORIA));
    }
}
