package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

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
public class NFeDetalheExportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número do ato concessório de Drawback
    @Size(max = 11)
    @JsonProperty("numero_drawback")
    private String numeroDrawback;

    //Número do Registro de Exportação
    @Size(max = 12)
    @JsonProperty("numero_re")
    private String numeroRe;

    //Chave de Acesso da NF-e recebida para exportação
    @Size(max = 44)
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //Quantidade do item efetivamente exportado
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_exportado")
    private BigDecimal quantidadeExportado;

    public NFeDetalheExportacao() {
        super();
    }

    private NFeDetalheExportacao(Builder builder) {
        setNumeroDrawback(builder.numeroDrawback);
        setNumeroRe(builder.numeroRe);
        setChaveNfe(builder.chaveNfe);
        setQuantidadeExportado(builder.quantidadeExportado);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNumeroDrawback() {
        return numeroDrawback;
    }

    public void setNumeroDrawback(String numeroDrawback) {
        this.numeroDrawback = numeroDrawback;
    }

    public String getNumeroRe() {
        return numeroRe;
    }

    public void setNumeroRe(String numeroRe) {
        this.numeroRe = numeroRe;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public BigDecimal getQuantidadeExportado() {
        return quantidadeExportado;
    }

    public void setQuantidadeExportado(BigDecimal quantidadeExportado) {
        this.quantidadeExportado = quantidadeExportado;
    }

    public static final class Builder {

        private String numeroDrawback;

        private String numeroRe;

        private String chaveNfe;

        private BigDecimal quantidadeExportado;

        private Builder() {
        }

        public Builder withNumeroDrawback(String val) {
            numeroDrawback = val;
            return this;
        }

        public Builder withNumeroRe(String val) {
            numeroRe = val;
            return this;
        }

        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        public Builder withQuantidadeExportado(BigDecimal val) {
            quantidadeExportado = val;
            return this;
        }

        public NFeDetalheExportacao build() {
            return new NFeDetalheExportacao(this);
        }
    }
}
