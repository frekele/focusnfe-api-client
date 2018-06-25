package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Indica operação com consumidor final.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeConsumidorFinalEnum {

    /**
     * 0 - Normal.
     */
    NORMAL("0", "Normal"),
    /**
     * 1 - Consumidor final.
     */
    CONSUMIDOR_FINAL("1", "Consumidor final");

    private String code;

    private String description;

    private NFeConsumidorFinalEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeConsumidorFinalEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeConsumidorFinalEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeConsumidorFinalEnum> getAll() {
        return Arrays.asList(NFeConsumidorFinalEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
