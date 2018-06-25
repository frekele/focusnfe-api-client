package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Unidade Federativa do Brasil.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeUnidadeFederativaEnum {

    /**
     * AC - Acre.
     */
    ACRE("AC", "Acre"),
    /**
     * AL - Alagoas.
     */
    ALAGOAS("AL", "Alagoas"),
    /**
     * AM - Amazonas.
     */
    AMAZONAS("AM", "Amazonas"),
    /**
     * AP - Amapá.
     */
    AMAPA("AP", "Amapá"),
    /**
     * BA - Bahia.
     */
    BAHIA("BA", "Bahia"),
    /**
     * CE - Ceará.
     */
    CEARA("CE", "Ceará"),
    /**
     * DF - Distrito Federal.
     */
    DISTRITO_FEDERAL("DF", "Distrito Federal"),
    /**
     * ES - Espírito Santo.
     */
    ESPIRITO_SANTO("ES", "Espírito Santo"),
    /**
     * GO - Goiás.
     */
    GOIAS("GO", "Goiás"),
    /**
     * MA - Maranhão.
     */
    MARANHAO("MA", "Maranhão"),
    /**
     * MG - Minas Gerais.
     */
    MINAS_GERAIS("MG", "Minas Gerais"),
    /**
     * MS - Mato Grosso do Sul.
     */
    MATO_GROSSO_SUL("MS", "Mato Grosso do Sul"),
    /**
     * MT - Mato Grosso.
     */
    MATO_GROSSO("MT", "Mato Grosso"),
    /**
     * PA - Pará.
     */
    PARA("PA", "Pará"),
    /**
     * PB - Paraíba.
     */
    PARAIBA("PB", "Paraíba"),
    /**
     * PE - Pernambuco.
     */
    PERNAMBUCO("PE", "Pernambuco"),
    /**
     * PI - Piauí.
     */
    PIAUI("PI", "Piauí"),
    /**
     * PR - Paraná.
     */
    PARANA("PR", "Paraná"),
    /**
     * RJ - Rio de Janeiro.
     */
    RIO_JANEIRO("RJ", "Rio de Janeiro"),
    /**
     * RN - Rio Grande do Norte.
     */
    RIO_GRANDE_DO_NORTE("RN", "Rio Grande do Norte"),
    /**
     * RO - Rondônia.
     */
    RONDONIA("RO", "Rondônia"),
    /**
     * RR - Roraima.
     */
    RORAIMA("RR", "Roraima"),
    /**
     * RS - Rio Grande do Sul.
     */
    RIO_GRANDE_DO_SUL("RS", "Rio Grande do Sul"),
    /**
     * SC - Santa Catarina.
     */
    SANTA_CATARINA("SC", "Santa Catarina"),
    /**
     * SE - Sergipe.
     */
    SERGIPE("SE", "Sergipe"),
    /**
     * SP - São Paulo.
     */
    SAO_PAULO("SP", "São Paulo"),
    /**
     * TO - Tocantins.
     */
    TOCANTINS("TO", "Tocantins"),
    /**
     * EX - Exterior.
     */
    EXTERIOR("EX", "Exterior");

    private String code;

    private String description;

    private NFeUnidadeFederativaEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeUnidadeFederativaEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeUnidadeFederativaEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeUnidadeFederativaEnum> getAll() {
        return Arrays.asList(NFeUnidadeFederativaEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
