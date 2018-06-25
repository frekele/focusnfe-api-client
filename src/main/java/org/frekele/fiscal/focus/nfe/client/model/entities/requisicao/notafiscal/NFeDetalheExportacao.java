package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

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
 * Detalhe de exportação.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDetalheExportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Número do ato concessório de Drawback.
     */
    @Size(max = 11)
    @JsonProperty("numero_drawback")
    private String numeroDrawback;

    /**
     * Número do Registro de Exportação.
     */
    @Size(max = 12)
    @JsonProperty("numero_re")
    private String numeroRe;

    /**
     * Chave de Acesso da NF-e recebida para exportação.
     */
    @Size(max = 44)
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    /**
     * Quantidade do item efetivamente exportado.
     */
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

    /**
     * Número do ato concessório de Drawback.
     */
    public String getNumeroDrawback() {
        return numeroDrawback;
    }

    /**
     * Número do ato concessório de Drawback.
     */
    public void setNumeroDrawback(String numeroDrawback) {
        this.numeroDrawback = numeroDrawback;
    }

    /**
     * Número do Registro de Exportação.
     */
    public String getNumeroRe() {
        return numeroRe;
    }

    /**
     * Número do Registro de Exportação.
     */
    public void setNumeroRe(String numeroRe) {
        this.numeroRe = numeroRe;
    }

    /**
     * Chave de Acesso da NF-e recebida para exportação.
     */
    public String getChaveNfe() {
        return chaveNfe;
    }

    /**
     * Chave de Acesso da NF-e recebida para exportação.
     */
    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    /**
     * Quantidade do item efetivamente exportado.
     */
    public BigDecimal getQuantidadeExportado() {
        return quantidadeExportado;
    }

    /**
     * Quantidade do item efetivamente exportado.
     */
    public void setQuantidadeExportado(BigDecimal quantidadeExportado) {
        this.quantidadeExportado = quantidadeExportado;
    }

    /**
     * NFeDetalheExportacao Builder Pattern.
     */
    public static final class Builder {

        private String numeroDrawback;

        private String numeroRe;

        private String chaveNfe;

        private BigDecimal quantidadeExportado;

        private Builder() {
        }

        /**
         * Número do ato concessório de Drawback.
         */
        public Builder withNumeroDrawback(String val) {
            numeroDrawback = val;
            return this;
        }

        /**
         * Número do Registro de Exportação.
         */
        public Builder withNumeroRe(String val) {
            numeroRe = val;
            return this;
        }

        /**
         * Chave de Acesso da NF-e recebida para exportação.
         */
        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        /**
         * Quantidade do item efetivamente exportado.
         */
        public Builder withQuantidadeExportado(BigDecimal val) {
            quantidadeExportado = val;
            return this;
        }

        public NFeDetalheExportacao build() {
            return new NFeDetalheExportacao(this);
        }
    }
}
