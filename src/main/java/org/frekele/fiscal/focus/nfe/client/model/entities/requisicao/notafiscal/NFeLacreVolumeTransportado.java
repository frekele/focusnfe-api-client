package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Lacre do volume transportado.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeLacreVolumeTransportado implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Número do lacre.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("numero")
    private String numero;

    public NFeLacreVolumeTransportado() {
        super();
    }

    public NFeLacreVolumeTransportado(String numero) {
        this.numero = numero;
    }

    private NFeLacreVolumeTransportado(Builder builder) {
        setNumero(builder.numero);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Número do lacre.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número do lacre.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * NFeLacreVolumeTransportado Builder Pattern.
     */
    public static final class Builder {

        private String numero;

        private Builder() {
        }

        /**
         * Número do lacre.
         */
        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public NFeLacreVolumeTransportado build() {
            return new NFeLacreVolumeTransportado(this);
        }
    }
}
