package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Código da cor segundo as regras de pré-cadastro do DENATRAN.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeVeiculoCodigoCorDenatranEnum {

    /**
     * 01 - Amarelo.
     */
    AMARELO("01", "Amarelo"),
    /**
     * 02 - Azul.
     */
    AZUL("02", "Azul"),
    /**
     * 03 - Bege.
     */
    BEGE("03", "Bege"),
    /**
     * 04 - Branca.
     */
    BRANCA("04", "Branca"),
    /**
     * 05 - Cinza.
     */
    CINZA("05", "Cinza"),
    /**
     * 06 - Dourada.
     */
    DOURADA("06", "Dourada"),
    /**
     * 07 - Grena.
     */
    GRENA("07", "Grena"),
    /**
     * 08 - Laranja.
     */
    LARANJA("08", "Laranja"),
    /**
     * 09 - Marrom.
     */
    MARROM("09", "Marrom"),
    /**
     * 10 - Prata.
     */
    PRATA("10", "Prata"),
    /**
     * 11 - Preta.
     */
    PRETA("11", "Preta"),
    /**
     * 12 - Rosa.
     */
    ROSA("12", "Rosa"),
    /**
     * 13 - Roxa.
     */
    ROXA("13", "Roxa"),
    /**
     * 14 - Verde.
     */
    VERDE("14", "Verde"),
    /**
     * 15 - Vermelha.
     */
    VERMELHA("15", "Vermelha"),
    /**
     * 16 - Fantasia.
     */
    FANTASIA("16", "Fantasia");

    private String code;

    private String description;

    private NFeVeiculoCodigoCorDenatranEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoCodigoCorDenatranEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoCodigoCorDenatranEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoCodigoCorDenatranEnum> getAll() {
        return Arrays.asList(NFeVeiculoCodigoCorDenatranEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
