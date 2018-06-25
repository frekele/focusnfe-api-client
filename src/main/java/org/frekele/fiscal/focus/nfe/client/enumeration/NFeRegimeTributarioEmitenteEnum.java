package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Código de regime tributário do emitente.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeRegimeTributarioEmitenteEnum {

    /**
     * 1 - Simples Nacional.
     */
    SIMPLES_NACIONAL("1", "Simples Nacional"),
    /**
     * 2 - Simples Nacional – excesso de sublimite de receita bruta.
     */
    SIMPLES_NACIONAL_EXCETO_SUBLIMITE_RECEITA_BRUTA("2", "Simples Nacional – excesso de sublimite de receita bruta"),
    /**
     * 3 - Regime Normal.
     */
    REGIME_NORMAL("3", "Regime Normal");

    private String code;

    private String description;

    private NFeRegimeTributarioEmitenteEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeRegimeTributarioEmitenteEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeRegimeTributarioEmitenteEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeRegimeTributarioEmitenteEnum> getAll() {
        return Arrays.asList(NFeRegimeTributarioEmitenteEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
