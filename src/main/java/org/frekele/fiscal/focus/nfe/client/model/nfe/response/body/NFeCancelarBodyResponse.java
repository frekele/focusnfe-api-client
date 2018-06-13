package org.frekele.fiscal.focus.nfe.client.model.nfe.response.body;

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
public class NFeCancelarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeError error;

    //Cancelado, se a nota pode ser cancelada, ou erro_cancelamento, se houve algum erro ao cancelar a nota.
    @JsonProperty("status")
    private String status;

    //O status do cancelamento na SEFAZ.
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    //Mensagem descritiva da SEFAZ detalhando o status.
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    //Caso a nota tenha sido cancelada, será informado aqui o caminho para download do XML de cancelamento.
    @JsonProperty("caminho_xml_cancelamento")
    private String caminhoXmlCancelamento;

    public NFeCancelarBodyResponse() {
        super();
    }

    private NFeCancelarBodyResponse(Builder builder) {
        setError(builder.error);
        setStatus(builder.status);
        setStatusSefaz(builder.statusSefaz);
        setMensagemSefaz(builder.mensagemSefaz);
        setCaminhoXmlCancelamento(builder.caminhoXmlCancelamento);
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

    public String getStatusSefaz() {
        return statusSefaz;
    }

    public void setStatusSefaz(String statusSefaz) {
        this.statusSefaz = statusSefaz;
    }

    public String getMensagemSefaz() {
        return mensagemSefaz;
    }

    public void setMensagemSefaz(String mensagemSefaz) {
        this.mensagemSefaz = mensagemSefaz;
    }

    public String getCaminhoXmlCancelamento() {
        return caminhoXmlCancelamento;
    }

    public void setCaminhoXmlCancelamento(String caminhoXmlCancelamento) {
        this.caminhoXmlCancelamento = caminhoXmlCancelamento;
    }

    public static final class Builder {

        private NFeError error;

        private String status;

        private String statusSefaz;

        private String mensagemSefaz;

        private String caminhoXmlCancelamento;

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

        public Builder withStatusSefaz(String val) {
            statusSefaz = val;
            return this;
        }

        public Builder withMensagemSefaz(String val) {
            mensagemSefaz = val;
            return this;
        }

        public Builder withCaminhoXmlCancelamento(String val) {
            caminhoXmlCancelamento = val;
            return this;
        }

        public NFeCancelarBodyResponse build() {
            return new NFeCancelarBodyResponse(this);
        }
    }
}
