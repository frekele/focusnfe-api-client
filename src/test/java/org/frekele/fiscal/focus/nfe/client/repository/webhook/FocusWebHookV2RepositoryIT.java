package org.frekele.fiscal.focus.nfe.client.repository.webhook;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.model.request.webhook.body.WebHookCriarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookCriarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.WebHookExcluirResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.body.WebHookBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.webhook.body.WebHooksBodyResponse;
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
public class FocusWebHookV2RepositoryIT {

    private FocusWebHookV2Repository repository;

    private String cnpjEmitente;

    private String webHookId;

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
        repository = new FocusWebHookV2RepositoryImpl(client, auth);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 3 seg, for prevent Error.
        FocusTestNGUtils.sleep(3);
    }

    @Test
    public void testCriar() throws Exception {
        WebHookCriarBodyRequest bodyRequest = WebHookCriarBodyRequest.newBuilder()
            .withCnpj(cnpjEmitente)
            .withEvent("nfe")
            .withUrl("http://minha.url/nfe")
            .build();
        WebHookCriarResponse response = repository.criar(bodyRequest);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        WebHookBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Id: " + bodyResponse.getId());
        webHookId = bodyResponse.getId();
    }

    @Test(dependsOnMethods = "testCriar")
    public void testConsultar() throws Exception {
        WebHookConsultarResponse response = repository.consultar(webHookId);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        WebHookBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Id: " + bodyResponse.getId());
    }

    @Test(dependsOnMethods = "testConsultar")
    public void testConsultarTodos() throws Exception {
        WebHookConsultarTodosResponse response = repository.consultarTodos();
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        WebHooksBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Webhooks.Size: " + bodyResponse.getWebhooks().size());
    }

    @Test(dependsOnMethods = "testConsultarTodos")
    public void testExcluir() throws Exception {
        WebHookExcluirResponse response = repository.excluir(webHookId);
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        WebHookBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Id: " + bodyResponse.getId());
    }
}
