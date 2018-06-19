package org.frekele.fiscal.focus.nfe.client.model.request.mde;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.MDeTipoManifestacaoEnum;

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
public class MDeManifestarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Tipo da manifestação podendo ser ciencia, confirmacao, desconhecimento ou nao_realizada.
    @NotNull
    private MDeTipoManifestacaoEnum tipo;

    //Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
    @Size(min = 15, max = 255)
    private String justificativa;

    public MDeManifestarBodyRequest() {
        super();
    }

    private MDeManifestarBodyRequest(Builder builder) {
        setTipo(builder.tipo);
        setJustificativa(builder.justificativa);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public MDeTipoManifestacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(MDeTipoManifestacaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public static final class Builder {

        private MDeTipoManifestacaoEnum tipo;

        private String justificativa;

        private Builder() {
        }

        public Builder withTipo(MDeTipoManifestacaoEnum val) {
            tipo = val;
            return this;
        }

        public Builder withJustificativa(String val) {
            justificativa = val;
            return this;
        }

        public MDeManifestarBodyRequest build() {
            return new MDeManifestarBodyRequest(this);
        }
    }
}
