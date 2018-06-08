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
public class NFePresencaCompradorEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFePresencaCompradorEnum entity = NFePresencaCompradorEnum.fromCode("0");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "0");

        entity = NFePresencaCompradorEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getDescription(), "Operação presencial");

        entity = NFePresencaCompradorEnum.fromCode("1");
        assertNotNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("2");
        assertNotNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("9");
        assertNotNull(entity);

        entity = NFePresencaCompradorEnum.fromCode(null);
        assertNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("");
        assertNull(entity);
        entity = NFePresencaCompradorEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFePresencaCompradorEnum> listAll = NFePresencaCompradorEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 7);
        assertTrue(listAll.contains(NFePresencaCompradorEnum.NAO_SE_APLICA));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_PRESENCIAL));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_NAO_PRESENCIAL_PELA_INTERNET));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_COM_NFCE_ENTREGA_DOMICILIO));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_PRESENCIAL_FORA_ESTABELECIMENTO));
        assertTrue(listAll.contains(NFePresencaCompradorEnum.OPERACAO_NAO_PRESENCIAL_OUTROS));
    }
}
