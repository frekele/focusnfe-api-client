package org.frekele.fiscal.focus.nfe.client.model.requisicao;

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
    private List<NFeNve> nves;

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
    private BigDecimal pisQuantidadeVendida;

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

    private NFeItem(Builder builder) {
        setNumeroItem(builder.numeroItem);
        setCodigoProduto(builder.codigoProduto);
        setCodigoBarrasComercial(builder.codigoBarrasComercial);
        setDescricao(builder.descricao);
        setCodigoNcm(builder.codigoNcm);
        setNves(builder.nves);
        setCest(builder.cest);
        setEscalaRelevante(builder.escalaRelevante);
        setCnpjFabricante(builder.cnpjFabricante);
        setCodigoBeneficioFiscalUf(builder.codigoBeneficioFiscalUf);
        setCodigoExTipi(builder.codigoExTipi);
        setCfop(builder.cfop);
        setUnidadeComercial(builder.unidadeComercial);
        setQuantidadeComercial(builder.quantidadeComercial);
        setValorUnitarioComercial(builder.valorUnitarioComercial);
        setValorBruto(builder.valorBruto);
        setCodigoBarrasTributavel(builder.codigoBarrasTributavel);
        setUnidadeTributavel(builder.unidadeTributavel);
        setQuantidadeTributavel(builder.quantidadeTributavel);
        setValorUnitarioTributavel(builder.valorUnitarioTributavel);
        setValorFrete(builder.valorFrete);
        setValorSeguro(builder.valorSeguro);
        setValorDesconto(builder.valorDesconto);
        setValorOutrasDespesas(builder.valorOutrasDespesas);
        setIncluiNoTotal(builder.incluiNoTotal);
        setDocumentosImportacao(builder.documentosImportacao);
        setDetalhesExportacao(builder.detalhesExportacao);
        setPedidoCompra(builder.pedidoCompra);
        setNumeroItemPedidoCompra(builder.numeroItemPedidoCompra);
        setNumeroFci(builder.numeroFci);
        setRastros(builder.rastros);
        setVeiculoTipoOperacao(builder.veiculoTipoOperacao);
        setVeiculoChassi(builder.veiculoChassi);
        setVeiculoCodigoCor(builder.veiculoCodigoCor);
        setVeiculoDescricaoCor(builder.veiculoDescricaoCor);
        setVeiculoPotenciaMotor(builder.veiculoPotenciaMotor);
        setVeiculoCm3(builder.veiculoCm3);
        setVeiculoPesoLiquido(builder.veiculoPesoLiquido);
        setVeiculoPesoBruto(builder.veiculoPesoBruto);
        setVeiculoSerie(builder.veiculoSerie);
        setVeiculoTipoCombustivel(builder.veiculoTipoCombustivel);
        setVeiculoNumeroMotor(builder.veiculoNumeroMotor);
        setVeiculoCmt(builder.veiculoCmt);
        setVeiculoDistanciaEixos(builder.veiculoDistanciaEixos);
        setVeiculoAnoModelo(builder.veiculoAnoModelo);
        setVeiculoAnoFabricacao(builder.veiculoAnoFabricacao);
        setVeiculoTipoPintura(builder.veiculoTipoPintura);
        setVeiculoTipo(builder.veiculoTipo);
        setVeiculoEspecie(builder.veiculoEspecie);
        setVeiculoCodigoVin(builder.veiculoCodigoVin);
        setVeiculoCondicao(builder.veiculoCondicao);
        setVeiculoCodigoMarcaModelo(builder.veiculoCodigoMarcaModelo);
        setVeiculoCodigoCorDenatran(builder.veiculoCodigoCorDenatran);
        setVeiculoLotacao(builder.veiculoLotacao);
        setVeiculoRestricao(builder.veiculoRestricao);
        setMedicamentoCodigoAnvisa(builder.medicamentoCodigoAnvisa);
        setMedicamentoPrecoMaximoConsumidor(builder.medicamentoPrecoMaximoConsumidor);
        setCombustivelCodigoAnp(builder.combustivelCodigoAnp);
        setCombustivelDescricaoAnp(builder.combustivelDescricaoAnp);
        setCombustivelPercentualGlp(builder.combustivelPercentualGlp);
        setCombustivelPercentualGasNaturalNacional(builder.combustivelPercentualGasNaturalNacional);
        setCombustivelPercentualGasNaturalImportado(builder.combustivelPercentualGasNaturalImportado);
        setCombustivelValorPartida(builder.combustivelValorPartida);
        setCombustivelRegistroCodif(builder.combustivelRegistroCodif);
        setCombustivelQuantidadeTemperaturaAmbiente(builder.combustivelQuantidadeTemperaturaAmbiente);
        setCombustivelSiglaUf(builder.combustivelSiglaUf);
        setCombustivelCideBaseCalculo(builder.combustivelCideBaseCalculo);
        setCombustivelCideAliquota(builder.combustivelCideAliquota);
        setCombustivelCideValor(builder.combustivelCideValor);
        setValorTotalTributos(builder.valorTotalTributos);
        setIssqnBaseCalculo(builder.issqnBaseCalculo);
        setIssqnAliquota(builder.issqnAliquota);
        setIssqnValor(builder.issqnValor);
        setIssqnCodigoMunicipio(builder.issqnCodigoMunicipio);
        setIssqnItemListaServico(builder.issqnItemListaServico);
        setIssqnValorDeducao(builder.issqnValorDeducao);
        setIssqnValorOutrasRetencoes(builder.issqnValorOutrasRetencoes);
        setIssqnValorDescontoIncondicionado(builder.issqnValorDescontoIncondicionado);
        setIssqnValorDescontoCondicionado(builder.issqnValorDescontoCondicionado);
        setIssqnValorRetencao(builder.issqnValorRetencao);
        setIssqnIndicadorExigibilidade(builder.issqnIndicadorExigibilidade);
        setIssqnCodigoServico(builder.issqnCodigoServico);
        setIssqnCodigoMunicipioIncidencia(builder.issqnCodigoMunicipioIncidencia);
        setIssqnCodigoPais(builder.issqnCodigoPais);
        setIssqnNumeroProcesso(builder.issqnNumeroProcesso);
        setIssqnIndicadorIncentivo(builder.issqnIndicadorIncentivo);
        setIcmsOrigem(builder.icmsOrigem);
        setIcmsSituacaoTributaria(builder.icmsSituacaoTributaria);
        setIcmsMmodalidadeBaseCalculo(builder.icmsMmodalidadeBaseCalculo);
        setIcmsBaseCalculo(builder.icmsBaseCalculo);
        setIcmsBaseCalculoRetidoSt(builder.icmsBaseCalculoRetidoSt);
        setIcmsReducaoBaseCalculo(builder.icmsReducaoBaseCalculo);
        setIcmsAliquota(builder.icmsAliquota);
        setIcmsAliquotaFinal(builder.icmsAliquotaFinal);
        setIcmsValor(builder.icmsValor);
        setIcmsValorRetidoSt(builder.icmsValorRetidoSt);
        setIcmsValorDesonerado(builder.icmsValorDesonerado);
        setIcmsValorOperacao(builder.icmsValorOperacao);
        setIcmsPercentualDiferimento(builder.icmsPercentualDiferimento);
        setIcmsValorDiferido(builder.icmsValorDiferido);
        setIcmsMotivoDesoneracao(builder.icmsMotivoDesoneracao);
        setIcmsModalidadeBaseCalculoSt(builder.icmsModalidadeBaseCalculoSt);
        setIcmsMargemValorAdicionadoSt(builder.icmsMargemValorAdicionadoSt);
        setIcmsReducaoBaseCalculoSt(builder.icmsReducaoBaseCalculoSt);
        setIcmsBaseCalculoSt(builder.icmsBaseCalculoSt);
        setIcmsAliquotaSt(builder.icmsAliquotaSt);
        setIcmsValorSt(builder.icmsValorSt);
        setIcmsAliquotaCreditoSimples(builder.icmsAliquotaCreditoSimples);
        setIcmsValorCreditoSimples(builder.icmsValorCreditoSimples);
        setFcpPercentual(builder.fcpPercentual);
        setFcpBaseCalculo(builder.fcpBaseCalculo);
        setFcpValor(builder.fcpValor);
        setFcpPercentualSt(builder.fcpPercentualSt);
        setFcpBaseCalculoSt(builder.fcpBaseCalculoSt);
        setFcpValorSt(builder.fcpValorSt);
        setFcpPercentualRetidoSt(builder.fcpPercentualRetidoSt);
        setFcpBaseCalculoRetidoSt(builder.fcpBaseCalculoRetidoSt);
        setFcpValorRetidoSt(builder.fcpValorRetidoSt);
        setIpiSituacaoTributaria(builder.ipiSituacaoTributaria);
        setIpiBaseCalculo(builder.ipiBaseCalculo);
        setIpiAliquota(builder.ipiAliquota);
        setIpiQuantidadeTotal(builder.ipiQuantidadeTotal);
        setIpiValorPorUnidadeTributavel(builder.ipiValorPorUnidadeTributavel);
        setIpiValor(builder.ipiValor);
        setIpiClasseEnquadramento(builder.ipiClasseEnquadramento);
        setIpiCnpjProdutor(builder.ipiCnpjProdutor);
        setIpiCodigoSeloControle(builder.ipiCodigoSeloControle);
        setIpiQuantidadeSeloControle(builder.ipiQuantidadeSeloControle);
        setIpiCodigoEnquadramentoLegal(builder.ipiCodigoEnquadramentoLegal);
        setIiBaseCalculo(builder.iiBaseCalculo);
        setIiDespesasAduaneiras(builder.iiDespesasAduaneiras);
        setIiValor(builder.iiValor);
        setIiValorIof(builder.iiValorIof);
        setPisSituacaoTributaria(builder.pisSituacaoTributaria);
        setPisBaseCalculo(builder.pisBaseCalculo);
        setPisAliquotaPorcentual(builder.pisAliquotaPorcentual);
        setPisQuantidadeVendida(builder.pisQuantidadeVendida);
        setPisAliquotaValor(builder.pisAliquotaValor);
        setPisValor(builder.pisValor);
        setPisBaseCalculoSt(builder.pisBaseCalculoSt);
        setPisAliquotaPorcentualSt(builder.pisAliquotaPorcentualSt);
        setPisQuantidadeVendidaSt(builder.pisQuantidadeVendidaSt);
        setPisAliquotaValorSt(builder.pisAliquotaValorSt);
        setPisValorSt(builder.pisValorSt);
        setCofinsSituacaoTributaria(builder.cofinsSituacaoTributaria);
        setCofinsBaseCalculo(builder.cofinsBaseCalculo);
        setCofinsAliquotaPorcentual(builder.cofinsAliquotaPorcentual);
        setCofinsQuantidadeVendida(builder.cofinsQuantidadeVendida);
        setCofinsAliquotaValor(builder.cofinsAliquotaValor);
        setCofinsValor(builder.cofinsValor);
        setCofinsBaseCalculoSt(builder.cofinsBaseCalculoSt);
        setCofinsAliquotaPorcentualSt(builder.cofinsAliquotaPorcentualSt);
        setCofinsQuantidadeVendidaSt(builder.cofinsQuantidadeVendidaSt);
        setCofinsAliquotaValorSt(builder.cofinsAliquotaValorSt);
        setCofinsValorSt(builder.cofinsValorSt);
        setIcmsBaseCalculoUfDestino(builder.icmsBaseCalculoUfDestino);
        setFcpBaseCalculoUfDestino(builder.fcpBaseCalculoUfDestino);
        setFcpPercentualUfDestino(builder.fcpPercentualUfDestino);
        setIcmsAliquotaInternaUfDestino(builder.icmsAliquotaInternaUfDestino);
        setIcmsAliquotaInterestadual(builder.icmsAliquotaInterestadual);
        setIcmsPercentualPartilha(builder.icmsPercentualPartilha);
        setFcpValorUfDestino(builder.fcpValorUfDestino);
        setIcmsValorUfDestino(builder.icmsValorUfDestino);
        setIcmsValorUfRemetente(builder.icmsValorUfRemetente);
        setPercentualDevolvido(builder.percentualDevolvido);
        setValorIpiDevolvido(builder.valorIpiDevolvido);
        setInformacoesAdicionaisItem(builder.informacoesAdicionaisItem);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(String numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCodigoBarrasComercial() {
        return codigoBarrasComercial;
    }

    public void setCodigoBarrasComercial(String codigoBarrasComercial) {
        this.codigoBarrasComercial = codigoBarrasComercial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoNcm() {
        return codigoNcm;
    }

    public void setCodigoNcm(String codigoNcm) {
        this.codigoNcm = codigoNcm;
    }

    public List<NFeNve> getNves() {
        return nves;
    }

    public void setNves(List<NFeNve> nves) {
        this.nves = nves;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public Boolean getEscalaRelevante() {
        return escalaRelevante;
    }

    public void setEscalaRelevante(Boolean escalaRelevante) {
        this.escalaRelevante = escalaRelevante;
    }

    public String getCnpjFabricante() {
        return cnpjFabricante;
    }

    public void setCnpjFabricante(String cnpjFabricante) {
        this.cnpjFabricante = cnpjFabricante;
    }

    public String getCodigoBeneficioFiscalUf() {
        return codigoBeneficioFiscalUf;
    }

    public void setCodigoBeneficioFiscalUf(String codigoBeneficioFiscalUf) {
        this.codigoBeneficioFiscalUf = codigoBeneficioFiscalUf;
    }

    public String getCodigoExTipi() {
        return codigoExTipi;
    }

    public void setCodigoExTipi(String codigoExTipi) {
        this.codigoExTipi = codigoExTipi;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getUnidadeComercial() {
        return unidadeComercial;
    }

    public void setUnidadeComercial(String unidadeComercial) {
        this.unidadeComercial = unidadeComercial;
    }

    public BigDecimal getQuantidadeComercial() {
        return quantidadeComercial;
    }

    public void setQuantidadeComercial(BigDecimal quantidadeComercial) {
        this.quantidadeComercial = quantidadeComercial;
    }

    public BigDecimal getValorUnitarioComercial() {
        return valorUnitarioComercial;
    }

    public void setValorUnitarioComercial(BigDecimal valorUnitarioComercial) {
        this.valorUnitarioComercial = valorUnitarioComercial;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public String getCodigoBarrasTributavel() {
        return codigoBarrasTributavel;
    }

    public void setCodigoBarrasTributavel(String codigoBarrasTributavel) {
        this.codigoBarrasTributavel = codigoBarrasTributavel;
    }

    public String getUnidadeTributavel() {
        return unidadeTributavel;
    }

    public void setUnidadeTributavel(String unidadeTributavel) {
        this.unidadeTributavel = unidadeTributavel;
    }

    public BigDecimal getQuantidadeTributavel() {
        return quantidadeTributavel;
    }

    public void setQuantidadeTributavel(BigDecimal quantidadeTributavel) {
        this.quantidadeTributavel = quantidadeTributavel;
    }

    public BigDecimal getValorUnitarioTributavel() {
        return valorUnitarioTributavel;
    }

    public void setValorUnitarioTributavel(BigDecimal valorUnitarioTributavel) {
        this.valorUnitarioTributavel = valorUnitarioTributavel;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public NFeIncluiNoTotalEnum getIncluiNoTotal() {
        return incluiNoTotal;
    }

    public void setIncluiNoTotal(NFeIncluiNoTotalEnum incluiNoTotal) {
        this.incluiNoTotal = incluiNoTotal;
    }

    public List<NFeDocumentoImportacao> getDocumentosImportacao() {
        return documentosImportacao;
    }

    public void setDocumentosImportacao(List<NFeDocumentoImportacao> documentosImportacao) {
        this.documentosImportacao = documentosImportacao;
    }

    public List<NFeDetalheExportacao> getDetalhesExportacao() {
        return detalhesExportacao;
    }

    public void setDetalhesExportacao(List<NFeDetalheExportacao> detalhesExportacao) {
        this.detalhesExportacao = detalhesExportacao;
    }

    public String getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(String pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public String getNumeroItemPedidoCompra() {
        return numeroItemPedidoCompra;
    }

    public void setNumeroItemPedidoCompra(String numeroItemPedidoCompra) {
        this.numeroItemPedidoCompra = numeroItemPedidoCompra;
    }

    public String getNumeroFci() {
        return numeroFci;
    }

    public void setNumeroFci(String numeroFci) {
        this.numeroFci = numeroFci;
    }

    public List<NFeRastro> getRastros() {
        return rastros;
    }

    public void setRastros(List<NFeRastro> rastros) {
        this.rastros = rastros;
    }

    public NFeVeiculoTipoOperacaoEnum getVeiculoTipoOperacao() {
        return veiculoTipoOperacao;
    }

    public void setVeiculoTipoOperacao(NFeVeiculoTipoOperacaoEnum veiculoTipoOperacao) {
        this.veiculoTipoOperacao = veiculoTipoOperacao;
    }

    public String getVeiculoChassi() {
        return veiculoChassi;
    }

    public void setVeiculoChassi(String veiculoChassi) {
        this.veiculoChassi = veiculoChassi;
    }

    public String getVeiculoCodigoCor() {
        return veiculoCodigoCor;
    }

    public void setVeiculoCodigoCor(String veiculoCodigoCor) {
        this.veiculoCodigoCor = veiculoCodigoCor;
    }

    public String getVeiculoDescricaoCor() {
        return veiculoDescricaoCor;
    }

    public void setVeiculoDescricaoCor(String veiculoDescricaoCor) {
        this.veiculoDescricaoCor = veiculoDescricaoCor;
    }

    public String getVeiculoPotenciaMotor() {
        return veiculoPotenciaMotor;
    }

    public void setVeiculoPotenciaMotor(String veiculoPotenciaMotor) {
        this.veiculoPotenciaMotor = veiculoPotenciaMotor;
    }

    public String getVeiculoCm3() {
        return veiculoCm3;
    }

    public void setVeiculoCm3(String veiculoCm3) {
        this.veiculoCm3 = veiculoCm3;
    }

    public String getVeiculoPesoLiquido() {
        return veiculoPesoLiquido;
    }

    public void setVeiculoPesoLiquido(String veiculoPesoLiquido) {
        this.veiculoPesoLiquido = veiculoPesoLiquido;
    }

    public String getVeiculoPesoBruto() {
        return veiculoPesoBruto;
    }

    public void setVeiculoPesoBruto(String veiculoPesoBruto) {
        this.veiculoPesoBruto = veiculoPesoBruto;
    }

    public String getVeiculoSerie() {
        return veiculoSerie;
    }

    public void setVeiculoSerie(String veiculoSerie) {
        this.veiculoSerie = veiculoSerie;
    }

    public NFeVeiculoTipoCombustivelEnum getVeiculoTipoCombustivel() {
        return veiculoTipoCombustivel;
    }

    public void setVeiculoTipoCombustivel(NFeVeiculoTipoCombustivelEnum veiculoTipoCombustivel) {
        this.veiculoTipoCombustivel = veiculoTipoCombustivel;
    }

    public String getVeiculoNumeroMotor() {
        return veiculoNumeroMotor;
    }

    public void setVeiculoNumeroMotor(String veiculoNumeroMotor) {
        this.veiculoNumeroMotor = veiculoNumeroMotor;
    }

    public String getVeiculoCmt() {
        return veiculoCmt;
    }

    public void setVeiculoCmt(String veiculoCmt) {
        this.veiculoCmt = veiculoCmt;
    }

    public String getVeiculoDistanciaEixos() {
        return veiculoDistanciaEixos;
    }

    public void setVeiculoDistanciaEixos(String veiculoDistanciaEixos) {
        this.veiculoDistanciaEixos = veiculoDistanciaEixos;
    }

    public String getVeiculoAnoModelo() {
        return veiculoAnoModelo;
    }

    public void setVeiculoAnoModelo(String veiculoAnoModelo) {
        this.veiculoAnoModelo = veiculoAnoModelo;
    }

    public String getVeiculoAnoFabricacao() {
        return veiculoAnoFabricacao;
    }

    public void setVeiculoAnoFabricacao(String veiculoAnoFabricacao) {
        this.veiculoAnoFabricacao = veiculoAnoFabricacao;
    }

    public String getVeiculoTipoPintura() {
        return veiculoTipoPintura;
    }

    public void setVeiculoTipoPintura(String veiculoTipoPintura) {
        this.veiculoTipoPintura = veiculoTipoPintura;
    }

    public String getVeiculoTipo() {
        return veiculoTipo;
    }

    public void setVeiculoTipo(String veiculoTipo) {
        this.veiculoTipo = veiculoTipo;
    }

    public String getVeiculoEspecie() {
        return veiculoEspecie;
    }

    public void setVeiculoEspecie(String veiculoEspecie) {
        this.veiculoEspecie = veiculoEspecie;
    }

    public NFeVeiculoVinEnum getVeiculoCodigoVin() {
        return veiculoCodigoVin;
    }

    public void setVeiculoCodigoVin(NFeVeiculoVinEnum veiculoCodigoVin) {
        this.veiculoCodigoVin = veiculoCodigoVin;
    }

    public NFeVeiculoCondicaoEnum getVeiculoCondicao() {
        return veiculoCondicao;
    }

    public void setVeiculoCondicao(NFeVeiculoCondicaoEnum veiculoCondicao) {
        this.veiculoCondicao = veiculoCondicao;
    }

    public String getVeiculoCodigoMarcaModelo() {
        return veiculoCodigoMarcaModelo;
    }

    public void setVeiculoCodigoMarcaModelo(String veiculoCodigoMarcaModelo) {
        this.veiculoCodigoMarcaModelo = veiculoCodigoMarcaModelo;
    }

    public NFeVeiculoCodigoCorDenatranEnum getVeiculoCodigoCorDenatran() {
        return veiculoCodigoCorDenatran;
    }

    public void setVeiculoCodigoCorDenatran(NFeVeiculoCodigoCorDenatranEnum veiculoCodigoCorDenatran) {
        this.veiculoCodigoCorDenatran = veiculoCodigoCorDenatran;
    }

    public String getVeiculoLotacao() {
        return veiculoLotacao;
    }

    public void setVeiculoLotacao(String veiculoLotacao) {
        this.veiculoLotacao = veiculoLotacao;
    }

    public NFeVeiculoRestricaoEnum getVeiculoRestricao() {
        return veiculoRestricao;
    }

    public void setVeiculoRestricao(NFeVeiculoRestricaoEnum veiculoRestricao) {
        this.veiculoRestricao = veiculoRestricao;
    }

    public String getMedicamentoCodigoAnvisa() {
        return medicamentoCodigoAnvisa;
    }

    public void setMedicamentoCodigoAnvisa(String medicamentoCodigoAnvisa) {
        this.medicamentoCodigoAnvisa = medicamentoCodigoAnvisa;
    }

    public BigDecimal getMedicamentoPrecoMaximoConsumidor() {
        return medicamentoPrecoMaximoConsumidor;
    }

    public void setMedicamentoPrecoMaximoConsumidor(BigDecimal medicamentoPrecoMaximoConsumidor) {
        this.medicamentoPrecoMaximoConsumidor = medicamentoPrecoMaximoConsumidor;
    }

    public String getCombustivelCodigoAnp() {
        return combustivelCodigoAnp;
    }

    public void setCombustivelCodigoAnp(String combustivelCodigoAnp) {
        this.combustivelCodigoAnp = combustivelCodigoAnp;
    }

    public String getCombustivelDescricaoAnp() {
        return combustivelDescricaoAnp;
    }

    public void setCombustivelDescricaoAnp(String combustivelDescricaoAnp) {
        this.combustivelDescricaoAnp = combustivelDescricaoAnp;
    }

    public BigDecimal getCombustivelPercentualGlp() {
        return combustivelPercentualGlp;
    }

    public void setCombustivelPercentualGlp(BigDecimal combustivelPercentualGlp) {
        this.combustivelPercentualGlp = combustivelPercentualGlp;
    }

    public BigDecimal getCombustivelPercentualGasNaturalNacional() {
        return combustivelPercentualGasNaturalNacional;
    }

    public void setCombustivelPercentualGasNaturalNacional(BigDecimal combustivelPercentualGasNaturalNacional) {
        this.combustivelPercentualGasNaturalNacional = combustivelPercentualGasNaturalNacional;
    }

    public BigDecimal getCombustivelPercentualGasNaturalImportado() {
        return combustivelPercentualGasNaturalImportado;
    }

    public void setCombustivelPercentualGasNaturalImportado(BigDecimal combustivelPercentualGasNaturalImportado) {
        this.combustivelPercentualGasNaturalImportado = combustivelPercentualGasNaturalImportado;
    }

    public BigDecimal getCombustivelValorPartida() {
        return combustivelValorPartida;
    }

    public void setCombustivelValorPartida(BigDecimal combustivelValorPartida) {
        this.combustivelValorPartida = combustivelValorPartida;
    }

    public String getCombustivelRegistroCodif() {
        return combustivelRegistroCodif;
    }

    public void setCombustivelRegistroCodif(String combustivelRegistroCodif) {
        this.combustivelRegistroCodif = combustivelRegistroCodif;
    }

    public BigDecimal getCombustivelQuantidadeTemperaturaAmbiente() {
        return combustivelQuantidadeTemperaturaAmbiente;
    }

    public void setCombustivelQuantidadeTemperaturaAmbiente(BigDecimal combustivelQuantidadeTemperaturaAmbiente) {
        this.combustivelQuantidadeTemperaturaAmbiente = combustivelQuantidadeTemperaturaAmbiente;
    }

    public NFeUnidadeFederativaEnum getCombustivelSiglaUf() {
        return combustivelSiglaUf;
    }

    public void setCombustivelSiglaUf(NFeUnidadeFederativaEnum combustivelSiglaUf) {
        this.combustivelSiglaUf = combustivelSiglaUf;
    }

    public BigDecimal getCombustivelCideBaseCalculo() {
        return combustivelCideBaseCalculo;
    }

    public void setCombustivelCideBaseCalculo(BigDecimal combustivelCideBaseCalculo) {
        this.combustivelCideBaseCalculo = combustivelCideBaseCalculo;
    }

    public BigDecimal getCombustivelCideAliquota() {
        return combustivelCideAliquota;
    }

    public void setCombustivelCideAliquota(BigDecimal combustivelCideAliquota) {
        this.combustivelCideAliquota = combustivelCideAliquota;
    }

    public BigDecimal getCombustivelCideValor() {
        return combustivelCideValor;
    }

    public void setCombustivelCideValor(BigDecimal combustivelCideValor) {
        this.combustivelCideValor = combustivelCideValor;
    }

    public BigDecimal getValorTotalTributos() {
        return valorTotalTributos;
    }

    public void setValorTotalTributos(BigDecimal valorTotalTributos) {
        this.valorTotalTributos = valorTotalTributos;
    }

    public BigDecimal getIssqnBaseCalculo() {
        return issqnBaseCalculo;
    }

    public void setIssqnBaseCalculo(BigDecimal issqnBaseCalculo) {
        this.issqnBaseCalculo = issqnBaseCalculo;
    }

    public BigDecimal getIssqnAliquota() {
        return issqnAliquota;
    }

    public void setIssqnAliquota(BigDecimal issqnAliquota) {
        this.issqnAliquota = issqnAliquota;
    }

    public BigDecimal getIssqnValor() {
        return issqnValor;
    }

    public void setIssqnValor(BigDecimal issqnValor) {
        this.issqnValor = issqnValor;
    }

    public String getIssqnCodigoMunicipio() {
        return issqnCodigoMunicipio;
    }

    public void setIssqnCodigoMunicipio(String issqnCodigoMunicipio) {
        this.issqnCodigoMunicipio = issqnCodigoMunicipio;
    }

    public String getIssqnItemListaServico() {
        return issqnItemListaServico;
    }

    public void setIssqnItemListaServico(String issqnItemListaServico) {
        this.issqnItemListaServico = issqnItemListaServico;
    }

    public BigDecimal getIssqnValorDeducao() {
        return issqnValorDeducao;
    }

    public void setIssqnValorDeducao(BigDecimal issqnValorDeducao) {
        this.issqnValorDeducao = issqnValorDeducao;
    }

    public BigDecimal getIssqnValorOutrasRetencoes() {
        return issqnValorOutrasRetencoes;
    }

    public void setIssqnValorOutrasRetencoes(BigDecimal issqnValorOutrasRetencoes) {
        this.issqnValorOutrasRetencoes = issqnValorOutrasRetencoes;
    }

    public BigDecimal getIssqnValorDescontoIncondicionado() {
        return issqnValorDescontoIncondicionado;
    }

    public void setIssqnValorDescontoIncondicionado(BigDecimal issqnValorDescontoIncondicionado) {
        this.issqnValorDescontoIncondicionado = issqnValorDescontoIncondicionado;
    }

    public BigDecimal getIssqnValorDescontoCondicionado() {
        return issqnValorDescontoCondicionado;
    }

    public void setIssqnValorDescontoCondicionado(BigDecimal issqnValorDescontoCondicionado) {
        this.issqnValorDescontoCondicionado = issqnValorDescontoCondicionado;
    }

    public BigDecimal getIssqnValorRetencao() {
        return issqnValorRetencao;
    }

    public void setIssqnValorRetencao(BigDecimal issqnValorRetencao) {
        this.issqnValorRetencao = issqnValorRetencao;
    }

    public NFeIssqnIndicadorExigibilidadeEnum getIssqnIndicadorExigibilidade() {
        return issqnIndicadorExigibilidade;
    }

    public void setIssqnIndicadorExigibilidade(NFeIssqnIndicadorExigibilidadeEnum issqnIndicadorExigibilidade) {
        this.issqnIndicadorExigibilidade = issqnIndicadorExigibilidade;
    }

    public String getIssqnCodigoServico() {
        return issqnCodigoServico;
    }

    public void setIssqnCodigoServico(String issqnCodigoServico) {
        this.issqnCodigoServico = issqnCodigoServico;
    }

    public String getIssqnCodigoMunicipioIncidencia() {
        return issqnCodigoMunicipioIncidencia;
    }

    public void setIssqnCodigoMunicipioIncidencia(String issqnCodigoMunicipioIncidencia) {
        this.issqnCodigoMunicipioIncidencia = issqnCodigoMunicipioIncidencia;
    }

    public String getIssqnCodigoPais() {
        return issqnCodigoPais;
    }

    public void setIssqnCodigoPais(String issqnCodigoPais) {
        this.issqnCodigoPais = issqnCodigoPais;
    }

    public String getIssqnNumeroProcesso() {
        return issqnNumeroProcesso;
    }

    public void setIssqnNumeroProcesso(String issqnNumeroProcesso) {
        this.issqnNumeroProcesso = issqnNumeroProcesso;
    }

    public String getIssqnIndicadorIncentivo() {
        return issqnIndicadorIncentivo;
    }

    public void setIssqnIndicadorIncentivo(String issqnIndicadorIncentivo) {
        this.issqnIndicadorIncentivo = issqnIndicadorIncentivo;
    }

    public NFeIcmsOrigemEnum getIcmsOrigem() {
        return icmsOrigem;
    }

    public void setIcmsOrigem(NFeIcmsOrigemEnum icmsOrigem) {
        this.icmsOrigem = icmsOrigem;
    }

    public NFeIcmsSituacaoTributariaEnum getIcmsSituacaoTributaria() {
        return icmsSituacaoTributaria;
    }

    public void setIcmsSituacaoTributaria(NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria) {
        this.icmsSituacaoTributaria = icmsSituacaoTributaria;
    }

    public NFeIcmsModalidadeBaseCalculoEnum getIcmsMmodalidadeBaseCalculo() {
        return icmsMmodalidadeBaseCalculo;
    }

    public void setIcmsMmodalidadeBaseCalculo(NFeIcmsModalidadeBaseCalculoEnum icmsMmodalidadeBaseCalculo) {
        this.icmsMmodalidadeBaseCalculo = icmsMmodalidadeBaseCalculo;
    }

    public BigDecimal getIcmsBaseCalculo() {
        return icmsBaseCalculo;
    }

    public void setIcmsBaseCalculo(BigDecimal icmsBaseCalculo) {
        this.icmsBaseCalculo = icmsBaseCalculo;
    }

    public BigDecimal getIcmsBaseCalculoRetidoSt() {
        return icmsBaseCalculoRetidoSt;
    }

    public void setIcmsBaseCalculoRetidoSt(BigDecimal icmsBaseCalculoRetidoSt) {
        this.icmsBaseCalculoRetidoSt = icmsBaseCalculoRetidoSt;
    }

    public BigDecimal getIcmsReducaoBaseCalculo() {
        return icmsReducaoBaseCalculo;
    }

    public void setIcmsReducaoBaseCalculo(BigDecimal icmsReducaoBaseCalculo) {
        this.icmsReducaoBaseCalculo = icmsReducaoBaseCalculo;
    }

    public BigDecimal getIcmsAliquota() {
        return icmsAliquota;
    }

    public void setIcmsAliquota(BigDecimal icmsAliquota) {
        this.icmsAliquota = icmsAliquota;
    }

    public BigDecimal getIcmsAliquotaFinal() {
        return icmsAliquotaFinal;
    }

    public void setIcmsAliquotaFinal(BigDecimal icmsAliquotaFinal) {
        this.icmsAliquotaFinal = icmsAliquotaFinal;
    }

    public BigDecimal getIcmsValor() {
        return icmsValor;
    }

    public void setIcmsValor(BigDecimal icmsValor) {
        this.icmsValor = icmsValor;
    }

    public BigDecimal getIcmsValorRetidoSt() {
        return icmsValorRetidoSt;
    }

    public void setIcmsValorRetidoSt(BigDecimal icmsValorRetidoSt) {
        this.icmsValorRetidoSt = icmsValorRetidoSt;
    }

    public BigDecimal getIcmsValorDesonerado() {
        return icmsValorDesonerado;
    }

    public void setIcmsValorDesonerado(BigDecimal icmsValorDesonerado) {
        this.icmsValorDesonerado = icmsValorDesonerado;
    }

    public BigDecimal getIcmsValorOperacao() {
        return icmsValorOperacao;
    }

    public void setIcmsValorOperacao(BigDecimal icmsValorOperacao) {
        this.icmsValorOperacao = icmsValorOperacao;
    }

    public BigDecimal getIcmsPercentualDiferimento() {
        return icmsPercentualDiferimento;
    }

    public void setIcmsPercentualDiferimento(BigDecimal icmsPercentualDiferimento) {
        this.icmsPercentualDiferimento = icmsPercentualDiferimento;
    }

    public BigDecimal getIcmsValorDiferido() {
        return icmsValorDiferido;
    }

    public void setIcmsValorDiferido(BigDecimal icmsValorDiferido) {
        this.icmsValorDiferido = icmsValorDiferido;
    }

    public NFeIcmsMotivoDesoneracaoEnum getIcmsMotivoDesoneracao() {
        return icmsMotivoDesoneracao;
    }

    public void setIcmsMotivoDesoneracao(NFeIcmsMotivoDesoneracaoEnum icmsMotivoDesoneracao) {
        this.icmsMotivoDesoneracao = icmsMotivoDesoneracao;
    }

    public NFeIcmsModalidadeBaseCalculoStEnum getIcmsModalidadeBaseCalculoSt() {
        return icmsModalidadeBaseCalculoSt;
    }

    public void setIcmsModalidadeBaseCalculoSt(NFeIcmsModalidadeBaseCalculoStEnum icmsModalidadeBaseCalculoSt) {
        this.icmsModalidadeBaseCalculoSt = icmsModalidadeBaseCalculoSt;
    }

    public BigDecimal getIcmsMargemValorAdicionadoSt() {
        return icmsMargemValorAdicionadoSt;
    }

    public void setIcmsMargemValorAdicionadoSt(BigDecimal icmsMargemValorAdicionadoSt) {
        this.icmsMargemValorAdicionadoSt = icmsMargemValorAdicionadoSt;
    }

    public BigDecimal getIcmsReducaoBaseCalculoSt() {
        return icmsReducaoBaseCalculoSt;
    }

    public void setIcmsReducaoBaseCalculoSt(BigDecimal icmsReducaoBaseCalculoSt) {
        this.icmsReducaoBaseCalculoSt = icmsReducaoBaseCalculoSt;
    }

    public BigDecimal getIcmsBaseCalculoSt() {
        return icmsBaseCalculoSt;
    }

    public void setIcmsBaseCalculoSt(BigDecimal icmsBaseCalculoSt) {
        this.icmsBaseCalculoSt = icmsBaseCalculoSt;
    }

    public BigDecimal getIcmsAliquotaSt() {
        return icmsAliquotaSt;
    }

    public void setIcmsAliquotaSt(BigDecimal icmsAliquotaSt) {
        this.icmsAliquotaSt = icmsAliquotaSt;
    }

    public BigDecimal getIcmsValorSt() {
        return icmsValorSt;
    }

    public void setIcmsValorSt(BigDecimal icmsValorSt) {
        this.icmsValorSt = icmsValorSt;
    }

    public BigDecimal getIcmsAliquotaCreditoSimples() {
        return icmsAliquotaCreditoSimples;
    }

    public void setIcmsAliquotaCreditoSimples(BigDecimal icmsAliquotaCreditoSimples) {
        this.icmsAliquotaCreditoSimples = icmsAliquotaCreditoSimples;
    }

    public BigDecimal getIcmsValorCreditoSimples() {
        return icmsValorCreditoSimples;
    }

    public void setIcmsValorCreditoSimples(BigDecimal icmsValorCreditoSimples) {
        this.icmsValorCreditoSimples = icmsValorCreditoSimples;
    }

    public BigDecimal getFcpPercentual() {
        return fcpPercentual;
    }

    public void setFcpPercentual(BigDecimal fcpPercentual) {
        this.fcpPercentual = fcpPercentual;
    }

    public BigDecimal getFcpBaseCalculo() {
        return fcpBaseCalculo;
    }

    public void setFcpBaseCalculo(BigDecimal fcpBaseCalculo) {
        this.fcpBaseCalculo = fcpBaseCalculo;
    }

    public BigDecimal getFcpValor() {
        return fcpValor;
    }

    public void setFcpValor(BigDecimal fcpValor) {
        this.fcpValor = fcpValor;
    }

    public BigDecimal getFcpPercentualSt() {
        return fcpPercentualSt;
    }

    public void setFcpPercentualSt(BigDecimal fcpPercentualSt) {
        this.fcpPercentualSt = fcpPercentualSt;
    }

    public BigDecimal getFcpBaseCalculoSt() {
        return fcpBaseCalculoSt;
    }

    public void setFcpBaseCalculoSt(BigDecimal fcpBaseCalculoSt) {
        this.fcpBaseCalculoSt = fcpBaseCalculoSt;
    }

    public BigDecimal getFcpValorSt() {
        return fcpValorSt;
    }

    public void setFcpValorSt(BigDecimal fcpValorSt) {
        this.fcpValorSt = fcpValorSt;
    }

    public BigDecimal getFcpPercentualRetidoSt() {
        return fcpPercentualRetidoSt;
    }

    public void setFcpPercentualRetidoSt(BigDecimal fcpPercentualRetidoSt) {
        this.fcpPercentualRetidoSt = fcpPercentualRetidoSt;
    }

    public BigDecimal getFcpBaseCalculoRetidoSt() {
        return fcpBaseCalculoRetidoSt;
    }

    public void setFcpBaseCalculoRetidoSt(BigDecimal fcpBaseCalculoRetidoSt) {
        this.fcpBaseCalculoRetidoSt = fcpBaseCalculoRetidoSt;
    }

    public BigDecimal getFcpValorRetidoSt() {
        return fcpValorRetidoSt;
    }

    public void setFcpValorRetidoSt(BigDecimal fcpValorRetidoSt) {
        this.fcpValorRetidoSt = fcpValorRetidoSt;
    }

    public NFeIpiSituacaoTributariaEnum getIpiSituacaoTributaria() {
        return ipiSituacaoTributaria;
    }

    public void setIpiSituacaoTributaria(NFeIpiSituacaoTributariaEnum ipiSituacaoTributaria) {
        this.ipiSituacaoTributaria = ipiSituacaoTributaria;
    }

    public BigDecimal getIpiBaseCalculo() {
        return ipiBaseCalculo;
    }

    public void setIpiBaseCalculo(BigDecimal ipiBaseCalculo) {
        this.ipiBaseCalculo = ipiBaseCalculo;
    }

    public BigDecimal getIpiAliquota() {
        return ipiAliquota;
    }

    public void setIpiAliquota(BigDecimal ipiAliquota) {
        this.ipiAliquota = ipiAliquota;
    }

    public BigDecimal getIpiQuantidadeTotal() {
        return ipiQuantidadeTotal;
    }

    public void setIpiQuantidadeTotal(BigDecimal ipiQuantidadeTotal) {
        this.ipiQuantidadeTotal = ipiQuantidadeTotal;
    }

    public BigDecimal getIpiValorPorUnidadeTributavel() {
        return ipiValorPorUnidadeTributavel;
    }

    public void setIpiValorPorUnidadeTributavel(BigDecimal ipiValorPorUnidadeTributavel) {
        this.ipiValorPorUnidadeTributavel = ipiValorPorUnidadeTributavel;
    }

    public BigDecimal getIpiValor() {
        return ipiValor;
    }

    public void setIpiValor(BigDecimal ipiValor) {
        this.ipiValor = ipiValor;
    }

    public String getIpiClasseEnquadramento() {
        return ipiClasseEnquadramento;
    }

    public void setIpiClasseEnquadramento(String ipiClasseEnquadramento) {
        this.ipiClasseEnquadramento = ipiClasseEnquadramento;
    }

    public String getIpiCnpjProdutor() {
        return ipiCnpjProdutor;
    }

    public void setIpiCnpjProdutor(String ipiCnpjProdutor) {
        this.ipiCnpjProdutor = ipiCnpjProdutor;
    }

    public String getIpiCodigoSeloControle() {
        return ipiCodigoSeloControle;
    }

    public void setIpiCodigoSeloControle(String ipiCodigoSeloControle) {
        this.ipiCodigoSeloControle = ipiCodigoSeloControle;
    }

    public String getIpiQuantidadeSeloControle() {
        return ipiQuantidadeSeloControle;
    }

    public void setIpiQuantidadeSeloControle(String ipiQuantidadeSeloControle) {
        this.ipiQuantidadeSeloControle = ipiQuantidadeSeloControle;
    }

    public String getIpiCodigoEnquadramentoLegal() {
        return ipiCodigoEnquadramentoLegal;
    }

    public void setIpiCodigoEnquadramentoLegal(String ipiCodigoEnquadramentoLegal) {
        this.ipiCodigoEnquadramentoLegal = ipiCodigoEnquadramentoLegal;
    }

    public BigDecimal getIiBaseCalculo() {
        return iiBaseCalculo;
    }

    public void setIiBaseCalculo(BigDecimal iiBaseCalculo) {
        this.iiBaseCalculo = iiBaseCalculo;
    }

    public BigDecimal getIiDespesasAduaneiras() {
        return iiDespesasAduaneiras;
    }

    public void setIiDespesasAduaneiras(BigDecimal iiDespesasAduaneiras) {
        this.iiDespesasAduaneiras = iiDespesasAduaneiras;
    }

    public BigDecimal getIiValor() {
        return iiValor;
    }

    public void setIiValor(BigDecimal iiValor) {
        this.iiValor = iiValor;
    }

    public BigDecimal getIiValorIof() {
        return iiValorIof;
    }

    public void setIiValorIof(BigDecimal iiValorIof) {
        this.iiValorIof = iiValorIof;
    }

    public NFePisCofinsSituacaoTributariaEnum getPisSituacaoTributaria() {
        return pisSituacaoTributaria;
    }

    public void setPisSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria) {
        this.pisSituacaoTributaria = pisSituacaoTributaria;
    }

    public BigDecimal getPisBaseCalculo() {
        return pisBaseCalculo;
    }

    public void setPisBaseCalculo(BigDecimal pisBaseCalculo) {
        this.pisBaseCalculo = pisBaseCalculo;
    }

    public BigDecimal getPisAliquotaPorcentual() {
        return pisAliquotaPorcentual;
    }

    public void setPisAliquotaPorcentual(BigDecimal pisAliquotaPorcentual) {
        this.pisAliquotaPorcentual = pisAliquotaPorcentual;
    }

    public BigDecimal getPisQuantidadeVendida() {
        return pisQuantidadeVendida;
    }

    public void setPisQuantidadeVendida(BigDecimal pisQuantidadeVendida) {
        this.pisQuantidadeVendida = pisQuantidadeVendida;
    }

    public BigDecimal getPisAliquotaValor() {
        return pisAliquotaValor;
    }

    public void setPisAliquotaValor(BigDecimal pisAliquotaValor) {
        this.pisAliquotaValor = pisAliquotaValor;
    }

    public BigDecimal getPisValor() {
        return pisValor;
    }

    public void setPisValor(BigDecimal pisValor) {
        this.pisValor = pisValor;
    }

    public BigDecimal getPisBaseCalculoSt() {
        return pisBaseCalculoSt;
    }

    public void setPisBaseCalculoSt(BigDecimal pisBaseCalculoSt) {
        this.pisBaseCalculoSt = pisBaseCalculoSt;
    }

    public BigDecimal getPisAliquotaPorcentualSt() {
        return pisAliquotaPorcentualSt;
    }

    public void setPisAliquotaPorcentualSt(BigDecimal pisAliquotaPorcentualSt) {
        this.pisAliquotaPorcentualSt = pisAliquotaPorcentualSt;
    }

    public BigDecimal getPisQuantidadeVendidaSt() {
        return pisQuantidadeVendidaSt;
    }

    public void setPisQuantidadeVendidaSt(BigDecimal pisQuantidadeVendidaSt) {
        this.pisQuantidadeVendidaSt = pisQuantidadeVendidaSt;
    }

    public BigDecimal getPisAliquotaValorSt() {
        return pisAliquotaValorSt;
    }

    public void setPisAliquotaValorSt(BigDecimal pisAliquotaValorSt) {
        this.pisAliquotaValorSt = pisAliquotaValorSt;
    }

    public BigDecimal getPisValorSt() {
        return pisValorSt;
    }

    public void setPisValorSt(BigDecimal pisValorSt) {
        this.pisValorSt = pisValorSt;
    }

    public NFePisCofinsSituacaoTributariaEnum getCofinsSituacaoTributaria() {
        return cofinsSituacaoTributaria;
    }

    public void setCofinsSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria) {
        this.cofinsSituacaoTributaria = cofinsSituacaoTributaria;
    }

    public BigDecimal getCofinsBaseCalculo() {
        return cofinsBaseCalculo;
    }

    public void setCofinsBaseCalculo(BigDecimal cofinsBaseCalculo) {
        this.cofinsBaseCalculo = cofinsBaseCalculo;
    }

    public BigDecimal getCofinsAliquotaPorcentual() {
        return cofinsAliquotaPorcentual;
    }

    public void setCofinsAliquotaPorcentual(BigDecimal cofinsAliquotaPorcentual) {
        this.cofinsAliquotaPorcentual = cofinsAliquotaPorcentual;
    }

    public BigDecimal getCofinsQuantidadeVendida() {
        return cofinsQuantidadeVendida;
    }

    public void setCofinsQuantidadeVendida(BigDecimal cofinsQuantidadeVendida) {
        this.cofinsQuantidadeVendida = cofinsQuantidadeVendida;
    }

    public BigDecimal getCofinsAliquotaValor() {
        return cofinsAliquotaValor;
    }

    public void setCofinsAliquotaValor(BigDecimal cofinsAliquotaValor) {
        this.cofinsAliquotaValor = cofinsAliquotaValor;
    }

    public BigDecimal getCofinsValor() {
        return cofinsValor;
    }

    public void setCofinsValor(BigDecimal cofinsValor) {
        this.cofinsValor = cofinsValor;
    }

    public BigDecimal getCofinsBaseCalculoSt() {
        return cofinsBaseCalculoSt;
    }

    public void setCofinsBaseCalculoSt(BigDecimal cofinsBaseCalculoSt) {
        this.cofinsBaseCalculoSt = cofinsBaseCalculoSt;
    }

    public BigDecimal getCofinsAliquotaPorcentualSt() {
        return cofinsAliquotaPorcentualSt;
    }

    public void setCofinsAliquotaPorcentualSt(BigDecimal cofinsAliquotaPorcentualSt) {
        this.cofinsAliquotaPorcentualSt = cofinsAliquotaPorcentualSt;
    }

    public BigDecimal getCofinsQuantidadeVendidaSt() {
        return cofinsQuantidadeVendidaSt;
    }

    public void setCofinsQuantidadeVendidaSt(BigDecimal cofinsQuantidadeVendidaSt) {
        this.cofinsQuantidadeVendidaSt = cofinsQuantidadeVendidaSt;
    }

    public BigDecimal getCofinsAliquotaValorSt() {
        return cofinsAliquotaValorSt;
    }

    public void setCofinsAliquotaValorSt(BigDecimal cofinsAliquotaValorSt) {
        this.cofinsAliquotaValorSt = cofinsAliquotaValorSt;
    }

    public BigDecimal getCofinsValorSt() {
        return cofinsValorSt;
    }

    public void setCofinsValorSt(BigDecimal cofinsValorSt) {
        this.cofinsValorSt = cofinsValorSt;
    }

    public BigDecimal getIcmsBaseCalculoUfDestino() {
        return icmsBaseCalculoUfDestino;
    }

    public void setIcmsBaseCalculoUfDestino(BigDecimal icmsBaseCalculoUfDestino) {
        this.icmsBaseCalculoUfDestino = icmsBaseCalculoUfDestino;
    }

    public BigDecimal getFcpBaseCalculoUfDestino() {
        return fcpBaseCalculoUfDestino;
    }

    public void setFcpBaseCalculoUfDestino(BigDecimal fcpBaseCalculoUfDestino) {
        this.fcpBaseCalculoUfDestino = fcpBaseCalculoUfDestino;
    }

    public BigDecimal getFcpPercentualUfDestino() {
        return fcpPercentualUfDestino;
    }

    public void setFcpPercentualUfDestino(BigDecimal fcpPercentualUfDestino) {
        this.fcpPercentualUfDestino = fcpPercentualUfDestino;
    }

    public BigDecimal getIcmsAliquotaInternaUfDestino() {
        return icmsAliquotaInternaUfDestino;
    }

    public void setIcmsAliquotaInternaUfDestino(BigDecimal icmsAliquotaInternaUfDestino) {
        this.icmsAliquotaInternaUfDestino = icmsAliquotaInternaUfDestino;
    }

    public BigDecimal getIcmsAliquotaInterestadual() {
        return icmsAliquotaInterestadual;
    }

    public void setIcmsAliquotaInterestadual(BigDecimal icmsAliquotaInterestadual) {
        this.icmsAliquotaInterestadual = icmsAliquotaInterestadual;
    }

    public BigDecimal getIcmsPercentualPartilha() {
        return icmsPercentualPartilha;
    }

    public void setIcmsPercentualPartilha(BigDecimal icmsPercentualPartilha) {
        this.icmsPercentualPartilha = icmsPercentualPartilha;
    }

    public BigDecimal getFcpValorUfDestino() {
        return fcpValorUfDestino;
    }

    public void setFcpValorUfDestino(BigDecimal fcpValorUfDestino) {
        this.fcpValorUfDestino = fcpValorUfDestino;
    }

    public BigDecimal getIcmsValorUfDestino() {
        return icmsValorUfDestino;
    }

    public void setIcmsValorUfDestino(BigDecimal icmsValorUfDestino) {
        this.icmsValorUfDestino = icmsValorUfDestino;
    }

    public BigDecimal getIcmsValorUfRemetente() {
        return icmsValorUfRemetente;
    }

    public void setIcmsValorUfRemetente(BigDecimal icmsValorUfRemetente) {
        this.icmsValorUfRemetente = icmsValorUfRemetente;
    }

    public BigDecimal getPercentualDevolvido() {
        return percentualDevolvido;
    }

    public void setPercentualDevolvido(BigDecimal percentualDevolvido) {
        this.percentualDevolvido = percentualDevolvido;
    }

    public BigDecimal getValorIpiDevolvido() {
        return valorIpiDevolvido;
    }

    public void setValorIpiDevolvido(BigDecimal valorIpiDevolvido) {
        this.valorIpiDevolvido = valorIpiDevolvido;
    }

    public String getInformacoesAdicionaisItem() {
        return informacoesAdicionaisItem;
    }

    public void setInformacoesAdicionaisItem(String informacoesAdicionaisItem) {
        this.informacoesAdicionaisItem = informacoesAdicionaisItem;
    }

    public static final class Builder {

        private String numeroItem;

        private String codigoProduto;

        private String codigoBarrasComercial;

        private String descricao;

        private String codigoNcm;

        private List<NFeNve> nves;

        private String cest;

        private Boolean escalaRelevante;

        private String cnpjFabricante;

        private String codigoBeneficioFiscalUf;

        private String codigoExTipi;

        private String cfop;

        private String unidadeComercial;

        private BigDecimal quantidadeComercial;

        private BigDecimal valorUnitarioComercial;

        private BigDecimal valorBruto;

        private String codigoBarrasTributavel;

        private String unidadeTributavel;

        private BigDecimal quantidadeTributavel;

        private BigDecimal valorUnitarioTributavel;

        private BigDecimal valorFrete;

        private BigDecimal valorSeguro;

        private BigDecimal valorDesconto;

        private BigDecimal valorOutrasDespesas;

        private NFeIncluiNoTotalEnum incluiNoTotal;

        private List<NFeDocumentoImportacao> documentosImportacao;

        private List<NFeDetalheExportacao> detalhesExportacao;

        private String pedidoCompra;

        private String numeroItemPedidoCompra;

        private String numeroFci;

        private List<NFeRastro> rastros;

        private NFeVeiculoTipoOperacaoEnum veiculoTipoOperacao;

        private String veiculoChassi;

        private String veiculoCodigoCor;

        private String veiculoDescricaoCor;

        private String veiculoPotenciaMotor;

        private String veiculoCm3;

        private String veiculoPesoLiquido;

        private String veiculoPesoBruto;

        private String veiculoSerie;

        private NFeVeiculoTipoCombustivelEnum veiculoTipoCombustivel;

        private String veiculoNumeroMotor;

        private String veiculoCmt;

        private String veiculoDistanciaEixos;

        private String veiculoAnoModelo;

        private String veiculoAnoFabricacao;

        private String veiculoTipoPintura;

        private String veiculoTipo;

        private String veiculoEspecie;

        private NFeVeiculoVinEnum veiculoCodigoVin;

        private NFeVeiculoCondicaoEnum veiculoCondicao;

        private String veiculoCodigoMarcaModelo;

        private NFeVeiculoCodigoCorDenatranEnum veiculoCodigoCorDenatran;

        private String veiculoLotacao;

        private NFeVeiculoRestricaoEnum veiculoRestricao;

        private String medicamentoCodigoAnvisa;

        private BigDecimal medicamentoPrecoMaximoConsumidor;

        private String combustivelCodigoAnp;

        private String combustivelDescricaoAnp;

        private BigDecimal combustivelPercentualGlp;

        private BigDecimal combustivelPercentualGasNaturalNacional;

        private BigDecimal combustivelPercentualGasNaturalImportado;

        private BigDecimal combustivelValorPartida;

        private String combustivelRegistroCodif;

        private BigDecimal combustivelQuantidadeTemperaturaAmbiente;

        private NFeUnidadeFederativaEnum combustivelSiglaUf;

        private BigDecimal combustivelCideBaseCalculo;

        private BigDecimal combustivelCideAliquota;

        private BigDecimal combustivelCideValor;

        private BigDecimal valorTotalTributos;

        private BigDecimal issqnBaseCalculo;

        private BigDecimal issqnAliquota;

        private BigDecimal issqnValor;

        private String issqnCodigoMunicipio;

        private String issqnItemListaServico;

        private BigDecimal issqnValorDeducao;

        private BigDecimal issqnValorOutrasRetencoes;

        private BigDecimal issqnValorDescontoIncondicionado;

        private BigDecimal issqnValorDescontoCondicionado;

        private BigDecimal issqnValorRetencao;

        private NFeIssqnIndicadorExigibilidadeEnum issqnIndicadorExigibilidade;

        private String issqnCodigoServico;

        private String issqnCodigoMunicipioIncidencia;

        private String issqnCodigoPais;

        private String issqnNumeroProcesso;

        private String issqnIndicadorIncentivo;

        private NFeIcmsOrigemEnum icmsOrigem;

        private NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria;

        private NFeIcmsModalidadeBaseCalculoEnum icmsMmodalidadeBaseCalculo;

        private BigDecimal icmsBaseCalculo;

        private BigDecimal icmsBaseCalculoRetidoSt;

        private BigDecimal icmsReducaoBaseCalculo;

        private BigDecimal icmsAliquota;

        private BigDecimal icmsAliquotaFinal;

        private BigDecimal icmsValor;

        private BigDecimal icmsValorRetidoSt;

        private BigDecimal icmsValorDesonerado;

        private BigDecimal icmsValorOperacao;

        private BigDecimal icmsPercentualDiferimento;

        private BigDecimal icmsValorDiferido;

        private NFeIcmsMotivoDesoneracaoEnum icmsMotivoDesoneracao;

        private NFeIcmsModalidadeBaseCalculoStEnum icmsModalidadeBaseCalculoSt;

        private BigDecimal icmsMargemValorAdicionadoSt;

        private BigDecimal icmsReducaoBaseCalculoSt;

        private BigDecimal icmsBaseCalculoSt;

        private BigDecimal icmsAliquotaSt;

        private BigDecimal icmsValorSt;

        private BigDecimal icmsAliquotaCreditoSimples;

        private BigDecimal icmsValorCreditoSimples;

        private BigDecimal fcpPercentual;

        private BigDecimal fcpBaseCalculo;

        private BigDecimal fcpValor;

        private BigDecimal fcpPercentualSt;

        private BigDecimal fcpBaseCalculoSt;

        private BigDecimal fcpValorSt;

        private BigDecimal fcpPercentualRetidoSt;

        private BigDecimal fcpBaseCalculoRetidoSt;

        private BigDecimal fcpValorRetidoSt;

        private NFeIpiSituacaoTributariaEnum ipiSituacaoTributaria;

        private BigDecimal ipiBaseCalculo;

        private BigDecimal ipiAliquota;

        private BigDecimal ipiQuantidadeTotal;

        private BigDecimal ipiValorPorUnidadeTributavel;

        private BigDecimal ipiValor;

        private String ipiClasseEnquadramento;

        private String ipiCnpjProdutor;

        private String ipiCodigoSeloControle;

        private String ipiQuantidadeSeloControle;

        private String ipiCodigoEnquadramentoLegal;

        private BigDecimal iiBaseCalculo;

        private BigDecimal iiDespesasAduaneiras;

        private BigDecimal iiValor;

        private BigDecimal iiValorIof;

        private NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria;

        private BigDecimal pisBaseCalculo;

        private BigDecimal pisAliquotaPorcentual;

        private BigDecimal pisQuantidadeVendida;

        private BigDecimal pisAliquotaValor;

        private BigDecimal pisValor;

        private BigDecimal pisBaseCalculoSt;

        private BigDecimal pisAliquotaPorcentualSt;

        private BigDecimal pisQuantidadeVendidaSt;

        private BigDecimal pisAliquotaValorSt;

        private BigDecimal pisValorSt;

        private NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria;

        private BigDecimal cofinsBaseCalculo;

        private BigDecimal cofinsAliquotaPorcentual;

        private BigDecimal cofinsQuantidadeVendida;

        private BigDecimal cofinsAliquotaValor;

        private BigDecimal cofinsValor;

        private BigDecimal cofinsBaseCalculoSt;

        private BigDecimal cofinsAliquotaPorcentualSt;

        private BigDecimal cofinsQuantidadeVendidaSt;

        private BigDecimal cofinsAliquotaValorSt;

        private BigDecimal cofinsValorSt;

        private BigDecimal icmsBaseCalculoUfDestino;

        private BigDecimal fcpBaseCalculoUfDestino;

        private BigDecimal fcpPercentualUfDestino;

        private BigDecimal icmsAliquotaInternaUfDestino;

        private BigDecimal icmsAliquotaInterestadual;

        private BigDecimal icmsPercentualPartilha;

        private BigDecimal fcpValorUfDestino;

        private BigDecimal icmsValorUfDestino;

        private BigDecimal icmsValorUfRemetente;

        private BigDecimal percentualDevolvido;

        private BigDecimal valorIpiDevolvido;

        private String informacoesAdicionaisItem;

        private Builder() {
        }

        public Builder withNumeroItem(String val) {
            numeroItem = val;
            return this;
        }

        public Builder withCodigoProduto(String val) {
            codigoProduto = val;
            return this;
        }

        public Builder withCodigoBarrasComercial(String val) {
            codigoBarrasComercial = val;
            return this;
        }

        public Builder withDescricao(String val) {
            descricao = val;
            return this;
        }

        public Builder withCodigoNcm(String val) {
            codigoNcm = val;
            return this;
        }

        public Builder withNves(List<NFeNve> val) {
            nves = val;
            return this;
        }

        public Builder withCest(String val) {
            cest = val;
            return this;
        }

        public Builder withEscalaRelevante(Boolean val) {
            escalaRelevante = val;
            return this;
        }

        public Builder withCnpjFabricante(String val) {
            cnpjFabricante = val;
            return this;
        }

        public Builder withCodigoBeneficioFiscalUf(String val) {
            codigoBeneficioFiscalUf = val;
            return this;
        }

        public Builder withCodigoExTipi(String val) {
            codigoExTipi = val;
            return this;
        }

        public Builder withCfop(String val) {
            cfop = val;
            return this;
        }

        public Builder withUnidadeComercial(String val) {
            unidadeComercial = val;
            return this;
        }

        public Builder withQuantidadeComercial(BigDecimal val) {
            quantidadeComercial = val;
            return this;
        }

        public Builder withValorUnitarioComercial(BigDecimal val) {
            valorUnitarioComercial = val;
            return this;
        }

        public Builder withValorBruto(BigDecimal val) {
            valorBruto = val;
            return this;
        }

        public Builder withCodigoBarrasTributavel(String val) {
            codigoBarrasTributavel = val;
            return this;
        }

        public Builder withUnidadeTributavel(String val) {
            unidadeTributavel = val;
            return this;
        }

        public Builder withQuantidadeTributavel(BigDecimal val) {
            quantidadeTributavel = val;
            return this;
        }

        public Builder withValorUnitarioTributavel(BigDecimal val) {
            valorUnitarioTributavel = val;
            return this;
        }

        public Builder withValorFrete(BigDecimal val) {
            valorFrete = val;
            return this;
        }

        public Builder withValorSeguro(BigDecimal val) {
            valorSeguro = val;
            return this;
        }

        public Builder withValorDesconto(BigDecimal val) {
            valorDesconto = val;
            return this;
        }

        public Builder withValorOutrasDespesas(BigDecimal val) {
            valorOutrasDespesas = val;
            return this;
        }

        public Builder withIncluiNoTotal(NFeIncluiNoTotalEnum val) {
            incluiNoTotal = val;
            return this;
        }

        public Builder withDocumentosImportacao(List<NFeDocumentoImportacao> val) {
            documentosImportacao = val;
            return this;
        }

        public Builder withDetalhesExportacao(List<NFeDetalheExportacao> val) {
            detalhesExportacao = val;
            return this;
        }

        public Builder withPedidoCompra(String val) {
            pedidoCompra = val;
            return this;
        }

        public Builder withNumeroItemPedidoCompra(String val) {
            numeroItemPedidoCompra = val;
            return this;
        }

        public Builder withNumeroFci(String val) {
            numeroFci = val;
            return this;
        }

        public Builder withRastros(List<NFeRastro> val) {
            rastros = val;
            return this;
        }

        public Builder withVeiculoTipoOperacao(NFeVeiculoTipoOperacaoEnum val) {
            veiculoTipoOperacao = val;
            return this;
        }

        public Builder withVeiculoChassi(String val) {
            veiculoChassi = val;
            return this;
        }

        public Builder withVeiculoCodigoCor(String val) {
            veiculoCodigoCor = val;
            return this;
        }

        public Builder withVeiculoDescricaoCor(String val) {
            veiculoDescricaoCor = val;
            return this;
        }

        public Builder withVeiculoPotenciaMotor(String val) {
            veiculoPotenciaMotor = val;
            return this;
        }

        public Builder withVeiculoCm3(String val) {
            veiculoCm3 = val;
            return this;
        }

        public Builder withVeiculoPesoLiquido(String val) {
            veiculoPesoLiquido = val;
            return this;
        }

        public Builder withVeiculoPesoBruto(String val) {
            veiculoPesoBruto = val;
            return this;
        }

        public Builder withVeiculoSerie(String val) {
            veiculoSerie = val;
            return this;
        }

        public Builder withVeiculoTipoCombustivel(NFeVeiculoTipoCombustivelEnum val) {
            veiculoTipoCombustivel = val;
            return this;
        }

        public Builder withVeiculoNumeroMotor(String val) {
            veiculoNumeroMotor = val;
            return this;
        }

        public Builder withVeiculoCmt(String val) {
            veiculoCmt = val;
            return this;
        }

        public Builder withVeiculoDistanciaEixos(String val) {
            veiculoDistanciaEixos = val;
            return this;
        }

        public Builder withVeiculoAnoModelo(String val) {
            veiculoAnoModelo = val;
            return this;
        }

        public Builder withVeiculoAnoFabricacao(String val) {
            veiculoAnoFabricacao = val;
            return this;
        }

        public Builder withVeiculoTipoPintura(String val) {
            veiculoTipoPintura = val;
            return this;
        }

        public Builder withVeiculoTipo(String val) {
            veiculoTipo = val;
            return this;
        }

        public Builder withVeiculoEspecie(String val) {
            veiculoEspecie = val;
            return this;
        }

        public Builder withVeiculoCodigoVin(NFeVeiculoVinEnum val) {
            veiculoCodigoVin = val;
            return this;
        }

        public Builder withVeiculoCondicao(NFeVeiculoCondicaoEnum val) {
            veiculoCondicao = val;
            return this;
        }

        public Builder withVeiculoCodigoMarcaModelo(String val) {
            veiculoCodigoMarcaModelo = val;
            return this;
        }

        public Builder withVeiculoCodigoCorDenatran(NFeVeiculoCodigoCorDenatranEnum val) {
            veiculoCodigoCorDenatran = val;
            return this;
        }

        public Builder withVeiculoLotacao(String val) {
            veiculoLotacao = val;
            return this;
        }

        public Builder withVeiculoRestricao(NFeVeiculoRestricaoEnum val) {
            veiculoRestricao = val;
            return this;
        }

        public Builder withMedicamentoCodigoAnvisa(String val) {
            medicamentoCodigoAnvisa = val;
            return this;
        }

        public Builder withMedicamentoPrecoMaximoConsumidor(BigDecimal val) {
            medicamentoPrecoMaximoConsumidor = val;
            return this;
        }

        public Builder withCombustivelCodigoAnp(String val) {
            combustivelCodigoAnp = val;
            return this;
        }

        public Builder withCombustivelDescricaoAnp(String val) {
            combustivelDescricaoAnp = val;
            return this;
        }

        public Builder withCombustivelPercentualGlp(BigDecimal val) {
            combustivelPercentualGlp = val;
            return this;
        }

        public Builder withCombustivelPercentualGasNaturalNacional(BigDecimal val) {
            combustivelPercentualGasNaturalNacional = val;
            return this;
        }

        public Builder withCombustivelPercentualGasNaturalImportado(BigDecimal val) {
            combustivelPercentualGasNaturalImportado = val;
            return this;
        }

        public Builder withCombustivelValorPartida(BigDecimal val) {
            combustivelValorPartida = val;
            return this;
        }

        public Builder withCombustivelRegistroCodif(String val) {
            combustivelRegistroCodif = val;
            return this;
        }

        public Builder withCombustivelQuantidadeTemperaturaAmbiente(BigDecimal val) {
            combustivelQuantidadeTemperaturaAmbiente = val;
            return this;
        }

        public Builder withCombustivelSiglaUf(NFeUnidadeFederativaEnum val) {
            combustivelSiglaUf = val;
            return this;
        }

        public Builder withCombustivelCideBaseCalculo(BigDecimal val) {
            combustivelCideBaseCalculo = val;
            return this;
        }

        public Builder withCombustivelCideAliquota(BigDecimal val) {
            combustivelCideAliquota = val;
            return this;
        }

        public Builder withCombustivelCideValor(BigDecimal val) {
            combustivelCideValor = val;
            return this;
        }

        public Builder withValorTotalTributos(BigDecimal val) {
            valorTotalTributos = val;
            return this;
        }

        public Builder withIssqnBaseCalculo(BigDecimal val) {
            issqnBaseCalculo = val;
            return this;
        }

        public Builder withIssqnAliquota(BigDecimal val) {
            issqnAliquota = val;
            return this;
        }

        public Builder withIssqnValor(BigDecimal val) {
            issqnValor = val;
            return this;
        }

        public Builder withIssqnCodigoMunicipio(String val) {
            issqnCodigoMunicipio = val;
            return this;
        }

        public Builder withIssqnItemListaServico(String val) {
            issqnItemListaServico = val;
            return this;
        }

        public Builder withIssqnValorDeducao(BigDecimal val) {
            issqnValorDeducao = val;
            return this;
        }

        public Builder withIssqnValorOutrasRetencoes(BigDecimal val) {
            issqnValorOutrasRetencoes = val;
            return this;
        }

        public Builder withIssqnValorDescontoIncondicionado(BigDecimal val) {
            issqnValorDescontoIncondicionado = val;
            return this;
        }

        public Builder withIssqnValorDescontoCondicionado(BigDecimal val) {
            issqnValorDescontoCondicionado = val;
            return this;
        }

        public Builder withIssqnValorRetencao(BigDecimal val) {
            issqnValorRetencao = val;
            return this;
        }

        public Builder withIssqnIndicadorExigibilidade(NFeIssqnIndicadorExigibilidadeEnum val) {
            issqnIndicadorExigibilidade = val;
            return this;
        }

        public Builder withIssqnCodigoServico(String val) {
            issqnCodigoServico = val;
            return this;
        }

        public Builder withIssqnCodigoMunicipioIncidencia(String val) {
            issqnCodigoMunicipioIncidencia = val;
            return this;
        }

        public Builder withIssqnCodigoPais(String val) {
            issqnCodigoPais = val;
            return this;
        }

        public Builder withIssqnNumeroProcesso(String val) {
            issqnNumeroProcesso = val;
            return this;
        }

        public Builder withIssqnIndicadorIncentivo(String val) {
            issqnIndicadorIncentivo = val;
            return this;
        }

        public Builder withIcmsOrigem(NFeIcmsOrigemEnum val) {
            icmsOrigem = val;
            return this;
        }

        public Builder withIcmsSituacaoTributaria(NFeIcmsSituacaoTributariaEnum val) {
            icmsSituacaoTributaria = val;
            return this;
        }

        public Builder withIcmsMmodalidadeBaseCalculo(NFeIcmsModalidadeBaseCalculoEnum val) {
            icmsMmodalidadeBaseCalculo = val;
            return this;
        }

        public Builder withIcmsBaseCalculo(BigDecimal val) {
            icmsBaseCalculo = val;
            return this;
        }

        public Builder withIcmsBaseCalculoRetidoSt(BigDecimal val) {
            icmsBaseCalculoRetidoSt = val;
            return this;
        }

        public Builder withIcmsReducaoBaseCalculo(BigDecimal val) {
            icmsReducaoBaseCalculo = val;
            return this;
        }

        public Builder withIcmsAliquota(BigDecimal val) {
            icmsAliquota = val;
            return this;
        }

        public Builder withIcmsAliquotaFinal(BigDecimal val) {
            icmsAliquotaFinal = val;
            return this;
        }

        public Builder withIcmsValor(BigDecimal val) {
            icmsValor = val;
            return this;
        }

        public Builder withIcmsValorRetidoSt(BigDecimal val) {
            icmsValorRetidoSt = val;
            return this;
        }

        public Builder withIcmsValorDesonerado(BigDecimal val) {
            icmsValorDesonerado = val;
            return this;
        }

        public Builder withIcmsValorOperacao(BigDecimal val) {
            icmsValorOperacao = val;
            return this;
        }

        public Builder withIcmsPercentualDiferimento(BigDecimal val) {
            icmsPercentualDiferimento = val;
            return this;
        }

        public Builder withIcmsValorDiferido(BigDecimal val) {
            icmsValorDiferido = val;
            return this;
        }

        public Builder withIcmsMotivoDesoneracao(NFeIcmsMotivoDesoneracaoEnum val) {
            icmsMotivoDesoneracao = val;
            return this;
        }

        public Builder withIcmsModalidadeBaseCalculoSt(NFeIcmsModalidadeBaseCalculoStEnum val) {
            icmsModalidadeBaseCalculoSt = val;
            return this;
        }

        public Builder withIcmsMargemValorAdicionadoSt(BigDecimal val) {
            icmsMargemValorAdicionadoSt = val;
            return this;
        }

        public Builder withIcmsReducaoBaseCalculoSt(BigDecimal val) {
            icmsReducaoBaseCalculoSt = val;
            return this;
        }

        public Builder withIcmsBaseCalculoSt(BigDecimal val) {
            icmsBaseCalculoSt = val;
            return this;
        }

        public Builder withIcmsAliquotaSt(BigDecimal val) {
            icmsAliquotaSt = val;
            return this;
        }

        public Builder withIcmsValorSt(BigDecimal val) {
            icmsValorSt = val;
            return this;
        }

        public Builder withIcmsAliquotaCreditoSimples(BigDecimal val) {
            icmsAliquotaCreditoSimples = val;
            return this;
        }

        public Builder withIcmsValorCreditoSimples(BigDecimal val) {
            icmsValorCreditoSimples = val;
            return this;
        }

        public Builder withFcpPercentual(BigDecimal val) {
            fcpPercentual = val;
            return this;
        }

        public Builder withFcpBaseCalculo(BigDecimal val) {
            fcpBaseCalculo = val;
            return this;
        }

        public Builder withFcpValor(BigDecimal val) {
            fcpValor = val;
            return this;
        }

        public Builder withFcpPercentualSt(BigDecimal val) {
            fcpPercentualSt = val;
            return this;
        }

        public Builder withFcpBaseCalculoSt(BigDecimal val) {
            fcpBaseCalculoSt = val;
            return this;
        }

        public Builder withFcpValorSt(BigDecimal val) {
            fcpValorSt = val;
            return this;
        }

        public Builder withFcpPercentualRetidoSt(BigDecimal val) {
            fcpPercentualRetidoSt = val;
            return this;
        }

        public Builder withFcpBaseCalculoRetidoSt(BigDecimal val) {
            fcpBaseCalculoRetidoSt = val;
            return this;
        }

        public Builder withFcpValorRetidoSt(BigDecimal val) {
            fcpValorRetidoSt = val;
            return this;
        }

        public Builder withIpiSituacaoTributaria(NFeIpiSituacaoTributariaEnum val) {
            ipiSituacaoTributaria = val;
            return this;
        }

        public Builder withIpiBaseCalculo(BigDecimal val) {
            ipiBaseCalculo = val;
            return this;
        }

        public Builder withIpiAliquota(BigDecimal val) {
            ipiAliquota = val;
            return this;
        }

        public Builder withIpiQuantidadeTotal(BigDecimal val) {
            ipiQuantidadeTotal = val;
            return this;
        }

        public Builder withIpiValorPorUnidadeTributavel(BigDecimal val) {
            ipiValorPorUnidadeTributavel = val;
            return this;
        }

        public Builder withIpiValor(BigDecimal val) {
            ipiValor = val;
            return this;
        }

        public Builder withIpiClasseEnquadramento(String val) {
            ipiClasseEnquadramento = val;
            return this;
        }

        public Builder withIpiCnpjProdutor(String val) {
            ipiCnpjProdutor = val;
            return this;
        }

        public Builder withIpiCodigoSeloControle(String val) {
            ipiCodigoSeloControle = val;
            return this;
        }

        public Builder withIpiQuantidadeSeloControle(String val) {
            ipiQuantidadeSeloControle = val;
            return this;
        }

        public Builder withIpiCodigoEnquadramentoLegal(String val) {
            ipiCodigoEnquadramentoLegal = val;
            return this;
        }

        public Builder withIiBaseCalculo(BigDecimal val) {
            iiBaseCalculo = val;
            return this;
        }

        public Builder withIiDespesasAduaneiras(BigDecimal val) {
            iiDespesasAduaneiras = val;
            return this;
        }

        public Builder withIiValor(BigDecimal val) {
            iiValor = val;
            return this;
        }

        public Builder withIiValorIof(BigDecimal val) {
            iiValorIof = val;
            return this;
        }

        public Builder withPisSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum val) {
            pisSituacaoTributaria = val;
            return this;
        }

        public Builder withPisBaseCalculo(BigDecimal val) {
            pisBaseCalculo = val;
            return this;
        }

        public Builder withPisAliquotaPorcentual(BigDecimal val) {
            pisAliquotaPorcentual = val;
            return this;
        }

        public Builder withPisQuantidadeVendida(BigDecimal val) {
            pisQuantidadeVendida = val;
            return this;
        }

        public Builder withPisAliquotaValor(BigDecimal val) {
            pisAliquotaValor = val;
            return this;
        }

        public Builder withPisValor(BigDecimal val) {
            pisValor = val;
            return this;
        }

        public Builder withPisBaseCalculoSt(BigDecimal val) {
            pisBaseCalculoSt = val;
            return this;
        }

        public Builder withPisAliquotaPorcentualSt(BigDecimal val) {
            pisAliquotaPorcentualSt = val;
            return this;
        }

        public Builder withPisQuantidadeVendidaSt(BigDecimal val) {
            pisQuantidadeVendidaSt = val;
            return this;
        }

        public Builder withPisAliquotaValorSt(BigDecimal val) {
            pisAliquotaValorSt = val;
            return this;
        }

        public Builder withPisValorSt(BigDecimal val) {
            pisValorSt = val;
            return this;
        }

        public Builder withCofinsSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum val) {
            cofinsSituacaoTributaria = val;
            return this;
        }

        public Builder withCofinsBaseCalculo(BigDecimal val) {
            cofinsBaseCalculo = val;
            return this;
        }

        public Builder withCofinsAliquotaPorcentual(BigDecimal val) {
            cofinsAliquotaPorcentual = val;
            return this;
        }

        public Builder withCofinsQuantidadeVendida(BigDecimal val) {
            cofinsQuantidadeVendida = val;
            return this;
        }

        public Builder withCofinsAliquotaValor(BigDecimal val) {
            cofinsAliquotaValor = val;
            return this;
        }

        public Builder withCofinsValor(BigDecimal val) {
            cofinsValor = val;
            return this;
        }

        public Builder withCofinsBaseCalculoSt(BigDecimal val) {
            cofinsBaseCalculoSt = val;
            return this;
        }

        public Builder withCofinsAliquotaPorcentualSt(BigDecimal val) {
            cofinsAliquotaPorcentualSt = val;
            return this;
        }

        public Builder withCofinsQuantidadeVendidaSt(BigDecimal val) {
            cofinsQuantidadeVendidaSt = val;
            return this;
        }

        public Builder withCofinsAliquotaValorSt(BigDecimal val) {
            cofinsAliquotaValorSt = val;
            return this;
        }

        public Builder withCofinsValorSt(BigDecimal val) {
            cofinsValorSt = val;
            return this;
        }

        public Builder withIcmsBaseCalculoUfDestino(BigDecimal val) {
            icmsBaseCalculoUfDestino = val;
            return this;
        }

        public Builder withFcpBaseCalculoUfDestino(BigDecimal val) {
            fcpBaseCalculoUfDestino = val;
            return this;
        }

        public Builder withFcpPercentualUfDestino(BigDecimal val) {
            fcpPercentualUfDestino = val;
            return this;
        }

        public Builder withIcmsAliquotaInternaUfDestino(BigDecimal val) {
            icmsAliquotaInternaUfDestino = val;
            return this;
        }

        public Builder withIcmsAliquotaInterestadual(BigDecimal val) {
            icmsAliquotaInterestadual = val;
            return this;
        }

        public Builder withIcmsPercentualPartilha(BigDecimal val) {
            icmsPercentualPartilha = val;
            return this;
        }

        public Builder withFcpValorUfDestino(BigDecimal val) {
            fcpValorUfDestino = val;
            return this;
        }

        public Builder withIcmsValorUfDestino(BigDecimal val) {
            icmsValorUfDestino = val;
            return this;
        }

        public Builder withIcmsValorUfRemetente(BigDecimal val) {
            icmsValorUfRemetente = val;
            return this;
        }

        public Builder withPercentualDevolvido(BigDecimal val) {
            percentualDevolvido = val;
            return this;
        }

        public Builder withValorIpiDevolvido(BigDecimal val) {
            valorIpiDevolvido = val;
            return this;
        }

        public Builder withInformacoesAdicionaisItem(String val) {
            informacoesAdicionaisItem = val;
            return this;
        }

        public NFeItem build() {
            return new NFeItem(this);
        }
    }
}
