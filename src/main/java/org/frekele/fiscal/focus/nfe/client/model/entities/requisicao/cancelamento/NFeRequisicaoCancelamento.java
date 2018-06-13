package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.cancelamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRequisicaoCancelamento implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    public NFeRequisicaoCancelamento() {
        super();
    }
}
