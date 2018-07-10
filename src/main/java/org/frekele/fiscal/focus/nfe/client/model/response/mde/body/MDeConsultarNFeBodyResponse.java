package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cartacorrecao.NFeProtocoloCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cartacorrecao.NFeRequisicaoCartaCorrecao;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response Body Consultar NFe MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarNFeBodyResponse implements FocusNFeEntity {

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
     * Dados completos da nota fiscal em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal;

    /**
     * Dados completos do retorno do SEFAZ em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_nota_fiscal")
    private NFeProtocoloNotaFiscal protocoloNotaFiscal;

    /**
     * Dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_cancelamento")
    private NFeRequisicaoCancelamento requisicaoCancelamento;

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_cancelamento")
    private NFeProtocoloCancelamento protocoloCancelamento;

    /**
     * Dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_carta_correcao")
    private NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao;

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_carta_correcao")
    private NFeProtocoloCartaCorrecao protocoloCartaCorrecao;

    public MDeConsultarNFeBodyResponse() {
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
     * Dados completos da nota fiscal em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRetornoRequisicaoNotaFiscal getRequisicaoNotaFiscal() {
        return requisicaoNotaFiscal;
    }

    /**
     * Dados completos da nota fiscal em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoNotaFiscal(NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal) {
        this.requisicaoNotaFiscal = requisicaoNotaFiscal;
    }

    /**
     * Dados completos do retorno do SEFAZ em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloNotaFiscal getProtocoloNotaFiscal() {
        return protocoloNotaFiscal;
    }

    /**
     * Dados completos do retorno do SEFAZ em formato JSON.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloNotaFiscal(NFeProtocoloNotaFiscal protocoloNotaFiscal) {
        this.protocoloNotaFiscal = protocoloNotaFiscal;
    }

    /**
     * Dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRequisicaoCancelamento getRequisicaoCancelamento() {
        return requisicaoCancelamento;
    }

    /**
     * Dados completos da requisição de cancelamento da nota fiscal.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoCancelamento(NFeRequisicaoCancelamento requisicaoCancelamento) {
        this.requisicaoCancelamento = requisicaoCancelamento;
    }

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloCancelamento getProtocoloCancelamento() {
        return protocoloCancelamento;
    }

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloCancelamento(NFeProtocoloCancelamento protocoloCancelamento) {
        this.protocoloCancelamento = protocoloCancelamento;
    }

    /**
     * Dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRequisicaoCartaCorrecao getRequisicaoCartaCorrecao() {
        return requisicaoCartaCorrecao;
    }

    /**
     * Dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoCartaCorrecao(NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao) {
        this.requisicaoCartaCorrecao = requisicaoCartaCorrecao;
    }

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloCartaCorrecao getProtocoloCartaCorrecao() {
        return protocoloCartaCorrecao;
    }

    /**
     * Dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloCartaCorrecao(NFeProtocoloCartaCorrecao protocoloCartaCorrecao) {
        this.protocoloCartaCorrecao = protocoloCartaCorrecao;
    }
}
