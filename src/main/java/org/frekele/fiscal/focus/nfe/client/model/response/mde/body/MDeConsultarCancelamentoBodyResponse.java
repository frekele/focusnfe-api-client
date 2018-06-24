package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body Consultar Cancelamento MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarCancelamentoBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * Ultima Manifestação emitidas para uma NFe.
     */
    @JsonUnwrapped
    private MDeManifesto manifesto;

    /**
     * Inclui os dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_cancelamento")
    private NFeRequisicaoCancelamento requisicaoCancelamento;

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_cancelamento")
    private NFeProtocoloCancelamento protocoloCancelamento;

    public MDeConsultarCancelamentoBodyResponse() {
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
     * Ultima Manifestação emitidas para uma NFe.
     */
    public MDeManifesto getManifesto() {
        return manifesto;
    }

    /**
     * Ultima Manifestação emitidas para uma NFe.
     */
    public void setManifesto(MDeManifesto manifesto) {
        this.manifesto = manifesto;
    }

    /**
     * Inclui os dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRequisicaoCancelamento getRequisicaoCancelamento() {
        return requisicaoCancelamento;
    }

    /**
     * Inclui os dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoCancelamento(NFeRequisicaoCancelamento requisicaoCancelamento) {
        this.requisicaoCancelamento = requisicaoCancelamento;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloCancelamento getProtocoloCancelamento() {
        return protocoloCancelamento;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloCancelamento(NFeProtocoloCancelamento protocoloCancelamento) {
        this.protocoloCancelamento = protocoloCancelamento;
    }
}
