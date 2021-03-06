package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body Cancelar NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFCeCancelarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Cancelado, se a nota pode ser cancelada, ou erro_cancelamento, se houve algum erro ao cancelar a nota.
     */
    @JsonProperty("status")
    private String status;

    /**
     * O status do cancelamento na SEFAZ.
     */
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    /**
     * Caso a nota tenha sido cancelada, será informado aqui o caminho para download do XML de cancelamento.
     */
    @JsonProperty("caminho_xml_cancelamento")
    private String caminhoXmlCancelamento;

    public NFCeCancelarBodyResponse() {
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
     * Cancelado, se a nota pode ser cancelada, ou erro_cancelamento, se houve algum erro ao cancelar a nota.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Cancelado, se a nota pode ser cancelada, ou erro_cancelamento, se houve algum erro ao cancelar a nota.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * O status do cancelamento na SEFAZ.
     */
    public String getStatusSefaz() {
        return statusSefaz;
    }

    /**
     * O status do cancelamento na SEFAZ.
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
     * Caso a nota tenha sido cancelada, será informado aqui o caminho para download do XML de cancelamento.
     */
    public String getCaminhoXmlCancelamento() {
        return caminhoXmlCancelamento;
    }

    /**
     * Caso a nota tenha sido cancelada, será informado aqui o caminho para download do XML de cancelamento.
     */
    public void setCaminhoXmlCancelamento(String caminhoXmlCancelamento) {
        this.caminhoXmlCancelamento = caminhoXmlCancelamento;
    }
}
