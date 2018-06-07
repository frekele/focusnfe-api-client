package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao.NFeRequisicao;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeAutorizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Dados nfe da requisicao para autorizacao.
    @JsonUnwrapped
    @NotNull
    private NFeRequisicao nfe;

    public NFeAutorizarBodyRequest() {
        super();
    }
}
