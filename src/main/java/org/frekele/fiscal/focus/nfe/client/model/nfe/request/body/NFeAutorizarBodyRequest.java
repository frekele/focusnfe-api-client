package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.frekele.fiscal.focus.nfe.client.converter.deserialize.OffsetDateTimeJsonDeserialize;
import org.frekele.fiscal.focus.nfe.client.converter.serialize.OffsetDateTimeJsonSerialize;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeConsumidorFinalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFinalidadeEmissaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaPagamentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIndicadorInscricaoEstadualDestinatarioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeLocalDestinoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModalidadeFreteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePresencaCompradorEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeRegimeTributarioEmitenteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoDocumentoEnum;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar.NFeItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Descrição da natureza da operação a ser realizada pela nota fiscal.
    @JsonProperty("natureza_operacao")
    private String naturezaOperacao;

    //Forma de pagamento utilizado no operação.
    @JsonProperty("forma_pagamento")
    private NFeFormaPagamentoEnum formaPagamento;

    //Data da emissão da NFe. Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @JsonProperty("data_emissao")
    @JsonDeserialize(using = OffsetDateTimeJsonDeserialize.class)
    @JsonSerialize(using = OffsetDateTimeJsonSerialize.class)
    private OffsetDateTime dataEmissao;

    //Tipo da NFe.
    @JsonProperty("tipo_documento")
    private NFeTipoDocumentoEnum tipoDocumento;

    //Local onde a operação irá acontecer.
    @JsonProperty("local_destino")
    private NFeLocalDestinoEnum localDestino;

    //Indicar qual a finalidade da emissão da nota.
    @JsonProperty("finalidade_emissao")
    private NFeFinalidadeEmissaoEnum finalidadeEmissao;

    //Indicar se a operação é com consumidor final.
    @JsonProperty("consumidor_final")
    private NFeConsumidorFinalEnum consumidorFinal;

    //Informar como foi a presença do comprador.
    @JsonProperty("presenca_comprador")
    private NFePresencaCompradorEnum presencaComprador;

    //
    //Emitente:
    //
    //CNPJ do emitente da nota.
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    //Informar a Inscrição Estadual do emitente.
    @JsonProperty("inscricao_estadual_emitente")
    private String inscricaoEstadualEmitente;

    //Logradouro do emitente.
    @JsonProperty("logradouro_emitente")
    private String logradouroEmitente;

    //Número do logradouro do emitente.
    @JsonProperty("numero_emitente")
    private String numeroEmitente;

    //Bairro do emitente.
    @JsonProperty("bairro_emitente")
    private String bairroEmitente;

    //Município do emitente.
    @JsonProperty("municipio_emitente")
    private String municipioEmitente;

    //UF do emitente.
    @JsonProperty("uf_emitente")
    private String ufEmitente;

    //Informar qual o regime tributário do emitente.
    @JsonProperty("regime_tributario_emitente")
    private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

    //
    //Destinatário:
    //
    //Nome completo do destinatário.
    @JsonProperty("nome_destinatario")
    private String nomeDestinatario;

    //CNPJ da empresa destinatária.
    @JsonProperty("cnpj_destinatario")
    private String cnpjDestinatario;

    //CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario”.
    @JsonProperty("cpf_destinatario")
    private String cpfDestinatario;

    //Informar a Inscrição Estadual do destinatário.
    @JsonProperty("inscricao_estadual_destinatario")
    private String inscricaoEstadualDestinatario;

    //Logradouro do destinatário.
    @JsonProperty("logradouro_destinatario")
    private String logradouroDestinatario;

    //Número do logradouro do destinatário.
    @JsonProperty("numero_destinatario")
    private String numeroDestinatario;

    //Bairro do destinatário.
    @JsonProperty("bairro_destinatario")
    private String bairroDestinatario;

    // Município do destinatário.
    @JsonProperty("municipio_destinatario")
    private String municipioDestinatario;

    // UF do destinatário.
    @JsonProperty("uf_destinatario")
    private String ufDestinatario;

    //Indicador da Inscrição Estadual do destinatário.
    @JsonProperty("indicador_inscricao_estadual_destinatario")
    private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

    //Uma NFe irá conter um ou mais itens no campo “items”.
    private List<NFeItem> items;

    //Valor total da base de cálculo do ICMS. Assume zero se não informado.
    @JsonProperty("icms_base_calculo")
    private String icmsBaseCalculo;

    //Valor total do ICMS. Assume zero se não informado.
    @JsonProperty("icms_valor_total")
    private String icmsValorTotal;

    //Valor total da base de cálculo do ICMS do substituto tributário. Assume zero se não informado.
    @JsonProperty("icms_base_calculo_st")
    private String icmsBaseCalculoST;

    //Valor total do ICMS do substituto tributário. Assume zero se não informado.
    @JsonProperty("icms_valor_total_st")
    private String icmsValorTotalST;

    //Valor total dos produtos. Assume zero se não informado.
    @JsonProperty("valor_produtos")
    private String valorProdutos;

    //Valor total do frete. Assume zero se não informado.
    @JsonProperty("valor_frete")
    private String valorFrete;

    //Valor total do seguro. Assume zero se não informado.
    @JsonProperty("valor_seguro")
    private String valorSeguro;

    //Valor total do desconto. Assume zero se não informado.
    @JsonProperty("valor_desconto")
    private String valorDesconto;

    //Valor total do IPI. Assume zero se não informado.
    @JsonProperty("valor_ipi")
    private String valorIpi;

    //Valor do PIS. Assume zero se não informado.
    @JsonProperty("valor_pis")
    private String valorPis;

    //Valor do COFINS. Assume zero se não informado.
    @JsonProperty("valor_cofins")
    private String valorCofins;

    //Valor das despesas acessórias. Assume zero se não informado.
    @JsonProperty("valor_outras_despesas")
    private String valorOutrasDespesas;

    //Valor total da nota fiscal.
    @JsonProperty("valor_total")
    private String valorTotal;

    // Indica a modalidade do frete da operação.
    @JsonProperty("modalidade_frete")
    private NFeModalidadeFreteEnum modalidadeFrete;

    public NFeAutorizarBodyRequest() {
        super();
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
}
