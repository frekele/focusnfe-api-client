package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

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
public class NFeInutilizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    private String cnpj;

    private String serie;

    @JsonProperty("numero_inicial")
    private String numeroInicial;

    @JsonProperty("numero_final")
    private String numeroFinal;

    private String justificativa;

    public NFeInutilizarBodyRequest() {
        super();
    }
}
