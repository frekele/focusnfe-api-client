package org.frekele.fiscal.focus.nfe.client.model.nfe.request.body.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    private NFeVolumeTransportado(Builder builder) {
        setQuantidade(builder.quantidade);
        setEspecie(builder.especie);
        setMarca(builder.marca);
        setNumero(builder.numero);
        setPesoLiquido(builder.pesoLiquido);
        setPesoBruto(builder.pesoBruto);
        setLacres(builder.lacres);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(String pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public String getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(String pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public List<NFeLacreVolumeTransportado> getLacres() {
        return lacres;
    }

    public void setLacres(List<NFeLacreVolumeTransportado> lacres) {
        this.lacres = lacres;
    }

    public static final class Builder {

        private String quantidade;

        private String especie;

        private String marca;

        private String numero;

        private String pesoLiquido;

        private String pesoBruto;

        private List<NFeLacreVolumeTransportado> lacres;

        private Builder() {
        }

        public Builder withQuantidade(String val) {
            quantidade = val;
            return this;
        }

        public Builder withEspecie(String val) {
            especie = val;
            return this;
        }

        public Builder withMarca(String val) {
            marca = val;
            return this;
        }

        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public Builder withPesoLiquido(String val) {
            pesoLiquido = val;
            return this;
        }

        public Builder withPesoBruto(String val) {
            pesoBruto = val;
            return this;
        }

        public Builder withLacres(List<NFeLacreVolumeTransportado> val) {
            lacres = val;
            return this;
        }

        public NFeVolumeTransportado build() {
            return new NFeVolumeTransportado(this);
        }
    }
}
