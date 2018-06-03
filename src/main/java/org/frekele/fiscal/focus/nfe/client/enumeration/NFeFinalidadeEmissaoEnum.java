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
public enum NFeFinalidadeEmissaoEnum {

    NORMAL("1", "Normal"),
    COMPLEMENTAR("2", "Complementar"),
    NOTA_DE_AJUSTE("3", "Nota de ajuste"),
    DEVOLUCAO("4", "Devolução");

    private String code;

    private String description;

    private NFeFinalidadeEmissaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeFinalidadeEmissaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeFinalidadeEmissaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeFinalidadeEmissaoEnum> getAll() {
        return Arrays.asList(NFeFinalidadeEmissaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}