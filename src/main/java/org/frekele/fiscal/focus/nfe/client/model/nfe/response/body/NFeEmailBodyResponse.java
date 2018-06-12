package org.frekele.fiscal.focus.nfe.client.model.nfe.response.body;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.error.NFeError;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeEmailBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeError error;

    public NFeEmailBodyResponse() {
        super();
    }

    private NFeEmailBodyResponse(Builder builder) {
        setError(builder.error);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NFeError getError() {
        return error;
    }

    public void setError(NFeError error) {
        this.error = error;
    }

    public static final class Builder {

        private NFeError error;

        private Builder() {
        }

        public Builder withError(NFeError val) {
            error = val;
            return this;
        }

        public NFeEmailBodyResponse build() {
            return new NFeEmailBodyResponse(this);
        }
    }
}
