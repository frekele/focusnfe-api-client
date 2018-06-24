package org.frekele.fiscal.focus.nfe.client.model.response.nfce.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
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
public class NFCeAutorizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * A situação da NFe, podendo ser: autorizado, cancelado, erro_autorizacao ou denegado.
     */
    @JsonProperty("status")
    private String status;

    /**
     * O status da nota na SEFAZ.
     */
    @JsonProperty("status_sefaz")
    private String statusSefaz;

    /**
     * Mensagem descritiva da SEFAZ detalhando o status.
     */
    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    /**
     * A série da nota fiscal, caso ela tenha sido autorizada.
     */
    @JsonProperty("serie")
    private String serie;

    /**
     * O número da nota fiscal, caso ela tenha sido autorizada.
     */
    @JsonProperty("numero")
    private String numero;

    /**
     * O CNPJ emitente da nota fiscal (o CNPJ de sua empresa).
     */
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    /**
     * A referência da emissão.
     */
    @JsonProperty("ref")
    private String referencia;

    /**
     * A chave da NFe, caso ela tenha sido autorizada.
     */
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    /**
     * Caso a nota tenha sido autorizada, retorna o caminho para download do XML.
     */
    @JsonProperty("caminho_xml_nota_fiscal")
    private String caminhoXmlNotaFiscal;

    /**
     * Caso a nota tenha sido autorizada retorna o caminho para download do DANFe.
     */
    @JsonProperty("caminho_danfe")
    private String caminhoDanfe;

    /**
     * Retorna a URL usado para QRCode.
     */
    @JsonProperty("qrcode_url")
    private String qrcodeUrl;

    /**
     * Retorna a URL Raiz usado para QRCode.
     */
    @JsonProperty("url_consulta_nf")
    private String urlConsultaNf;

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal;

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    @JsonProperty("protocolo_nota_fiscal")
    private NFeProtocoloNotaFiscal protocoloNotaFiscal;

    public NFCeAutorizarBodyResponse() {
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
     * A situação da NFe, podendo ser: autorizado, cancelado, erro_autorizacao ou denegado.
     */
    public String getStatus() {
        return status;
    }

    /**
     * A situação da NFe, podendo ser: autorizado, cancelado, erro_autorizacao ou denegado.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * O status da nota na SEFAZ.
     */
    public String getStatusSefaz() {
        return statusSefaz;
    }

    /**
     * O status da nota na SEFAZ.
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
     * A série da nota fiscal, caso ela tenha sido autorizada.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * A série da nota fiscal, caso ela tenha sido autorizada.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * O número da nota fiscal, caso ela tenha sido autorizada.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * O número da nota fiscal, caso ela tenha sido autorizada.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * O CNPJ emitente da nota fiscal (o CNPJ de sua empresa).
     */
    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    /**
     * O CNPJ emitente da nota fiscal (o CNPJ de sua empresa).
     */
    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    /**
     * A referência da emissão.
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * A referência da emissão.
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * A chave da NFe, caso ela tenha sido autorizada.
     */
    public String getChaveNfe() {
        return chaveNfe;
    }

    /**
     * A chave da NFe, caso ela tenha sido autorizada.
     */
    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    /**
     * Caso a nota tenha sido autorizada, retorna o caminho para download do XML.
     */
    public String getCaminhoXmlNotaFiscal() {
        return caminhoXmlNotaFiscal;
    }

    /**
     * Caso a nota tenha sido autorizada, retorna o caminho para download do XML.
     */
    public void setCaminhoXmlNotaFiscal(String caminhoXmlNotaFiscal) {
        this.caminhoXmlNotaFiscal = caminhoXmlNotaFiscal;
    }

    /**
     * Caso a nota tenha sido autorizada retorna o caminho para download do DANFe.
     */
    public String getCaminhoDanfe() {
        return caminhoDanfe;
    }

    /**
     * Caso a nota tenha sido autorizada retorna o caminho para download do DANFe.
     */
    public void setCaminhoDanfe(String caminhoDanfe) {
        this.caminhoDanfe = caminhoDanfe;
    }

    /**
     * Retorna a URL usado para QRCode.
     */
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    /**
     * Retorna a URL usado para QRCode.
     */
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    /**
     * Retorna a URL Raiz usado para QRCode.
     */
    public String getUrlConsultaNf() {
        return urlConsultaNf;
    }

    /**
     * Retorna a URL Raiz usado para QRCode.
     */
    public void setUrlConsultaNf(String urlConsultaNf) {
        this.urlConsultaNf = urlConsultaNf;
    }

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public NFeRetornoRequisicaoNotaFiscal getRequisicaoNotaFiscal() {
        return requisicaoNotaFiscal;
    }

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1;
     */

    public void setRequisicaoNotaFiscal(NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal) {
        this.requisicaoNotaFiscal = requisicaoNotaFiscal;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public NFeProtocoloNotaFiscal getProtocoloNotaFiscal() {
        return protocoloNotaFiscal;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1;
     */
    public void setProtocoloNotaFiscal(NFeProtocoloNotaFiscal protocoloNotaFiscal) {
        this.protocoloNotaFiscal = protocoloNotaFiscal;
    }
}
