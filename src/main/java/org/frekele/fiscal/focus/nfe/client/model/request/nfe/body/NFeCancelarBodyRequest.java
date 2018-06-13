package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class NFeCancelarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
    @NotNull
    @Size(min = 15, max = 255)
    private String justificativa;

    public NFeCancelarBodyRequest() {
        super();
    }

    public NFeCancelarBodyRequest(String justificativa) {
        this.justificativa = justificativa;
    }

    private NFeCancelarBodyRequest(Builder builder) {
        setJustificativa(builder.justificativa);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public static final class Builder {

        private String justificativa;

        private Builder() {
        }

        public Builder withJustificativa(String val) {
            justificativa = val;
            return this;
        }

        public NFeCancelarBodyRequest build() {
            return new NFeCancelarBodyRequest(this);
        }
    }
}
