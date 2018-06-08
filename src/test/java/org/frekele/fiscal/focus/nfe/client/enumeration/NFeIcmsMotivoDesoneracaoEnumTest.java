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
public class NFeIcmsMotivoDesoneracaoEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeIcmsMotivoDesoneracaoEnum entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("1");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "1");

        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("3");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("4");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("5");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("6");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("7");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("9");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("10");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("11");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("12");
        assertNotNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("16");
        assertNotNull(entity);

        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode(null);
        assertNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("");
        assertNull(entity);
        entity = NFeIcmsMotivoDesoneracaoEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeIcmsMotivoDesoneracaoEnum> listAll = NFeIcmsMotivoDesoneracaoEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 11);
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.TAXI));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.PRODUTOR_AGROPECUARIO));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.FROTISTA_LOCADORA));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.DIPLOMATICO_CONSULAR));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.UTILITARIOS_MOTOCICLETAS_DA_AMAZONIA_OCIDENTAL));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.SUFRAMA));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.OUTROS));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.DEFICIENTE_CONDUTOR));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.DEFICIENTE_NAO_CONDUTOR));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO));
        assertTrue(listAll.contains(NFeIcmsMotivoDesoneracaoEnum.OLIMPIADAS_RIO_2016));
    }
}
