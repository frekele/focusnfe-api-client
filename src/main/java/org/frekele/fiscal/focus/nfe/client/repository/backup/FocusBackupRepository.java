package org.frekele.fiscal.focus.nfe.client.repository.backup;

import org.frekele.fiscal.focus.nfe.client.model.response.backup.BackupConsultaResponse;

import java.io.Serializable;

/**
 * Interface com chamadas para API Backups.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusBackupRepository extends Serializable {

    /**
     * GET - Consultar os Backups disponíveis.
     * Exemplo de requisição: GET https://api.focusnfe.com.br/backups/CNPJ.json
     */
    BackupConsultaResponse consultarTodos(String cnpj);
}