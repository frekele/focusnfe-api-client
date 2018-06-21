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
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarCancelamentoBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    //Ultima Manifestação emitidas para uma NFe.
    @JsonUnwrapped
    private MDeManifesto manifesto;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Inclui os dados completos da requisição de cancelamento da nota fiscal.
    @JsonProperty("requisicao_cancelamento")
    private NFeRequisicaoCancelamento requisicaoCancelamento;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_cancelamento")
    private NFeProtocoloCancelamento protocoloCancelamento;

    public MDeConsultarCancelamentoBodyResponse() {
        super();
    }

    public NFeErro getErro() {
        return erro;
    }

    public void setErro(NFeErro erro) {
        this.erro = erro;
    }

    public MDeManifesto getManifesto() {
        return manifesto;
    }

    public void setManifesto(MDeManifesto manifesto) {
        this.manifesto = manifesto;
    }

    public NFeRequisicaoCancelamento getRequisicaoCancelamento() {
        return requisicaoCancelamento;
    }

    public void setRequisicaoCancelamento(NFeRequisicaoCancelamento requisicaoCancelamento) {
        this.requisicaoCancelamento = requisicaoCancelamento;
    }

    public NFeProtocoloCancelamento getProtocoloCancelamento() {
        return protocoloCancelamento;
    }

    public void setProtocoloCancelamento(NFeProtocoloCancelamento protocoloCancelamento) {
        this.protocoloCancelamento = protocoloCancelamento;
    }
}
