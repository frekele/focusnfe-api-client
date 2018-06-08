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
public class NFeCodigoRegimeEspecialTributacaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeCodigoRegimeEspecialTributacaoEnum entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");

        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("6");
        assertNotNull(entity);

        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeCodigoRegimeEspecialTributacaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeCodigoRegimeEspecialTributacaoEnum> listAll = NFeCodigoRegimeEspecialTributacaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 6);
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.MICROEMPRESA_MUNICIPAL));
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.ESTIMATIVA));
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.SOCIEDADE_DE_PROFISSIONAIS));
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.COOPERATIVA));
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.MICROEMPRESARIO_INDIVIDUAL_MEI));
        assertTrue(listAll.contains(NFeCodigoRegimeEspecialTributacaoEnum.MICROEMPRESARIO_E_EMPRESA_PEQUENO_PORTE_ME_EPP));
    }
}
