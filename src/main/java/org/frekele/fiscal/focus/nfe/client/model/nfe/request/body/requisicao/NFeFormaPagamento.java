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

    private NFeFormaPagamento(Builder builder) {
        setFormaPagamento(builder.formaPagamento);
        setValorPagamento(builder.valorPagamento);
        setTipoIntegracao(builder.tipoIntegracao);
        setCnpjCredenciadora(builder.cnpjCredenciadora);
        setBandeiraOperadora(builder.bandeiraOperadora);
        setNumeroAutorizacao(builder.numeroAutorizacao);
        setValorTroco(builder.valorTroco);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NFeFormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(NFeFormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public NFeTipoIntegracaoEnum getTipoIntegracao() {
        return tipoIntegracao;
    }

    public void setTipoIntegracao(NFeTipoIntegracaoEnum tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

    public String getCnpjCredenciadora() {
        return cnpjCredenciadora;
    }

    public void setCnpjCredenciadora(String cnpjCredenciadora) {
        this.cnpjCredenciadora = cnpjCredenciadora;
    }

    public NFeBandeiraOperadoraEnum getBandeiraOperadora() {
        return bandeiraOperadora;
    }

    public void setBandeiraOperadora(NFeBandeiraOperadoraEnum bandeiraOperadora) {
        this.bandeiraOperadora = bandeiraOperadora;
    }

    public String getNumeroAutorizacao() {
        return numeroAutorizacao;
    }

    public void setNumeroAutorizacao(String numeroAutorizacao) {
        this.numeroAutorizacao = numeroAutorizacao;
    }

    public BigDecimal getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(BigDecimal valorTroco) {
        this.valorTroco = valorTroco;
    }

    public static final class Builder {

        private NFeFormaPagamentoEnum formaPagamento;

        private BigDecimal valorPagamento;

        private NFeTipoIntegracaoEnum tipoIntegracao;

        private String cnpjCredenciadora;

        private NFeBandeiraOperadoraEnum bandeiraOperadora;

        private String numeroAutorizacao;

        private BigDecimal valorTroco;

        private Builder() {
        }

        public Builder withFormaPagamento(NFeFormaPagamentoEnum val) {
            formaPagamento = val;
            return this;
        }

        public Builder withValorPagamento(BigDecimal val) {
            valorPagamento = val;
            return this;
        }

        public Builder withTipoIntegracao(NFeTipoIntegracaoEnum val) {
            tipoIntegracao = val;
            return this;
        }

        public Builder withCnpjCredenciadora(String val) {
            cnpjCredenciadora = val;
            return this;
        }

        public Builder withBandeiraOperadora(NFeBandeiraOperadoraEnum val) {
            bandeiraOperadora = val;
            return this;
        }

        public Builder withNumeroAutorizacao(String val) {
            numeroAutorizacao = val;
            return this;
        }

        public Builder withValorTroco(BigDecimal val) {
            valorTroco = val;
            return this;
        }

        public NFeFormaPagamento build() {
            return new NFeFormaPagamento(this);
        }
    }
}
