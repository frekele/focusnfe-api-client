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
public class NFeTipoIntegracaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeTipoIntegracaoEnum entity = NFeTipoIntegracaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");

        entity = NFeTipoIntegracaoEnum.fromCode("2");
        assertNotNull(entity);
        assertEquals(entity.getDescription(), "Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS)");

        entity = NFeTipoIntegracaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeTipoIntegracaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeTipoIntegracaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeTipoIntegracaoEnum> listAll = NFeTipoIntegracaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 2);
        assertTrue(listAll.contains(NFeTipoIntegracaoEnum.PAGAMENTO_INTEGRADO_COM_SISTEMA_DE_AUTOMACAO));
        assertTrue(listAll.contains(NFeTipoIntegracaoEnum.PAGAMENTO_NAO_INTEGRADO_COM_SISTEMA_DE_AUTOMACAO));
    }
}
