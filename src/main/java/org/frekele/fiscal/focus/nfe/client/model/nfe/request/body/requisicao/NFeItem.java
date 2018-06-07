package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsModalidadeBaseCalculoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsModalidadeBaseCalculoStEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsMotivoDesoneracaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsOrigemEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIncluiNoTotalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIpiSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIssqnIndicadorExigibilidadeEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePisCofinsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoCodigoCorDenatranEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoCondicaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoRestricaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoTipoCombustivelEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoTipoOperacaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeVeiculoVinEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeItem implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Numeração que indica qual a posição do item na nota, deve ser usado numeração sequencial a partir do número “1”.
    @NotNull
    @Size(min = 1, max = 3)
    @JsonProperty("numero_item")
    private String numeroItem;

    //Código interno do produto. Se não existir deve ser usado o CFOP no formato CFOP9999.
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_produto")
    private String codigoProduto;

    //Código GTIN/EAN do produto.
    @Size(max = 14)
    @JsonProperty("codigo_barras_comercial")
    private String codigoBarrasComercial;

    //Descrição do produto.
    @NotNull
    @Size(min = 1, max = 120)
    @JsonProperty("descricao")
    private String descricao;

    //Código NCM do produto.
    //É permitida a informação do gênero (posição do capítulo da NCM) se a operação não for de comércio exterior (importação/exportação) ou o produto não for tributado pelo IPI.
    //Em caso de item de serviço ou item que não tenha produto (ex. transferência de crédito, crédito do ativo imobilizado etc.) informar o código 00.
    @NotNull
    @Size(min = 2, max = 8)
    @JsonProperty("codigo_ncm")
    private String codigoNcm;

    //Codificação NVE - Nomenclatura de Valor Aduaneiro e Estatística (codificação opcional que detalha alguns NCM)
    //Se a mercadoria se enquadrar em mais de uma codificação, informar até 8 codificações principais
    @JsonProperty("nves")
    @Size(max = 8)
    List<NFeNve> nves;

    //Código Especificador da Substituição Tributária – CEST, que identifica a mercadoria sujeita aos regimes de substituicao tributária e de antecipação do recolhimento do imposto.
    //Obrigatório para produto em que incide Substituição Tributária (ICMS-ST)
    @Size(max = 7)
    @JsonProperty("cest")
    private String cest;

    //Indicador de Produção em escala relevante, conforme Cláusula 23 do Convenio ICMS 52/2017:
    @JsonProperty("escala_relevante")
    private Boolean escalaRelevante;

    //CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante.
    @Size(max = 14)
    @JsonProperty("cnpj_fabricante")
    private String cnpjFabricante;

    //Código de Benefício Fiscal utilizado pela UF, aplicado ao item
    @JsonProperty("codigo_beneficio_fiscal_uf")
    private String codigoBeneficioFiscalUf;

    //Código EX TIPI do produto.
    @Size(min = 2, max = 3)
    @JsonProperty("codigo_ex_tipi")
    private String codigoExTipi;

    //CFOP do produto.
    @NotNull
    @Size(max = 4)
    @JsonProperty("cfop")
    private String cfop;

    //Unidade comercial.
    @NotNull
    @Size(min = 1, max = 6)
    @JsonProperty("unidade_comercial")
    private String unidadeComercial;

    //Quantidade da mercadoria.
    @NotNull
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_comercial")
    private BigDecimal quantidadeComercial;

    //Valor unitário comercial.
    @NotNull
    @Digits(integer = 11, fraction = 10)
    @BigDecimalJsonConverter
    @JsonProperty("valor_unitario_comercial")
    private BigDecimal valorUnitarioComercial;

    //Valor bruto. Deve ser igual ao produto de Valor unitário comercial com quantidade comercial.
    //Se não informado é calculado automaticamente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_bruto")
    private BigDecimal valorBruto;

    //Código GTIN/EAN tributável.
    @Size(max = 14)
    @JsonProperty("codigo_barras_tributavel")
    private String codigoBarrasTributavel;

    //Unidade tributável. Se não informado será utilizado o mesmo valor de unidade_comercial.
    @Size(min = 1, max = 6)
    @JsonProperty("unidade_tributavel")
    private String unidadeTributavel;

    //Quantidade tributável. Se não informado será utilizado o mesmo valor de quantidade_comercial.
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_tributavel")
    private BigDecimal quantidadeTributavel;

    //Valor unitário tributável Se não informado será utilizado o mesmo valor de valor_unitario_comercial.
    @Digits(integer = 11, fraction = 10)
    @BigDecimalJsonConverter
    @JsonProperty("valor_unitario_tributavel")
    private BigDecimal valorUnitarioTributavel;

    //Valor do frete.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_frete")
    private BigDecimal valorFrete;

    //Valor do seguro.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_seguro")
    private BigDecimal valorSeguro;

    //Valor do desconto.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valorDesconto;

    //Valor de outras despesas acessórias.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_outras_despesas")
    private BigDecimal valorOutrasDespesas;

    //Valor do item (valor_bruto) compõe valor total da NFe (valor_produtos)?
    @JsonProperty("inclui_no_total")
    private NFeIncluiNoTotalEnum incluiNoTotal;

    //Documentos de importação.
    @Size(max = 100)
    @JsonProperty("documentos_importacao")
    private List<NFeDocumentoImportacao> documentosImportacao;

    //Detalhes de exportação
    @Size(max = 500)
    @JsonProperty("detalhes_exportacao")
    private List<NFeDetalheExportacao> detalhesExportacao;

    //Pedido de Compra.
    @Size(min = 1, max = 15)
    @JsonProperty("pedido_compra")
    private String pedidoCompra;

    //Número do Item de Pedido de Compra.
    @Size(max = 6)
    @JsonProperty("numero_item_pedido_compra")
    private String numeroItemPedidoCompra;

    //Número da FCI (Ficha de Conteúdo de Importação) veja NT 2013/006
    @Size(max = 36)
    @JsonProperty("numero_fci")
    private String numeroFci;

    //Grupo para permitir a rastreabilidade de qualquer produto sujeito a regulações sanitárias, casos de recolhimento/recall, além de defensivos agrícolas,
    //produtos veterinários, odontológicos, medicamentos, bebidas, águas envasadas, embalagens, etc., a partir da indicação de informações de número de lote,
    //data de fabricação/produção, data de validade, etc. Obrigatório o preenchimento deste grupo no caso de medicamentos e produtos farmacêuticos.
    @JsonProperty("rastros")
    private List<NFeRastro> rastros;

    //Tipo da operação.
    @JsonProperty("veiculo_tipo_operacao")
    private NFeVeiculoTipoOperacaoEnum veiculoTipoOperacao;

    //Chassi do veículo - VIN.
    @Size(max = 17)
    @JsonProperty("veiculo_chassi")
    private String veiculoChassi;

    //Cor do veículo (código de cada montadora).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_codigo_cor")
    private String veiculoCodigoCor;

    //Descrição da cor.
    @Size(min = 1, max = 40)
    @JsonProperty("veiculo_descricao_cor")
    private String veiculoDescricaoCor;

    //Potência máxima do motor em cavalo-vapor (CV).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_potencia_motor")
    private String veiculoPotenciaMotor;

    //Capacidade voluntária do motor em centímetros cúbicos (cilindradas/CC).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_cm3")
    private String veiculoCm3;

    //Peso líquido.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_peso_liquido")
    private String veiculoPesoLiquido;

    //Peso bruto.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_peso_bruto")
    private String veiculoPesoBruto;

    //Número de série.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_serie")
    private String veiculoSerie;

    //Tipo de combustível (utilizar tabela do RENAVAM):
    @JsonProperty("veiculo_tipo_combustivel")
    private NFeVeiculoTipoCombustivelEnum veiculoTipoCombustivel;

    //Número do motor.
    @Size(min = 1, max = 21)
    @JsonProperty("veiculo_numero_motor")
    private String veiculoNumeroMotor;

    //Capacidade máxima de tração em toneladas (4 casas decimais).
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_cmt")
    private String veiculoCmt;

    //Distância entre eixos.
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_distancia_eixos")
    private String veiculoDistanciaEixos;

    //Ano do modelo.
    @Size(max = 4)
    @JsonProperty("veiculo_ano_modelo")
    private String veiculoAnoModelo;

    //Ano de fabricação.
    @Size(max = 4)
    @JsonProperty("veiculo_ano_fabricacao")
    private String veiculoAnoFabricacao;

    //Tipo de pintura.
    @Size(max = 1)
    @JsonProperty("veiculo_tipo_pintura")
    private String veiculoTipoPintura;

    //Tipo de veículo (utilizar tabela RENAVAM).
    @Size(min = 1, max = 2)
    @JsonProperty("veiculo_tipo")
    private String veiculoTipo;

    //Espécie de veículo (utilizar tabela RENAVAM).
    @Size(max = 1)
    @JsonProperty("veiculo_especie")
    private String veiculoEspecie;

    //Veículo tem VIN remarcado?
    @JsonProperty("veiculo_codigo_vin")
    private NFeVeiculoVinEnum veiculoCodigoVin;

    //Condição do veículo.
    @JsonProperty("veiculo_condicao")
    private NFeVeiculoCondicaoEnum veiculoCondicao;

    //Código Marca Modelo (utilizar tabela RENAVAM).
    @Size(min = 1, max = 6)
    @JsonProperty("veiculo_codigo_marca_modelo")
    private String veiculoCodigoMarcaModelo;

    //Código da cor segundo as regras de pré-cadastro do DENATRAN.
    @JsonProperty("veiculo_codigo_cor_denatran")
    private NFeVeiculoCodigoCorDenatranEnum veiculoCodigoCorDenatran;

    //Quantidade máxima permitida de passageiros sentados, inclusive motorista.
    @Size(min = 1, max = 3)
    @JsonProperty("veiculo_lotacao")
    private String veiculoLotacao;

    //Restrição.
    @JsonProperty("veiculo_restricao")
    private NFeVeiculoRestricaoEnum veiculoRestricao;

    //Código de Produto da ANVISA
    @Size(max = 13)
    @JsonProperty("medicamento_codigo_anvisa")
    private String medicamentoCodigoAnvisa;

    //Preço Máximo ao consumidor
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("medicamento_preco_maximo_consumidor")
    private BigDecimal medicamentoPrecoMaximoConsumidor;

    //Código de produto da ANP (www.anp.gov.br/simp/)
    @Size(max = 9)
    @JsonProperty("combustivel_codigo_anp")
    private String combustivelCodigoAnp;

    //Descrição do produto conforme ANP
    @Size(min = 2, max = 95)
    @JsonProperty("combustivel_descricao_anp")
    private String combustivelDescricaoAnp;

    //Percentual do GLP derivado do petróleo no produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_glp")
    private BigDecimal combustivelPercentualGlp;

    //Percentual de Gás Natural Nacional – GLGNn para o produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_gas_natural_nacional")
    private BigDecimal combustivelPercentualGasNaturalNacional;

    //Percentual de Gás Natural Importado – GLGNi para o produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_gas_natural_importado")
    private BigDecimal combustivelPercentualGasNaturalImportado;

    //Valor de partida (combustivel_codigo_anp=210203001)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_valor_partida")
    private BigDecimal combustivelValorPartida;

    //Código de autorização / registro do CODIF - Informar apenas quando a UF utilizar o CODIF
    @Size(max = 21)
    @JsonProperty("combustivel_registro_codif")
    private String combustivelRegistroCodif;

    //Quantidade de combustível faturada à temperatura ambiente,
    //Informar quando a quantidade faturada informada no campo quantidade do produto tiver sido ajustada para uma temperatura diferente da ambiente.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_quantidade_temperatura_ambiente")
    private BigDecimal combustivelQuantidadeTemperaturaAmbiente;

    //Sigla da UF de consumo - Informar “EX” para exterior
    @JsonProperty("combustivel_sigla_uf")
    private NFeUnidadeFederativaEnum combustivelSiglaUf;

    //BC da CIDE em quantidade
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_base_calculo")
    private BigDecimal combustivelCideBaseCalculo;

    //Valor da alíquota da CIDE em reais
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_aliquota")
    private BigDecimal combustivelCideAliquota;

    //Valor da CIDE
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_valor")
    private BigDecimal combustivelCideValor;

    //Valor total aproximado dos tributos - calculado automaticamente pela API
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_tributos")
    private BigDecimal valorTotalTributos;

    //Valor da Base de Cálculo do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_base_calculo")
    private BigDecimal issqnBaseCalculo;

    //Alíquota do ISSQN
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_aliquota")
    private BigDecimal issqnAliquota;

    //Valor do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor")
    private BigDecimal issqnValor;

    //Código do município de ocorrência do fato gerador do ISSQN
    @Size(max = 7)
    @JsonProperty("issqn_codigo_municipio")
    private String issqnCodigoMunicipio;

    //Item da Lista de Serviços do ISSQN. Formato: NN.NN
    @Size(max = 5)
    @JsonProperty("issqn_item_lista_servico")
    private String issqnItemListaServico;

    //Valor dedução para redução da Base de Cálculo do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_deducao")
    private BigDecimal issqnValorDeducao;

    //Valor outras retenções do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_outras_retencoes")
    private BigDecimal issqnValorOutrasRetencoes;

    //Valor desconto incondicionado do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_desconto_incondicionado")
    private BigDecimal issqnValorDescontoIncondicionado;

    //Valor desconto condicionado do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_desconto_condicionado")
    private BigDecimal issqnValorDescontoCondicionado;

    //Valor retenção ISS
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_retencao")
    private BigDecimal issqnValorRetencao;

    //Indicador da exigibilidade do ISS: (valor default: 1)
    @JsonProperty("issqn_indicador_exigibilidade")
    private NFeIssqnIndicadorExigibilidadeEnum issqnIndicadorExigibilidade;

    //Código do serviço prestado dentro do município
    @Size(min = 1, max = 20)
    @JsonProperty("issqn_codigo_servico")
    private String issqnCodigoServico;

    //Código do Município de incidência do imposto ISSQN - Tabela do IBGE. Informar “9999999” para serviço fora do País.
    @Size(max = 7)
    @JsonProperty("issqn_codigo_municipio_incidencia")
    private String issqnCodigoMunicipioIncidencia;

    //Código do País onde o serviço foi prestado - Tabela do BACEN. Infomar somente se o município da prestação do serviço for “9999999”.
    @Size(max = 4)
    @JsonProperty("issqn_codigo_pais")
    private String issqnCodigoPais;

    //Número do processo judicial ou administrativo de suspensão da exigibilidade - Informar somente quando declarada a suspensão da exigibilidade do ISSQN
    @Size(min = 1, max = 30)
    @JsonProperty("issqn_numero_processo")
    private String issqnNumeroProcesso;

    //Indicador de incentivo Fiscal ISSQN
    @Size(max = 1)
    @JsonProperty("issqn_indicador_incentivo")
    private String issqnIndicadorIncentivo;

    //Origem da mercadoria.
    @NotNull
    @JsonProperty("icms_origem")
    private NFeIcmsOrigemEnum icmsOrigem;

    //Situação tributária do ICMS.
    @NotNull
    @JsonProperty("icms_situacao_tributaria")
    private NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria;

    //Modalidade de determinação da base de cálculo do ICMS.
    @JsonProperty("icms_modalidade_base_calculo")
    private NFeIcmsModalidadeBaseCalculoEnum icmsMmodalidadeBaseCalculo;

    //Valor da base de cálculo do ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo")
    private BigDecimal icmsBaseCalculo;

    //Valor da base de cálculo do ICMS retido anteriormente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_retido_st")
    private BigDecimal icmsBaseCalculoRetidoSt;

    //Percentual de redução da base de cálculo.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_reducao_base_calculo")
    private BigDecimal icmsReducaoBaseCalculo;

    //Alíquota do ICMS.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota")
    private BigDecimal icmsAliquota;

    //Alíquota do ICMS suportada pelo consumidor final.
    //Informado apenas para icms_situacao_tributaria = 60 ou 500.
    //Deve ser informada a alíquota do cálculo do ICMS-ST, já incluso o FCP caso incida sobre a mercadoria.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_final")
    private BigDecimal icmsAliquotaFinal;

    //Valor do ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor")
    private BigDecimal icmsValor;

    //Valor do ICMS retido anteriormente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_retido_st")
    private BigDecimal icmsValorRetidoSt;

    //Valor do ICMS desonerado.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_desonerado")
    private BigDecimal icmsValorDesonerado;

    //(CST=51) Valor como se não tivesse o diferimento
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_operacao")
    private BigDecimal icmsValorOperacao;

    //(CST=51) Percentual de diferimento
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_percentual_diferimento")
    private BigDecimal icmsPercentualDiferimento;

    //(CST=51) Valor do ICMS diferido (informar o valor realmente devido no campo icms_valor)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_diferido")
    private BigDecimal icmsValorDiferido;

    //Motivo da desoneração do ICMS.
    @JsonProperty("icms_motivo_desoneracao")
    private NFeIcmsMotivoDesoneracaoEnum icmsMotivoDesoneracao;

    //Modalidade de determinação da base de cálculo do ICMS ST.
    @JsonProperty("icms_modalidade_base_calculo_st")
    private NFeIcmsModalidadeBaseCalculoStEnum icmsModalidadeBaseCalculoSt;

    //Percentual da margem de valor adicionado do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_margem_valor_adicionado_st")
    private BigDecimal icmsMargemValorAdicionadoSt;

    //Percentual de redução da base de cálculo do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_reducao_base_calculo_st")
    private BigDecimal icmsReducaoBaseCalculoSt;

    //Valor da base de cálculo do ICMS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_st")
    private BigDecimal icmsBaseCalculoSt;

    //Alíquota do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_st")
    private BigDecimal icmsAliquotaSt;

    //Valor do ICMS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_st")
    private BigDecimal icmsValorSt;

    //Alíquota aplicável de cálculo do crédito (Apenas Simples Nacional).
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_credito_simples")
    private BigDecimal icmsAliquotaCreditoSimples;

    //Valor crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (Apenas Simples Nacional)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_credito_simples")
    private BigDecimal icmsValorCreditoSimples;

    //Percentual do Fundo de Combate à Pobreza (FCP)
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual")
    private BigDecimal fcpPercentual;

    //Valor da Base de Cálculo do FCP
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo")
    private BigDecimal fcpBaseCalculo;

    //Valor do Fundo de Combate à Pobreza (FCP)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor")
    private BigDecimal fcpValor;

    //Percentual do Fundo de Combate à Pobreza (FCP) retido por Substituição Tributária
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_st")
    private BigDecimal fcpPercentualSt;

    //Valor da Base de Cálculo do FCP retido por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_st")
    private BigDecimal fcpBaseCalculoSt;

    //Valor do Fundo de Combate à Pobreza (FCP) retido por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_st")
    private BigDecimal fcpValorSt;

    //Percentual do Fundo de Combate à Pobreza (FCP) retido anteriormente por Substituição Tributária
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_retido_st")
    private BigDecimal fcpPercentualRetidoSt;

    //Valor da Base de Cálculo do FCP retido anteriormente por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_retido_st")
    private BigDecimal fcpBaseCalculoRetidoSt;

    //Valor do Fundo de Combate à Pobreza (FCP) retido anteriormente por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_retido_st")
    private BigDecimal fcpValorRetidoSt;

    //Situação tributária do IPI.
    @JsonProperty("ipi_situacao_tributaria")
    private NFeIpiSituacaoTributariaEnum ipiSituacaoTributaria;

    //Valor da base de cálculo do IPI.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_base_calculo")
    private BigDecimal ipiBaseCalculo;

    //Alíquota do IPI.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_aliquota")
    private BigDecimal ipiAliquota;

    //Quantidade total na unidade padrão para tributação.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_quantidade_total")
    private BigDecimal ipiQuantidadeTotal;

    //Valor por unidade tributável. Informar o valor do imposto pauta por unidade de medida.
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_valor_por_unidade_tributavel")
    private BigDecimal ipiValorPorUnidadeTributavel;

    //Valor do IPI.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_valor")
    private BigDecimal ipiValor;

    //Classe de enquadramento do IPI (para cigarros e bebidas).
    @Size(min = 1, max = 5)
    @JsonProperty("ipi_classe_enquadramento")
    private String ipiClasseEnquadramento;

    //CNPJ do produtor. Informar apenas quando for diferente do emitente, em casos
    @Size(max = 14)
    @JsonProperty("ipi_cnpj_produtor")
    private String ipiCnpjProdutor;

    //Código do selo de controle do IPI.
    @Size(min = 1, max = 60)
    @JsonProperty("ipi_codigo_selo_controle")
    private String ipiCodigoSeloControle;

    //Quantidade de selo de controle.
    @Size(min = 1, max = 12)
    @JsonProperty("ipi_quantidade_selo_controle")
    private String ipiQuantidadeSeloControle;

    //Código de Enquadramento Legal do IPI. Obrigatório quando informado IPI. Utilize o valor 999 se não aplicável
    @Size(max = 3)
    @JsonProperty("ipi_codigo_enquadramento_legal")
    private String ipiCodigoEnquadramentoLegal;

    //Base de cálculo do imposto de importação.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_base_calculo")
    private BigDecimal iiBaseCalculo;

    //Valor das despesas aduaneiras.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_despesas_aduaneiras")
    private BigDecimal iiDespesasAduaneiras;

    //Valor do imposto de importação.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_valor")
    private BigDecimal iiValor;

    //Valor do IOF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_valor_iof")
    private BigDecimal iiValorIof;

    //Situação tributária do PIS.
    @NotNull
    @JsonProperty("pis_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria;

    //Valor da base de cálculo do PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_base_calculo")
    private BigDecimal pisBaseCalculo;

    //Alíquota do PIS em porcentual.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_porcentual")
    private BigDecimal pisAliquotaPorcentual;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_quantidade_vendida")
    private BigDecimal pis_quantidade_vendida;

    //Alíquota do PIS em unidades monetarias.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_valor")
    private BigDecimal pisAliquotaValor;

    //Valor do PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor")
    private BigDecimal pisValor;

    //Valor da base de cálculo do PIS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_base_calculo_st")
    private BigDecimal pisBaseCalculoSt;

    //Alíquota do PIS ST (em percentual).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_porcentual_st")
    private BigDecimal pisAliquotaPorcentualSt;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_quantidade_vendida_st")
    private BigDecimal pisQuantidadeVendidaSt;

    //Alíquota do PIS ST (em unidades monetarias).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_valor_st")
    private BigDecimal pisAliquotaValorSt;

    //Valor do PIS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor_st")
    private BigDecimal pisValorSt;

    //Situação tributária do PIS.
    @NotNull
    @JsonProperty("cofins_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria;

    //Valor da base de cálculo do COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_base_calculo")
    private BigDecimal cofinsBaseCalculo;

    //Alíquota do COFINS em porcentual.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_porcentual")
    private BigDecimal cofinsAliquotaPorcentual;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_quantidade_vendida")
    private BigDecimal cofinsQuantidadeVendida;

    //Alíquota do COFINS em unidades monetarias.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor")
    private BigDecimal cofinsAliquotaValor;

    //Valor do COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor")
    private BigDecimal cofinsValor;

    //Valor da base de cálculo do COFINS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_base_calculo_st")
    private BigDecimal cofinsBaseCalculoSt;

    //Alíquota do COFINS ST (em percentual).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_porcentual_st")
    private BigDecimal cofinsAliquotaPorcentualSt;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_quantidade_vendida_st")
    private BigDecimal cofinsQuantidadeVendidaSt;

    //Alíquota do COFINS ST (em unidades monetarias).
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor_st")
    private BigDecimal cofinsAliquotaValorSt;

    //Valor do COFINS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_valor_st")
    private BigDecimal cofinsValorSt;

    //(apenas para venda interestadual para consumidor final) Valor da BC do ICMS na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_uf_destino")
    private BigDecimal icmsBaseCalculoUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor da BC FCP na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_uf_destino")
    private BigDecimal fcpBaseCalculoUfDestino;

    //(apenas para venda interestadual para consumidor final) Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_uf_destino")
    private BigDecimal fcpPercentualUfDestino;

    //(apenas para venda interestadual para consumidor final) Alíquota interna da UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_interna_uf_destino")
    private BigDecimal icmsAliquotaInternaUfDestino;

    //(apenas para venda interestadual para consumidor final) Alíquota interestadual das UF envolvidas
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_interestadual")
    private BigDecimal icmsAliquotaInterestadual;

    //(apenas para venda interestadual para consumidor final) Percentual provisório de partilha do ICMS Interestadual
    @BigDecimalJsonConverter
    @JsonProperty("icms_percentual_partilha")
    private BigDecimal icmsPercentualPartilha;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_uf_destino")
    private BigDecimal fcpValorUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS Interestadual para a UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_uf_destino")
    private BigDecimal icmsValorUfDestino;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS Interestadual para a UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_uf_remetente")
    private BigDecimal icmsValorUfRemetente;

    //Percentual da mercadoria devolvida
    @Digits(integer = 3, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("percentual_devolvido")
    private BigDecimal percentualDevolvido;

    //Valor do IPI devolvido
    @Digits(integer = 3, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_ipi_devolvido")
    private BigDecimal valorIpiDevolvido;

    //Informações adicionais do item
    @Size(max = 500)
    @JsonProperty("informacoes_adicionais_item")
    private String informacoesAdicionaisItem;

    public NFeItem() {
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
}
