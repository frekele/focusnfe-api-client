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
public enum NFeVeiculoRestricaoEnum {

    /**
     * 0 - Não há.
     */
    NAO_HA("0", "Não há"),
    /**
     * 1 - Alienação fiduciária.
     */
    ALIENACAO_FIDUCIARIA("1", "Alienação fiduciária"),
    /**
     * 2 - Arrendamento mercantil.
     */
    ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
    /**
     * 3 - Reserva de domínio.
     */
    RESERVA_DE_DOMINIO("3", "Reserva de domínio"),
    /**
     * 4 - Penhor de veículos.
     */
    PENHOR_DE_VEICULOS("4", "Penhor de veículos"),
    /**
     * 9 - Outras.
     */
    OUTRAS("9", "Outras");

    private String code;

    private String description;

    private NFeVeiculoRestricaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoRestricaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoRestricaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoRestricaoEnum> getAll() {
        return Arrays.asList(NFeVeiculoRestricaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
