package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
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
 * Response Body Consultar NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeConsultarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * As mensagens de erro serão apresentadas em qualquer operação sempre que for devolvido um código HTTP que começa com 4.
     */
    @JsonUnwrapped
    private NFeErro erro;

    /**
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
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
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do XML.
     */
    @JsonProperty("caminho_xml_carta_correcao")
    private String caminhoXmlCartaCorrecao;

    /**
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do PDF da carta.
     */
    @JsonProperty("caminho_pdf_carta_correcao")
    private String caminhoPdfCartaCorrecao;

    /**
     * O número da carta de correção, caso tenha sido emitida.
     */
    @JsonProperty("numero_carta_correcao")
    private String numeroCartaCorrecao;

    /**
     * Caso a nota esteja cancelada, é fornecido o caminho para fazer o download do XML de cancelamento.
     */
    @JsonProperty("caminho_xml_cancelamento")
    private String caminhoXmlCancelamento;

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal;

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_nota_fiscal")
    private NFeProtocoloNotaFiscal protocoloNotaFiscal;

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

    /**
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("requisicao_carta_correcao")
    private NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao;

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    @JsonProperty("protocolo_carta_correcao")
    private NFeProtocoloCartaCorrecao protocoloCartaCorrecao;

    public NFeConsultarBodyResponse() {
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
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
     */
    public String getStatus() {
        return status;
    }

    /**
     * A situação da NFe, podendo ser: processando_autorizacao, autorizado, cancelado, erro_autorizacao ou denegado.
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
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do XML.
     */
    public String getCaminhoXmlCartaCorrecao() {
        return caminhoXmlCartaCorrecao;
    }

    /**
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do XML.
     */
    public void setCaminhoXmlCartaCorrecao(String caminhoXmlCartaCorrecao) {
        this.caminhoXmlCartaCorrecao = caminhoXmlCartaCorrecao;
    }

    /**
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do PDF da carta.
     */
    public String getCaminhoPdfCartaCorrecao() {
        return caminhoPdfCartaCorrecao;
    }

    /**
     * Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do PDF da carta.
     */
    public void setCaminhoPdfCartaCorrecao(String caminhoPdfCartaCorrecao) {
        this.caminhoPdfCartaCorrecao = caminhoPdfCartaCorrecao;
    }

    /**
     * O número da carta de correção, caso tenha sido emitida.
     */
    public String getNumeroCartaCorrecao() {
        return numeroCartaCorrecao;
    }

    /**
     * O número da carta de correção, caso tenha sido emitida.
     */
    public void setNumeroCartaCorrecao(String numeroCartaCorrecao) {
        this.numeroCartaCorrecao = numeroCartaCorrecao;
    }

    /**
     * Caso a nota esteja cancelada, é fornecido o caminho para fazer o download do XML de cancelamento.
     */
    public String getCaminhoXmlCancelamento() {
        return caminhoXmlCancelamento;
    }

    /**
     * Caso a nota esteja cancelada, é fornecido o caminho para fazer o download do XML de cancelamento.
     */
    public void setCaminhoXmlCancelamento(String caminhoXmlCancelamento) {
        this.caminhoXmlCancelamento = caminhoXmlCancelamento;
    }

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRetornoRequisicaoNotaFiscal getRequisicaoNotaFiscal() {
        return requisicaoNotaFiscal;
    }

    /**
     * Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoNotaFiscal(NFeRetornoRequisicaoNotaFiscal requisicaoNotaFiscal) {
        this.requisicaoNotaFiscal = requisicaoNotaFiscal;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloNotaFiscal getProtocoloNotaFiscal() {
        return protocoloNotaFiscal;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloNotaFiscal(NFeProtocoloNotaFiscal protocoloNotaFiscal) {
        this.protocoloNotaFiscal = protocoloNotaFiscal;
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

    /**
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeRequisicaoCartaCorrecao getRequisicaoCartaCorrecao() {
        return requisicaoCartaCorrecao;
    }

    /**
     * Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setRequisicaoCartaCorrecao(NFeRequisicaoCartaCorrecao requisicaoCartaCorrecao) {
        this.requisicaoCartaCorrecao = requisicaoCartaCorrecao;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public NFeProtocoloCartaCorrecao getProtocoloCartaCorrecao() {
        return protocoloCartaCorrecao;
    }

    /**
     * Inclui os dados completos do protocolo devolvido pela SEFAZ.
     * Caso na requisição seja passado o parâmetro completa=1.
     */
    public void setProtocoloCartaCorrecao(NFeProtocoloCartaCorrecao protocoloCartaCorrecao) {
        this.protocoloCartaCorrecao = protocoloCartaCorrecao;
    }
}
