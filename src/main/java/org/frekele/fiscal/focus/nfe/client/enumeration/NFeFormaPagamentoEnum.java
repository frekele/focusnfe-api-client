package org.frekele.fiscal.focus.nfe.client.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.util.Arrays;
import java.util.List;

/**
 * Forma de pagamento.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlType
@XmlEnum(String.class)
public enum NFeFormaPagamentoEnum {

    /**
     * 01 - Dinheiro.
     */
    DINHEIRO("01", "Dinheiro"),
    /**
     * 02 - Cheque.
     */
    CHEQUE("02", "Cheque"),
    /**
     * 03 - Cartão de Crédito.
     */
    CARTAO_DE_CREDITO("03", "Cartão de Crédito"),
    /**
     * 04 - Cartão de Débito.
     */
    CARTAO_DE_DEBITO("04", "Cartão de Débito"),
    /**
     * 05 - Crédito Loja.
     */
    CREDITO_LOJA("05", "Crédito Loja"),
    /**
     * 10 - Vale Alimentação.
     */
    VALE_ALIMENTACAO("10", "Vale Alimentação"),
    /**
     * 11 - Vale Refeição
     */
    VALE_REFEICAO("11", "Vale Refeição"),
    /**
     * 12 - Vale Presente.
     */
    VALE_PRESENTE("12", "Vale Presente"),
    /**
     * 13 - Vale Combustível.
     */
    VALE_COMBUSTIVEL("13", "Vale Combustível"),
    /**
     * 14 - Duplicata Mercantil.
     */
    DUPLICATA_MERCANTIL("14", "Duplicata Mercantil"),
    /**
     * 15 - Boleto Bancário.
     */
    BOLETO_BANCARIO("15", "Boleto Bancário"),
    /**
     * 90 - Sem pagamento.
     */
    SEM_PAGAMENTO("90", "Sem pagamento"),
    /**
     * 99 - Outros.
     */
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
