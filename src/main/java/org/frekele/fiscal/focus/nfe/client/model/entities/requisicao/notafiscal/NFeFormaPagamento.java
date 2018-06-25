package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

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
 * Forma de pagamento para NF-e e NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeFormaPagamento implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Forma de pagamento.
     */
    @JsonProperty("forma_pagamento")
    private NFeFormaPagamentoEnum formaPagamento;

    /**
     * Valor do pagamento.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pagamento")
    private BigDecimal valorPagamento;

    /**
     * Tipo de Integração para pagamento.
     */
    @JsonProperty("tipo_integracao")
    private NFeTipoIntegracaoEnum tipoIntegracao;

    /**
     * CNPJ da Credenciadora de cartão de crédito e/ou débito.
     */
    @Size(max = 14)
    @JsonProperty("cnpj_credenciadora")
    private String cnpjCredenciadora;

    /**
     * Bandeira da operadora de cartão de crédito e/ou débito.
     */
    @JsonProperty("bandeira_operadora")
    private NFeBandeiraOperadoraEnum bandeiraOperadora;

    /**
     * Número de autorização da operação cartão de crédito e/ou débito.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("numero_autorizacao")
    private String numeroAutorizacao;

    /**
     * Valor do troco.
     */
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

    /**
     * Forma de pagamento.
     */
    public NFeFormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * Forma de pagamento.
     */
    public void setFormaPagamento(NFeFormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * Valor do pagamento.
     */
    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    /**
     * Valor do pagamento.
     */
    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    /**
     * Tipo de Integração para pagamento.
     */
    public NFeTipoIntegracaoEnum getTipoIntegracao() {
        return tipoIntegracao;
    }

    /**
     * Tipo de Integração para pagamento.
     */
    public void setTipoIntegracao(NFeTipoIntegracaoEnum tipoIntegracao) {
        this.tipoIntegracao = tipoIntegracao;
    }

    /**
     * CNPJ da Credenciadora de cartão de crédito e/ou débito.
     */
    public String getCnpjCredenciadora() {
        return cnpjCredenciadora;
    }

    /**
     * CNPJ da Credenciadora de cartão de crédito e/ou débito.
     */
    public void setCnpjCredenciadora(String cnpjCredenciadora) {
        this.cnpjCredenciadora = cnpjCredenciadora;
    }

    /**
     * Bandeira da operadora de cartão de crédito e/ou débito.
     */
    public NFeBandeiraOperadoraEnum getBandeiraOperadora() {
        return bandeiraOperadora;
    }

    /**
     * Bandeira da operadora de cartão de crédito e/ou débito.
     */
    public void setBandeiraOperadora(NFeBandeiraOperadoraEnum bandeiraOperadora) {
        this.bandeiraOperadora = bandeiraOperadora;
    }

    /**
     * Número de autorização da operação cartão de crédito e/ou débito.
     */
    public String getNumeroAutorizacao() {
        return numeroAutorizacao;
    }

    /**
     * Número de autorização da operação cartão de crédito e/ou débito.
     */
    public void setNumeroAutorizacao(String numeroAutorizacao) {
        this.numeroAutorizacao = numeroAutorizacao;
    }

    /**
     * Valor do troco.
     */
    public BigDecimal getValorTroco() {
        return valorTroco;
    }

    /**
     * Valor do troco.
     */
    public void setValorTroco(BigDecimal valorTroco) {
        this.valorTroco = valorTroco;
    }

    /**
     * NFeFormaPagamento Builder Pattern.
     */
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

        /**
         * Forma de pagamento.
         */
        public Builder withFormaPagamento(NFeFormaPagamentoEnum val) {
            formaPagamento = val;
            return this;
        }

        /**
         * Valor do pagamento.
         */
        public Builder withValorPagamento(BigDecimal val) {
            valorPagamento = val;
            return this;
        }

        /**
         * Tipo de Integração para pagamento.
         */
        public Builder withTipoIntegracao(NFeTipoIntegracaoEnum val) {
            tipoIntegracao = val;
            return this;
        }

        /**
         * CNPJ da Credenciadora de cartão de crédito e/ou débito.
         */
        public Builder withCnpjCredenciadora(String val) {
            cnpjCredenciadora = val;
            return this;
        }

        /**
         * Bandeira da operadora de cartão de crédito e/ou débito.
         */
        public Builder withBandeiraOperadora(NFeBandeiraOperadoraEnum val) {
            bandeiraOperadora = val;
            return this;
        }

        /**
         * Número de autorização da operação cartão de crédito e/ou débito.
         */
        public Builder withNumeroAutorizacao(String val) {
            numeroAutorizacao = val;
            return this;
        }

        /**
         * Valor do troco.
         */
        public Builder withValorTroco(BigDecimal val) {
            valorTroco = val;
            return this;
        }

        public NFeFormaPagamento build() {
            return new NFeFormaPagamento(this);
        }
    }
}
