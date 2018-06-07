package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    //Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
    @NotNull
    @Size(min = 1, max = 10)
    @JsonProperty("emails")
    private List<String> emails;

    public NFeEmailBodyRequest() {
        super();
    }
}
