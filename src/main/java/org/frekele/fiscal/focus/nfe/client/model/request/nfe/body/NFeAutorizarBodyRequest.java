package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.NFeRequisicao;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Dados nfe da requisicao para autorizacao.
    @JsonUnwrapped
    @NotNull
    private NFeRequisicao nfe;

    public NFeAutorizarBodyRequest() {
        super();
    }

    public NFeAutorizarBodyRequest(NFeRequisicao nfe) {
        this.nfe = nfe;
    }

    private NFeAutorizarBodyRequest(Builder builder) {
        setNfe(builder.nfe);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NFeRequisicao getNfe() {
        return nfe;
    }

    public void setNfe(NFeRequisicao nfe) {
        this.nfe = nfe;
    }

    public static final class Builder {

        private NFeRequisicao nfe;

        private Builder() {
        }

        public Builder withNfe(NFeRequisicao val) {
            nfe = val;
            return this;
        }

        public NFeAutorizarBodyRequest build() {
            return new NFeAutorizarBodyRequest(this);
        }
    }
}
