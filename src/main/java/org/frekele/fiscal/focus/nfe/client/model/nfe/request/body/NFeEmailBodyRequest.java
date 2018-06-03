package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeEmailBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    private List<String> emails;

    public NFeEmailBodyRequest() {
        super();
    }
}