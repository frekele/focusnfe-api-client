package org.frekele.fiscal.focus.nfe.client.repository.ncm;

import org.frekele.fiscal.focus.nfe.client.auth.EnvironmentFocusNFeEnum;
import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.model.request.ncm.param.NcmQueryParam;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.body.NcmBodyResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.body.NcmsBodyResponse;
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
 * O código NCM é formato por 8 dígitos no seguinte formato:
 * <p>
 * CCPPSÇII, sendo:
 * <ul>
 * <li>CC = Capitulo;
 * <li>PP = Posição;
 * <li>S = Subposição 1;
 * <li>Ç = Subposição 2;
 * <li>II = Item 1 e 2;
 * </ul>
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@Listeners(InvokedMethodListener.class)
public class FocusNcmV2RepositoryIT {

    private FocusNcmV2Repository repository;

    @BeforeClass
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);

        String accessToken = System.getenv("FOCUS_NFE_ACCESS_TOKEN");
        EnvironmentFocusNFeEnum environment = EnvironmentFocusNFeEnum.HOMOLOGATION;
        FocusNFeAuth auth = FocusNFeAuth.newBuilder()
            .withAccessToken(accessToken)
            .withEnvironment(environment)
            .build();
        ResteasyClient client = new ResteasyClientBuilder().build();
        repository = new FocusNcmV2RepositoryImpl(client, auth);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        //After Method Sleep 2 seg, for prevent Error.
        FocusTestNGUtils.sleep(2);
    }

    @Test
    public void testConsultar() throws Exception {
        NcmConsultarResponse response = repository.consultar("94036000");
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("Status: " + response.getStatus());
        NcmBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Ncm.DescricaoCompleta: " + bodyResponse.getNcm().getDescricaoCompleta());
    }

    @Test
    public void testConsultarTodos() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder().build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos2() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos3() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .withPosicao("03")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos4() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .withPosicao("03")
            .withSubposicao1("6")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos5() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .withPosicao("03")
            .withSubposicao1("6")
            .withSubposicao2("0")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos6() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .withPosicao("03")
            .withSubposicao1("6")
            .withSubposicao2("0")
            .withItem1("0")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodos7() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCapitulo("94")
            .withPosicao("03")
            .withSubposicao1("6")
            .withSubposicao2("0")
            .withItem1("0")
            .withItem2("0")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    @Test
    public void testConsultarTodosOffset() throws Exception {
        NcmQueryParam queryParam = NcmQueryParam.newBuilder()
            .withCodigo("9")
            .withOffset("20")
            .build();
        NcmConsultarTodosResponse response = repository.consultarTodos(queryParam);
        this.printNcmConsultarTodosResponse(response);
    }

    private void printNcmConsultarTodosResponse(NcmConsultarTodosResponse response) {
        System.out.println("RateLimitLimit: " + response.getRateLimitLimit());
        System.out.println("RateLimitRemaining: " + response.getRateLimitRemaining());
        System.out.println("RateLimitReset: " + response.getRateLimitReset());
        System.out.println("TotalCount: " + response.getTotalCount());
        System.out.println("Status: " + response.getStatus());
        NcmsBodyResponse bodyResponse = response.getBody();
        System.out.println("Body.Ncms.Size: " + bodyResponse.getNcms().size());
    }
}
