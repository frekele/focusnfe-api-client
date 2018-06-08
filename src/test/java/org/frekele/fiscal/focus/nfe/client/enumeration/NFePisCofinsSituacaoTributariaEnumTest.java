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
public class NFePisCofinsSituacaoTributariaEnumTest {

    @Test
    public void testFromCode() throws Exception {
        NFePisCofinsSituacaoTributariaEnum entity = NFePisCofinsSituacaoTributariaEnum.fromCode("01");
        assertNotNull(entity);
        assertEquals(entity.getCode(), "01");

        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("02");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("03");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("04");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("05");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("06");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("07");
        assertNotNull(entity);
        assertEquals(entity.getDescription(), "Operação isenta da contribuição");
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("08");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("09");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("49");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("50");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("51");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("52");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("53");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("54");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("55");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("56");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("60");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("61");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("62");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("63");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("64");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("65");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("66");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("67");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("70");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("71");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("72");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("73");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("74");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("75");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("98");
        assertNotNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("99");
        assertNotNull(entity);

        entity = NFePisCofinsSituacaoTributariaEnum.fromCode(null);
        assertNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("");
        assertNull(entity);
        entity = NFePisCofinsSituacaoTributariaEnum.fromCode("XXXXXXXXXX");
        assertNull(entity);
    }

    @Test
    public void testGetAll() throws Exception {
        List<NFePisCofinsSituacaoTributariaEnum> listAll = NFePisCofinsSituacaoTributariaEnum.getAll();
        assertNotNull(listAll);
        assertEquals(listAll.size(), 33);
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_BASE_CALCULO_VALOR_OPERACAO_ALIQUOTA_NORMAL_MENOS_CUMULATIVA_NAO_CUMULATIVA));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_BASE_CALCULO_VALOR_OPERACAO_ALIQUOTA_DIFERENCIADA));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_BASE_CALCULO_QUANTIDADE_VENDIDA_X_ALIQUOTA_POR_UND_PRODUTO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_TRIBUTACAO_MONOFASICA_ALIQUOTA_ZERO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_ST));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_SEM_INCIDENCIA_DA_CONTRIBUICAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_SUSPENSAO_DA_CONTRIBUICAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_SAIDA));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_DE_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_DE_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.CREDITO_PRESUMIDO_OUTRAS_OPERACOES));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_SEM_DIREITO_A_CREDITO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_COM_ISENCAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_AQUISICAO_COM_SUSPENSAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_ALIQUOTA_ZERO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_SEM_INCIDENCIA_DA_CONTRIBUICAO));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OPERACAO_DE_AQUISICAO_POR_ST));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_ENTRADA));
        assertTrue(listAll.contains(NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES));
    }
}
