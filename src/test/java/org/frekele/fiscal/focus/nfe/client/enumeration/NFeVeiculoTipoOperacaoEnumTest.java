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
public class NFeVeiculoTipoOperacaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoTipoOperacaoEnum entity = NFeVeiculoTipoOperacaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");
        assertEquals(entity.getDescription(), "Venda concessionária");

        entity = NFeVeiculoTipoOperacaoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeVeiculoTipoOperacaoEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeVeiculoTipoOperacaoEnum.fromCode("0");
        assertNotNull(entity);

        entity = NFeVeiculoTipoOperacaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoTipoOperacaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoTipoOperacaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoTipoOperacaoEnum> listAll = NFeVeiculoTipoOperacaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 4);
        assertTrue(listAll.contains(NFeVeiculoTipoOperacaoEnum.VENDA_CONCESSIONARIA));
        assertTrue(listAll.contains(NFeVeiculoTipoOperacaoEnum.FATURAMENTO_DIRETO));
        assertTrue(listAll.contains(NFeVeiculoTipoOperacaoEnum.VENDA_DIRETA));
        assertTrue(listAll.contains(NFeVeiculoTipoOperacaoEnum.OUTROS));
    }
}
