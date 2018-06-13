package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeError;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeError error;

    // A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
    @JsonProperty("status")
    private String status;

    //A referência da emissão.
    @JsonProperty("ref")
    private String referencia;

    //O CNPJ do emitente da nota fiscal.
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    public NFeAutorizarBodyResponse() {
        super();
    }

    private NFeAutorizarBodyResponse(Builder builder) {
        setError(builder.error);
        setStatus(builder.status);
        setReferencia(builder.referencia);
        setCnpjEmitente(builder.cnpjEmitente);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public static final class Builder {

        private NFeError error;

        private String status;

        private String referencia;

        private String cnpjEmitente;

        private Builder() {
        }

        public Builder withError(NFeError val) {
            error = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public Builder withReferencia(String val) {
            referencia = val;
            return this;
        }

        public Builder withCnpjEmitente(String val) {
            cnpjEmitente = val;
            return this;
        }

        public NFeAutorizarBodyResponse build() {
            return new NFeAutorizarBodyResponse(this);
        }
    }
}
