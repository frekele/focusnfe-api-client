package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cancelamento.NFeProtocoloCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal.NFeProtocoloNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento.NFeRequisicaoCancelamento;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRetornoRequisicaoNotaFiscal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFCeConsultarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
    @JsonUnwrapped
    private NFeErro erro;

    // A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
    @JsonProperty("status")
    private String status;

    //O status da nota na SEFAZ.
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    //Mensagem descritiva da SEFAZ detalhando o status.
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    //A série da nota fiscal, caso ela tenha sido autorizada.
    @JsonProperty("serie")
    private String serie;

    //O número da nota fiscal, caso ela tenha sido autorizada.
    @JsonProperty("numero")
    private String numero;

    //O CNPJ emitente da nota fiscal (o CNPJ de sua empresa).
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    //A referência da emissão.
    @JsonProperty("ref")
    private String referencia;

    //A chave da NFe, caso ela tenha sido autorizada.
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //Caso a nota tenha sido autorizada, retorna o caminho para download do XML.
    @JsonProperty("caminho_xml_nota_fiscal")
    private String caminhoXmlNotaFiscal;

    //Caso a nota tenha sido autorizada retorna o caminho para download do DANFe.
    @JsonProperty("caminho_danfe")
    private String caminhoDanfe;

    //Caso a nota esteja cancelada, é fornecido o caminho para fazer o download do XML de cancelamento.
    @JsonProperty("caminho_xml_cancelamento")
    private String caminhoXmlCancelamento;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_nota_fiscal")
    private NFeProtocoloNotaFiscal protocoloNotaFiscal;

    //Inclui os dados completos da requisição de cancelamento da nota fiscal.
    @JsonProperty("requisicao_cancelamento")
    private NFeRequisicaoCancelamento requisicaoCancelamento;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_cancelamento")
    private NFeProtocoloCancelamento protocoloCancelamento;

    public NFCeConsultarBodyResponse() {
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public String getCaminhoXmlNotaFiscal() {
        return caminhoXmlNotaFiscal;
    }

    public void setCaminhoXmlNotaFiscal(String caminhoXmlNotaFiscal) {
        this.caminhoXmlNotaFiscal = caminhoXmlNotaFiscal;
    }

    public String getCaminhoDanfe() {
        return caminhoDanfe;
    }

    public void setCaminhoDanfe(String caminhoDanfe) {
        this.caminhoDanfe = caminhoDanfe;
    }

    public String getCaminhoXmlCancelamento() {
        return caminhoXmlCancelamento;
    }

    public void setCaminhoXmlCancelamento(String caminhoXmlCancelamento) {
        this.caminhoXmlCancelamento = caminhoXmlCancelamento;
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
