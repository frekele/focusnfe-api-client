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
public class NFeViaTransporteEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeViaTransporteEnum entity = NFeViaTransporteEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Marítima");

        entity = NFeViaTransporteEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("6");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("7");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("8");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("9");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("10");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("11");
        assertNotNull(entity);
        entity = NFeViaTransporteEnum.fromCode("12");
        assertNotNull(entity);

        entity = NFeViaTransporteEnum.fromCode(null);
        assertNull(entity);
        entity = NFeViaTransporteEnum.fromCode("");
        assertNull(entity);
        entity = NFeViaTransporteEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeViaTransporteEnum> listAll = NFeViaTransporteEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 12);
        assertTrue(listAll.contains(NFeViaTransporteEnum.MARITIMA));
        assertTrue(listAll.contains(NFeViaTransporteEnum.FLUVIAL));
        assertTrue(listAll.contains(NFeViaTransporteEnum.LACUSTRE));
        assertTrue(listAll.contains(NFeViaTransporteEnum.AEREA));
        assertTrue(listAll.contains(NFeViaTransporteEnum.POSTAL));
        assertTrue(listAll.contains(NFeViaTransporteEnum.FERROVIARIA));
        assertTrue(listAll.contains(NFeViaTransporteEnum.RODOVIARIA));
        assertTrue(listAll.contains(NFeViaTransporteEnum.CONDUTO_REDES_TRANSMISSAO));
        assertTrue(listAll.contains(NFeViaTransporteEnum.MEIOS_PROPRIOS));
        assertTrue(listAll.contains(NFeViaTransporteEnum.ENTRADA_SAIDA_FICTA));
        assertTrue(listAll.contains(NFeViaTransporteEnum.COURIER));
        assertTrue(listAll.contains(NFeViaTransporteEnum.HANDCARRY));
    }
}
