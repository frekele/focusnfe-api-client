package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRastro implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do lote do produto
    @Size(min = 1, max = 20)
    @JsonProperty("numero_lote")
    private String numeroLote;

    //Quantidade de produtos no Lote.
    @Digits(integer = 8, fraction = 3)
    @JsonProperty("quantidade_lote")
    private String quantidadeLote;

    //Data de Fabricaçao do medicamento
    @LocalDateJsonConverter
    @JsonProperty("data_fabricacao")
    private LocalDate dataFabricacao;

    //Data de Validade do medicamento
    @LocalDateJsonConverter
    @JsonProperty("data_validade")
    private LocalDate dataValidade;

    //Código de agregação
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

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getQuantidadeLote() {
        return quantidadeLote;
    }

    public void setQuantidadeLote(String quantidadeLote) {
        this.quantidadeLote = quantidadeLote;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCodigoAgregacao() {
        return codigoAgregacao;
    }

    public void setCodigoAgregacao(String codigoAgregacao) {
        this.codigoAgregacao = codigoAgregacao;
    }

    public static final class Builder {

        private String numeroLote;

        private String quantidadeLote;

        private LocalDate dataFabricacao;

        private LocalDate dataValidade;

        private String codigoAgregacao;

        private Builder() {
        }

        public Builder withNumeroLote(String val) {
            numeroLote = val;
            return this;
        }

        public Builder withQuantidadeLote(String val) {
            quantidadeLote = val;
            return this;
        }

        public Builder withDataFabricacao(LocalDate val) {
            dataFabricacao = val;
            return this;
        }

        public Builder withDataValidade(LocalDate val) {
            dataValidade = val;
            return this;
        }

        public Builder withCodigoAgregacao(String val) {
            codigoAgregacao = val;
            return this;
        }

        public NFeRastro build() {
            return new NFeRastro(this);
        }
    }
}
