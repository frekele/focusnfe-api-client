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
public enum NFeIcmsMotivoDesoneracaoEnum {

    TAXI("1", "Táxi"),
    PRODUTOR_AGROPECUARIO("3", "Produtor agropecuário"),
    FROTISTA_LOCADORA("4", "Frotista/locadora"),
    DIPLOMATICO_CONSULAR("5", "Diplomático/consular"),
    UTILITARIOS_MOTOCICLETAS_DA_AMAZONIA_OCIDENTAL("6", "Utilitários e motocicletas da Amazônia Ocidental e áreas de livre comercio (resolucao 714/88 e 790/94 – CONTRAN e suas alterações)"),
    SUFRAMA("7", "SUFRAMA"),
    OUTROS("9", "Outros"),
    DEFICIENTE_CONDUTOR("10", "Deficiente condutor"),
    DEFICIENTE_NAO_CONDUTOR("11", "Deficiente não condutor"),
    ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", "Órgão de fomento e desenvolvimento agropecuário"),
    OLIMPIADAS_RIO_2016("16", "Olimpíadas Rio 2016");

    private String code;

    private String description;

    private NFeIcmsMotivoDesoneracaoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIcmsMotivoDesoneracaoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIcmsMotivoDesoneracaoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIcmsMotivoDesoneracaoEnum> getAll() {
        return Arrays.asList(NFeIcmsMotivoDesoneracaoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
