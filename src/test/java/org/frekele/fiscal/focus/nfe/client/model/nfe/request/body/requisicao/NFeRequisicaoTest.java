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
        String naturezaOperacao = "";
        String serie = "";
        String numero = "";
        OffsetDateTime dataEmissao = OffsetDateTime.now();
        OffsetDateTime dataEntradaSaida = OffsetDateTime.now().plusHours(4);
        NFeTipoDocumentoEnum tipoDocumento = NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA;
        NFeLocalDestinoEnum localDestino = NFeLocalDestinoEnum.OPERACAO_INTERNA;
        NFeFinalidadeEmissaoEnum finalidadeEmissao = NFeFinalidadeEmissaoEnum.NOTA_NORMAL;
        NFeConsumidorFinalEnum consumidorFinal = NFeConsumidorFinalEnum.CONSUMIDOR_FINAL;
        NFePresencaCompradorEnum presencaComprador = NFePresencaCompradorEnum.OPERACAO_PRESENCIAL;
        List<NFeNotaReferenciada> notasReferenciadas = new ArrayList<>();
        notasReferenciadas.add(new NFeNotaReferenciada());
        String cnpjEmitente = "";
        String nomeEmitente = "";
        String nomeFantasiaEmitente = "";
        String logradouroEmitente = "";
        String numeroEmitente = "";
        String complementoEmitente = "";
        String bairroEmitente = "";
        String municipioEmitente = "";
        NFeUnidadeFederativaEnum ufEmitente = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cepEmitente = "";
        String telefoneEmitente = "";
        String inscricaoEstadualEmitente = "";
        String inscricaoEstadualStEmitente = "";
        String inscricaoMunicipalEmitente = "";
        String cnaeFiscalEmitente = "";
        NFeRegimeTributarioEmitenteEnum regimeTributarioEmitente = NFeRegimeTributarioEmitenteEnum.SIMPLES_NACIONAL;
        String cnpjDestinatario = "";
        String cpfDestinatario = "";
        String idEstrangeiroDestinatario = "";
        String nomeDestinatario = "";
        String logradouroDestinatario = "";
        String numeroDestinatario = "";
        String complementoDestinatario = "";
        String bairroDestinatario = "";
        String codigoMunicipioDestinatario = "";
        String municipioDestinatario = "";
        NFeUnidadeFederativaEnum ufDestinatario = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cepDestinatario = "";
        String codigoPaisDestinatario = "";
        String paisDestinatario = "";
        String telefoneDestinatario = "";
        NFeIndicadorInscricaoEstadualDestinatarioEnum indicadorInscricaoEstadualDestinatario = NFeIndicadorInscricaoEstadualDestinatarioEnum.CONTRIBUINTE;
        String inscricaoEstadualDestinatario = "";
        String inscricaoSuframaDestinatario = "";
        String inscricaoMunicipalDestinatario = "";
        String emailDestinatario = "";
        String cnpjRetirada = "";
        String cpfRetirada = "";
        String logradouroRetirada = "";
        String numeroRetirada = "";
        String complementoRetirada = "";
        String bairroRetirada = "";
        String codigoMunicipioRetirada = "";
        String municipioRetirada = "";
        NFeUnidadeFederativaEnum ufRetirada = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String cnpjEntrega = "";
        String cpfEntrega = "";
        String logradouroEntrega = "";
        String numeroEntrega = "";
        String complementoEntrega = "";
        String bairroEntrega = "";
        String codigoMunicipioEntrega = "";
        String municipioEntrega = "";
        NFeUnidadeFederativaEnum ufEntrega = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        List<NFePessoaAutorizada> pessoasAutorizadas = new ArrayList<>();
        pessoasAutorizadas.add(new NFePessoaAutorizada());
        List<NFeItem> items = new ArrayList<>();
        items.add(new NFeItem());
        BigDecimal icmsBaseCalculo = new BigDecimal("0.0");
        BigDecimal icmsValorTotal = new BigDecimal("0.0");
        BigDecimal icmsValorTotalDesonerado = new BigDecimal("0.0");
        BigDecimal fcpValorTotalUfDestino = new BigDecimal("0.0");
        BigDecimal icmsValorTotalUfDestino = new BigDecimal("0.0");
        BigDecimal icmsValorTotalUfRemetente = new BigDecimal("0.0");
        BigDecimal fcpValorTotal = new BigDecimal("0.0");
        BigDecimal icmsBaseCalculoSt = new BigDecimal("0.0");
        BigDecimal icmsValorTotalSt = new BigDecimal("0.0");
        BigDecimal fcpValorTotalSt = new BigDecimal("0.0");
        BigDecimal fcpValorTotalRetidoSt = new BigDecimal("0.0");
        BigDecimal valorProdutos = new BigDecimal("0.0");
        BigDecimal valorFrete = new BigDecimal("0.0");
        BigDecimal valorSeguro = new BigDecimal("0.0");
        BigDecimal valorDesconto = new BigDecimal("0.0");
        BigDecimal valorTotalII = new BigDecimal("0.0");
        BigDecimal valorIpi = new BigDecimal("0.0");
        BigDecimal valorIpiDevolvido = new BigDecimal("0.0");
        BigDecimal valorPis = new BigDecimal("0.0");
        BigDecimal valorCofins = new BigDecimal("0.0");
        BigDecimal valorOutrasDespesas = new BigDecimal("0.0");
        BigDecimal valorTotal = new BigDecimal("0.0");
        BigDecimal valorTotalTributos = new BigDecimal("0.0");
        BigDecimal valorTotalServicos = new BigDecimal("0.0");
        BigDecimal issqnBaseCalculo = new BigDecimal("0.0");
        BigDecimal issqnValorTotal = new BigDecimal("0.0");
        BigDecimal valorPisServicos = new BigDecimal("0.0");
        BigDecimal valorCofinsServicos = new BigDecimal("0.0");
        LocalDate dataPrestacaoServico = LocalDate.parse("2018-04-20");
        BigDecimal issqnValorTotalDeducao = new BigDecimal("0.0");
        BigDecimal issqnValorTotalOutrasRetencoes = new BigDecimal("0.0");
        BigDecimal issqnValorTotalDescontoIncondicionado = new BigDecimal("0.0");
        BigDecimal issqnValorTotalDescontoCondicionado = new BigDecimal("0.0");
        BigDecimal issqnValorTotalRetencao = new BigDecimal("0.0");
        NFeCodigoRegimeEspecialTributacaoEnum codigoRegimeEspecialTributacao = NFeCodigoRegimeEspecialTributacaoEnum.MICROEMPRESARIO_E_EMPRESA_PEQUENO_PORTE_ME_EPP;
        BigDecimal pisValorRetido = new BigDecimal("0.0");
        BigDecimal cofinsValorRetido = new BigDecimal("0.0");
        BigDecimal csllValorRetido = new BigDecimal("0.0");
        BigDecimal irrfBaseCalculo = new BigDecimal("0.0");
        BigDecimal irrfValorRetido = new BigDecimal("0.0");
        BigDecimal prevSocialBaseCalculo = new BigDecimal("0.0");
        BigDecimal prevSocialValorRetido = new BigDecimal("0.0");
        NFeModalidadeFreteEnum modalidadeFrete = NFeModalidadeFreteEnum.POR_CONTA_EMITENTE;
        String cnpjTransportador = "";
        String cpfTransportador = "";
        String nomeTransportador = "";
        String inscricaoEstadualTransportador = "";
        String enderecoTransportador = "";
        String municipioTransportador = "";
        NFeUnidadeFederativaEnum ufTransportador = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        BigDecimal transporteIcmsServico = new BigDecimal("0.0");
        BigDecimal transporteIcmsBaseCalculo = new BigDecimal("0.0");
        BigDecimal transporteIcmsAliquota = new BigDecimal("0.0");
        BigDecimal transporteIcmsValor = new BigDecimal("0.0");
        String transporteIcmsCfop = "";
        String transporteIcmsCodigoMunicipio = "";
        String veiculoPlaca = "";
        NFeUnidadeFederativaEnum veiculoUf = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String veiculoRntc = "";
        List<NFeReboque> reboques = new ArrayList<>();
        reboques.add(new NFeReboque());
        String veiculoIdentificacaoVagao = "";
        String veiculoIdentificacaoBalsa = "";
        List<NFeVolumeTransportado> volumes = new ArrayList<>();
        volumes.add(new NFeVolumeTransportado());
        String numeroFatura = "";
        BigDecimal valorOriginalFatura = new BigDecimal("0.0");
        BigDecimal valorDescontoFatura = new BigDecimal("0.0");
        BigDecimal valorLiquidoFatura = new BigDecimal("0.0");
        List<NFeDuplicataNotaFiscal> duplicatas = new ArrayList<>();
        duplicatas.add(new NFeDuplicataNotaFiscal());
        List<NFeFormaPagamento> formasPagamento = new ArrayList<>();
        formasPagamento.add(new NFeFormaPagamento());
        String informacoesAdicionaisFisco = "";
        String informacoesAdicionaisContribuinte = "";
        NFeUnidadeFederativaEnum ufLocalEmbarque = NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL;
        String localEmbarque = "";
        String localDespacho = "";

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
