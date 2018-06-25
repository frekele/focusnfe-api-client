package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Condição do veículo.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeVeiculoCondicaoEnum {

    /**
     * 1 - Acabado.
     */
    ACABADO("1", "Acabado"),
    /**
     * 2 - Inacabado.
     */
    INACABADO("2", "Inacabado"),
    /**
     * 3 - Semi-acabado.
     */
    SEMI_ACABADO("3", "Semi-acabado");

    private String code;

    private String description;

    private NFeVeiculoCondicaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoCondicaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoCondicaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoCondicaoEnum> getAll() {
        return Arrays.asList(NFeVeiculoCondicaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
