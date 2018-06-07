package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeInutilizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //CNPJ da empresa emitente
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    //Série da numeração da NFe que terá uma faixa de numeração inutilizada
    @NotNull
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    //Número inicial a ser inutilizado
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_inicial")
    private String numeroInicial;

    //Número final a ser inutilizado
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_final")
    private String numeroFinal;

    //Justificativa da inutilização (mínimo 15 caracteres)
    @NotNull
    @Size(min = 15, max = 255)
    @JsonProperty("justificativa")
    private String justificativa;

    public NFeInutilizarBodyRequest() {
        super();
    }

    public NFeInutilizarBodyRequest(String cnpj, String serie, String numeroInicial, String numeroFinal, String justificativa) {
        this.cnpj = cnpj;
        this.serie = serie;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
        this.justificativa = justificativa;
    }

    private NFeInutilizarBodyRequest(Builder builder) {
        setCnpj(builder.cnpj);
        setSerie(builder.serie);
        setNumeroInicial(builder.numeroInicial);
        setNumeroFinal(builder.numeroFinal);
        setJustificativa(builder.justificativa);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(String numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public String getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(String numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public static final class Builder {

        private String cnpj;

        private String serie;

        private String numeroInicial;

        private String numeroFinal;

        private String justificativa;

        private Builder() {
        }

        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        public Builder withNumeroInicial(String val) {
            numeroInicial = val;
            return this;
        }

        public Builder withNumeroFinal(String val) {
            numeroFinal = val;
            return this;
        }

        public Builder withJustificativa(String val) {
            justificativa = val;
            return this;
        }

        public NFeInutilizarBodyRequest build() {
            return new NFeInutilizarBodyRequest(this);
        }
    }
}
