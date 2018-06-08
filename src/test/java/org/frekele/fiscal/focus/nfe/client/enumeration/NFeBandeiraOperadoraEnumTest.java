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
public class NFeBandeiraOperadoraEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeBandeiraOperadoraEnum entity = NFeBandeiraOperadoraEnum.fromCode("01");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "01");

        entity = NFeBandeiraOperadoraEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("04");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("05");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("06");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("07");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("08");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("09");
        assertNotNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("99");
        assertNotNull(entity);

        entity = NFeBandeiraOperadoraEnum.fromCode(null);
        assertNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("");
        assertNull(entity);
        entity = NFeBandeiraOperadoraEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeBandeiraOperadoraEnum> listAll = NFeBandeiraOperadoraEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 10);
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.VISA));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.MASTERCARD));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.AMERICAN_EXPRESS));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.SOROCRED));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.DINERS_CLUB));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.ELO));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.HIPERCARD));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.AURA));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.CABAL));
        assertTrue(listAll.contains(NFeBandeiraOperadoraEnum.OUTROS));
    }
}
