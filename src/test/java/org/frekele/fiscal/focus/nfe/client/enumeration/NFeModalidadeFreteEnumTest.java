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
public class NFeModalidadeFreteEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeModalidadeFreteEnum entity = NFeModalidadeFreteEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");
        assertEquals(entity.getDescription(), "Por conta do emitente");

        entity = NFeModalidadeFreteEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("9");
        assertNotNull(entity);

        entity = NFeModalidadeFreteEnum.fromCode(null);
        assertNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("");
        assertNull(entity);
        entity = NFeModalidadeFreteEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeModalidadeFreteEnum> listAll = NFeModalidadeFreteEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 6);
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.POR_CONTA_EMITENTE));
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.POR_CONTA_DESTINATARIO));
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.POR_CONTA_TERCEIROS));
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.TRANSPORTE_PROPRIO_POR_CONTA_REMETENTE));
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.TRANSPORTE_PROPRIO_POR_CONTA_DESTINATARIO));
        assertTrue(listAll.contains(NFeModalidadeFreteEnum.SEM_FRETE));
    }
}
