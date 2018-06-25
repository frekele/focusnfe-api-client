package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Tipo de Integração para pagamento.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeTipoIntegracaoEnum {

    /**
     * 1 - Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico) - Obrigatorio informar cnpj_credenciadora e numero_autorizacao.
     */
    PAGAMENTO_INTEGRADO_COM_SISTEMA_DE_AUTOMACAO("1", "Pagamento integrado com o sistema de automação da empresa (Ex.: equipamento TEF, Comércio Eletrônico) - Obrigatorio informar cnpj_credenciadora e numero_autorizacao"),
    /**
     * 2 - Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS).
     */
    PAGAMENTO_NAO_INTEGRADO_COM_SISTEMA_DE_AUTOMACAO("2", "Pagamento não integrado com o sistema de automação da empresa (Ex.: equipamento POS)");

    private String code;

    private String description;

    private NFeTipoIntegracaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeTipoIntegracaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeTipoIntegracaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeTipoIntegracaoEnum> getAll() {
        return Arrays.asList(NFeTipoIntegracaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
