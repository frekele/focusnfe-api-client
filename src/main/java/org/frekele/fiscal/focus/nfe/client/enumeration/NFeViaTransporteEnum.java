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
public enum NFeViaTransporteEnum {

    MARITIMA("1", "Marítima"),
    FLUVIAL("2", "Fluvial"),
    LACUSTRE("3", "Lacustre"),
    AEREA("4", "Aérea"),
    POSTAL("5", "Postal"),
    FERROVIARIA("6", "Ferroviária"),
    RODOVIARIA("7", "Rodoviária"),
    CONDUTO_REDES_TRANSMISSAO("8", "Conduto / Redes transmissão"),
    MEIOS_PROPRIOS("9", "Meios próprios"),
    ENTRADA_SAIDA_FICTA("10", "Entrada / Saída ficta"),
    COURIER("11", "Courier"),
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
