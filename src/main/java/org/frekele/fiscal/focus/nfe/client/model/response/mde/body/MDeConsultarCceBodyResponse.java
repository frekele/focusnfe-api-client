package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cartacorrecao.NFeProtocoloCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao.NFeRequisicaoCartaCorrecao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarCceBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    //Ultima Manifestação emitidas para uma NFe.
    @JsonUnwrapped
    private MDeManifesto manifesto;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
    @JsonProperty("requisicao_carta_correcao")
    private NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_carta_correcao")
    private NFeProtocoloCartaCorrecao protocoloCartaCorrecao;

    public MDeConsultarCceBodyResponse() {
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

    public NFeRequisicaoCartaCorrecao getRequisicaoCartaCorrecao() {
        return requisicaoCartaCorrecao;
    }

    public void setRequisicaoCartaCorrecao(NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao) {
        this.requisicaoCartaCorrecao = requisicaoCartaCorrecao;
    }

    public NFeProtocoloCartaCorrecao getProtocoloCartaCorrecao() {
        return protocoloCartaCorrecao;
    }

    public void setProtocoloCartaCorrecao(NFeProtocoloCartaCorrecao protocoloCartaCorrecao) {
        this.protocoloCartaCorrecao = protocoloCartaCorrecao;
    }
}
