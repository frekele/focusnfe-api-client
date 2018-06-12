package org.frekele.fiscal.focus.nfe.client.model.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

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
public class NFeAdicaoDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número da adição.
    @Size(min = 1, max = 3)
    @JsonProperty("numero")
    private String numero;

    //Número sequencial do item dentro da adição.
    @Size(min = 1, max = 3)
    @JsonProperty("numero_sequencial_item")
    private String numeroSequencialItem;

    //Código interno do fabricante estrangeiro.
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_fabricante_estrangeiro")
    private String codigoFabricanteEstrangeiro;

    //Valor do desconto do item na adição.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    //Número do ato concessório de Drawback.
    @Size(max = 11)
    @JsonProperty("numero_drawback")
    private String numeroDrawback;

    public NFeAdicaoDocumentoImportacao() {
        super();
    }

    private NFeAdicaoDocumentoImportacao(Builder builder) {
        setNumero(builder.numero);
        setNumeroSequencialItem(builder.numeroSequencialItem);
        setCodigoFabricanteEstrangeiro(builder.codigoFabricanteEstrangeiro);
        setValorDesconto(builder.valorDesconto);
        setNumeroDrawback(builder.numeroDrawback);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroSequencialItem() {
        return numeroSequencialItem;
    }

    public void setNumeroSequencialItem(String numeroSequencialItem) {
        this.numeroSequencialItem = numeroSequencialItem;
    }

    public String getCodigoFabricanteEstrangeiro() {
        return codigoFabricanteEstrangeiro;
    }

    public void setCodigoFabricanteEstrangeiro(String codigoFabricanteEstrangeiro) {
        this.codigoFabricanteEstrangeiro = codigoFabricanteEstrangeiro;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getNumeroDrawback() {
        return numeroDrawback;
    }

    public void setNumeroDrawback(String numeroDrawback) {
        this.numeroDrawback = numeroDrawback;
    }

    public static final class Builder {

        private String numero;

        private String numeroSequencialItem;

        private String codigoFabricanteEstrangeiro;

        private BigDecimal valorDesconto;

        private String numeroDrawback;

        private Builder() {
        }

        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public Builder withNumeroSequencialItem(String val) {
            numeroSequencialItem = val;
            return this;
        }

        public Builder withCodigoFabricanteEstrangeiro(String val) {
            codigoFabricanteEstrangeiro = val;
            return this;
        }

        public Builder withValorDesconto(BigDecimal val) {
            valorDesconto = val;
            return this;
        }

        public Builder withNumeroDrawback(String val) {
            numeroDrawback = val;
            return this;
        }

        public NFeAdicaoDocumentoImportacao build() {
            return new NFeAdicaoDocumentoImportacao(this);
        }
    }
}
