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
public enum NFeBandeiraOperadoraEnum {

    VISA("01", "Visa"),
    MASTERCARD("02", "Mastercard"),
    AMERICAN_EXPRESS("03", "American Express"),
    SOROCRED("04", "Sorocred"),
    DINERS_CLUB("05", "Diners Club"),
    ELO("06", "Elo"),
    HIPERCARD("07", "Hipercard"),
    AURA("08", "Aura"),
    CABAL("09", "Cabal"),
    OUTROS("99", "Outros");

    private String code;

    private String description;

    private NFeBandeiraOperadoraEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeBandeiraOperadoraEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeBandeiraOperadoraEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeBandeiraOperadoraEnum> getAll() {
        return Arrays.asList(NFeBandeiraOperadoraEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
