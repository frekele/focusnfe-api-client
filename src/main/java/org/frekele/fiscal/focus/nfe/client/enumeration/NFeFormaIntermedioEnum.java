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
public enum NFeFormaIntermedioEnum {

    IMPORTACAO_POR_CONTA_PROPRIA("1", "Importação por conta própria"),
    IMPORTACAO_POR_CONTA_E_ORDEM("2", "Importação por conta e ordem"),
    IMPORTACAO_POR_ENCOMENDA("3", "Importação por encomenda");

    private String code;

    private String description;

    private NFeFormaIntermedioEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeFormaIntermedioEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeFormaIntermedioEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeFormaIntermedioEnum> getAll() {
        return Arrays.asList(NFeFormaIntermedioEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
