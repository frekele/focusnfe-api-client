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
public class NFeIpiSituacaoTributariaEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIpiSituacaoTributariaEnum entity = NFeIpiSituacaoTributariaEnum.fromCode("00");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "00");
        assertEquals(entity.getDescription(), "Entrada com recuperação de crédito");

        entity = NFeIpiSituacaoTributariaEnum.fromCode("01");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("04");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("05");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("49");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("50");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("51");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("52");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("53");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("54");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("55");
        assertNotNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("99");
        assertNotNull(entity);

        entity = NFeIpiSituacaoTributariaEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("");
        assertNull(entity);
        entity = NFeIpiSituacaoTributariaEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIpiSituacaoTributariaEnum> listAll = NFeIpiSituacaoTributariaEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 14);
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_COM_RECUPERACAO_DE_CREDITO));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_TRIBUTADA_COM_ALIQUODTA_ZERO));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_ISENTA));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_NAO_TRIBUTADA));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_IMUNE));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.ENTRADA_COM_SUSPENSAO));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.OUTRAS_ENTRADAS));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_TRIBUTADA));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_ISENTA));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_NAO_TRIBUTADA));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_IMUNE));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.SAIDA_COM_SUSPENSAO));
        assertTrue(listAll.contains(NFeIpiSituacaoTributariaEnum.OUTRAS_SAIDAS));
    }
}
