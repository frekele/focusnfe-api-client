package org.frekele.fiscal.focus.nfe.client.repository.nfce;

import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeAutorizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeCancelarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeEmailBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.request.nfce.body.NFCeInutilizarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeAutorizarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeCancelarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeConsultarResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeEmailResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.nfce.NFCeInutilizarResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API NFC-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusNFCeV2Repository extends Serializable {

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA
     */
    NFCeAutorizarResponse autorizar(String referencia, NFCeAutorizarBodyRequest bodyRequest);

    /**
     * POST - Emitir uma Nota Fiscal de Consumidor Eletrônica (NFCe) para qualquer Estado que aceita o uso deste documento.
     * Todos os processos envolvendo NFCe são Síncronos.
     * Cria uma nota fiscal e a envia para processamento Síncronos e retorna informações completa.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce?ref=REFERENCIA&completa=(0|1)
     */
    NFCeAutorizarResponse autorizarConsultarTudo(String referencia, NFCeAutorizarBodyRequest bodyRequest);

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    NFCeConsultarResponse consultar(String referencia);

    /**
     * GET - Consultar o status de NFCe emitidas.
     * Este processo é assíncrono. Ou seja, após a emissão a nota será enfileirada para processamento.
     * Consulta a nota fiscal com a referência informada e o seu status de processamento.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfce/REFERENCIA?completa=(0|1)
     */
    NFCeConsultarResponse consultarTudo(String referencia);

    /**
     * DELETE - Cancelar NFCe.
     * Cancela uma nota fiscal com a referência informada.
     * Exemplo de requisição: DELETE https://api.focusnfe.com.br/v2/nfce/REFERENCIA
     */
    NFCeCancelarResponse cancelar(String referencia, NFCeCancelarBodyRequest bodyRequest);

    /**
     * POST - Encaminhar uma NFCe por email.
     * Envia um email com uma cópia da nota fiscal com a referência informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/REFERENCIA/email
     */
    NFCeEmailResponse enviarEmail(String referencia, NFCeEmailBodyRequest bodyRequest);

    /**
     * POST - Inutilizar uma faixa de numeração de NFCe.
     * Inutiliza uma numeração da nota fiscal.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfce/inutilizacao
     */
    NFCeInutilizarResponse inutilizar(NFCeInutilizarBodyRequest bodyRequest);
}
