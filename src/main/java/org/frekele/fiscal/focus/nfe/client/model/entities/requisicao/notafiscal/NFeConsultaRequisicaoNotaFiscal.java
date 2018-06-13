package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeConsultaRequisicaoNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("codigo_unico")
    private String codigoUnico;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("formato_impressao")
    private String formatoImpressao;

    @JsonProperty("forma_emissao")
    private String formaEmissao;

    @JsonProperty("digito_verificador")
    private String digitoVerificador;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("processo_emissao")
    private String processoEmissao;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonUnwrapped
    private NFeRequisicaoNotaFiscal nfe;

    public NFeConsultaRequisicaoNotaFiscal() {
        super();
    }
}
