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
public class NFeIcmsModalidadeBaseCalculoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIcmsModalidadeBaseCalculoEnum entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");

        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("3");
        assertNotNull(entity);

        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("");
        assertNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIcmsModalidadeBaseCalculoEnum> listAll = NFeIcmsModalidadeBaseCalculoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 4);
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoEnum.MARGEM_DE_VALOR_AGREGADO));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoEnum.PAUTA));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoEnum.PRECO_TABELADO_MAXIMO));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoEnum.VALOR_DA_OPERACAO));
    }
}
