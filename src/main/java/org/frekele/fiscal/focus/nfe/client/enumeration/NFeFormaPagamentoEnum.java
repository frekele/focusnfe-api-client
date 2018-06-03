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
public enum NFeFormaPagamentoEnum {

    A_VISTA("0", "À vista"),
    A_PRAZO("1", "À prazo"),
    OUTROS("2", "outros");

    private String code;

    private String description;

    private NFeFormaPagamentoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeFormaPagamentoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeFormaPagamentoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeFormaPagamentoEnum> getAll() {
        return Arrays.asList(NFeFormaPagamentoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
