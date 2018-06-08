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
public class NFeUnidadeFederativaEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFeUnidadeFederativaEnum entity = NFeUnidadeFederativaEnum.fromCode("AC");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "AC");
        assertEquals(entity.getDescription(), "Acre");

        entity = NFeUnidadeFederativaEnum.fromCode("AL");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("AM");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("AP");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("BA");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("CE");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("DF");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("ES");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("GO");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("MA");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("MG");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("MS");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("MT");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("PA");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("PB");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("PE");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("PI");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("PR");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("RJ");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("RN");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("RO");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("RR");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("RS");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("SC");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("SE");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("SP");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("TO");
        assertNotNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("EX");
        assertNotNull(entity);

        entity = NFeUnidadeFederativaEnum.fromCode(null);
        assertNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("");
        assertNull(entity);
        entity = NFeUnidadeFederativaEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFeUnidadeFederativaEnum> listAll = NFeUnidadeFederativaEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 28);
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.ACRE));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.ALAGOAS));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.AMAZONAS));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.AMAPA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.BAHIA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.CEARA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.DISTRITO_FEDERAL));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.ESPIRITO_SANTO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.GOIAS));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.MARANHAO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.MINAS_GERAIS));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.MATO_GROSSO_SUL));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.MATO_GROSSO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.PARA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.PARAIBA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.PERNAMBUCO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.PIAUI));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.PARANA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.RIO_JANEIRO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.RIO_GRANDE_DO_NORTE));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.RONDONIA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.RORAIMA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.SANTA_CATARINA));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.SERGIPE));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.SAO_PAULO));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.TOCANTINS));
        assertTrue(listAll.contains(NFeUnidadeFederativaEnum.EXTERIOR));
    }
}
