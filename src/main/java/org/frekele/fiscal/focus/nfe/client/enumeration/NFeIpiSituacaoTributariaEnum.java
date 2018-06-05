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
public enum NFeIpiSituacaoTributariaEnum {

    ENTRADA_COM_RECUPERACAO_DE_CREDITO("00", "Entrada com recuperação de crédito"),
    ENTRADA_TRIBUTADA_COM_ALIQUODTA_ZERO("01", "Entrada tributada com alíquota zero"),
    ENTRADA_ISENTA("02", "Entrada isenta"),
    ENTRADA_NAO_TRIBUTADA("03", "Entrada não-tributada"),
    ENTRADA_IMUNE("04", "Entrada imune"),
    ENTRADA_COM_SUSPENSAO("05", "Entrada com suspensão"),
    OUTRAS_ENTRADAS("49", "Outras entradas"),
    SAIDA_TRIBUTADA("50", "Saída tributada"),
    SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO("51", "Saída tributada com alíquota zero"),
    SAIDA_ISENTA("52", "Saída isenta"),
    SAIDA_NAO_TRIBUTADA("53", "Saída não-tributada"),
    SAIDA_IMUNE("54", "Saída imune"),
    SAIDA_COM_SUSPENSAO("55", "Saída com suspensão"),
    OUTRAS_SAIDAS("99", "Outras saídas");

    private String code;

    private String description;

    private NFeIpiSituacaoTributariaEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIpiSituacaoTributariaEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIpiSituacaoTributariaEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIpiSituacaoTributariaEnum> getAll() {
        return Arrays.asList(NFeIpiSituacaoTributariaEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
