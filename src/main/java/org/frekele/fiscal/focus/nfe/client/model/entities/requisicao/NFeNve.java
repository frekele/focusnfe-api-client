package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

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
public class NFeNve implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Codificação opcional que detalha alguns NC<. Formato: duas letras maiúsculas e 4 algarismos
    @Size(max = 6)
    @JsonProperty("nve")
    private String nve;

    public NFeNve() {
        super();
    }

    public NFeNve(String nve) {
        this.nve = nve;
    }

    private NFeNve(Builder builder) {
        setNve(builder.nve);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNve() {
        return nve;
    }

    public void setNve(String nve) {
        this.nve = nve;
    }

    public static final class Builder {

        private String nve;

        private Builder() {
        }

        public Builder withNve(String val) {
            nve = val;
            return this;
        }

        public NFeNve build() {
            return new NFeNve(this);
        }
    }
}
