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
public class MDeTipoManifestacaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        MDeTipoManifestacaoEnum entity = MDeTipoManifestacaoEnum.fromCode("ciencia");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "ciencia");
        assertEquals(entity.getDescription(), "Ciência da operação");

        entity = MDeTipoManifestacaoEnum.fromCode("confirmacao");
        assertNotNull(entity);
        entity = MDeTipoManifestacaoEnum.fromCode("desconhecimento");
        assertNotNull(entity);
        entity = MDeTipoManifestacaoEnum.fromCode("nao_realizada");
        assertNotNull(entity);

        entity = MDeTipoManifestacaoEnum.fromCode(null);
        assertNull(entity);
        entity = MDeTipoManifestacaoEnum.fromCode("");
        assertNull(entity);
        entity = MDeTipoManifestacaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<MDeTipoManifestacaoEnum> listAll = MDeTipoManifestacaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 4);
        assertTrue(listAll.contains(MDeTipoManifestacaoEnum.CIENCIA));
        assertTrue(listAll.contains(MDeTipoManifestacaoEnum.CONFIRMACAO));
        assertTrue(listAll.contains(MDeTipoManifestacaoEnum.DESCONHECIMENTO));
        assertTrue(listAll.contains(MDeTipoManifestacaoEnum.NAO_REALIZADA));
    }
}
