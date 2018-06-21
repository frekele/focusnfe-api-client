package org.frekele.fiscal.focus.nfe.client.model.response.mde.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.manifesto.MDeManifesto;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeConsultarNFeBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    //Ultima Manifestação emitidas para uma NFe.
    @JsonUnwrapped
    private MDeManifesto manifesto;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Dados completos da nota fiscal em formato JSON.
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Dados completos do retorno do SEFAZ em formato JSON.
    @JsonProperty("protocolo_nota_fiscal")
    private NFeProtocoloNotaFiscal protocoloNotaFiscal;

    public MDeConsultarNFeBodyResponse() {
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

    public NFeRetornoRequisicaoNotaFiscal getRequisicaoNotaFiscal() {
        return requisicaoNotaFiscal;
    }

    public void setRequisicaoNotaFiscal(NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal) {
        this.requisicaoNotaFiscal = requisicaoNotaFiscal;
    }

    public NFeProtocoloNotaFiscal getProtocoloNotaFiscal() {
        return protocoloNotaFiscal;
    }

    public void setProtocoloNotaFiscal(NFeProtocoloNotaFiscal protocoloNotaFiscal) {
        this.protocoloNotaFiscal = protocoloNotaFiscal;
    }
}
