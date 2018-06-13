package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao;

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

    //Número do documento de importação DI/DSA/DA.
    @Size(min = 1, max = 12)
    @JsonProperty("numero")
    private String numero;

    //Data de registro do documento de importação.
    @LocalDateJsonConverter
    @JsonProperty("data_registro")
    private LocalDate dataRegistro;

    //Local do desembaraço aduaneiro.
    @Size(min = 1, max = 60)
    @JsonProperty("local_desembaraco_aduaneiro")
    private String localDesembaracoAduaneiro;

    //UF do desembaraço aduaneiro.
    @JsonProperty("uf_desembaraco_aduaneiro")
    private NFeUnidadeFederativaEnum ufDesembaracoAduaneiro;

    //Data do desembaraço aduaneiro.
    @LocalDateJsonConverter
    @JsonProperty("data_desembaraco_aduaneiro")
    private LocalDate dataDesembaracoAduaneiro;

    //Via de transporte internacional informada na DI
    @JsonProperty("via_transporte")
    private NFeViaTransporteEnum viaTransporte;

    //Valor da AFRMM - Adicional ao Frete para Renovação da Marinha Mercante (obrigatório se marítimo)
    @Digits(integer = 13, fraction = 2)
    @BigDecimalJsonConverter
    @JsonProperty("valor_afrmm")
    private BigDecimal valorAfrmm;

    //Forma de importação quanto a intermediação
    @JsonProperty("forma_intermedio")
    private NFeFormaIntermedioEnum formaIntermedio;

    //CNPJ do adquirente ou do encomendante.
    //Informação obrigatória no caso de importação por conta e ordem ou por encomenda
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    //Sigla da UF do adquirente ou do encomendante.
    @JsonProperty("uf_terceiro")
    private NFeUnidadeFederativaEnum ufTerceiro;

    //Código interno do exportador.
    @Size(min = 1, max = 60)
    @JsonProperty("codigo_exportador")
    private String codigoExportador;

    //Adições do documento de importação.
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getLocalDesembaracoAduaneiro() {
        return localDesembaracoAduaneiro;
    }

    public void setLocalDesembaracoAduaneiro(String localDesembaracoAduaneiro) {
        this.localDesembaracoAduaneiro = localDesembaracoAduaneiro;
    }

    public NFeUnidadeFederativaEnum getUfDesembaracoAduaneiro() {
        return ufDesembaracoAduaneiro;
    }

    public void setUfDesembaracoAduaneiro(NFeUnidadeFederativaEnum ufDesembaracoAduaneiro) {
        this.ufDesembaracoAduaneiro = ufDesembaracoAduaneiro;
    }

    public LocalDate getDataDesembaracoAduaneiro() {
        return dataDesembaracoAduaneiro;
    }

    public void setDataDesembaracoAduaneiro(LocalDate dataDesembaracoAduaneiro) {
        this.dataDesembaracoAduaneiro = dataDesembaracoAduaneiro;
    }

    public NFeViaTransporteEnum getViaTransporte() {
        return viaTransporte;
    }

    public void setViaTransporte(NFeViaTransporteEnum viaTransporte) {
        this.viaTransporte = viaTransporte;
    }

    public BigDecimal getValorAfrmm() {
        return valorAfrmm;
    }

    public void setValorAfrmm(BigDecimal valorAfrmm) {
        this.valorAfrmm = valorAfrmm;
    }

    public NFeFormaIntermedioEnum getFormaIntermedio() {
        return formaIntermedio;
    }

    public void setFormaIntermedio(NFeFormaIntermedioEnum formaIntermedio) {
        this.formaIntermedio = formaIntermedio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public NFeUnidadeFederativaEnum getUfTerceiro() {
        return ufTerceiro;
    }

    public void setUfTerceiro(NFeUnidadeFederativaEnum ufTerceiro) {
        this.ufTerceiro = ufTerceiro;
    }

    public String getCodigoExportador() {
        return codigoExportador;
    }

    public void setCodigoExportador(String codigoExportador) {
        this.codigoExportador = codigoExportador;
    }

    public List<NFeAdicaoDocumentoImportacao> getAdicoes() {
        return adicoes;
    }

    public void setAdicoes(List<NFeAdicaoDocumentoImportacao> adicoes) {
        this.adicoes = adicoes;
    }

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

        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        public Builder withDataRegistro(LocalDate val) {
            dataRegistro = val;
            return this;
        }

        public Builder withLocalDesembaracoAduaneiro(String val) {
            localDesembaracoAduaneiro = val;
            return this;
        }

        public Builder withUfDesembaracoAduaneiro(NFeUnidadeFederativaEnum val) {
            ufDesembaracoAduaneiro = val;
            return this;
        }

        public Builder withDataDesembaracoAduaneiro(LocalDate val) {
            dataDesembaracoAduaneiro = val;
            return this;
        }

        public Builder withViaTransporte(NFeViaTransporteEnum val) {
            viaTransporte = val;
            return this;
        }

        public Builder withValorAfrmm(BigDecimal val) {
            valorAfrmm = val;
            return this;
        }

        public Builder withFormaIntermedio(NFeFormaIntermedioEnum val) {
            formaIntermedio = val;
            return this;
        }

        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        public Builder withUfTerceiro(NFeUnidadeFederativaEnum val) {
            ufTerceiro = val;
            return this;
        }

        public Builder withCodigoExportador(String val) {
            codigoExportador = val;
            return this;
        }

        public Builder withAdicoes(List<NFeAdicaoDocumentoImportacao> val) {
            adicoes = val;
            return this;
        }

        public NFeDocumentoImportacao build() {
            return new NFeDocumentoImportacao(this);
        }
    }
}
