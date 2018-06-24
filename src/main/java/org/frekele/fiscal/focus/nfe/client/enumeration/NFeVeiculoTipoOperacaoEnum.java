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
public enum NFeVeiculoTipoOperacaoEnum {

    /**
     * 1 - Venda concessionária.
     */
    VENDA_CONCESSIONARIA("1", "Venda concessionária"),
    /**
     * 2 - Faturamento direto.
     */
    FATURAMENTO_DIRETO("2", "Faturamento direto"),
    /**
     * 3 - Venda direta.
     */
    VENDA_DIRETA("3", "Venda direta"),
    /**
     * 0 - Outros.
     */
    OUTROS("0", "Outros");

    private String code;

    private String description;

    private NFeVeiculoTipoOperacaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeVeiculoTipoOperacaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeVeiculoTipoOperacaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeVeiculoTipoOperacaoEnum> getAll() {
        return Arrays.asList(NFeVeiculoTipoOperacaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
