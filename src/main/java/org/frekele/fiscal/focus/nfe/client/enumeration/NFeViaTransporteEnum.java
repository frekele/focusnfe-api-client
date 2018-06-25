package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Via de transporte internacional informada na DI.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeViaTransporteEnum {

    /**
     * 1 - Marítima.
     */
    MARITIMA("1", "Marítima"),
    /**
     * 2 - Fluvial.
     */
    FLUVIAL("2", "Fluvial"),
    /**
     * 3 - Lacustre.
     */
    LACUSTRE("3", "Lacustre"),
    /**
     * 4 - Aérea.
     */
    AEREA("4", "Aérea"),
    /**
     * 5 - Postal.
     */
    POSTAL("5", "Postal"),
    /**
     * 6 - Ferroviária.
     */
    FERROVIARIA("6", "Ferroviária"),
    /**
     * 7 - Rodoviária.
     */
    RODOVIARIA("7", "Rodoviária"),
    /**
     * 8 - Conduto / Redes transmissão.
     */
    CONDUTO_REDES_TRANSMISSAO("8", "Conduto / Redes transmissão"),
    /**
     * 9 - Meios próprios.
     */
    MEIOS_PROPRIOS("9", "Meios próprios"),
    /**
     * 10 - Entrada / Saída ficta.
     */
    ENTRADA_SAIDA_FICTA("10", "Entrada / Saída ficta"),
    /**
     * 11 - Courier.
     */
    COURIER("11", "Courier"),
    /**
     * 12 - Handcarry.
     */
    HANDCARRY("12", "Handcarry");

    private String code;

    private String description;

    private NFeViaTransporteEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeViaTransporteEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeViaTransporteEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeViaTransporteEnum> getAll() {
        return Arrays.asList(NFeViaTransporteEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
