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
public enum NFeFormaPagamentoEnum {

    DINHEIRO("01", "Dinheiro"),
    CHEQUE("02", "Cheque"),
    CARTAO_DE_CREDITO("03", "Cartão de Crédito"),
    CARTAO_DE_DEBITO("04", "Cartão de Débito"),
    CREDITO_LOJA("05", "Crédito Loja"),
    VALE_ALIMENTACAO("10", "Vale Alimentação"),
    VALE_REFEICAO("11", "Vale Refeição"),
    VALE_PRESENTE("12", "Vale Presente"),
    VALE_COMBUSTIVEL("13", "Vale Combustível"),
    DUPLICATA_MERCANTIL("14", "Duplicata Mercantil"),
    BOLETO_BANCARIO("15", "Boleto Bancário"),
    SEM_PAGAMENTO("90", "Sem pagamento"),
    OUTROS("99", "Outros");

    private String code;

    private String description;

    private NFeFormaPagamentoEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    @XmlValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static NFeFormaPagamentoEnum fromCode(String value) {
        if (value != null && value.length() != 0) {
            for (NFeFormaPagamentoEnum obj : getAll()) {
                if (obj.code.equals(value)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static List<NFeFormaPagamentoEnum> getAll() {
        return Arrays.asList(NFeFormaPagamentoEnum.values());
    }

    public String getDescription() {
        return description;
    }
}
