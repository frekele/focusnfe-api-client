package org.frekele.fiscal.focus.nfe.client.model.nfe.response.body;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class NFeInutilizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeError error;

    //Autorizado, se a inutilização foi aceita pela SEFAZ, ou erro_autorizacao, se houve algum erro ao inutilizar os números.
    @JsonProperty("status")
    private String status;

    //O status da carta de correção na SEFAZ.
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    //Mensagem descritiva da SEFAZ detalhando o status.
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    //Série da numeração da NFe que terá uma faixa de numeração inutilizada.
    @JsonProperty("serie")
    private String serie;

    //Número inicial a ser inutilizado.
    @JsonProperty("numero_inicial")
    private String numeroInicial;

    //Número final a ser inutilizado.
    @JsonProperty("numero_final")
    private String numeroFinal;

    //Caminho do XML para download caso a inutilização tenha sido autorizada pela SEFAZ.
    @JsonProperty("caminho_xml")
    private String caminhoXml;

    public NFeInutilizarBodyResponse() {
        super();
    }

    private NFeInutilizarBodyResponse(Builder builder) {
        setError(builder.error);
        setStatus(builder.status);
        setStatusSefaz(builder.statusSefaz);
        setMensagemSefaz(builder.mensagemSefaz);
        setSerie(builder.serie);
        setNumeroInicial(builder.numeroInicial);
        setNumeroFinal(builder.numeroFinal);
        setCaminhoXml(builder.caminhoXml);
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(String numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public String getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(String numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getCaminhoXml() {
        return caminhoXml;
    }

    public void setCaminhoXml(String caminhoXml) {
        this.caminhoXml = caminhoXml;
    }

    public static final class Builder {

        private NFeError error;

        private String status;

        private String statusSefaz;

        private String mensagemSefaz;

        private String serie;

        private String numeroInicial;

        private String numeroFinal;

        private String caminhoXml;

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

        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        public Builder withNumeroInicial(String val) {
            numeroInicial = val;
            return this;
        }

        public Builder withNumeroFinal(String val) {
            numeroFinal = val;
            return this;
        }

        public Builder withCaminhoXml(String val) {
            caminhoXml = val;
            return this;
        }

        public NFeInutilizarBodyResponse build() {
            return new NFeInutilizarBodyResponse(this);
        }
    }
}
