package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRastro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Número do lote do produto.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("numero_lote")
    private String numeroLote;

    /**
     * Quantidade de produtos no Lote.
     */
    @Digits(integer = 8, fraction = 3)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_lote")
    private BigDecimal quantidadeLote;

    /**
     * Data de Fabricaçao do medicamento.
     */
    @LocalDateJsonConverter
    @JsonProperty("data_fabricacao")
    private LocalDate dataFabricacao;

    /**
     * Data de Validade do medicamento.
     */
    @LocalDateJsonConverter
    @JsonProperty("data_validade")
    private LocalDate dataValidade;

    /**
     * Código de agregação.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("codigo_agregacao")
    private String codigoAgregacao;

    public NFeRastro() {
        super();
    }

    private NFeRastro(Builder builder) {
        setNumeroLote(builder.numeroLote);
        setQuantidadeLote(builder.quantidadeLote);
        setDataFabricacao(builder.dataFabricacao);
        setDataValidade(builder.dataValidade);
        setCodigoAgregacao(builder.codigoAgregacao);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Número do lote do produto.
     */
    public String getNumeroLote() {
        return numeroLote;
    }

    /**
     * Número do lote do produto.
     */
    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    /**
     * Quantidade de produtos no Lote.
     */
    public BigDecimal getQuantidadeLote() {
        return quantidadeLote;
    }

    /**
     * Quantidade de produtos no Lote.
     */
    public void setQuantidadeLote(BigDecimal quantidadeLote) {
        this.quantidadeLote = quantidadeLote;
    }

    /**
     * Data de Fabricaçao do medicamento.
     */
    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * Data de Fabricaçao do medicamento.
     */
    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * Data de Validade do medicamento.
     */
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    /**
     * Data de Validade do medicamento.
     */
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Código de agregação.
     */
    public String getCodigoAgregacao() {
        return codigoAgregacao;
    }

    /**
     * Código de agregação.
     */
    public void setCodigoAgregacao(String codigoAgregacao) {
        this.codigoAgregacao = codigoAgregacao;
    }

    /**
     * NFeRastro Builder Pattern.
     */
    public static final class Builder {

        private String numeroLote;

        private BigDecimal quantidadeLote;

        private LocalDate dataFabricacao;

        private LocalDate dataValidade;

        private String codigoAgregacao;

        private Builder() {
        }

        /**
         * Número do lote do produto.
         */
        public Builder withNumeroLote(String val) {
            numeroLote = val;
            return this;
        }

        /**
         * Quantidade de produtos no Lote.
         */
        public Builder withQuantidadeLote(BigDecimal val) {
            quantidadeLote = val;
            return this;
        }

        /**
         * Data de Fabricaçao do medicamento.
         */
        public Builder withDataFabricacao(LocalDate val) {
            dataFabricacao = val;
            return this;
        }

        /**
         * Data de Validade do medicamento.
         */
        public Builder withDataValidade(LocalDate val) {
            dataValidade = val;
            return this;
        }

        /**
         * Código de agregação.
         */
        public Builder withCodigoAgregacao(String val) {
            codigoAgregacao = val;
            return this;
        }

        public NFeRastro build() {
            return new NFeRastro(this);
        }
    }
}
