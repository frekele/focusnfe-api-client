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
public class NFeRegimeTributarioEmitenteEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeRegimeTributarioEmitenteEnum entity = NFeRegimeTributarioEmitenteEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Simples Nacional");

        entity = NFeRegimeTributarioEmitenteEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeRegimeTributarioEmitenteEnum.fromCode("3");
        assertNotNull(entity);

        entity = NFeRegimeTributarioEmitenteEnum.fromCode(null);
        assertNull(entity);
        entity = NFeRegimeTributarioEmitenteEnum.fromCode("");
        assertNull(entity);
        entity = NFeRegimeTributarioEmitenteEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeRegimeTributarioEmitenteEnum> listAll = NFeRegimeTributarioEmitenteEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeRegimeTributarioEmitenteEnum.SIMPLES_NACIONAL));
        assertTrue(listAll.contains(NFeRegimeTributarioEmitenteEnum.SIMPLES_NACIONAL_EXCETO_SUBLIMITE_RECEITA_BRUTA));
        assertTrue(listAll.contains(NFeRegimeTributarioEmitenteEnum.REGIME_NORMAL));
    }
}
