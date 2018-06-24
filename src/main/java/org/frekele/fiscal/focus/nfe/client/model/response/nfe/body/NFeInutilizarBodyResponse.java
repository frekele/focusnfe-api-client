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
public class NFeInutilizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Autorizado, se a inutilização foi aceita pela SEFAZ, ou erro_autorizacao, se houve algum erro ao inutilizar os números.
     */
    @JsonProperty("status")
    private String status;

    /**
     * O status da carta de correção na SEFAZ.
     */
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    /**
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    @JsonProperty("serie")
    private String serie;

    /**
     * Número inicial a ser inutilizado.
     */
    @JsonProperty("numero_inicial")
    private String numeroInicial;

    /**
     * Número final a ser inutilizado.
     */
    @JsonProperty("numero_final")
    private String numeroFinal;

    /**
     * Caminho do XML para download caso a inutilização tenha sido autorizada pela SEFAZ.
     */
    @JsonProperty("caminho_xml")
    private String caminhoXml;

    public NFeInutilizarBodyResponse() {
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
     * Autorizado, se a inutilização foi aceita pela SEFAZ, ou erro_autorizacao, se houve algum erro ao inutilizar os números.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Autorizado, se a inutilização foi aceita pela SEFAZ, ou erro_autorizacao, se houve algum erro ao inutilizar os números.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * O status da carta de correção na SEFAZ.
     */
    public String getStatusSefaz() {
        return statusSefaz;
    }

    /**
     * O status da carta de correção na SEFAZ.
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
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Série da numeração da NFe que terá uma faixa de numeração inutilizada.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Número inicial a ser inutilizado.
     */
    public String getNumeroInicial() {
        return numeroInicial;
    }

    /**
     * Número inicial a ser inutilizado.
     */
    public void setNumeroInicial(String numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    /**
     * Número final a ser inutilizado.
     */
    public String getNumeroFinal() {
        return numeroFinal;
    }

    /**
     * Número final a ser inutilizado.
     */
    public void setNumeroFinal(String numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    /**
     * Caminho do XML para download caso a inutilização tenha sido autorizada pela SEFAZ.
     */
    public String getCaminhoXml() {
        return caminhoXml;
    }

    /**
     * Caminho do XML para download caso a inutilização tenha sido autorizada pela SEFAZ.
     */
    public void setCaminhoXml(String caminhoXml) {
        this.caminhoXml = caminhoXml;
    }
}
