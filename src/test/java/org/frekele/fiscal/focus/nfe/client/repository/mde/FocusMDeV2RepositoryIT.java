package org.frekele.fiscal.focus.nfe.client.repository.mde;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseManifestosReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeConsultarManifestosBodyResponse;
import org.frekele.fiscal.focus.nfe.client.testng.FocusTestNGUtils;
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
public class FocusMDeV2RepositoryIT {

    private FocusMDeV2Repository repository;

    private ObjectMapper mapper = new ObjectMapper();

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

//    @Test
//    public void testConsultarManifestos() throws Exception {
//        MDeConsultarManifestosResponse response = repository.consultarManifestos(cnpjEmitente);
//        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
//        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
//        System.out.println("RateLimitReset: " + response.getRateLimitReset());
//        System.out.println("Status: " + response.getStatus());
//        MDeConsultarManifestosBodyResponse bodyResponse = response.getBody();
//        System.out.println("Body.Status: " + bodyResponse.getManifestos());
//    }
}
