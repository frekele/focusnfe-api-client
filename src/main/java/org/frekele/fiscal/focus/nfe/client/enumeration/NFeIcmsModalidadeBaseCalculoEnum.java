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
public enum NFeIcmsModalidadeBaseCalculoEnum {

    MARGEM_DE_VALOR_AGREGADO("0", "Margem de valor agregado (%)"),
    PAUTA("1", "Pauta (valor)"),
    PRECO_TABELADO_MAXIMO("2", "Preço tabelado máximo (valor)"),
    VALOR_DA_OPERACAO("3", "Valor da operação");

    private String code;

    private String description;

    private NFeIcmsModalidadeBaseCalculoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsModalidadeBaseCalculoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsModalidadeBaseCalculoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsModalidadeBaseCalculoEnum> getAll() {
        return Arrays.asList(NFeIcmsModalidadeBaseCalculoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
