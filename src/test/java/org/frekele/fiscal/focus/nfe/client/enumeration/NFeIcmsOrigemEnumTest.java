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
public class NFeIcmsOrigemEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIcmsOrigemEnum entity = NFeIcmsOrigemEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");

        entity = NFeIcmsOrigemEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("6");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("7");
        assertNotNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("8");
        assertNotNull(entity);

        entity = NFeIcmsOrigemEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("");
        assertNull(entity);
        entity = NFeIcmsOrigemEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIcmsOrigemEnum> listAll = NFeIcmsOrigemEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 9);
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.NACIONAL));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.ESTRANGEIRO_IMPORTACAO_DIRETA));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.ESTRANGEIRO_ADQUIRIDO_NO_MERCADO_INTERIOR));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.NACIONAL_COM_MAIS_DE_40_PORCENTO_CONTEUDO_ESTRANGEIRO));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.NACIONAL_PRODUZIDO_ATRAVEZ_PROCESSO_PRODUTIVO_BASICO));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.NACIONAL_COM_MENOS_DE_40_PORCENTO_CONTEUDO_ESTRANGEIRO));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.ESTRANGEIRO_IMPORTACAO_DIRETA_SEM_PRODUTO_NACIONAL_SIMILAR));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.ESTRANGEIRO_ADQUIRIDO_NO_MERCADO_INTERIOR_SEM_PRODUTO_NACIONAL_SIMILAR));
        assertTrue(listAll.contains(NFeIcmsOrigemEnum.NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_70_PORCENTO));
    }
}
