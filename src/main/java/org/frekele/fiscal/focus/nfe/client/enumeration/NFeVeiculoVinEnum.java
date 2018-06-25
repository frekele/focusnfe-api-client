package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Veículo tem VIN remarcado.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeVeiculoVinEnum {

    /**
     * R - Remarcado.
     */
    REMARCADO("R", "Remarcado"),
    /**
     * N - Normal.
     */
    NORMAL("N", "Normal");

    private String code;

    private String description;

    private NFeVeiculoVinEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoVinEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoVinEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoVinEnum> getAll() {
        return Arrays.asList(NFeVeiculoVinEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
