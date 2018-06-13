package org.frekele.fiscal.focus.nfe.client.model.response.nfe.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.entities.erro.NFeErro;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeRequisicao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeConsultarBodyResponse implements FocusNFeEntity {

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

    //Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do XML.
    @JsonProperty("caminho_xml_carta_correcao")
    private String caminhoXmlCartaCorrecao;

    //Caso tenha sido emitida alguma carta de correção, aqui aparecerá o caminho para fazer o download do PDF da carta.
    @JsonProperty("caminho_pdf_carta_correcao")
    private String caminhoPdfCartaCorrecao;

    //O número da carta de correção, caso tenha sido emitida.
    @JsonProperty("numero_carta_correcao")
    private String numeroCartaCorrecao;

    //Caso a nota esteja cancelada, é fornecido o caminho para fazer o download do XML de cancelamento.
    @JsonProperty("caminho_xml_cancelamento")
    private String caminhoXmlCancelamento;

    //Caso na requisição seja passado o parâmetro completa=1;
    //Inclui os dados completos da requisição da nota fiscal, da mesma forma que constam no XML da nota.
    @JsonProperty("requisicao_nota_fiscal")
    private NFeRequisicao requisicaoNotaFiscal;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_nota_fiscal")
    private String protocoloNotaFiscal;

    //Inclui os dados completos da requisição de cancelamento da nota fiscal.
    @JsonProperty("requisicao_cancelamento")
    private String requisicaoCancelamento;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_cancelamento")
    private String protocoloCancelamento;

    //Inclui os dados completos da requisição de Carta de Correção Eletrônica da NFe.
    @JsonProperty("requisicao_carta_correcao")
    private String requisicaoCartaCorrecao;

    //Inclui os dados completos do protocolo devolvido pela SEFAZ.
    @JsonProperty("protocolo_carta_correcao")
    private String protocoloCartaCorrecao;

    public NFeConsultarBodyResponse() {
        super();
    }
}
