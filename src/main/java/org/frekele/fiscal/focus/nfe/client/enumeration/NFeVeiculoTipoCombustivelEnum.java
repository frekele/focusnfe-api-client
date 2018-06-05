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
public enum NFeVeiculoTipoCombustivelEnum {

    ALCOOL("01", "Álcool"),
    GASOLINA("02", "Gasolina"),
    DIESEL("03", "Diesel"),
    ALCOOL_GASOLINA("16", "Álcool/Gasolina"),
    GASOLINA_ALCOOL_GNV("17", "Gasolina/Álcool/GNV"),
    GASOLINA_ELETRICO("18", "Gasolina/Elétrico");

    private String code;

    private String description;

    private NFeVeiculoTipoCombustivelEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoTipoCombustivelEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoTipoCombustivelEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoTipoCombustivelEnum> getAll() {
        return Arrays.asList(NFeVeiculoTipoCombustivelEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
