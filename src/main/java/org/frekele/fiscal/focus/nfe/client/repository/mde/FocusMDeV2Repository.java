package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.model.request.mde.body.MDeManifestarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarNFeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarUltimoManifestoResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeDownloadXmlResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeManifestarResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API MD-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusMDeV2Repository extends Serializable {

    /**
     * POST - Realiza um manifesto na nota informada.
     * Exemplo de requisição: POST https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/manifesto
     */
    MDeManifestarResponse manifestar(String chaveNFe, MDeManifestarBodyRequest bodyRequest);

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ
     */
    MDeConsultarManifestosResponse consultarManifestos(String cnpj);

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&versao=VERSAO
     */
    MDeConsultarManifestosResponse consultarManifestos(String cnpj, Integer versao);

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&pendente=PENDENTE
     */
    MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj);

    /**
     * GET - Busca informações resumidas de todas as NFe’s recebidas.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/v2/nfes_recebidas?cnpj=CNPJ&versao=VERSAO&pendente=PENDENTE
     */
    MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj, Integer versao);

    /**
     * GET - Consulta o último manifesto válido na nota fiscal informada.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/manifesto
     */
    MDeConsultarUltimoManifestoResponse consultarUltimoManifesto(String chaveNFe);

    /**
     * GET - Consulta as informações da nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.json
     */
    MDeConsultarNFeResponse consultarNFe(String chaveNFe);

    /**
     * GET - Consulta as informações da nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.json?completa=1
     */
    MDeConsultarNFeResponse consultarNFeCompleta(String chaveNFe);

    /**
     * GET - Baixar o XML de uma nota fiscal especifica:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE.xml
     */
    MDeDownloadXmlResponse downloadNFe(String chaveNFe);

    /**
     * GET - Baixar o XML de cancelamento de uma nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/cancelamento.xml
     */
    MDeDownloadXmlResponse downloadCancelamento(String chaveNFe);

    /**
     * GET - Baixar o XML da última Carta de Correção Eletrônica de uma nota fiscal.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/v2/nfes_recebidas/CHAVE/carta_correcao.xml
     */
    MDeDownloadXmlResponse downloadUltimaCCe(String chaveNFe);
}
