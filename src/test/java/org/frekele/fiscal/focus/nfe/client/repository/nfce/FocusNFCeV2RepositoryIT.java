package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsOrigemEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIcmsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIncluiNoTotalEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeIndicadorInscricaoEstadualDestinatarioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModalidadeFreteEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePisCofinsSituacaoTributariaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFePresencaCompradorEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeTipoDocumentoEnum;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeEnvioRequisicaoNotaFiscal;
import org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal.NFeItem;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeInutilizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeAutorizarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeCancelarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeConsultarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.body.NFCeInutilizarBodyResponse;
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
public class FocusNFCeV2RepositoryIT {

    private FocusNFCeV2Repository repository;

    private String cnpjEmitente;

    private String reference;

    NFeEnvioRequisicaoNotaFiscal nfce;

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
        repository = new FocusNFCeV2RepositoryImpl(client, auth);

        reference = UUID.randomUUID().toString();
        System.out.println("Reference: " + reference);

        nfce = NFeEnvioRequisicaoNotaFiscal.newBuilder()
            .withNaturezaOperacao("VENDA DE MERCADORIA")
            .withTipoDocumento(NFeTipoDocumentoEnum.NOTA_FISCAL_SAIDA)
            .withDataEmissao(OffsetDateTime.now())
            .withIndicadorInscricaoEstadualDestinatario(NFeIndicadorInscricaoEstadualDestinatarioEnum.NAO_CONTRIBUINTE)
            .withPresencaComprador(NFePresencaCompradorEnum.OPERACAO_PRESENCIAL)
            .withCnpjEmitente(cnpjEmitente)
            .withModalidadeFrete(NFeModalidadeFreteEnum.SEM_FRETE)
            .withItems(new ArrayList<>())
            .build();
        NFeItem item = NFeItem.newBuilder()
            .withNumeroItem("1")
            .withCodigoProduto("XYZ-12345")
            .withDescricao("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
            .withCfop("5102")
            .withCodigoNcm("94036000")
            .withUnidadeComercial("UN")
            .withQuantidadeComercial(BigDecimal.valueOf(1))
            .withValorUnitarioComercial(new BigDecimal("245.85"))
            .withUnidadeTributavel("UN")
            .withQuantidadeTributavel(BigDecimal.valueOf(1))
            .withValorUnitarioTributavel(new BigDecimal("245.85"))
            .withValorBruto(new BigDecimal("245.85"))
            .withIcmsSituacaoTributaria(NFeIcmsSituacaoTributariaEnum.TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_CREDITO)
            .withIcmsOrigem(NFeIcmsOrigemEnum.NACIONAL)
            .withPisSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
            .withCofinsSituacaoTributaria(NFePisCofinsSituacaoTributariaEnum.OPERACAO_ISENTA_DA_CONTRIBUICAO)
            .withIncluiNoTotal(NFeIncluiNoTotalEnum.SIM)
            .build();
        nfce.getItems().add(item);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 3 seg, for prevent Error.
        FocusTestNGUtils.sleep(3);
    }

    @Test
    public void testAutorizar() throws Exception {
        System.out.println("Reference: " + reference);
        NFCeAutorizarBodyRequest bodyRequest = NFCeAutorizarBodyRequest.newBuilder().withNfce(nfce).build();
        NFCeAutorizarResponse response = repository.autorizar(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeAutorizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testAutorizar")
    public void testEnviarEmail() throws Exception {
        System.out.println("Reference: " + reference);
        NFCeEmailBodyRequest bodyRequest = NFCeEmailBodyRequest.newBuilder()
            .withEmails("testexyz12345@teste.com.br")
            .build();
        NFCeEmailResponse response = repository.enviarEmail(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
    }

    @Test(dependsOnMethods = "testEnviarEmail")
    public void testCancelar() throws Exception {
        System.out.println("Reference: " + reference);
        NFCeCancelarBodyRequest bodyRequest = NFCeCancelarBodyRequest.newBuilder()
            .withJustificativa("bla bla bla bla bla bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFCeCancelarResponse response = repository.cancelar(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeCancelarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testCancelar")
    public void testConsultar() throws Exception {
        System.out.println("Reference: " + reference);
        NFCeConsultarResponse response = repository.consultar(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testConsultar")
    public void testConsultarNFeCompleta() throws Exception {
        System.out.println("Reference: " + reference);
        NFCeConsultarResponse response = repository.consultarNFeCompleta(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
        System.out.println("Body.Status.ProtocoloNotaFiscal.Motivo: " + bodyResponse.getProtocoloNotaFiscal().getMotivo());
    }

    @Test(dependsOnMethods = "testConsultarNFeCompleta")
    public void testInutilizar() throws Exception {
        NFCeInutilizarBodyRequest bodyRequest = NFCeInutilizarBodyRequest.newBuilder()
            .withCnpj(cnpjEmitente)
            .withSerie("1")
            .withNumeroInicial("2")
            .withNumeroFinal("4")
            .withJustificativa("bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFCeInutilizarResponse response = repository.inutilizar(bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeInutilizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testInutilizar", expectedExceptions = ClientErrorException.class)
    public void testInutilizarWithError() throws Exception {
        NFCeInutilizarBodyRequest bodyRequest = NFCeInutilizarBodyRequest.newBuilder()
            .withCnpj("10000000000001")
            .withSerie("1")
            .withNumeroInicial("2")
            .withNumeroFinal("4")
            .withJustificativa("bla bla bla bla bla bla bla bla bla Teste")
            .build();
        NFCeInutilizarResponse response = repository.inutilizar(bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeInutilizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testInutilizarWithError")
    public void testAutorizarConsultarNFeCompleta() throws Exception {
        String reference = UUID.randomUUID().toString();
        System.out.println("Reference: " + reference);
        NFCeAutorizarBodyRequest bodyRequest = NFCeAutorizarBodyRequest.newBuilder().withNfce(nfce).build();
        NFCeAutorizarResponse response = repository.autorizarConsultarNFeCompleta(reference, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFCeAutorizarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }
}
