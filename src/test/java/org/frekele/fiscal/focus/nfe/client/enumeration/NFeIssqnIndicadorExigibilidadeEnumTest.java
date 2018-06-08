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
public class NFeIssqnIndicadorExigibilidadeEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIssqnIndicadorExigibilidadeEnum entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Exigível");

        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("6");
        assertNotNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("7");
        assertNotNull(entity);

        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("");
        assertNull(entity);
        entity = NFeIssqnIndicadorExigibilidadeEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIssqnIndicadorExigibilidadeEnum> listAll = NFeIssqnIndicadorExigibilidadeEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 7);
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.EXIGIVEL));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.NAO_INCIDENCIA));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.ISENCAO));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.EXPORTACAO));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.IMUNIDADE));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL));
        assertTrue(listAll.contains(NFeIssqnIndicadorExigibilidadeEnum.EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO));
    }
}
