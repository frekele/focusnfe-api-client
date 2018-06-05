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
public enum NFeVeiculoCodigoCorDenatranEnum {

    AMARELO("01", "Amarelo"),
    AZUL("02", "Azul"),
    BEGE("03", "Bege"),
    BRANCA("04", "Branca"),
    CINZA("05", "Cinza"),
    DOURADA("06", "Dourada"),
    GRENA("07", "Grena"),
    LARANJA("08", "Laranja"),
    MARROM("09", "Marrom"),
    PRATA("10", "Prata"),
    PRETA("11", "Preta"),
    ROSA("12", "Rosa"),
    ROXA("13", "Roxa"),
    VERDE("14", "Verde"),
    VERMELHA("15", "Vermelha"),
    FANTASIA("16", "Fantasia");

    private String code;

    private String description;

    private NFeVeiculoCodigoCorDenatranEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoCodigoCorDenatranEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoCodigoCorDenatranEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoCodigoCorDenatranEnum> getAll() {
        return Arrays.asList(NFeVeiculoCodigoCorDenatranEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
