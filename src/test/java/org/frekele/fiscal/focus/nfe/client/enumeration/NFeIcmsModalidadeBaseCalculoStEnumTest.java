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
public class NFeIcmsModalidadeBaseCalculoStEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIcmsModalidadeBaseCalculoStEnum entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");
        assertEquals(entity.getDescription(), "Preço tabelado ou máximo sugerido");

        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("5");
        assertNotNull(entity);

        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("");
        assertNull(entity);
        entity = NFeIcmsModalidadeBaseCalculoStEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIcmsModalidadeBaseCalculoStEnum> listAll = NFeIcmsModalidadeBaseCalculoStEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 6);
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.PRECO_TABELADO_OU_MAXIMO_SUGERIDO));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.LISTA_NEGATIVA));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.LISTA_POSITIVA));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.LISTA_NEGRA));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.MARGEM_DE_VALOR_AGREGADO));
        assertTrue(listAll.contains(NFeIcmsModalidadeBaseCalculoStEnum.PAUTA));
    }
}
