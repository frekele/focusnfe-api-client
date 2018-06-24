package org.frekele.fiscal.focus.nfe.client.model.response.mde;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.body.MDeConsultarManifestosBodyResponse;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.ResponseObject;
import org.jboss.resteasy.annotations.Status;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@ResponseObject
public interface MDeConsultarManifestosResponse extends FocusNFeEntity {

    //Número de créditos para o período atual.
    @HeaderParam("X-Rate-Limit-Limit")
    String getRateLimitLimit();

    //Número de créditos que restam no período atual.
    @HeaderParam("X-Rate-Limit-Remaining")
    String getRateLimitRemaining();

    //Número de segundos até que seja reinicializado o contador de créditos.
    @HeaderParam("X-Rate-Limit-Reset")
    String getRateLimitReset();

    //Tempo de execução.
    @HeaderParam("X-Runtime")
    String getRuntime();

    //O número total de registros (incluindo aqueles que não foram devolvidos pelo limite de 100 registros)
    @HeaderParam("X-Total-Count")
    String getTotalCount();

    //Valor máximo da versão dos documentos devolvidos.
    //Utilize este cabeçalho para utilizar na próxima busca de versão, caso seja necessário.
    @HeaderParam("X-Max-Version")
    String getMaxVersion();

    //Status Http da Chamada.
    @Status
    Integer getStatus();

    //Corpo da Resposta.
    @Body
    MDeConsultarManifestosBodyResponse getBody();

    //Response Completo.
    Response getResponse();
}
