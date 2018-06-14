package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.body.NFeConsultarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNFeV2RepositoryIT {

    private FocusNFeV2Repository repository;

    private ObjectMapper mapper = new ObjectMapper();

    private String reference;

    @BeforeClass
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        String accessToken = System.getenv("FOCUS_NFE_ACCESS_TOKEN");
        EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;
        FocusNFeAuth auth = FocusNFeAuth.newBuilder()
            .withAccessToken(accessToken)
            .withEnvironment(environment)
            .build();
        ResteasyClient client = new ResteasyClientBuilder()
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .build();
        repository = new FocusNFeV2RepositoryImpl(client, auth);

        //reference = UUID.randomUUID().toString();
        reference = "a14";
        System.out.println("reference: " + reference);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 1 seg, for prevent (HTTP 429 Unknown Code).
        this.sleep(1);
    }

    @Test
    public void testAutorizar() throws Exception {
//        NFeAutorizarBodyRequest bodyRequest = NFeAutorizarBodyRequest.newBuilder()
//            .build();
//        NFeAutorizarResponse response = repository.autorizar(reference, bodyRequest);
//        response.getBody();
    }

    //@Test
    public void testConsultar() throws Exception {
        NFeConsultarResponse response = repository.consultar(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
    }

    @Test
    public void testConsultarTudo() throws Exception {
        NFeConsultarResponse response = repository.consultarTudo(reference);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NFeConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Status: " + bodyResponse.getStatus());
        System.out.println("Body.Status.ProtocoloNotaFiscal.Motivo: " + bodyResponse.getProtocoloNotaFiscal().getMotivo());
    }

    @Test
    public void testEmitirCCe() throws Exception {
    }

    @Test
    public void testEnviarEmail() throws Exception {
    }

    @Test
    public void testCancelar() throws Exception {
    }

    @Test
    public void testInutilizar() throws Exception {
    }

    private void sleep(long seconds) {
        try {
            long millis = seconds * 1000;
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
    }
}
