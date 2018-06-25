package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * * Retorna da Requisicao Nota Fiscal na Consulta, Inclui os dados completos do protocolo devolvido pela SEFAZ - 'protocolo_nota_fiscal'.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeRetornoRequisicaoNotaFiscal implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("versao")
    private String versao;

    @JsonProperty("chave_nfe")
    private String chaveNfe;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("codigo_unico")
    private String codigoUnico;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("formato_impressao")
    private String formatoImpressao;

    @JsonProperty("forma_emissao")
    private String formaEmissao;

    @JsonProperty("digito_verificador")
    private String digitoVerificador;

    @JsonProperty("ambiente")
    private String ambiente;

    @JsonProperty("processo_emissao")
    private String processoEmissao;

    @JsonProperty("versao_aplicativo")
    private String versaoAplicativo;

    @JsonUnwrapped
    private NFeEnvioRequisicaoNotaFiscal nfe;

    public NFeRetornoRequisicaoNotaFiscal() {
        super();
    }

    private NFeRetornoRequisicaoNotaFiscal(Builder builder) {
        setVersao(builder.versao);
        setChaveNfe(builder.chaveNfe);
        setUf(builder.uf);
        setCodigoUnico(builder.codigoUnico);
        setModelo(builder.modelo);
        setMunicipio(builder.municipio);
        setFormatoImpressao(builder.formatoImpressao);
        setFormaEmissao(builder.formaEmissao);
        setDigitoVerificador(builder.digitoVerificador);
        setAmbiente(builder.ambiente);
        setProcessoEmissao(builder.processoEmissao);
        setVersaoAplicativo(builder.versaoAplicativo);
        setNfe(builder.nfe);
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

    public String getChaveNfe() {
        return chaveNfe;
    }

    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFormatoImpressao() {
        return formatoImpressao;
    }

    public void setFormatoImpressao(String formatoImpressao) {
        this.formatoImpressao = formatoImpressao;
    }

    public String getFormaEmissao() {
        return formaEmissao;
    }

    public void setFormaEmissao(String formaEmissao) {
        this.formaEmissao = formaEmissao;
    }

    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getProcessoEmissao() {
        return processoEmissao;
    }

    public void setProcessoEmissao(String processoEmissao) {
        this.processoEmissao = processoEmissao;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public NFeEnvioRequisicaoNotaFiscal getNfe() {
        return nfe;
    }

    public void setNfe(NFeEnvioRequisicaoNotaFiscal nfe) {
        this.nfe = nfe;
    }

    public static final class Builder {

        private String versao;

        private String chaveNfe;

        private String uf;

        private String codigoUnico;

        private String modelo;

        private String municipio;

        private String formatoImpressao;

        private String formaEmissao;

        private String digitoVerificador;

        private String ambiente;

        private String processoEmissao;

        private String versaoAplicativo;

        private NFeEnvioRequisicaoNotaFiscal nfe;

        private Builder() {
        }

        public Builder withVersao(String val) {
            versao = val;
            return this;
        }

        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        public Builder withUf(String val) {
            uf = val;
            return this;
        }

        public Builder withCodigoUnico(String val) {
            codigoUnico = val;
            return this;
        }

        public Builder withModelo(String val) {
            modelo = val;
            return this;
        }

        public Builder withMunicipio(String val) {
            municipio = val;
            return this;
        }

        public Builder withFormatoImpressao(String val) {
            formatoImpressao = val;
            return this;
        }

        public Builder withFormaEmissao(String val) {
            formaEmissao = val;
            return this;
        }

        public Builder withDigitoVerificador(String val) {
            digitoVerificador = val;
            return this;
        }

        public Builder withAmbiente(String val) {
            ambiente = val;
            return this;
        }

        public Builder withProcessoEmissao(String val) {
            processoEmissao = val;
            return this;
        }

        public Builder withVersaoAplicativo(String val) {
            versaoAplicativo = val;
            return this;
        }

        public Builder withNfe(NFeEnvioRequisicaoNotaFiscal val) {
            nfe = val;
            return this;
        }

        public NFeRetornoRequisicaoNotaFiscal build() {
            return new NFeRetornoRequisicaoNotaFiscal(this);
        }
    }
}
