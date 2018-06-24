package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeReboque implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Placa do veículo de transporte.
     */
    @Size(max = 7)
    @JsonProperty("veiculo_placa")
    private String veiculoPlaca;

    /**
     * UF do veículo de transporte.
     */
    @JsonProperty("veiculo_uf")
    private NFeUnidadeFederativaEnum veiculoUf;

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    @Size(min = 1, max = 20)
    @JsonProperty("veiculo_rntc")
    private String veiculoRntc;

    public NFeReboque() {
        super();
    }

    private NFeReboque(Builder builder) {
        setVeiculoPlaca(builder.veiculoPlaca);
        setVeiculoUf(builder.veiculoUf);
        setVeiculoRntc(builder.veiculoRntc);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Placa do veículo de transporte.
     */
    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    /**
     * Placa do veículo de transporte.
     */
    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    /**
     * UF do veículo de transporte.
     */
    public NFeUnidadeFederativaEnum getVeiculoUf() {
        return veiculoUf;
    }

    /**
     * UF do veículo de transporte.
     */
    public void setVeiculoUf(NFeUnidadeFederativaEnum veiculoUf) {
        this.veiculoUf = veiculoUf;
    }

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    public String getVeiculoRntc() {
        return veiculoRntc;
    }

    /**
     * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
     */
    public void setVeiculoRntc(String veiculoRntc) {
        this.veiculoRntc = veiculoRntc;
    }

    /**
     * NFeReboque Builder Pattern.
     */
    public static final class Builder {

        private String veiculoPlaca;

        private NFeUnidadeFederativaEnum veiculoUf;

        private String veiculoRntc;

        private Builder() {
        }

        /**
         * Placa do veículo de transporte.
         */
        public Builder withVeiculoPlaca(String val) {
            veiculoPlaca = val;
            return this;
        }

        /**
         * UF do veículo de transporte.
         */
        public Builder withVeiculoUf(NFeUnidadeFederativaEnum val) {
            veiculoUf = val;
            return this;
        }

        /**
         * RNTC (Registro Nacional de Transportador de Carga - ANTT) do veículo de transporte.
         */
        public Builder withVeiculoRntc(String val) {
            veiculoRntc = val;
            return this;
        }

        public NFeReboque build() {
            return new NFeReboque(this);
        }
    }
}
