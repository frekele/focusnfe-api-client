package org.frekele.fiscal.focus.nfe.client.repository.backup;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.model.response.backup.BackupConsultaResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.backup.body.BackupConsultarBodyResponse;
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
public class FocusBackupV2RepositoryIT {

    private FocusBackupV2Repository repository;

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
        ResteasyClient client = new ResteasyClientBuilder().build();
        repository = new FocusBackupV2RepositoryImpl(client, auth);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 3 seg, for prevent Error.
        FocusTestNGUtils.sleep(3);
    }

    @Test
    public void testConsultarTodos() throws Exception {
        BackupConsultaResponse response = repository.consultarTodos(cnpjEmitente);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        BackupConsultarBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Backups.size: " + bodyResponse.getBackups().size());
    }
}
