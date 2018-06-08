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
public class NFeFormaPagamentoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeFormaPagamentoEnum entity = NFeFormaPagamentoEnum.fromCode("01");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "01");
        assertEquals(entity.getDescription(), "Dinheiro");

        entity = NFeFormaPagamentoEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("04");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("05");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("10");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("11");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("12");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("13");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("14");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("15");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("90");
        assertNotNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("99");
        assertNotNull(entity);

        entity = NFeFormaPagamentoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("");
        assertNull(entity);
        entity = NFeFormaPagamentoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeFormaPagamentoEnum> listAll = NFeFormaPagamentoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 13);
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.DINHEIRO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.CHEQUE));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.CARTAO_DE_CREDITO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.CARTAO_DE_DEBITO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.CREDITO_LOJA));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.VALE_ALIMENTACAO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.VALE_REFEICAO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.VALE_PRESENTE));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.VALE_COMBUSTIVEL));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.DUPLICATA_MERCANTIL));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.BOLETO_BANCARIO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.SEM_PAGAMENTO));
        assertTrue(listAll.contains(NFeFormaPagamentoEnum.OUTROS));
    }
}
