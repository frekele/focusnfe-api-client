package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.enumeration.MDeTipoManifestacaoEnum;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseManifestosReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.model.request.mde.MDeManifestarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarNFeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarUltimoManifestoResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeDownloadXmlResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeManifestarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeConsultarManifestosBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeConsultarNFeBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeConsultarUltimoManifestoBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeManifestarBodyResponse;
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

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusMDeV2RepositoryIT {

    private FocusMDeV2Repository repository;

    private String cnpjEmitente;

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
        ResteasyClient client = new ResteasyClientBuilder()
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(ResponseManifestosReplaceFilter.class)
            .build();
        repository = new FocusMDeV2RepositoryImpl(client, auth);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 2 seg, for prevent Error.
        FocusTestNGUtils.sleep(2);
    }

    @Test(expectedExceptions = ClientErrorException.class)
    public void testManifestar() {
        String chaveNFe = "41180603918468000158550010000000251406642480";
        MDeManifestarBodyRequest bodyRequest = MDeManifestarBodyRequest.newBuilder()
            .withTipo(MDeTipoManifestacaoEnum.CIENCIA)
            .build();
        MDeManifestarResponse response = repository.manifestar(chaveNFe, bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeManifestarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test(dependsOnMethods = "testManifestar")
    public void testConsultarManifestos() throws Exception {
        MDeConsultarManifestosResponse response = repository.consultarManifestos(cnpjEmitente);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarManifestosBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifestos.size: " + bodyResponse.getManifestos().size());
    }

    @Test(dependsOnMethods = "testConsultarManifestos")
    public void testConsultarManifestosWithVersao() throws Exception {
        MDeConsultarManifestosResponse response = repository.consultarManifestos(cnpjEmitente, 40);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarManifestosBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifestos.size: " + bodyResponse.getManifestos().size());
    }

    @Test(dependsOnMethods = "testConsultarManifestosWithVersao")
    public void testConsultarManifestosPendentes() throws Exception {
        MDeConsultarManifestosResponse response = repository.consultarManifestosPendentes(cnpjEmitente);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarManifestosBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifestos.size: " + bodyResponse.getManifestos().size());
    }

    @Test(dependsOnMethods = "testConsultarManifestosPendentes")
    public void testConsultarManifestosPendentesWithVersao() throws Exception {
        //MDeConsultarManifestosResponse response = repository.consultarManifestosPendentes(cnpjEmitente, 40);
        //System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        //System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        //System.out.println("RateLimitReset: " + response.getRateLimitReset());
        //System.out.println("Status: " + response.getStatus());
        //MDeConsultarManifestosBodyResponse bodyResponse = response.getBody();
        //System.out.println("Body.Manifestos.size: " + bodyResponse.getManifestos().size());
    }

    @Test(dependsOnMethods = "testConsultarManifestosPendentesWithVersao")
    public void testConsultarUltimoManifesto() throws Exception {
        String chaveNFe = "41180603918468000158550010000000251406642480";
        MDeConsultarUltimoManifestoResponse response = repository.consultarUltimoManifesto(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarUltimoManifestoBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifesto: " + bodyResponse.getManifesto());
    }

    @Test(dependsOnMethods = "testConsultarUltimoManifesto")
    public void testConsultarNFe() throws Exception {
        String chaveNFe = "41180603918468000158550010000000251406642480";
        MDeConsultarNFeResponse response = repository.consultarNFe(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarNFeBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifesto: " + bodyResponse.getManifesto());
    }

    @Test(dependsOnMethods = "testConsultarNFe")
    public void testConsultarNFeCompleta() throws Exception {
        String chaveNFe = "41180603918468000158550010000000251406642480";
        MDeConsultarNFeResponse response = repository.consultarNFeCompleta(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        MDeConsultarNFeBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Manifesto: " + bodyResponse.getManifesto());
    }

    @Test(dependsOnMethods = "testConsultarNFeCompleta")
    public void testDownloadNFe() throws Exception {
        String chaveNFe = "41180603918468000158550010000000291467053999";
        MDeDownloadXmlResponse response = repository.downloadNFe(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        String bodyResponse = response.getBody();
        System.out.println("Body: " + bodyResponse);
    }

    @Test(dependsOnMethods = "testDownloadNFe")
    public void testDownloadCancelamento() throws Exception {
        String chaveNFe = "41180603918468000158550010000000291467053999";
        MDeDownloadXmlResponse response = repository.downloadCancelamento(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        String bodyResponse = response.getBody();
        System.out.println("Body: " + bodyResponse);
    }

    @Test(dependsOnMethods = "testDownloadCancelamento")
    public void testDownloadUltimaCCe() throws Exception {
        String chaveNFe = "41180603918468000158550010000000251406642480";
        MDeDownloadXmlResponse response = repository.downloadUltimaCCe(chaveNFe);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        String bodyResponse = response.getBody();
        System.out.println("Body: " + bodyResponse);
    }
}
