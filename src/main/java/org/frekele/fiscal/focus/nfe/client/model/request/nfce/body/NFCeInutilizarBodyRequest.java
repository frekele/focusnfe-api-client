package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request Body Inutilizar NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFCeInutilizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * CNPJ da empresa emitente.
     */
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    @NotNull
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    /**
     * Número inicial a ser inutilizado.
     */
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_inicial")
    private String numeroInicial;

    /**
     * Número final a ser inutilizado.
     */
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_final")
    private String numeroFinal;

    /**
     * Justificativa da inutilização (mínimo 15 caracteres).
     */
    @NotNull
    @Size(min = 15, max = 255)
    @JsonProperty("justificativa")
    private String justificativa;

    public NFCeInutilizarBodyRequest() {
        super();
    }

    public NFCeInutilizarBodyRequest(String cnpj, String serie, String numeroInicial, String numeroFinal, String justificativa) {
        this.cnpj = cnpj;
        this.serie = serie;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
        this.justificativa = justificativa;
    }

    private NFCeInutilizarBodyRequest(Builder builder) {
        setCnpj(builder.cnpj);
        setSerie(builder.serie);
        setNumeroInicial(builder.numeroInicial);
        setNumeroFinal(builder.numeroFinal);
        setJustificativa(builder.justificativa);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * CNPJ da empresa emitente.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * CNPJ da empresa emitente.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Número inicial a ser inutilizado.
     */
    public String getNumeroInicial() {
        return numeroInicial;
    }

    /**
     * Número inicial a ser inutilizado.
     */
    public void setNumeroInicial(String numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    /**
     * Número final a ser inutilizado.
     */
    public String getNumeroFinal() {
        return numeroFinal;
    }

    /**
     * Número final a ser inutilizado.
     */
    public void setNumeroFinal(String numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    /**
     * Justificativa da inutilização (mínimo 15 caracteres).
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * Justificativa da inutilização (mínimo 15 caracteres).
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * NFCeInutilizarBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private String cnpj;

        private String serie;

        private String numeroInicial;

        private String numeroFinal;

        private String justificativa;

        private Builder() {
        }

        /**
         * CNPJ da empresa emitente.
         */
        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        /**
         * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
         */
        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        /**
         * Número inicial a ser inutilizado.
         */
        public Builder withNumeroInicial(String val) {
            numeroInicial = val;
            return this;
        }

        /**
         * Número final a ser inutilizado.
         */
        public Builder withNumeroFinal(String val) {
            numeroFinal = val;
            return this;
        }

        /**
         * Justificativa da inutilização (mínimo 15 caracteres).
         */
        public Builder withJustificativa(String val) {
            justificativa = val;
            return this;
        }

        public NFCeInutilizarBodyRequest build() {
            return new NFCeInutilizarBodyRequest(this);
        }
    }
}
