package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

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
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeItemTest {

    @Test
    public void testNewInstance() throws Exception {
        String numeroItem;
        String codigoProduto;
        String codigoBarrasComercial;
        String descricao;
        String codigoNcm;
        List<NFeNve> nves;
        String cest;
        Boolean escalaRelevante;
        String cnpjFabricante;
        String codigoBeneficioFiscalUf;
        String codigoExTipi;
        String cfop;
        String unidadeComercial;
        BigDecimal quantidadeComercial;
        BigDecimal valorUnitarioComercial;
        BigDecimal valorBruto;
        String codigoBarrasTributavel;
        String unidadeTributavel;
        BigDecimal quantidadeTributavel;
        BigDecimal valorUnitarioTributavel;
        BigDecimal valorFrete;
        BigDecimal valorSeguro;
        BigDecimal valorDesconto;
        BigDecimal valorOutrasDespesas;
        NFeIncluiNoTotalEnum incluiNoTotal;
        List<NFeDocumentoImportacao> documentosImportacao;
        List<NFeDetalheExportacao> detalhesExportacao;
        String pedidoCompra;
        String numeroItemPedidoCompra;
        String numeroFci;
        List<NFeRastro> rastros;
        NFeVeiculoTipoOperacaoEnum veiculoTipoOperacao;
        String veiculoChassi;
        String veiculoCodigoCor;
        String veiculoDescricaoCor;
        String veiculoPotenciaMotor;
        String veiculoCm3;
        String veiculoPesoLiquido;
        String veiculoPesoBruto;
        String veiculoSerie;
        NFeVeiculoTipoCombustivelEnum veiculoTipoCombustivel;
        String veiculoNumeroMotor;
        String veiculoCmt;
        String veiculoDistanciaEixos;
        String veiculoAnoModelo;
        String veiculoAnoFabricacao;
        String veiculoTipoPintura;
        String veiculoTipo;
        String veiculoEspecie;
        NFeVeiculoVinEnum veiculoCodigoVin;
        NFeVeiculoCondicaoEnum veiculoCondicao;
        String veiculoCodigoMarcaModelo;
        NFeVeiculoCodigoCorDenatranEnum veiculoCodigoCorDenatran;
        String veiculoLotacao;
        NFeVeiculoRestricaoEnum veiculoRestricao;
        String medicamentoCodigoAnvisa;
        BigDecimal medicamentoPrecoMaximoConsumidor;
        String combustivelCodigoAnp;
        String combustivelDescricaoAnp;
        BigDecimal combustivelPercentualGlp;
        BigDecimal combustivelPercentualGasNaturalNacional;
        BigDecimal combustivelPercentualGasNaturalImportado;
        BigDecimal combustivelValorPartida;
        String combustivelRegistroCodif;
        BigDecimal combustivelQuantidadeTemperaturaAmbiente;
        NFeUnidadeFederativaEnum combustivelSiglaUf;
        BigDecimal combustivelCideBaseCalculo;
        BigDecimal combustivelCideAliquota;
        BigDecimal combustivelCideValor;
        BigDecimal valorTotalTributos;
        BigDecimal issqnBaseCalculo;
        BigDecimal issqnAliquota;
        BigDecimal issqnValor;
        String issqnCodigoMunicipio;
        String issqnItemListaServico;
        BigDecimal issqnValorDeducao;
        BigDecimal issqnValorOutrasRetencoes;
        BigDecimal issqnValorDescontoIncondicionado;
        BigDecimal issqnValorDescontoCondicionado;
        BigDecimal issqnValorRetencao;
        NFeIssqnIndicadorExigibilidadeEnum issqnIndicadorExigibilidade;
        String issqnCodigoServico;
        String issqnCodigoMunicipioIncidencia;
        String issqnCodigoPais;
        String issqnNumeroProcesso;
        String issqnIndicadorIncentivo;
        NFeIcmsOrigemEnum icmsOrigem;
        NFeIcmsSituacaoTributariaEnum icmsSituacaoTributaria;
        NFeIcmsModalidadeBaseCalculoEnum icmsMmodalidadeBaseCalculo;
        BigDecimal icmsBaseCalculo;
        BigDecimal icmsBaseCalculoRetidoSt;
        BigDecimal icmsReducaoBaseCalculo;
        BigDecimal icmsAliquota;
        BigDecimal icmsAliquotaFinal;
        BigDecimal icmsValor;
        BigDecimal icmsValorRetidoSt;
        BigDecimal icmsValorDesonerado;
        BigDecimal icmsValorOperacao;
        BigDecimal icmsPercentualDiferimento;
        BigDecimal icmsValorDiferido;
        NFeIcmsMotivoDesoneracaoEnum icmsMotivoDesoneracao;
        NFeIcmsModalidadeBaseCalculoStEnum icmsModalidadeBaseCalculoSt;
        BigDecimal icmsMargemValorAdicionadoSt;
        BigDecimal icmsReducaoBaseCalculoSt;
        BigDecimal icmsBaseCalculoSt;
        BigDecimal icmsAliquotaSt;
        BigDecimal icmsValorSt;
        BigDecimal icmsAliquotaCreditoSimples;
        BigDecimal icmsValorCreditoSimples;
        BigDecimal fcpPercentual;
        BigDecimal fcpBaseCalculo;
        BigDecimal fcpValor;
        BigDecimal fcpPercentualSt;
        BigDecimal fcpBaseCalculoSt;
        BigDecimal fcpValorSt;
        BigDecimal fcpPercentualRetidoSt;
        BigDecimal fcpBaseCalculoRetidoSt;
        BigDecimal fcpValorRetidoSt;
        NFeIpiSituacaoTributariaEnum ipiSituacaoTributaria;
        BigDecimal ipiBaseCalculo;
        BigDecimal ipiAliquota;
        BigDecimal ipiQuantidadeTotal;
        BigDecimal ipiValorPorUnidadeTributavel;
        BigDecimal ipiValor;
        String ipiClasseEnquadramento;
        String ipiCnpjProdutor;
        String ipiCodigoSeloControle;
        String ipiQuantidadeSeloControle;
        String ipiCodigoEnquadramentoLegal;
        BigDecimal iiBaseCalculo;
        BigDecimal iiDespesasAduaneiras;
        BigDecimal iiValor;
        BigDecimal iiValorIof;
        NFePisCofinsSituacaoTributariaEnum pisSituacaoTributaria;
        BigDecimal pisBaseCalculo;
        BigDecimal pisAliquotaPorcentual;
        BigDecimal pisQuantidadeVendida;
        BigDecimal pisAliquotaValor;
        BigDecimal pisValor;
        BigDecimal pisBaseCalculoSt;
        BigDecimal pisAliquotaPorcentualSt;
        BigDecimal pisQuantidadeVendidaSt;
        BigDecimal pisAliquotaValorSt;
        BigDecimal pisValorSt;
        NFePisCofinsSituacaoTributariaEnum cofinsSituacaoTributaria;
        BigDecimal cofinsBaseCalculo;
        BigDecimal cofinsAliquotaPorcentual;
        BigDecimal cofinsQuantidadeVendida;
        BigDecimal cofinsAliquotaValor;
        BigDecimal cofinsValor;
        BigDecimal cofinsBaseCalculoSt;
        BigDecimal cofinsAliquotaPorcentualSt;
        BigDecimal cofinsQuantidadeVendidaSt;
        BigDecimal cofinsAliquotaValorSt;
        BigDecimal cofinsValorSt;
        BigDecimal icmsBaseCalculoUfDestino;
        BigDecimal fcpBaseCalculoUfDestino;
        BigDecimal fcpPercentualUfDestino;
        BigDecimal icmsAliquotaInternaUfDestino;
        BigDecimal icmsAliquotaInterestadual;
        BigDecimal icmsPercentualPartilha;
        BigDecimal fcpValorUfDestino;
        BigDecimal icmsValorUfDestino;
        BigDecimal icmsValorUfRemetente;
        BigDecimal percentualDevolvido;
        BigDecimal valorIpiDevolvido;
        String informacoesAdicionaisItem;

        NFeItem entity = new NFeItem();
        // entity.setNve(nve);

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());

        entity = NFeItem.newBuilder()
            //   .withNve(nve)
            .build();

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());
    }

    //@Test
    //public void testBeanValidation() throws Exception {
    //    NFeItem entity = new NFeItem();
    //    FocusNFeUtils.throwBeanValidation(entity);
    //}

    //@Test(expectedExceptions = {ConstraintViolationException.class})
    //public void testBeanValidationWithError() throws Exception {
    //    NFeItem entity = new NFeItem();
    //    FocusNFeUtils.throwBeanValidation(entity);
    //}
}
