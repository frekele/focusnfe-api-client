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
public enum NFePresencaCompradorEnum {

    NAO_SE_APLICA("0", "Não se aplica (por exemplo, para a Nota Fiscal complementar ou de ajuste)"),
    OPERACAO_PRESENCIAL("1", "Operação presencial"),
    OPERACAO_NAO_PRESENCIAL_PELA_INTERNET("2", "Operação não presencial, pela Internet"),
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3", "Operação não presencial, Teleatendimento"),
    OPERACAO_COM_NFCE_ENTREGA_DOMICILIO("4", "NFC-e em operação com entrega em domicílio"),
    OPERACAO_NAO_PRESENCIAL_OUTROS("9", "Operação não presencial, outros");

    private String code;

    private String description;

    private NFePresencaCompradorEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFePresencaCompradorEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFePresencaCompradorEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFePresencaCompradorEnum> getAll() {
        return Arrays.asList(NFePresencaCompradorEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
