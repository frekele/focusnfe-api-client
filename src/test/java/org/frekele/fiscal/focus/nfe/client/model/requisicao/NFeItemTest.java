package org.frekele.fiscal.focus.nfe.client.model.requisicao;

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
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeDetalheExportacao;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeDocumentoImportacao;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeItem;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeNve;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeRastro;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeItemTest {

    @Test
    public void testNewInstance() throws Exception {
        String numeroItem = "1";
        String codigoProduto = "378t4yhfgsdjh";
        String codigoBarrasComercial = "873465874356843756786";
        String descricao = "lba bla vla bla bla bla";
        String codigoNcm = "40123122";
        List<NFeNve> nves = new ArrayList<>();
        nves.add(new NFeNve("234343"));
        String cest = "576755765";
        Boolean escalaRelevante = Boolean.TRUE;
        String cnpjFabricante = "45678765434567";
        String codigoBeneficioFiscalUf = "453453543";
        String codigoExTipi = "4343";
        String cfop = "5102";
        String unidadeComercial = "UN";
        BigDecimal quantidadeComercial = new BigDecimal("10.21");
        BigDecimal valorUnitarioComercial = new BigDecimal("10.22");
        BigDecimal valorBruto = new BigDecimal("10.23");
        String codigoBarrasTributavel = "4387549857439584789";
        String unidadeTributavel = "UN";
        BigDecimal quantidadeTributavel = new BigDecimal("10.24");
        BigDecimal valorUnitarioTributavel = new BigDecimal("10.25");
        BigDecimal valorFrete = new BigDecimal("10.26");
        BigDecimal valorSeguro = new BigDecimal("10.27");
        BigDecimal valorDesconto = new BigDecimal("10.28");
        BigDecimal valorOutrasDespesas = new BigDecimal("10.29");
        NFeIncluiNoTotalEnum incluiNoTotal = NFeIncluiNoTotalEnum.NAO;
        List<NFeDocumentoImportacao> documentosImportacao = new ArrayList<>();
        documentosImportacao.add(new NFeDocumentoImportacao());
        List<NFeDetalheExportacao> detalhesExportacao = new ArrayList<>();
        detalhesExportacao.add(new NFeDetalheExportacao());
        String pedidoCompra = "879347";
        String numeroItemPedidoCompra = "637457";
        String numeroFci = "6723457";
        List<NFeRastro> rastros = new ArrayList<>();
        rastros.add(new NFeRastro());
        NFeVeiculoTipoOperacaoEnum veiculoTipoOperacao = NFeVeiculoTipoOperacaoEnum.VENDA_DIRETA;
        String veiculoChassi = "765";
        String veiculoCodigoCor = "gfhytr765";
        String veiculoDescricaoCor = "azul";
        String veiculoPotenciaMotor = "82374";
        String veiculoCm3 = "786";
        String veiculoPesoLiquido = "345.45";
        String veiculoPesoBruto = "567.76";
        String veiculoSerie = "897";
        NFeVeiculoTipoCombustivelEnum veiculoTipoCombustivel = NFeVeiculoTipoCombustivelEnum.GASOLINA;
        String veiculoNumeroMotor = "765765";
        String veiculoCmt = "59087";
        String veiculoDistanciaEixos = "783";
        String veiculoAnoModelo = "1504";
        String veiculoAnoFabricacao = "1503";
        String veiculoTipoPintura = "normal";
        String veiculoTipo = "bla bla";
        String veiculoEspecie = "x1";
        NFeVeiculoVinEnum veiculoCodigoVin = NFeVeiculoVinEnum.NORMAL;
        NFeVeiculoCondicaoEnum veiculoCondicao = NFeVeiculoCondicaoEnum.ACABADO;
        String veiculoCodigoMarcaModelo = "65754";
        NFeVeiculoCodigoCorDenatranEnum veiculoCodigoCorDenatran = NFeVeiculoCodigoCorDenatranEnum.AZUL;
        String veiculoLotacao = "675765";
        NFeVeiculoRestricaoEnum veiculoRestricao = NFeVeiculoRestricaoEnum.NAO_HA;
        String medicamentoCodigoAnvisa = "6767556";
        BigDecimal medicamentoPrecoMaximoConsumidor = new BigDecimal("10.30");
        String combustivelCodigoAnp = "8sgyfds";
        String combustivelDescricaoAnp = "sdfhfkjdhfkj zdxfcsd";
        BigDecimal combustivelPercentualGlp = new BigDecimal("10.31");
        BigDecimal combustivelPercentualGasNaturalNacional = new BigDecimal("10.32");
        BigDecimal combustivelPercentualGasNaturalImportado = new BigDecimal("10.33");
        BigDecimal combustivelValorPartida = new BigDecimal("10.34");
        String combustivelRegistroCodif = "hgjfdjh73456";
        BigDecimal combustivelQuantidadeTemperaturaAmbiente = new BigDecimal("10.35");
        NFeUnidadeFederativaEnum combustivelSiglaUf = NFeUnidadeFederativaEnum.PARANA;
        BigDecimal combustivelCideBaseCalculo = new BigDecimal("10.36");
        BigDecimal combustivelCideAliquota = new BigDecimal("10.37");
        BigDecimal combustivelCideValor = new BigDecimal("10.38");
        BigDecimal valorTotalTributos = new BigDecimal("10.39");
        BigDecimal issqnBaseCalculo = new BigDecimal("10.40");
        BigDecimal issqnAliquota = new BigDecimal("10.41");
        BigDecimal issqnValor = new BigDecimal("10.42");
        String issqnCodigoMunicipio = "76238";
        String issqnItemListaServico = "34545";
        BigDecimal issqnValorDeducao = new BigDecimal("10.43");
        BigDecimal issqnValorOutrasRetencoes = new BigDecimal("10.44");
        BigDecimal issqnValorDescontoIncondicionado = new BigDecimal("10.45");
        BigDecimal issqnValorDescontoCondicionado = new BigDecimal("10.46");
        BigDecimal issqnValorRetencao = new BigDecimal("10.47");
        NFeIssqnIndicadorExigibilidadeEnum issqnIndicadorExigibilidade = NFeIssqnIndicadorExigibilidadeEnum.ISENCAO;
        String issqnCodigoServico = "86876";
        String issqnCodigoMunicipioIncidencia = "64363";
        String issqnCodigoPais = "434";
        String issqnNumeroProcesso = "12343";
        String issqnIndicadorIncentivo = "4536757";
        NFeIcmsOrigemEnum icmsOrigem = NFeIcmsOrigemEnum.NACIONAL;
        NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria = NFeIcmsSituacaoTributariaEnum.ISENTA;
        NFeIcmsModalidadeBaseCalculoEnum icmsMmodalidadeBaseCalculo = NFeIcmsModalidadeBaseCalculoEnum.MARGEM_DE_VALOR_AGREGADO;
        BigDecimal icmsBaseCalculo = new BigDecimal("10.48");
        BigDecimal icmsBaseCalculoRetidoSt = new BigDecimal("10.49");
        BigDecimal icmsReducaoBaseCalculo = new BigDecimal("10.50");
        BigDecimal icmsAliquota = new BigDecimal("10.51");
        BigDecimal icmsAliquotaFinal = new BigDecimal("10.52");
        BigDecimal icmsValor = new BigDecimal("10.53");
        BigDecimal icmsValorRetidoSt = new BigDecimal("10.54");
        BigDecimal icmsValorDesonerado = new BigDecimal("10.55");
        BigDecimal icmsValorOperacao = new BigDecimal("10.56");
        BigDecimal icmsPercentualDiferimento = new BigDecimal("10.57");
        BigDecimal icmsValorDiferido = new BigDecimal("10.58");
        NFeIcmsMotivoDesoneracaoEnum icmsMotivoDesoneracao = NFeIcmsMotivoDesoneracaoEnum.TAXI;
        NFeIcmsModalidadeBaseCalculoStEnum icmsModalidadeBaseCalculoSt = NFeIcmsModalidadeBaseCalculoStEnum.MARGEM_DE_VALOR_AGREGADO;
        BigDecimal icmsMargemValorAdicionadoSt = new BigDecimal("10.59");
        BigDecimal icmsReducaoBaseCalculoSt = new BigDecimal("10.60");
        BigDecimal icmsBaseCalculoSt = new BigDecimal("10.61");
        BigDecimal icmsAliquotaSt = new BigDecimal("10.62");
        BigDecimal icmsValorSt = new BigDecimal("10.63");
        BigDecimal icmsAliquotaCreditoSimples = new BigDecimal("10.64");
        BigDecimal icmsValorCreditoSimples = new BigDecimal("10.65");
        BigDecimal fcpPercentual = new BigDecimal("10.66");
        BigDecimal fcpBaseCalculo = new BigDecimal("10.67");
        BigDecimal fcpValor = new BigDecimal("10.68");
        BigDecimal fcpPercentualSt = new BigDecimal("10.69");
        BigDecimal fcpBaseCalculoSt = new BigDecimal("10.70");
        BigDecimal fcpValorSt = new BigDecimal("10.71");
        BigDecimal fcpPercentualRetidoSt = new BigDecimal("10.72");
        BigDecimal fcpBaseCalculoRetidoSt = new BigDecimal("10.73");
        BigDecimal fcpValorRetidoSt = new BigDecimal("10.74");
        NFeIpiSituacaoTributariaEnum ipiSituacaoTributaria = NFeIpiSituacaoTributariaEnum.SAIDA_ISENTA;
        BigDecimal ipiBaseCalculo = new BigDecimal("10.75");
        BigDecimal ipiAliquota = new BigDecimal("10.76");
        BigDecimal ipiQuantidadeTotal = new BigDecimal("10.77");
        BigDecimal ipiValorPorUnidadeTributavel = new BigDecimal("10.78");
        BigDecimal ipiValor = new BigDecimal("10.79");
        String ipiClasseEnquadramento = "0989";
        String ipiCnpjProdutor = "4567865433578675";
        String ipiCodigoSeloControle = "6576";
        String ipiQuantidadeSeloControle = "78";
        String ipiCodigoEnquadramentoLegal = "786876";
        BigDecimal iiBaseCalculo = new BigDecimal("10.80");
        BigDecimal iiDespesasAduaneiras = new BigDecimal("10.81");
        BigDecimal iiValor = new BigDecimal("10.82");
        BigDecimal iiValorIof = new BigDecimal("10.83");
        NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria = NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_SAIDA;
        BigDecimal pisBaseCalculo = new BigDecimal("10.84");
        BigDecimal pisAliquotaPorcentual = new BigDecimal("10.85");
        BigDecimal pisQuantidadeVendida = new BigDecimal("10.86");
        BigDecimal pisAliquotaValor = new BigDecimal("10.87");
        BigDecimal pisValor = new BigDecimal("10.88");
        BigDecimal pisBaseCalculoSt = new BigDecimal("10.89");
        BigDecimal pisAliquotaPorcentualSt = new BigDecimal("10.90");
        BigDecimal pisQuantidadeVendidaSt = new BigDecimal("10.91");
        BigDecimal pisAliquotaValorSt = new BigDecimal("10.92");
        BigDecimal pisValorSt = new BigDecimal("10.93");
        NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria = NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_SAIDA;
        BigDecimal cofinsBaseCalculo = new BigDecimal("10.94");
        BigDecimal cofinsAliquotaPorcentual = new BigDecimal("10.95");
        BigDecimal cofinsQuantidadeVendida = new BigDecimal("10.96");
        BigDecimal cofinsAliquotaValor = new BigDecimal("10.97");
        BigDecimal cofinsValor = new BigDecimal("10.98");
        BigDecimal cofinsBaseCalculoSt = new BigDecimal("10.99");
        BigDecimal cofinsAliquotaPorcentualSt = new BigDecimal("11.01");
        BigDecimal cofinsQuantidadeVendidaSt = new BigDecimal("111.02");
        BigDecimal cofinsAliquotaValorSt = new BigDecimal("11.03");
        BigDecimal cofinsValorSt = new BigDecimal("11.04");
        BigDecimal icmsBaseCalculoUfDestino = new BigDecimal("11.05");
        BigDecimal fcpBaseCalculoUfDestino = new BigDecimal("11.06");
        BigDecimal fcpPercentualUfDestino = new BigDecimal("11.07");
        BigDecimal icmsAliquotaInternaUfDestino = new BigDecimal("11.08");
        BigDecimal icmsAliquotaInterestadual = new BigDecimal("11.09");
        BigDecimal icmsPercentualPartilha = new BigDecimal("11.10");
        BigDecimal fcpValorUfDestino = new BigDecimal("11.11");
        BigDecimal icmsValorUfDestino = new BigDecimal("11.12");
        BigDecimal icmsValorUfRemetente = new BigDecimal("11.13");
        BigDecimal percentualDevolvido = new BigDecimal("11.14");
        BigDecimal valorIpiDevolvido = new BigDecimal("11.15");
        String informacoesAdicionaisItem = "bla bla bla bla bla bla";

        NFeItem entity = new NFeItem();
        entity.setNumeroItem(numeroItem);
        entity.setCodigoProduto(codigoProduto);
        entity.setCodigoBarrasComercial(codigoBarrasComercial);
        entity.setDescricao(descricao);
        entity.setCodigoNcm(codigoNcm);
        entity.setNves(nves);
        entity.setCest(cest);
        entity.setEscalaRelevante(escalaRelevante);
        entity.setCnpjFabricante(cnpjFabricante);
        entity.setCodigoBeneficioFiscalUf(codigoBeneficioFiscalUf);
        entity.setCodigoExTipi(codigoExTipi);
        entity.setCfop(cfop);
        entity.setUnidadeComercial(unidadeComercial);
        entity.setQuantidadeComercial(quantidadeComercial);
        entity.setValorUnitarioComercial(valorUnitarioComercial);
        entity.setValorBruto(valorBruto);
        entity.setCodigoBarrasTributavel(codigoBarrasTributavel);
        entity.setUnidadeTributavel(unidadeTributavel);
        entity.setQuantidadeTributavel(quantidadeTributavel);
        entity.setValorUnitarioTributavel(valorUnitarioTributavel);
        entity.setValorFrete(valorFrete);
        entity.setValorSeguro(valorSeguro);
        entity.setValorDesconto(valorDesconto);
        entity.setValorOutrasDespesas(valorOutrasDespesas);
        entity.setIncluiNoTotal(incluiNoTotal);
        entity.setDocumentosImportacao(documentosImportacao);
        entity.setDetalhesExportacao(detalhesExportacao);
        entity.setPedidoCompra(pedidoCompra);
        entity.setNumeroItemPedidoCompra(numeroItemPedidoCompra);
        entity.setNumeroFci(numeroFci);
        entity.setRastros(rastros);
        entity.setVeiculoTipoOperacao(veiculoTipoOperacao);
        entity.setVeiculoChassi(veiculoChassi);
        entity.setVeiculoCodigoCor(veiculoCodigoCor);
        entity.setVeiculoDescricaoCor(veiculoDescricaoCor);
        entity.setVeiculoPotenciaMotor(veiculoPotenciaMotor);
        entity.setVeiculoCm3(veiculoCm3);
        entity.setVeiculoPesoLiquido(veiculoPesoLiquido);
        entity.setVeiculoPesoBruto(veiculoPesoBruto);
        entity.setVeiculoSerie(veiculoSerie);
        entity.setVeiculoTipoCombustivel(veiculoTipoCombustivel);
        entity.setVeiculoNumeroMotor(veiculoNumeroMotor);
        entity.setVeiculoCmt(veiculoCmt);
        entity.setVeiculoDistanciaEixos(veiculoDistanciaEixos);
        entity.setVeiculoAnoModelo(veiculoAnoModelo);
        entity.setVeiculoAnoFabricacao(veiculoAnoFabricacao);
        entity.setVeiculoTipoPintura(veiculoTipoPintura);
        entity.setVeiculoTipo(veiculoTipo);
        entity.setVeiculoEspecie(veiculoEspecie);
        entity.setVeiculoCodigoVin(veiculoCodigoVin);
        entity.setVeiculoCondicao(veiculoCondicao);
        entity.setVeiculoCodigoMarcaModelo(veiculoCodigoMarcaModelo);
        entity.setVeiculoCodigoCorDenatran(veiculoCodigoCorDenatran);
        entity.setVeiculoLotacao(veiculoLotacao);
        entity.setVeiculoRestricao(veiculoRestricao);
        entity.setMedicamentoCodigoAnvisa(medicamentoCodigoAnvisa);
        entity.setMedicamentoPrecoMaximoConsumidor(medicamentoPrecoMaximoConsumidor);
        entity.setCombustivelCodigoAnp(combustivelCodigoAnp);
        entity.setCombustivelDescricaoAnp(combustivelDescricaoAnp);
        entity.setCombustivelPercentualGlp(combustivelPercentualGlp);
        entity.setCombustivelPercentualGasNaturalNacional(combustivelPercentualGasNaturalNacional);
        entity.setCombustivelPercentualGasNaturalImportado(combustivelPercentualGasNaturalImportado);
        entity.setCombustivelValorPartida(combustivelValorPartida);
        entity.setCombustivelRegistroCodif(combustivelRegistroCodif);
        entity.setCombustivelQuantidadeTemperaturaAmbiente(combustivelQuantidadeTemperaturaAmbiente);
        entity.setCombustivelSiglaUf(combustivelSiglaUf);
        entity.setCombustivelCideBaseCalculo(combustivelCideBaseCalculo);
        entity.setCombustivelCideAliquota(combustivelCideAliquota);
        entity.setCombustivelCideValor(combustivelCideValor);
        entity.setValorTotalTributos(valorTotalTributos);
        entity.setIssqnBaseCalculo(issqnBaseCalculo);
        entity.setIssqnAliquota(issqnAliquota);
        entity.setIssqnValor(issqnValor);
        entity.setIssqnCodigoMunicipio(issqnCodigoMunicipio);
        entity.setIssqnItemListaServico(issqnItemListaServico);
        entity.setIssqnValorDeducao(issqnValorDeducao);
        entity.setIssqnValorOutrasRetencoes(issqnValorOutrasRetencoes);
        entity.setIssqnValorDescontoIncondicionado(issqnValorDescontoIncondicionado);
        entity.setIssqnValorDescontoCondicionado(issqnValorDescontoCondicionado);
        entity.setIssqnValorRetencao(issqnValorRetencao);
        entity.setIssqnIndicadorExigibilidade(issqnIndicadorExigibilidade);
        entity.setIssqnCodigoServico(issqnCodigoServico);
        entity.setIssqnCodigoMunicipioIncidencia(issqnCodigoMunicipioIncidencia);
        entity.setIssqnCodigoPais(issqnCodigoPais);
        entity.setIssqnNumeroProcesso(issqnNumeroProcesso);
        entity.setIssqnIndicadorIncentivo(issqnIndicadorIncentivo);
        entity.setIcmsOrigem(icmsOrigem);
        entity.setIcmsSituacaoTributaria(icmsSituacaoTributaria);
        entity.setIcmsMmodalidadeBaseCalculo(icmsMmodalidadeBaseCalculo);
        entity.setIcmsBaseCalculo(icmsBaseCalculo);
        entity.setIcmsBaseCalculoRetidoSt(icmsBaseCalculoRetidoSt);
        entity.setIcmsReducaoBaseCalculo(icmsReducaoBaseCalculo);
        entity.setIcmsAliquota(icmsAliquota);
        entity.setIcmsAliquotaFinal(icmsAliquotaFinal);
        entity.setIcmsValor(icmsValor);
        entity.setIcmsValorRetidoSt(icmsValorRetidoSt);
        entity.setIcmsValorDesonerado(icmsValorDesonerado);
        entity.setIcmsValorOperacao(icmsValorOperacao);
        entity.setIcmsPercentualDiferimento(icmsPercentualDiferimento);
        entity.setIcmsValorDiferido(icmsValorDiferido);
        entity.setIcmsMotivoDesoneracao(icmsMotivoDesoneracao);
        entity.setIcmsModalidadeBaseCalculoSt(icmsModalidadeBaseCalculoSt);
        entity.setIcmsMargemValorAdicionadoSt(icmsMargemValorAdicionadoSt);
        entity.setIcmsReducaoBaseCalculoSt(icmsReducaoBaseCalculoSt);
        entity.setIcmsBaseCalculoSt(icmsBaseCalculoSt);
        entity.setIcmsAliquotaSt(icmsAliquotaSt);
        entity.setIcmsValorSt(icmsValorSt);
        entity.setIcmsAliquotaCreditoSimples(icmsAliquotaCreditoSimples);
        entity.setIcmsValorCreditoSimples(icmsValorCreditoSimples);
        entity.setFcpPercentual(fcpPercentual);
        entity.setFcpBaseCalculo(fcpBaseCalculo);
        entity.setFcpValor(fcpValor);
        entity.setFcpPercentualSt(fcpPercentualSt);
        entity.setFcpBaseCalculoSt(fcpBaseCalculoSt);
        entity.setFcpValorSt(fcpValorSt);
        entity.setFcpPercentualRetidoSt(fcpPercentualRetidoSt);
        entity.setFcpBaseCalculoRetidoSt(fcpBaseCalculoRetidoSt);
        entity.setFcpValorRetidoSt(fcpValorRetidoSt);
        entity.setIpiSituacaoTributaria(ipiSituacaoTributaria);
        entity.setIpiBaseCalculo(ipiBaseCalculo);
        entity.setIpiAliquota(ipiAliquota);
        entity.setIpiQuantidadeTotal(ipiQuantidadeTotal);
        entity.setIpiValorPorUnidadeTributavel(ipiValorPorUnidadeTributavel);
        entity.setIpiValor(ipiValor);
        entity.setIpiClasseEnquadramento(ipiClasseEnquadramento);
        entity.setIpiCnpjProdutor(ipiCnpjProdutor);
        entity.setIpiCodigoSeloControle(ipiCodigoSeloControle);
        entity.setIpiQuantidadeSeloControle(ipiQuantidadeSeloControle);
        entity.setIpiCodigoEnquadramentoLegal(ipiCodigoEnquadramentoLegal);
        entity.setIiBaseCalculo(iiBaseCalculo);
        entity.setIiDespesasAduaneiras(iiDespesasAduaneiras);
        entity.setIiValor(iiValor);
        entity.setIiValorIof(iiValorIof);
        entity.setPisSituacaoTributaria(pisSituacaoTributaria);
        entity.setPisBaseCalculo(pisBaseCalculo);
        entity.setPisAliquotaPorcentual(pisAliquotaPorcentual);
        entity.setPisQuantidadeVendida(pisQuantidadeVendida);
        entity.setPisAliquotaValor(pisAliquotaValor);
        entity.setPisValor(pisValor);
        entity.setPisBaseCalculoSt(pisBaseCalculoSt);
        entity.setPisAliquotaPorcentualSt(pisAliquotaPorcentualSt);
        entity.setPisQuantidadeVendidaSt(pisQuantidadeVendidaSt);
        entity.setPisAliquotaValorSt(pisAliquotaValorSt);
        entity.setPisValorSt(pisValorSt);
        entity.setCofinsSituacaoTributaria(cofinsSituacaoTributaria);
        entity.setCofinsBaseCalculo(cofinsBaseCalculo);
        entity.setCofinsAliquotaPorcentual(cofinsAliquotaPorcentual);
        entity.setCofinsQuantidadeVendida(cofinsQuantidadeVendida);
        entity.setCofinsAliquotaValor(cofinsAliquotaValor);
        entity.setCofinsValor(cofinsValor);
        entity.setCofinsBaseCalculoSt(cofinsBaseCalculoSt);
        entity.setCofinsAliquotaPorcentualSt(cofinsAliquotaPorcentualSt);
        entity.setCofinsQuantidadeVendidaSt(cofinsQuantidadeVendidaSt);
        entity.setCofinsAliquotaValorSt(cofinsAliquotaValorSt);
        entity.setCofinsValorSt(cofinsValorSt);
        entity.setIcmsBaseCalculoUfDestino(icmsBaseCalculoUfDestino);
        entity.setFcpBaseCalculoUfDestino(fcpBaseCalculoUfDestino);
        entity.setFcpPercentualUfDestino(fcpPercentualUfDestino);
        entity.setIcmsAliquotaInternaUfDestino(icmsAliquotaInternaUfDestino);
        entity.setIcmsAliquotaInterestadual(icmsAliquotaInterestadual);
        entity.setIcmsPercentualPartilha(icmsPercentualPartilha);
        entity.setFcpValorUfDestino(fcpValorUfDestino);
        entity.setIcmsValorUfDestino(icmsValorUfDestino);
        entity.setIcmsValorUfRemetente(icmsValorUfRemetente);
        entity.setPercentualDevolvido(percentualDevolvido);
        entity.setValorIpiDevolvido(valorIpiDevolvido);
        entity.setInformacoesAdicionaisItem(informacoesAdicionaisItem);

        assertNotNull(entity);
        assertEquals(numeroItem, entity.getNumeroItem());
        assertEquals(codigoProduto, entity.getCodigoProduto());
        assertEquals(codigoBarrasComercial, entity.getCodigoBarrasComercial());
        assertEquals(descricao, entity.getDescricao());
        assertEquals(codigoNcm, entity.getCodigoNcm());
        assertEquals(nves, entity.getNves());
        assertEquals(cest, entity.getCest());
        assertEquals(escalaRelevante, entity.getEscalaRelevante());
        assertEquals(cnpjFabricante, entity.getCnpjFabricante());
        assertEquals(codigoBeneficioFiscalUf, entity.getCodigoBeneficioFiscalUf());
        assertEquals(codigoExTipi, entity.getCodigoExTipi());
        assertEquals(cfop, entity.getCfop());
        assertEquals(unidadeComercial, entity.getUnidadeComercial());
        assertEquals(quantidadeComercial, entity.getQuantidadeComercial());
        assertEquals(valorUnitarioComercial, entity.getValorUnitarioComercial());
        assertEquals(valorBruto, entity.getValorBruto());
        assertEquals(codigoBarrasTributavel, entity.getCodigoBarrasTributavel());
        assertEquals(unidadeTributavel, entity.getUnidadeTributavel());
        assertEquals(quantidadeTributavel, entity.getQuantidadeTributavel());
        assertEquals(valorUnitarioTributavel, entity.getValorUnitarioTributavel());
        assertEquals(valorFrete, entity.getValorFrete());
        assertEquals(valorSeguro, entity.getValorSeguro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(valorOutrasDespesas, entity.getValorOutrasDespesas());
        assertEquals(incluiNoTotal, entity.getIncluiNoTotal());
        assertEquals(documentosImportacao, entity.getDocumentosImportacao());
        assertEquals(detalhesExportacao, entity.getDetalhesExportacao());
        assertEquals(pedidoCompra, entity.getPedidoCompra());
        assertEquals(numeroItemPedidoCompra, entity.getNumeroItemPedidoCompra());
        assertEquals(numeroFci, entity.getNumeroFci());
        assertEquals(rastros, entity.getRastros());
        assertEquals(veiculoTipoOperacao, entity.getVeiculoTipoOperacao());
        assertEquals(veiculoChassi, entity.getVeiculoChassi());
        assertEquals(veiculoCodigoCor, entity.getVeiculoCodigoCor());
        assertEquals(veiculoDescricaoCor, entity.getVeiculoDescricaoCor());
        assertEquals(veiculoPotenciaMotor, entity.getVeiculoPotenciaMotor());
        assertEquals(veiculoCm3, entity.getVeiculoCm3());
        assertEquals(veiculoPesoLiquido, entity.getVeiculoPesoLiquido());
        assertEquals(veiculoPesoBruto, entity.getVeiculoPesoBruto());
        assertEquals(veiculoSerie, entity.getVeiculoSerie());
        assertEquals(veiculoTipoCombustivel, entity.getVeiculoTipoCombustivel());
        assertEquals(veiculoNumeroMotor, entity.getVeiculoNumeroMotor());
        assertEquals(veiculoCmt, entity.getVeiculoCmt());
        assertEquals(veiculoDistanciaEixos, entity.getVeiculoDistanciaEixos());
        assertEquals(veiculoAnoModelo, entity.getVeiculoAnoModelo());
        assertEquals(veiculoAnoFabricacao, entity.getVeiculoAnoFabricacao());
        assertEquals(veiculoTipoPintura, entity.getVeiculoTipoPintura());
        assertEquals(veiculoTipo, entity.getVeiculoTipo());
        assertEquals(veiculoEspecie, entity.getVeiculoEspecie());
        assertEquals(veiculoCodigoVin, entity.getVeiculoCodigoVin());
        assertEquals(veiculoCondicao, entity.getVeiculoCondicao());
        assertEquals(veiculoCodigoMarcaModelo, entity.getVeiculoCodigoMarcaModelo());
        assertEquals(veiculoCodigoCorDenatran, entity.getVeiculoCodigoCorDenatran());
        assertEquals(veiculoLotacao, entity.getVeiculoLotacao());
        assertEquals(veiculoRestricao, entity.getVeiculoRestricao());
        assertEquals(medicamentoCodigoAnvisa, entity.getMedicamentoCodigoAnvisa());
        assertEquals(medicamentoPrecoMaximoConsumidor, entity.getMedicamentoPrecoMaximoConsumidor());
        assertEquals(combustivelCodigoAnp, entity.getCombustivelCodigoAnp());
        assertEquals(combustivelDescricaoAnp, entity.getCombustivelDescricaoAnp());
        assertEquals(combustivelPercentualGlp, entity.getCombustivelPercentualGlp());
        assertEquals(combustivelPercentualGasNaturalNacional, entity.getCombustivelPercentualGasNaturalNacional());
        assertEquals(combustivelPercentualGasNaturalImportado, entity.getCombustivelPercentualGasNaturalImportado());
        assertEquals(combustivelValorPartida, entity.getCombustivelValorPartida());
        assertEquals(combustivelRegistroCodif, entity.getCombustivelRegistroCodif());
        assertEquals(combustivelQuantidadeTemperaturaAmbiente, entity.getCombustivelQuantidadeTemperaturaAmbiente());
        assertEquals(combustivelSiglaUf, entity.getCombustivelSiglaUf());
        assertEquals(combustivelCideBaseCalculo, entity.getCombustivelCideBaseCalculo());
        assertEquals(combustivelCideAliquota, entity.getCombustivelCideAliquota());
        assertEquals(combustivelCideValor, entity.getCombustivelCideValor());
        assertEquals(valorTotalTributos, entity.getValorTotalTributos());
        assertEquals(issqnBaseCalculo, entity.getIssqnBaseCalculo());
        assertEquals(issqnAliquota, entity.getIssqnAliquota());
        assertEquals(issqnValor, entity.getIssqnValor());
        assertEquals(issqnCodigoMunicipio, entity.getIssqnCodigoMunicipio());
        assertEquals(issqnItemListaServico, entity.getIssqnItemListaServico());
        assertEquals(issqnValorDeducao, entity.getIssqnValorDeducao());
        assertEquals(issqnValorOutrasRetencoes, entity.getIssqnValorOutrasRetencoes());
        assertEquals(issqnValorDescontoIncondicionado, entity.getIssqnValorDescontoIncondicionado());
        assertEquals(issqnValorDescontoCondicionado, entity.getIssqnValorDescontoCondicionado());
        assertEquals(issqnValorRetencao, entity.getIssqnValorRetencao());
        assertEquals(issqnIndicadorExigibilidade, entity.getIssqnIndicadorExigibilidade());
        assertEquals(issqnCodigoServico, entity.getIssqnCodigoServico());
        assertEquals(issqnCodigoMunicipioIncidencia, entity.getIssqnCodigoMunicipioIncidencia());
        assertEquals(issqnCodigoPais, entity.getIssqnCodigoPais());
        assertEquals(issqnNumeroProcesso, entity.getIssqnNumeroProcesso());
        assertEquals(issqnIndicadorIncentivo, entity.getIssqnIndicadorIncentivo());
        assertEquals(icmsOrigem, entity.getIcmsOrigem());
        assertEquals(icmsSituacaoTributaria, entity.getIcmsSituacaoTributaria());
        assertEquals(icmsMmodalidadeBaseCalculo, entity.getIcmsMmodalidadeBaseCalculo());
        assertEquals(icmsBaseCalculo, entity.getIcmsBaseCalculo());
        assertEquals(icmsBaseCalculoRetidoSt, entity.getIcmsBaseCalculoRetidoSt());
        assertEquals(icmsReducaoBaseCalculo, entity.getIcmsReducaoBaseCalculo());
        assertEquals(icmsAliquota, entity.getIcmsAliquota());
        assertEquals(icmsAliquotaFinal, entity.getIcmsAliquotaFinal());
        assertEquals(icmsValor, entity.getIcmsValor());
        assertEquals(icmsValorRetidoSt, entity.getIcmsValorRetidoSt());
        assertEquals(icmsValorDesonerado, entity.getIcmsValorDesonerado());
        assertEquals(icmsValorOperacao, entity.getIcmsValorOperacao());
        assertEquals(icmsPercentualDiferimento, entity.getIcmsPercentualDiferimento());
        assertEquals(icmsValorDiferido, entity.getIcmsValorDiferido());
        assertEquals(icmsMotivoDesoneracao, entity.getIcmsMotivoDesoneracao());
        assertEquals(icmsModalidadeBaseCalculoSt, entity.getIcmsModalidadeBaseCalculoSt());
        assertEquals(icmsMargemValorAdicionadoSt, entity.getIcmsMargemValorAdicionadoSt());
        assertEquals(icmsReducaoBaseCalculoSt, entity.getIcmsReducaoBaseCalculoSt());
        assertEquals(icmsBaseCalculoSt, entity.getIcmsBaseCalculoSt());
        assertEquals(icmsAliquotaSt, entity.getIcmsAliquotaSt());
        assertEquals(icmsValorSt, entity.getIcmsValorSt());
        assertEquals(icmsAliquotaCreditoSimples, entity.getIcmsAliquotaCreditoSimples());
        assertEquals(icmsValorCreditoSimples, entity.getIcmsValorCreditoSimples());
        assertEquals(fcpPercentual, entity.getFcpPercentual());
        assertEquals(fcpBaseCalculo, entity.getFcpBaseCalculo());
        assertEquals(fcpValor, entity.getFcpValor());
        assertEquals(fcpPercentualSt, entity.getFcpPercentualSt());
        assertEquals(fcpBaseCalculoSt, entity.getFcpBaseCalculoSt());
        assertEquals(fcpValorSt, entity.getFcpValorSt());
        assertEquals(fcpPercentualRetidoSt, entity.getFcpPercentualRetidoSt());
        assertEquals(fcpBaseCalculoRetidoSt, entity.getFcpBaseCalculoRetidoSt());
        assertEquals(fcpValorRetidoSt, entity.getFcpValorRetidoSt());
        assertEquals(ipiSituacaoTributaria, entity.getIpiSituacaoTributaria());
        assertEquals(ipiBaseCalculo, entity.getIpiBaseCalculo());
        assertEquals(ipiAliquota, entity.getIpiAliquota());
        assertEquals(ipiQuantidadeTotal, entity.getIpiQuantidadeTotal());
        assertEquals(ipiValorPorUnidadeTributavel, entity.getIpiValorPorUnidadeTributavel());
        assertEquals(ipiValor, entity.getIpiValor());
        assertEquals(ipiClasseEnquadramento, entity.getIpiClasseEnquadramento());
        assertEquals(ipiCnpjProdutor, entity.getIpiCnpjProdutor());
        assertEquals(ipiCodigoSeloControle, entity.getIpiCodigoSeloControle());
        assertEquals(ipiQuantidadeSeloControle, entity.getIpiQuantidadeSeloControle());
        assertEquals(ipiCodigoEnquadramentoLegal, entity.getIpiCodigoEnquadramentoLegal());
        assertEquals(iiBaseCalculo, entity.getIiBaseCalculo());
        assertEquals(iiDespesasAduaneiras, entity.getIiDespesasAduaneiras());
        assertEquals(iiValor, entity.getIiValor());
        assertEquals(iiValorIof, entity.getIiValorIof());
        assertEquals(pisSituacaoTributaria, entity.getPisSituacaoTributaria());
        assertEquals(pisBaseCalculo, entity.getPisBaseCalculo());
        assertEquals(pisAliquotaPorcentual, entity.getPisAliquotaPorcentual());
        assertEquals(pisQuantidadeVendida, entity.getPisQuantidadeVendida());
        assertEquals(pisAliquotaValor, entity.getPisAliquotaValor());
        assertEquals(pisValor, entity.getPisValor());
        assertEquals(pisBaseCalculoSt, entity.getPisBaseCalculoSt());
        assertEquals(pisAliquotaPorcentualSt, entity.getPisAliquotaPorcentualSt());
        assertEquals(pisQuantidadeVendidaSt, entity.getPisQuantidadeVendidaSt());
        assertEquals(pisAliquotaValorSt, entity.getPisAliquotaValorSt());
        assertEquals(pisValorSt, entity.getPisValorSt());
        assertEquals(cofinsSituacaoTributaria, entity.getCofinsSituacaoTributaria());
        assertEquals(cofinsBaseCalculo, entity.getCofinsBaseCalculo());
        assertEquals(cofinsAliquotaPorcentual, entity.getCofinsAliquotaPorcentual());
        assertEquals(cofinsQuantidadeVendida, entity.getCofinsQuantidadeVendida());
        assertEquals(cofinsAliquotaValor, entity.getCofinsAliquotaValor());
        assertEquals(cofinsValor, entity.getCofinsValor());
        assertEquals(cofinsBaseCalculoSt, entity.getCofinsBaseCalculoSt());
        assertEquals(cofinsAliquotaPorcentualSt, entity.getCofinsAliquotaPorcentualSt());
        assertEquals(cofinsQuantidadeVendidaSt, entity.getCofinsQuantidadeVendidaSt());
        assertEquals(cofinsAliquotaValorSt, entity.getCofinsAliquotaValorSt());
        assertEquals(cofinsValorSt, entity.getCofinsValorSt());
        assertEquals(icmsBaseCalculoUfDestino, entity.getIcmsBaseCalculoUfDestino());
        assertEquals(fcpBaseCalculoUfDestino, entity.getFcpBaseCalculoUfDestino());
        assertEquals(fcpPercentualUfDestino, entity.getFcpPercentualUfDestino());
        assertEquals(icmsAliquotaInternaUfDestino, entity.getIcmsAliquotaInternaUfDestino());
        assertEquals(icmsAliquotaInterestadual, entity.getIcmsAliquotaInterestadual());
        assertEquals(icmsPercentualPartilha, entity.getIcmsPercentualPartilha());
        assertEquals(fcpValorUfDestino, entity.getFcpValorUfDestino());
        assertEquals(icmsValorUfDestino, entity.getIcmsValorUfDestino());
        assertEquals(icmsValorUfRemetente, entity.getIcmsValorUfRemetente());
        assertEquals(percentualDevolvido, entity.getPercentualDevolvido());
        assertEquals(valorIpiDevolvido, entity.getValorIpiDevolvido());
        assertEquals(informacoesAdicionaisItem, entity.getInformacoesAdicionaisItem());

        entity = NFeItem.newBuilder()
            .withNumeroItem(numeroItem)
            .withCodigoProduto(codigoProduto)
            .withCodigoBarrasComercial(codigoBarrasComercial)
            .withDescricao(descricao)
            .withCodigoNcm(codigoNcm)
            .withNves(nves)
            .withCest(cest)
            .withEscalaRelevante(escalaRelevante)
            .withCnpjFabricante(cnpjFabricante)
            .withCodigoBeneficioFiscalUf(codigoBeneficioFiscalUf)
            .withCodigoExTipi(codigoExTipi)
            .withCfop(cfop)
            .withUnidadeComercial(unidadeComercial)
            .withQuantidadeComercial(quantidadeComercial)
            .withValorUnitarioComercial(valorUnitarioComercial)
            .withValorBruto(valorBruto)
            .withCodigoBarrasTributavel(codigoBarrasTributavel)
            .withUnidadeTributavel(unidadeTributavel)
            .withQuantidadeTributavel(quantidadeTributavel)
            .withValorUnitarioTributavel(valorUnitarioTributavel)
            .withValorFrete(valorFrete)
            .withValorSeguro(valorSeguro)
            .withValorDesconto(valorDesconto)
            .withValorOutrasDespesas(valorOutrasDespesas)
            .withIncluiNoTotal(incluiNoTotal)
            .withDocumentosImportacao(documentosImportacao)
            .withDetalhesExportacao(detalhesExportacao)
            .withPedidoCompra(pedidoCompra)
            .withNumeroItemPedidoCompra(numeroItemPedidoCompra)
            .withNumeroFci(numeroFci)
            .withRastros(rastros)
            .withVeiculoTipoOperacao(veiculoTipoOperacao)
            .withVeiculoChassi(veiculoChassi)
            .withVeiculoCodigoCor(veiculoCodigoCor)
            .withVeiculoDescricaoCor(veiculoDescricaoCor)
            .withVeiculoPotenciaMotor(veiculoPotenciaMotor)
            .withVeiculoCm3(veiculoCm3)
            .withVeiculoPesoLiquido(veiculoPesoLiquido)
            .withVeiculoPesoBruto(veiculoPesoBruto)
            .withVeiculoSerie(veiculoSerie)
            .withVeiculoTipoCombustivel(veiculoTipoCombustivel)
            .withVeiculoNumeroMotor(veiculoNumeroMotor)
            .withVeiculoCmt(veiculoCmt)
            .withVeiculoDistanciaEixos(veiculoDistanciaEixos)
            .withVeiculoAnoModelo(veiculoAnoModelo)
            .withVeiculoAnoFabricacao(veiculoAnoFabricacao)
            .withVeiculoTipoPintura(veiculoTipoPintura)
            .withVeiculoTipo(veiculoTipo)
            .withVeiculoEspecie(veiculoEspecie)
            .withVeiculoCodigoVin(veiculoCodigoVin)
            .withVeiculoCondicao(veiculoCondicao)
            .withVeiculoCodigoMarcaModelo(veiculoCodigoMarcaModelo)
            .withVeiculoCodigoCorDenatran(veiculoCodigoCorDenatran)
            .withVeiculoLotacao(veiculoLotacao)
            .withVeiculoRestricao(veiculoRestricao)
            .withMedicamentoCodigoAnvisa(medicamentoCodigoAnvisa)
            .withMedicamentoPrecoMaximoConsumidor(medicamentoPrecoMaximoConsumidor)
            .withCombustivelCodigoAnp(combustivelCodigoAnp)
            .withCombustivelDescricaoAnp(combustivelDescricaoAnp)
            .withCombustivelPercentualGlp(combustivelPercentualGlp)
            .withCombustivelPercentualGasNaturalNacional(combustivelPercentualGasNaturalNacional)
            .withCombustivelPercentualGasNaturalImportado(combustivelPercentualGasNaturalImportado)
            .withCombustivelValorPartida(combustivelValorPartida)
            .withCombustivelRegistroCodif(combustivelRegistroCodif)
            .withCombustivelQuantidadeTemperaturaAmbiente(combustivelQuantidadeTemperaturaAmbiente)
            .withCombustivelSiglaUf(combustivelSiglaUf)
            .withCombustivelCideBaseCalculo(combustivelCideBaseCalculo)
            .withCombustivelCideAliquota(combustivelCideAliquota)
            .withCombustivelCideValor(combustivelCideValor)
            .withValorTotalTributos(valorTotalTributos)
            .withIssqnBaseCalculo(issqnBaseCalculo)
            .withIssqnAliquota(issqnAliquota)
            .withIssqnValor(issqnValor)
            .withIssqnCodigoMunicipio(issqnCodigoMunicipio)
            .withIssqnItemListaServico(issqnItemListaServico)
            .withIssqnValorDeducao(issqnValorDeducao)
            .withIssqnValorOutrasRetencoes(issqnValorOutrasRetencoes)
            .withIssqnValorDescontoIncondicionado(issqnValorDescontoIncondicionado)
            .withIssqnValorDescontoCondicionado(issqnValorDescontoCondicionado)
            .withIssqnValorRetencao(issqnValorRetencao)
            .withIssqnIndicadorExigibilidade(issqnIndicadorExigibilidade)
            .withIssqnCodigoServico(issqnCodigoServico)
            .withIssqnCodigoMunicipioIncidencia(issqnCodigoMunicipioIncidencia)
            .withIssqnCodigoPais(issqnCodigoPais)
            .withIssqnNumeroProcesso(issqnNumeroProcesso)
            .withIssqnIndicadorIncentivo(issqnIndicadorIncentivo)
            .withIcmsOrigem(icmsOrigem)
            .withIcmsSituacaoTributaria(icmsSituacaoTributaria)
            .withIcmsMmodalidadeBaseCalculo(icmsMmodalidadeBaseCalculo)
            .withIcmsBaseCalculo(icmsBaseCalculo)
            .withIcmsBaseCalculoRetidoSt(icmsBaseCalculoRetidoSt)
            .withIcmsReducaoBaseCalculo(icmsReducaoBaseCalculo)
            .withIcmsAliquota(icmsAliquota)
            .withIcmsAliquotaFinal(icmsAliquotaFinal)
            .withIcmsValor(icmsValor)
            .withIcmsValorRetidoSt(icmsValorRetidoSt)
            .withIcmsValorDesonerado(icmsValorDesonerado)
            .withIcmsValorOperacao(icmsValorOperacao)
            .withIcmsPercentualDiferimento(icmsPercentualDiferimento)
            .withIcmsValorDiferido(icmsValorDiferido)
            .withIcmsMotivoDesoneracao(icmsMotivoDesoneracao)
            .withIcmsModalidadeBaseCalculoSt(icmsModalidadeBaseCalculoSt)
            .withIcmsMargemValorAdicionadoSt(icmsMargemValorAdicionadoSt)
            .withIcmsReducaoBaseCalculoSt(icmsReducaoBaseCalculoSt)
            .withIcmsBaseCalculoSt(icmsBaseCalculoSt)
            .withIcmsAliquotaSt(icmsAliquotaSt)
            .withIcmsValorSt(icmsValorSt)
            .withIcmsAliquotaCreditoSimples(icmsAliquotaCreditoSimples)
            .withIcmsValorCreditoSimples(icmsValorCreditoSimples)
            .withFcpPercentual(fcpPercentual)
            .withFcpBaseCalculo(fcpBaseCalculo)
            .withFcpValor(fcpValor)
            .withFcpPercentualSt(fcpPercentualSt)
            .withFcpBaseCalculoSt(fcpBaseCalculoSt)
            .withFcpValorSt(fcpValorSt)
            .withFcpPercentualRetidoSt(fcpPercentualRetidoSt)
            .withFcpBaseCalculoRetidoSt(fcpBaseCalculoRetidoSt)
            .withFcpValorRetidoSt(fcpValorRetidoSt)
            .withIpiSituacaoTributaria(ipiSituacaoTributaria)
            .withIpiBaseCalculo(ipiBaseCalculo)
            .withIpiAliquota(ipiAliquota)
            .withIpiQuantidadeTotal(ipiQuantidadeTotal)
            .withIpiValorPorUnidadeTributavel(ipiValorPorUnidadeTributavel)
            .withIpiValor(ipiValor)
            .withIpiClasseEnquadramento(ipiClasseEnquadramento)
            .withIpiCnpjProdutor(ipiCnpjProdutor)
            .withIpiCodigoSeloControle(ipiCodigoSeloControle)
            .withIpiQuantidadeSeloControle(ipiQuantidadeSeloControle)
            .withIpiCodigoEnquadramentoLegal(ipiCodigoEnquadramentoLegal)
            .withIiBaseCalculo(iiBaseCalculo)
            .withIiDespesasAduaneiras(iiDespesasAduaneiras)
            .withIiValor(iiValor)
            .withIiValorIof(iiValorIof)
            .withPisSituacaoTributaria(pisSituacaoTributaria)
            .withPisBaseCalculo(pisBaseCalculo)
            .withPisAliquotaPorcentual(pisAliquotaPorcentual)
            .withPisQuantidadeVendida(pisQuantidadeVendida)
            .withPisAliquotaValor(pisAliquotaValor)
            .withPisValor(pisValor)
            .withPisBaseCalculoSt(pisBaseCalculoSt)
            .withPisAliquotaPorcentualSt(pisAliquotaPorcentualSt)
            .withPisQuantidadeVendidaSt(pisQuantidadeVendidaSt)
            .withPisAliquotaValorSt(pisAliquotaValorSt)
            .withPisValorSt(pisValorSt)
            .withCofinsSituacaoTributaria(cofinsSituacaoTributaria)
            .withCofinsBaseCalculo(cofinsBaseCalculo)
            .withCofinsAliquotaPorcentual(cofinsAliquotaPorcentual)
            .withCofinsQuantidadeVendida(cofinsQuantidadeVendida)
            .withCofinsAliquotaValor(cofinsAliquotaValor)
            .withCofinsValor(cofinsValor)
            .withCofinsBaseCalculoSt(cofinsBaseCalculoSt)
            .withCofinsAliquotaPorcentualSt(cofinsAliquotaPorcentualSt)
            .withCofinsQuantidadeVendidaSt(cofinsQuantidadeVendidaSt)
            .withCofinsAliquotaValorSt(cofinsAliquotaValorSt)
            .withCofinsValorSt(cofinsValorSt)
            .withIcmsBaseCalculoUfDestino(icmsBaseCalculoUfDestino)
            .withFcpBaseCalculoUfDestino(fcpBaseCalculoUfDestino)
            .withFcpPercentualUfDestino(fcpPercentualUfDestino)
            .withIcmsAliquotaInternaUfDestino(icmsAliquotaInternaUfDestino)
            .withIcmsAliquotaInterestadual(icmsAliquotaInterestadual)
            .withIcmsPercentualPartilha(icmsPercentualPartilha)
            .withFcpValorUfDestino(fcpValorUfDestino)
            .withIcmsValorUfDestino(icmsValorUfDestino)
            .withIcmsValorUfRemetente(icmsValorUfRemetente)
            .withPercentualDevolvido(percentualDevolvido)
            .withValorIpiDevolvido(valorIpiDevolvido)
            .withInformacoesAdicionaisItem(informacoesAdicionaisItem)
            .build();

        assertNotNull(entity);
        assertEquals(numeroItem, entity.getNumeroItem());
        assertEquals(codigoProduto, entity.getCodigoProduto());
        assertEquals(codigoBarrasComercial, entity.getCodigoBarrasComercial());
        assertEquals(descricao, entity.getDescricao());
        assertEquals(codigoNcm, entity.getCodigoNcm());
        assertEquals(nves, entity.getNves());
        assertEquals(cest, entity.getCest());
        assertEquals(escalaRelevante, entity.getEscalaRelevante());
        assertEquals(cnpjFabricante, entity.getCnpjFabricante());
        assertEquals(codigoBeneficioFiscalUf, entity.getCodigoBeneficioFiscalUf());
        assertEquals(codigoExTipi, entity.getCodigoExTipi());
        assertEquals(cfop, entity.getCfop());
        assertEquals(unidadeComercial, entity.getUnidadeComercial());
        assertEquals(quantidadeComercial, entity.getQuantidadeComercial());
        assertEquals(valorUnitarioComercial, entity.getValorUnitarioComercial());
        assertEquals(valorBruto, entity.getValorBruto());
        assertEquals(codigoBarrasTributavel, entity.getCodigoBarrasTributavel());
        assertEquals(unidadeTributavel, entity.getUnidadeTributavel());
        assertEquals(quantidadeTributavel, entity.getQuantidadeTributavel());
        assertEquals(valorUnitarioTributavel, entity.getValorUnitarioTributavel());
        assertEquals(valorFrete, entity.getValorFrete());
        assertEquals(valorSeguro, entity.getValorSeguro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(valorOutrasDespesas, entity.getValorOutrasDespesas());
        assertEquals(incluiNoTotal, entity.getIncluiNoTotal());
        assertEquals(documentosImportacao, entity.getDocumentosImportacao());
        assertEquals(detalhesExportacao, entity.getDetalhesExportacao());
        assertEquals(pedidoCompra, entity.getPedidoCompra());
        assertEquals(numeroItemPedidoCompra, entity.getNumeroItemPedidoCompra());
        assertEquals(numeroFci, entity.getNumeroFci());
        assertEquals(rastros, entity.getRastros());
        assertEquals(veiculoTipoOperacao, entity.getVeiculoTipoOperacao());
        assertEquals(veiculoChassi, entity.getVeiculoChassi());
        assertEquals(veiculoCodigoCor, entity.getVeiculoCodigoCor());
        assertEquals(veiculoDescricaoCor, entity.getVeiculoDescricaoCor());
        assertEquals(veiculoPotenciaMotor, entity.getVeiculoPotenciaMotor());
        assertEquals(veiculoCm3, entity.getVeiculoCm3());
        assertEquals(veiculoPesoLiquido, entity.getVeiculoPesoLiquido());
        assertEquals(veiculoPesoBruto, entity.getVeiculoPesoBruto());
        assertEquals(veiculoSerie, entity.getVeiculoSerie());
        assertEquals(veiculoTipoCombustivel, entity.getVeiculoTipoCombustivel());
        assertEquals(veiculoNumeroMotor, entity.getVeiculoNumeroMotor());
        assertEquals(veiculoCmt, entity.getVeiculoCmt());
        assertEquals(veiculoDistanciaEixos, entity.getVeiculoDistanciaEixos());
        assertEquals(veiculoAnoModelo, entity.getVeiculoAnoModelo());
        assertEquals(veiculoAnoFabricacao, entity.getVeiculoAnoFabricacao());
        assertEquals(veiculoTipoPintura, entity.getVeiculoTipoPintura());
        assertEquals(veiculoTipo, entity.getVeiculoTipo());
        assertEquals(veiculoEspecie, entity.getVeiculoEspecie());
        assertEquals(veiculoCodigoVin, entity.getVeiculoCodigoVin());
        assertEquals(veiculoCondicao, entity.getVeiculoCondicao());
        assertEquals(veiculoCodigoMarcaModelo, entity.getVeiculoCodigoMarcaModelo());
        assertEquals(veiculoCodigoCorDenatran, entity.getVeiculoCodigoCorDenatran());
        assertEquals(veiculoLotacao, entity.getVeiculoLotacao());
        assertEquals(veiculoRestricao, entity.getVeiculoRestricao());
        assertEquals(medicamentoCodigoAnvisa, entity.getMedicamentoCodigoAnvisa());
        assertEquals(medicamentoPrecoMaximoConsumidor, entity.getMedicamentoPrecoMaximoConsumidor());
        assertEquals(combustivelCodigoAnp, entity.getCombustivelCodigoAnp());
        assertEquals(combustivelDescricaoAnp, entity.getCombustivelDescricaoAnp());
        assertEquals(combustivelPercentualGlp, entity.getCombustivelPercentualGlp());
        assertEquals(combustivelPercentualGasNaturalNacional, entity.getCombustivelPercentualGasNaturalNacional());
        assertEquals(combustivelPercentualGasNaturalImportado, entity.getCombustivelPercentualGasNaturalImportado());
        assertEquals(combustivelValorPartida, entity.getCombustivelValorPartida());
        assertEquals(combustivelRegistroCodif, entity.getCombustivelRegistroCodif());
        assertEquals(combustivelQuantidadeTemperaturaAmbiente, entity.getCombustivelQuantidadeTemperaturaAmbiente());
        assertEquals(combustivelSiglaUf, entity.getCombustivelSiglaUf());
        assertEquals(combustivelCideBaseCalculo, entity.getCombustivelCideBaseCalculo());
        assertEquals(combustivelCideAliquota, entity.getCombustivelCideAliquota());
        assertEquals(combustivelCideValor, entity.getCombustivelCideValor());
        assertEquals(valorTotalTributos, entity.getValorTotalTributos());
        assertEquals(issqnBaseCalculo, entity.getIssqnBaseCalculo());
        assertEquals(issqnAliquota, entity.getIssqnAliquota());
        assertEquals(issqnValor, entity.getIssqnValor());
        assertEquals(issqnCodigoMunicipio, entity.getIssqnCodigoMunicipio());
        assertEquals(issqnItemListaServico, entity.getIssqnItemListaServico());
        assertEquals(issqnValorDeducao, entity.getIssqnValorDeducao());
        assertEquals(issqnValorOutrasRetencoes, entity.getIssqnValorOutrasRetencoes());
        assertEquals(issqnValorDescontoIncondicionado, entity.getIssqnValorDescontoIncondicionado());
        assertEquals(issqnValorDescontoCondicionado, entity.getIssqnValorDescontoCondicionado());
        assertEquals(issqnValorRetencao, entity.getIssqnValorRetencao());
        assertEquals(issqnIndicadorExigibilidade, entity.getIssqnIndicadorExigibilidade());
        assertEquals(issqnCodigoServico, entity.getIssqnCodigoServico());
        assertEquals(issqnCodigoMunicipioIncidencia, entity.getIssqnCodigoMunicipioIncidencia());
        assertEquals(issqnCodigoPais, entity.getIssqnCodigoPais());
        assertEquals(issqnNumeroProcesso, entity.getIssqnNumeroProcesso());
        assertEquals(issqnIndicadorIncentivo, entity.getIssqnIndicadorIncentivo());
        assertEquals(icmsOrigem, entity.getIcmsOrigem());
        assertEquals(icmsSituacaoTributaria, entity.getIcmsSituacaoTributaria());
        assertEquals(icmsMmodalidadeBaseCalculo, entity.getIcmsMmodalidadeBaseCalculo());
        assertEquals(icmsBaseCalculo, entity.getIcmsBaseCalculo());
        assertEquals(icmsBaseCalculoRetidoSt, entity.getIcmsBaseCalculoRetidoSt());
        assertEquals(icmsReducaoBaseCalculo, entity.getIcmsReducaoBaseCalculo());
        assertEquals(icmsAliquota, entity.getIcmsAliquota());
        assertEquals(icmsAliquotaFinal, entity.getIcmsAliquotaFinal());
        assertEquals(icmsValor, entity.getIcmsValor());
        assertEquals(icmsValorRetidoSt, entity.getIcmsValorRetidoSt());
        assertEquals(icmsValorDesonerado, entity.getIcmsValorDesonerado());
        assertEquals(icmsValorOperacao, entity.getIcmsValorOperacao());
        assertEquals(icmsPercentualDiferimento, entity.getIcmsPercentualDiferimento());
        assertEquals(icmsValorDiferido, entity.getIcmsValorDiferido());
        assertEquals(icmsMotivoDesoneracao, entity.getIcmsMotivoDesoneracao());
        assertEquals(icmsModalidadeBaseCalculoSt, entity.getIcmsModalidadeBaseCalculoSt());
        assertEquals(icmsMargemValorAdicionadoSt, entity.getIcmsMargemValorAdicionadoSt());
        assertEquals(icmsReducaoBaseCalculoSt, entity.getIcmsReducaoBaseCalculoSt());
        assertEquals(icmsBaseCalculoSt, entity.getIcmsBaseCalculoSt());
        assertEquals(icmsAliquotaSt, entity.getIcmsAliquotaSt());
        assertEquals(icmsValorSt, entity.getIcmsValorSt());
        assertEquals(icmsAliquotaCreditoSimples, entity.getIcmsAliquotaCreditoSimples());
        assertEquals(icmsValorCreditoSimples, entity.getIcmsValorCreditoSimples());
        assertEquals(fcpPercentual, entity.getFcpPercentual());
        assertEquals(fcpBaseCalculo, entity.getFcpBaseCalculo());
        assertEquals(fcpValor, entity.getFcpValor());
        assertEquals(fcpPercentualSt, entity.getFcpPercentualSt());
        assertEquals(fcpBaseCalculoSt, entity.getFcpBaseCalculoSt());
        assertEquals(fcpValorSt, entity.getFcpValorSt());
        assertEquals(fcpPercentualRetidoSt, entity.getFcpPercentualRetidoSt());
        assertEquals(fcpBaseCalculoRetidoSt, entity.getFcpBaseCalculoRetidoSt());
        assertEquals(fcpValorRetidoSt, entity.getFcpValorRetidoSt());
        assertEquals(ipiSituacaoTributaria, entity.getIpiSituacaoTributaria());
        assertEquals(ipiBaseCalculo, entity.getIpiBaseCalculo());
        assertEquals(ipiAliquota, entity.getIpiAliquota());
        assertEquals(ipiQuantidadeTotal, entity.getIpiQuantidadeTotal());
        assertEquals(ipiValorPorUnidadeTributavel, entity.getIpiValorPorUnidadeTributavel());
        assertEquals(ipiValor, entity.getIpiValor());
        assertEquals(ipiClasseEnquadramento, entity.getIpiClasseEnquadramento());
        assertEquals(ipiCnpjProdutor, entity.getIpiCnpjProdutor());
        assertEquals(ipiCodigoSeloControle, entity.getIpiCodigoSeloControle());
        assertEquals(ipiQuantidadeSeloControle, entity.getIpiQuantidadeSeloControle());
        assertEquals(ipiCodigoEnquadramentoLegal, entity.getIpiCodigoEnquadramentoLegal());
        assertEquals(iiBaseCalculo, entity.getIiBaseCalculo());
        assertEquals(iiDespesasAduaneiras, entity.getIiDespesasAduaneiras());
        assertEquals(iiValor, entity.getIiValor());
        assertEquals(iiValorIof, entity.getIiValorIof());
        assertEquals(pisSituacaoTributaria, entity.getPisSituacaoTributaria());
        assertEquals(pisBaseCalculo, entity.getPisBaseCalculo());
        assertEquals(pisAliquotaPorcentual, entity.getPisAliquotaPorcentual());
        assertEquals(pisQuantidadeVendida, entity.getPisQuantidadeVendida());
        assertEquals(pisAliquotaValor, entity.getPisAliquotaValor());
        assertEquals(pisValor, entity.getPisValor());
        assertEquals(pisBaseCalculoSt, entity.getPisBaseCalculoSt());
        assertEquals(pisAliquotaPorcentualSt, entity.getPisAliquotaPorcentualSt());
        assertEquals(pisQuantidadeVendidaSt, entity.getPisQuantidadeVendidaSt());
        assertEquals(pisAliquotaValorSt, entity.getPisAliquotaValorSt());
        assertEquals(pisValorSt, entity.getPisValorSt());
        assertEquals(cofinsSituacaoTributaria, entity.getCofinsSituacaoTributaria());
        assertEquals(cofinsBaseCalculo, entity.getCofinsBaseCalculo());
        assertEquals(cofinsAliquotaPorcentual, entity.getCofinsAliquotaPorcentual());
        assertEquals(cofinsQuantidadeVendida, entity.getCofinsQuantidadeVendida());
        assertEquals(cofinsAliquotaValor, entity.getCofinsAliquotaValor());
        assertEquals(cofinsValor, entity.getCofinsValor());
        assertEquals(cofinsBaseCalculoSt, entity.getCofinsBaseCalculoSt());
        assertEquals(cofinsAliquotaPorcentualSt, entity.getCofinsAliquotaPorcentualSt());
        assertEquals(cofinsQuantidadeVendidaSt, entity.getCofinsQuantidadeVendidaSt());
        assertEquals(cofinsAliquotaValorSt, entity.getCofinsAliquotaValorSt());
        assertEquals(cofinsValorSt, entity.getCofinsValorSt());
        assertEquals(icmsBaseCalculoUfDestino, entity.getIcmsBaseCalculoUfDestino());
        assertEquals(fcpBaseCalculoUfDestino, entity.getFcpBaseCalculoUfDestino());
        assertEquals(fcpPercentualUfDestino, entity.getFcpPercentualUfDestino());
        assertEquals(icmsAliquotaInternaUfDestino, entity.getIcmsAliquotaInternaUfDestino());
        assertEquals(icmsAliquotaInterestadual, entity.getIcmsAliquotaInterestadual());
        assertEquals(icmsPercentualPartilha, entity.getIcmsPercentualPartilha());
        assertEquals(fcpValorUfDestino, entity.getFcpValorUfDestino());
        assertEquals(icmsValorUfDestino, entity.getIcmsValorUfDestino());
        assertEquals(icmsValorUfRemetente, entity.getIcmsValorUfRemetente());
        assertEquals(percentualDevolvido, entity.getPercentualDevolvido());
        assertEquals(valorIpiDevolvido, entity.getValorIpiDevolvido());
        assertEquals(informacoesAdicionaisItem, entity.getInformacoesAdicionaisItem());
    }

    @Test
    public void testBeanValidation() throws Exception {
        String numeroItem = "1";
        String codigoProduto = "849375948";
        String descricao = "bla bla bla bla bla bla";
        String codigoNcm = "40113000";
        String cfop = "5102";
        String unidadeComercial = "UN";
        BigDecimal quantidadeComercial = new BigDecimal("200.40");
        BigDecimal valorUnitarioComercial = new BigDecimal("200.40");
        NFeIcmsOrigemEnum icmsOrigem = NFeIcmsOrigemEnum.NACIONAL;
        NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria = NFeIcmsSituacaoTributariaEnum.ISENTA;
        NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria = NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_SAIDA;
        NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria = NFePisCofinsSituacaoTributariaEnum.OUTRAS_OPERACOES_DE_SAIDA;

        NFeItem entity = NFeItem.newBuilder()
            .withNumeroItem(numeroItem)
            .withCodigoProduto(codigoProduto)
            .withDescricao(descricao)
            .withCodigoNcm(codigoNcm)
            .withCfop(cfop)
            .withUnidadeComercial(unidadeComercial)
            .withQuantidadeComercial(quantidadeComercial)
            .withValorUnitarioComercial(valorUnitarioComercial)
            .withIcmsOrigem(icmsOrigem)
            .withIcmsSituacaoTributaria(icmsSituacaoTributaria)
            .withPisSituacaoTributaria(pisSituacaoTributaria)
            .withCofinsSituacaoTributaria(cofinsSituacaoTributaria)
            .build();
        FocusNFeUtils.throwBeanValidation(entity);
    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeItem entity = new NFeItem();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
