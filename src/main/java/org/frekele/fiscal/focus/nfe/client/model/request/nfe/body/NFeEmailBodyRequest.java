package org.frekele.fiscal.focus.nfe.client.model.request.nfe.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.frekele.fiscal.focus.nfe.client.core.FocusNFeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

/**
 * Request Body Enviar Email NF-e.
 *
 * @author frekele - Leandro Kersting de Freitas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NFeEmailBodyRequest implements FocusNFeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
     */
    @NotNull
    @Size(min = 1, max = 10)
    @JsonProperty("emails")
    private List<String> emails;

    public NFeEmailBodyRequest() {
        super();
    }

    public NFeEmailBodyRequest(List<String> emails) {
        this.emails = emails;
    }

    public NFeEmailBodyRequest(String... emails) {
        this.emails = Arrays.asList(emails);
    }

    private NFeEmailBodyRequest(Builder builder) {
        setEmails(builder.emails);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
     */
    public List<String> getEmails() {
        return emails;
    }

    /**
     * Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
     */
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    /**
     * NFeEmailBodyRequest Builder Pattern.
     */
    public static final class Builder {

        private List<String> emails;

        private Builder() {
        }

        /**
         * Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
         */
        public Builder withEmails(List<String> val) {
            emails = val;
            return this;
        }

        /**
         * Array com uma lista de emails que deverão receber uma cópia da nota. Limitado a 10 emails por vez.
         */
        public Builder withEmails(String... val) {
            emails = Arrays.asList(val);
            return this;
        }

        public NFeEmailBodyRequest build() {
            return new NFeEmailBodyRequest(this);
        }
    }
}
