package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Modalidade de determinação da base de cálculo do ICMS ST.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeIcmsModalidadeBaseCalculoStEnum {

    /**
     * 0 - Preço tabelado ou máximo sugerido.
     */
    PRECO_TABELADO_OU_MAXIMO_SUGERIDO("0", "Preço tabelado ou máximo sugerido"),
    /**
     * 1 - Lista negativa (valor).
     */
    LISTA_NEGATIVA("1", "Lista negativa (valor)"),
    /**
     * 2 - Lista positiva (valor).
     */
    LISTA_POSITIVA("2", "Lista positiva (valor)"),
    /**
     * 3 - Lista neutra (valor).
     */
    LISTA_NEGRA("3", "Lista neutra (valor)"),
    /**
     * 4 - Margem de valor agregado (%).
     */
    MARGEM_DE_VALOR_AGREGADO("4", "Margem de valor agregado (%)"),
    /**
     * 5 - Pauta (valor).
     */
    PAUTA("5", "Pauta (valor)");

    private String code;

    private String description;

    private NFeIcmsModalidadeBaseCalculoStEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsModalidadeBaseCalculoStEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsModalidadeBaseCalculoStEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsModalidadeBaseCalculoStEnum> getAll() {
        return Arrays.asList(NFeIcmsModalidadeBaseCalculoStEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
