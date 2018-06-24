package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request Body Cancelar NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFCeCancelarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
     */
    @NotNull
    @Size(min = 15, max = 255)
    private String justificativa;

    public NFCeCancelarBodyRequest() {
        super();
    }

    public NFCeCancelarBodyRequest(String justificativa) {
        this.justificativa = justificativa;
    }

    private NFCeCancelarBodyRequest(Builder builder) {
        setJustificativa(builder.justificativa);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * NFCeCancelarBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private String justificativa;

        private Builder() {
        }

        /**
         * Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
         */
        public Builder withJustificativa(String val) {
            justificativa = val;
            return this;
        }

        public NFCeCancelarBodyRequest build() {
            return new NFCeCancelarBodyRequest(this);
        }
    }
}
