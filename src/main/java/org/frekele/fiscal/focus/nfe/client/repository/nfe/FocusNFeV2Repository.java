package org.frekele.fiscal.focus.nfe.client.repository.nfe;

import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCCeBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfe.body.NFeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCCeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfe.NFeInutilizarResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API V2 NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusNFeV2Repository extends Serializable {

    /**
     * POST - Emitir NFe utilizando dados simplificados.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Cria uma nota fiscal e a envia para processamento.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe?ref=REFERENCIA
     */
    NFeAutorizarResponse autorizar(String referencia, NFeAutorizarBodyRequest bodyRequest);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    NFeConsultarResponse consultar(String referencia);

    /**
     * GET - Consultar o status de NFe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfe/REFERENCIA?completa=(0|1)
     */
    NFeConsultarResponse consultarNFeCompleta(String referencia);

    /**
     * DELETE - Cancelar NFe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfe/REFERENCIA
     */
    NFeCancelarResponse cancelar(String referencia, NFeCancelarBodyRequest bodyRequest);

    /**
     * POST - Emitir Carta de Correção.
     * Cria uma carta de correção para a nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/carta_correcao
     */
    NFeCCeResponse emitirCCe(String referencia, NFeCCeBodyRequest bodyRequest);

    /**
     * POST - Encaminhar uma NFe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/REFERENCIA/email
     */
    NFeEmailResponse enviarEmail(String referencia, NFeEmailBodyRequest bodyRequest);

    /**
     * POST - Inutilizar uma faixa de numeração de NFe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfe/inutilizacao
     */
    NFeInutilizarResponse inutilizar(NFeInutilizarBodyRequest bodyRequest);
}
