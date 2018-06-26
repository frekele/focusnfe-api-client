package org.frekele.fiscal.focus.nfe.client.repository.ncm;

import org.frekele.fiscal.focus.nfe.client.auth.FocusNFeAuth;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFe;
import org.frekele.fiscal.focus.nfe.client.filter.RequestLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseArrayJsonReplaceFilter;
import org.frekele.fiscal.focus.nfe.client.filter.ResponseLoggingFilter;
import org.frekele.fiscal.focus.nfe.client.model.request.ncm.param.NcmQueryParam;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.ncm.NcmConsultarTodosResponse;
import org.frekele.fiscal.focus.nfe.client.util.FocusNFeUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.inject.Inject;

/**
 * Classe com implementação das chamadas para API NCM.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@FocusNFe
public class FocusNcmV2RepositoryImpl implements FocusNcmV2Repository {

    private static final long serialVersionUID = 1L;

    private final ResteasyClient client;

    private final FocusNFeAuth auth;

    @Inject
    public FocusNcmV2RepositoryImpl(@FocusNFe ResteasyClient client, @FocusNFe FocusNFeAuth auth) {
        FocusNFeUtils.throwInjection(client, auth);
        FocusNFeUtils.throwAuth(auth);
        this.client = client
            .register(RequestLoggingFilter.class)
            .register(ResponseLoggingFilter.class)
            .register(ResponseArrayJsonReplaceFilter.class);
        this.auth = auth;
        this.client.register(ResponseArrayJsonReplaceFilter.class);
    }

    ResteasyClient getClient() {
        return client;
    }

    FocusNFeAuth getAuth() {
        return auth;
    }

    private FocusNcmV2ProxyClient getProxyClient() {
        ResteasyClient client = this.getClient();
        ResteasyWebTarget webTarget = client.target(this.getAuth().getEnvironment().getTargetUrl());
        return webTarget.proxy(FocusNcmV2ProxyClient.class);
    }

    /**
     * GET - Consultar um NCM individualmente.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/ncms/CODIGO_NCM
     */
    @Override
    public NcmConsultarResponse consultar(String ncm) {
        FocusNFeUtils.throwObject(ncm, "ncm");
        FocusNcmV2ProxyClient proxyClient = this.getProxyClient();
        return proxyClient.consultar(this.getAuth().getBasicAuthorization(), ncm);
    }

    /**
     * GET - Consultar os NCMs disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/ncms
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
     * São aceitos os seguintes parâmetros de pesquisa:
     * codigo: Pesquise pela parte inicial do código NCM
     * descricao: Pesquisa por parte da descrição do código NCM.
     * capitulo, posicao, subposicao1, subposicao2, item1 e item2: Pesquisa exata informando qualquer uma das partes do código NCM.
     * Para buscar os demais registros, utilize o parâmetro offset.
     */
    @Override
    public NcmConsultarTodosResponse consultarTodos(NcmQueryParam queryParam) {
        FocusNFeUtils.throwObject(queryParam, "NcmQueryParam");
        FocusNFeUtils.throwBeanValidation(queryParam);
        FocusNcmV2ProxyClient proxyClient = this.getProxyClient();

        return proxyClient.consultarTodos(this.getAuth().getBasicAuthorization(),
            queryParam.getCodigo(), queryParam.getDescricao(),
            queryParam.getCapitulo(), queryParam.getPosicao(),
            queryParam.getSubposicao1(), queryParam.getSubposicao2(),
            queryParam.getItem1(), queryParam.getItem2(),
            queryParam.getOffset());
    }
}
