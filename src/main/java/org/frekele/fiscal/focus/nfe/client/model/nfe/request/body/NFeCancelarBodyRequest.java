package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeCancelarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Justificativa do cancelamento. Deverá conter de 15 a 255 caracteres.
    @NotNull
    @Size(min = 15, max = 255)
    private String justificativa;

    public NFeCancelarBodyRequest() {
        super();
    }
}
