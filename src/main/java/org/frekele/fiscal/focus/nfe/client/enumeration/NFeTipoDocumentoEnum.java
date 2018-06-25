package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Tipo da nota fiscal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeTipoDocumentoEnum {

    /**
     * 0 - Nota Fiscal de Entrada.
     */
    NOTA_FISCAL_ENTRADA("0", "Nota Fiscal de Entrada"),
    /**
     * 1 - Nota Fiscal de Saída.
     */
    NOTA_FISCAL_SAIDA("1", "Nota Fiscal de Saída");

    private String code;

    private String description;

    private NFeTipoDocumentoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeTipoDocumentoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeTipoDocumentoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeTipoDocumentoEnum> getAll() {
        return Arrays.asList(NFeTipoDocumentoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
