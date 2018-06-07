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
public enum NFeUnidadeFederativaEnum {

    ACRE("AC", "Acre"),
    ALAGOAS("AL", "Alagoas"),
    AMAZONAS("AM", "Amazonas"),
    AMAPA("AP", "Amapá"),
    BAHIA("BA", "Bahia"),
    CEARA("CE", "Ceará"),
    DISTRITO_FEDERAL("DF", "Distrito Federal"),
    ESPIRITO_SANTO("ES", "Espírito Santo"),
    GOIAS("GO", "Goiás"),
    MARANHAO("MA", "Maranhão"),
    MINAS_GERAIS("MG", "Minas Gerais"),
    MATO_GROSSO_SUL("MS", "Mato Grosso do Sul"),
    MATO_GROSSO("MT", "Mato Grosso"),
    PARA("PA", "Pará"),
    PARAIBA("PB", "Paraíba"),
    PERNAMBUCO("PE", "Pernambuco"),
    PIAUI("PI", "Piauí"),
    PARANA("PR", "Paraná"),
    RIO_JANEIRO("RJ", "Rio de Janeiro"),
    RIO_GRANDE_DO_NORTE("RN", "Rio Grande do Norte"),
    RONDONIA("RO", "Rondônia"),
    RORAIMA("RR", "Roraima"),
    RIO_GRANDE_DO_SUL("RS", "Rio Grande do Sul"),
    SANTA_CATARINA("SC", "Santa Catarina"),
    SERGIPE("SE", "Sergipe"),
    SAO_PAULO("SP", "São Paulo"),
    TOCANTINS("TO", "Tocantins"),
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
