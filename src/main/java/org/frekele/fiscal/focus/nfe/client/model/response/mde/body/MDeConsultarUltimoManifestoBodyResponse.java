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
public class MDeConsultarUltimoManifestoBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Erro se não foi possível fazer a manifestação ou evento_registrado se a manifestação foi registrada com sucesso à NFe.
     */
    @JsonProperty("status")
    private String status;

    /**
     * Código de status da SEFAZ.
     */
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    /**
     * Protocolo do recebimento na SEFAZ.
     */
    @JsonProperty("protocolo")
    private String protocolo;

    /**
     * Tipo da manifestação informado.
     */
    @JsonProperty("tipo")
    private MDeTipoManifestacaoEnum tipo;

    /**
     * Justificativa da manifestação informada, se existente.
     */
    @JsonProperty("justificativa")
    private String justificativa;

    public MDeConsultarUltimoManifestoBodyResponse() {
        super();
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public NFeErro getErro() {
        return erro;
    }

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    public void setErro(NFeErro erro) {
        this.erro = erro;
    }

    /**
     * Erro se não foi possível fazer a manifestação ou evento_registrado se a manifestação foi registrada com sucesso à NFe.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Erro se não foi possível fazer a manifestação ou evento_registrado se a manifestação foi registrada com sucesso à NFe.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Código de status da SEFAZ.
     */
    public String getStatusSefaz() {
        return statusSefaz;
    }

    /**
     * Código de status da SEFAZ.
     */
    public void setStatusSefaz(String statusSefaz) {
        this.statusSefaz = statusSefaz;
    }

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    public String getMensagemSefaz() {
        return mensagemSefaz;
    }

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    public void setMensagemSefaz(String mensagemSefaz) {
        this.mensagemSefaz = mensagemSefaz;
    }

    /**
     * Protocolo do recebimento na SEFAZ.
     */
    public String getProtocolo() {
        return protocolo;
    }

    /**
     * Protocolo do recebimento na SEFAZ.
     */
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    /**
     * Tipo da manifestação informado.
     */
    public MDeTipoManifestacaoEnum getTipo() {
        return tipo;
    }

    /**
     * Tipo da manifestação informado.
     */
    public void setTipo(MDeTipoManifestacaoEnum tipo) {
        this.tipo = tipo;
    }

    /**
     * Justificativa da manifestação informada, se existente.
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * Justificativa da manifestação informada, se existente.
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
