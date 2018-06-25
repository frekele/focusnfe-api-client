package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Volume transportado.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeVolumeTransportado implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Quantidade de volumes transportados.
     */
    @Size(min = 1, max = 15)
    @JsonProperty("quantidade")
    private String quantidade;

    /**
     * Espécie dos volumes transportados.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("especie")
    private String especie;

    /**
     * Marca dos volumes transportados.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("marca")
    private String marca;

    /**
     * Numeração dos volumes transportados.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("numero")
    private String numero;

    /**
     * Peso líquido dos volumes transportados.
     */
    @Digits(integer = 12, fraction = 3)
    @BigDecimalJsonConverter
    @JsonProperty("peso_liquido")
    private BigDecimal pesoLiquido;

    /**
     * Peso bruto dos volumes transportados.
     */
    @Digits(integer = 12, fraction = 3)
    @BigDecimalJsonConverter
    @JsonProperty("peso_bruto")
    private BigDecimal pesoBruto;

    /**
     * Quantidade de volumes transportados.
     */
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

    /**
     * Quantidade de volumes transportados.
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * Quantidade de volumes transportados.
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Espécie dos volumes transportados.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Espécie dos volumes transportados.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Marca dos volumes transportados.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Marca dos volumes transportados.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Numeração dos volumes transportados.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Numeração dos volumes transportados.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Peso líquido dos volumes transportados.
     */
    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    /**
     * Peso líquido dos volumes transportados.
     */
    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    /**
     * Peso bruto dos volumes transportados.
     */
    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    /**
     * Peso bruto dos volumes transportados.
     */
    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    /**
     * Quantidade de volumes transportados.
     */
    public List<NFeLacreVolumeTransportado> getLacres() {
        return lacres;
    }

    /**
     * Quantidade de volumes transportados.
     */
    public void setLacres(List<NFeLacreVolumeTransportado> lacres) {
        this.lacres = lacres;
    }

    /**
     * NFeVolumeTransportado Builder Pattern.
     */
    public static final class Builder {

        private String quantidade;

        private String especie;

        private String marca;

        private String numero;

        private BigDecimal pesoLiquido;

        private BigDecimal pesoBruto;

        private List<NFeLacreVolumeTransportado> lacres;

        private Builder() {
        }

        /**
         * Quantidade de volumes transportados.
         */
        public Builder withQuantidade(String val) {
            quantidade = val;
            return this;
        }

        /**
         * Espécie dos volumes transportados.
         */
        public Builder withEspecie(String val) {
            especie = val;
            return this;
        }

        /**
         * Marca dos volumes transportados.
         */
        public Builder withMarca(String val) {
            marca = val;
            return this;
        }

        /**
         * Numeração dos volumes transportados.
         */
        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        /**
         * Peso líquido dos volumes transportados.
         */
        public Builder withPesoLiquido(BigDecimal val) {
            pesoLiquido = val;
            return this;
        }

        /**
         * Peso bruto dos volumes transportados.
         */
        public Builder withPesoBruto(BigDecimal val) {
            pesoBruto = val;
            return this;
        }

        /**
         * Quantidade de volumes transportados.
         */
        public Builder withLacres(List<NFeLacreVolumeTransportado> val) {
            lacres = val;
            return this;
        }

        public NFeVolumeTransportado build() {
            return new NFeVolumeTransportado(this);
        }
    }
}
