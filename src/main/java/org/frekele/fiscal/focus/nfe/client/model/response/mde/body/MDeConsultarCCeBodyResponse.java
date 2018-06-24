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
 * Response Body Consultar CCe MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarCCeBodyResponse implements FocusNFeEntity {

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
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    @JsonProperty("requisicao_carta_correcao")
    private NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao;

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    @JsonProperty("protocolo_carta_correcao")
    private NFeProtocoloCartaCorrecao protocoloCartaCorrecao;

    public MDeConsultarCCeBodyResponse() {
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
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public NFeRequisicaoCartaCorrecao getRequisicaoCartaCorrecao() {
        return requisicaoCartaCorrecao;
    }

    /**
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public void setRequisicaoCartaCorrecao(NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao) {
        this.requisicaoCartaCorrecao = requisicaoCartaCorrecao;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public NFeProtocoloCartaCorrecao getProtocoloCartaCorrecao() {
        return protocoloCartaCorrecao;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public void setProtocoloCartaCorrecao(NFeProtocoloCartaCorrecao protocoloCartaCorrecao) {
        this.protocoloCartaCorrecao = protocoloCartaCorrecao;
    }
}
