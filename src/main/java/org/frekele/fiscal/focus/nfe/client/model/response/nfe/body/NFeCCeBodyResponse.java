package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeCCeBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    //Autorizado, se a carta de correção foi aceita pela SEFAZ, ou erro_autorizacao, se houve algum erro ao cancelar a nota.
    @JsonProperty("status")
    private String status;

    //O status da carta de correção na SEFAZ.
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    //Mensagem descritiva da SEFAZ detalhando o status.
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    //Informa o caminho do XML da carta de correção, caso ela tenha sido autorizada.
    @JsonProperty("caminho_xml_carta_correcao")
    private String caminhoXmlCartaCorrecao;

    //Informa o caminho do PDF da carta de correção, caso ela tenha sido autorizada.
    @JsonProperty("caminho_pdf_carta_correcao")
    private String caminhoPdfCartaCorrecao;

    //Informa o número da carta de correção, caso ela tenha sido autorizada.
    @JsonProperty("numero_carta_correcao")
    private Integer numeroCartaCorrecao;

    public NFeCCeBodyResponse() {
        super();
    }

    private NFeCCeBodyResponse(Builder builder) {
        setErro(builder.erro);
        setStatus(builder.status);
        setStatusSefaz(builder.statusSefaz);
        setMensagemSefaz(builder.mensagemSefaz);
        setCaminhoXmlCartaCorrecao(builder.caminhoXmlCartaCorrecao);
        setCaminhoPdfCartaCorrecao(builder.caminhoPdfCartaCorrecao);
        setNumeroCartaCorrecao(builder.numeroCartaCorrecao);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public NFeErro getErro() {
        return erro;
    }

    public void setErro(NFeErro erro) {
        this.erro = erro;
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

    public String getCaminhoXmlCartaCorrecao() {
        return caminhoXmlCartaCorrecao;
    }

    public void setCaminhoXmlCartaCorrecao(String caminhoXmlCartaCorrecao) {
        this.caminhoXmlCartaCorrecao = caminhoXmlCartaCorrecao;
    }

    public String getCaminhoPdfCartaCorrecao() {
        return caminhoPdfCartaCorrecao;
    }

    public void setCaminhoPdfCartaCorrecao(String caminhoPdfCartaCorrecao) {
        this.caminhoPdfCartaCorrecao = caminhoPdfCartaCorrecao;
    }

    public Integer getNumeroCartaCorrecao() {
        return numeroCartaCorrecao;
    }

    public void setNumeroCartaCorrecao(Integer numeroCartaCorrecao) {
        this.numeroCartaCorrecao = numeroCartaCorrecao;
    }

    public static final class Builder {

        private NFeErro erro;

        private String status;

        private String statusSefaz;

        private String mensagemSefaz;

        private String caminhoXmlCartaCorrecao;

        private String caminhoPdfCartaCorrecao;

        private Integer numeroCartaCorrecao;

        private Builder() {
        }

        public Builder withErro(NFeErro val) {
            erro = val;
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

        public Builder withCaminhoXmlCartaCorrecao(String val) {
            caminhoXmlCartaCorrecao = val;
            return this;
        }

        public Builder withCaminhoPdfCartaCorrecao(String val) {
            caminhoPdfCartaCorrecao = val;
            return this;
        }

        public Builder withNumeroCartaCorrecao(Integer val) {
            numeroCartaCorrecao = val;
            return this;
        }

        public NFeCCeBodyResponse build() {
            return new NFeCCeBodyResponse(this);
        }
    }
}
