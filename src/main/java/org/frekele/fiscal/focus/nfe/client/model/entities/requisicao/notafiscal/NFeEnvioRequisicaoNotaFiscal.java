package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeEnvioRequisicaoNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Descrição da natureza de operação.
     */
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("natureza_operacao")
    private String naturezaOperacao;

    /**
     * Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    /**
     * Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    @Size(min = 1, max = 9)
    @JsonProperty("numero")
    private String numero;

    /**
     * Data e hora de emissão da emissão da NFe.
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     * Para NFC-e (A diferença máxima permitida de 5 minutos do horário atual).
     */
    @NotNull
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_emissao")
    private OffsetDateTime dataEmissao;

    /**
     * Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     */
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_entrada_saida")
    private OffsetDateTime dataEntradaSaida;

    /**
     * Tipo da NFe.
     */
    @NotNull
    @JsonProperty("tipo_documento")
    private NFeTipoDocumentoEnum tipoDocumento;

    /**
     * Local onde a operação irá acontecer.
     */
    @NotNull
    @JsonProperty("local_destino")
    private NFeLocalDestinoEnum localDestino;

    /**
     * Indicar qual a finalidade da emissão da nota.
     */
    @NotNull
    @JsonProperty("finalidade_emissao")
    private NFeFinalidadeEmissaoEnum finalidadeEmissao;

    /**
     * Indicar se a operação é com consumidor final.
     */
    @NotNull
    @JsonProperty("consumidor_final")
    private NFeConsumidorFinalEnum consumidorFinal;

    /**
     * Informar como foi a presença do comprador.
     */
    @NotNull
    @JsonProperty("presenca_comprador")
    private NFePresencaCompradorEnum presencaComprador;

    /**
     * Notas referenciadas.
     */
    @Size(max = 500)
    @JsonProperty("notas_referenciadas")
    private List<NFeNotaReferenciada> notasReferenciadas;

    //
    //Emitente:
    //

    /**
     * CNPJ da empresa emitente.
     */
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    /**
     * Razão social da empresa emitente.
     */
    @Size(min = 2, max = 60)
    @JsonProperty("nome_emitente")
    private String nomeEmitente;

    /**
     * Nome fantasia da empresa emitente.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("nome_fantasia_emitente")
    private String nomeFantasiaEmitente;

    /**
     * Logradouro (rua, avenida, travessa etc.) da empresa emitente.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_emitente")
    private String logradouroEmitente;

    /**
     * Número do endereço da empresa emitente.
     */
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_emitente")
    private String numeroEmitente;

    /**
     * Complemento do endereço da empresa emitente.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_emitente")
    private String complementoEmitente;

    /**
     * Bairro da empresa emitente.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_emitente")
    private String bairroEmitente;

    /**
     * Código do município do emitente (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    @Size(min = 7)
    @JsonProperty("codigo_municipio_emitente")
    private String codigoMunicipioEmitente;

    /**
     * Município da empresa emitente.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_emitente")
    private String municipioEmitente;

    /**
     * UF da empresa emitente.
     */
    @NotNull
    @JsonProperty("uf_emitente")
    private NFeUnidadeFederativaEnum ufEmitente;

    /**
     * CEP da empresa emitente.
     */
    @Size(max = 8)
    @JsonProperty("cep_emitente")
    private String cepEmitente;

    /**
     * Código IBGE do país do emitente. (Apenas se diferente de 1058 - Brasil).
     */
    @Size(min = 2, max = 4)
    @JsonProperty("codigo_pais_emitente")
    private String codigoPaisEmitente;

    /**
     * Nome do país do emitente. (Apenas se diferente de Brasil).
     */
    @Size(min = 2, max = 4)
    @JsonProperty("pais_emitente")
    private String paisEmitente;

    /**
     * Telefone da empresa emitente.
     */
    @JsonProperty("telefone_emitente")
    @Size(min = 6, max = 14)
    private String telefoneEmitente;

    /**
     * Inscrição Estadual da empresa emitente.
     */
    @NotNull
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_emitente")
    private String inscricaoEstadualEmitente;

    /**
     * Inscrição Estadual do Substituto Tributário da empresa emitente.
     */
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_st_emitente")
    private String inscricaoEstadualStEmitente;

    /**
     * Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
     */
    @Size(min = 2, max = 15)
    @JsonProperty("inscricao_municipal_emitente")
    private String inscricaoMunicipalEmitente;

    /**
     * CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
     */
    @Size(max = 7)
    @JsonProperty("cnae_fiscal_emitente")
    private String cnaeFiscalEmitente;

    /**
     * Informar qual o regime tributário do emitente.
     */
    @NotNull
    @JsonProperty("regime_tributario_emitente")
    private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

    //
    //Destinatário:
    //

    /**
     * CNPJ da empresa destinatária - Obrigatório CNPJ ou CPF.
     */
    @Size(max = 14)
    @JsonProperty("cnpj_destinatario")
    private String cnpjDestinatario;

    /**
     * CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario” - Obrigatório CNPJ ou CPF.
     */
    @Size(max = 11)
    @JsonProperty("cpf_destinatario")
    private String cpfDestinatario;

    /**
     * Identificação do destinatário no caso de comprador estrangeiro.
     */
    @Size(min = 5, max = 20)
    @JsonProperty("id_estrangeiro_destinatario")
    private String idEstrangeiroDestinatario;

    /**
     * Nome completo ou razão social do destinatário.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("nome_destinatario")
    private String nomeDestinatario;

    /**
     * Logradouro (rua, avenida, travessa etc.) do destinatário.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_destinatario")
    private String logradouroDestinatario;

    /**
     * Número do endereço do destinatário.
     */
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("numero_destinatario")
    private String numeroDestinatario;

    /**
     * Complemento do endereço do destinatário.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_destinatario")
    private String complementoDestinatario;

    /**
     * Bairro do destinatário.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_destinatario")
    private String bairroDestinatario;

    /**
     * Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    @Size(min = 7)
    @JsonProperty("codigo_municipio_destinatario")
    private String codigoMunicipioDestinatario;

    /**
     * Município do destinatário.
     */
    @NotNull
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_destinatario")
    private String municipioDestinatario;

    /**
     * UF do destinatário. Deve ser omitido em operações com o exterior.
     */
    @NotNull
    @JsonProperty("uf_destinatario")
    private NFeUnidadeFederativaEnum ufDestinatario;

    /**
     * CEP do destinatário.
     */
    @Size(max = 8)
    @JsonProperty("cep_destinatario")
    private String cepDestinatario;

    /**
     * Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
     */
    @Size(min = 2, max = 4)
    @JsonProperty("codigo_pais_destinatario")
    private String codigoPaisDestinatario;

    /**
     * Nome do país do destinatário. (Apenas se diferente de Brasil).
     */
    @Size(min = 2, max = 4)
    @JsonProperty("pais_destinatario")
    private String paisDestinatario;

    /**
     * Telefone do destinatário.
     */
    @Size(min = 6, max = 14)
    @JsonProperty("telefone_destinatario")
    private String telefoneDestinatario;

    /**
     * Indicador da Inscrição Estadual do destinatário.
     */
    @NotNull
    @JsonProperty("indicador_inscricao_estadual_destinatario")
    private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

    /**
     * Informar a Inscrição Estadual do destinatário.
     */
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_destinatario")
    private String inscricaoEstadualDestinatario;

    /**
     * Inscrição Suframa do destinatário.
     */
    @Size(min = 8, max = 9)
    @JsonProperty("inscricao_suframa_destinatario")
    private String inscricaoSuframaDestinatario;

    /**
     * Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
     */
    @Size(min = 1, max = 15)
    @JsonProperty("inscricao_municipal_destinatario")
    private String inscricaoMunicipalDestinatario;

    /**
     * E-mail do destinatário.
     * O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
     * Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("email_destinatario")
    private String emailDestinatario;

    //
    //Retirada:
    //

    /**
     * CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(max = 14)
    @JsonProperty("cnpj_retirada")
    private String cnpjRetirada;

    /**
     * CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(max = 11)
    @JsonProperty("cpf_retirada")
    private String cpfRetirada;

    /**
     * Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_retirada")
    private String logradouroRetirada;

    /**
     * Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(min = 1, max = 60)
    @JsonProperty("numero_retirada")
    private String numeroRetirada;

    /**
     * Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_retirada")
    private String complementoRetirada;

    /**
     * Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(min = 1, max = 60)
    @JsonProperty("bairro_retirada")
    private String bairroRetirada;

    /**
     * Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    @Size(max = 7)
    @JsonProperty("codigo_municipio_retirada")
    private String codigoMunicipioRetirada;

    /**
     * Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_retirada")
    private String municipioRetirada;

    /**
     * UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    @JsonProperty("uf_retirada")
    private NFeUnidadeFederativaEnum ufRetirada;

    //
    //Entrega:
    //

    /**
     * CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(max = 14)
    @JsonProperty("cnpj_entrega")
    private String cnpjEntrega;

    /**
     * CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(max = 11)
    @JsonProperty("cpf_entrega")
    private String cpfEntrega;

    /**
     * Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(min = 2, max = 60)
    @JsonProperty("logradouro_entrega")
    private String logradouroEntrega;

    /**
     * Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(min = 1, max = 60)
    @JsonProperty("numero_entrega")
    private String numeroEntrega;

    /**
     * Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(min = 1, max = 60)
    @JsonProperty("complemento_entrega")
    private String complementoEntrega;

    /**
     * Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(min = 2, max = 60)
    @JsonProperty("bairro_entrega")
    private String bairroEntrega;

    /**
     * Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    @Size(max = 7)
    @JsonProperty("codigo_municipio_entrega")
    private String codigoMunicipioEntrega;

    /**
     * Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @Size(min = 2, max = 60)
    @JsonProperty("municipio_entrega")
    private String municipioEntrega;

    /**
     * UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    @JsonProperty("uf_entrega")
    private NFeUnidadeFederativaEnum ufEntrega;

    /**
     * Pessoas autorizadas a acessar o XML da NF-e.
     */
    @Size(max = 10)
    @JsonProperty("pessoas_autorizadas")
    private List<NFePessoaAutorizada> pessoasAutorizadas;

    /**
     * Uma NFe irá conter um ou mais itens no campo “items”.
     */
    @Size(max = 990)
    @JsonProperty("items")
    private List<NFeItem> items;

    /**
     * Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo")
    private BigDecimal icmsBaseCalculo;

    /**
     * Valor total do ICMS. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total")
    private BigDecimal icmsValorTotal;

    /**
     * Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_desonerado")
    private BigDecimal icmsValorTotalDesonerado;

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_uf_destino")
    private BigDecimal fcpValorTotalUfDestino;

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_destino")
    private BigDecimal icmsValorTotalUfDestino;

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_uf_remetente")
    private BigDecimal icmsValorTotalUfRemetente;

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total")
    private BigDecimal fcpValorTotal;

    /**
     * Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_st")
    private BigDecimal icmsBaseCalculoSt;

    /**
     * Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_total_st")
    private BigDecimal icmsValorTotalSt;

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_st")
    private BigDecimal fcpValorTotalSt;

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_total_retido_st")
    private BigDecimal fcpValorTotalRetidoSt;

    /**
     * Valor total dos produtos. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_produtos")
    private BigDecimal valorProdutos;

    /**
     * Valor total do frete. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_frete")
    private BigDecimal valorFrete;

    /**
     * Valor total do seguro. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_seguro")
    private BigDecimal valorSeguro;

    /**
     * Valor total do desconto. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    /**
     * Valor total do imposto de importação. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_ii")
    private BigDecimal valorTotalII;

    /**
     * Valor total do IPI. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor_ipi")
    private BigDecimal valorIpi;

    /**
     * Valor total do IPI devolvido. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_ipi_devolvido")
    private BigDecimal valorIpiDevolvido;

    /**
     * Valor do PIS. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis")
    private BigDecimal valorPis;

    /**
     * Valor do COFINS. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins")
    private BigDecimal valorCofins;

    /**
     * Valor das despesas acessórias. Calculado automaticamente se omitido.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_outras_despesas")
    private BigDecimal valorOutrasDespesas;

    /**
     * Valor total da nota fiscal.
     * Se não informado o valor será calculado como:
     * (valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
     * Este campo não será calculado se a nota for de importação (CFOP começando com 3).
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    /**
     * Valor total aproximado dos tributos - calculado automaticamente pela API.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_tributos")
    private BigDecimal valorTotalTributos;

    /**
     * (ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_servicos")
    private BigDecimal valorTotalServicos;

    /**
     * (ISSQN) Base de Cálculo do ISS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_base_calculo")
    private BigDecimal issqnBaseCalculo;

    /**
     * (ISSQN) Valor Total do ISS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total")
    private BigDecimal issqnValorTotal;

    /**
     * (ISSQN) Valor do PIS sobre serviços.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_pis_servicos")
    private BigDecimal valorPisServicos;

    /**
     * (ISSQN) Valor do COFINS sobre serviços.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_cofins_servicos")
    private BigDecimal valorCofinsServicos;

    /**
     * (ISSQN) Data da prestação do serviço. Obrigatório se houver serviços.
     */
    @LocalDateJsonConverter
    @JsonProperty("data_prestacao_servico")
    private LocalDate dataPrestacaoServico;

    /**
     * (ISSQN) Valor total da dedução para redução da Base de Cálculo.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_deducao")
    private BigDecimal issqnValorTotalDeducao;

    /**
     * (ISSQN) Valor total outras retenções.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_outras_retencoes")
    private BigDecimal issqnValorTotalOutrasRetencoes;

    /**
     * (ISSQN) Valor total desconto incondicionado.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_incondicionado")
    private BigDecimal issqnValorTotalDescontoIncondicionado;

    /**
     * (ISSQN) Valor total desconto condicionado.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_desconto_condicionado")
    private BigDecimal issqnValorTotalDescontoCondicionado;

    /**
     * (ISSQN) Valor total retenção ISS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_total_retencao")
    private BigDecimal issqnValorTotalRetencao;

    /**
     * (ISSQN) Código do regime especial de tributação.
     */
    @JsonProperty("codigo_regime_especial_tributacao")
    private NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;

    /**
     * Valor Retido de PIS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor_retido")
    private BigDecimal pisValorRetido;

    /**
     * Valor Retido de COFINS.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_valor_retido")
    private BigDecimal cofinsValorRetido;

    /**
     * Valor Retido de CSLL.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("csll_valor_retido")
    private BigDecimal csllValorRetido;

    /**
     * Base de Cálculo do IRRF.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_base_calculo")
    private BigDecimal irrfBaseCalculo;

    /**
     * Valor Retido de IRRF.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("irrf_valor_retido")
    private BigDecimal irrfValorRetido;

    /**
     * Base de Cálculo da Retenção da Previdêncica Social.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_base_calculo")
    private BigDecimal prevSocialBaseCalculo;

    /**
     * Valor da Retenção da Previdêncica Social.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("prev_social_valor_retido")
    private BigDecimal prevSocialValorRetido;

    /**
     * Modalidade do frete.
     */
    @NotNull
    @JsonProperty("modalidade_frete")
    private NFeModalidadeFreteEnum modalidadeFrete;

    /**
     * CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
     */
    @Size(max = 14)
    @JsonProperty("cnpj_transportador")
    private String cnpjTransportador;

    /**
     * CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
     */
    @Size(max = 11)
    @JsonProperty("cpf_transportador")
    private String cpfTransportador;

    /**
     * Nome ou razão social do transportador.
     */
    @Size(min = 2, max = 60)
    @JsonProperty("nome_transportador")
    private String nomeTransportador;

    /**
     * Inscrição Estadual do transportador.
     */
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_transportador")
    private String inscricaoEstadualTransportador;

    /**
     * Endereço (logradouro, número, complemento e bairro) do transportador.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("endereco_transportador")
    private String enderecoTransportador;

    /**
     * Município do transportador.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("municipio_transportador")
    private String municipioTransportador;

    /**
     * UF do transportador.
     */
    @JsonProperty("uf_transportador")
    private NFeUnidadeFederativaEnum ufTransportador;

    /**
     * Valor do serviço de transporte.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_servico")
    private BigDecimal transporteIcmsServico;

    /**
     * Base de cálculo da retenção do ICMS de transporte.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_base_calculo")
    private BigDecimal transporteIcmsBaseCalculo;

    /**
     * Alíquota da retenção do ICMS de transporte.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_aliquota")
    private BigDecimal transporteIcmsAliquota;

    /**
     * Valor retido do ICMS de transporte.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("transporte_icms_valor")
    private BigDecimal transporteIcmsValor;

    /**
     * CFOP do serviço de transporte.
     * (Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358).
     */
    @Size(max = 4)
    @JsonProperty("transporte_icms_cfop")
    private String transporteIcmsCfop;

    /**
     * Código do município de ocorrência do fato gerador.
     */
    @Size(max = 7)
    @JsonProperty("transporte_icms_codigo_municipio")
    private String transporteIcmsCodigoMunicipio;

    /**
     * Placa do veículo de transporte.
     */
    @JsonProperty("veiculo_placa")
    private String veiculoPlaca;

    /**
     * UF do veículo de transporte.
     */
    @JsonProperty("veiculo_uf")
    private NFeUnidadeFederativaEnum veiculoUf;

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    @JsonProperty("veiculo_rntc")
    private String veiculoRntc;

    /**
     * Reboques.
     */
    @Size(max = 5)
    @JsonProperty("reboques")
    private List<NFeReboque> reboques;

    /**
     * Identificação do vagão de transporte.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_vagao")
    private String veiculoIdentificacaoVagao;

    /**
     * Identificação da balsa de transporte.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_identificacao_balsa")
    private String veiculoIdentificacaoBalsa;

    /**
     * Volumes transportados.
     */
    @Size(max = 5000)
    @JsonProperty("volumes")
    private List<NFeVolumeTransportado> volumes;

    /**
     * Número da fatura.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("numero_fatura")
    private String numeroFatura;

    /**
     * Valor original da fatura.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_original_fatura")
    private BigDecimal valorOriginalFatura;

    /**
     * Valor do desconto da fatura.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto_fatura")
    private BigDecimal valorDescontoFatura;

    /**
     * Valor líquido da fatura.
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_liquido_fatura")
    private BigDecimal valorLiquidoFatura;

    /**
     * Duplicatas da nota fiscal.
     */
    @Size(max = 120)
    @JsonProperty("duplicatas")
    private List<NFeDuplicataNotaFiscal> duplicatas;

    /**
     * Formas de Pagamento (Tanto NF-e quanto NFC-e).
     */
    @Size(max = 100)
    @JsonProperty("formas_pagamento")
    private List<NFeFormaPagamento> formasPagamento;

    /**
     * Informações adicionais de interesse do fisco.
     */
    @Size(min = 1, max = 2000)
    @JsonProperty("informacoes_adicionais_fisco")
    private String informacoesAdicionaisFisco;

    /**
     * Informações adicionais de interesse do contribuinte.
     */
    @Size(min = 1, max = 5000)
    @JsonProperty("informacoes_adicionais_contribuinte")
    private String informacoesAdicionaisContribuinte;

    /**
     * Sigla da UF de Embarque ou de transposição de fronteira.
     */
    @JsonProperty("uf_local_embarque")
    private NFeUnidadeFederativaEnum ufLocalEmbarque;

    /**
     * Descrição do Local de Embarque ou de transposição de fronteira.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("local_embarque")
    private String localEmbarque;

    /**
     * Descrição do local de despacho.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("local_despacho")
    private String localDespacho;

    public NFeEnvioRequisicaoNotaFiscal() {
        super();
    }

    private NFeEnvioRequisicaoNotaFiscal(Builder builder) {
        setNaturezaOperacao(builder.naturezaOperacao);
        setSerie(builder.serie);
        setNumero(builder.numero);
        setDataEmissao(builder.dataEmissao);
        setDataEntradaSaida(builder.dataEntradaSaida);
        setTipoDocumento(builder.tipoDocumento);
        setLocalDestino(builder.localDestino);
        setFinalidadeEmissao(builder.finalidadeEmissao);
        setConsumidorFinal(builder.consumidorFinal);
        setPresencaComprador(builder.presencaComprador);
        setNotasReferenciadas(builder.notasReferenciadas);
        setCnpjEmitente(builder.cnpjEmitente);
        setNomeEmitente(builder.nomeEmitente);
        setNomeFantasiaEmitente(builder.nomeFantasiaEmitente);
        setLogradouroEmitente(builder.logradouroEmitente);
        setNumeroEmitente(builder.numeroEmitente);
        setComplementoEmitente(builder.complementoEmitente);
        setBairroEmitente(builder.bairroEmitente);
        setCodigoMunicipioEmitente(builder.codigoMunicipioEmitente);
        setMunicipioEmitente(builder.municipioEmitente);
        setUfEmitente(builder.ufEmitente);
        setCepEmitente(builder.cepEmitente);
        setCodigoPaisEmitente(builder.codigoPaisEmitente);
        setPaisEmitente(builder.paisEmitente);
        setTelefoneEmitente(builder.telefoneEmitente);
        setInscricaoEstadualEmitente(builder.inscricaoEstadualEmitente);
        setInscricaoEstadualStEmitente(builder.inscricaoEstadualStEmitente);
        setInscricaoMunicipalEmitente(builder.inscricaoMunicipalEmitente);
        setCnaeFiscalEmitente(builder.cnaeFiscalEmitente);
        setRegimeTributarioEmitente(builder.regimeTributarioEmitente);
        setCnpjDestinatario(builder.cnpjDestinatario);
        setCpfDestinatario(builder.cpfDestinatario);
        setIdEstrangeiroDestinatario(builder.idEstrangeiroDestinatario);
        setNomeDestinatario(builder.nomeDestinatario);
        setLogradouroDestinatario(builder.logradouroDestinatario);
        setNumeroDestinatario(builder.numeroDestinatario);
        setComplementoDestinatario(builder.complementoDestinatario);
        setBairroDestinatario(builder.bairroDestinatario);
        setCodigoMunicipioDestinatario(builder.codigoMunicipioDestinatario);
        setMunicipioDestinatario(builder.municipioDestinatario);
        setUfDestinatario(builder.ufDestinatario);
        setCepDestinatario(builder.cepDestinatario);
        setCodigoPaisDestinatario(builder.codigoPaisDestinatario);
        setPaisDestinatario(builder.paisDestinatario);
        setTelefoneDestinatario(builder.telefoneDestinatario);
        setIndicadorInscricaoEstadualDestinatario(builder.indicadorInscricaoEstadualDestinatario);
        setInscricaoEstadualDestinatario(builder.inscricaoEstadualDestinatario);
        setInscricaoSuframaDestinatario(builder.inscricaoSuframaDestinatario);
        setInscricaoMunicipalDestinatario(builder.inscricaoMunicipalDestinatario);
        setEmailDestinatario(builder.emailDestinatario);
        setCnpjRetirada(builder.cnpjRetirada);
        setCpfRetirada(builder.cpfRetirada);
        setLogradouroRetirada(builder.logradouroRetirada);
        setNumeroRetirada(builder.numeroRetirada);
        setComplementoRetirada(builder.complementoRetirada);
        setBairroRetirada(builder.bairroRetirada);
        setCodigoMunicipioRetirada(builder.codigoMunicipioRetirada);
        setMunicipioRetirada(builder.municipioRetirada);
        setUfRetirada(builder.ufRetirada);
        setCnpjEntrega(builder.cnpjEntrega);
        setCpfEntrega(builder.cpfEntrega);
        setLogradouroEntrega(builder.logradouroEntrega);
        setNumeroEntrega(builder.numeroEntrega);
        setComplementoEntrega(builder.complementoEntrega);
        setBairroEntrega(builder.bairroEntrega);
        setCodigoMunicipioEntrega(builder.codigoMunicipioEntrega);
        setMunicipioEntrega(builder.municipioEntrega);
        setUfEntrega(builder.ufEntrega);
        setPessoasAutorizadas(builder.pessoasAutorizadas);
        setItems(builder.items);
        setIcmsBaseCalculo(builder.icmsBaseCalculo);
        setIcmsValorTotal(builder.icmsValorTotal);
        setIcmsValorTotalDesonerado(builder.icmsValorTotalDesonerado);
        setFcpValorTotalUfDestino(builder.fcpValorTotalUfDestino);
        setIcmsValorTotalUfDestino(builder.icmsValorTotalUfDestino);
        setIcmsValorTotalUfRemetente(builder.icmsValorTotalUfRemetente);
        setFcpValorTotal(builder.fcpValorTotal);
        setIcmsBaseCalculoSt(builder.icmsBaseCalculoSt);
        setIcmsValorTotalSt(builder.icmsValorTotalSt);
        setFcpValorTotalSt(builder.fcpValorTotalSt);
        setFcpValorTotalRetidoSt(builder.fcpValorTotalRetidoSt);
        setValorProdutos(builder.valorProdutos);
        setValorFrete(builder.valorFrete);
        setValorSeguro(builder.valorSeguro);
        setValorDesconto(builder.valorDesconto);
        setValorTotalII(builder.valorTotalII);
        setValorIpi(builder.valorIpi);
        setValorIpiDevolvido(builder.valorIpiDevolvido);
        setValorPis(builder.valorPis);
        setValorCofins(builder.valorCofins);
        setValorOutrasDespesas(builder.valorOutrasDespesas);
        setValorTotal(builder.valorTotal);
        setValorTotalTributos(builder.valorTotalTributos);
        setValorTotalServicos(builder.valorTotalServicos);
        setIssqnBaseCalculo(builder.issqnBaseCalculo);
        setIssqnValorTotal(builder.issqnValorTotal);
        setValorPisServicos(builder.valorPisServicos);
        setValorCofinsServicos(builder.valorCofinsServicos);
        setDataPrestacaoServico(builder.dataPrestacaoServico);
        setIssqnValorTotalDeducao(builder.issqnValorTotalDeducao);
        setIssqnValorTotalOutrasRetencoes(builder.issqnValorTotalOutrasRetencoes);
        setIssqnValorTotalDescontoIncondicionado(builder.issqnValorTotalDescontoIncondicionado);
        setIssqnValorTotalDescontoCondicionado(builder.issqnValorTotalDescontoCondicionado);
        setIssqnValorTotalRetencao(builder.issqnValorTotalRetencao);
        setCodigoRegimeEspecialTributacao(builder.codigoRegimeEspecialTributacao);
        setPisValorRetido(builder.pisValorRetido);
        setCofinsValorRetido(builder.cofinsValorRetido);
        setCsllValorRetido(builder.csllValorRetido);
        setIrrfBaseCalculo(builder.irrfBaseCalculo);
        setIrrfValorRetido(builder.irrfValorRetido);
        setPrevSocialBaseCalculo(builder.prevSocialBaseCalculo);
        setPrevSocialValorRetido(builder.prevSocialValorRetido);
        setModalidadeFrete(builder.modalidadeFrete);
        setCnpjTransportador(builder.cnpjTransportador);
        setCpfTransportador(builder.cpfTransportador);
        setNomeTransportador(builder.nomeTransportador);
        setInscricaoEstadualTransportador(builder.inscricaoEstadualTransportador);
        setEnderecoTransportador(builder.enderecoTransportador);
        setMunicipioTransportador(builder.municipioTransportador);
        setUfTransportador(builder.ufTransportador);
        setTransporteIcmsServico(builder.transporteIcmsServico);
        setTransporteIcmsBaseCalculo(builder.transporteIcmsBaseCalculo);
        setTransporteIcmsAliquota(builder.transporteIcmsAliquota);
        setTransporteIcmsValor(builder.transporteIcmsValor);
        setTransporteIcmsCfop(builder.transporteIcmsCfop);
        setTransporteIcmsCodigoMunicipio(builder.transporteIcmsCodigoMunicipio);
        setVeiculoPlaca(builder.veiculoPlaca);
        setVeiculoUf(builder.veiculoUf);
        setVeiculoRntc(builder.veiculoRntc);
        setReboques(builder.reboques);
        setVeiculoIdentificacaoVagao(builder.veiculoIdentificacaoVagao);
        setVeiculoIdentificacaoBalsa(builder.veiculoIdentificacaoBalsa);
        setVolumes(builder.volumes);
        setNumeroFatura(builder.numeroFatura);
        setValorOriginalFatura(builder.valorOriginalFatura);
        setValorDescontoFatura(builder.valorDescontoFatura);
        setValorLiquidoFatura(builder.valorLiquidoFatura);
        setDuplicatas(builder.duplicatas);
        setFormasPagamento(builder.formasPagamento);
        setInformacoesAdicionaisFisco(builder.informacoesAdicionaisFisco);
        setInformacoesAdicionaisContribuinte(builder.informacoesAdicionaisContribuinte);
        setUfLocalEmbarque(builder.ufLocalEmbarque);
        setLocalEmbarque(builder.localEmbarque);
        setLocalDespacho(builder.localDespacho);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Descrição da natureza de operação.
     */
    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    /**
     * Descrição da natureza de operação.
     */
    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    /**
     * Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Data e hora de emissão da emissão da NFe.
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     * Para NFC-e (A diferença máxima permitida de 5 minutos do horário atual).
     */
    public OffsetDateTime getDataEmissao() {
        return dataEmissao;
    }

    /**
     * Data e hora de emissão da emissão da NFe.
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     * Para NFC-e (A diferença máxima permitida de 5 minutos do horário atual).
     */
    public void setDataEmissao(OffsetDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     */
    public OffsetDateTime getDataEntradaSaida() {
        return dataEntradaSaida;
    }

    /**
     * Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
     * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
     */
    public void setDataEntradaSaida(OffsetDateTime dataEntradaSaida) {
        this.dataEntradaSaida = dataEntradaSaida;
    }

    /**
     * Tipo da NFe.
     */
    public NFeTipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Tipo da NFe.
     */
    public void setTipoDocumento(NFeTipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Local onde a operação irá acontecer.
     */
    public NFeLocalDestinoEnum getLocalDestino() {
        return localDestino;
    }

    /**
     * Local onde a operação irá acontecer.
     */
    public void setLocalDestino(NFeLocalDestinoEnum localDestino) {
        this.localDestino = localDestino;
    }

    /**
     * Indicar qual a finalidade da emissão da nota.
     */
    public NFeFinalidadeEmissaoEnum getFinalidadeEmissao() {
        return finalidadeEmissao;
    }

    /**
     * Indicar qual a finalidade da emissão da nota.
     */
    public void setFinalidadeEmissao(NFeFinalidadeEmissaoEnum finalidadeEmissao) {
        this.finalidadeEmissao = finalidadeEmissao;
    }

    /**
     * Indicar se a operação é com consumidor final.
     */
    public NFeConsumidorFinalEnum getConsumidorFinal() {
        return consumidorFinal;
    }

    /**
     * Indicar se a operação é com consumidor final.
     */
    public void setConsumidorFinal(NFeConsumidorFinalEnum consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

    /**
     * Informar como foi a presença do comprador.
     */
    public NFePresencaCompradorEnum getPresencaComprador() {
        return presencaComprador;
    }

    /**
     * Informar como foi a presença do comprador.
     */
    public void setPresencaComprador(NFePresencaCompradorEnum presencaComprador) {
        this.presencaComprador = presencaComprador;
    }

    /**
     * Notas referenciadas.
     */
    public List<NFeNotaReferenciada> getNotasReferenciadas() {
        return notasReferenciadas;
    }

    /**
     * Notas referenciadas.
     */
    public void setNotasReferenciadas(List<NFeNotaReferenciada> notasReferenciadas) {
        this.notasReferenciadas = notasReferenciadas;
    }

    /**
     * CNPJ da empresa emitente.
     */
    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    /**
     * CNPJ da empresa emitente.
     */
    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    /**
     * Razão social da empresa emitente.
     */
    public String getNomeEmitente() {
        return nomeEmitente;
    }

    /**
     * Razão social da empresa emitente.
     */
    public void setNomeEmitente(String nomeEmitente) {
        this.nomeEmitente = nomeEmitente;
    }

    /**
     * Nome fantasia da empresa emitente.
     */
    public String getNomeFantasiaEmitente() {
        return nomeFantasiaEmitente;
    }

    /**
     * Nome fantasia da empresa emitente.
     */
    public void setNomeFantasiaEmitente(String nomeFantasiaEmitente) {
        this.nomeFantasiaEmitente = nomeFantasiaEmitente;
    }

    /**
     * Logradouro (rua, avenida, travessa etc.) da empresa emitente.
     */
    public String getLogradouroEmitente() {
        return logradouroEmitente;
    }

    /**
     * Logradouro (rua, avenida, travessa etc.) da empresa emitente.
     */
    public void setLogradouroEmitente(String logradouroEmitente) {
        this.logradouroEmitente = logradouroEmitente;
    }

    /**
     * Número do endereço da empresa emitente.
     */
    public String getNumeroEmitente() {
        return numeroEmitente;
    }

    /**
     * Número do endereço da empresa emitente.
     */
    public void setNumeroEmitente(String numeroEmitente) {
        this.numeroEmitente = numeroEmitente;
    }

    /**
     * Complemento do endereço da empresa emitente.
     */
    public String getComplementoEmitente() {
        return complementoEmitente;
    }

    /**
     * Complemento do endereço da empresa emitente.
     */
    public void setComplementoEmitente(String complementoEmitente) {
        this.complementoEmitente = complementoEmitente;
    }

    /**
     * Bairro da empresa emitente.
     */
    public String getBairroEmitente() {
        return bairroEmitente;
    }

    /**
     * Bairro da empresa emitente.
     */
    public void setBairroEmitente(String bairroEmitente) {
        this.bairroEmitente = bairroEmitente;
    }

    /**
     * Código do município do emitente (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public String getCodigoMunicipioEmitente() {
        return codigoMunicipioEmitente;
    }

    /**
     * Código do município do emitente (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public void setCodigoMunicipioEmitente(String codigoMunicipioEmitente) {
        this.codigoMunicipioEmitente = codigoMunicipioEmitente;
    }

    /**
     * Município da empresa emitente.
     */
    public String getMunicipioEmitente() {
        return municipioEmitente;
    }

    /**
     * Município da empresa emitente.
     */
    public void setMunicipioEmitente(String municipioEmitente) {
        this.municipioEmitente = municipioEmitente;
    }

    /**
     * UF da empresa emitente.
     */
    public NFeUnidadeFederativaEnum getUfEmitente() {
        return ufEmitente;
    }

    /**
     * UF da empresa emitente.
     */
    public void setUfEmitente(NFeUnidadeFederativaEnum ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    /**
     * CEP da empresa emitente.
     */
    public String getCepEmitente() {
        return cepEmitente;
    }

    /**
     * CEP da empresa emitente.
     */
    public void setCepEmitente(String cepEmitente) {
        this.cepEmitente = cepEmitente;
    }

    /**
     * Código IBGE do país do emitente. (Apenas se diferente de 1058 - Brasil).
     */
    public String getCodigoPaisEmitente() {
        return codigoPaisEmitente;
    }

    /**
     * Código IBGE do país do emitente. (Apenas se diferente de 1058 - Brasil).
     */
    public void setCodigoPaisEmitente(String codigoPaisEmitente) {
        this.codigoPaisEmitente = codigoPaisEmitente;
    }

    /**
     * Nome do país do emitente. (Apenas se diferente de Brasil).
     */
    public String getPaisEmitente() {
        return paisEmitente;
    }

    /**
     * Nome do país do emitente. (Apenas se diferente de Brasil).
     */
    public void setPaisEmitente(String paisEmitente) {
        this.paisEmitente = paisEmitente;
    }

    /**
     * Telefone da empresa emitente.
     */
    public String getTelefoneEmitente() {
        return telefoneEmitente;
    }

    /**
     * Telefone da empresa emitente.
     */
    public void setTelefoneEmitente(String telefoneEmitente) {
        this.telefoneEmitente = telefoneEmitente;
    }

    /**
     * Inscrição Estadual da empresa emitente.
     */
    public String getInscricaoEstadualEmitente() {
        return inscricaoEstadualEmitente;
    }

    /**
     * Inscrição Estadual da empresa emitente.
     */
    public void setInscricaoEstadualEmitente(String inscricaoEstadualEmitente) {
        this.inscricaoEstadualEmitente = inscricaoEstadualEmitente;
    }

    /**
     * Inscrição Estadual do Substituto Tributário da empresa emitente.
     */
    public String getInscricaoEstadualStEmitente() {
        return inscricaoEstadualStEmitente;
    }

    /**
     * Inscrição Estadual do Substituto Tributário da empresa emitente.
     */
    public void setInscricaoEstadualStEmitente(String inscricaoEstadualStEmitente) {
        this.inscricaoEstadualStEmitente = inscricaoEstadualStEmitente;
    }

    /**
     * Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
     */
    public String getInscricaoMunicipalEmitente() {
        return inscricaoMunicipalEmitente;
    }

    /**
     * Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
     */
    public void setInscricaoMunicipalEmitente(String inscricaoMunicipalEmitente) {
        this.inscricaoMunicipalEmitente = inscricaoMunicipalEmitente;
    }

    /**
     * CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
     */
    public String getCnaeFiscalEmitente() {
        return cnaeFiscalEmitente;
    }

    /**
     * CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
     */
    public void setCnaeFiscalEmitente(String cnaeFiscalEmitente) {
        this.cnaeFiscalEmitente = cnaeFiscalEmitente;
    }

    /**
     * Informar qual o regime tributário do emitente.
     */
    public NFeRegimeTributarioEmitenteEnum getRegimeTributarioEmitente() {
        return regimeTributarioEmitente;
    }

    /**
     * Informar qual o regime tributário do emitente.
     */
    public void setRegimeTributarioEmitente(NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente) {
        this.regimeTributarioEmitente = regimeTributarioEmitente;
    }

    /**
     * CNPJ da empresa destinatária - Obrigatório CNPJ ou CPF.
     */
    public String getCnpjDestinatario() {
        return cnpjDestinatario;
    }

    /**
     * CNPJ da empresa destinatária - Obrigatório CNPJ ou CPF.
     */
    public void setCnpjDestinatario(String cnpjDestinatario) {
        this.cnpjDestinatario = cnpjDestinatario;
    }

    /**
     * CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario” - Obrigatório CNPJ ou CPF.
     */
    public String getCpfDestinatario() {
        return cpfDestinatario;
    }

    /**
     * CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario” - Obrigatório CNPJ ou CPF.
     */
    public void setCpfDestinatario(String cpfDestinatario) {
        this.cpfDestinatario = cpfDestinatario;
    }

    /**
     * Identificação do destinatário no caso de comprador estrangeiro.
     */
    public String getIdEstrangeiroDestinatario() {
        return idEstrangeiroDestinatario;
    }

    /**
     * Identificação do destinatário no caso de comprador estrangeiro.
     */
    public void setIdEstrangeiroDestinatario(String idEstrangeiroDestinatario) {
        this.idEstrangeiroDestinatario = idEstrangeiroDestinatario;
    }

    /**
     * Nome completo ou razão social do destinatário.
     */
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    /**
     * Nome completo ou razão social do destinatário.
     */
    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    /**
     * Logradouro (rua, avenida, travessa etc.) do destinatário.
     */
    public String getLogradouroDestinatario() {
        return logradouroDestinatario;
    }

    /**
     * Logradouro (rua, avenida, travessa etc.) do destinatário.
     */
    public void setLogradouroDestinatario(String logradouroDestinatario) {
        this.logradouroDestinatario = logradouroDestinatario;
    }

    /**
     * Número do endereço do destinatário.
     */
    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }

    /**
     * Número do endereço do destinatário.
     */
    public void setNumeroDestinatario(String numeroDestinatario) {
        this.numeroDestinatario = numeroDestinatario;
    }

    /**
     * Complemento do endereço do destinatário.
     */
    public String getComplementoDestinatario() {
        return complementoDestinatario;
    }

    /**
     * Complemento do endereço do destinatário.
     */
    public void setComplementoDestinatario(String complementoDestinatario) {
        this.complementoDestinatario = complementoDestinatario;
    }

    /**
     * Bairro do destinatário.
     */
    public String getBairroDestinatario() {
        return bairroDestinatario;
    }

    /**
     * Bairro do destinatário.
     */
    public void setBairroDestinatario(String bairroDestinatario) {
        this.bairroDestinatario = bairroDestinatario;
    }

    /**
     * Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public String getCodigoMunicipioDestinatario() {
        return codigoMunicipioDestinatario;
    }

    /**
     * Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
     * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public void setCodigoMunicipioDestinatario(String codigoMunicipioDestinatario) {
        this.codigoMunicipioDestinatario = codigoMunicipioDestinatario;
    }

    /**
     * Município do destinatário.
     */
    public String getMunicipioDestinatario() {
        return municipioDestinatario;
    }

    /**
     * Município do destinatário.
     */
    public void setMunicipioDestinatario(String municipioDestinatario) {
        this.municipioDestinatario = municipioDestinatario;
    }

    /**
     * UF do destinatário. Deve ser omitido em operações com o exterior.
     */
    public NFeUnidadeFederativaEnum getUfDestinatario() {
        return ufDestinatario;
    }

    /**
     * UF do destinatário. Deve ser omitido em operações com o exterior.
     */
    public void setUfDestinatario(NFeUnidadeFederativaEnum ufDestinatario) {
        this.ufDestinatario = ufDestinatario;
    }

    /**
     * CEP do destinatário.
     */
    public String getCepDestinatario() {
        return cepDestinatario;
    }

    /**
     * CEP do destinatário.
     */
    public void setCepDestinatario(String cepDestinatario) {
        this.cepDestinatario = cepDestinatario;
    }

    /**
     * Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
     */
    public String getCodigoPaisDestinatario() {
        return codigoPaisDestinatario;
    }

    /**
     * Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
     */
    public void setCodigoPaisDestinatario(String codigoPaisDestinatario) {
        this.codigoPaisDestinatario = codigoPaisDestinatario;
    }

    /**
     * Nome do país do destinatário. (Apenas se diferente de Brasil).
     */
    public String getPaisDestinatario() {
        return paisDestinatario;
    }

    /**
     * Nome do país do destinatário. (Apenas se diferente de Brasil).
     */
    public void setPaisDestinatario(String paisDestinatario) {
        this.paisDestinatario = paisDestinatario;
    }

    /**
     * Telefone do destinatário.
     */
    public String getTelefoneDestinatario() {
        return telefoneDestinatario;
    }

    /**
     * Telefone do destinatário.
     */
    public void setTelefoneDestinatario(String telefoneDestinatario) {
        this.telefoneDestinatario = telefoneDestinatario;
    }

    /**
     * Indicador da Inscrição Estadual do destinatário.
     */
    public NFeIndicadorInscricaoEstadualDestinatarioEnum getIndicadorInscricaoEstadualDestinatario() {
        return indicadorInscricaoEstadualDestinatario;
    }

    /**
     * Indicador da Inscrição Estadual do destinatário.
     */
    public void setIndicadorInscricaoEstadualDestinatario(NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario) {
        this.indicadorInscricaoEstadualDestinatario = indicadorInscricaoEstadualDestinatario;
    }

    /**
     * Informar a Inscrição Estadual do destinatário.
     */
    public String getInscricaoEstadualDestinatario() {
        return inscricaoEstadualDestinatario;
    }

    /**
     * Informar a Inscrição Estadual do destinatário.
     */
    public void setInscricaoEstadualDestinatario(String inscricaoEstadualDestinatario) {
        this.inscricaoEstadualDestinatario = inscricaoEstadualDestinatario;
    }

    /**
     * Inscrição Suframa do destinatário.
     */
    public String getInscricaoSuframaDestinatario() {
        return inscricaoSuframaDestinatario;
    }

    /**
     * Inscrição Suframa do destinatário.
     */
    public void setInscricaoSuframaDestinatario(String inscricaoSuframaDestinatario) {
        this.inscricaoSuframaDestinatario = inscricaoSuframaDestinatario;
    }

    /**
     * Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
     */
    public String getInscricaoMunicipalDestinatario() {
        return inscricaoMunicipalDestinatario;
    }

    /**
     * Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
     */
    public void setInscricaoMunicipalDestinatario(String inscricaoMunicipalDestinatario) {
        this.inscricaoMunicipalDestinatario = inscricaoMunicipalDestinatario;
    }

    /**
     * E-mail do destinatário.
     * O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
     * Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
     */
    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    /**
     * E-mail do destinatário.
     * O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
     * Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
     */
    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    /**
     * CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getCnpjRetirada() {
        return cnpjRetirada;
    }

    /**
     * CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setCnpjRetirada(String cnpjRetirada) {
        this.cnpjRetirada = cnpjRetirada;
    }

    /**
     * CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getCpfRetirada() {
        return cpfRetirada;
    }

    /**
     * CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setCpfRetirada(String cpfRetirada) {
        this.cpfRetirada = cpfRetirada;
    }

    /**
     * Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getLogradouroRetirada() {
        return logradouroRetirada;
    }

    /**
     * Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setLogradouroRetirada(String logradouroRetirada) {
        this.logradouroRetirada = logradouroRetirada;
    }

    /**
     * Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getNumeroRetirada() {
        return numeroRetirada;
    }

    /**
     * Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setNumeroRetirada(String numeroRetirada) {
        this.numeroRetirada = numeroRetirada;
    }

    /**
     * Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getComplementoRetirada() {
        return complementoRetirada;
    }

    /**
     * Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setComplementoRetirada(String complementoRetirada) {
        this.complementoRetirada = complementoRetirada;
    }

    /**
     * Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getBairroRetirada() {
        return bairroRetirada;
    }

    /**
     * Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setBairroRetirada(String bairroRetirada) {
        this.bairroRetirada = bairroRetirada;
    }

    /**
     * Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public String getCodigoMunicipioRetirada() {
        return codigoMunicipioRetirada;
    }

    /**
     * Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public void setCodigoMunicipioRetirada(String codigoMunicipioRetirada) {
        this.codigoMunicipioRetirada = codigoMunicipioRetirada;
    }

    /**
     * Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public String getMunicipioRetirada() {
        return municipioRetirada;
    }

    /**
     * Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setMunicipioRetirada(String municipioRetirada) {
        this.municipioRetirada = municipioRetirada;
    }

    /**
     * UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public NFeUnidadeFederativaEnum getUfRetirada() {
        return ufRetirada;
    }

    /**
     * UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
     */
    public void setUfRetirada(NFeUnidadeFederativaEnum ufRetirada) {
        this.ufRetirada = ufRetirada;
    }

    /**
     * CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getCnpjEntrega() {
        return cnpjEntrega;
    }

    /**
     * CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setCnpjEntrega(String cnpjEntrega) {
        this.cnpjEntrega = cnpjEntrega;
    }

    /**
     * CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getCpfEntrega() {
        return cpfEntrega;
    }

    /**
     * CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setCpfEntrega(String cpfEntrega) {
        this.cpfEntrega = cpfEntrega;
    }

    /**
     * Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getLogradouroEntrega() {
        return logradouroEntrega;
    }

    /**
     * Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setLogradouroEntrega(String logradouroEntrega) {
        this.logradouroEntrega = logradouroEntrega;
    }

    /**
     * Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getNumeroEntrega() {
        return numeroEntrega;
    }

    /**
     * Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setNumeroEntrega(String numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    /**
     * Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getComplementoEntrega() {
        return complementoEntrega;
    }

    /**
     * Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setComplementoEntrega(String complementoEntrega) {
        this.complementoEntrega = complementoEntrega;
    }

    /**
     * Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getBairroEntrega() {
        return bairroEntrega;
    }

    /**
     * Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    /**
     * Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public String getCodigoMunicipioEntrega() {
        return codigoMunicipioEntrega;
    }

    /**
     * Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
     */
    public void setCodigoMunicipioEntrega(String codigoMunicipioEntrega) {
        this.codigoMunicipioEntrega = codigoMunicipioEntrega;
    }

    /**
     * Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public String getMunicipioEntrega() {
        return municipioEntrega;
    }

    /**
     * Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setMunicipioEntrega(String municipioEntrega) {
        this.municipioEntrega = municipioEntrega;
    }

    /**
     * UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public NFeUnidadeFederativaEnum getUfEntrega() {
        return ufEntrega;
    }

    /**
     * UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
     */
    public void setUfEntrega(NFeUnidadeFederativaEnum ufEntrega) {
        this.ufEntrega = ufEntrega;
    }

    /**
     * Pessoas autorizadas a acessar o XML da NF-e.
     */
    public List<NFePessoaAutorizada> getPessoasAutorizadas() {
        return pessoasAutorizadas;
    }

    /**
     * Pessoas autorizadas a acessar o XML da NF-e.
     */
    public void setPessoasAutorizadas(List<NFePessoaAutorizada> pessoasAutorizadas) {
        this.pessoasAutorizadas = pessoasAutorizadas;
    }

    /**
     * Uma NFe irá conter um ou mais itens no campo “items”.
     */
    public List<NFeItem> getItems() {
        return items;
    }

    /**
     * Uma NFe irá conter um ou mais itens no campo “items”.
     */
    public void setItems(List<NFeItem> items) {
        this.items = items;
    }

    /**
     * Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsBaseCalculo() {
        return icmsBaseCalculo;
    }

    /**
     * Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
     */
    public void setIcmsBaseCalculo(BigDecimal icmsBaseCalculo) {
        this.icmsBaseCalculo = icmsBaseCalculo;
    }

    /**
     * Valor total do ICMS. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsValorTotal() {
        return icmsValorTotal;
    }

    /**
     * Valor total do ICMS. Calculado automaticamente se omitido.
     */
    public void setIcmsValorTotal(BigDecimal icmsValorTotal) {
        this.icmsValorTotal = icmsValorTotal;
    }

    /**
     * Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsValorTotalDesonerado() {
        return icmsValorTotalDesonerado;
    }

    /**
     * Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
     */
    public void setIcmsValorTotalDesonerado(BigDecimal icmsValorTotalDesonerado) {
        this.icmsValorTotalDesonerado = icmsValorTotalDesonerado;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
     */
    public BigDecimal getFcpValorTotalUfDestino() {
        return fcpValorTotalUfDestino;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
     */
    public void setFcpValorTotalUfDestino(BigDecimal fcpValorTotalUfDestino) {
        this.fcpValorTotalUfDestino = fcpValorTotalUfDestino;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsValorTotalUfDestino() {
        return icmsValorTotalUfDestino;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
     */
    public void setIcmsValorTotalUfDestino(BigDecimal icmsValorTotalUfDestino) {
        this.icmsValorTotalUfDestino = icmsValorTotalUfDestino;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsValorTotalUfRemetente() {
        return icmsValorTotalUfRemetente;
    }

    /**
     * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
     */
    public void setIcmsValorTotalUfRemetente(BigDecimal icmsValorTotalUfRemetente) {
        this.icmsValorTotalUfRemetente = icmsValorTotalUfRemetente;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
     */
    public BigDecimal getFcpValorTotal() {
        return fcpValorTotal;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
     */
    public void setFcpValorTotal(BigDecimal fcpValorTotal) {
        this.fcpValorTotal = fcpValorTotal;
    }

    /**
     * Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsBaseCalculoSt() {
        return icmsBaseCalculoSt;
    }

    /**
     * Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    public void setIcmsBaseCalculoSt(BigDecimal icmsBaseCalculoSt) {
        this.icmsBaseCalculoSt = icmsBaseCalculoSt;
    }

    /**
     * Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    public BigDecimal getIcmsValorTotalSt() {
        return icmsValorTotalSt;
    }

    /**
     * Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
     */
    public void setIcmsValorTotalSt(BigDecimal icmsValorTotalSt) {
        this.icmsValorTotalSt = icmsValorTotalSt;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
     */
    public BigDecimal getFcpValorTotalSt() {
        return fcpValorTotalSt;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
     */
    public void setFcpValorTotalSt(BigDecimal fcpValorTotalSt) {
        this.fcpValorTotalSt = fcpValorTotalSt;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
     */
    public BigDecimal getFcpValorTotalRetidoSt() {
        return fcpValorTotalRetidoSt;
    }

    /**
     * Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
     */
    public void setFcpValorTotalRetidoSt(BigDecimal fcpValorTotalRetidoSt) {
        this.fcpValorTotalRetidoSt = fcpValorTotalRetidoSt;
    }

    /**
     * Valor total dos produtos. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorProdutos() {
        return valorProdutos;
    }

    /**
     * Valor total dos produtos. Calculado automaticamente se omitido.
     */
    public void setValorProdutos(BigDecimal valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    /**
     * Valor total do frete. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    /**
     * Valor total do frete. Calculado automaticamente se omitido.
     */
    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    /**
     * Valor total do seguro. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    /**
     * Valor total do seguro. Calculado automaticamente se omitido.
     */
    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    /**
     * Valor total do desconto. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    /**
     * Valor total do desconto. Calculado automaticamente se omitido.
     */
    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    /**
     * Valor total do imposto de importação. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorTotalII() {
        return valorTotalII;
    }

    /**
     * Valor total do imposto de importação. Calculado automaticamente se omitido.
     */
    public void setValorTotalII(BigDecimal valorTotalII) {
        this.valorTotalII = valorTotalII;
    }

    /**
     * Valor total do IPI. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    /**
     * Valor total do IPI. Calculado automaticamente se omitido.
     */
    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    /**
     * Valor total do IPI devolvido. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorIpiDevolvido() {
        return valorIpiDevolvido;
    }

    /**
     * Valor total do IPI devolvido. Calculado automaticamente se omitido.
     */
    public void setValorIpiDevolvido(BigDecimal valorIpiDevolvido) {
        this.valorIpiDevolvido = valorIpiDevolvido;
    }

    /**
     * Valor do PIS. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorPis() {
        return valorPis;
    }

    /**
     * Valor do PIS. Calculado automaticamente se omitido.
     */
    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    /**
     * Valor do COFINS. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    /**
     * Valor do COFINS. Calculado automaticamente se omitido.
     */
    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    /**
     * Valor das despesas acessórias. Calculado automaticamente se omitido.
     */
    public BigDecimal getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    /**
     * Valor das despesas acessórias. Calculado automaticamente se omitido.
     */
    public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    /**
     * Valor total da nota fiscal.
     * Se não informado o valor será calculado como:
     * (valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
     * Este campo não será calculado se a nota for de importação (CFOP começando com 3).
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * Valor total da nota fiscal.
     * Se não informado o valor será calculado como:
     * (valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
     * Este campo não será calculado se a nota for de importação (CFOP começando com 3).
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Valor total aproximado dos tributos - calculado automaticamente pela API.
     */
    public BigDecimal getValorTotalTributos() {
        return valorTotalTributos;
    }

    /**
     * Valor total aproximado dos tributos - calculado automaticamente pela API.
     */
    public void setValorTotalTributos(BigDecimal valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }

    /**
     * (ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
     */
    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    /**
     * (ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
     */
    public void setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
    }

    /**
     * (ISSQN) Base de Cálculo do ISS.
     */
    public BigDecimal getIssqnBaseCalculo() {
        return issqnBaseCalculo;
    }

    /**
     * (ISSQN) Base de Cálculo do ISS.
     */
    public void setIssqnBaseCalculo(BigDecimal issqnBaseCalculo) {
        this.issqnBaseCalculo = issqnBaseCalculo;
    }

    /**
     * (ISSQN) Valor Total do ISS.
     */
    public BigDecimal getIssqnValorTotal() {
        return issqnValorTotal;
    }

    /**
     * (ISSQN) Valor Total do ISS.
     */
    public void setIssqnValorTotal(BigDecimal issqnValorTotal) {
        this.issqnValorTotal = issqnValorTotal;
    }

    /**
     * (ISSQN) Valor do PIS sobre serviços.
     */
    public BigDecimal getValorPisServicos() {
        return valorPisServicos;
    }

    /**
     * (ISSQN) Valor do PIS sobre serviços.
     */
    public void setValorPisServicos(BigDecimal valorPisServicos) {
        this.valorPisServicos = valorPisServicos;
    }

    /**
     * (ISSQN) Valor do COFINS sobre serviços.
     */
    public BigDecimal getValorCofinsServicos() {
        return valorCofinsServicos;
    }

    /**
     * (ISSQN) Valor do COFINS sobre serviços.
     */
    public void setValorCofinsServicos(BigDecimal valorCofinsServicos) {
        this.valorCofinsServicos = valorCofinsServicos;
    }

    /**
     * (ISSQN) Data da prestação do serviço. Obrigatório se houver serviços.
     */
    public LocalDate getDataPrestacaoServico() {
        return dataPrestacaoServico;
    }

    /**
     * (ISSQN) Data da prestação do serviço. Obrigatório se houver serviços.
     */
    public void setDataPrestacaoServico(LocalDate dataPrestacaoServico) {
        this.dataPrestacaoServico = dataPrestacaoServico;
    }

    /**
     * (ISSQN) Valor total da dedução para redução da Base de Cálculo.
     */
    public BigDecimal getIssqnValorTotalDeducao() {
        return issqnValorTotalDeducao;
    }

    /**
     * (ISSQN) Valor total da dedução para redução da Base de Cálculo.
     */
    public void setIssqnValorTotalDeducao(BigDecimal issqnValorTotalDeducao) {
        this.issqnValorTotalDeducao = issqnValorTotalDeducao;
    }

    /**
     * (ISSQN) Valor total outras retenções.
     */
    public BigDecimal getIssqnValorTotalOutrasRetencoes() {
        return issqnValorTotalOutrasRetencoes;
    }

    /**
     * (ISSQN) Valor total outras retenções.
     */
    public void setIssqnValorTotalOutrasRetencoes(BigDecimal issqnValorTotalOutrasRetencoes) {
        this.issqnValorTotalOutrasRetencoes = issqnValorTotalOutrasRetencoes;
    }

    /**
     * (ISSQN) Valor total desconto incondicionado.
     */
    public BigDecimal getIssqnValorTotalDescontoIncondicionado() {
        return issqnValorTotalDescontoIncondicionado;
    }

    /**
     * (ISSQN) Valor total desconto incondicionado.
     */
    public void setIssqnValorTotalDescontoIncondicionado(BigDecimal issqnValorTotalDescontoIncondicionado) {
        this.issqnValorTotalDescontoIncondicionado = issqnValorTotalDescontoIncondicionado;
    }

    /**
     * (ISSQN) Valor total desconto condicionado.
     */
    public BigDecimal getIssqnValorTotalDescontoCondicionado() {
        return issqnValorTotalDescontoCondicionado;
    }

    /**
     * (ISSQN) Valor total desconto condicionado.
     */
    public void setIssqnValorTotalDescontoCondicionado(BigDecimal issqnValorTotalDescontoCondicionado) {
        this.issqnValorTotalDescontoCondicionado = issqnValorTotalDescontoCondicionado;
    }

    /**
     * (ISSQN) Valor total retenção ISS.
     */
    public BigDecimal getIssqnValorTotalRetencao() {
        return issqnValorTotalRetencao;
    }

    /**
     * (ISSQN) Valor total retenção ISS.
     */
    public void setIssqnValorTotalRetencao(BigDecimal issqnValorTotalRetencao) {
        this.issqnValorTotalRetencao = issqnValorTotalRetencao;
    }

    /**
     * (ISSQN) Código do regime especial de tributação.
     */
    public NFeCodigoRegimeEspecialTributacaoEnum getCodigoRegimeEspecialTributacao() {
        return codigoRegimeEspecialTributacao;
    }

    /**
     * (ISSQN) Código do regime especial de tributação.
     */
    public void setCodigoRegimeEspecialTributacao(NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao) {
        this.codigoRegimeEspecialTributacao = codigoRegimeEspecialTributacao;
    }

    /**
     * Valor Retido de PIS.
     */
    public BigDecimal getPisValorRetido() {
        return pisValorRetido;
    }

    /**
     * Valor Retido de PIS.
     */
    public void setPisValorRetido(BigDecimal pisValorRetido) {
        this.pisValorRetido = pisValorRetido;
    }

    /**
     * Valor Retido de COFINS.
     */
    public BigDecimal getCofinsValorRetido() {
        return cofinsValorRetido;
    }

    /**
     * Valor Retido de COFINS.
     */
    public void setCofinsValorRetido(BigDecimal cofinsValorRetido) {
        this.cofinsValorRetido = cofinsValorRetido;
    }

    /**
     * Valor Retido de CSLL.
     */
    public BigDecimal getCsllValorRetido() {
        return csllValorRetido;
    }

    /**
     * Valor Retido de CSLL.
     */
    public void setCsllValorRetido(BigDecimal csllValorRetido) {
        this.csllValorRetido = csllValorRetido;
    }

    /**
     * Base de Cálculo do IRRF.
     */
    public BigDecimal getIrrfBaseCalculo() {
        return irrfBaseCalculo;
    }

    /**
     * Base de Cálculo do IRRF.
     */
    public void setIrrfBaseCalculo(BigDecimal irrfBaseCalculo) {
        this.irrfBaseCalculo = irrfBaseCalculo;
    }

    /**
     * Valor Retido de IRRF.
     */
    public BigDecimal getIrrfValorRetido() {
        return irrfValorRetido;
    }

    /**
     * Valor Retido de IRRF.
     */
    public void setIrrfValorRetido(BigDecimal irrfValorRetido) {
        this.irrfValorRetido = irrfValorRetido;
    }

    /**
     * Base de Cálculo da Retenção da Previdêncica Social.
     */
    public BigDecimal getPrevSocialBaseCalculo() {
        return prevSocialBaseCalculo;
    }

    /**
     * Base de Cálculo da Retenção da Previdêncica Social.
     */
    public void setPrevSocialBaseCalculo(BigDecimal prevSocialBaseCalculo) {
        this.prevSocialBaseCalculo = prevSocialBaseCalculo;
    }

    /**
     * Valor da Retenção da Previdêncica Social.
     */
    public BigDecimal getPrevSocialValorRetido() {
        return prevSocialValorRetido;
    }

    /**
     * Valor da Retenção da Previdêncica Social.
     */
    public void setPrevSocialValorRetido(BigDecimal prevSocialValorRetido) {
        this.prevSocialValorRetido = prevSocialValorRetido;
    }

    /**
     * Modalidade do frete.
     */
    public NFeModalidadeFreteEnum getModalidadeFrete() {
        return modalidadeFrete;
    }

    /**
     * Modalidade do frete.
     */
    public void setModalidadeFrete(NFeModalidadeFreteEnum modalidadeFrete) {
        this.modalidadeFrete = modalidadeFrete;
    }

    /**
     * CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
     */
    public String getCnpjTransportador() {
        return cnpjTransportador;
    }

    /**
     * CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
     */
    public void setCnpjTransportador(String cnpjTransportador) {
        this.cnpjTransportador = cnpjTransportador;
    }

    /**
     * CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
     */
    public String getCpfTransportador() {
        return cpfTransportador;
    }

    /**
     * CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
     */
    public void setCpfTransportador(String cpfTransportador) {
        this.cpfTransportador = cpfTransportador;
    }

    /**
     * Nome ou razão social do transportador.
     */
    public String getNomeTransportador() {
        return nomeTransportador;
    }

    /**
     * Nome ou razão social do transportador.
     */
    public void setNomeTransportador(String nomeTransportador) {
        this.nomeTransportador = nomeTransportador;
    }

    /**
     * Inscrição Estadual do transportador.
     */
    public String getInscricaoEstadualTransportador() {
        return inscricaoEstadualTransportador;
    }

    /**
     * Inscrição Estadual do transportador.
     */
    public void setInscricaoEstadualTransportador(String inscricaoEstadualTransportador) {
        this.inscricaoEstadualTransportador = inscricaoEstadualTransportador;
    }

    /**
     * Endereço (logradouro, número, complemento e bairro) do transportador.
     */
    public String getEnderecoTransportador() {
        return enderecoTransportador;
    }

    /**
     * Endereço (logradouro, número, complemento e bairro) do transportador.
     */
    public void setEnderecoTransportador(String enderecoTransportador) {
        this.enderecoTransportador = enderecoTransportador;
    }

    /**
     * Município do transportador.
     */
    public String getMunicipioTransportador() {
        return municipioTransportador;
    }

    /**
     * Município do transportador.
     */
    public void setMunicipioTransportador(String municipioTransportador) {
        this.municipioTransportador = municipioTransportador;
    }

    /**
     * UF do transportador.
     */
    public NFeUnidadeFederativaEnum getUfTransportador() {
        return ufTransportador;
    }

    /**
     * UF do transportador.
     */
    public void setUfTransportador(NFeUnidadeFederativaEnum ufTransportador) {
        this.ufTransportador = ufTransportador;
    }

    /**
     * Valor do serviço de transporte.
     */
    public BigDecimal getTransporteIcmsServico() {
        return transporteIcmsServico;
    }

    /**
     * Valor do serviço de transporte.
     */
    public void setTransporteIcmsServico(BigDecimal transporteIcmsServico) {
        this.transporteIcmsServico = transporteIcmsServico;
    }

    /**
     * Base de cálculo da retenção do ICMS de transporte.
     */
    public BigDecimal getTransporteIcmsBaseCalculo() {
        return transporteIcmsBaseCalculo;
    }

    /**
     * Base de cálculo da retenção do ICMS de transporte.
     */
    public void setTransporteIcmsBaseCalculo(BigDecimal transporteIcmsBaseCalculo) {
        this.transporteIcmsBaseCalculo = transporteIcmsBaseCalculo;
    }

    /**
     * Alíquota da retenção do ICMS de transporte.
     */
    public BigDecimal getTransporteIcmsAliquota() {
        return transporteIcmsAliquota;
    }

    /**
     * Alíquota da retenção do ICMS de transporte.
     */
    public void setTransporteIcmsAliquota(BigDecimal transporteIcmsAliquota) {
        this.transporteIcmsAliquota = transporteIcmsAliquota;
    }

    /**
     * Valor retido do ICMS de transporte.
     */
    public BigDecimal getTransporteIcmsValor() {
        return transporteIcmsValor;
    }

    /**
     * Valor retido do ICMS de transporte.
     */
    public void setTransporteIcmsValor(BigDecimal transporteIcmsValor) {
        this.transporteIcmsValor = transporteIcmsValor;
    }

    /**
     * CFOP do serviço de transporte.
     * (Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358).
     */
    public String getTransporteIcmsCfop() {
        return transporteIcmsCfop;
    }

    /**
     * CFOP do serviço de transporte.
     * (Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358).
     */
    public void setTransporteIcmsCfop(String transporteIcmsCfop) {
        this.transporteIcmsCfop = transporteIcmsCfop;
    }

    /**
     * Código do município de ocorrência do fato gerador.
     */
    public String getTransporteIcmsCodigoMunicipio() {
        return transporteIcmsCodigoMunicipio;
    }

    /**
     * Código do município de ocorrência do fato gerador.
     */
    public void setTransporteIcmsCodigoMunicipio(String transporteIcmsCodigoMunicipio) {
        this.transporteIcmsCodigoMunicipio = transporteIcmsCodigoMunicipio;
    }

    /**
     * Placa do veículo de transporte.
     */
    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    /**
     * Placa do veículo de transporte.
     */
    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    /**
     * UF do veículo de transporte.
     */
    public NFeUnidadeFederativaEnum getVeiculoUf() {
        return veiculoUf;
    }

    /**
     * UF do veículo de transporte.
     */
    public void setVeiculoUf(NFeUnidadeFederativaEnum veiculoUf) {
        this.veiculoUf = veiculoUf;
    }

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    public String getVeiculoRntc() {
        return veiculoRntc;
    }

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    public void setVeiculoRntc(String veiculoRntc) {
        this.veiculoRntc = veiculoRntc;
    }

    /**
     * Reboques.
     */
    public List<NFeReboque> getReboques() {
        return reboques;
    }

    /**
     * Reboques.
     */
    public void setReboques(List<NFeReboque> reboques) {
        this.reboques = reboques;
    }

    /**
     * Identificação do vagão de transporte.
     */
    public String getVeiculoIdentificacaoVagao() {
        return veiculoIdentificacaoVagao;
    }

    /**
     * Identificação do vagão de transporte.
     */
    public void setVeiculoIdentificacaoVagao(String veiculoIdentificacaoVagao) {
        this.veiculoIdentificacaoVagao = veiculoIdentificacaoVagao;
    }

    /**
     * Identificação da balsa de transporte.
     */
    public String getVeiculoIdentificacaoBalsa() {
        return veiculoIdentificacaoBalsa;
    }

    /**
     * Identificação da balsa de transporte.
     */
    public void setVeiculoIdentificacaoBalsa(String veiculoIdentificacaoBalsa) {
        this.veiculoIdentificacaoBalsa = veiculoIdentificacaoBalsa;
    }

    /**
     * Volumes transportados.
     */
    public List<NFeVolumeTransportado> getVolumes() {
        return volumes;
    }

    /**
     * Volumes transportados.
     */
    public void setVolumes(List<NFeVolumeTransportado> volumes) {
        this.volumes = volumes;
    }

    /**
     * Número da fatura.
     */
    public String getNumeroFatura() {
        return numeroFatura;
    }

    /**
     * Número da fatura.
     */
    public void setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    /**
     * Valor original da fatura.
     */
    public BigDecimal getValorOriginalFatura() {
        return valorOriginalFatura;
    }

    /**
     * Valor original da fatura.
     */
    public void setValorOriginalFatura(BigDecimal valorOriginalFatura) {
        this.valorOriginalFatura = valorOriginalFatura;
    }

    /**
     * Valor do desconto da fatura.
     */
    public BigDecimal getValorDescontoFatura() {
        return valorDescontoFatura;
    }

    /**
     * Valor do desconto da fatura.
     */
    public void setValorDescontoFatura(BigDecimal valorDescontoFatura) {
        this.valorDescontoFatura = valorDescontoFatura;
    }

    /**
     * Valor líquido da fatura.
     */
    public BigDecimal getValorLiquidoFatura() {
        return valorLiquidoFatura;
    }

    /**
     * Valor líquido da fatura.
     */
    public void setValorLiquidoFatura(BigDecimal valorLiquidoFatura) {
        this.valorLiquidoFatura = valorLiquidoFatura;
    }

    /**
     * Duplicatas da nota fiscal.
     */
    public List<NFeDuplicataNotaFiscal> getDuplicatas() {
        return duplicatas;
    }

    /**
     * Duplicatas da nota fiscal.
     */
    public void setDuplicatas(List<NFeDuplicataNotaFiscal> duplicatas) {
        this.duplicatas = duplicatas;
    }

    /**
     * Formas de Pagamento (Tanto NF-e quanto NFC-e).
     */
    public List<NFeFormaPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    /**
     * Formas de Pagamento (Tanto NF-e quanto NFC-e).
     */
    public void setFormasPagamento(List<NFeFormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    /**
     * Informações adicionais de interesse do fisco.
     */
    public String getInformacoesAdicionaisFisco() {
        return informacoesAdicionaisFisco;
    }

    /**
     * Informações adicionais de interesse do fisco.
     */
    public void setInformacoesAdicionaisFisco(String informacoesAdicionaisFisco) {
        this.informacoesAdicionaisFisco = informacoesAdicionaisFisco;
    }

    /**
     * Informações adicionais de interesse do contribuinte.
     */
    public String getInformacoesAdicionaisContribuinte() {
        return informacoesAdicionaisContribuinte;
    }

    /**
     * Informações adicionais de interesse do contribuinte.
     */
    public void setInformacoesAdicionaisContribuinte(String informacoesAdicionaisContribuinte) {
        this.informacoesAdicionaisContribuinte = informacoesAdicionaisContribuinte;
    }

    /**
     * Sigla da UF de Embarque ou de transposição de fronteira.
     */
    public NFeUnidadeFederativaEnum getUfLocalEmbarque() {
        return ufLocalEmbarque;
    }

    /**
     * Sigla da UF de Embarque ou de transposição de fronteira.
     */
    public void setUfLocalEmbarque(NFeUnidadeFederativaEnum ufLocalEmbarque) {
        this.ufLocalEmbarque = ufLocalEmbarque;
    }

    /**
     * Descrição do Local de Embarque ou de transposição de fronteira.
     */
    public String getLocalEmbarque() {
        return localEmbarque;
    }

    /**
     * Descrição do Local de Embarque ou de transposição de fronteira.
     */
    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    /**
     * Descrição do local de despacho.
     */
    public String getLocalDespacho() {
        return localDespacho;
    }

    /**
     * Descrição do local de despacho.
     */
    public void setLocalDespacho(String localDespacho) {
        this.localDespacho = localDespacho;
    }

    /**
     * NFeEnvioRequisicaoNotaFiscal Builder Pattern.
     */
    public static final class Builder {

        private String naturezaOperacao;

        private String serie;

        private String numero;

        private OffsetDateTime dataEmissao;

        private OffsetDateTime dataEntradaSaida;

        private NFeTipoDocumentoEnum tipoDocumento;

        private NFeLocalDestinoEnum localDestino;

        private NFeFinalidadeEmissaoEnum finalidadeEmissao;

        private NFeConsumidorFinalEnum consumidorFinal;

        private NFePresencaCompradorEnum presencaComprador;

        private List<NFeNotaReferenciada> notasReferenciadas;

        private String cnpjEmitente;

        private String nomeEmitente;

        private String nomeFantasiaEmitente;

        private String logradouroEmitente;

        private String numeroEmitente;

        private String complementoEmitente;

        private String bairroEmitente;

        private String codigoMunicipioEmitente;

        private String municipioEmitente;

        private NFeUnidadeFederativaEnum ufEmitente;

        private String cepEmitente;

        private String codigoPaisEmitente;

        private String paisEmitente;

        private String telefoneEmitente;

        private String inscricaoEstadualEmitente;

        private String inscricaoEstadualStEmitente;

        private String inscricaoMunicipalEmitente;

        private String cnaeFiscalEmitente;

        private NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;

        private String cnpjDestinatario;

        private String cpfDestinatario;

        private String idEstrangeiroDestinatario;

        private String nomeDestinatario;

        private String logradouroDestinatario;

        private String numeroDestinatario;

        private String complementoDestinatario;

        private String bairroDestinatario;

        private String codigoMunicipioDestinatario;

        private String municipioDestinatario;

        private NFeUnidadeFederativaEnum ufDestinatario;

        private String cepDestinatario;

        private String codigoPaisDestinatario;

        private String paisDestinatario;

        private String telefoneDestinatario;

        private NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;

        private String inscricaoEstadualDestinatario;

        private String inscricaoSuframaDestinatario;

        private String inscricaoMunicipalDestinatario;

        private String emailDestinatario;

        private String cnpjRetirada;

        private String cpfRetirada;

        private String logradouroRetirada;

        private String numeroRetirada;

        private String complementoRetirada;

        private String bairroRetirada;

        private String codigoMunicipioRetirada;

        private String municipioRetirada;

        private NFeUnidadeFederativaEnum ufRetirada;

        private String cnpjEntrega;

        private String cpfEntrega;

        private String logradouroEntrega;

        private String numeroEntrega;

        private String complementoEntrega;

        private String bairroEntrega;

        private String codigoMunicipioEntrega;

        private String municipioEntrega;

        private NFeUnidadeFederativaEnum ufEntrega;

        private List<NFePessoaAutorizada> pessoasAutorizadas;

        private List<NFeItem> items;

        private BigDecimal icmsBaseCalculo;

        private BigDecimal icmsValorTotal;

        private BigDecimal icmsValorTotalDesonerado;

        private BigDecimal fcpValorTotalUfDestino;

        private BigDecimal icmsValorTotalUfDestino;

        private BigDecimal icmsValorTotalUfRemetente;

        private BigDecimal fcpValorTotal;

        private BigDecimal icmsBaseCalculoSt;

        private BigDecimal icmsValorTotalSt;

        private BigDecimal fcpValorTotalSt;

        private BigDecimal fcpValorTotalRetidoSt;

        private BigDecimal valorProdutos;

        private BigDecimal valorFrete;

        private BigDecimal valorSeguro;

        private BigDecimal valorDesconto;

        private BigDecimal valorTotalII;

        private BigDecimal valorIpi;

        private BigDecimal valorIpiDevolvido;

        private BigDecimal valorPis;

        private BigDecimal valorCofins;

        private BigDecimal valorOutrasDespesas;

        private BigDecimal valorTotal;

        private BigDecimal valorTotalTributos;

        private BigDecimal valorTotalServicos;

        private BigDecimal issqnBaseCalculo;

        private BigDecimal issqnValorTotal;

        private BigDecimal valorPisServicos;

        private BigDecimal valorCofinsServicos;

        private LocalDate dataPrestacaoServico;

        private BigDecimal issqnValorTotalDeducao;

        private BigDecimal issqnValorTotalOutrasRetencoes;

        private BigDecimal issqnValorTotalDescontoIncondicionado;

        private BigDecimal issqnValorTotalDescontoCondicionado;

        private BigDecimal issqnValorTotalRetencao;

        private NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;

        private BigDecimal pisValorRetido;

        private BigDecimal cofinsValorRetido;

        private BigDecimal csllValorRetido;

        private BigDecimal irrfBaseCalculo;

        private BigDecimal irrfValorRetido;

        private BigDecimal prevSocialBaseCalculo;

        private BigDecimal prevSocialValorRetido;

        private NFeModalidadeFreteEnum modalidadeFrete;

        private String cnpjTransportador;

        private String cpfTransportador;

        private String nomeTransportador;

        private String inscricaoEstadualTransportador;

        private String enderecoTransportador;

        private String municipioTransportador;

        private NFeUnidadeFederativaEnum ufTransportador;

        private BigDecimal transporteIcmsServico;

        private BigDecimal transporteIcmsBaseCalculo;

        private BigDecimal transporteIcmsAliquota;

        private BigDecimal transporteIcmsValor;

        private String transporteIcmsCfop;

        private String transporteIcmsCodigoMunicipio;

        private String veiculoPlaca;

        private NFeUnidadeFederativaEnum veiculoUf;

        private String veiculoRntc;

        private List<NFeReboque> reboques;

        private String veiculoIdentificacaoVagao;

        private String veiculoIdentificacaoBalsa;

        private List<NFeVolumeTransportado> volumes;

        private String numeroFatura;

        private BigDecimal valorOriginalFatura;

        private BigDecimal valorDescontoFatura;

        private BigDecimal valorLiquidoFatura;

        private List<NFeDuplicataNotaFiscal> duplicatas;

        private List<NFeFormaPagamento> formasPagamento;

        private String informacoesAdicionaisFisco;

        private String informacoesAdicionaisContribuinte;

        private NFeUnidadeFederativaEnum ufLocalEmbarque;

        private String localEmbarque;

        private String localDespacho;

        private Builder() {
        }

        /**
         * Descrição da natureza de operação.
         */
        public Builder withNaturezaOperacao(String val) {
            naturezaOperacao = val;
            return this;
        }

        /**
         * Série da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
         */
        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        /**
         * Número da nota fiscal. Deixe em branco para que a API se responsabilize pela numeração automática (recomendado).
         */
        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        /**
         * Data e hora de emissão da emissão da NFe.
         * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
         * Para NFC-e (A diferença máxima permitida de 5 minutos do horário atual).
         */
        public Builder withDataEmissao(OffsetDateTime val) {
            dataEmissao = val;
            return this;
        }

        /**
         * Data e hora de entrada (em notas de entrada) ou saída (em notas de saída)
         * Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
         */
        public Builder withDataEntradaSaida(OffsetDateTime val) {
            dataEntradaSaida = val;
            return this;
        }

        /**
         * Tipo da NFe.
         */
        public Builder withTipoDocumento(NFeTipoDocumentoEnum val) {
            tipoDocumento = val;
            return this;
        }

        /**
         * Local onde a operação irá acontecer.
         */
        public Builder withLocalDestino(NFeLocalDestinoEnum val) {
            localDestino = val;
            return this;
        }

        /**
         * Indicar qual a finalidade da emissão da nota.
         */
        public Builder withFinalidadeEmissao(NFeFinalidadeEmissaoEnum val) {
            finalidadeEmissao = val;
            return this;
        }

        /**
         * Indicar se a operação é com consumidor final.
         */
        public Builder withConsumidorFinal(NFeConsumidorFinalEnum val) {
            consumidorFinal = val;
            return this;
        }

        /**
         * Informar como foi a presença do comprador.
         */
        public Builder withPresencaComprador(NFePresencaCompradorEnum val) {
            presencaComprador = val;
            return this;
        }

        /**
         * Notas referenciadas.
         */
        public Builder withNotasReferenciadas(List<NFeNotaReferenciada> val) {
            notasReferenciadas = val;
            return this;
        }

        /**
         * CNPJ da empresa emitente.
         */
        public Builder withCnpjEmitente(String val) {
            cnpjEmitente = val;
            return this;
        }

        /**
         * Razão social da empresa emitente.
         */
        public Builder withNomeEmitente(String val) {
            nomeEmitente = val;
            return this;
        }

        /**
         * Nome fantasia da empresa emitente.
         */
        public Builder withNomeFantasiaEmitente(String val) {
            nomeFantasiaEmitente = val;
            return this;
        }

        /**
         * Logradouro (rua, avenida, travessa etc.) da empresa emitente.
         */
        public Builder withLogradouroEmitente(String val) {
            logradouroEmitente = val;
            return this;
        }

        /**
         * Número do endereço da empresa emitente.
         */
        public Builder withNumeroEmitente(String val) {
            numeroEmitente = val;
            return this;
        }

        /**
         * Complemento do endereço da empresa emitente.
         */
        public Builder withComplementoEmitente(String val) {
            complementoEmitente = val;
            return this;
        }

        /**
         * Bairro da empresa emitente.
         */
        public Builder withBairroEmitente(String val) {
            bairroEmitente = val;
            return this;
        }

        /**
         * Código do município do emitente (7 dígitos), de acordo com a tabela do IBGE.
         * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
         */
        public Builder withCodigoMunicipioEmitente(String val) {
            codigoMunicipioEmitente = val;
            return this;
        }

        /**
         * Município da empresa emitente.
         */
        public Builder withMunicipioEmitente(String val) {
            municipioEmitente = val;
            return this;
        }

        /**
         * UF da empresa emitente.
         */
        public Builder withUfEmitente(NFeUnidadeFederativaEnum val) {
            ufEmitente = val;
            return this;
        }

        /**
         * CEP da empresa emitente.
         */
        public Builder withCepEmitente(String val) {
            cepEmitente = val;
            return this;
        }

        /**
         * Código IBGE do país do emitente. (Apenas se diferente de 1058 - Brasil).
         */
        public Builder withCodigoPaisEmitente(String val) {
            codigoPaisEmitente = val;
            return this;
        }

        /**
         * Nome do país do emitente. (Apenas se diferente de Brasil).
         */
        public Builder withPaisEmitente(String val) {
            paisEmitente = val;
            return this;
        }

        /**
         * Telefone da empresa emitente.
         */
        public Builder withTelefoneEmitente(String val) {
            telefoneEmitente = val;
            return this;
        }

        /**
         * Inscrição Estadual da empresa emitente.
         */
        public Builder withInscricaoEstadualEmitente(String val) {
            inscricaoEstadualEmitente = val;
            return this;
        }

        /**
         * Inscrição Estadual do Substituto Tributário da empresa emitente.
         */
        public Builder withInscricaoEstadualStEmitente(String val) {
            inscricaoEstadualStEmitente = val;
            return this;
        }

        /**
         * Inscrição Municipal da empresa emitente. Se este campo for informado também deverá ser informado o CNAE Fiscal do emitente.
         */
        public Builder withInscricaoMunicipalEmitente(String val) {
            inscricaoMunicipalEmitente = val;
            return this;
        }

        /**
         * CNAE Fiscal da empresa emitente. Se este campo for informado também deverá ser informada a Inscrição Municipal do emitente.
         */
        public Builder withCnaeFiscalEmitente(String val) {
            cnaeFiscalEmitente = val;
            return this;
        }

        /**
         * Informar qual o regime tributário do emitente.
         */
        public Builder withRegimeTributarioEmitente(NFeRegimeTributarioEmitenteEnum val) {
            regimeTributarioEmitente = val;
            return this;
        }

        /**
         * CNPJ da empresa destinatária - Obrigatório CNPJ ou CPF.
         */
        public Builder withCnpjDestinatario(String val) {
            cnpjDestinatario = val;
            return this;
        }

        /**
         * CPF do destinatário. Caso utilize este campo, não enviar o campo “cnpf_destinatario” - Obrigatório CNPJ ou CPF.
         */
        public Builder withCpfDestinatario(String val) {
            cpfDestinatario = val;
            return this;
        }

        /**
         * Identificação do destinatário no caso de comprador estrangeiro.
         */
        public Builder withIdEstrangeiroDestinatario(String val) {
            idEstrangeiroDestinatario = val;
            return this;
        }

        /**
         * Nome completo ou razão social do destinatário.
         */
        public Builder withNomeDestinatario(String val) {
            nomeDestinatario = val;
            return this;
        }

        /**
         * Logradouro (rua, avenida, travessa etc.) do destinatário.
         */
        public Builder withLogradouroDestinatario(String val) {
            logradouroDestinatario = val;
            return this;
        }

        /**
         * Número do endereço do destinatário.
         */
        public Builder withNumeroDestinatario(String val) {
            numeroDestinatario = val;
            return this;
        }

        /**
         * Complemento do endereço do destinatário.
         */
        public Builder withComplementoDestinatario(String val) {
            complementoDestinatario = val;
            return this;
        }

        /**
         * Bairro do destinatário.
         */
        public Builder withBairroDestinatario(String val) {
            bairroDestinatario = val;
            return this;
        }

        /**
         * Código do município do destinatário (7 dígitos), de acordo com a tabela do IBGE.
         * Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
         */
        public Builder withCodigoMunicipioDestinatario(String val) {
            codigoMunicipioDestinatario = val;
            return this;
        }

        /**
         * Município do destinatário.
         */
        public Builder withMunicipioDestinatario(String val) {
            municipioDestinatario = val;
            return this;
        }

        /**
         * UF do destinatário. Deve ser omitido em operações com o exterior.
         */
        public Builder withUfDestinatario(NFeUnidadeFederativaEnum val) {
            ufDestinatario = val;
            return this;
        }

        /**
         * CEP do destinatário.
         */
        public Builder withCepDestinatario(String val) {
            cepDestinatario = val;
            return this;
        }

        /**
         * Código IBGE do país do destinatário. (Apenas se diferente de 1058 - Brasil).
         */
        public Builder withCodigoPaisDestinatario(String val) {
            codigoPaisDestinatario = val;
            return this;
        }

        /**
         * Nome do país do destinatário. (Apenas se diferente de Brasil).
         */
        public Builder withPaisDestinatario(String val) {
            paisDestinatario = val;
            return this;
        }

        /**
         * Telefone do destinatário.
         */
        public Builder withTelefoneDestinatario(String val) {
            telefoneDestinatario = val;
            return this;
        }

        /**
         * Indicador da Inscrição Estadual do destinatário.
         */
        public Builder withIndicadorInscricaoEstadualDestinatario(NFeIndicadorInscricaoEstadualDestinatarioEnum val) {
            indicadorInscricaoEstadualDestinatario = val;
            return this;
        }

        /**
         * Informar a Inscrição Estadual do destinatário.
         */
        public Builder withInscricaoEstadualDestinatario(String val) {
            inscricaoEstadualDestinatario = val;
            return this;
        }

        /**
         * Inscrição Suframa do destinatário.
         */
        public Builder withInscricaoSuframaDestinatario(String val) {
            inscricaoSuframaDestinatario = val;
            return this;
        }

        /**
         * Inscrição Municipal do Tomador do Serviço (apenas para NFe conjugada).
         */
        public Builder withInscricaoMunicipalDestinatario(String val) {
            inscricaoMunicipalDestinatario = val;
            return this;
        }

        /**
         * E-mail do destinatário.
         * O destinatário receberá um e-mail com o XML e a DANFE gerados, adicione mais de um email separando por vírgulas.
         * Será informado apenas o primeiro email no XML da NFe mas todos os emails informados receberão os arquivos.
         */
        public Builder withEmailDestinatario(String val) {
            emailDestinatario = val;
            return this;
        }

        /**
         * CNPJ do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withCnpjRetirada(String val) {
            cnpjRetirada = val;
            return this;
        }

        /**
         * CPF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withCpfRetirada(String val) {
            cpfRetirada = val;
            return this;
        }

        /**
         * Logradouro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withLogradouroRetirada(String val) {
            logradouroRetirada = val;
            return this;
        }

        /**
         * Número do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withNumeroRetirada(String val) {
            numeroRetirada = val;
            return this;
        }

        /**
         * Complemento do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withComplementoRetirada(String val) {
            complementoRetirada = val;
            return this;
        }

        /**
         * Bairro do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withBairroRetirada(String val) {
            bairroRetirada = val;
            return this;
        }

        /**
         * Código do município de retirada (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
         */
        public Builder withCodigoMunicipioRetirada(String val) {
            codigoMunicipioRetirada = val;
            return this;
        }

        /**
         * Município do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withMunicipioRetirada(String val) {
            municipioRetirada = val;
            return this;
        }

        /**
         * UF do local de retirada. (Informar apenas quando o local de retirada for diferente do destinatário.)
         */
        public Builder withUfRetirada(NFeUnidadeFederativaEnum val) {
            ufRetirada = val;
            return this;
        }

        /**
         * CNPJ do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withCnpjEntrega(String val) {
            cnpjEntrega = val;
            return this;
        }

        /**
         * CPF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withCpfEntrega(String val) {
            cpfEntrega = val;
            return this;
        }

        /**
         * Logradouro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withLogradouroEntrega(String val) {
            logradouroEntrega = val;
            return this;
        }

        /**
         * Número do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withNumeroEntrega(String val) {
            numeroEntrega = val;
            return this;
        }

        /**
         * Complemento do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withComplementoEntrega(String val) {
            complementoEntrega = val;
            return this;
        }

        /**
         * Bairro do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withBairroEntrega(String val) {
            bairroEntrega = val;
            return this;
        }

        /**
         * Código do município de entrega (7 dígitos), de acordo com a tabela do IBGE. Se não informado o sistema tentará encontrar o código com base no nome do município e da UF.
         */
        public Builder withCodigoMunicipioEntrega(String val) {
            codigoMunicipioEntrega = val;
            return this;
        }

        /**
         * Município do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withMunicipioEntrega(String val) {
            municipioEntrega = val;
            return this;
        }

        /**
         * UF do local de entrega. (Informar apenas quando o local de entrega for diferente do destinatário.)
         */
        public Builder withUfEntrega(NFeUnidadeFederativaEnum val) {
            ufEntrega = val;
            return this;
        }

        /**
         * Pessoas autorizadas a acessar o XML da NF-e.
         */
        public Builder withPessoasAutorizadas(List<NFePessoaAutorizada> val) {
            pessoasAutorizadas = val;
            return this;
        }

        /**
         * Uma NFe irá conter um ou mais itens no campo “items”.
         */
        public Builder withItems(List<NFeItem> val) {
            items = val;
            return this;
        }

        /**
         * Valor total da base de cálculo do ICMS. Calculado automaticamente se omitido.
         */
        public Builder withIcmsBaseCalculo(BigDecimal val) {
            icmsBaseCalculo = val;
            return this;
        }

        /**
         * Valor total do ICMS. Calculado automaticamente se omitido.
         */
        public Builder withIcmsValorTotal(BigDecimal val) {
            icmsValorTotal = val;
            return this;
        }

        /**
         * Valor total do ICMS Desonerado. Calculado automaticamente se omitido.
         */
        public Builder withIcmsValorTotalDesonerado(BigDecimal val) {
            icmsValorTotalDesonerado = val;
            return this;
        }

        /**
         * (apenas para venda interestadual para consumidor final) Valor total do ICMS relativo Fundo de Combate à Pobreza (FCP) da UF de destino. Calculado automaticamente se omitido.
         */
        public Builder withFcpValorTotalUfDestino(BigDecimal val) {
            fcpValorTotalUfDestino = val;
            return this;
        }

        /**
         * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF de destino. Calculado automaticamente se omitido.
         */
        public Builder withIcmsValorTotalUfDestino(BigDecimal val) {
            icmsValorTotalUfDestino = val;
            return this;
        }

        /**
         * (apenas para venda interestadual para consumidor final) Valor total do ICMS Interestadual para a UF do remetente. Calculado automaticamente se omitido.
         */
        public Builder withIcmsValorTotalUfRemetente(BigDecimal val) {
            icmsValorTotalUfRemetente = val;
            return this;
        }

        /**
         * Valor Total do FCP (Fundo de Combate à Pobreza). Calculado automaticamente se omitido.
         */
        public Builder withFcpValorTotal(BigDecimal val) {
            fcpValorTotal = val;
            return this;
        }

        /**
         * Valor total da base de cálculo do ICMS do substituto tributário. Calculado automaticamente se omitido.
         */
        public Builder withIcmsBaseCalculoSt(BigDecimal val) {
            icmsBaseCalculoSt = val;
            return this;
        }

        /**
         * Valor total do ICMS do substituto tributário. Calculado automaticamente se omitido.
         */
        public Builder withIcmsValorTotalSt(BigDecimal val) {
            icmsValorTotalSt = val;
            return this;
        }

        /**
         * Valor Total do FCP (Fundo de Combate à Pobreza) retido por substituição tributária. Calculado automaticamente se omitido.
         */
        public Builder withFcpValorTotalSt(BigDecimal val) {
            fcpValorTotalSt = val;
            return this;
        }

        /**
         * Valor Total do FCP (Fundo de Combate à Pobreza) retido anteriormente substituição tributária. Calculado automaticamente se omitido.
         */
        public Builder withFcpValorTotalRetidoSt(BigDecimal val) {
            fcpValorTotalRetidoSt = val;
            return this;
        }

        /**
         * Valor total dos produtos. Calculado automaticamente se omitido.
         */
        public Builder withValorProdutos(BigDecimal val) {
            valorProdutos = val;
            return this;
        }

        /**
         * Valor total do frete. Calculado automaticamente se omitido.
         */
        public Builder withValorFrete(BigDecimal val) {
            valorFrete = val;
            return this;
        }

        /**
         * Valor total do seguro. Calculado automaticamente se omitido.
         */
        public Builder withValorSeguro(BigDecimal val) {
            valorSeguro = val;
            return this;
        }

        /**
         * Valor total do desconto. Calculado automaticamente se omitido.
         */
        public Builder withValorDesconto(BigDecimal val) {
            valorDesconto = val;
            return this;
        }

        /**
         * Valor total do imposto de importação. Calculado automaticamente se omitido.
         */
        public Builder withValorTotalII(BigDecimal val) {
            valorTotalII = val;
            return this;
        }

        /**
         * Valor total do IPI. Calculado automaticamente se omitido.
         */
        public Builder withValorIpi(BigDecimal val) {
            valorIpi = val;
            return this;
        }

        /**
         * Valor total do IPI devolvido. Calculado automaticamente se omitido.
         */
        public Builder withValorIpiDevolvido(BigDecimal val) {
            valorIpiDevolvido = val;
            return this;
        }

        /**
         * Valor do PIS. Calculado automaticamente se omitido.
         */
        public Builder withValorPis(BigDecimal val) {
            valorPis = val;
            return this;
        }

        /**
         * Valor do COFINS. Calculado automaticamente se omitido.
         */
        public Builder withValorCofins(BigDecimal val) {
            valorCofins = val;
            return this;
        }

        /**
         * Valor das despesas acessórias. Calculado automaticamente se omitido.
         */
        public Builder withValorOutrasDespesas(BigDecimal val) {
            valorOutrasDespesas = val;
            return this;
        }

        /**
         * Valor total da nota fiscal.
         * Se não informado o valor será calculado como:
         * (valor_produtos - valor_desconto - icms_valor_total_desonerado + icms_valor_total_st + valor_frete + valor_seguro + valor_outras_despesas + valor_total_ii + valor_ipi + valor_total_servicos).
         * Este campo não será calculado se a nota for de importação (CFOP começando com 3).
         */
        public Builder withValorTotal(BigDecimal val) {
            valorTotal = val;
            return this;
        }

        /**
         * Valor total aproximado dos tributos - calculado automaticamente pela API.
         */
        public Builder withValorTotalTributos(BigDecimal val) {
            valorTotalTributos = val;
            return this;
        }

        /**
         * (ISSQN) Valor Total dos Serviços sob não-incidência ou não tributados pelo ICMS.
         */
        public Builder withValorTotalServicos(BigDecimal val) {
            valorTotalServicos = val;
            return this;
        }

        /**
         * (ISSQN) Base de Cálculo do ISS.
         */
        public Builder withIssqnBaseCalculo(BigDecimal val) {
            issqnBaseCalculo = val;
            return this;
        }

        /**
         * (ISSQN) Valor Total do ISS.
         */
        public Builder withIssqnValorTotal(BigDecimal val) {
            issqnValorTotal = val;
            return this;
        }

        /**
         * (ISSQN) Valor do PIS sobre serviços.
         */
        public Builder withValorPisServicos(BigDecimal val) {
            valorPisServicos = val;
            return this;
        }

        /**
         * (ISSQN) Valor do COFINS sobre serviços.
         */
        public Builder withValorCofinsServicos(BigDecimal val) {
            valorCofinsServicos = val;
            return this;
        }

        /**
         * (ISSQN) Data da prestação do serviço. Obrigatório se houver serviços.
         */
        public Builder withDataPrestacaoServico(LocalDate val) {
            dataPrestacaoServico = val;
            return this;
        }

        /**
         * (ISSQN) Valor total da dedução para redução da Base de Cálculo.
         */
        public Builder withIssqnValorTotalDeducao(BigDecimal val) {
            issqnValorTotalDeducao = val;
            return this;
        }

        /**
         * (ISSQN) Valor total outras retenções.
         */
        public Builder withIssqnValorTotalOutrasRetencoes(BigDecimal val) {
            issqnValorTotalOutrasRetencoes = val;
            return this;
        }

        /**
         * (ISSQN) Valor total desconto incondicionado.
         */
        public Builder withIssqnValorTotalDescontoIncondicionado(BigDecimal val) {
            issqnValorTotalDescontoIncondicionado = val;
            return this;
        }

        /**
         * (ISSQN) Valor total desconto condicionado.
         */
        public Builder withIssqnValorTotalDescontoCondicionado(BigDecimal val) {
            issqnValorTotalDescontoCondicionado = val;
            return this;
        }

        /**
         * (ISSQN) Valor total retenção ISS.
         */
        public Builder withIssqnValorTotalRetencao(BigDecimal val) {
            issqnValorTotalRetencao = val;
            return this;
        }

        /**
         * (ISSQN) Código do regime especial de tributação.
         */
        public Builder withCodigoRegimeEspecialTributacao(NFeCodigoRegimeEspecialTributacaoEnum val) {
            codigoRegimeEspecialTributacao = val;
            return this;
        }

        /**
         * Valor Retido de PIS.
         */
        public Builder withPisValorRetido(BigDecimal val) {
            pisValorRetido = val;
            return this;
        }

        /**
         * Valor Retido de COFINS.
         */
        public Builder withCofinsValorRetido(BigDecimal val) {
            cofinsValorRetido = val;
            return this;
        }

        /**
         * Valor Retido de CSLL.
         */
        public Builder withCsllValorRetido(BigDecimal val) {
            csllValorRetido = val;
            return this;
        }

        /**
         * Base de Cálculo do IRRF.
         */
        public Builder withIrrfBaseCalculo(BigDecimal val) {
            irrfBaseCalculo = val;
            return this;
        }

        /**
         * Valor Retido de IRRF.
         */
        public Builder withIrrfValorRetido(BigDecimal val) {
            irrfValorRetido = val;
            return this;
        }

        /**
         * Base de Cálculo da Retenção da Previdêncica Social.
         */
        public Builder withPrevSocialBaseCalculo(BigDecimal val) {
            prevSocialBaseCalculo = val;
            return this;
        }

        /**
         * Valor da Retenção da Previdêncica Social.
         */
        public Builder withPrevSocialValorRetido(BigDecimal val) {
            prevSocialValorRetido = val;
            return this;
        }

        /**
         * Modalidade do frete.
         */
        public Builder withModalidadeFrete(NFeModalidadeFreteEnum val) {
            modalidadeFrete = val;
            return this;
        }

        /**
         * CNPJ do transportador. Se este campo for informado não deverá ser informado o CPF.
         */
        public Builder withCnpjTransportador(String val) {
            cnpjTransportador = val;
            return this;
        }

        /**
         * CPF do transportador. Se este campo for informado não deverá ser informado o CNPJ.
         */
        public Builder withCpfTransportador(String val) {
            cpfTransportador = val;
            return this;
        }

        /**
         * Nome ou razão social do transportador.
         */
        public Builder withNomeTransportador(String val) {
            nomeTransportador = val;
            return this;
        }

        /**
         * Inscrição Estadual do transportador.
         */
        public Builder withInscricaoEstadualTransportador(String val) {
            inscricaoEstadualTransportador = val;
            return this;
        }

        /**
         * Endereço (logradouro, número, complemento e bairro) do transportador.
         */
        public Builder withEnderecoTransportador(String val) {
            enderecoTransportador = val;
            return this;
        }

        /**
         * Município do transportador.
         */
        public Builder withMunicipioTransportador(String val) {
            municipioTransportador = val;
            return this;
        }

        /**
         * UF do transportador.
         */
        public Builder withUfTransportador(NFeUnidadeFederativaEnum val) {
            ufTransportador = val;
            return this;
        }

        /**
         * Valor do serviço de transporte.
         */
        public Builder withTransporteIcmsServico(BigDecimal val) {
            transporteIcmsServico = val;
            return this;
        }

        /**
         * Base de cálculo da retenção do ICMS de transporte.
         */
        public Builder withTransporteIcmsBaseCalculo(BigDecimal val) {
            transporteIcmsBaseCalculo = val;
            return this;
        }

        /**
         * Alíquota da retenção do ICMS de transporte.
         */
        public Builder withTransporteIcmsAliquota(BigDecimal val) {
            transporteIcmsAliquota = val;
            return this;
        }

        /**
         * Valor retido do ICMS de transporte.
         */
        public Builder withTransporteIcmsValor(BigDecimal val) {
            transporteIcmsValor = val;
            return this;
        }

        /**
         * CFOP do serviço de transporte.
         * (Valores aceitos: 5351, 5352, 5353, 5354, 5355, 5356, 5357, 5359, 5360, 5931, 5932, 6351, 6352, 6353, 6354, 6355, 6356, 6357, 6359, 6360, 6931, 6932, 7358).
         */
        public Builder withTransporteIcmsCfop(String val) {
            transporteIcmsCfop = val;
            return this;
        }

        /**
         * Código do município de ocorrência do fato gerador.
         */
        public Builder withTransporteIcmsCodigoMunicipio(String val) {
            transporteIcmsCodigoMunicipio = val;
            return this;
        }

        /**
         * Placa do veículo de transporte.
         */
        public Builder withVeiculoPlaca(String val) {
            veiculoPlaca = val;
            return this;
        }

        /**
         * UF do veículo de transporte.
         */
        public Builder withVeiculoUf(NFeUnidadeFederativaEnum val) {
            veiculoUf = val;
            return this;
        }

        /**
         * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
         */
        public Builder withVeiculoRntc(String val) {
            veiculoRntc = val;
            return this;
        }

        /**
         * Reboques.
         */
        public Builder withReboques(List<NFeReboque> val) {
            reboques = val;
            return this;
        }

        /**
         * Identificação do vagão de transporte.
         */
        public Builder withVeiculoIdentificacaoVagao(String val) {
            veiculoIdentificacaoVagao = val;
            return this;
        }

        /**
         * Identificação da balsa de transporte.
         */
        public Builder withVeiculoIdentificacaoBalsa(String val) {
            veiculoIdentificacaoBalsa = val;
            return this;
        }

        /**
         * Volumes transportados.
         */
        public Builder withVolumes(List<NFeVolumeTransportado> val) {
            volumes = val;
            return this;
        }

        /**
         * Número da fatura.
         */
        public Builder withNumeroFatura(String val) {
            numeroFatura = val;
            return this;
        }

        /**
         * Valor original da fatura.
         */
        public Builder withValorOriginalFatura(BigDecimal val) {
            valorOriginalFatura = val;
            return this;
        }

        /**
         * Valor do desconto da fatura.
         */
        public Builder withValorDescontoFatura(BigDecimal val) {
            valorDescontoFatura = val;
            return this;
        }

        /**
         * Valor líquido da fatura.
         */
        public Builder withValorLiquidoFatura(BigDecimal val) {
            valorLiquidoFatura = val;
            return this;
        }

        /**
         * Duplicatas da nota fiscal.
         */
        public Builder withDuplicatas(List<NFeDuplicataNotaFiscal> val) {
            duplicatas = val;
            return this;
        }

        /**
         * Formas de Pagamento (Tanto NF-e quanto NFC-e).
         */
        public Builder withFormasPagamento(List<NFeFormaPagamento> val) {
            formasPagamento = val;
            return this;
        }

        /**
         * Informações adicionais de interesse do fisco.
         */
        public Builder withInformacoesAdicionaisFisco(String val) {
            informacoesAdicionaisFisco = val;
            return this;
        }

        /**
         * Informações adicionais de interesse do contribuinte.
         */
        public Builder withInformacoesAdicionaisContribuinte(String val) {
            informacoesAdicionaisContribuinte = val;
            return this;
        }

        /**
         * Sigla da UF de Embarque ou de transposição de fronteira.
         */
        public Builder withUfLocalEmbarque(NFeUnidadeFederativaEnum val) {
            ufLocalEmbarque = val;
            return this;
        }

        /**
         * Descrição do Local de Embarque ou de transposição de fronteira.
         */
        public Builder withLocalEmbarque(String val) {
            localEmbarque = val;
            return this;
        }

        /**
         * Descrição do local de despacho.
         */
        public Builder withLocalDespacho(String val) {
            localDespacho = val;
            return this;
        }

        public NFeEnvioRequisicaoNotaFiscal build() {
            return new NFeEnvioRequisicaoNotaFiscal(this);
        }
    }
}
