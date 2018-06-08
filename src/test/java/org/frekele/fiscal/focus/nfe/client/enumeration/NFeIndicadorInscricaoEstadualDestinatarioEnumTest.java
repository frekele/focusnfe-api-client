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
public class NFeIndicadorInscricaoEstadualDestinatarioEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIndicadorInscricaoEstadualDestinatarioEnum entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Contribuinte ICMS (informar a IE do destinatário)");

        entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode("9");
        assertNotNull(entity);

        entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode("");
        assertNull(entity);
        entity = NFeIndicadorInscricaoEstadualDestinatarioEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIndicadorInscricaoEstadualDestinatarioEnum> listAll = NFeIndicadorInscricaoEstadualDestinatarioEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 3);
        assertTrue(listAll.contains(NFeIndicadorInscricaoEstadualDestinatarioEnum.CONTRIBUINTE));
        assertTrue(listAll.contains(NFeIndicadorInscricaoEstadualDestinatarioEnum.ISENTO));
        assertTrue(listAll.contains(NFeIndicadorInscricaoEstadualDestinatarioEnum.NAO_CONTRIBUINTE));
    }
}
