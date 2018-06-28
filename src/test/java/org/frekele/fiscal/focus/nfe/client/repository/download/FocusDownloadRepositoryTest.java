package org.frekele.fiscal.focus.nfe.client.repository.download;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.model.entities.backup.NFeBackup;
import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;
import org.frekele.fiscal.focus.nfe.client.repository.backup.FocusBackupV2Repository;
import org.frekele.fiscal.focus.nfe.client.repository.backup.FocusBackupV2RepositoryImpl;
import org.frekele.fiscal.focus.nfe.client.repository.nfe.FocusNFeV2Repository;
import org.frekele.fiscal.focus.nfe.client.repository.nfe.FocusNFeV2RepositoryImpl;
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
public class FocusDownloadRepositoryTest {

    private FocusDownloadRepository repository;

    private FocusNFeV2Repository repositoryNfe;

    private FocusBackupV2Repository repositoryBackup;

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
        repository = new FocusDownloadRepositoryImpl(client, auth);
        repositoryNfe = new FocusNFeV2RepositoryImpl(client, auth);
        repositoryBackup = new FocusBackupV2RepositoryImpl(client, auth);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 3 seg, for prevent Error.
        FocusTestNGUtils.sleep(3);
    }

    @Test
    public void testDownloadXml() throws Exception {
        String reference = "27415e72-81a9-49fc-a381-d81247ede6f3";
        String pathXmlNFe = repositoryNfe.consultar(reference).getBody().getCaminhoXmlNotaFiscal();
        DownloadFileResponse response = repository.downloadXml(pathXmlNFe);
        response.getBody();
    }

    @Test(dependsOnMethods = "testDownloadXml")
    public void testDownloadPdf() throws Exception {
        String reference = "27415e72-81a9-49fc-a381-d81247ede6f3";
        String pathDanfeNFe = repositoryNfe.consultar(reference).getBody().getCaminhoDanfe();
        DownloadFileResponse response = repository.downloadPdf(pathDanfeNFe);
        response.getBody();
    }

    @Test(dependsOnMethods = "testDownloadPdf")
    public void testDownloadHtml() throws Exception {
        String reference = "3b098972-9072-4385-ac11-d19c3039efb2";
        String pathDanfeNFCe = repositoryNfe.consultar(reference).getBody().getCaminhoDanfe();
        DownloadFileResponse response = repository.downloadHtml(pathDanfeNFCe);
        response.getBody();
    }

    @Test(dependsOnMethods = "testDownloadHtml")
    public void testDownloadZip() throws Exception {
        List<NFeBackup> backups = repositoryBackup.consultarTodos(cnpjEmitente).getBody().getBackups();
        if (!backups.isEmpty()) {
            NFeBackup backup = backups.get(0);
            if (backup != null && backup.getDanfes() != null && !backup.getDanfes().isEmpty()) {
                String pathBackupDanfes = backup.getDanfes();
                DownloadFileResponse response = repository.downloadZip(pathBackupDanfes);
                response.getBody();
            }
        }
    }
}
