package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeInutilizarBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //CNPJ da empresa emitente
    @NotNull
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    //Série da numeração da NFe que terá uma faixa de numeração inutilizada
    @NotNull
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    //Número inicial a ser inutilizado
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_inicial")
    private String numeroInicial;

    //Número final a ser inutilizado
    @NotNull
    @Size(min = 1, max = 9)
    @JsonProperty("numero_final")
    private String numeroFinal;

    //Justificativa da inutilização (mínimo 15 caracteres)
    @NotNull
    @Size(min = 15, max = 255)
    @JsonProperty("justificativa")
    private String justificativa;

    public NFeInutilizarBodyRequest() {
        super();
    }
}
