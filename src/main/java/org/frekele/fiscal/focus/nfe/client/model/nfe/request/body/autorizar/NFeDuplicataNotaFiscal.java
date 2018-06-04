package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.autorizar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDuplicataNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Número.
    @Size(min = 1, max = 60)
    @JsonProperty("numero")
    private String numero;

    //Data de vencimento.
    @JsonProperty("data_vencimento")
    private String dataVencimento;

    //Valor.
    @Digits(integer = 13, fraction = 2)
    @JsonProperty("valor")
    private String valor;

    public NFeDuplicataNotaFiscal() {
        super();
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
}
