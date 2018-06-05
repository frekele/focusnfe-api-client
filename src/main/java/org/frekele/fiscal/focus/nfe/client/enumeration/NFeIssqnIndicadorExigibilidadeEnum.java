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
public enum NFeIssqnIndicadorExigibilidadeEnum {

    EXIGIVEL("1", "Exigível"),
    NAO_INCIDENCIA("2", "Não incidência"),
    ISENCAO("3", "Isenção"),
    EXPORTACAO("4", "Exportação"),
    IMUNIDADE("5", "Imunidade"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade Suspensa por Decisão Judicial"),
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7", "Exigibilidade Suspensa por Processo Administrativo");

    private String code;

    private String description;

    private NFeIssqnIndicadorExigibilidadeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeIssqnIndicadorExigibilidadeEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeIssqnIndicadorExigibilidadeEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeIssqnIndicadorExigibilidadeEnum> getAll() {
        return Arrays.asList(NFeIssqnIndicadorExigibilidadeEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
