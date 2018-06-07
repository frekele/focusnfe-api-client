package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

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
    private String codigo_barras_comercial;

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
    private String codigo_ncm;

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
    private Boolean escala_relevante;

    //CNPJ do Fabricante da Mercadoria, obrigatório para produto em escala NÃO relevante.
    @Size(max = 14)
    @JsonProperty("cnpj_fabricante")
    private String cnpj_fabricante;

    //Código de Benefício Fiscal utilizado pela UF, aplicado ao item
    @JsonProperty("codigo_beneficio_fiscal_uf")
    private String codigo_beneficio_fiscal_uf;

    //Código EX TIPI do produto.
    @Size(min = 2, max = 3)
    @JsonProperty("codigo_ex_tipi")
    private String codigo_ex_tipi;

    //CFOP do produto.
    @NotNull
    @Size(max = 4)
    @JsonProperty("cfop")
    private String cfop;

    //Unidade comercial.
    @NotNull
    @Size(min = 1, max = 6)
    @JsonProperty("unidade_comercial")
    private String unidade_comercial;

    //Quantidade da mercadoria.
    @NotNull
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_comercial")
    private BigDecimal quantidade_comercial;

    //Valor unitário comercial.
    @NotNull
    @Digits(integer = 11, fraction = 10)
    @BigDecimalJsonConverter
    @JsonProperty("valor_unitario_comercial")
    private BigDecimal valor_unitario_comercial;

    //Valor bruto. Deve ser igual ao produto de Valor unitário comercial com quantidade comercial.
    //Se não informado é calculado automaticamente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_bruto")
    private BigDecimal valor_bruto;

    //Código GTIN/EAN tributável.
    @Size(max = 14)
    @JsonProperty("codigo_barras_tributavel")
    private String codigo_barras_tributavel;

    //Unidade tributável. Se não informado será utilizado o mesmo valor de unidade_comercial.
    @Size(min = 1, max = 6)
    @JsonProperty("unidade_tributavel")
    private String unidade_tributavel;

    //Quantidade tributável. Se não informado será utilizado o mesmo valor de quantidade_comercial.
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("quantidade_tributavel")
    private BigDecimal quantidade_tributavel;

    //Valor unitário tributável Se não informado será utilizado o mesmo valor de valor_unitario_comercial.
    @Digits(integer = 11, fraction = 10)
    @BigDecimalJsonConverter
    @JsonProperty("valor_unitario_tributavel")
    private BigDecimal valor_unitario_tributavel;

    //Valor do frete.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_frete")
    private BigDecimal valor_frete;

    //Valor do seguro.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_seguro")
    private BigDecimal valor_seguro;

    //Valor do desconto.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_desconto")
    private BigDecimal valor_desconto;

    //Valor de outras despesas acessórias.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_outras_despesas")
    private BigDecimal valor_outras_despesas;

    //Valor do item (valor_bruto) compõe valor total da NFe (valor_produtos)?
    @JsonProperty("inclui_no_total")
    private NFeIncluiNoTotalEnum inclui_no_total;

    //Documentos de importação.
    @Size(max = 100)
    @JsonProperty("documentos_importacao")
    private List<NFeDocumentoImportacao> documentos_importacao;

    //Detalhes de exportação
    @Size(max = 500)
    @JsonProperty("detalhes_exportacao")
    private List<NFeDetalheExportacao> detalhes_exportacao;

    //Pedido de Compra.
    @Size(min = 1, max = 15)
    @JsonProperty("pedido_compra")
    private String pedido_compra;

    //Número do Item de Pedido de Compra.
    @Size(max = 6)
    @JsonProperty("numero_item_pedido_compra")
    private String numero_item_pedido_compra;

    //Número da FCI (Ficha de Conteúdo de Importação) veja NT 2013/006
    @Size(max = 36)
    @JsonProperty("numero_fci")
    private String numero_fci;

    //Grupo para permitir a rastreabilidade de qualquer produto sujeito a regulações sanitárias, casos de recolhimento/recall, além de defensivos agrícolas,
    //produtos veterinários, odontológicos, medicamentos, bebidas, águas envasadas, embalagens, etc., a partir da indicação de informações de número de lote,
    //data de fabricação/produção, data de validade, etc. Obrigatório o preenchimento deste grupo no caso de medicamentos e produtos farmacêuticos.
    @JsonProperty("rastros")
    private List<NFeRastro> rastros;

    //Tipo da operação.
    @JsonProperty("veiculo_tipo_operacao")
    private NFeVeiculoTipoOperacaoEnum veiculo_tipo_operacao;

    //Chassi do veículo - VIN.
    @Size(max = 17)
    @JsonProperty("veiculo_chassi")
    private String veiculo_chassi;

    //Cor do veículo (código de cada montadora).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_codigo_cor")
    private String veiculo_codigo_cor;

    //Descrição da cor.
    @Size(min = 1, max = 40)
    @JsonProperty("veiculo_descricao_cor")
    private String veiculo_descricao_cor;

    //Potência máxima do motor em cavalo-vapor (CV).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_potencia_motor")
    private String veiculo_potencia_motor;

    //Capacidade voluntária do motor em centímetros cúbicos (cilindradas/CC).
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_cm3")
    private String veiculo_cm3;

    //Peso líquido.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_peso_liquido")
    private String veiculo_peso_liquido;

    //Peso bruto.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_peso_bruto")
    private String veiculo_peso_bruto;

    //Número de série.
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_serie")
    private String veiculo_serie;

    //Tipo de combustível (utilizar tabela do RENAVAM):
    @JsonProperty("veiculo_tipo_combustivel")
    private NFeVeiculoTipoCombustivelEnum veiculo_tipo_combustivel;

    //Número do motor.
    @Size(min = 1, max = 21)
    @JsonProperty("veiculo_numero_motor")
    private String veiculo_numero_motor;

    //Capacidade máxima de tração em toneladas (4 casas decimais).
    @Size(min = 1, max = 9)
    @JsonProperty("veiculo_cmt")
    private String veiculo_cmt;

    //Distância entre eixos.
    @Size(min = 1, max = 4)
    @JsonProperty("veiculo_distancia_eixos")
    private String veiculo_distancia_eixos;

    //Ano do modelo.
    @Size(max = 4)
    @JsonProperty("veiculo_ano_modelo")
    private String veiculo_ano_modelo;

    //Ano de fabricação.
    @Size(max = 4)
    @JsonProperty("veiculo_ano_fabricacao")
    private String veiculo_ano_fabricacao;

    //Tipo de pintura.
    @Size(max = 1)
    @JsonProperty("veiculo_tipo_pintura")
    private String veiculo_tipo_pintura;

    //Tipo de veículo (utilizar tabela RENAVAM).
    @Size(min = 1, max = 2)
    @JsonProperty("veiculo_tipo")
    private String veiculo_tipo;

    //Espécie de veículo (utilizar tabela RENAVAM).
    @Size(max = 1)
    @JsonProperty("veiculo_especie")
    private String veiculo_especie;

    //Veículo tem VIN remarcado?
    @JsonProperty("veiculo_codigo_vin")
    private NFeVeiculoVinEnum veiculo_codigo_vin;

    //Condição do veículo.
    @JsonProperty("veiculo_condicao")
    private NFeVeiculoCondicaoEnum veiculo_condicao;

    //Código Marca Modelo (utilizar tabela RENAVAM).
    @Size(min = 1, max = 6)
    @JsonProperty("veiculo_codigo_marca_modelo")
    private String veiculo_codigo_marca_modelo;

    //Código da cor segundo as regras de pré-cadastro do DENATRAN.
    @JsonProperty("veiculo_codigo_cor_denatran")
    private NFeVeiculoCodigoCorDenatranEnum veiculo_codigo_cor_denatran;

    //Quantidade máxima permitida de passageiros sentados, inclusive motorista.
    @Size(min = 1, max = 3)
    @JsonProperty("veiculo_lotacao")
    private String veiculo_lotacao;

    //Restrição.
    @JsonProperty("veiculo_restricao")
    private NFeVeiculoRestricaoEnum veiculo_restricao;

    //Código de Produto da ANVISA
    @Size(max = 13)
    @JsonProperty("medicamento_codigo_anvisa")
    private String medicamento_codigo_anvisa;

    //Preço Máximo ao consumidor
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("medicamento_preco_maximo_consumidor")
    private BigDecimal medicamento_preco_maximo_consumidor;

    //Código de produto da ANP (www.anp.gov.br/simp/)
    @Size(max = 9)
    @JsonProperty("combustivel_codigo_anp")
    private String combustivel_codigo_anp;

    //Descrição do produto conforme ANP
    @Size(min = 2, max = 95)
    @JsonProperty("combustivel_descricao_anp")
    private String combustivel_descricao_anp;

    //Percentual do GLP derivado do petróleo no produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_glp")
    private BigDecimal combustivel_percentual_glp;

    //Percentual de Gás Natural Nacional – GLGNn para o produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_gas_natural_nacional")
    private BigDecimal combustivel_percentual_gas_natural_nacional;

    //Percentual de Gás Natural Importado – GLGNi para o produto GLP (combustivel_codigo_anp=210203001)
    @Digits(integer = 1, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_percentual_gas_natural_importado")
    private BigDecimal combustivel_percentual_gas_natural_importado;

    //Valor de partida (combustivel_codigo_anp=210203001)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_valor_partida")
    private BigDecimal combustivel_valor_partida;

    //Código de autorização / registro do CODIF - Informar apenas quando a UF utilizar o CODIF
    @Size(max = 21)
    @JsonProperty("combustivel_registro_codif")
    private String combustivel_registro_codif;

    //Quantidade de combustível faturada à temperatura ambiente,
    //Informar quando a quantidade faturada informada no campo quantidade do produto tiver sido ajustada para uma temperatura diferente da ambiente.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_quantidade_temperatura_ambiente")
    private BigDecimal combustivel_quantidade_temperatura_ambiente;

    //Sigla da UF de consumo - Informar “EX” para exterior
    @JsonProperty("combustivel_sigla_uf")
    private NFeUnidadeFederativaEnum combustivel_sigla_uf;

    //BC da CIDE em quantidade
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_base_calculo")
    private BigDecimal combustivel_cide_base_calculo;

    //Valor da alíquota da CIDE em reais
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_aliquota")
    private BigDecimal combustivel_cide_aliquota;

    //Valor da CIDE
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("combustivel_cide_valor")
    private BigDecimal combustivel_cide_valor;

    //Valor total aproximado dos tributos - calculado automaticamente pela API
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_total_tributos")
    private BigDecimal valor_total_tributos;

    //Valor da Base de Cálculo do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_base_calculo")
    private BigDecimal issqn_base_calculo;

    //Alíquota do ISSQN
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_aliquota")
    private BigDecimal issqn_aliquota;

    //Valor do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor")
    private BigDecimal issqn_valor;

    //Código do município de ocorrência do fato gerador do ISSQN
    @Size(max = 7)
    @JsonProperty("issqn_codigo_municipio")
    private String issqn_codigo_municipio;

    //Item da Lista de Serviços do ISSQN. Formato: NN.NN
    @Size(max = 5)
    @JsonProperty("issqn_item_lista_servico")
    private String issqn_item_lista_servico;

    //Valor dedução para redução da Base de Cálculo do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_deducao")
    private BigDecimal issqn_valor_deducao;

    //Valor outras retenções do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_outras_retencoes")
    private BigDecimal issqn_valor_outras_retencoes;

    //Valor desconto incondicionado do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_desconto_incondicionado")
    private BigDecimal issqn_valor_desconto_incondicionado;

    //Valor desconto condicionado do ISSQN
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_desconto_condicionado")
    private BigDecimal issqn_valor_desconto_condicionado;

    //Valor retenção ISS
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("issqn_valor_retencao")
    private BigDecimal issqn_valor_retencao;

    //Indicador da exigibilidade do ISS: (valor default: 1)
    @JsonProperty("issqn_indicador_exigibilidade")
    private NFeIssqnIndicadorExigibilidadeEnum issqn_indicador_exigibilidade;

    //Código do serviço prestado dentro do município
    @Size(min = 1, max = 20)
    @JsonProperty("issqn_codigo_servico")
    private String issqn_codigo_servico;

    //Código do Município de incidência do imposto ISSQN - Tabela do IBGE. Informar “9999999” para serviço fora do País.
    @Size(max = 7)
    @JsonProperty("issqn_codigo_municipio_incidencia")
    private String issqn_codigo_municipio_incidencia;

    //Código do País onde o serviço foi prestado - Tabela do BACEN. Infomar somente se o município da prestação do serviço for “9999999”.
    @Size(max = 4)
    @JsonProperty("issqn_codigo_pais")
    private String issqn_codigo_pais;

    //Número do processo judicial ou administrativo de suspensão da exigibilidade - Informar somente quando declarada a suspensão da exigibilidade do ISSQN
    @Size(min = 1, max = 30)
    @JsonProperty("issqn_numero_processo")
    private String issqn_numero_processo;

    //Indicador de incentivo Fiscal ISSQN
    @Size(max = 1)
    @JsonProperty("issqn_indicador_incentivo")
    private String issqn_indicador_incentivo;

    //Origem da mercadoria.
    @NotNull
    @JsonProperty("icms_origem")
    private NFeIcmsOrigemEnum icms_origem;

    //Situação tributária do ICMS.
    @NotNull
    @JsonProperty("icms_situacao_tributaria")
    private NFeIcmsSituacaoTributariaEnum icms_situacao_tributaria;

    //Modalidade de determinação da base de cálculo do ICMS.
    @JsonProperty("icms_modalidade_base_calculo")
    private NFeIcmsModalidadeBaseCalculoEnum icms_modalidade_base_calculo;

    //Valor da base de cálculo do ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo")
    private BigDecimal icms_base_calculo;

    //Valor da base de cálculo do ICMS retido anteriormente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_retido_st")
    private BigDecimal icms_base_calculo_retido_st;

    //Percentual de redução da base de cálculo.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_reducao_base_calculo")
    private BigDecimal icms_reducao_base_calculo;

    //Alíquota do ICMS.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota")
    private BigDecimal icms_aliquota;

    //Alíquota do ICMS suportada pelo consumidor final.
    //Informado apenas para icms_situacao_tributaria = 60 ou 500.
    //Deve ser informada a alíquota do cálculo do ICMS-ST, já incluso o FCP caso incida sobre a mercadoria.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_final")
    private BigDecimal icms_aliquota_final;

    //Valor do ICMS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor")
    private BigDecimal icms_valor;

    //Valor do ICMS retido anteriormente.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_retido_st")
    private BigDecimal icms_valor_retido_st;

    //Valor do ICMS desonerado.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_desonerado")
    private BigDecimal icms_valor_desonerado;

    //(CST=51) Valor como se não tivesse o diferimento
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_operacao")
    private BigDecimal icms_valor_operacao;

    //(CST=51) Percentual de diferimento
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_percentual_diferimento")
    private BigDecimal icms_percentual_diferimento;

    //(CST=51) Valor do ICMS diferido (informar o valor realmente devido no campo icms_valor)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_diferido")
    private BigDecimal icms_valor_diferido;

    //Motivo da desoneração do ICMS.
    @JsonProperty("icms_motivo_desoneracao")
    private NFeIcmsMotivoDesoneracaoEnum icms_motivo_desoneracao;

    //Modalidade de determinação da base de cálculo do ICMS ST.
    @JsonProperty("icms_modalidade_base_calculo_st")
    private NFeIcmsModalidadeBaseCalculoStEnum icms_modalidade_base_calculo_st;

    //Percentual da margem de valor adicionado do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_margem_valor_adicionado_st")
    private BigDecimal icms_margem_valor_adicionado_st;

    //Percentual de redução da base de cálculo do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_reducao_base_calculo_st")
    private BigDecimal icms_reducao_base_calculo_st;

    //Valor da base de cálculo do ICMS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_st")
    private BigDecimal icms_base_calculo_st;

    //Alíquota do ICMS ST.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_st")
    private BigDecimal icms_aliquota_st;

    //Valor do ICMS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_st")
    private BigDecimal icms_valor_st;

    //Alíquota aplicável de cálculo do crédito (Apenas Simples Nacional).
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_credito_simples")
    private BigDecimal icms_aliquota_credito_simples;

    //Valor crédito do ICMS que pode ser aproveitado nos termos do art. 23 da LC 123 (Apenas Simples Nacional)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_credito_simples")
    private BigDecimal icms_valor_credito_simples;

    //Percentual do Fundo de Combate à Pobreza (FCP)
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual")
    private BigDecimal fcp_percentual;

    //Valor da Base de Cálculo do FCP
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo")
    private BigDecimal fcp_base_calculo;

    //Valor do Fundo de Combate à Pobreza (FCP)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor")
    private BigDecimal fcp_valor;

    //Percentual do Fundo de Combate à Pobreza (FCP) retido por Substituição Tributária
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_st")
    private BigDecimal fcp_percentual_st;

    //Valor da Base de Cálculo do FCP retido por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_st")
    private BigDecimal fcp_base_calculo_st;

    //Valor do Fundo de Combate à Pobreza (FCP) retido por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_st")
    private BigDecimal fcp_valor_st;

    //Percentual do Fundo de Combate à Pobreza (FCP) retido anteriormente por Substituição Tributária
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_retido_st")
    private BigDecimal fcp_percentual_retido_st;

    //Valor da Base de Cálculo do FCP retido anteriormente por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_retido_st")
    private BigDecimal fcp_base_calculo_retido_st;

    //Valor do Fundo de Combate à Pobreza (FCP) retido anteriormente por Substituição Tributária
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_retido_st")
    private BigDecimal fcp_valor_retido_st;

    //Situação tributária do IPI.
    @JsonProperty("ipi_situacao_tributaria")
    private NFeIpiSituacaoTributariaEnum ipi_situacao_tributaria;

    //Valor da base de cálculo do IPI.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_base_calculo")
    private BigDecimal ipi_base_calculo;

    //Alíquota do IPI.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_aliquota")
    private BigDecimal ipi_aliquota;

    //Quantidade total na unidade padrão para tributação.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_quantidade_total")
    private BigDecimal ipi_quantidade_total;

    //Valor por unidade tributável. Informar o valor do imposto pauta por unidade de medida.
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_valor_por_unidade_tributavel")
    private BigDecimal ipi_valor_por_unidade_tributavel;

    //Valor do IPI.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ipi_valor")
    private BigDecimal ipi_valor;

    //Classe de enquadramento do IPI (para cigarros e bebidas).
    @Size(min = 1, max = 5)
    @JsonProperty("ipi_classe_enquadramento")
    private String ipi_classe_enquadramento;

    //CNPJ do produtor. Informar apenas quando for diferente do emitente, em casos
    @Size(max = 14)
    @JsonProperty("ipi_cnpj_produtor")
    private String ipi_cnpj_produtor;

    //Código do selo de controle do IPI.
    @Size(min = 1, max = 60)
    @JsonProperty("ipi_codigo_selo_controle")
    private String ipi_codigo_selo_controle;

    //Quantidade de selo de controle.
    @Size(min = 1, max = 12)
    @JsonProperty("ipi_quantidade_selo_controle")
    private String ipi_quantidade_selo_controle;

    //Código de Enquadramento Legal do IPI. Obrigatório quando informado IPI. Utilize o valor 999 se não aplicável
    @Size(max = 3)
    @JsonProperty("ipi_codigo_enquadramento_legal")
    private String ipi_codigo_enquadramento_legal;

    //Base de cálculo do imposto de importação.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_base_calculo")
    private BigDecimal ii_base_calculo;

    //Valor das despesas aduaneiras.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_despesas_aduaneiras")
    private BigDecimal ii_despesas_aduaneiras;

    //Valor do imposto de importação.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_valor")
    private BigDecimal ii_valor;

    //Valor do IOF.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("ii_valor_iof")
    private BigDecimal ii_valor_iof;

    //Situação tributária do PIS.
    @NotNull
    @JsonProperty("pis_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum pis_situacao_tributaria;

    //Valor da base de cálculo do PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_base_calculo")
    private BigDecimal pis_base_calculo;

    //Alíquota do PIS em porcentual.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_porcentual")
    private BigDecimal pis_aliquota_porcentual;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_quantidade_vendida")
    private BigDecimal pis_quantidade_vendida;

    //Alíquota do PIS em unidades monetarias.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_valor")
    private BigDecimal pis_aliquota_valor;

    //Valor do PIS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor")
    private BigDecimal pis_valor;

    //Valor da base de cálculo do PIS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_base_calculo_st")
    private BigDecimal pis_base_calculo_st;

    //Alíquota do PIS ST (em percentual).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_porcentual_st")
    private BigDecimal pis_aliquota_porcentual_st;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_quantidade_vendida_st")
    private BigDecimal pis_quantidade_vendida_st;

    //Alíquota do PIS ST (em unidades monetarias).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("pis_aliquota_valor_st")
    private BigDecimal pis_aliquota_valor_st;

    //Valor do PIS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("pis_valor_st")
    private BigDecimal pis_valor_st;

    //Situação tributária do PIS.
    @NotNull
    @JsonProperty("cofins_situacao_tributaria")
    private NFePisCofinsSituacaoTributariaEnum cofins_situacao_tributaria;

    //Valor da base de cálculo do COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_base_calculo")
    private BigDecimal cofins_base_calculo;

    //Alíquota do COFINS em porcentual.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_porcentual")
    private BigDecimal cofins_aliquota_porcentual;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_quantidade_vendida")
    private BigDecimal cofins_quantidade_vendida;

    //Alíquota do COFINS em unidades monetarias.
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor")
    private BigDecimal cofins_aliquota_valor;

    //Valor do COFINS.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor")
    private BigDecimal cofins_valor;

    //Valor da base de cálculo do COFINS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_base_calculo_st")
    private BigDecimal cofins_base_calculo_st;

    //Alíquota do COFINS ST (em percentual).
    @Digits(integer = 3, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_porcentual_st")
    private BigDecimal cofins_aliquota_porcentual_st;

    //Quantidade vendida.
    @Digits(integer = 12, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_quantidade_vendida_st")
    private BigDecimal cofins_quantidade_vendida_st;

    //Alíquota do COFINS ST (em unidades monetarias).
    @Digits(integer = 11, fraction = 4)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_aliquota_valor_st")
    private BigDecimal cofins_aliquota_valor_st;

    //Valor do COFINS ST.
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("cofins_valor_st")
    private BigDecimal cofins_valor_st;

    //(apenas para venda interestadual para consumidor final) Valor da BC do ICMS na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_base_calculo_uf_destino")
    private BigDecimal icms_base_calculo_uf_destino;

    //(apenas para venda interestadual para consumidor final) Valor da BC FCP na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_base_calculo_uf_destino")
    private BigDecimal fcp_base_calculo_uf_destino;

    //(apenas para venda interestadual para consumidor final) Percentual do ICMS relativo ao Fundo de Combate à Pobreza (FCP) na UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_percentual_uf_destino")
    private BigDecimal fcp_percentual_uf_destino;

    //(apenas para venda interestadual para consumidor final) Alíquota interna da UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_interna_uf_destino")
    private BigDecimal icms_aliquota_interna_uf_destino;

    //(apenas para venda interestadual para consumidor final) Alíquota interestadual das UF envolvidas
    @BigDecimalJsonConverter
    @JsonProperty("icms_aliquota_interestadual")
    private BigDecimal icms_aliquota_interestadual;

    //(apenas para venda interestadual para consumidor final) Percentual provisório de partilha do ICMS Interestadual
    @BigDecimalJsonConverter
    @JsonProperty("icms_percentual_partilha")
    private BigDecimal icms_percentual_partilha;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS relativo ao Fundo de Combate à Pobreza (FCP) da UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("fcp_valor_uf_destino")
    private BigDecimal fcp_valor_uf_destino;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS Interestadual para a UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_uf_destino")
    private BigDecimal icms_valor_uf_destino;

    //(apenas para venda interestadual para consumidor final) Valor do ICMS Interestadual para a UF de destino
    @BigDecimalJsonConverter
    @JsonProperty("icms_valor_uf_remetente")
    private BigDecimal icms_valor_uf_remetente;

    //Percentual da mercadoria devolvida
    @Digits(integer = 3, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("percentual_devolvido")
    private BigDecimal percentual_devolvido;

    //Valor do IPI devolvido
    @Digits(integer = 3, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_ipi_devolvido")
    private BigDecimal valor_ipi_devolvido;

    //Informações adicionais do item
    @Size(max = 500)
    @JsonProperty("informacoes_adicionais_item")
    private String informacoes_adicionais_item;

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
