package org.frekele.fiscal.focus.nfe.client.model.entities.protocolo.cartacorrecao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.converter.OffsetDateTimeJsonConverter;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.OffsetDateTime;

/**
 * Protocolo Carta Correção,  Inclui os dados completos do protocolo devolvido pela SEFAZ - 'protocolo_carta_correcao'.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeProtocoloCartaCorrecao implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonProperty("codigo_orgao")
    private String codigoOrgao;

    @JsonProperty("status")
    private String status;

    @JsonProperty("motivo")
    private String motivo;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    @JsonProperty("tipo_evento")
    private String tipoEvento;

    @JsonProperty("descricao_evento")
    private String descricaoEvento;

    //Formato padrão ISO, exemplo: “2016-12-25T12:00-0300”.
    @OffsetDateTimeJsonConverter
    @JsonProperty("data_evento")
    private OffsetDateTime dataEvento;

    @JsonProperty("numero_protocolo")
    private String numeroProtocolo;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("cpf")
    private String cpf;

    public NFeProtocoloCartaCorrecao() {
        super();
    }

    private NFeProtocoloCartaCorrecao(Builder builder) {
        setVersao(builder.versao);
        setAmbiente(builder.ambiente);
        setVersaoAplicativo(builder.versaoAplicativo);
        setCodigoOrgao(builder.codigoOrgao);
        setStatus(builder.status);
        setMotivo(builder.motivo);
        setChaveNfe(builder.chaveNfe);
        setTipoEvento(builder.tipoEvento);
        setDescricaoEvento(builder.descricaoEvento);
        setDataEvento(builder.dataEvento);
        setNumeroProtocolo(builder.numeroProtocolo);
        setCnpj(builder.cnpj);
        setCpf(builder.cpf);
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

    public String getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(String codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
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

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public OffsetDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(OffsetDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * NFeProtocoloCartaCorrecao Builder Pattern.
     */
    public static final class Builder {

        private String versao;

        private String ambiente;

        private String versaoAplicativo;

        private String codigoOrgao;

        private String status;

        private String motivo;

        private String chaveNfe;

        private String tipoEvento;

        private String descricaoEvento;

        private OffsetDateTime dataEvento;

        private String numeroProtocolo;

        private String cnpj;

        private String cpf;

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

        public Builder withCodigoOrgao(String val) {
            codigoOrgao = val;
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

        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        public Builder withTipoEvento(String val) {
            tipoEvento = val;
            return this;
        }

        public Builder withDescricaoEvento(String val) {
            descricaoEvento = val;
            return this;
        }

        public Builder withDataEvento(OffsetDateTime val) {
            dataEvento = val;
            return this;
        }

        public Builder withNumeroProtocolo(String val) {
            numeroProtocolo = val;
            return this;
        }

        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        public Builder withCpf(String val) {
            cpf = val;
            return this;
        }

        public NFeProtocoloCartaCorrecao build() {
            return new NFeProtocoloCartaCorrecao(this);
        }
    }
}
