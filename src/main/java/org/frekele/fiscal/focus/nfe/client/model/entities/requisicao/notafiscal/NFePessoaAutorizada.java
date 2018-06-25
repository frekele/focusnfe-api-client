package org.frekele.fiscal.focus.nfe.client.model.entities.requisicao.notafiscal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Pessoa autorizada a acessar o XML da NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFePessoaAutorizada implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * CNPJ autorizado.
     */
    @Size(max = 14)
    @JsonProperty("cnpj")
    private String cnpj;

    /**
     * CPF autorizado.
     */
    @Size(max = 11)
    @JsonProperty("cpf")
    private String cpf;

    public NFePessoaAutorizada() {
        super();
    }

    private NFePessoaAutorizada(Builder builder) {
        setCnpj(builder.cnpj);
        setCpf(builder.cpf);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * CNPJ autorizado.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * CNPJ autorizado.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * CPF autorizado.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * CPF autorizado.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * NFePessoaAutorizada Builder Pattern.
     */
    public static final class Builder {

        private String cnpj;

        private String cpf;

        private Builder() {
        }

        /**
         * CNPJ autorizado.
         */
        public Builder withCnpj(String val) {
            cnpj = val;
            return this;
        }

        /**
         * CPF autorizado.
         */
        public Builder withCpf(String val) {
            cpf = val;
            return this;
        }

        public NFePessoaAutorizada build() {
            return new NFePessoaAutorizada(this);
        }
    }
}
