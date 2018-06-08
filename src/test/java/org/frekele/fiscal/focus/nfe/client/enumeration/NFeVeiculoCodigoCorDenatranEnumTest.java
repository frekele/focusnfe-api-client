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
public class NFeVeiculoCodigoCorDenatranEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoCodigoCorDenatranEnum entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("01");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "01");
        assertEquals(entity.getDescription(), "Amarelo");

        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("04");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("05");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("06");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("07");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("08");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("09");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("10");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("11");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("12");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("13");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("14");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("15");
        assertNotNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("16");
        assertNotNull(entity);

        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoCodigoCorDenatranEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoCodigoCorDenatranEnum> listAll = NFeVeiculoCodigoCorDenatranEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 16);
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.AMARELO));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.AZUL));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.BEGE));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.BRANCA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.CINZA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.DOURADA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.GRENA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.LARANJA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.MARROM));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.PRATA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.PRETA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.ROSA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.ROXA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.VERDE));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.VERMELHA));
        assertTrue(listAll.contains(NFeVeiculoCodigoCorDenatranEnum.FANTASIA));
    }
}
