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

    /**
     * 1 - Exigível.
     */
    EXIGIVEL("1", "Exigível"),
    /**
     * 2 - Não incidência.
     */
    NAO_INCIDENCIA("2", "Não incidência"),
    /**
     * 3 - Isenção.
     */
    ISENCAO("3", "Isenção"),
    /**
     * 4 - Exportação.
     */
    EXPORTACAO("4", "Exportação"),
    /**
     * 5 - Imunidade.
     */
    IMUNIDADE("5", "Imunidade"),
    /**
     * 6 - Exigibilidade Suspensa por Decisão Judicial.
     */
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade Suspensa por Decisão Judicial"),
    /**
     * 7- Exigibilidade Suspensa por Processo Administrativo.
     */
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
