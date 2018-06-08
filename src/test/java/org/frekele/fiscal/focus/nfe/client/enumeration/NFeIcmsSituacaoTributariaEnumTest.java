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
public class NFeIcmsSituacaoTributariaEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIcmsSituacaoTributariaEnum entity = NFeIcmsSituacaoTributariaEnum.fromCode("00");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "00");
        assertEquals(entity.getDescription(), "Tributada integralmente");

        entity = NFeIcmsSituacaoTributariaEnum.fromCode("10");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("20");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("30");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("40");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("41");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("50");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("51");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("60");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("70");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("90");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("101");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("102");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("103");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("201");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("202");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("203");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("300");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("400");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("500");
        assertNotNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("900");
        assertNotNull(entity);

        entity = NFeIcmsSituacaoTributariaEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("");
        assertNull(entity);
        entity = NFeIcmsSituacaoTributariaEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIcmsSituacaoTributariaEnum> listAll = NFeIcmsSituacaoTributariaEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 21);
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_INTEGRALMENTE));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_E_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_COM_REDUCAO_BASE_CALCULO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.ISENTA));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.NAO_TRIBUTADA));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.SUSPENSAO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.DIFERIMENTO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.COBRADO_ANTERIORMENTE_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBURADA_COM_REDUCAO_BASE_CALCULO_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.OUTROS_REGIME_NORMAL));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_CREDITO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.ISENCAO_ICMS_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_CREDITO_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.ISENCAO_ICMS_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_COM_COBRANCA_ICMS_POR_ST));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.IMUNE));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.NAO_TRIBUTADA_PELO_SIMPLES_NACIONAL));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.ICMS_COBRADO_ANTERIORMENTE_POR_ST_OU_ANTECIPACAO));
        assertTrue(listAll.contains(NFeIcmsSituacaoTributariaEnum.OUTROS_REGIME_SIMPLES_NACIONAL));
    }
}
