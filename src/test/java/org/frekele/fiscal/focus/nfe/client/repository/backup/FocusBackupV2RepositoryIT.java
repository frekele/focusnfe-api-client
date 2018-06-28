package org.frekele.fiscal.focus.nfe.client.repository.backup;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.model.entities.backup.NFeBackup;
import org.frekele.fiscal.focus.nfe.client.model.response.backup.BackupConsultaResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.backup.body.BackupConsultarBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;
import org.frekele.fiscal.focus.nfe.client.repository.download.FocusDownloadRepository;
import org.frekele.fiscal.focus.nfe.client.repository.download.FocusDownloadRepositoryImpl;
import org.frekele.fiscal.focus.nfe.client.testng.FocusTestNGUtils;
import org.frekele.fiscal.focus.nfe.client.testng.InvokedMethodListener;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusBackupV2RepositoryIT {

    private FocusBackupV2Repository repository;

    private FocusDownloadRepository downloadRepository;

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
        downloadRepository = new FocusDownloadRepositoryImpl(client, auth);
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

    @Test(dependsOnMethods = "testConsultarTodos")
    public void testDownloadZip() throws Exception {
        List<NFeBackup> backups = repository.consultarTodos(cnpjEmitente).getBody().getBackups();
        if (!backups.isEmpty()) {
            if (backups.get(0) != null && backups.get(0).getDanfes() != null && !backups.get(0).getDanfes().isEmpty()) {
                String pathBackupDanfes = backups.get(0).getDanfes();
                DownloadFileResponse response = downloadRepository.downloadZip(pathBackupDanfes);
                response.getBody();
            }
        }
    }
}
