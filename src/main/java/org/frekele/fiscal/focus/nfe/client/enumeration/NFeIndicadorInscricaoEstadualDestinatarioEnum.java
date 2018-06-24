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
public enum NFeIndicadorInscricaoEstadualDestinatarioEnum {

    /**
     * 1 - Contribuinte ICMS (informar a IE do destinatário).
     */
    CONTRIBUINTE("1", "Contribuinte ICMS (informar a IE do destinatário)"),
    /**
     * 2 - Contribuinte isento de Inscrição no cadastro de Contribuintes do ICMS.
     */
    ISENTO("2", "Contribuinte isento de Inscrição no cadastro de Contribuintes do ICMS"),
    /**
     * 9 - Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS.
     */
    NAO_CONTRIBUINTE("9", "Não Contribuinte, que pode ou não possuir Inscrição Estadual no Cadastro de Contribuintes do ICMS");

    private String code;

    private String description;

    private NFeIndicadorInscricaoEstadualDestinatarioEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIndicadorInscricaoEstadualDestinatarioEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIndicadorInscricaoEstadualDestinatarioEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIndicadorInscricaoEstadualDestinatarioEnum> getAll() {
        return Arrays.asList(NFeIndicadorInscricaoEstadualDestinatarioEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
