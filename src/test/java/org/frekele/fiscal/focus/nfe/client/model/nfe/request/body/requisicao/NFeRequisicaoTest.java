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
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class NFeRequisicaoTest {

    @Test
    public void testNewInstance() throws Exception {
        String naturezaOperacao = "Venda de Mercadoria";
        String serie = "1";
        String numero = "6543567";
        OffsetDateTime dataEmissao = OffsetDateTime.now();
        OffsetDateTime dataEntradaSaida = OffsetDateTime.now().plusHours(4);
        NFeTipoDocumentoEnum tipoDocumento = NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA;
        NFeLocalDestinoEnum localDestino = NFeLocalDestinoEnum.OPERACAO_INTERNA;
        NFeFinalidadeEmissaoEnum finalidadeEmissao = NFeFinalidadeEmissaoEnum.NOTA_NORMAL;
        NFeConsumidorFinalEnum consumidorFinal = NFeConsumidorFinalEnum.CONSUMIDOR_FINAL;
        NFePresencaCompradorEnum presencaComprador = NFePresencaCompradorEnum.OPERACAO_PRESENCIAL;
        List<NFeNotaReferenciada> notasReferenciadas = new ArrayList<>();
        notasReferenciadas.add(new NFeNotaReferenciada());
        String cnpjEmitente = "65456787654345";
        String nomeEmitente = "bla bla bla bla bla";
        String nomeFantasiaEmitente = "bla bla bla bla bla bla";
        String logradouroEmitente = "bla bla bla bla bla bla bla";
        String numeroEmitente = "12334";
        String complementoEmitente = "bla bla bla";
        String bairroEmitente = "bla bla";
        String municipioEmitente = "Porto Alegre";
        NFeUnidadeFederativaEnum ufEmitente = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cepEmitente = "91920530";
        String telefoneEmitente = "513457070";
        String inscricaoEstadualEmitente = "8978976987";
        String inscricaoEstadualStEmitente = "786786786";
        String inscricaoMunicipalEmitente = "4654564545";
        String cnaeFiscalEmitente = "5646545";
        NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente = NFeRegimeTributarioEmitenteEnum.SIMPLES_NACIONAL;
        String cnpjDestinatario = "83654385345673";
        String cpfDestinatario = "29876432054";
        String idEstrangeiroDestinatario = "654545";
        String nomeDestinatario = "bla bla bla bla";
        String logradouroDestinatario = "bla bla bla bla";
        String numeroDestinatario = "123445";
        String complementoDestinatario = "bla bla bla bla";
        String bairroDestinatario = "bla bla";
        String codigoMunicipioDestinatario = "2346545";
        String municipioDestinatario = "bla bla bla bla bla";
        NFeUnidadeFederativaEnum ufDestinatario = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cepDestinatario = "91920530";
        String codigoPaisDestinatario = "897456";
        String paisDestinatario = "Brasil";
        String telefoneDestinatario = "51334354566";
        NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario = NFeIndicadorInscricaoEstadualDestinatarioEnum.CONTRIBUINTE;
        String inscricaoEstadualDestinatario = "67843564786";
        String inscricaoSuframaDestinatario = "5645646543";
        String inscricaoMunicipalDestinatario = "345543543";
        String emailDestinatario = "teste@teste.com.br";
        String cnpjRetirada = "87654654323456";
        String cpfRetirada = "56781243265";
        String logradouroRetirada = "bla bla bla bla bla";
        String numeroRetirada = "23454";
        String complementoRetirada = "bla bla bla bla";
        String bairroRetirada = "bla bla";
        String codigoMunicipioRetirada = "3455346";
        String municipioRetirada = "Porto Alegre";
        NFeUnidadeFederativaEnum ufRetirada = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cnpjEntrega = "45676543456789";
        String cpfEntrega = "34567876543";
        String logradouroEntrega = "bla bla bla bla";
        String numeroEntrega = "8976";
        String complementoEntrega = "bla bla bla";
        String bairroEntrega = "bla bla bla";
        String codigoMunicipioEntrega = "432535";
        String municipioEntrega = "Porto Alegre";
        NFeUnidadeFederativaEnum ufEntrega = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        List<NFePessoaAutorizada> pessoasAutorizadas = new ArrayList<>();
        pessoasAutorizadas.add(new NFePessoaAutorizada());
        List<NFeItem> items = new ArrayList<>();
        items.add(new NFeItem());
        BigDecimal icmsBaseCalculo = new BigDecimal("10.10");
        BigDecimal icmsValorTotal = new BigDecimal("10.11");
        BigDecimal icmsValorTotalDesonerado = new BigDecimal("10.12");
        BigDecimal fcpValorTotalUfDestino = new BigDecimal("10.13");
        BigDecimal icmsValorTotalUfDestino = new BigDecimal("10.14");
        BigDecimal icmsValorTotalUfRemetente = new BigDecimal("10.15");
        BigDecimal fcpValorTotal = new BigDecimal("10.16");
        BigDecimal icmsBaseCalculoSt = new BigDecimal("10.17");
        BigDecimal icmsValorTotalSt = new BigDecimal("10.18");
        BigDecimal fcpValorTotalSt = new BigDecimal("10.19");
        BigDecimal fcpValorTotalRetidoSt = new BigDecimal("10.20");
        BigDecimal valorProdutos = new BigDecimal("10.21");
        BigDecimal valorFrete = new BigDecimal("10.22");
        BigDecimal valorSeguro = new BigDecimal("10.23");
        BigDecimal valorDesconto = new BigDecimal("10.24");
        BigDecimal valorTotalII = new BigDecimal("10.25");
        BigDecimal valorIpi = new BigDecimal("10.26");
        BigDecimal valorIpiDevolvido = new BigDecimal("10.27");
        BigDecimal valorPis = new BigDecimal("10.28");
        BigDecimal valorCofins = new BigDecimal("10.29");
        BigDecimal valorOutrasDespesas = new BigDecimal("10.30");
        BigDecimal valorTotal = new BigDecimal("10.31");
        BigDecimal valorTotalTributos = new BigDecimal("10.32");
        BigDecimal valorTotalServicos = new BigDecimal("10.33");
        BigDecimal issqnBaseCalculo = new BigDecimal("10.34");
        BigDecimal issqnValorTotal = new BigDecimal("10.35");
        BigDecimal valorPisServicos = new BigDecimal("10.36");
        BigDecimal valorCofinsServicos = new BigDecimal("10.37");
        LocalDate dataPrestacaoServico = LocalDate.parse("2018-04-20");
        BigDecimal issqnValorTotalDeducao = new BigDecimal("10.38");
        BigDecimal issqnValorTotalOutrasRetencoes = new BigDecimal("10.39");
        BigDecimal issqnValorTotalDescontoIncondicionado = new BigDecimal("10.40");
        BigDecimal issqnValorTotalDescontoCondicionado = new BigDecimal("10.41");
        BigDecimal issqnValorTotalRetencao = new BigDecimal("10.42");
        NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao = NFeCodigoRegimeEspecialTributacaoEnum.MICROEMPRESARIO_E_EMPRESA_PEQUENO_PORTE_ME_EPP;
        BigDecimal pisValorRetido = new BigDecimal("10.43");
        BigDecimal cofinsValorRetido = new BigDecimal("10.44");
        BigDecimal csllValorRetido = new BigDecimal("10.45");
        BigDecimal irrfBaseCalculo = new BigDecimal("10.46");
        BigDecimal irrfValorRetido = new BigDecimal("10.47");
        BigDecimal prevSocialBaseCalculo = new BigDecimal("10.48");
        BigDecimal prevSocialValorRetido = new BigDecimal("10.49");
        NFeModalidadeFreteEnum modalidadeFrete = NFeModalidadeFreteEnum.POR_CONTA_EMITENTE;
        String cnpjTransportador = "45678543256789";
        String cpfTransportador = "23456765456";
        String nomeTransportador = "bla bla bla bla";
        String inscricaoEstadualTransportador = "95684590685";
        String enderecoTransportador = "bla bla bla bla bla";
        String municipioTransportador = "Porto Alegre";
        NFeUnidadeFederativaEnum ufTransportador = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        BigDecimal transporteIcmsServico = new BigDecimal("10.50");
        BigDecimal transporteIcmsBaseCalculo = new BigDecimal("10.51");
        BigDecimal transporteIcmsAliquota = new BigDecimal("10.52");
        BigDecimal transporteIcmsValor = new BigDecimal("10.53");
        String transporteIcmsCfop = "5102";
        String transporteIcmsCodigoMunicipio = "3455";
        String veiculoPlaca = "FGG4545";
        NFeUnidadeFederativaEnum veiculoUf = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String veiculoRntc = "394568";
        List<NFeReboque> reboques = new ArrayList<>();
        reboques.add(new NFeReboque());
        String veiculoIdentificacaoVagao = "897987";
        String veiculoIdentificacaoBalsa = "67876";
        List<NFeVolumeTransportado> volumes = new ArrayList<>();
        volumes.add(new NFeVolumeTransportado());
        String numeroFatura = "6";
        BigDecimal valorOriginalFatura = new BigDecimal("10.54");
        BigDecimal valorDescontoFatura = new BigDecimal("10.55");
        BigDecimal valorLiquidoFatura = new BigDecimal("10.56");
        List<NFeDuplicataNotaFiscal> duplicatas = new ArrayList<>();
        duplicatas.add(new NFeDuplicataNotaFiscal());
        List<NFeFormaPagamento> formasPagamento = new ArrayList<>();
        formasPagamento.add(new NFeFormaPagamento());
        String informacoesAdicionaisFisco = "bla bla bla bla bla bla bla bla";
        String informacoesAdicionaisContribuinte = "bla bla bla bla bla bla bla";
        NFeUnidadeFederativaEnum ufLocalEmbarque = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String localEmbarque = "xblabla bla bla";
        String localDespacho = "cxx bla bla bla";

        NFeRequisicao entity = new NFeRequisicao();
        entity.setNaturezaOperacao(naturezaOperacao);
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setDataEmissao(dataEmissao);
        entity.setDataEntradaSaida(dataEntradaSaida);
        entity.setTipoDocumento(tipoDocumento);
        entity.setLocalDestino(localDestino);
        entity.setFinalidadeEmissao(finalidadeEmissao);
        entity.setConsumidorFinal(consumidorFinal);
        entity.setPresencaComprador(presencaComprador);
        entity.setNotasReferenciadas(notasReferenciadas);
        entity.setCnpjEmitente(cnpjEmitente);
        entity.setNomeEmitente(nomeEmitente);
        entity.setNomeFantasiaEmitente(nomeFantasiaEmitente);
        entity.setLogradouroEmitente(logradouroEmitente);
        entity.setNumeroEmitente(numeroEmitente);
        entity.setComplementoEmitente(complementoEmitente);
        entity.setBairroEmitente(bairroEmitente);
        entity.setMunicipioEmitente(municipioEmitente);
        entity.setUfEmitente(ufEmitente);
        entity.setCepEmitente(cepEmitente);
        entity.setTelefoneEmitente(telefoneEmitente);
        entity.setInscricaoEstadualEmitente(inscricaoEstadualEmitente);
        entity.setInscricaoEstadualStEmitente(inscricaoEstadualStEmitente);
        entity.setInscricaoMunicipalEmitente(inscricaoMunicipalEmitente);
        entity.setCnaeFiscalEmitente(cnaeFiscalEmitente);
        entity.setRegimeTributarioEmitente(regimeTributarioEmitente);
        entity.setCnpjDestinatario(cnpjDestinatario);
        entity.setCpfDestinatario(cpfDestinatario);
        entity.setIdEstrangeiroDestinatario(idEstrangeiroDestinatario);
        entity.setNomeDestinatario(nomeDestinatario);
        entity.setLogradouroDestinatario(logradouroDestinatario);
        entity.setNumeroDestinatario(numeroDestinatario);
        entity.setComplementoDestinatario(complementoDestinatario);
        entity.setBairroDestinatario(bairroDestinatario);
        entity.setCodigoMunicipioDestinatario(codigoMunicipioDestinatario);
        entity.setMunicipioDestinatario(municipioDestinatario);
        entity.setUfDestinatario(ufDestinatario);
        entity.setCepDestinatario(cepDestinatario);
        entity.setCodigoPaisDestinatario(codigoPaisDestinatario);
        entity.setPaisDestinatario(paisDestinatario);
        entity.setTelefoneDestinatario(telefoneDestinatario);
        entity.setIndicadorInscricaoEstadualDestinatario(indicadorInscricaoEstadualDestinatario);
        entity.setInscricaoEstadualDestinatario(inscricaoEstadualDestinatario);
        entity.setInscricaoSuframaDestinatario(inscricaoSuframaDestinatario);
        entity.setInscricaoMunicipalDestinatario(inscricaoMunicipalDestinatario);
        entity.setEmailDestinatario(emailDestinatario);
        entity.setCnpjRetirada(cnpjRetirada);
        entity.setCpfRetirada(cpfRetirada);
        entity.setLogradouroRetirada(logradouroRetirada);
        entity.setNumeroRetirada(numeroRetirada);
        entity.setComplementoRetirada(complementoRetirada);
        entity.setBairroRetirada(bairroRetirada);
        entity.setCodigoMunicipioRetirada(codigoMunicipioRetirada);
        entity.setMunicipioRetirada(municipioRetirada);
        entity.setUfRetirada(ufRetirada);
        entity.setCnpjEntrega(cnpjEntrega);
        entity.setCpfEntrega(cpfEntrega);
        entity.setLogradouroEntrega(logradouroEntrega);
        entity.setNumeroEntrega(numeroEntrega);
        entity.setComplementoEntrega(complementoEntrega);
        entity.setBairroEntrega(bairroEntrega);
        entity.setCodigoMunicipioEntrega(codigoMunicipioEntrega);
        entity.setMunicipioEntrega(municipioEntrega);
        entity.setUfEntrega(ufEntrega);
        entity.setPessoasAutorizadas(pessoasAutorizadas);
        entity.setItems(items);
        entity.setIcmsBaseCalculo(icmsBaseCalculo);
        entity.setIcmsValorTotal(icmsValorTotal);
        entity.setIcmsValorTotalDesonerado(icmsValorTotalDesonerado);
        entity.setFcpValorTotalUfDestino(fcpValorTotalUfDestino);
        entity.setIcmsValorTotalUfDestino(icmsValorTotalUfDestino);
        entity.setIcmsValorTotalUfRemetente(icmsValorTotalUfRemetente);
        entity.setFcpValorTotal(fcpValorTotal);
        entity.setIcmsBaseCalculoSt(icmsBaseCalculoSt);
        entity.setIcmsValorTotalSt(icmsValorTotalSt);
        entity.setFcpValorTotalSt(fcpValorTotalSt);
        entity.setFcpValorTotalRetidoSt(fcpValorTotalRetidoSt);
        entity.setValorProdutos(valorProdutos);
        entity.setValorFrete(valorFrete);
        entity.setValorSeguro(valorSeguro);
        entity.setValorDesconto(valorDesconto);
        entity.setValorTotalII(valorTotalII);
        entity.setValorIpi(valorIpi);
        entity.setValorIpiDevolvido(valorIpiDevolvido);
        entity.setValorPis(valorPis);
        entity.setValorCofins(valorCofins);
        entity.setValorOutrasDespesas(valorOutrasDespesas);
        entity.setValorTotal(valorTotal);
        entity.setValorTotalTributos(valorTotalTributos);
        entity.setValorTotalServicos(valorTotalServicos);
        entity.setIssqnBaseCalculo(issqnBaseCalculo);
        entity.setIssqnValorTotal(issqnValorTotal);
        entity.setValorPisServicos(valorPisServicos);
        entity.setValorCofinsServicos(valorCofinsServicos);
        entity.setDataPrestacaoServico(dataPrestacaoServico);
        entity.setIssqnValorTotalDeducao(issqnValorTotalDeducao);
        entity.setIssqnValorTotalOutrasRetencoes(issqnValorTotalOutrasRetencoes);
        entity.setIssqnValorTotalDescontoIncondicionado(issqnValorTotalDescontoIncondicionado);
        entity.setIssqnValorTotalDescontoCondicionado(issqnValorTotalDescontoCondicionado);
        entity.setIssqnValorTotalRetencao(issqnValorTotalRetencao);
        entity.setCodigoRegimeEspecialTributacao(codigoRegimeEspecialTributacao);
        entity.setPisValorRetido(pisValorRetido);
        entity.setCofinsValorRetido(cofinsValorRetido);
        entity.setCsllValorRetido(csllValorRetido);
        entity.setIrrfBaseCalculo(irrfBaseCalculo);
        entity.setIrrfValorRetido(irrfValorRetido);
        entity.setPrevSocialBaseCalculo(prevSocialBaseCalculo);
        entity.setPrevSocialValorRetido(prevSocialValorRetido);
        entity.setModalidadeFrete(modalidadeFrete);
        entity.setCnpjTransportador(cnpjTransportador);
        entity.setCpfTransportador(cpfTransportador);
        entity.setNomeTransportador(nomeTransportador);
        entity.setInscricaoEstadualTransportador(inscricaoEstadualTransportador);
        entity.setEnderecoTransportador(enderecoTransportador);
        entity.setMunicipioTransportador(municipioTransportador);
        entity.setUfTransportador(ufTransportador);
        entity.setTransporteIcmsServico(transporteIcmsServico);
        entity.setTransporteIcmsBaseCalculo(transporteIcmsBaseCalculo);
        entity.setTransporteIcmsAliquota(transporteIcmsAliquota);
        entity.setTransporteIcmsValor(transporteIcmsValor);
        entity.setTransporteIcmsCfop(transporteIcmsCfop);
        entity.setTransporteIcmsCodigoMunicipio(transporteIcmsCodigoMunicipio);
        entity.setVeiculoPlaca(veiculoPlaca);
        entity.setVeiculoUf(veiculoUf);
        entity.setVeiculoRntc(veiculoRntc);
        entity.setReboques(reboques);
        entity.setVeiculoIdentificacaoVagao(veiculoIdentificacaoVagao);
        entity.setVeiculoIdentificacaoBalsa(veiculoIdentificacaoBalsa);
        entity.setVolumes(volumes);
        entity.setNumeroFatura(numeroFatura);
        entity.setValorOriginalFatura(valorOriginalFatura);
        entity.setValorDescontoFatura(valorDescontoFatura);
        entity.setValorLiquidoFatura(valorLiquidoFatura);
        entity.setDuplicatas(duplicatas);
        entity.setFormasPagamento(formasPagamento);
        entity.setInformacoesAdicionaisFisco(informacoesAdicionaisFisco);
        entity.setInformacoesAdicionaisContribuinte(informacoesAdicionaisContribuinte);
        entity.setUfLocalEmbarque(ufLocalEmbarque);
        entity.setLocalEmbarque(localEmbarque);
        entity.setLocalDespacho(localDespacho);

        assertNotNull(entity);
        assertEquals(naturezaOperacao, entity.getNaturezaOperacao());
        assertEquals(serie, entity.getSerie());
        assertEquals(numero, entity.getNumero());
        assertEquals(dataEmissao, entity.getDataEmissao());
        assertEquals(dataEntradaSaida, entity.getDataEntradaSaida());
        assertEquals(tipoDocumento, entity.getTipoDocumento());
        assertEquals(localDestino, entity.getLocalDestino());
        assertEquals(finalidadeEmissao, entity.getFinalidadeEmissao());
        assertEquals(consumidorFinal, entity.getConsumidorFinal());
        assertEquals(presencaComprador, entity.getPresencaComprador());
        assertEquals(notasReferenciadas, entity.getNotasReferenciadas());
        assertEquals(cnpjEmitente, entity.getCnpjEmitente());
        assertEquals(nomeEmitente, entity.getNomeEmitente());
        assertEquals(nomeFantasiaEmitente, entity.getNomeFantasiaEmitente());
        assertEquals(logradouroEmitente, entity.getLogradouroEmitente());
        assertEquals(numeroEmitente, entity.getNumeroEmitente());
        assertEquals(complementoEmitente, entity.getComplementoEmitente());
        assertEquals(bairroEmitente, entity.getBairroEmitente());
        assertEquals(municipioEmitente, entity.getMunicipioEmitente());
        assertEquals(ufEmitente, entity.getUfEmitente());
        assertEquals(cepEmitente, entity.getCepEmitente());
        assertEquals(telefoneEmitente, entity.getTelefoneEmitente());
        assertEquals(inscricaoEstadualEmitente, entity.getInscricaoEstadualEmitente());
        assertEquals(inscricaoEstadualStEmitente, entity.getInscricaoEstadualStEmitente());
        assertEquals(inscricaoMunicipalEmitente, entity.getInscricaoMunicipalEmitente());
        assertEquals(cnaeFiscalEmitente, entity.getCnaeFiscalEmitente());
        assertEquals(regimeTributarioEmitente, entity.getRegimeTributarioEmitente());
        assertEquals(cnpjDestinatario, entity.getCnpjDestinatario());
        assertEquals(cpfDestinatario, entity.getCpfDestinatario());
        assertEquals(idEstrangeiroDestinatario, entity.getIdEstrangeiroDestinatario());
        assertEquals(nomeDestinatario, entity.getNomeDestinatario());
        assertEquals(logradouroDestinatario, entity.getLogradouroDestinatario());
        assertEquals(numeroDestinatario, entity.getNumeroDestinatario());
        assertEquals(complementoDestinatario, entity.getComplementoDestinatario());
        assertEquals(bairroDestinatario, entity.getBairroDestinatario());
        assertEquals(codigoMunicipioDestinatario, entity.getCodigoMunicipioDestinatario());
        assertEquals(municipioDestinatario, entity.getMunicipioDestinatario());
        assertEquals(ufDestinatario, entity.getUfDestinatario());
        assertEquals(cepDestinatario, entity.getCepDestinatario());
        assertEquals(codigoPaisDestinatario, entity.getCodigoPaisDestinatario());
        assertEquals(paisDestinatario, entity.getPaisDestinatario());
        assertEquals(telefoneDestinatario, entity.getTelefoneDestinatario());
        assertEquals(indicadorInscricaoEstadualDestinatario, entity.getIndicadorInscricaoEstadualDestinatario());
        assertEquals(inscricaoEstadualDestinatario, entity.getInscricaoEstadualDestinatario());
        assertEquals(inscricaoSuframaDestinatario, entity.getInscricaoSuframaDestinatario());
        assertEquals(inscricaoMunicipalDestinatario, entity.getInscricaoMunicipalDestinatario());
        assertEquals(emailDestinatario, entity.getEmailDestinatario());
        assertEquals(cnpjRetirada, entity.getCnpjRetirada());
        assertEquals(cpfRetirada, entity.getCpfRetirada());
        assertEquals(logradouroRetirada, entity.getLogradouroRetirada());
        assertEquals(numeroRetirada, entity.getNumeroRetirada());
        assertEquals(complementoRetirada, entity.getComplementoRetirada());
        assertEquals(bairroRetirada, entity.getBairroRetirada());
        assertEquals(codigoMunicipioRetirada, entity.getCodigoMunicipioRetirada());
        assertEquals(municipioRetirada, entity.getMunicipioRetirada());
        assertEquals(ufRetirada, entity.getUfRetirada());
        assertEquals(cnpjEntrega, entity.getCnpjEntrega());
        assertEquals(cpfEntrega, entity.getCpfEntrega());
        assertEquals(logradouroEntrega, entity.getLogradouroEntrega());
        assertEquals(numeroEntrega, entity.getNumeroEntrega());
        assertEquals(complementoEntrega, entity.getComplementoEntrega());
        assertEquals(bairroEntrega, entity.getBairroEntrega());
        assertEquals(codigoMunicipioEntrega, entity.getCodigoMunicipioEntrega());
        assertEquals(municipioEntrega, entity.getMunicipioEntrega());
        assertEquals(ufEntrega, entity.getUfEntrega());
        assertEquals(pessoasAutorizadas, entity.getPessoasAutorizadas());
        assertEquals(items, entity.getItems());
        assertEquals(icmsBaseCalculo, entity.getIcmsBaseCalculo());
        assertEquals(icmsValorTotal, entity.getIcmsValorTotal());
        assertEquals(icmsValorTotalDesonerado, entity.getIcmsValorTotalDesonerado());
        assertEquals(fcpValorTotalUfDestino, entity.getFcpValorTotalUfDestino());
        assertEquals(icmsValorTotalUfDestino, entity.getIcmsValorTotalUfDestino());
        assertEquals(icmsValorTotalUfRemetente, entity.getIcmsValorTotalUfRemetente());
        assertEquals(fcpValorTotal, entity.getFcpValorTotal());
        assertEquals(icmsBaseCalculoSt, entity.getIcmsBaseCalculoSt());
        assertEquals(icmsValorTotalSt, entity.getIcmsValorTotalSt());
        assertEquals(fcpValorTotalSt, entity.getFcpValorTotalSt());
        assertEquals(fcpValorTotalRetidoSt, entity.getFcpValorTotalRetidoSt());
        assertEquals(valorProdutos, entity.getValorProdutos());
        assertEquals(valorFrete, entity.getValorFrete());
        assertEquals(valorSeguro, entity.getValorSeguro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(valorTotalII, entity.getValorTotalII());
        assertEquals(valorIpi, entity.getValorIpi());
        assertEquals(valorIpiDevolvido, entity.getValorIpiDevolvido());
        assertEquals(valorPis, entity.getValorPis());
        assertEquals(valorCofins, entity.getValorCofins());
        assertEquals(valorOutrasDespesas, entity.getValorOutrasDespesas());
        assertEquals(valorTotal, entity.getValorTotal());
        assertEquals(valorTotalTributos, entity.getValorTotalTributos());
        assertEquals(valorTotalServicos, entity.getValorTotalServicos());
        assertEquals(issqnBaseCalculo, entity.getIssqnBaseCalculo());
        assertEquals(issqnValorTotal, entity.getIssqnValorTotal());
        assertEquals(valorPisServicos, entity.getValorPisServicos());
        assertEquals(valorCofinsServicos, entity.getValorCofinsServicos());
        assertEquals(dataPrestacaoServico, entity.getDataPrestacaoServico());
        assertEquals(issqnValorTotalDeducao, entity.getIssqnValorTotalDeducao());
        assertEquals(issqnValorTotalOutrasRetencoes, entity.getIssqnValorTotalOutrasRetencoes());
        assertEquals(issqnValorTotalDescontoIncondicionado, entity.getIssqnValorTotalDescontoIncondicionado());
        assertEquals(issqnValorTotalDescontoCondicionado, entity.getIssqnValorTotalDescontoCondicionado());
        assertEquals(issqnValorTotalRetencao, entity.getIssqnValorTotalRetencao());
        assertEquals(codigoRegimeEspecialTributacao, entity.getCodigoRegimeEspecialTributacao());
        assertEquals(pisValorRetido, entity.getPisValorRetido());
        assertEquals(cofinsValorRetido, entity.getCofinsValorRetido());
        assertEquals(csllValorRetido, entity.getCsllValorRetido());
        assertEquals(irrfBaseCalculo, entity.getIrrfBaseCalculo());
        assertEquals(irrfValorRetido, entity.getIrrfValorRetido());
        assertEquals(prevSocialBaseCalculo, entity.getPrevSocialBaseCalculo());
        assertEquals(prevSocialValorRetido, entity.getPrevSocialValorRetido());
        assertEquals(modalidadeFrete, entity.getModalidadeFrete());
        assertEquals(cnpjTransportador, entity.getCnpjTransportador());
        assertEquals(cpfTransportador, entity.getCpfTransportador());
        assertEquals(nomeTransportador, entity.getNomeTransportador());
        assertEquals(inscricaoEstadualTransportador, entity.getInscricaoEstadualTransportador());
        assertEquals(enderecoTransportador, entity.getEnderecoTransportador());
        assertEquals(municipioTransportador, entity.getMunicipioTransportador());
        assertEquals(ufTransportador, entity.getUfTransportador());
        assertEquals(transporteIcmsServico, entity.getTransporteIcmsServico());
        assertEquals(transporteIcmsBaseCalculo, entity.getTransporteIcmsBaseCalculo());
        assertEquals(transporteIcmsAliquota, entity.getTransporteIcmsAliquota());
        assertEquals(transporteIcmsValor, entity.getTransporteIcmsValor());
        assertEquals(transporteIcmsCfop, entity.getTransporteIcmsCfop());
        assertEquals(transporteIcmsCodigoMunicipio, entity.getTransporteIcmsCodigoMunicipio());
        assertEquals(veiculoPlaca, entity.getVeiculoPlaca());
        assertEquals(veiculoUf, entity.getVeiculoUf());
        assertEquals(veiculoRntc, entity.getVeiculoRntc());
        assertEquals(reboques, entity.getReboques());
        assertEquals(veiculoIdentificacaoVagao, entity.getVeiculoIdentificacaoVagao());
        assertEquals(veiculoIdentificacaoBalsa, entity.getVeiculoIdentificacaoBalsa());
        assertEquals(volumes, entity.getVolumes());
        assertEquals(numeroFatura, entity.getNumeroFatura());
        assertEquals(valorOriginalFatura, entity.getValorOriginalFatura());
        assertEquals(valorDescontoFatura, entity.getValorDescontoFatura());
        assertEquals(valorLiquidoFatura, entity.getValorLiquidoFatura());
        assertEquals(duplicatas, entity.getDuplicatas());
        assertEquals(formasPagamento, entity.getFormasPagamento());
        assertEquals(informacoesAdicionaisFisco, entity.getInformacoesAdicionaisFisco());
        assertEquals(informacoesAdicionaisContribuinte, entity.getInformacoesAdicionaisContribuinte());
        assertEquals(ufLocalEmbarque, entity.getUfLocalEmbarque());
        assertEquals(localEmbarque, entity.getLocalEmbarque());
        assertEquals(localDespacho, entity.getLocalDespacho());

        entity = NFeRequisicao.newBuilder()
            .withNaturezaOperacao(naturezaOperacao)
            .withSerie(serie)
            .withNumero(numero)
            .withDataEmissao(dataEmissao)
            .withDataEntradaSaida(dataEntradaSaida)
            .withTipoDocumento(tipoDocumento)
            .withLocalDestino(localDestino)
            .withFinalidadeEmissao(finalidadeEmissao)
            .withConsumidorFinal(consumidorFinal)
            .withPresencaComprador(presencaComprador)
            .withNotasReferenciadas(notasReferenciadas)
            .withCnpjEmitente(cnpjEmitente)
            .withNomeEmitente(nomeEmitente)
            .withNomeFantasiaEmitente(nomeFantasiaEmitente)
            .withLogradouroEmitente(logradouroEmitente)
            .withNumeroEmitente(numeroEmitente)
            .withComplementoEmitente(complementoEmitente)
            .withBairroEmitente(bairroEmitente)
            .withMunicipioEmitente(municipioEmitente)
            .withUfEmitente(ufEmitente)
            .withCepEmitente(cepEmitente)
            .withTelefoneEmitente(telefoneEmitente)
            .withInscricaoEstadualEmitente(inscricaoEstadualEmitente)
            .withInscricaoEstadualStEmitente(inscricaoEstadualStEmitente)
            .withInscricaoMunicipalEmitente(inscricaoMunicipalEmitente)
            .withCnaeFiscalEmitente(cnaeFiscalEmitente)
            .withRegimeTributarioEmitente(regimeTributarioEmitente)
            .withCnpjDestinatario(cnpjDestinatario)
            .withCpfDestinatario(cpfDestinatario)
            .withIdEstrangeiroDestinatario(idEstrangeiroDestinatario)
            .withNomeDestinatario(nomeDestinatario)
            .withLogradouroDestinatario(logradouroDestinatario)
            .withNumeroDestinatario(numeroDestinatario)
            .withComplementoDestinatario(complementoDestinatario)
            .withBairroDestinatario(bairroDestinatario)
            .withCodigoMunicipioDestinatario(codigoMunicipioDestinatario)
            .withMunicipioDestinatario(municipioDestinatario)
            .withUfDestinatario(ufDestinatario)
            .withCepDestinatario(cepDestinatario)
            .withCodigoPaisDestinatario(codigoPaisDestinatario)
            .withPaisDestinatario(paisDestinatario)
            .withTelefoneDestinatario(telefoneDestinatario)
            .withIndicadorInscricaoEstadualDestinatario(indicadorInscricaoEstadualDestinatario)
            .withInscricaoEstadualDestinatario(inscricaoEstadualDestinatario)
            .withInscricaoSuframaDestinatario(inscricaoSuframaDestinatario)
            .withInscricaoMunicipalDestinatario(inscricaoMunicipalDestinatario)
            .withEmailDestinatario(emailDestinatario)
            .withCnpjRetirada(cnpjRetirada)
            .withCpfRetirada(cpfRetirada)
            .withLogradouroRetirada(logradouroRetirada)
            .withNumeroRetirada(numeroRetirada)
            .withComplementoRetirada(complementoRetirada)
            .withBairroRetirada(bairroRetirada)
            .withCodigoMunicipioRetirada(codigoMunicipioRetirada)
            .withMunicipioRetirada(municipioRetirada)
            .withUfRetirada(ufRetirada)
            .withCnpjEntrega(cnpjEntrega)
            .withCpfEntrega(cpfEntrega)
            .withLogradouroEntrega(logradouroEntrega)
            .withNumeroEntrega(numeroEntrega)
            .withComplementoEntrega(complementoEntrega)
            .withBairroEntrega(bairroEntrega)
            .withCodigoMunicipioEntrega(codigoMunicipioEntrega)
            .withMunicipioEntrega(municipioEntrega)
            .withUfEntrega(ufEntrega)
            .withPessoasAutorizadas(pessoasAutorizadas)
            .withItems(items)
            .withIcmsBaseCalculo(icmsBaseCalculo)
            .withIcmsValorTotal(icmsValorTotal)
            .withIcmsValorTotalDesonerado(icmsValorTotalDesonerado)
            .withFcpValorTotalUfDestino(fcpValorTotalUfDestino)
            .withIcmsValorTotalUfDestino(icmsValorTotalUfDestino)
            .withIcmsValorTotalUfRemetente(icmsValorTotalUfRemetente)
            .withFcpValorTotal(fcpValorTotal)
            .withIcmsBaseCalculoSt(icmsBaseCalculoSt)
            .withIcmsValorTotalSt(icmsValorTotalSt)
            .withFcpValorTotalSt(fcpValorTotalSt)
            .withFcpValorTotalRetidoSt(fcpValorTotalRetidoSt)
            .withValorProdutos(valorProdutos)
            .withValorFrete(valorFrete)
            .withValorSeguro(valorSeguro)
            .withValorDesconto(valorDesconto)
            .withValorTotalII(valorTotalII)
            .withValorIpi(valorIpi)
            .withValorIpiDevolvido(valorIpiDevolvido)
            .withValorPis(valorPis)
            .withValorCofins(valorCofins)
            .withValorOutrasDespesas(valorOutrasDespesas)
            .withValorTotal(valorTotal)
            .withValorTotalTributos(valorTotalTributos)
            .withValorTotalServicos(valorTotalServicos)
            .withIssqnBaseCalculo(issqnBaseCalculo)
            .withIssqnValorTotal(issqnValorTotal)
            .withValorPisServicos(valorPisServicos)
            .withValorCofinsServicos(valorCofinsServicos)
            .withDataPrestacaoServico(dataPrestacaoServico)
            .withIssqnValorTotalDeducao(issqnValorTotalDeducao)
            .withIssqnValorTotalOutrasRetencoes(issqnValorTotalOutrasRetencoes)
            .withIssqnValorTotalDescontoIncondicionado(issqnValorTotalDescontoIncondicionado)
            .withIssqnValorTotalDescontoCondicionado(issqnValorTotalDescontoCondicionado)
            .withIssqnValorTotalRetencao(issqnValorTotalRetencao)
            .withCodigoRegimeEspecialTributacao(codigoRegimeEspecialTributacao)
            .withPisValorRetido(pisValorRetido)
            .withCofinsValorRetido(cofinsValorRetido)
            .withCsllValorRetido(csllValorRetido)
            .withIrrfBaseCalculo(irrfBaseCalculo)
            .withIrrfValorRetido(irrfValorRetido)
            .withPrevSocialBaseCalculo(prevSocialBaseCalculo)
            .withPrevSocialValorRetido(prevSocialValorRetido)
            .withModalidadeFrete(modalidadeFrete)
            .withCnpjTransportador(cnpjTransportador)
            .withCpfTransportador(cpfTransportador)
            .withNomeTransportador(nomeTransportador)
            .withInscricaoEstadualTransportador(inscricaoEstadualTransportador)
            .withEnderecoTransportador(enderecoTransportador)
            .withMunicipioTransportador(municipioTransportador)
            .withUfTransportador(ufTransportador)
            .withTransporteIcmsServico(transporteIcmsServico)
            .withTransporteIcmsBaseCalculo(transporteIcmsBaseCalculo)
            .withTransporteIcmsAliquota(transporteIcmsAliquota)
            .withTransporteIcmsValor(transporteIcmsValor)
            .withTransporteIcmsCfop(transporteIcmsCfop)
            .withTransporteIcmsCodigoMunicipio(transporteIcmsCodigoMunicipio)
            .withVeiculoPlaca(veiculoPlaca)
            .withVeiculoUf(veiculoUf)
            .withVeiculoRntc(veiculoRntc)
            .withReboques(reboques)
            .withVeiculoIdentificacaoVagao(veiculoIdentificacaoVagao)
            .withVeiculoIdentificacaoBalsa(veiculoIdentificacaoBalsa)
            .withVolumes(volumes)
            .withNumeroFatura(numeroFatura)
            .withValorOriginalFatura(valorOriginalFatura)
            .withValorDescontoFatura(valorDescontoFatura)
            .withValorLiquidoFatura(valorLiquidoFatura)
            .withDuplicatas(duplicatas)
            .withFormasPagamento(formasPagamento)
            .withInformacoesAdicionaisFisco(informacoesAdicionaisFisco)
            .withInformacoesAdicionaisContribuinte(informacoesAdicionaisContribuinte)
            .withUfLocalEmbarque(ufLocalEmbarque)
            .withLocalEmbarque(localEmbarque)
            .withLocalDespacho(localDespacho)
            .build();

        assertNotNull(entity);
        assertEquals(naturezaOperacao, entity.getNaturezaOperacao());
        assertEquals(serie, entity.getSerie());
        assertEquals(numero, entity.getNumero());
        assertEquals(dataEmissao, entity.getDataEmissao());
        assertEquals(dataEntradaSaida, entity.getDataEntradaSaida());
        assertEquals(tipoDocumento, entity.getTipoDocumento());
        assertEquals(localDestino, entity.getLocalDestino());
        assertEquals(finalidadeEmissao, entity.getFinalidadeEmissao());
        assertEquals(consumidorFinal, entity.getConsumidorFinal());
        assertEquals(presencaComprador, entity.getPresencaComprador());
        assertEquals(notasReferenciadas, entity.getNotasReferenciadas());
        assertEquals(cnpjEmitente, entity.getCnpjEmitente());
        assertEquals(nomeEmitente, entity.getNomeEmitente());
        assertEquals(nomeFantasiaEmitente, entity.getNomeFantasiaEmitente());
        assertEquals(logradouroEmitente, entity.getLogradouroEmitente());
        assertEquals(numeroEmitente, entity.getNumeroEmitente());
        assertEquals(complementoEmitente, entity.getComplementoEmitente());
        assertEquals(bairroEmitente, entity.getBairroEmitente());
        assertEquals(municipioEmitente, entity.getMunicipioEmitente());
        assertEquals(ufEmitente, entity.getUfEmitente());
        assertEquals(cepEmitente, entity.getCepEmitente());
        assertEquals(telefoneEmitente, entity.getTelefoneEmitente());
        assertEquals(inscricaoEstadualEmitente, entity.getInscricaoEstadualEmitente());
        assertEquals(inscricaoEstadualStEmitente, entity.getInscricaoEstadualStEmitente());
        assertEquals(inscricaoMunicipalEmitente, entity.getInscricaoMunicipalEmitente());
        assertEquals(cnaeFiscalEmitente, entity.getCnaeFiscalEmitente());
        assertEquals(regimeTributarioEmitente, entity.getRegimeTributarioEmitente());
        assertEquals(cnpjDestinatario, entity.getCnpjDestinatario());
        assertEquals(cpfDestinatario, entity.getCpfDestinatario());
        assertEquals(idEstrangeiroDestinatario, entity.getIdEstrangeiroDestinatario());
        assertEquals(nomeDestinatario, entity.getNomeDestinatario());
        assertEquals(logradouroDestinatario, entity.getLogradouroDestinatario());
        assertEquals(numeroDestinatario, entity.getNumeroDestinatario());
        assertEquals(complementoDestinatario, entity.getComplementoDestinatario());
        assertEquals(bairroDestinatario, entity.getBairroDestinatario());
        assertEquals(codigoMunicipioDestinatario, entity.getCodigoMunicipioDestinatario());
        assertEquals(municipioDestinatario, entity.getMunicipioDestinatario());
        assertEquals(ufDestinatario, entity.getUfDestinatario());
        assertEquals(cepDestinatario, entity.getCepDestinatario());
        assertEquals(codigoPaisDestinatario, entity.getCodigoPaisDestinatario());
        assertEquals(paisDestinatario, entity.getPaisDestinatario());
        assertEquals(telefoneDestinatario, entity.getTelefoneDestinatario());
        assertEquals(indicadorInscricaoEstadualDestinatario, entity.getIndicadorInscricaoEstadualDestinatario());
        assertEquals(inscricaoEstadualDestinatario, entity.getInscricaoEstadualDestinatario());
        assertEquals(inscricaoSuframaDestinatario, entity.getInscricaoSuframaDestinatario());
        assertEquals(inscricaoMunicipalDestinatario, entity.getInscricaoMunicipalDestinatario());
        assertEquals(emailDestinatario, entity.getEmailDestinatario());
        assertEquals(cnpjRetirada, entity.getCnpjRetirada());
        assertEquals(cpfRetirada, entity.getCpfRetirada());
        assertEquals(logradouroRetirada, entity.getLogradouroRetirada());
        assertEquals(numeroRetirada, entity.getNumeroRetirada());
        assertEquals(complementoRetirada, entity.getComplementoRetirada());
        assertEquals(bairroRetirada, entity.getBairroRetirada());
        assertEquals(codigoMunicipioRetirada, entity.getCodigoMunicipioRetirada());
        assertEquals(municipioRetirada, entity.getMunicipioRetirada());
        assertEquals(ufRetirada, entity.getUfRetirada());
        assertEquals(cnpjEntrega, entity.getCnpjEntrega());
        assertEquals(cpfEntrega, entity.getCpfEntrega());
        assertEquals(logradouroEntrega, entity.getLogradouroEntrega());
        assertEquals(numeroEntrega, entity.getNumeroEntrega());
        assertEquals(complementoEntrega, entity.getComplementoEntrega());
        assertEquals(bairroEntrega, entity.getBairroEntrega());
        assertEquals(codigoMunicipioEntrega, entity.getCodigoMunicipioEntrega());
        assertEquals(municipioEntrega, entity.getMunicipioEntrega());
        assertEquals(ufEntrega, entity.getUfEntrega());
        assertEquals(pessoasAutorizadas, entity.getPessoasAutorizadas());
        assertEquals(items, entity.getItems());
        assertEquals(icmsBaseCalculo, entity.getIcmsBaseCalculo());
        assertEquals(icmsValorTotal, entity.getIcmsValorTotal());
        assertEquals(icmsValorTotalDesonerado, entity.getIcmsValorTotalDesonerado());
        assertEquals(fcpValorTotalUfDestino, entity.getFcpValorTotalUfDestino());
        assertEquals(icmsValorTotalUfDestino, entity.getIcmsValorTotalUfDestino());
        assertEquals(icmsValorTotalUfRemetente, entity.getIcmsValorTotalUfRemetente());
        assertEquals(fcpValorTotal, entity.getFcpValorTotal());
        assertEquals(icmsBaseCalculoSt, entity.getIcmsBaseCalculoSt());
        assertEquals(icmsValorTotalSt, entity.getIcmsValorTotalSt());
        assertEquals(fcpValorTotalSt, entity.getFcpValorTotalSt());
        assertEquals(fcpValorTotalRetidoSt, entity.getFcpValorTotalRetidoSt());
        assertEquals(valorProdutos, entity.getValorProdutos());
        assertEquals(valorFrete, entity.getValorFrete());
        assertEquals(valorSeguro, entity.getValorSeguro());
        assertEquals(valorDesconto, entity.getValorDesconto());
        assertEquals(valorTotalII, entity.getValorTotalII());
        assertEquals(valorIpi, entity.getValorIpi());
        assertEquals(valorIpiDevolvido, entity.getValorIpiDevolvido());
        assertEquals(valorPis, entity.getValorPis());
        assertEquals(valorCofins, entity.getValorCofins());
        assertEquals(valorOutrasDespesas, entity.getValorOutrasDespesas());
        assertEquals(valorTotal, entity.getValorTotal());
        assertEquals(valorTotalTributos, entity.getValorTotalTributos());
        assertEquals(valorTotalServicos, entity.getValorTotalServicos());
        assertEquals(issqnBaseCalculo, entity.getIssqnBaseCalculo());
        assertEquals(issqnValorTotal, entity.getIssqnValorTotal());
        assertEquals(valorPisServicos, entity.getValorPisServicos());
        assertEquals(valorCofinsServicos, entity.getValorCofinsServicos());
        assertEquals(dataPrestacaoServico, entity.getDataPrestacaoServico());
        assertEquals(issqnValorTotalDeducao, entity.getIssqnValorTotalDeducao());
        assertEquals(issqnValorTotalOutrasRetencoes, entity.getIssqnValorTotalOutrasRetencoes());
        assertEquals(issqnValorTotalDescontoIncondicionado, entity.getIssqnValorTotalDescontoIncondicionado());
        assertEquals(issqnValorTotalDescontoCondicionado, entity.getIssqnValorTotalDescontoCondicionado());
        assertEquals(issqnValorTotalRetencao, entity.getIssqnValorTotalRetencao());
        assertEquals(codigoRegimeEspecialTributacao, entity.getCodigoRegimeEspecialTributacao());
        assertEquals(pisValorRetido, entity.getPisValorRetido());
        assertEquals(cofinsValorRetido, entity.getCofinsValorRetido());
        assertEquals(csllValorRetido, entity.getCsllValorRetido());
        assertEquals(irrfBaseCalculo, entity.getIrrfBaseCalculo());
        assertEquals(irrfValorRetido, entity.getIrrfValorRetido());
        assertEquals(prevSocialBaseCalculo, entity.getPrevSocialBaseCalculo());
        assertEquals(prevSocialValorRetido, entity.getPrevSocialValorRetido());
        assertEquals(modalidadeFrete, entity.getModalidadeFrete());
        assertEquals(cnpjTransportador, entity.getCnpjTransportador());
        assertEquals(cpfTransportador, entity.getCpfTransportador());
        assertEquals(nomeTransportador, entity.getNomeTransportador());
        assertEquals(inscricaoEstadualTransportador, entity.getInscricaoEstadualTransportador());
        assertEquals(enderecoTransportador, entity.getEnderecoTransportador());
        assertEquals(municipioTransportador, entity.getMunicipioTransportador());
        assertEquals(ufTransportador, entity.getUfTransportador());
        assertEquals(transporteIcmsServico, entity.getTransporteIcmsServico());
        assertEquals(transporteIcmsBaseCalculo, entity.getTransporteIcmsBaseCalculo());
        assertEquals(transporteIcmsAliquota, entity.getTransporteIcmsAliquota());
        assertEquals(transporteIcmsValor, entity.getTransporteIcmsValor());
        assertEquals(transporteIcmsCfop, entity.getTransporteIcmsCfop());
        assertEquals(transporteIcmsCodigoMunicipio, entity.getTransporteIcmsCodigoMunicipio());
        assertEquals(veiculoPlaca, entity.getVeiculoPlaca());
        assertEquals(veiculoUf, entity.getVeiculoUf());
        assertEquals(veiculoRntc, entity.getVeiculoRntc());
        assertEquals(reboques, entity.getReboques());
        assertEquals(veiculoIdentificacaoVagao, entity.getVeiculoIdentificacaoVagao());
        assertEquals(veiculoIdentificacaoBalsa, entity.getVeiculoIdentificacaoBalsa());
        assertEquals(volumes, entity.getVolumes());
        assertEquals(numeroFatura, entity.getNumeroFatura());
        assertEquals(valorOriginalFatura, entity.getValorOriginalFatura());
        assertEquals(valorDescontoFatura, entity.getValorDescontoFatura());
        assertEquals(valorLiquidoFatura, entity.getValorLiquidoFatura());
        assertEquals(duplicatas, entity.getDuplicatas());
        assertEquals(formasPagamento, entity.getFormasPagamento());
        assertEquals(informacoesAdicionaisFisco, entity.getInformacoesAdicionaisFisco());
        assertEquals(informacoesAdicionaisContribuinte, entity.getInformacoesAdicionaisContribuinte());
        assertEquals(ufLocalEmbarque, entity.getUfLocalEmbarque());
        assertEquals(localEmbarque, entity.getLocalEmbarque());
        assertEquals(localDespacho, entity.getLocalDespacho());
    }

//    @Test
//    public void testBeanValidation() throws Exception {
//        String naturezaOperacao;
//        OffsetDateTime dataEmissao;
//        NFeTipoDocumentoEnum tipoDocumento;
//        NFeLocalDestinoEnum localDestino;
//        NFeFinalidadeEmissaoEnum finalidadeEmissao;
//        NFeConsumidorFinalEnum consumidorFinal;
//        NFePresencaCompradorEnum presencaComprador;
//        String cnpjEmitente;
//        String logradouroEmitente;
//        String numeroEmitente;
//        String bairroEmitente;
//        String municipioEmitente;
//        NFeUnidadeFederativaEnum ufEmitente;
//        String inscricaoEstadualEmitente;
//        NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente;
//        String cpfDestinatario;
//        String nomeDestinatario;
//        String logradouroDestinatario;
//        String numeroDestinatario;
//        String complementoDestinatario;
//        String bairroDestinatario;
//        String municipioDestinatario;
//        NFeUnidadeFederativaEnum ufDestinatario;
//        NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario;
//        NFeModalidadeFreteEnum modalidadeFrete;
//
//        NFeRequisicao entity = NFeRequisicao.newBuilder()
//            .build();
//        FocusNFeUtils.throwBeanValidation(entity);
//    }

    @Test(expectedExceptions = {ConstraintViolationException.class})
    public void testBeanValidationWithError() throws Exception {
        NFeRequisicao entity = new NFeRequisicao();
        FocusNFeUtils.throwBeanValidation(entity);
    }
}
