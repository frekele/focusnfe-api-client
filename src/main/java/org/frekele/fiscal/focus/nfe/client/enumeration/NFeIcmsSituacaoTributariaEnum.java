package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

@XmlType
@XmlEnum(String.class)
public enum NFeIcmsSituacaoTributariaEnum {

    /**
     * 00 - Tributada integralmente.
     */
    TRIBUTADA_INTEGRALMENTE("00", "Tributada integralmente"),
    /**
     * 10 - Tributada e com cobrança do ICMS por substituição tributária.
     */
    TRIBUTADA_E_COM_COBRANCA_ICMS_POR_ST("10", "Tributada e com cobrança do ICMS por substituição tributária"),
    /**
     * 20 - Tributada com redução de base de cálculo.
     */
    TRIBUTADA_COM_REDUCAO_BASE_CALCULO("20", "Tributada com redução de base de cálculo"),
    /**
     * 30 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária.
     */
    ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_ST("30", "Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
    /**
     * 40 - Isenta.
     */
    ISENTA("40", "Isenta"),
    /**
     * 41 - "Não tributada.
     */
    NAO_TRIBUTADA("41", "Não tributada"),
    /**
     * 50 - Suspensão.
     */
    SUSPENSAO("50", "Suspensão"),
    /**
     * 51 - Diferimento (a exigência do preenchimento das informações do ICMS diferido fica a critério de cada UF).
     */
    DIFERIMENTO("51", "Diferimento (a exigência do preenchimento das informações do ICMS diferido fica a critério de cada UF)"),
    /**
     * 60 - Cobrado anteriormente por substituição tributária.
     */
    COBRADO_ANTERIORMENTE_POR_ST("60", "Cobrado anteriormente por substituição tributária"),
    /**
     * 70 - Tributada com redução de base de cálculo e com cobrança do ICMS por substituição tributária.
     */
    TRIBURADA_COM_REDUCAO_BASE_CALCULO_COM_COBRANCA_ICMS_POR_ST("70", "Tributada com redução de base de cálculo e com cobrança do ICMS por substituição tributária"),
    /**
     * 90 - Outras (regime Normal).
     */
    OUTROS_REGIME_NORMAL("90", "Outras (regime Normal)"),
    /**
     * 101 - Tributada pelo Simples Nacional com permissão de crédito.
     */
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_CREDITO("101", "Tributada pelo Simples Nacional com permissão de crédito"),
    /**
     * 102 - Tributada pelo Simples Nacional sem permissão de crédito.
     */
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO("102", "Tributada pelo Simples Nacional sem permissão de crédito"),
    /**
     * 103 - Isenção do ICMS no Simples Nacional para faixa de receita bruta.
     */
    ISENCAO_ICMS_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA("103", "Isenção do ICMS no Simples Nacional para faixa de receita bruta"),
    /**
     * 201 - Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária.
     */
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_CREDITO_COM_COBRANCA_ICMS_POR_ST("201", "Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária"),
    /**
     * 202 - Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária.
     */
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO_COM_COBRANCA_ICMS_POR_ST("202", "Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária"),
    /**
     * 203 - Isenção do ICMS nos Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária.
     */
    ISENCAO_ICMS_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_COM_COBRANCA_ICMS_POR_ST("203", "Isenção do ICMS nos Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária"),
    /**
     * 300 - Imune.
     */
    IMUNE("300", "Imune"),
    /**
     * 400 - Não tributada pelo Simples Nacional.
     */
    NAO_TRIBUTADA_PELO_SIMPLES_NACIONAL("400", "Não tributada pelo Simples Nacional"),
    /**
     * 500 - ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação.
     */
    ICMS_COBRADO_ANTERIORMENTE_POR_ST_OU_ANTECIPACAO("500", "ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação"),
    /**
     * 900 - Outras (regime Simples Nacional).
     */
    OUTROS_REGIME_SIMPLES_NACIONAL("900", "Outras (regime Simples Nacional)");

    private String code;

    private String description;

    private NFeIcmsSituacaoTributariaEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsSituacaoTributariaEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsSituacaoTributariaEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsSituacaoTributariaEnum> getAll() {
        return Arrays.asList(NFeIcmsSituacaoTributariaEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
