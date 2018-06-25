package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeModeloEcfEnum;
import org.frekele.fiscal.focus.nfe.client.enumeration.NFeUnidadeFederativaEnum;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Nota fiscal referenciada. Informar exclusivamente 1 das seções: NFe (camo chave_nfe), nota modelo 1 ou cupom fiscal.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeNotaReferenciada implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Chave de acesso da nota referenciada.
     */
    @Size(max = 44)
    @JsonProperty("chave_nfe")
    private String chaveNfe;

    /**
     * UF do emitente (nota modelo 1).
     */
    @JsonProperty("uf")
    private NFeUnidadeFederativaEnum uf;

    /**
     * Ano e mês de emissão no formato AAMM (nota modelo 1).
     */
    @Size(max = 4)
    @JsonProperty("mes")
    private String mes;

    /**
     * CNPJ do emitente (nota modelo 1).
     */
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * Código do modelo (nota modelo 1). Utilizar 01 para modelo 1/1A ou 02 para modelo 2.
     */
    @Size(max = 2)
    @JsonProperty("modelo")
    private String modelo;

    /**
     * Série (nota modelo 1). Informar 0 se não existir.
     */
    @Size(min = 1, max = 3)
    @JsonProperty("serie")
    private String serie;

    /**
     * Número (nota modelo 1).
     */
    @Size(min = 1, max = 9)
    @JsonProperty("numero")
    private String numero;

    /**
     * UF do emitente (nota produtor rural).
     */
    @JsonProperty("uf_nf_produtor")
    private NFeUnidadeFederativaEnum ufNfProdutor;

    /**
     * Ano e mês de emissão no formato AAMM (nota produtor rural).
     */
    @Size(max = 4)
    @JsonProperty("mes_nf_produtor")
    private String mesNfProdutor;

    /**
     * CNPJ do emitente (nota produtor rural).
     */
    @Size(max = 14)
    @JsonProperty("cnpj_nf_produtor")
    private String cnpjNfProdutor;

    /**
     * CPF do emitente (nota produtor rural).
     */
    @Size(max = 11)
    @JsonProperty("cpf_nf_produtor")
    private String cpfNfProdutor;

    /**
     * Inscrição estadual do emitente (nota produtor rural).
     */
    @Size(min = 2, max = 14)
    @JsonProperty("inscricao_estadual_nf_produtor")
    private String inscricaoEstadualNfProdutor;

    /**
     * Código do modelo (nota produtor rural). Utilizar 04 para NF de produtor ou 01 para NF modelo 1.
     */
    @Size(max = 2)
    @JsonProperty("modelo_nf_produtor")
    private String modeloNfProdutor;

    /**
     * Série (nota produtor rural). Informar 0 se não existir.
     */
    @Size(min = 1, max = 3)
    @JsonProperty("serie_nf_produtor")
    private String serieNfProdutor;

    /**
     * Número (nota produtor rural).
     */
    @Size(min = 1, max = 9)
    @JsonProperty("numero_nf_produtor")
    private String numeroNfProdutor;

    /**
     * Chave de acesso da CTe referenciada.
     */
    @Size(max = 44)
    @JsonProperty("chave_cte")
    private String chaveCte;

    /**
     * Modelo do Documento Fiscal (cupom fiscal).
     */
    @JsonProperty("modelo_ecf")
    private NFeModeloEcfEnum modeloEcf;

    /**
     * Número de ordem sequencial do ECF (cupom fiscal).
     */
    @Size(max = 3)
    @JsonProperty("numero_ecf")
    private String numeroEcf;

    /**
     * Número do Contador de Ordem de Operação - COO (cupom fiscal).
     */
    @Size(max = 6)
    @JsonProperty("coo")
    private String coo;

    public NFeNotaReferenciada() {
        super();
    }

    private NFeNotaReferenciada(Builder builder) {
        setChaveNfe(builder.chaveNfe);
        setUf(builder.uf);
        setMes(builder.mes);
        setCnpj(builder.cnpj);
        setModelo(builder.modelo);
        setSerie(builder.serie);
        setNumero(builder.numero);
        setUfNfProdutor(builder.ufNfProdutor);
        setMesNfProdutor(builder.mesNfProdutor);
        setCnpjNfProdutor(builder.cnpjNfProdutor);
        setCpfNfProdutor(builder.cpfNfProdutor);
        setInscricaoEstadualNfProdutor(builder.inscricaoEstadualNfProdutor);
        setModeloNfProdutor(builder.modeloNfProdutor);
        setSerieNfProdutor(builder.serieNfProdutor);
        setNumeroNfProdutor(builder.numeroNfProdutor);
        setChaveCte(builder.chaveCte);
        setModeloEcf(builder.modeloEcf);
        setNumeroEcf(builder.numeroEcf);
        setCoo(builder.coo);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Chave de acesso da nota referenciada.
     */
    public String getChaveNfe() {
        return chaveNfe;
    }

    /**
     * Chave de acesso da nota referenciada.
     */
    public void setChaveNfe(String chaveNfe) {
        this.chaveNfe = chaveNfe;
    }

    /**
     * UF do emitente (nota modelo 1).
     */
    public NFeUnidadeFederativaEnum getUf() {
        return uf;
    }

    /**
     * UF do emitente (nota modelo 1).
     */
    public void setUf(NFeUnidadeFederativaEnum uf) {
        this.uf = uf;
    }

    /**
     * Ano e mês de emissão no formato AAMM (nota modelo 1).
     */
    public String getMes() {
        return mes;
    }

    /**
     * Ano e mês de emissão no formato AAMM (nota modelo 1).
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * CNPJ do emitente (nota modelo 1).
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * CNPJ do emitente (nota modelo 1).
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Código do modelo (nota modelo 1). Utilizar 01 para modelo 1/1A ou 02 para modelo 2.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Código do modelo (nota modelo 1). Utilizar 01 para modelo 1/1A ou 02 para modelo 2.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Série (nota modelo 1). Informar 0 se não existir.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Série (nota modelo 1). Informar 0 se não existir.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Número (nota modelo 1).
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número (nota modelo 1).
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * UF do emitente (nota produtor rural).
     */
    public NFeUnidadeFederativaEnum getUfNfProdutor() {
        return ufNfProdutor;
    }

    /**
     * UF do emitente (nota produtor rural).
     */
    public void setUfNfProdutor(NFeUnidadeFederativaEnum ufNfProdutor) {
        this.ufNfProdutor = ufNfProdutor;
    }

    /**
     * Ano e mês de emissão no formato AAMM (nota produtor rural).
     */
    public String getMesNfProdutor() {
        return mesNfProdutor;
    }

    /**
     * Ano e mês de emissão no formato AAMM (nota produtor rural).
     */
    public void setMesNfProdutor(String mesNfProdutor) {
        this.mesNfProdutor = mesNfProdutor;
    }

    /**
     * CNPJ do emitente (nota produtor rural).
     */
    public String getCnpjNfProdutor() {
        return cnpjNfProdutor;
    }

    /**
     * CNPJ do emitente (nota produtor rural).
     */
    public void setCnpjNfProdutor(String cnpjNfProdutor) {
        this.cnpjNfProdutor = cnpjNfProdutor;
    }

    /**
     * CPF do emitente (nota produtor rural).
     */
    public String getCpfNfProdutor() {
        return cpfNfProdutor;
    }

    /**
     * CPF do emitente (nota produtor rural).
     */
    public void setCpfNfProdutor(String cpfNfProdutor) {
        this.cpfNfProdutor = cpfNfProdutor;
    }

    /**
     * Inscrição estadual do emitente (nota produtor rural).
     */
    public String getInscricaoEstadualNfProdutor() {
        return inscricaoEstadualNfProdutor;
    }

    /**
     * Inscrição estadual do emitente (nota produtor rural).
     */
    public void setInscricaoEstadualNfProdutor(String inscricaoEstadualNfProdutor) {
        this.inscricaoEstadualNfProdutor = inscricaoEstadualNfProdutor;
    }

    /**
     * Código do modelo (nota produtor rural). Utilizar 04 para NF de produtor ou 01 para NF modelo 1.
     */
    public String getModeloNfProdutor() {
        return modeloNfProdutor;
    }

    /**
     * Código do modelo (nota produtor rural). Utilizar 04 para NF de produtor ou 01 para NF modelo 1.
     */
    public void setModeloNfProdutor(String modeloNfProdutor) {
        this.modeloNfProdutor = modeloNfProdutor;
    }

    /**
     * Série (nota produtor rural). Informar 0 se não existir.
     */
    public String getSerieNfProdutor() {
        return serieNfProdutor;
    }

    /**
     * Série (nota produtor rural). Informar 0 se não existir.
     */
    public void setSerieNfProdutor(String serieNfProdutor) {
        this.serieNfProdutor = serieNfProdutor;
    }

    /**
     * Número (nota produtor rural).
     */
    public String getNumeroNfProdutor() {
        return numeroNfProdutor;
    }

    /**
     * Número (nota produtor rural).
     */
    public void setNumeroNfProdutor(String numeroNfProdutor) {
        this.numeroNfProdutor = numeroNfProdutor;
    }

    /**
     * Chave de acesso da CTe referenciada.
     */
    public String getChaveCte() {
        return chaveCte;
    }

    /**
     * Chave de acesso da CTe referenciada.
     */
    public void setChaveCte(String chaveCte) {
        this.chaveCte = chaveCte;
    }

    /**
     * Modelo do Documento Fiscal (cupom fiscal).
     */
    public NFeModeloEcfEnum getModeloEcf() {
        return modeloEcf;
    }

    /**
     * Modelo do Documento Fiscal (cupom fiscal).
     */
    public void setModeloEcf(NFeModeloEcfEnum modeloEcf) {
        this.modeloEcf = modeloEcf;
    }

    /**
     * Número de ordem sequencial do ECF (cupom fiscal).
     */
    public String getNumeroEcf() {
        return numeroEcf;
    }

    /**
     * Número de ordem sequencial do ECF (cupom fiscal).
     */
    public void setNumeroEcf(String numeroEcf) {
        this.numeroEcf = numeroEcf;
    }

    /**
     * Número do Contador de Ordem de Operação - COO (cupom fiscal).
     */
    public String getCoo() {
        return coo;
    }

    /**
     * Número do Contador de Ordem de Operação - COO (cupom fiscal).
     */
    public void setCoo(String coo) {
        this.coo = coo;
    }

    /**
     * NFeNotaReferenciada Builder Pattern.
     */
    public static final class Builder {

        private String chaveNfe;

        private NFeUnidadeFederativaEnum uf;

        private String mes;

        private String cnpj;

        private String modelo;

        private String serie;

        private String numero;

        private NFeUnidadeFederativaEnum ufNfProdutor;

        private String mesNfProdutor;

        private String cnpjNfProdutor;

        private String cpfNfProdutor;

        private String inscricaoEstadualNfProdutor;

        private String modeloNfProdutor;

        private String serieNfProdutor;

        private String numeroNfProdutor;

        private String chaveCte;

        private NFeModeloEcfEnum modeloEcf;

        private String numeroEcf;

        private String coo;

        private Builder() {
        }

        /**
         * Chave de acesso da nota referenciada.
         */
        public Builder withChaveNfe(String val) {
            chaveNfe = val;
            return this;
        }

        /**
         * UF do emitente (nota modelo 1).
         */
        public Builder withUf(NFeUnidadeFederativaEnum val) {
            uf = val;
            return this;
        }

        /**
         * Ano e mês de emissão no formato AAMM (nota modelo 1).
         */
        public Builder withMes(String val) {
            mes = val;
            return this;
        }

        /**
         * CNPJ do emitente (nota modelo 1).
         */
        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        /**
         * Código do modelo (nota modelo 1). Utilizar 01 para modelo 1/1A ou 02 para modelo 2.
         */
        public Builder withModelo(String val) {
            modelo = val;
            return this;
        }

        /**
         * Série (nota modelo 1). Informar 0 se não existir.
         */
        public Builder withSerie(String val) {
            serie = val;
            return this;
        }

        /**
         * Número (nota modelo 1).
         */
        public Builder withNumero(String val) {
            numero = val;
            return this;
        }

        /**
         * UF do emitente (nota produtor rural).
         */
        public Builder withUfNfProdutor(NFeUnidadeFederativaEnum val) {
            ufNfProdutor = val;
            return this;
        }

        /**
         * Ano e mês de emissão no formato AAMM (nota produtor rural).
         */
        public Builder withMesNfProdutor(String val) {
            mesNfProdutor = val;
            return this;
        }

        /**
         * CNPJ do emitente (nota produtor rural).
         */
        public Builder withCnpjNfProdutor(String val) {
            cnpjNfProdutor = val;
            return this;
        }

        /**
         * CPF do emitente (nota produtor rural).
         */
        public Builder withCpfNfProdutor(String val) {
            cpfNfProdutor = val;
            return this;
        }

        /**
         * Inscrição estadual do emitente (nota produtor rural).
         */
        public Builder withInscricaoEstadualNfProdutor(String val) {
            inscricaoEstadualNfProdutor = val;
            return this;
        }

        /**
         * Código do modelo (nota produtor rural). Utilizar 04 para NF de produtor ou 01 para NF modelo 1.
         */
        public Builder withModeloNfProdutor(String val) {
            modeloNfProdutor = val;
            return this;
        }

        /**
         * Série (nota produtor rural). Informar 0 se não existir.
         */
        public Builder withSerieNfProdutor(String val) {
            serieNfProdutor = val;
            return this;
        }

        /**
         * Número (nota produtor rural).
         */
        public Builder withNumeroNfProdutor(String val) {
            numeroNfProdutor = val;
            return this;
        }

        /**
         * Chave de acesso da CTe referenciada.
         */
        public Builder withChaveCte(String val) {
            chaveCte = val;
            return this;
        }

        /**
         * Modelo do Documento Fiscal (cupom fiscal).
         */
        public Builder withModeloEcf(NFeModeloEcfEnum val) {
            modeloEcf = val;
            return this;
        }

        /**
         * Número de ordem sequencial do ECF (cupom fiscal).
         */
        public Builder withNumeroEcf(String val) {
            numeroEcf = val;
            return this;
        }

        /**
         * Número do Contador de Ordem de Operação - COO (cupom fiscal).
         */
        public Builder withCoo(String val) {
            coo = val;
            return this;
        }

        public NFeNotaReferenciada build() {
            return new NFeNotaReferenciada(this);
        }
    }
}
