package org.frekele.fiscal.focus.nfe.client.model.entities.manifesto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.OffsetDateTime;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MDeManifesto implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("nome_emitente")
    private String nomeEmitente;

    @JsonProperty("documento_emitente")
    private String documentoEmitente;

    @JsonProperty("cnpj_destinatario")
    private String cnpjDestinatario;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    @JsonProperty("valor_total")
    private String valorTotal;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_emissao")
    private OffsetDateTime dataEmissao;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("manifestacao_destinatario")
    private String manifestacaoDestinatario;

    @JsonProperty("nfe_completa")
    private Boolean nfeCompleta;

    @JsonProperty("tipo_nfe")
    private String tipoNfe;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("digest_value")
    private String digestValue;

    @JsonProperty("numero_carta_correcao")
    private String numeroCartaCorrecao;

    @JsonProperty("carta_correcao")
    private String cartaCorrecao;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_carta_correcao")
    private OffsetDateTime dataCartaCorrecao;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_cancelamento")
    private OffsetDateTime dataCancelamento;

    @JsonProperty("justificativa_cancelamento")
    private String justificativaCancelamento;

    public MDeManifesto() {
        super();
    }

    private MDeManifesto(Builder builder) {
        setNomeEmitente(builder.nomeEmitente);
        setDocumentoEmitente(builder.documentoEmitente);
        setCnpjDestinatario(builder.cnpjDestinatario);
        setChaveNfe(builder.chaveNfe);
        setValorTotal(builder.valorTotal);
        setDataEmissao(builder.dataEmissao);
        setSituacao(builder.situacao);
        setManifestacaoDestinatario(builder.manifestacaoDestinatario);
        setNfeCompleta(builder.nfeCompleta);
        setTipoNfe(builder.tipoNfe);
        setVersao(builder.versao);
        setDigestValue(builder.digestValue);
        setNumeroCartaCorrecao(builder.numeroCartaCorrecao);
        setCartaCorrecao(builder.cartaCorrecao);
        setDataCartaCorrecao(builder.dataCartaCorrecao);
        setDataCancelamento(builder.dataCancelamento);
        setJustificativaCancelamento(builder.justificativaCancelamento);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNomeEmitente() {
        return nomeEmitente;
    }

    public void setNomeEmitente(String nomeEmitente) {
        this.nomeEmitente = nomeEmitente;
    }

    public String getDocumentoEmitente() {
        return documentoEmitente;
    }

    public void setDocumentoEmitente(String documentoEmitente) {
        this.documentoEmitente = documentoEmitente;
    }

    public String getCnpjDestinatario() {
        return cnpjDestinatario;
    }

    public void setCnpjDestinatario(String cnpjDestinatario) {
        this.cnpjDestinatario = cnpjDestinatario;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public OffsetDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(OffsetDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getManifestacaoDestinatario() {
        return manifestacaoDestinatario;
    }

    public void setManifestacaoDestinatario(String manifestacaoDestinatario) {
        this.manifestacaoDestinatario = manifestacaoDestinatario;
    }

    public Boolean getNfeCompleta() {
        return nfeCompleta;
    }

    public void setNfeCompleta(Boolean nfeCompleta) {
        this.nfeCompleta = nfeCompleta;
    }

    public String getTipoNfe() {
        return tipoNfe;
    }

    public void setTipoNfe(String tipoNfe) {
        this.tipoNfe = tipoNfe;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDigestValue() {
        return digestValue;
    }

    public void setDigestValue(String digestValue) {
        this.digestValue = digestValue;
    }

    public String getNumeroCartaCorrecao() {
        return numeroCartaCorrecao;
    }

    public void setNumeroCartaCorrecao(String numeroCartaCorrecao) {
        this.numeroCartaCorrecao = numeroCartaCorrecao;
    }

    public String getCartaCorrecao() {
        return cartaCorrecao;
    }

    public void setCartaCorrecao(String cartaCorrecao) {
        this.cartaCorrecao = cartaCorrecao;
    }

    public OffsetDateTime getDataCartaCorrecao() {
        return dataCartaCorrecao;
    }

    public void setDataCartaCorrecao(OffsetDateTime dataCartaCorrecao) {
        this.dataCartaCorrecao = dataCartaCorrecao;
    }

    public OffsetDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(OffsetDateTime dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public String getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public void setJustificativaCancelamento(String justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
    }

    public static final class Builder {

        private String nomeEmitente;

        private String documentoEmitente;

        private String cnpjDestinatario;

        private String chaveNfe;

        private String valorTotal;

        private OffsetDateTime dataEmissao;

        private String situacao;

        private String manifestacaoDestinatario;

        private Boolean nfeCompleta;

        private String tipoNfe;

        private String versao;

        private String digestValue;

        private String numeroCartaCorrecao;

        private String cartaCorrecao;

        private OffsetDateTime dataCartaCorrecao;

        private OffsetDateTime dataCancelamento;

        private String justificativaCancelamento;

        private Builder() {
        }

        public Builder withNomeEmitente(String val) {
            nomeEmitente = val;
            return this;
        }

        public Builder withDocumentoEmitente(String val) {
            documentoEmitente = val;
            return this;
        }

        public Builder withCnpjDestinatario(String val) {
            cnpjDestinatario = val;
            return this;
        }

        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        public Builder withValorTotal(String val) {
            valorTotal = val;
            return this;
        }

        public Builder withDataEmissao(OffsetDateTime val) {
            dataEmissao = val;
            return this;
        }

        public Builder withSituacao(String val) {
            situacao = val;
            return this;
        }

        public Builder withManifestacaoDestinatario(String val) {
            manifestacaoDestinatario = val;
            return this;
        }

        public Builder withNfeCompleta(Boolean val) {
            nfeCompleta = val;
            return this;
        }

        public Builder withTipoNfe(String val) {
            tipoNfe = val;
            return this;
        }

        public Builder withVersao(String val) {
            versao = val;
            return this;
        }

        public Builder withDigestValue(String val) {
            digestValue = val;
            return this;
        }

        public Builder withNumeroCartaCorrecao(String val) {
            numeroCartaCorrecao = val;
            return this;
        }

        public Builder withCartaCorrecao(String val) {
            cartaCorrecao = val;
            return this;
        }

        public Builder withDataCartaCorrecao(OffsetDateTime val) {
            dataCartaCorrecao = val;
            return this;
        }

        public Builder withDataCancelamento(OffsetDateTime val) {
            dataCancelamento = val;
            return this;
        }

        public Builder withJustificativaCancelamento(String val) {
            justificativaCancelamento = val;
            return this;
        }

        public MDeManifesto build() {
            return new MDeManifesto(this);
        }
    }
}
