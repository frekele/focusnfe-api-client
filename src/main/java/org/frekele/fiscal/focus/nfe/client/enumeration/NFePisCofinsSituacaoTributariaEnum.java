package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Situação tributária do PIS e Cofins.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFePisCofinsSituacaoTributariaEnum {

    /**
     * 01 - Operação tributável: base de cálculo = valor da operação (alíquota normal – cumulativo/não cumulativo).
     */
    OPERACAO_TRIBUTAVEL_BASE_CALCULO_VALOR_OPERACAO_ALIQUOTA_NORMAL_MENOS_CUMULATIVA_NAO_CUMULATIVA("01", "Operação tributável: base de cálculo = valor da operação (alíquota normal – cumulativo/não cumulativo)"),
    /**
     * 02 - Operação tributável: base de cálculo = valor da operação (alíquota diferenciada).
     */
    OPERACAO_TRIBUTAVEL_BASE_CALCULO_VALOR_OPERACAO_ALIQUOTA_DIFERENCIADA("02", "Operação tributável: base de cálculo = valor da operação (alíquota diferenciada)"),
    /**
     * 03 - Operação tributável: base de cálculo = quantidade vendida × alíquota por unidade de produto.
     */
    OPERACAO_TRIBUTAVEL_BASE_CALCULO_QUANTIDADE_VENDIDA_X_ALIQUOTA_POR_UND_PRODUTO("03", "Operação tributável: base de cálculo = quantidade vendida × alíquota por unidade de produto"),
    /**
     * 04 - Operação tributável: tributação monofásica (alíquota zero).
     */
    OPERACAO_TRIBUTAVEL_TRIBUTACAO_MONOFASICA_ALIQUOTA_ZERO("04", "Operação tributável: tributação monofásica (alíquota zero)"),
    /**
     * 05 - Operação tributável: substituição tributária.
     */
    OPERACAO_TRIBUTAVEL_ST("05", "Operação tributável: substituição tributária"),
    /**
     * 06 - Operação tributável: alíquota zero.
     */
    OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", "Operação tributável: alíquota zero"),
    /**
     * 07 - Operação isenta da contribuição.
     */
    OPERACAO_ISENTA_DA_CONTRIBUICAO("07", "Operação isenta da contribuição"),
    /**
     * 08 - Operação sem incidência da contribuição.
     */
    OPERACAO_SEM_INCIDENCIA_DA_CONTRIBUICAO("08", "Operação sem incidência da contribuição"),
    /**
     * 09 - Operação com suspensão da contribuição.
     */
    OPERACAO_COM_SUSPENSAO_DA_CONTRIBUICAO("09", "Operação com suspensão da contribuição"),
    /**
     * 49 - Outras operações de saída.
     */
    OUTRAS_OPERACOES_DE_SAIDA("49", "Outras operações de saída"),
    /**
     * 50 - Operação com direito a crédito: vinculada exclusivamente a receita tributada no mercado interno.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_TRIBUTADA_MERCADO_INTERNO("50", "Operação com direito a crédito: vinculada exclusivamente a receita tributada no mercado interno"),
    /**
     * 51 - Operação com direito a crédito: vinculada exclusivamente a receita não tributada no mercado interno.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("51", "Operação com direito a crédito: vinculada exclusivamente a receita não tributada no mercado interno"),
    /**
     * 52 - Operação com direito a crédito: vinculada exclusivamente a receita de exportação.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_DE_EXPORTACAO("52", "Operação com direito a crédito: vinculada exclusivamente a receita de exportação"),
    /**
     * 53 - Operação com direito a crédito: vinculada a receitas tributadas e não-tributadas no mercado interno.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO("53", "Operação com direito a crédito: vinculada a receitas tributadas e não-tributadas no mercado interno"),
    /**
     * 54 - Operação com direito a crédito: vinculada a receitas tributadas no mercado interno e de exportação.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("54", "Operação com direito a crédito: vinculada a receitas tributadas no mercado interno e de exportação"),
    /**
     * 55 - Operação com direito a crédito: vinculada a receitas não-tributadas no mercado interno e de exportação.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("55", "Operação com direito a crédito: vinculada a receitas não-tributadas no mercado interno e de exportação"),
    /**
     * 56 - Operação com direito a crédito: vinculada a receitas tributadas e não-tributadas no mercado interno e de exportação.
     */
    OPERACAO_COM_DIREITO_A_CREDITO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("56", "Operação com direito a crédito: vinculada a receitas tributadas e não-tributadas no mercado interno e de exportação"),
    /**
     * 60 - Crédito presumido: operação de aquisição vinculada exclusivamente a receita tributada no mercado interno.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_TRIBUTADA_MERCADO_INTERNO("60", "Crédito presumido: operação de aquisição vinculada exclusivamente a receita tributada no mercado interno"),
    /**
     * 61 - Crédito presumido: operação de aquisição vinculada exclusivamente a receita não-tributada no mercado interno.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("61", "Crédito presumido: operação de aquisição vinculada exclusivamente a receita não-tributada no mercado interno"),
    /**
     * 62 - Crédito presumido: operação de aquisição vinculada exclusivamente a receita de exportação.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_EXCLUSIVAMENTE_A_RECEITA_DE_EXPORTACAO("62", "Crédito presumido: operação de aquisição vinculada exclusivamente a receita de exportação"),
    /**
     * 63 - Crédito presumido: operação de aquisição vinculada a receitas tributadas e não-tributadas no mercado interno.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO("63", "Crédito presumido: operação de aquisição vinculada a receitas tributadas e não-tributadas no mercado interno"),
    /**
     * 64 - Crédito presumido: operação de aquisição vinculada a receitas tributadas no mercado interno e de exportação.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("64", "Crédito presumido: operação de aquisição vinculada a receitas tributadas no mercado interno e de exportação"),
    /**
     * 65 - Crédito presumido: operação de aquisição vinculada a receitas não-tributadas no mercado interno e de exportação.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("65", "Crédito presumido: operação de aquisição vinculada a receitas não-tributadas no mercado interno e de exportação"),
    /**
     * 66 - Crédito presumido: operação de aquisição vinculada a receitas tributadas e não-tributadas no mercado interno e de exportação.
     */
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADO_A_RECEITA_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO_E_EXPORTACAO("66", "Crédito presumido: operação de aquisição vinculada a receitas tributadas e não-tributadas no mercado interno e de exportação"),
    /**
     * 67 - Crédito presumido: outras operações.
     */
    CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", "Crédito presumido: outras operações"),
    /**
     * 70 - Operação de aquisição sem direito a crédito.
     */
    OPERACAO_DE_AQUISICAO_SEM_DIREITO_A_CREDITO("70", "Operação de aquisição sem direito a crédito"),
    /**
     * 71 - Operação de aquisição com isenção.
     */
    OPERACAO_DE_AQUISICAO_COM_ISENCAO("71", "Operação de aquisição com isenção"),
    /**
     * 72 - Operação de aquisição com suspensão.
     */
    OPERACAO_DE_AQUISICAO_AQUISICAO_COM_SUSPENSAO("72", "Operação de aquisição com suspensão"),
    /**
     * 73 - Operação de aquisição a alíquota zero.
     */
    OPERACAO_DE_AQUISICAO_ALIQUOTA_ZERO("73", "Operação de aquisição a alíquota zero"),
    /**
     * 74 - Operação de aquisição sem incidência da contribuição.
     */
    OPERACAO_DE_AQUISICAO_SEM_INCIDENCIA_DA_CONTRIBUICAO("74", "Operação de aquisição sem incidência da contribuição"),
    /**
     * 75 - Operação de aquisição por substituição tributária.
     */
    OPERACAO_DE_AQUISICAO_POR_ST("75", "Operação de aquisição por substituição tributária"),
    /**
     * 98 - Outras operações de entrada.
     */
    OUTRAS_OPERACOES_DE_ENTRADA("98", "Outras operações de entrada"),
    /**
     * 99 - Outras operações.
     */
    OUTRAS_OPERACOES("99", "Outras operações");

    private String code;

    private String description;

    private NFePisCofinsSituacaoTributariaEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFePisCofinsSituacaoTributariaEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFePisCofinsSituacaoTributariaEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFePisCofinsSituacaoTributariaEnum> getAll() {
        return Arrays.asList(NFePisCofinsSituacaoTributariaEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
