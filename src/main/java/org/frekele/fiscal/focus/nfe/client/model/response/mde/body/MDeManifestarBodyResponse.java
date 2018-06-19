package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.MDeTipoManifestacaoEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeManifestarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    //Erro se não foi possível fazer a manifestação ou evento_registrado se a manifestação foi registrada com sucesso à NFe.
    @JsonProperty("status")
    private String status;

    //Código de status da SEFAZ.
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    //Mensagem descritiva da SEFAZ detalhando o status.
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    //Protocolo do recebimento na SEFAZ.
    @JsonProperty("protocolo")
    private String protocolo;

    //Tipo da manifestação informado.
    @JsonProperty("tipo")
    private MDeTipoManifestacaoEnum tipo;

    //Justificativa da manifestação informada, se existente.
    @JsonProperty("justificativa")
    private String justificativa;

    public MDeManifestarBodyResponse() {
        super();
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

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public MDeTipoManifestacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(MDeTipoManifestacaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
