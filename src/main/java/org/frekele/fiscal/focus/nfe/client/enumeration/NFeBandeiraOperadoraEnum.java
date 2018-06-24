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

    /**
     * 01 - Visa.
     */
    VISA("01", "Visa"),
    /**
     * 02 - Mastercard.
     */
    MASTERCARD("02", "Mastercard"),
    /**
     * 03 - American Express.
     */
    AMERICAN_EXPRESS("03", "American Express"),
    /**
     * 04 - Sorocred.
     */
    SOROCRED("04", "Sorocred"),
    /**
     * 05 - Diners Club.
     */
    DINERS_CLUB("05", "Diners Club"),
    /**
     * 06 - Elo.
     */
    ELO("06", "Elo"),
    /**
     * 07 - Hipercard.
     */
    HIPERCARD("07", "Hipercard"),
    /**
     * 08 - Aura.
     */
    AURA("08", "Aura"),
    /**
     * 09 - Cabal.
     */
    CABAL("09", "Cabal"),
    /**
     * 99 - Outros.
     */
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
