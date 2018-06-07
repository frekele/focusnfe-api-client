package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
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
public class NFeVolumeTransportado implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    //Quantidade de volumes transportados.
    @Size(min = 1, max = 15)
    @JsonProperty("quantidade")
    private String quantidade;

    //Quantidade de volumes transportados.
    @Size(min = 1, max = 60)
    @JsonProperty("especie")
    private String especie;

    //Quantidade de volumes transportados.
    @Size(min = 1, max = 60)
    @JsonProperty("marca")
    private String marca;

    //Quantidade de volumes transportados.
    @Size(min = 1, max = 60)
    @JsonProperty("numero")
    private String numero;

    //Peso líquido dos volumes transportados.
    @Digits(integer = 12, fraction = 3)
    @JsonProperty("peso_liquido")
    private String pesoLiquido;

    //Peso líquido dos volumes transportados.
    @Digits(integer = 12, fraction = 3)
    @JsonProperty("peso_bruto")
    private String pesoBruto;

    //Quantidade de volumes transportados.
    @Size(max = 5000)
    @JsonProperty("lacres")
    private List<NFeLacreVolumeTransportado> lacres;

    public NFeVolumeTransportado() {
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
