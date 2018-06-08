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
public class NFeTipoDocumentoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeTipoDocumentoEnum entity = NFeTipoDocumentoEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");
        assertEquals(entity.getDescription(), "Nota Fiscal de Entrada");

        entity = NFeTipoDocumentoEnum.fromCode("1");
        assertNotNull(entity);

        entity = NFeTipoDocumentoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeTipoDocumentoEnum.fromCode("");
        assertNull(entity);
        entity = NFeTipoDocumentoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeTipoDocumentoEnum> listAll = NFeTipoDocumentoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 2);
        assertTrue(listAll.contains(NFeTipoDocumentoEnum.NOTA_FISCAL_ENTRADA));
        assertTrue(listAll.contains(NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA));
    }
}
