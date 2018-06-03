package org.frekele.fiscal.focus.nfe.client.model.nfe.response.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeInutilizarBodyResponse implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    private String status;

    @JsonProperty("status_sefaz")
    private String statusSefaz;

    @JsonProperty("mensagem_sefaz")
    private String mensagemSefaz;

    private String serie;

    @JsonProperty("numero_inicial")
    private String numeroInicial;

    @JsonProperty("numero_final")
    private String numeroFinal;

    @JsonProperty("caminho_xml")
    private String caminhoXml;

    public NFeInutilizarBodyResponse() {
        super();
    }
}
