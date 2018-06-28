package org.frekele.fiscal.focus.nfe.client.repository.download;

import org.frekele.fiscal.focus.nfe.client.model.response.download.DownloadFileResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para Download de Arquivos.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusDownloadRepository extends Serializable {

    /**
     * GET - Baixar arquivo .xml informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.xml
     */
    DownloadFileResponse downloadXml(String path);

    /**
     * GET - Baixar arquivo .pdf informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.pdf
     */
    DownloadFileResponse downloadPdf(String path);

    /**
     * GET - Baixar arquivo .html informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.html
     */
    DownloadFileResponse downloadHtml(String path);

    /**
     * GET - Baixar arquivo .zip informando um caminho:
     * Exemplo de requisição: GET https://api.focusnfe.com.br/PATH.zip
     */
    DownloadFileResponse downloadZip(String path);
}
