package org.frekele.fiscal.focus.nfe.client.model.entities.backup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * NFe e NFCe Backups.
 * Mensalmente a API (primeira hora do primeiro dia de cada mês) gera um arquivo compactado em formato ZIP com todos os arquivos gerados de cada empresa.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeBackup implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Mês do backup no formato AAAAMM”, ex: “201701”.
     */
    @JsonProperty("mes")
    private String mes;

    /**
     * Caminho para baixar arquivo ZIP com as DANFEs geradas (NFe).
     */
    @JsonProperty("danfes")
    private String danfes;

    /**
     * Caminho para baixar arquivo ZIP com os XMLs gerados (NFe e NFCe).
     */
    @JsonProperty("xmls")
    private String xmls;

    public NFeBackup() {
        super();
    }

    private NFeBackup(Builder builder) {
        setMes(builder.mes);
        setDanfes(builder.danfes);
        setXmls(builder.xmls);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Mês do backup no formato AAAAMM”, ex: “201701”.
     */
    public String getMes() {
        return mes;
    }

    /**
     * Mês do backup no formato AAAAMM”, ex: “201701”.
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Caminho para baixar arquivo ZIP com as DANFEs geradas (NFe).
     */
    public String getDanfes() {
        return danfes;
    }

    /**
     * Caminho para baixar arquivo ZIP com as DANFEs geradas (NFe).
     */
    public void setDanfes(String danfes) {
        this.danfes = danfes;
    }

    /**
     * Caminho para baixar arquivo ZIP com os XMLs gerados (NFe e NFCe).
     */
    public String getXmls() {
        return xmls;
    }

    /**
     * Caminho para baixar arquivo ZIP com os XMLs gerados (NFe e NFCe).
     */
    public void setXmls(String xmls) {
        this.xmls = xmls;
    }

    /**
     * NFeBackup Builder Pattern.
     */
    public static final class Builder {

        private String mes;

        private String danfes;

        private String xmls;

        private Builder() {
        }

        /**
         * Mês do backup no formato AAAAMM”, ex: “201701”.
         */
        public Builder withMes(String val) {
            mes = val;
            return this;
        }

        /**
         * Caminho para baixar arquivo ZIP com as DANFEs geradas (NFe).
         */
        public Builder withDanfes(String val) {
            danfes = val;
            return this;
        }

        /**
         * Caminho para baixar arquivo ZIP com os XMLs gerados (NFe e NFCe).
         */
        public Builder withXmls(String val) {
            xmls = val;
            return this;
        }

        public NFeBackup build() {
            return new NFeBackup(this);
        }
    }
}
