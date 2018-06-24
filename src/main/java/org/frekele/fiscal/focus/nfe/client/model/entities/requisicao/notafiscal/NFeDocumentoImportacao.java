package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.BigDecimalJsonConverter;
import org.frekele.fiscal.focus.nfe.client.converter.LocalDateJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeFormaIntermedioEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeViaTransporteEnum;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeDocumentoImportacao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Número do documento de importação DI/DSA/DA.
     */
    @Size(min = 1, max = 12)
    @JsonProperty("numero")
    private String numero;

    /**
     * Data de registro do documento de importação.
     */
    @LocalDateJsonConverter
    @JsonProperty("data_registro")
    private LocalDate dataRegistro;

    /**
     * Local do desembaraço aduaneiro.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("local_desembaraco_aduaneiro")
    private String localDesembaracoAduaneiro;

    /**
     * UF do desembaraço aduaneiro.
     */
    @JsonProperty("uf_desembaraco_aduaneiro")
    private NFeUnidadeFederativaEnum ufDesembaracoAduaneiro;

    /**
     * Data do desembaraço aduaneiro.
     */
    @LocalDateJsonConverter
    @JsonProperty("data_desembaraco_aduaneiro")
    private LocalDate dataDesembaracoAduaneiro;

    /**
     * Via de transporte internacional informada na DI.
     */
    @JsonProperty("via_transporte")
    private NFeViaTransporteEnum viaTransporte;

    /**
     * Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo).
     */
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_afrmm")
    private BigDecimal valorAfrmm;

    /**
     * Forma de importação quanto a intermediação.
     */
    @JsonProperty("forma_intermedio")
    private NFeFormaIntermedioEnum formaIntermedio;

    /**
     * CNPJ do adquirente ou do encomendante.
     * Informação obrigatória no caso de importação por conta e ordem ou por encomenda.
     */
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Sigla da UF do adquirente ou do encomendante.
     */
    @JsonProperty("uf_terceiro")
    private NFeUnidadeFederativaEnum ufTerceiro;

    /**
     * Código interno do exportador.
     */
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_exportador")
    private String codigoExportador;

    /**
     * Adições do documento de importação.
     */
    @Size(min = 1, max = 100)
    @JsonProperty("adicoes")
    private List<NFeAdicaoDocumentoImportacao> adicoes;

    public NFeDocumentoImportacao() {
        super();
    }

    private NFeDocumentoImportacao(Builder builder) {
        setNumero(builder.numero);
        setDataRegistro(builder.dataRegistro);
        setLocalDesembaracoAduaneiro(builder.localDesembaracoAduaneiro);
        setUfDesembaracoAduaneiro(builder.ufDesembaracoAduaneiro);
        setDataDesembaracoAduaneiro(builder.dataDesembaracoAduaneiro);
        setViaTransporte(builder.viaTransporte);
        setValorAfrmm(builder.valorAfrmm);
        setFormaIntermedio(builder.formaIntermedio);
        setCnpj(builder.cnpj);
        setUfTerceiro(builder.ufTerceiro);
        setCodigoExportador(builder.codigoExportador);
        setAdicoes(builder.adicoes);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Número do documento de importação DI/DSA/DA.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número do documento de importação DI/DSA/DA.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Data de registro do documento de importação.
     */
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    /**
     * Data de registro do documento de importação.
     */
    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     * Local do desembaraço aduaneiro.
     */
    public String getLocalDesembaracoAduaneiro() {
        return localDesembaracoAduaneiro;
    }

    /**
     * Local do desembaraço aduaneiro.
     */
    public void setLocalDesembaracoAduaneiro(String localDesembaracoAduaneiro) {
        this.localDesembaracoAduaneiro = localDesembaracoAduaneiro;
    }

    /**
     * UF do desembaraço aduaneiro.
     */
    public NFeUnidadeFederativaEnum getUfDesembaracoAduaneiro() {
        return ufDesembaracoAduaneiro;
    }

    /**
     * UF do desembaraço aduaneiro.
     */
    public void setUfDesembaracoAduaneiro(NFeUnidadeFederativaEnum ufDesembaracoAduaneiro) {
        this.ufDesembaracoAduaneiro = ufDesembaracoAduaneiro;
    }

    /**
     * Data do desembaraço aduaneiro.
     */
    public LocalDate getDataDesembaracoAduaneiro() {
        return dataDesembaracoAduaneiro;
    }

    /**
     * Data do desembaraço aduaneiro.
     */
    public void setDataDesembaracoAduaneiro(LocalDate dataDesembaracoAduaneiro) {
        this.dataDesembaracoAduaneiro = dataDesembaracoAduaneiro;
    }

    /**
     * Via de transporte internacional informada na DI.
     */
    public NFeViaTransporteEnum getViaTransporte() {
        return viaTransporte;
    }

    /**
     * Via de transporte internacional informada na DI.
     */
    public void setViaTransporte(NFeViaTransporteEnum viaTransporte) {
        this.viaTransporte = viaTransporte;
    }

    /**
     * Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo).
     */
    public BigDecimal getValorAfrmm() {
        return valorAfrmm;
    }

    /**
     * Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo).
     */
    public void setValorAfrmm(BigDecimal valorAfrmm) {
        this.valorAfrmm = valorAfrmm;
    }

    /**
     * Forma de importação quanto a intermediação.
     */
    public NFeFormaIntermedioEnum getFormaIntermedio() {
        return formaIntermedio;
    }

    /**
     * Forma de importação quanto a intermediação.
     */
    public void setFormaIntermedio(NFeFormaIntermedioEnum formaIntermedio) {
        this.formaIntermedio = formaIntermedio;
    }

    /**
     * CNPJ do adquirente ou do encomendante.
     * Informação obrigatória no caso de importação por conta e ordem ou por encomenda.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * CNPJ do adquirente ou do encomendante.
     * Informação obrigatória no caso de importação por conta e ordem ou por encomenda.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Sigla da UF do adquirente ou do encomendante.
     */
    public NFeUnidadeFederativaEnum getUfTerceiro() {
        return ufTerceiro;
    }

    /**
     * Sigla da UF do adquirente ou do encomendante.
     */
    public void setUfTerceiro(NFeUnidadeFederativaEnum ufTerceiro) {
        this.ufTerceiro = ufTerceiro;
    }

    /**
     * Código interno do exportador.
     */
    public String getCodigoExportador() {
        return codigoExportador;
    }

    /**
     * Código interno do exportador.
     */
    public void setCodigoExportador(String codigoExportador) {
        this.codigoExportador = codigoExportador;
    }

    /**
     * Adições do documento de importação.
     */
    public List<NFeAdicaoDocumentoImportacao> getAdicoes() {
        return adicoes;
    }

    /**
     * Adições do documento de importação.
     */
    public void setAdicoes(List<NFeAdicaoDocumentoImportacao> adicoes) {
        this.adicoes = adicoes;
    }

    /**
     * NFeDocumentoImportacao Builder Pattern.
     */
    public static final class Builder {

        private String numero;

        private LocalDate dataRegistro;

        private String localDesembaracoAduaneiro;

        private NFeUnidadeFederativaEnum ufDesembaracoAduaneiro;

        private LocalDate dataDesembaracoAduaneiro;

        private NFeViaTransporteEnum viaTransporte;

        private BigDecimal valorAfrmm;

        private NFeFormaIntermedioEnum formaIntermedio;

        private String cnpj;

        private NFeUnidadeFederativaEnum ufTerceiro;

        private String codigoExportador;

        private List<NFeAdicaoDocumentoImportacao> adicoes;

        private Builder() {
        }

        /**
         * Número do documento de importação DI/DSA/DA.
         */
        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        /**
         * Data de registro do documento de importação.
         */
        public Builder withDataRegistro(LocalDate val) {
            dataRegistro = val;
            return this;
        }

        /**
         * Local do desembaraço aduaneiro.
         */
        public Builder withLocalDesembaracoAduaneiro(String val) {
            localDesembaracoAduaneiro = val;
            return this;
        }

        /**
         * UF do desembaraço aduaneiro.
         */
        public Builder withUfDesembaracoAduaneiro(NFeUnidadeFederativaEnum val) {
            ufDesembaracoAduaneiro = val;
            return this;
        }

        /**
         * Data do desembaraço aduaneiro.
         */
        public Builder withDataDesembaracoAduaneiro(LocalDate val) {
            dataDesembaracoAduaneiro = val;
            return this;
        }

        /**
         * Via de transporte internacional informada na DI.
         */
        public Builder withViaTransporte(NFeViaTransporteEnum val) {
            viaTransporte = val;
            return this;
        }

        /**
         * Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo).
         */
        public Builder withValorAfrmm(BigDecimal val) {
            valorAfrmm = val;
            return this;
        }

        /**
         * Forma de importação quanto a intermediação.
         */
        public Builder withFormaIntermedio(NFeFormaIntermedioEnum val) {
            formaIntermedio = val;
            return this;
        }

        /**
         * CNPJ do adquirente ou do encomendante.
         * Informação obrigatória no caso de importação por conta e ordem ou por encomenda.
         */
        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        /**
         * Sigla da UF do adquirente ou do encomendante.
         */
        public Builder withUfTerceiro(NFeUnidadeFederativaEnum val) {
            ufTerceiro = val;
            return this;
        }

        /**
         * Código interno do exportador.
         */
        public Builder withCodigoExportador(String val) {
            codigoExportador = val;
            return this;
        }

        /**
         * Adições do documento de importação.
         */
        public Builder withAdicoes(List<NFeAdicaoDocumentoImportacao> val) {
            adicoes = val;
            return this;
        }

        public NFeDocumentoImportacao build() {
            return new NFeDocumentoImportacao(this);
        }
    }
}
