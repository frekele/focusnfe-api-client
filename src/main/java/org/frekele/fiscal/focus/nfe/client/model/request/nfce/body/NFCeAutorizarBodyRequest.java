package org.frekele.fiscal.focus.nfe.client.model.request.nfce.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeEnvioRequisicaoNotaFiscal;

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
public class NFCeAutorizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    @JsonUnwrapped
    @NotNull
    private NFeEnvioRequisicaoNotaFiscal nfce;

    public NFCeAutorizarBodyRequest() {
        super();
    }

    public NFCeAutorizarBodyRequest(NFeEnvioRequisicaoNotaFiscal nfce) {
        this.nfce = nfce;
    }

    private NFCeAutorizarBodyRequest(Builder builder) {
        setNfce(builder.nfce);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    public NFeEnvioRequisicaoNotaFiscal getNfce() {
        return nfce;
    }

    /**
     * Dados nfe da requisicao para autorizacao.
     */
    public void setNfce(NFeEnvioRequisicaoNotaFiscal nfce) {
        this.nfce = nfce;
    }

    /**
     * NFCeAutorizarBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private NFeEnvioRequisicaoNotaFiscal nfce;

        private Builder() {
        }

        /**
         * Dados nfe da requisicao para autorizacao.
         */
        public Builder withNfce(NFeEnvioRequisicaoNotaFiscal val) {
            nfce = val;
            return this;
        }

        public NFCeAutorizarBodyRequest build() {
            return new NFCeAutorizarBodyRequest(this);
        }
    }
}
