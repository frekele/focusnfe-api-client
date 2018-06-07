package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeBandeiraOperadoraEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaPagamentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoIntegracaoEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeFormaPagamento implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Forma de pagamento
    @JsonProperty("forma_pagamento")
    private NFeFormaPagamentoEnum formaPagamento;

    //Valor do pagamento
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pagamento")
    private BigDecimal valorPagamento;

    //Tipo de Integração para pagamento
    @JsonProperty("tipo_integracao")
    private NFeTipoIntegracaoEnum tipoIntegracao;

    //CNPJ da Credenciadora de cartão de crédito e/ou débito
    @Size(max = 14)
    @JsonProperty("cnpj_credenciadora")
    private String cnpjCredenciadora;

    //Bandeira da operadora de cartão de crédito e/ou débito
    @JsonProperty("bandeira_operadora")
    private NFeBandeiraOperadoraEnum bandeiraOperadora;

    //Número de autorização da operação cartão de crédito e/ou débito
    @Size(min = 1, max = 20)
    @JsonProperty("numero_autorizacao")
    private String numeroAutorizacao;

    //Valor do troco
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_troco")
    private BigDecimal valorTroco;

    public NFeFormaPagamento() {
        super();
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
}
