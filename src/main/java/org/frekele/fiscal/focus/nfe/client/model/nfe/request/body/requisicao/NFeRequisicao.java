package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeCodigoRegimeEspecialTributacaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeConsumidorFinalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFinalidadeEmissaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIndicadorInscricaoEstadualDestinatarioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeLocalDestinoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModalidadeFreteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePresencaCompradorEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeRegimeTributarioEmitenteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoDocumentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRequisicao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Descrição da natureza de operação.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("natureza_operacao")
    private String naturezaOperacao;

    //Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    //Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado)
    @Size(min = 1, max = 9)
    @JsonProperty("numero")
    private String numero;

    //Data e hora de emissão da emissão da NFe.
    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @NotNull
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_emissao")
    private OffsetDateTime dataEmissao;

    //Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_entrada_saida")
    private OffsetDateTime dataEntradaSaida;

    //Tipo da NFe.
    @NotNull
    @JsonProperty("tipo_documento")
    private NFeTipoDocumentoEnum tipoDocumento;

    //Local onde a operação irá acontecer.
    @NotNull
    @JsonProperty("local_destino")
    private NFeLocalDestinoEnum localDestino;

    //Indicar qual a finalidade da emissão da nota.
    @NotNull
    @JsonProperty("finalidade_emissao")
    private NFeFinalidadeEmissaoEnum finalidadeEmissao;

    //Indicar se a operação é com consumidor final.
    @NotNull
    @JsonProperty("consumidor_final")
    private NFeConsumidorFinalEnum consumidorFinal;

    //Informar como foi a presença do comprador.
    @NotNull
    @JsonProperty("presenca_comprador")
    private NFePresencaCompradorEnum presencaComprador;

    //
    // Notas referenciadas.
    //
    @Size(max = 500)
    @JsonProperty("notas_referenciadas")
    private List<NFeNotaReferenciada> notasReferenciadas;

    //
    //Emitente:
    //
    //CNPJ da empresa emitente.
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    //Razão social da empresa emitente.
    @Size(min = 2, max = 60)
    @JsonProperty("nome_emitente")
    private String nomeEmitente;

    //Nome fantasia da empresa emitente.
    @Size(min = 1, max = 60)
    @JsonProperty("nome_fantasia_emitente")
    private String nomeFantasiaEmitente;

    //Logradouro (rua, avenida, travessa etc.) da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_emitente")
    private String logradouroEmitente;

    //Número do endereço da empresa emitente.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_emitente")
    private String numeroEmitente;

    //Complemento do endereço da empresa emitente.
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_emitente")
    private String complementoEmitente;

    //Bairro da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_emitente")
    private String bairroEmitente;

    //Município da empresa emitente.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_emitente")
    private String municipioEmitente;

    //UF da empresa emitente.
    @NotNull
    @JsonProperty("uf_emitente")
    private NFeUnidadeFederativaEnum ufEmitente;

    //CEP da empresa emitente.
    @Size(max = 8)
    @JsonProperty("cep_emitente")
    private String cepEmitente;

    //Telefone da empresa emitente.
    @JsonProperty("telefone_emitente")
    @Size(min = 6, max = 14)
    private String telefoneEmitente;

    //Inscrição Estadual da empresa emitente.
    @NotNull
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_emitente")
    private String inscricaoEstadualEmitente;

    //Inscrição Estadual do Substituto Tributário da empresa emitente.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_st_emitente")
    private String inscricaoEstadualStEmitente;

    //Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
    @Size(min = 2, max = 15)
    @JsonProperty("inscricao_municipal_emitente")
    private String inscricaoMunicipalEmitente;

    //CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
    @Size(max = 7)
    @JsonProperty("cnae_fiscal_emitente")
    private String cnaeFiscalEmitente;

    //Informar qual o regime tributário do emitente.
    @NotNull
    @JsonProperty("regime_tributario_emitente")
    private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

    //
    //Destinatário:
    //
    //CNPJ da empresa destinatária.
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj_destinatario")
    private String cnpjDestinatario;

    //CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario”.
    @NotNull
    @Size(max = 11)
    @JsonProperty("cpf_destinatario")
    private String cpfDestinatario;

    //Identificação do destinatário no caso de comprador estrangeiro.
    @Size(min = 5, max = 20)
    @JsonProperty("id_estrangeiro_destinatario")
    private String idEstrangeiroDestinatario;

    //Nome completo ou razão social do destinatário
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("nome_destinatario")
    private String nomeDestinatario;

    //Logradouro (rua, avenida, travessa etc.) do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_destinatario")
    private String logradouroDestinatario;

    //Número do endereço do destinatário.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_destinatario")
    private String numeroDestinatario;

    //Complemento do endereço do destinatário.
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_destinatario")
    private String complementoDestinatario;

    //Bairro do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_destinatario")
    private String bairroDestinatario;

    //Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
    //Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(min = 7)
    @JsonProperty("codigo_municipio_destinatario")
    private String codigoMunicipioDestinatario;

    //Município do destinatário.
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_destinatario")
    private String municipioDestinatario;

    //UF do destinatário. Deve ser omitido em operações com o exterior.
    @NotNull
    @JsonProperty("uf_destinatario")
    private NFeUnidadeFederativaEnum ufDestinatario;

    //CEP do destinatário.
    @Size(max = 8)
    @JsonProperty("cep_destinatario")
    private String cepDestinatario;

    //Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
    @Size(min = 2, max = 4)
    @JsonProperty("codigo_pais_destinatario")
    private String codigoPaisDestinatario;

    //Nome do país do destinatário. (Apenas se diferente de Brasil).
    @Size(min = 2, max = 4)
    @JsonProperty("pais_destinatario")
    private String paisDestinatario;

    //Telefone do destinatário.
    @Size(min = 6, max = 14)
    @JsonProperty("telefone_destinatario")
    private String telefoneDestinatario;

    //Indicador da Inscrição Estadual do destinatário.
    @NotNull
    @JsonProperty("indicador_inscricao_estadual_destinatario")
    private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

    //Informar a Inscrição Estadual do destinatário.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_destinatario")
    private String inscricaoEstadualDestinatario;

    //Inscrição Suframa do destinatário.
    @Size(min = 8, max = 9)
    @JsonProperty("inscricao_suframa_destinatario")
    private String inscricaoSuframaDestinatario;

    //Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
    @Size(min = 1, max = 15)
    @JsonProperty("inscricao_municipal_destinatario")
    private String inscricaoMunicipalDestinatario;

    //E-mail do destinatário.
    //O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
    //Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
    @Size(min = 1, max = 60)
    @JsonProperty("email_destinatario")
    private String emailDestinatario;

    //
    //Retirada:
    //
    //CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(max = 14)
    @JsonProperty("cnpj_retirada")
    private String cnpjRetirada;

    //CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(max = 11)
    @JsonProperty("cpf_retirada")
    private String cpfRetirada;

    //Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_retirada")
    private String logradouroRetirada;

    //Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("numero_retirada")
    private String numeroRetirada;

    //Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_retirada")
    private String complementoRetirada;

    //Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("bairro_retirada")
    private String bairroRetirada;

    //Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(max = 7)
    @JsonProperty("codigo_municipio_retirada")
    private String codigoMunicipioRetirada;

    //Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_retirada")
    private String municipioRetirada;

    //UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
    @JsonProperty("uf_retirada")
    private NFeUnidadeFederativaEnum ufRetirada;

    //
    //Entrega:
    //
    //CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(max = 14)
    @JsonProperty("cnpj_entrega")
    private String cnpjEntrega;

    //CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(max = 11)
    @JsonProperty("cpf_entrega")
    private String cpfEntrega;

    //Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_entrega")
    private String logradouroEntrega;

    //Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("numero_entrega")
    private String numeroEntrega;

    //Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_entrega")
    private String complementoEntrega;

    //Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_entrega")
    private String bairroEntrega;

    //Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
    @Size(max = 7)
    @JsonProperty("codigo_municipio_entrega")
    private String codigoMunicipioEntrega;

    //Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_entrega")
    private String municipioEntrega;

    //UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
    @JsonProperty("uf_entrega")
    private NFeUnidadeFederativaEnum ufEntrega;

    //Pessoas autorizadas a acessar o XML da NF-e.
    @Size(max = 10)
    @JsonProperty("pessoas_autorizadas")
    private List<NFePessoaAutorizada> pessoasAutorizadas;

    //Uma NFe irá conter um ou mais itens no campo “items”.
    @Size(max = 990)
    @JsonProperty("items")
    private List<NFeItem> items;

    //Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo")
    private BigDecimal icmsBaseCalculo;

    //Valor total do ICMS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total")
    private BigDecimal icmsValorTotal;

    //Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_desonerado")
    private BigDecimal icmsValorTotalDesonerado;

    //(apenas para venda interestadual para consumidor final)
    //Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_uf_destino")
    private BigDecimal fcpValorTotalUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_destino")
    private BigDecimal icmsValorTotalUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_remetente")
    private BigDecimal icmsValorTotalUfRemetente;

    //Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total")
    private BigDecimal fcpValorTotal;

    //Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_st")
    private BigDecimal icmsBaseCalculoST;

    //Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_st")
    private BigDecimal icmsValorTotalST;

    //Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_st")
    private BigDecimal fcpValorTotalST;

    //Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_retido_st")
    private BigDecimal fcpValorTotalRetidoST;

    //Valor total dos produtos. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_produtos")
    private BigDecimal valorProdutos;

    //Valor total do frete. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_frete")
    private BigDecimal valorFrete;

    //Valor total do seguro. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_seguro")
    private BigDecimal valorSeguro;

    //Valor total do desconto. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    //Valor total do imposto de importação. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_ii")
    private BigDecimal valorTotalII;

    //Valor total do IPI. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor_ipi")
    private BigDecimal valorIpi;

    //Valor total do IPI devolvido. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_ipi_devolvido")
    private BigDecimal valorIpiDevolvido;

    //Valor do PIS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis")
    private BigDecimal valorPis;

    //Valor do COFINS. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins")
    private BigDecimal valorCofins;

    //Valor das despesas acessórias. Calculado automaticamente se omitido.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_outras_despesas")
    private BigDecimal valorOutrasDespesas;

    //Valor total da nota fiscal.
    //Se não informado o valor será calculado como:
    //(valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
    //Este campo não será calculado se a nota for de importação (CFOP começando com 3).
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    //Valor total aproximado dos tributos - calculado automaticamente pela API.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_tributos")
    private BigDecimal valorTotalTributos;

    //(ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_servicos")
    private BigDecimal valorTotalServicos;

    //(ISSQN) Base de Cálculo do ISS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_base_calculo")
    private BigDecimal issqnBaseCalculo;

    //(ISSQN) Valor Total do ISS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total")
    private BigDecimal issqnValorTotal;

    //(ISSQN) Valor do PIS sobre serviços.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis_servicos")
    private BigDecimal valorPisServicos;

    //(ISSQN) Valor do COFINS sobre serviços.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins_servicos")
    private BigDecimal valorCofinsServicos;

    //(ISSQN) Data da prestação do serviço. Obrigatório se houver serviços
    @LocalDateJsonConverter
    @JsonProperty("data_prestacao_servico")
    private LocalDate dataPrestacaoServico;

    //(ISSQN) Valor total da dedução para redução da Base de Cálculo
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_deducao")
    private BigDecimal issqnValorTotalDeducao;

    //(ISSQN) Valor total outras retenções
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_outras_retencoes")
    private BigDecimal issqnValorTotalOutrasRetencoes;

    //(ISSQN) Valor total desconto incondicionado
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_incondicionado")
    private BigDecimal issqnValorTotalDescontoIncondicionado;

    //(ISSQN) Valor total desconto condicionado
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_condicionado")
    private BigDecimal issqnValorTotalDescontoCondicionado;

    //(ISSQN) Valor total retenção ISS
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_retencao")
    private BigDecimal issqnValorTotalRetencao;

    //(ISSQN) Código do regime especial de tributação
    @JsonProperty("codigo_regime_especial_tributacao")
    private NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;

    //Valor Retido de PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor_retido")
    private BigDecimal pisValorRetido;

    //Valor Retido de COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_valor_retido")
    private BigDecimal cofinsValorRetido;

    //Valor Retido de CSLL.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("csll_valor_retido")
    private BigDecimal csllValorRetido;

    //Base de Cálculo do IRRF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_base_calculo")
    private BigDecimal irrfBaseCalculo;

    //Valor Retido de IRRF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_valor_retido")
    private BigDecimal irrfValorRetido;

    //Base de Cálculo da Retenção da Previdêncica Social.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_base_calculo")
    private BigDecimal prevSocialBaseCalculo;

    //Valor da Retenção da Previdêncica Social.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_valor_retido")
    private BigDecimal prevSocialValorRetido;

    //Modalidade do frete.
    @NotNull
    @JsonProperty("modalidade_frete")
    private NFeModalidadeFreteEnum modalidadeFrete;

    //CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
    @Size(max = 14)
    @JsonProperty("cnpj_transportador")
    private String cnpjTransportador;

    //CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
    @Size(max = 11)
    @JsonProperty("cpf_transportador")
    private String cpfTransportador;

    //Nome ou razão social do transportador.
    @Size(min = 2, max = 60)
    @JsonProperty("nome_transportador")
    private String nomeTransportador;

    //Inscrição Estadual do transportador.
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_transportador")
    private String inscricaoEstadualTransportador;

    //Endereço (logradouro, número, complemento e bairro) do transportador.
    @Size(min = 1, max = 60)
    @JsonProperty("endereco_transportador")
    private String enderecoTransportador;

    //Município do transportador.
    @Size(min = 1, max = 60)
    @JsonProperty("municipio_transportador")
    private String municipioTransportador;

    //UF do transportador.
    @JsonProperty("uf_transportador")
    private NFeUnidadeFederativaEnum ufTransportador;

    //Valor do serviço de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_servico")
    private BigDecimal transporteIcmsServico;

    //Base de cálculo da retenção do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_base_calculo")
    private BigDecimal transporteIcmsBaseCalculo;

    //Alíquota da retenção do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_aliquota")
    private BigDecimal transporteIcmsAliquota;

    //Valor retido do ICMS de transporte.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_valor")
    private BigDecimal transporteIcmsValor;

    //CFOP do serviço de transporte.
    //(Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358)
    @Size(max = 4)
    @JsonProperty("transporte_icms_cfop")
    private String transporteIcmsCfop;

    //Código do município de ocorrência do fato gerador.
    @Size(max = 7)
    @JsonProperty("transporte_icms_codigo_municipio")
    private String transporteIcmsCodigoMunicipio;

    //Placa do veículo de transporte.
    @JsonProperty("veiculo_placa")
    private String veiculoPlaca;

    //UF do veículo de transporte.
    @JsonProperty("veiculo_uf")
    private NFeUnidadeFederativaEnum veiculoUf;

    //RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
    @JsonProperty("veiculo_rntc")
    private String veiculoRntc;

    //Reboques
    @Size(max = 5)
    @JsonProperty("reboques")
    private List<NFeReboque> reboques;

    //Identificação do vagão de transporte.
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_vagao")
    private String veiculoIdentificacaoVagao;

    //Identificação da balsa de transporte.
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_balsa")
    private String veiculoIdentificacaoBalsa;

    //Volumes transportados.
    @Size(max = 5000)
    @JsonProperty("volumes")
    private List<NFeVolumeTransportado> volumes;

    //Número da fatura.
    @Size(min = 1, max = 60)
    @JsonProperty("numero_fatura")
    private String numeroFatura;

    //Valor original da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_original_fatura")
    private BigDecimal valorOriginalFatura;

    //Valor do desconto da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto_fatura")
    private BigDecimal valorDescontoFatura;

    //Valor líquido da fatura.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_liquido_fatura")
    private BigDecimal valorLiquidoFatura;

    //Duplicatas da nota fiscal.
    @Size(max = 120)
    @JsonProperty("duplicatas")
    private List<NFeDuplicataNotaFiscal> duplicatas;

    //Formas de Pagamento (Tanto NF-e quanto NFC-e)
    @Size(max = 100)
    @JsonProperty("formas_pagamento")
    private List<NFeFormaPagamento> formasPagamento;

    //Informações adicionais de interesse do fisco.
    @Size(min = 1, max = 2000)
    @JsonProperty("informacoes_adicionais_fisco")
    private String informacoesAdicionaisFisco;

    //Informações adicionais de interesse do contribuinte.
    @Size(min = 1, max = 5000)
    @JsonProperty("informacoes_adicionais_contribuinte")
    private String informacoesAdicionaisContribuinte;

    //Sigla da UF de Embarque ou de transposição de fronteira
    @Size(max = 2)
    @JsonProperty("uf_local_embarque")
    private NFeUnidadeFederativaEnum ufLocalEmbarque;

    //Descrição do Local de Embarque ou de transposição de fronteira
    @Size(min = 1, max = 60)
    @JsonProperty("local_embarque")
    private String localEmbarque;

    //Descrição do local de despacho
    @Size(min = 1, max = 60)
    @JsonProperty("local_despacho")
    private String localDespacho;

    public NFeRequisicao() {
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
