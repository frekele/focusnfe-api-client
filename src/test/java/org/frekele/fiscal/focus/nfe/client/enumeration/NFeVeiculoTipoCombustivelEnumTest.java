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
public class NFeVeiculoTipoCombustivelEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoTipoCombustivelEnum entity = NFeVeiculoTipoCombustivelEnum.fromCode("01");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "01");
        assertEquals(entity.getDescription(), "Álcool");

        entity = NFeVeiculoTipoCombustivelEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("16");
        assertNotNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("17");
        assertNotNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("18");
        assertNotNull(entity);

        entity = NFeVeiculoTipoCombustivelEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoTipoCombustivelEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoTipoCombustivelEnum> listAll = NFeVeiculoTipoCombustivelEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 6);
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.ALCOOL));
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.GASOLINA));
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.DIESEL));
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.ALCOOL_GASOLINA));
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.GASOLINA_ALCOOL_GNV));
        assertTrue(listAll.contains(NFeVeiculoTipoCombustivelEnum.GASOLINA_ELETRICO));
    }
}
