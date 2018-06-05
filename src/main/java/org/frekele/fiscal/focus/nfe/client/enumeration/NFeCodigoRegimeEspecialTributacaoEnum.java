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
public enum NFeCodigoRegimeEspecialTributacaoEnum {

    MICROEMPRESA_MUNICIPAL("1", "Microempresa Municipal"),
    ESTIMATIVA("2", "Estimativa"),
    SOCIEDADE_DE_PROFISSIONAIS("3", "Sociedade de Profissionais"),
    COOPERATIVA("4", "Cooperativa"),
    MICROEMPRESARIO_INDIVIDUAL_MEI("5", "Microempresário Individual (MEI)"),
    MICROEMPRESARIO_E_EMPRESA_PEQUENO_PORTE_ME_EPP("6", "Microempresário e Empresa de Pequeno Porte (ME/EPP)");

    private String code;

    private String description;

    private NFeCodigoRegimeEspecialTributacaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeCodigoRegimeEspecialTributacaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeCodigoRegimeEspecialTributacaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeCodigoRegimeEspecialTributacaoEnum> getAll() {
        return Arrays.asList(NFeCodigoRegimeEspecialTributacaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
