package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

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
public class NFeDuplicataNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número.
    @Size(min = 1, max = 60)
    @JsonProperty("numero")
    private String numero;

    //Data de vencimento.
    @LocalDateJsonConverter
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    //Valor.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor")
    private BigDecimal valor;

    public NFeDuplicataNotaFiscal() {
        super();
    }

    public NFeDuplicataNotaFiscal(String numero, LocalDate dataVencimento, BigDecimal valor) {
        this.numero = numero;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    private NFeDuplicataNotaFiscal(Builder builder) {
        setNumero(builder.numero);
        setDataVencimento(builder.dataVencimento);
        setValor(builder.valor);
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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public static final class Builder {

        private String numero;

        private LocalDate dataVencimento;

        private BigDecimal valor;

        private Builder() {
        }

        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public Builder withDataVencimento(LocalDate val) {
            dataVencimento = val;
            return this;
        }

        public Builder withValor(BigDecimal val) {
            valor = val;
            return this;
        }

        public NFeDuplicataNotaFiscal build() {
            return new NFeDuplicataNotaFiscal(this);
        }
    }
}
