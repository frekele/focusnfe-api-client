package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeEnvioRequisicaoNotaFiscal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Request Body Autorizar NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    @JsonUnwrapped
    @NotNull
    private NFeEnvioRequisicaoNotaFiscal nfe;

    public NFeAutorizarBodyRequest() {
        super();
    }

    public NFeAutorizarBodyRequest(NFeEnvioRequisicaoNotaFiscal nfe) {
        this.nfe = nfe;
    }

    private NFeAutorizarBodyRequest(Builder builder) {
        setNfe(builder.nfe);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    public NFeEnvioRequisicaoNotaFiscal getNfe() {
        return nfe;
    }

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    public void setNfe(NFeEnvioRequisicaoNotaFiscal nfe) {
        this.nfe = nfe;
    }

    /**
     * NFeAutorizarBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private NFeEnvioRequisicaoNotaFiscal nfe;

        private Builder() {
        }

        /**
         * Dados nfe da requisicao para autorizacao.
         */
        public Builder withNfe(NFeEnvioRequisicaoNotaFiscal val) {
            nfe = val;
            return this;
        }

        public NFeAutorizarBodyRequest build() {
            return new NFeAutorizarBodyRequest(this);
        }
    }
}
