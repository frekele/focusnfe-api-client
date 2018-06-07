package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeCCeBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Texto da carta de correção. Deverá conter de 15 a 255 caracteres.
    @NotNull
    @Size(min = 15, max = 255)
    @JsonProperty("correcao")
    private String correcao;

    //Campo opcional. Data do evento da carta de correção. Se não informado será usado a data atual.
    @LocalDateJsonConverter
    @JsonProperty("data_evento")
    private LocalDate dataEvento;

    public NFeCCeBodyRequest() {
        super();
    }
}
