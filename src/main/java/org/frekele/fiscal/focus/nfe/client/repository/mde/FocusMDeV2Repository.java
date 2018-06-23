package org.frekele.fiscal.focus.nfe.client.repository.mde;

import org.frekele.fiscal.focus.nfe.client.model.request.mde.MDeManifestarBodyRequest;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarManifestosResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarNFeResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeConsultarUltimoManifestoResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeDownloadXmlResponse;
import org.frekele.fiscal.focus.nfe.client.model.response.mde.MDeManifestarResponse;

import java.io.Serializable;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public interface FocusMDeV2Repository extends Serializable {

    MDeManifestarResponse manifestar(String chaveNFe, MDeManifestarBodyRequest bodyRequest);

    MDeConsultarManifestosResponse consultarManifestos(String cnpj);

    MDeConsultarManifestosResponse consultarManifestos(String cnpj, Integer versao);

    MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj);

    MDeConsultarManifestosResponse consultarManifestosPendentes(String cnpj, Integer versao);

    MDeConsultarUltimoManifestoResponse consultarUltimoManifesto(String chaveNFe);

    MDeConsultarNFeResponse consultarNFe(String chaveNFe);

    MDeConsultarNFeResponse consultarNFeCompleta(String chaveNFe);

    MDeDownloadXmlResponse downloadNFe(String chaveNFe);

    MDeDownloadXmlResponse downloadCancelamento(String chaveNFe);

    MDeDownloadXmlResponse downloadUltimaCCe(String chaveNFe);
}
