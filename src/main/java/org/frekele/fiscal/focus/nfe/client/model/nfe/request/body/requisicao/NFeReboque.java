package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeReboque implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Placa do veículo de transporte.
    @Size(max = 7)
    @JsonProperty("veiculo_placa")
    private String veiculoPlaca;

    //UF do veículo de transporte.
    @JsonProperty("veiculo_uf")
    private NFeUnidadeFederativaEnum veiculoUf;

    //RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_rntc")
    private String veiculoRntc;

    public NFeReboque() {
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
