package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;

import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusMDeV2Repository extends Serializable {

    MDeConsultarManifestosResponse consultarManifestos(String cnpj);
}
