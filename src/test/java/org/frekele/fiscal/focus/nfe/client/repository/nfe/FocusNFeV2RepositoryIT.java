package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFinalidadeEmissaoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsOrigemEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIncluiNoTotalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModalidadeFreteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePisCofinsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoDocumentoEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeEnvioRequisicaoNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeItem;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCCeBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCCeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeInutilizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeAutorizarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeCCeBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeCancelarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeConsultarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeInutilizarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.testng.FocusTestNGUtils;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.ws.rs.ClientErrorException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeV2RepositoryIT {

    private FocusNFeV2Repository repository;

    private String cnpjEmitente;

    private String reference;

    @BeforeClass
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        cnpjEmitente = System.getenv("FOCUS_NFE_CNPJ_EMITENTE");
        String accessToken = System.getenv("FOCUS_NFE_ACCESS_TOKEN");
        EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;
        FocusNFeAuth auth = FocusNFeAuth.newBuilder()
            .withAccessToken(accessToken)
            .withEnvironment(environment)
            .build();
        ResteasyClient client = new ResteasyClientBuilder().build();
        repository = new FocusNFeV2RepositoryImpl(client, auth);

        reference = UUID.randomUUID().toString();
        System.out.println("Reference: " + reference);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 2 seg, for prevent Error.
        FocusTestNGUtils.sleep(2);
    }

    @Test
    public void testAutorizar() throws Exception {
        System.out.println("Reference: " + reference);
        NFeEnvioRequisicaoNotaFiscal nfe = NFeEnvioRequisicaoNotaFiscal.newBuilder()
            .withNaturezaOperacao("VENDA DE MERCADORIA")
            .withDataEmissao(OffsetDateTime.now())
            .withTipoDocumento(NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA)
            .withFinalidadeEmissao(NFeFinalidadeEmissaoEnum.NOTA_NORMAL)
            .withCnpjEmitente(cnpjEmitente)
            .withNomeDestinatario("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
            .withCpfDestinatario("98445556550")
            .withTelefoneDestinatario("5196185555")
            .withLogradouroDestinatario("Av Otto Niemeyer")
            .withNumeroDestinatario("600")
            .withBairroDestinatario("Tristeza")
            .withMunicipioDestinatario("Porto Alegre")
            .withUfDestinatario(NFeUnidadeFederativaEnum.RIO_GRANDE_DO_SUL)
            .withCepDestinatario("91910-001")
            .withModalidadeFrete(NFeModalidadeFreteEnum.POR_CONTA_EMITENTE)
            .withItems(new ArrayList<>())
            .build();
        NFeItem item = NFeItem.newBuilder()
            .withNumeroItem("1")
            .withCodigoProduto("XYZ-12345")
            .withDescricao("Produto Teste 12345 XYZ")
            .withCfop("5102")
            .withCodigoNcm("94036000")
            .withUnidadeComercial("UN")
            .withQuantidadeComercial(BigDecimal.valueOf(1))
            .withValorUnitarioComercial(new BigDecimal("124.35"))
            .withUnidadeTributavel("UN")
            .withQuantidadeTributavel(BigDecimal.valueOf(1))
            .withValorUnitarioTributavel(new BigDecimal("124.35"))
            .withValorBruto(new BigDecimal("124.35"))
            .withIcmsSituacaoTributaria(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO)
            .withIcmsOrigem(NFeIcmsOrigemEnum.NACIONAL)
            .withPisSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
            .withCofinsSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
            .withIncluiNoTotal(NFeIncluiNoTotalEnum.SIM)
            .build();
        nfe.getItems().add(item);

        NFeAutorizarBodyRequest bodyRequest = NFeAutorizarBodyRequest.newBuilder().withNfe(nfe).build();
        NFeAutorizarResponse response = repository.autorizar(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeAutorizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());

        //After Method Sleep 20 seg, for prevent Error.
        System.out.println("Sleep 20seg");
        FocusTestNGUtils.sleep(20);
    }

    @Test(dependsOnMethods = "testAutorizar")
    public void testEmitirCCe() throws Exception {
        System.out.println("Reference: " + reference);
        NFeCCeBodyRequest bodyRequest = NFeCCeBodyRequest.newBuilder()
            .withCorrecao("bla bla bla bla bla bla bla bla bla bla CCe1")
            .build();
        NFeCCeResponse response = repository.emitirCCe(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeCCeBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testEmitirCCe")
    public void testEmitirCCe2() throws Exception {
        System.out.println("Reference: " + reference);
        NFeCCeBodyRequest bodyRequest = NFeCCeBodyRequest.newBuilder()
            .withCorrecao("bla bla bla bla bla bla bla bla bla bla bla bla bla CCe2")
            .build();
        NFeCCeResponse response = repository.emitirCCe(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeCCeBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testEmitirCCe2")
    public void testEnviarEmail() throws Exception {
        System.out.println("Reference: " + reference);
        NFeEmailBodyRequest bodyRequest = NFeEmailBodyRequest.newBuilder()
            .withEmails("testexyz12345@teste.com.br")
            .build();
        NFeEmailResponse response = repository.enviarEmail(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
    }

    @Test(dependsOnMethods = "testEnviarEmail")
    public void testCancelar() throws Exception {
        System.out.println("Reference: " + reference);
        NFeCancelarBodyRequest bodyRequest = NFeCancelarBodyRequest.newBuilder()
            .withJustificativa("bla bla bla bla bla bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFeCancelarResponse response = repository.cancelar(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeCancelarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testCancelar")
    public void testConsultar() throws Exception {
        System.out.println("Reference: " + reference);
        NFeConsultarResponse response = repository.consultar(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testConsultar")
    public void testConsultarNFeCompleta() throws Exception {
        System.out.println("Reference: " + reference);
        NFeConsultarResponse response = repository.consultarNFeCompleta(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
        System.out.println("Body.Status.ProtocoloNotaFiscal.Motivo: " + bodyResponse.getProtocoloNotaFiscal().getMotivo());
    }

    @Test(dependsOnMethods = "testConsultarNFeCompleta")
    public void testInutilizar() throws Exception {
        NFeInutilizarBodyRequest bodyRequest = NFeInutilizarBodyRequest.newBuilder()
            .withCnpj(cnpjEmitente)
            .withSerie("1")
            .withNumeroInicial("2")
            .withNumeroFinal("4")
            .withJustificativa("bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFeInutilizarResponse response = repository.inutilizar(bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeInutilizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testInutilizar", expectedExceptions = ClientErrorException.class)
    public void testInutilizarWithError() throws Exception {
        NFeInutilizarBodyRequest bodyRequest = NFeInutilizarBodyRequest.newBuilder()
            .withCnpj("10000000000001")
            .withSerie("1")
            .withNumeroInicial("2")
            .withNumeroFinal("4")
            .withJustificativa("bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFeInutilizarResponse response = repository.inutilizar(bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeInutilizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testInutilizarWithError")
    public void testAutorizar2() throws Exception {
        reference = UUID.randomUUID().toString();
        System.out.println("Reference: " + reference);
        testAutorizar();
    }
}
