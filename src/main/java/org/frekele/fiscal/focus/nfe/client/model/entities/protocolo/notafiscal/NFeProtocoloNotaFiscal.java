package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.OffsetDateTime;

/**
 * Protocolo Nota Fiscal, Inclui os dados completos do protocolo devolvido pela SEFAZ - 'protocolo_nota_fiscal'.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeProtocoloNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_recebimento")
    private OffsetDateTime dataRecebimento;

    @JsonProperty("numero_protocolo")
    private String numeroProtocolo;

    @JsonProperty("digest_value")
    private String digestValue;

    @JsonProperty("status")
    private String status;

    @JsonProperty("motivo")
    private String motivo;

    public NFeProtocoloNotaFiscal() {
        super();
    }

    private NFeProtocoloNotaFiscal(Builder builder) {
        setVersao(builder.versao);
        setAmbiente(builder.ambiente);
        setVersaoAplicativo(builder.versaoAplicativo);
        setChaveNfe(builder.chaveNfe);
        setDataRecebimento(builder.dataRecebimento);
        setNumeroProtocolo(builder.numeroProtocolo);
        setDigestValue(builder.digestValue);
        setStatus(builder.status);
        setMotivo(builder.motivo);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public OffsetDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(OffsetDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getDigestValue() {
        return digestValue;
    }

    public void setDigestValue(String digestValue) {
        this.digestValue = digestValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public static final class Builder {

        private String versao;

        private String ambiente;

        private String versaoAplicativo;

        private String chaveNfe;

        private OffsetDateTime dataRecebimento;

        private String numeroProtocolo;

        private String digestValue;

        private String status;

        private String motivo;

        private Builder() {
        }

        public Builder withVersao(String val) {
            versao = val;
            return this;
        }

        public Builder withAmbiente(String val) {
            ambiente = val;
            return this;
        }

        public Builder withVersaoAplicativo(String val) {
            versaoAplicativo = val;
            return this;
        }

        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        public Builder withDataRecebimento(OffsetDateTime val) {
            dataRecebimento = val;
            return this;
        }

        public Builder withNumeroProtocolo(String val) {
            numeroProtocolo = val;
            return this;
        }

        public Builder withDigestValue(String val) {
            digestValue = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public Builder withMotivo(String val) {
            motivo = val;
            return this;
        }

        public NFeProtocoloNotaFiscal build() {
            return new NFeProtocoloNotaFiscal(this);
        }
    }
}
