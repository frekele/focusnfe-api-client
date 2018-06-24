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
public enum NFeModeloEcfEnum {

    /**
     * 2B - Cupom Fiscal emitido por máquina registradora (não ECF).
     */
    CUPOM_FISCAL_EMITIDO_POR_MAQUINA_REGISTRADORA_NAO_ECF("2B", "Cupom Fiscal emitido por máquina registradora (não ECF)"),
    /**
     * 2C - Cupom Fiscal PDV.
     */
    CUPOM_FISCAL_PDV("2C", "Cupom Fiscal PDV"),
    /**
     * 2D - Cupom Fiscal (emitido por ECF) (v2.0).
     */
    CUPOM_FISCAL_EMITIDO_ECF("2D", "Cupom Fiscal (emitido por ECF) (v2.0)");

    private String code;

    private String description;

    private NFeModeloEcfEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeModeloEcfEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeModeloEcfEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeModeloEcfEnum> getAll() {
        return Arrays.asList(NFeModeloEcfEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
