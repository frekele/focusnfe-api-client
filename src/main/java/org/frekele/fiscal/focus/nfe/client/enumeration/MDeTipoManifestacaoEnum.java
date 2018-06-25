package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Situação atual da manifestação MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum MDeTipoManifestacaoEnum {

    /**
     * Significa que a operação é conhecida pela empresa, mas ainda não há informações suficientes para saber se ela foi concluída ou não.
     */
    CIENCIA("ciencia", "Ciência da operação"),
    /**
     * Significa que a operação é conhecida e foi realizada com sucesso.
     */
    CONFIRMACAO("confirmacao", "Operação realizada"),
    /**
     * Significa que a empresa não reconhece a nota fiscal emitida.
     */
    DESCONHECIMENTO("desconhecimento", "Desconhecimento da operação"),
    /**
     * Significa que a operação é conhecida e por algum motivo não foi realizada.
     */
    NAO_REALIZADA("nao_realizada", "Operação não realizada");

    private String code;

    private String description;

    private MDeTipoManifestacaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static MDeTipoManifestacaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (MDeTipoManifestacaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<MDeTipoManifestacaoEnum> getAll() {
        return Arrays.asList(MDeTipoManifestacaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
