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
public class NFeVeiculoRestricaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeVeiculoRestricaoEnum entity = NFeVeiculoRestricaoEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");
        assertEquals(entity.getDescription(), "Não há");

        entity = NFeVeiculoRestricaoEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("9");
        assertNotNull(entity);

        entity = NFeVeiculoRestricaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeVeiculoRestricaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeVeiculoRestricaoEnum> listAll = NFeVeiculoRestricaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 6);
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.NAO_HA));
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.ALIENACAO_FIDUCIARIA));
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.ARRENDAMENTO_MERCANTIL));
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.RESERVA_DE_DOMINIO));
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.PENHOR_DE_VEICULOS));
        assertTrue(listAll.contains(NFeVeiculoRestricaoEnum.OUTRAS));
    }
}
