package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Tipo de combustível (utilizar tabela do RENAVAM).
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeVeiculoTipoCombustivelEnum {

    /**
     * 01 - Álcool.
     */
    ALCOOL("01", "Álcool"),
    /**
     * 02 - Gasolina.
     */
    GASOLINA("02", "Gasolina"),
    /**
     * 03 - Diesel.
     */
    DIESEL("03", "Diesel"),
    /**
     * 16 - Álcool/Gasolina.
     */
    ALCOOL_GASOLINA("16", "Álcool/Gasolina"),
    /**
     * 17 - Gasolina/Álcool/GNV.
     */
    GASOLINA_ALCOOL_GNV("17", "Gasolina/Álcool/GNV"),
    /**
     * 18 - Gasolina/Elétrico.
     */
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
