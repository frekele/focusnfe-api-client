package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

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
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRequisicaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String naturezaOperacao;
        String serie;
        String numero;
        OffsetDateTime dataEmissao;
        OffsetDateTime dataEntradaSaida;
        NFeTipoDocumentoEnum tipoDocumento;
        NFeLocalDestinoEnum localDestino;
        NFeFinalidadeEmissaoEnum finalidadeEmissao;
        NFeConsumidorFinalEnum consumidorFinal;
        NFePresencaCompradorEnum presencaComprador;
        List<NFeNotaReferenciada> notasReferenciadas;
        String cnpjEmitente;
        String nomeEmitente;
        String nomeFantasiaEmitente;
        String logradouroEmitente;
        String numeroEmitente;
        String complementoEmitente;
        String bairroEmitente;
        String municipioEmitente;
        NFeUnidadeFederativaEnum ufEmitente;
        String cepEmitente;
        String telefoneEmitente;
        String inscricaoEstadualEmitente;
        String inscricaoEstadualStEmitente;
        String inscricaoMunicipalEmitente;
        String cnaeFiscalEmitente;
        NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;
        String cnpjDestinatario;
        String cpfDestinatario;
        String idEstrangeiroDestinatario;
        String nomeDestinatario;
        String logradouroDestinatario;
        String numeroDestinatario;
        String complementoDestinatario;
        String bairroDestinatario;
        String codigoMunicipioDestinatario;
        String municipioDestinatario;
        NFeUnidadeFederativaEnum ufDestinatario;
        String cepDestinatario;
        String codigoPaisDestinatario;
        String paisDestinatario;
        String telefoneDestinatario;
        NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;
        String inscricaoEstadualDestinatario;
        String inscricaoSuframaDestinatario;
        String inscricaoMunicipalDestinatario;
        String emailDestinatario;
        String cnpjRetirada;
        String cpfRetirada;
        String logradouroRetirada;
        String numeroRetirada;
        String complementoRetirada;
        String bairroRetirada;
        String codigoMunicipioRetirada;
        String municipioRetirada;
        NFeUnidadeFederativaEnum ufRetirada;
        String cnpjEntrega;
        String cpfEntrega;
        String logradouroEntrega;
        String numeroEntrega;
        String complementoEntrega;
        String bairroEntrega;
        String codigoMunicipioEntrega;
        String municipioEntrega;
        NFeUnidadeFederativaEnum ufEntrega;
        List<NFePessoaAutorizada> pessoasAutorizadas;
        List<NFeItem> items;
        BigDecimal icmsBaseCalculo;
        BigDecimal icmsValorTotal;
        BigDecimal icmsValorTotalDesonerado;
        BigDecimal fcpValorTotalUfDestino;
        BigDecimal icmsValorTotalUfDestino;
        BigDecimal icmsValorTotalUfRemetente;
        BigDecimal fcpValorTotal;
        BigDecimal icmsBaseCalculoSt;
        BigDecimal icmsValorTotalSt;
        BigDecimal fcpValorTotalSt;
        BigDecimal fcpValorTotalRetidoSt;
        BigDecimal valorProdutos;
        BigDecimal valorFrete;
        BigDecimal valorSeguro;
        BigDecimal valorDesconto;
        BigDecimal valorTotalII;
        BigDecimal valorIpi;
        BigDecimal valorIpiDevolvido;
        BigDecimal valorPis;
        BigDecimal valorCofins;
        BigDecimal valorOutrasDespesas;
        BigDecimal valorTotal;
        BigDecimal valorTotalTributos;
        BigDecimal valorTotalServicos;
        BigDecimal issqnBaseCalculo;
        BigDecimal issqnValorTotal;
        BigDecimal valorPisServicos;
        BigDecimal valorCofinsServicos;
        LocalDate dataPrestacaoServico;
        BigDecimal issqnValorTotalDeducao;
        BigDecimal issqnValorTotalOutrasRetencoes;
        BigDecimal issqnValorTotalDescontoIncondicionado;
        BigDecimal issqnValorTotalDescontoCondicionado;
        BigDecimal issqnValorTotalRetencao;
        NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao;
        BigDecimal pisValorRetido;
        BigDecimal cofinsValorRetido;
        BigDecimal csllValorRetido;
        BigDecimal irrfBaseCalculo;
        BigDecimal irrfValorRetido;
        BigDecimal prevSocialBaseCalculo;
        BigDecimal prevSocialValorRetido;
        NFeModalidadeFreteEnum modalidadeFrete;
        String cnpjTransportador;
        String cpfTransportador;
        String nomeTransportador;
        String inscricaoEstadualTransportador;
        String enderecoTransportador;
        String municipioTransportador;
        NFeUnidadeFederativaEnum ufTransportador;
        BigDecimal transporteIcmsServico;
        BigDecimal transporteIcmsBaseCalculo;
        BigDecimal transporteIcmsAliquota;
        BigDecimal transporteIcmsValor;
        String transporteIcmsCfop;
        String transporteIcmsCodigoMunicipio;
        String veiculoPlaca;
        NFeUnidadeFederativaEnum veiculoUf;
        String veiculoRntc;
        List<NFeReboque> reboques;
        String veiculoIdentificacaoVagao;
        String veiculoIdentificacaoBalsa;
        List<NFeVolumeTransportado> volumes;
        String numeroFatura;
        BigDecimal valorOriginalFatura;
        BigDecimal valorDescontoFatura;
        BigDecimal valorLiquidoFatura;
        List<NFeDuplicataNotaFiscal> duplicatas;
        List<NFeFormaPagamento> formasPagamento;
        String informacoesAdicionaisFisco;
        String informacoesAdicionaisContribuinte;
        NFeUnidadeFederativaEnum ufLocalEmbarque;
        String localEmbarque;
        String localDespacho;

        NFeRequisicao entity = new NFeRequisicao();
        //entity.setNve(nve);

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());

        entity = NFeRequisicao.newBuilder()
            //.withNve(nve)
            .build();

        assertNotNull(entity);
        //assertEquals(nve, entity.getNve());
    }

    //@Test
    //public void testBeanValidation() throws Exception {
    //    NFeRequisicao entity = new NFeRequisicao();
    //    FocusNFeUtils.throwBeanValidation(entity);
    //}

    //@Test(expectedExceptions = {ConstraintViolationException.class})
    //public void testBeanValidationWithError() throws Exception {
    //    NFeRequisicao entity = new NFeRequisicao();
    //    FocusNFeUtils.throwBeanValidation(entity);
    //}
}
